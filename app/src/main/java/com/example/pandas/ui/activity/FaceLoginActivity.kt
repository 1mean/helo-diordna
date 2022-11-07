package com.example.pandas.ui.activity

import android.content.Intent
import android.content.Intent.ACTION_OPEN_DOCUMENT
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.*
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.databinding.ActivityFaceLoginBinding
import com.example.pandas.ui.ext.shortToast
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
import kotlin.math.roundToInt


/**
 * @description: FaceLoginActivity
 * @author: dongyiming
 * @date: 11/4/22 9:35 AM
 * @version: v1.0
 */
public class FaceLoginActivity : BaseActivity<BaseViewModel, ActivityFaceLoginBinding>() {

    private var tempFileName: String = ""
    private var frontFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var initSuccess = false

    private var mAbsoluteFaceSize = 0
    private var loadingPopup: LoadingPopupView? = null

    private val mHandler = Handler(Looper.getMainLooper())

    private val albumLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == RESULT_OK) {
                it.data?.let { intent ->
                    intent.data?.let { uri ->

                        val path = FileUtils.getRealPathFromUri(this,uri)
                        Log.e("1mean","path: $path")
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

        binding.btnFaceLoginCapture.setOnClickListener {

            if (!initSuccess) {
                shortToast(this, "初始化失败，无法操作！！")
                return@setOnClickListener
            }
            val faceDir = FileUtils.getExternalFilePath(this, "face")
            if (faceDir.isEmpty()) {
                return@setOnClickListener
            }
            val facePic = File(faceDir, System.currentTimeMillis().toString() + ".jpg")
            tempFileName = facePic.absolutePath
            val uri = FileProvider.getUriForFile(
                this,
                "$packageName.fileprovider",
                facePic
            )
            takePictureLauncher.launch(uri)
        }

        binding.btnFaceLoginLocal.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //参数一:对应的数据的URI 参数二:使用该函数表示要查找文件的MIME类型
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            albumLauncher.launch(intent)
        }
        //这两还少不了
        initLoadOpenCV()
        initFrontFace()

        binding.ibnFaceLoginBack.setOnClickListener {
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
            Log.e("1mean", "cascadeFile: ${cascadeFile.absolutePath}")
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

    private fun trackFace() {
        Thread {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(tempFileName, options)
            options.inSampleSize = calculateSampleSize(options, 400, 400)
            options.inJustDecodeBounds = false
            val bitmap = BitmapFactory.decodeFile(tempFileName, options)

            BitmapUtils.saveBitmap(bitmap, tempFileName)

            val matSrc = Mat()
            val matDst = Mat() //目标图，用于画框框
            val matGray = Mat() //转换成单通道的灰度图
            Utils.bitmapToMat(bitmap, matSrc)
            Imgproc.cvtColor(matSrc, matGray, COLOR_BGRA2GRAY)

            val mRelativeFaceSize = 0.2f
            if (mAbsoluteFaceSize == 0) {
                val height = matGray.rows()
                if ((height * mRelativeFaceSize).roundToInt() > 0) {
                    mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
                }
                //mNativeDetector.setMinFaceSize(mAbsoluteFaceSize)
            }

            // Imgproc.compareHist()
            val faces = MatOfRect()
            frontFaceClassifier!!.detectMultiScale(
                matGray,
                faces,
                1.1,
                1,//只检测单个人脸
                2,
                Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble()),
                Size()
            )
            val faceList = faces.toList()
            if (faceList.size > 0) {

                val rect = faceList[0]
                Log.e("1mean", "face rect: $rect")

                matSrc.copyTo(matDst)
                //tl:左上角坐标，br右下角坐标

                Imgproc.rectangle(
                    matDst,
                    rect.tl(),
                    rect.br(),
                    Scalar(255.0, 0.0, 0.0, 255.0),
                    4,
                    8,
                    0
                )

                val dstBitmap =
                    Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
                Utils.matToBitmap(matDst, dstBitmap)

                val localFile = FileUtils.getExternalFileDirectory(this, "")//File目录
                val facePath =
                    StringBuilder(localFile!!.absolutePath).append(File.separator).append("face")
                        .toString()
                val path = File(facePath, System.currentTimeMillis().toString() + ".jpg")


                val cropBitmap =
                    cropBitmap(dstBitmap, intArrayOf(rect.x, rect.y, rect.width, rect.height))

                Log.e("1mean", "${rect.width}")
                val newBitmap =
                    Bitmap.createBitmap(dstBitmap, rect.x, rect.y, rect.width, rect.height)

                val newMat = Mat()
                Utils.bitmapToMat(newBitmap, newMat)
                Log.e("1mean", "newMat: $newMat")


                //比对两个人脸 两个mat必须有相同的size，不然报错 616x820 302x302
                Log.e("1mean", "size1:${matDst.size()}, size2:${newMat.size()}")
                //val similar = Imgproc.compareHist(matDst, newMat, Imgproc.HISTCMP_CHISQR)
                //Log.e("1mean", "相似度： $similar")

//                BitmapUtils.saveBitmap(dstBitmap, path.absolutePath)
                BitmapUtils.saveBitmap(newBitmap!!, path.absolutePath)

                mHandler.post {
                    loadingPopup?.dismiss()
                    loadCircleBitmap(this, dstBitmap, binding.imgFaceLogin)
                }
            } else {//未检测到人脸，删除本地图片，并提示
                FileUtils.deleteFile(tempFileName)
                loadingPopup?.dismiss()
                Looper.prepare()
                shortToast(this, "未检测到人脸，请重新拍摄")
                Looper.loop()
            }
            matSrc.release()
            matDst.release()
            matGray.release()
        }.start()


    }

    private fun calculateSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        val width = options.outWidth
        val height = options.outHeight
        var inSampleSize = 1
        val halfWidth = width / 2
        val halfHeight = height / 2
        while (halfWidth / inSampleSize >= reqWidth && halfHeight / inSampleSize >= reqHeight) {
            inSampleSize *= 2
        }
        return inSampleSize
    }

    private fun cropBitmap(bitmap: Bitmap, rect: IntArray): Bitmap? {
        val iw = bitmap.width
        val ih = bitmap.height
        var width_add = rect[2]
        while ((rect[0]
                    - width_add < 0) || rect[1] - width_add < 0 || rect[0] + rect[2] + width_add > iw || rect[1] + rect[3] + width_add > ih
        ) {
            width_add--
            if (width_add == 0) break
        }
        val rect_int = intArrayOf(
            (rect[0] - width_add),
            (rect[1] - width_add),
            (rect[2] + 2 * width_add),
            (rect[3] + 2 * width_add)
        )
        return Bitmap.createBitmap(
            bitmap,
            rect_int[0],
            rect_int[1],
            rect_int[2],
            rect_int[3]
        )
    }
}