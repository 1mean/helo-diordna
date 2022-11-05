package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityFaceBinding
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import org.opencv.android.BaseLoaderCallback
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
import org.opencv.android.LoaderCallbackInterface
import org.opencv.android.OpenCVLoader
import org.opencv.core.*
import org.opencv.imgproc.Imgproc.LINE_AA
import org.opencv.imgproc.Imgproc.rectangle
import org.opencv.objdetect.CascadeClassifier
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.math.roundToInt

/**
 * @description: face camera
 * @author: dongyiming
 * @date: 11/2/22 9:20 AM
 * @version: v1.0
 */
public class FaceActivity : BaseActivity<BaseViewModel, ActivityFaceBinding>(),
    CvCameraViewListener2 {

    private var isFrontCamera: Boolean = false
    private var mRgba: Mat? = null
    private var mGray: Mat? = null
    private var classifierFace: CascadeClassifier? = null //这个检测器检测是真垃圾
    private var frontFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var profileFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var classifierEye: CascadeClassifier? = null

    //设置检测区域
    private val m55Size = Size(55.0, 55.0)
    private val m65Size = Size(65.0, 65.0)
    private val mDefault = Size()


    private var fps = 3
    private var mAbsoluteFaceSize = 0
    private var facesCache: MutableList<Rect> = mutableListOf()

    private val faceRectColor: Scalar by lazy { Scalar(255.0, 0.0, 0.0, 255.0) }

    override fun initView(savedInstanceState: Bundle?) {

        initWindow()
        initLoadOpenCV()
        initClassifierFace()
        initClassifierEye()
        initFrontFace()
        initProfileFace()
        binding.cameraView.enableView()
        binding.cameraView.setCvCameraViewListener(this)
        binding.btnCameraSwitch.setOnClickListener {//前后摄像头的切换
            if (isFrontCamera) {
                binding.cameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_BACK)
            } else {
                binding.cameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_FRONT)
            }
            isFrontCamera = !isFrontCamera
            //摄像头切换
            binding.cameraView.disableView()
            binding.cameraView.enableView()
            Log.e("1mean", "点击了")
        }

    }

    /**
     * 人脸
     * 初始化级联分类器
     * 写入/data/user/0/com.example.hello_diordna/app_cascade/lbpcascade_frontalface_improved.xml
     */
    private fun initClassifierFace() {
        try {
            //读取存放在raw的文件
            val `is` = resources.openRawResource(R.raw.lbpcascade_frontalface_improved)
            val cascadeDir = getDir("cascade", MODE_PRIVATE)
            val cascadeFile = File(cascadeDir, "lbpcascade_frontalface_improved.xml")
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
            classifierFace = CascadeClassifier(cascadeFile.absolutePath)
            cascadeFile.delete()
            cascadeDir.delete()
        } catch (e: IOException) {
            e.printStackTrace()
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

    /**
     * 初始化侧脸分类器
     */
    private fun initProfileFace() {
        try {
            //读取存放在raw的文件
            val `is` = resources.openRawResource(R.raw.haarcascade_profileface)
            val cascadeDir = getDir("cascade", MODE_PRIVATE)
            val cascadeFile = File(cascadeDir, "haarcascade_profileface.xml")
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
            profileFaceClassifier = CascadeClassifier(cascadeFile.absolutePath)
            cascadeFile.delete()
            cascadeDir.delete()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 眼睛
     * 初始化级联分类器
     */
    fun initClassifierEye() {
        try {
            //读取存放在raw的文件
            val `is` = resources
                .openRawResource(R.raw.haarcascade_eye_tree_eyeglasses)
            val cascadeDir = getDir("cascade", MODE_PRIVATE)
            val cascadeFile = File(cascadeDir, "haarcascade_eye_tree_eyeglasses.xml")
            val os = FileOutputStream(cascadeFile)
            val buffer = ByteArray(4096)
            var bytesRead: Int
            while (`is`.read(buffer).also { bytesRead = it } != -1) {
                os.write(buffer, 0, bytesRead)
            }
            `is`.close()
            os.close()
            classifierEye = CascadeClassifier(cascadeFile.absolutePath)
            cascadeFile.delete()
            cascadeDir.delete()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback)
        } else {
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
        }
    }

    override fun createObserver() {
    }

    /**
     * 设置全屏/常亮/强制横屏
     *
     * JavaCameraView默认横屏，当改成竖屏时，预览会发生逆时针90度旋转。需要对预览帧进行实时处理才能正确显示图像
     * 处理：翻转预览帧，导致帧率降低，此处强制横屏来简化处理
     */
    private fun initWindow() {
        StatusBarUtils.setStatusBarMode(this, true, R.color.white)
        ScreenUtil.setFullScreen(this)
        ScreenUtil.setScreenOn(this)
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    /**
     * OpeenCV包的初始化
     */
    private fun initLoadOpenCV() {

        val success = OpenCVLoader.initDebug()
        if (success) {
            shortToast(applicationContext, "Loading OpenCV Libraries...")
        } else {
            shortToast(applicationContext, "WARNING: Could not load openCV Libraries")
        }
    }

    override fun onCameraViewStarted(width: Int, height: Int) {
        mRgba = Mat()
        mGray = Mat()
    }

    override fun onCameraViewStopped() {
        mRgba?.release()
        mGray?.release()
    }


    /**
     * 获取每一帧的数据，进行人脸检测(线程池里不同的线程)
     * -
     *  - 首先要初始化级联分类器 raw里保存模型文件
     */
    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame): Mat {
        mRgba = inputFrame.rgba()//RGBA
        mGray = inputFrame.gray()//返回单通道的灰度图
        //隔3帧进行一次人脸检测
        val mRelativeFaceSize = 0.2f
        if (mAbsoluteFaceSize == 0) {
            val height = mGray!!.rows()
            if ((height * mRelativeFaceSize).roundToInt() > 0) {
                mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
            }
            //mNativeDetector.setMinFaceSize(mAbsoluteFaceSize)
        }
        Log.e("1mean","size: ${mAbsoluteFaceSize.toDouble()}")
        val faces = MatOfRect()
        frontFaceClassifier?.detectMultiScale(
            mGray,
            faces,//被检测物体的矩形框向量组
            1.1,//前后两次的扫描，窗口的搜索比例系数，默认1.1(每次搜索窗口依次扩大10%)
            5,//构成检测目标的相邻矩形的个数 默认是3，同时检测3个单位
            2,//排除检测不到的区域
            //这个size设置成m55Size，值越小会导致画面拖动特别特别卡顿
            Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble()),
//            m55Size,//2个size是限制得到的目标区域的范围，越小检测距离越远
            mDefault
        )
        //把检测到的人脸坐标存在全局变量
        facesCache = faces.toList()

        //使用缓存的人脸坐标信息进行绘制

        //使用缓存的人脸坐标信息进行绘制 LINE_AA抗锯齿线 LINE_4和LINE_8是属于钜齿线
        for (rect in facesCache) {
            rectangle(mRgba, rect.tl(), rect.br(), faceRectColor, 3, LINE_AA)
        }
        return mRgba!!
    }

    override fun onPause() {
        super.onPause()
        binding.cameraView.disableView()
    }

    private val mLoaderCallback: BaseLoaderCallback = object : BaseLoaderCallback(this) {
        override fun onManagerConnected(status: Int) {
            when (status) {
                SUCCESS -> {
                }
                else -> {
                    super.onManagerConnected(status)
                }
            }
        }
    }
}