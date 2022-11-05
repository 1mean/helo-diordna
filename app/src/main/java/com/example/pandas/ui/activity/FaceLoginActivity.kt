package com.example.pandas.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
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

    private var tempFilePath: String = ""
    private var frontFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var initSuccess = false

    private var mAbsoluteFaceSize = 0
    private var loadingPopup: LoadingPopupView? = null

    private val mHandler = Handler(Looper.getMainLooper())

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {

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

            if (initSuccess) {
                shortToast(this, "初始化失败，无法操作！！")
            }
            val localFile = FileUtils.getExternalFileDirectory(this, "")//File目录
            val facePath =
                StringBuilder(localFile!!.absolutePath).append(File.separator).append("face")
                    .toString()
            val faceFile = File(facePath)
            if (!faceFile.exists()) {
                faceFile.mkdirs()
            }
            val facePic = File(facePath, System.currentTimeMillis().toString() + ".jpg")
            tempFilePath = facePic.absolutePath
            Log.d("1mean", "tempFilePath: $tempFilePath")
            val uri: Uri = FileProvider.getUriForFile(
                this,
                "$packageName.fileprovider",
                facePic
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

            val activityOptionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeCustomAnimation(
                    this,
                    R.anim.animate_fragment_in,
                    R.anim.animate_fragment_out
                )
            requestLauncher.launch(intent, activityOptionsCompat)
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
            BitmapFactory.decodeFile(tempFilePath, options)
            options.inSampleSize = calculateSampleSize(options, 400, 400)
            options.inJustDecodeBounds = false
            val bitmap = BitmapFactory.decodeFile(tempFilePath, options)

            BitmapUtils.saveBitmap(bitmap, tempFilePath)

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
                matSrc.copyTo(matDst)
                faceList.forEach {
                    //tl:左上角坐标，br右下角坐标
                    Imgproc.rectangle(
                        matDst,
                        it.tl(),
                        it.br(),
                        Scalar(255.0, 0.0, 0.0, 255.0),
                        4,
                        8,
                        0
                    )
                }

                val dstBitmap =
                    Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
                Utils.matToBitmap(matDst, dstBitmap)

                bitmap.recycle()
                val localFile = FileUtils.getExternalFileDirectory(this, "")//File目录
                val facePath =
                    StringBuilder(localFile!!.absolutePath).append(File.separator).append("face")
                        .toString()
                val path = File(facePath, System.currentTimeMillis().toString() + ".jpg")
                BitmapUtils.saveBitmap(dstBitmap, path.absolutePath)

                mHandler.post {
                    loadingPopup?.dismiss()
                    loadCircleBitmap(this, dstBitmap, binding.imgFaceLogin)
                    dstBitmap.recycle()
                }
            } else {//未检测到人脸，删除本地图片，并提示
                FileUtils.deleteFile(tempFilePath)
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
}