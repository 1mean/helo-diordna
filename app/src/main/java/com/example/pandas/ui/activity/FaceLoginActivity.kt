package com.example.pandas.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.ActivityFaceLoginBinding
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.view.dialog.FaceAddSheetDialog
import com.example.pandas.utils.BitmapUtils
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.core.MatOfRect
import org.opencv.core.Scalar
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc
import org.opencv.imgproc.Imgproc.COLOR_BGRA2GRAY
import org.opencv.objdetect.CascadeClassifier
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.math.roundToInt


/**
 * @description: FaceLoginActivity
 * @author: dongyiming
 * @date: 11/4/22 9:35 AM
 * @version: v1.0
 */
public class FaceLoginActivity : BaseActivity<BaseViewModel, ActivityFaceLoginBinding>() {

    private var tempCameraPicName: String = ""
    private var frontFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var initSuccess = false

    private var mDialog: FaceAddSheetDialog? = null
    private var mAbsoluteFaceSize = 0
    private var loadingPopup: LoadingPopupView? = null

    private val mHandler = Handler(Looper.getMainLooper())

    private val albumLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.let { intent ->
                    intent.data?.let { uri ->
                        if (loadingPopup == null) {
                            loadingPopup =
                                XPopup.Builder(this@FaceLoginActivity).dismissOnBackPressed(true)
                                    .isLightNavigationBar(true)
                                    .isViewMode(false)
                                    .asLoading(null, R.layout.layout_waiting)
                            loadingPopup!!.show()
                        } else {
                            loadingPopup!!.show()
                        }
                        trackPicture(uri)
                    }
                }
            }
        }

    private val takePictureLauncher =
        //TakePicturePreview()返回bitmap预览图，是缩略图，比较模糊
        registerForActivityResult(ActivityResultContracts.TakePicture()) { result ->
            if (result) {
                if (loadingPopup == null) {
                    loadingPopup =
                        XPopup.Builder(this@FaceLoginActivity).dismissOnBackPressed(true)
                            .isLightNavigationBar(true)
                            .isViewMode(false)
                            .asLoading(null, R.layout.layout_waiting)
                    loadingPopup!!.show()
                } else {
                    loadingPopup!!.show()
                }
                trackFace()
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.white)

        //这两还少不了
        initLoadOpenCV()
        initFrontFace()

        binding.ibnFaceLoginBack.setOnClickListener {
            finish()
        }

        binding.btnFaceLoginUpload.setOnClickListener {

            if (mDialog == null) {
                mDialog = FaceAddSheetDialog(this, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        if (!initSuccess) {
                            shortToast(this@FaceLoginActivity, "初始化失败，无法操作！！")
                            return
                        }
                        if (t == 1) {
                            val faceDir =
                                FileUtils.getExternalFilePath(this@FaceLoginActivity, "face")
                            if (faceDir.isEmpty()) {
                                return
                            }
                            val facePic =
                                File(faceDir, System.currentTimeMillis().toString() + ".jpg")
                            tempCameraPicName = facePic.absolutePath
                            val uri = FileProvider.getUriForFile(
                                this@FaceLoginActivity,
                                "$packageName.fileprovider",
                                facePic
                            )
                            takePictureLauncher.launch(uri)
                        } else {
                            val intent = Intent(
                                Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                            );
                            //参数一:对应的数据的URI 参数二:使用该函数表示要查找文件的MIME类型
                            intent.setDataAndType(
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                "image/*"
                            );
                            albumLauncher.launch(intent)
                        }
                    }
                })
            }
            mDialog!!.onShow()
        }

        binding.txtFaceLoginFinish.setOnClickListener {

            val name = binding.editFaceLoginName.text?.trim().toString()
            val phone = binding.editFaceLoginPhone.text?.trim().toString()
            if (name.isEmpty() || phone.isEmpty()) {
                shortToast(this, "数据不能为空")
                return@setOnClickListener
            }
            if (phone.length < 11) {
                shortToast(this, "请填写正确的手机号码")
                return@setOnClickListener
            }
            finish()
        }
    }

    /**
     * OpeenCV包的初始化
     */
    private fun initLoadOpenCV() {

        initSuccess = OpenCVLoader.initDebug()
        if (initSuccess) {
            shortToast(applicationContext, "Loading OpenCV Libraries...")
        } else {
            shortToast(applicationContext, "WARNING: Could not load openCV Libraries")
        }
    }

    /**
     * 初始化正脸分类器
     */
    private fun initFrontFace() {
        try {
            //读取存放在raw的文件
            val `is` = resources.openRawResource(R.raw.haarcascade_frontalface_alt)
            val cascadeDir = getDir("cascade", MODE_PRIVATE)
            val cascadeFile = File(cascadeDir, "haarcascade_frontalface_alt.xml")
            val os = FileOutputStream(cascadeFile)
            val buffer = ByteArray(4096)
            var bytesRead: Int
            while (`is`.read(buffer).also { bytesRead = it } != -1) {
                os.write(buffer, 0, bytesRead)
            }
            `is`.close()
            os.close()
            //通过classifier来操作人脸检测， 在外部定义一个CascadeClassifier classifier
            frontFaceClassifier = CascadeClassifier(cascadeFile.absolutePath)
            cascadeFile.delete()
            cascadeDir.delete()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun createObserver() {

    }

    /**
     * 原始图片5M-->直接压缩存储，哪怕quality=10，也有近200kb-->需要先压缩一下，然后再压缩保存，大小40-60kb
     * @param:
     * @author: dongyiming
     * @date: 11/9/22 3:45 AM
     * @version: v1.0
     */
    private fun trackFace() {
        thread {

            val compressedBitmap = BitmapUtils.compressBitmap(tempCameraPicName, 400, 400)
            compressedBitmap?.let {
                //1,二次压缩存储
                BitmapUtils.saveCompressedBitmap(
                    it,
                    Bitmap.CompressFormat.WEBP_LOSSY,
                    tempCameraPicName
                )
                val finalBitmap = BitmapFactory.decodeFile(tempCameraPicName) ?: return@thread

                //2,图片处理，获取图片的mat对象，为画框作准备
                val matCanvas = Mat()//目标图，用于在上面画框
                val matGray = Mat()//单通道的灰度图，用于人脸识别来获取人脸坐标,提高识别速度
                Utils.bitmapToMat(finalBitmap, matCanvas)
                Imgproc.cvtColor(matCanvas, matGray, COLOR_BGRA2GRAY)

                //3,人脸识别，得到人脸坐标
                val mRelativeFaceSize = 0.2f
                if (mAbsoluteFaceSize == 0) {
                    val height = matGray.rows()
                    if ((height * mRelativeFaceSize).roundToInt() > 0) {
                        mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
                    }
                    //mNativeDetector.setMinFaceSize(mAbsoluteFaceSize)
                }
                val faces = MatOfRect() //人脸坐标
                frontFaceClassifier!!.detectMultiScale(
                    matGray,
                    faces,
                    1.1,
                    1,//只检测单个人脸，如果检测多个人脸，可以挑选人脸框最大的那一个
                    2,
                    Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble()),
                    Size()
                )

                //4，开始画框，截取框内人脸
                val faceList = faces.toList()
                if (faceList.size > 0) {
                    val rect = faceList[0]
                    Imgproc.rectangle(//画框
                        matCanvas,
                        rect.tl(),//tl:左上角坐标，br右下角坐标
                        rect.br(), //#F7CA2F
                        Scalar(255.0, 255.0, 0.0, 255.0),
                        4,
                        8,
                        0
                    )

                    //5，将画框的图片保存在本地，画框后的bitmap大小从46kb-->400kb,需要再次压缩
                    val faceBitmap =
                        Bitmap.createBitmap(
                            finalBitmap.width,
                            finalBitmap.height,
                            Bitmap.Config.ARGB_8888
                        )
                    Utils.matToBitmap(matCanvas, faceBitmap)

                    val faceDir =
                        FileUtils.getExternalFilePath(this@FaceLoginActivity, "face")
                    val facePic =
                        File(faceDir, System.currentTimeMillis().toString() + ".jpg")

                    //画框后的bitmap又变大了，需要再次压缩并保存在本地
                    BitmapUtils.saveWebpBitmap(faceBitmap, facePic.absolutePath)

                    mHandler.post {
                        loadingPopup?.dismiss()
                        loadCircleBitmap(this, faceBitmap, binding.imgFaceLogin)
                    }
                } else {//未检测到人脸，删除本地图片，并提示
                    FileUtils.deleteFile(tempCameraPicName)
                    mHandler.post {
                        loadingPopup?.dismiss()
                        shortToast(this, "未检测到人脸，请重新上传")
                    }
                }
                matCanvas.release()
                matGray.release()
                // Imgproc.compareHist()
            }
        }

//            val cropBitmap =
//                cropBitmap(dstBitmap, intArrayOf(rect.x, rect.y, rect.width, rect.height))
//
//            Log.e("1mean", "${rect.width}")
//            val newBitmap =
//                Bitmap.createBitmap(dstBitmap, rect.x, rect.y, rect.width, rect.height)
//
//            val newMat = Mat()
//            Utils.bitmapToMat(newBitmap, newMat)
//            Log.e("1mean", "newMat: $newMat")
//
//
//            //比对两个人脸 两个mat必须有相同的size，不然报错 616x820 302x302
//            Log.e("1mean", "size1:${matDst.size()}, size2:${newMat.size()}")
//            //val similar = Imgproc.compareHist(matDst, newMat, Imgproc.HISTCMP_CHISQR)
//            //Log.e("1mean", "相似度： $similar")

    }

    private fun trackPicture(uri: Uri) {
        thread {
            FileUtils.getRealPathFromUri(this, uri)?.let { path ->
                val compressedBitmap = BitmapUtils.compressBitmap(path, 400, 400)
                compressedBitmap?.let {
                    val faceDir =
                        FileUtils.getExternalFilePath(this@FaceLoginActivity, "face")
                    val facePath =
                        File(faceDir, System.currentTimeMillis().toString() + ".jpg").absolutePath

                    //1,二次压缩存储
                    BitmapUtils.saveCompressedBitmap(
                        it,
                        Bitmap.CompressFormat.WEBP_LOSSY,
                        facePath
                    )
                    val finalBitmap = BitmapFactory.decodeFile(facePath) ?: return@thread

                    //2,图片处理，获取图片的mat对象，为画框作准备
                    val matCanvas = Mat()//目标图，用于在上面画框
                    val matGray = Mat()//单通道的灰度图，用于人脸识别来获取人脸坐标,提高识别速度
                    Utils.bitmapToMat(finalBitmap, matCanvas)
                    Imgproc.cvtColor(matCanvas, matGray, COLOR_BGRA2GRAY)

                    //3,人脸识别，得到人脸坐标
                    val mRelativeFaceSize = 0.2f
                    if (mAbsoluteFaceSize == 0) {
                        val height = matGray.rows()
                        if ((height * mRelativeFaceSize).roundToInt() > 0) {
                            mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
                        }
                        //mNativeDetector.setMinFaceSize(mAbsoluteFaceSize)
                    }
                    val faces = MatOfRect() //人脸坐标
                    frontFaceClassifier!!.detectMultiScale(
                        matGray,
                        faces,
                        1.1,
                        3,//只检测单个人脸，如果检测多个人脸，可以挑选人脸框最大的那一个
                        2,
                        Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble()),
                        Size()
                    )

                    //4，开始画框，截取框内人脸
                    val faceList = faces.toList()
                    if (faceList.size > 0) {
                        val rect = faceList[0]
                        Imgproc.rectangle(//画框
                            matCanvas,
                            rect.tl(),//tl:左上角坐标，br右下角坐标
                            rect.br(), //#F7CA2F
                            Scalar(255.0, 255.0, 0.0, 255.0),
                            4,
                            8,
                            0
                        )

                        //5，将画框的图片保存在本地，画框后的bitmap大小从46kb-->400kb,需要再次压缩
                        val faceBitmap =
                            Bitmap.createBitmap(
                                finalBitmap.width,
                                finalBitmap.height,
                                Bitmap.Config.ARGB_8888
                            )
                        Utils.matToBitmap(matCanvas, faceBitmap)


                        //画框后的bitmap又变大了，需要再次压缩并保存在本地
                        BitmapUtils.saveWebpBitmap(faceBitmap, facePath)

                        mHandler.post {
                            loadingPopup?.dismiss()
                            loadCircleBitmap(this, faceBitmap, binding.imgFaceLogin)
                        }
                    } else {//未检测到人脸，删除本地图片，并提示
                        FileUtils.deleteFile(facePath)
                        mHandler.post {
                            loadingPopup?.dismiss()
                            shortToast(this, "未检测到人脸，请重新上传")
                        }
                    }
                    matCanvas.release()
                    matGray.release()
                }

            }
        }
    }
}