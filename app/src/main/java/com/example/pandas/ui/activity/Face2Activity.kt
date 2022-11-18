package com.example.pandas.ui.activity

import FaceManager
import android.Manifest
import android.annotation.TargetApi
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.MatRect
import com.example.pandas.databinding.ActivityFaceBinding
import com.example.pandas.ui.adapter.FaceDetectedAdapter
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.view.CustomJavaCameraView
import com.example.pandas.utils.ScreenUtil
import org.opencv.android.*
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import org.opencv.imgproc.Imgproc.*
import org.opencv.objdetect.CascadeClassifier
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.Executors
import kotlin.math.roundToInt


/**
 * @description: face camera
 * @author: dongyiming
 * @date: 11/2/22 9:20 AM
 * @version: v1.0
 */
public class Face2Activity : BaseActivity<BaseViewModel, ActivityFaceBinding>(),
    CvCameraViewListener2 {

    //设置检测区域
    private val m55Size = Size(55.0, 55.0)
    private val m65Size = Size(65.0, 65.0)
    private val faceRectColor: Scalar by lazy { Scalar(255.0, 255.0, 0.0, 255.0) }

    private var fps = 3
    private var mAbsoluteFaceSize = 0
    private var facesCache: MutableList<Rect> = mutableListOf()
    private var isInitSuccess = false
    private var isFrontCamera: Boolean = false
    private var mRgba: Mat? = null
    private var mGray: Mat? = null
    private var classifierFace: CascadeClassifier? = null //这个检测器检测是真垃圾
    private var frontFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var profileFaceClassifier: CascadeClassifier? = null //正脸检分类器
    private var classifierEye: CascadeClassifier? = null
    private val threadPool = Executors.newSingleThreadExecutor()
    private val detectedFace: MutableList<Mat> by lazy { mutableListOf() }
    private val mAdapter: FaceDetectedAdapter by lazy { FaceDetectedAdapter() }

    //当前屏幕中以识别的人脸
//    private val detectedMats = ConcurrentHashMap<Mat, IntArray>()
//    private val trackFaces = mutableMapOf<Mat, Rect>()
    private val trackFaces = mutableListOf<MatRect>()

    override fun initView(savedInstanceState: Bundle?) {

        initWindow()
        binding.cameraView.isPortrait = false
        //binding.cameraView.visibility = CameraBridgeViewBase.VISIBLE
        binding.cameraView.setCvCameraViewListener(this)


        binding.btnCameraSwitch.setOnClickListener {//前后摄像头的切换
//            if (isFrontCamera) {
//                binding.cameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_BACK)
//            } else {
//                binding.cameraView.setCameraIndex(CameraBridgeViewBase.CAMERA_ID_FRONT)
//            }
//            isFrontCamera = !isFrontCamera
//            //摄像头切换
//            binding.cameraView.disableView()
//            binding.cameraView.enableView()
//            Log.e("1mean", "点击了")
            binding.cameraView.swithCamera(!binding.cameraView.useFrontCamera)
        }

        //有小屏幕的核心代码
        binding.cameraView.setOnFrameReadCallBack(object :
            CustomJavaCameraView.OnFrameReadCallBack {
            override fun OnFrameRead(bitmap: Bitmap?, mat: Mat?) {
                runOnUiThread {
                    //无限设置bitmap，成为一个小内屏
                    //binding.btnCameraSwitch.setImageBitmap(bitmap)
                }
            }
        })
        requestPermission()

        binding.rvFaces.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@Face2Activity)
        }
    }

    /**
     * 注意：
     * CameraBridgeViewBase里checkCurrentState()方法判断mCameraPermissionGranted=false不会启动camera，会导致黑屏
     * 故必须申请此权限，否则只能自己手动启动camera，如restart connect方法
     */
    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST_CODE
                )
            } else {
                initCamera()
            }
        } else {
            initCamera()
        }
    }

    /**
     * 初始化正脸分类器 初始化级联分类器
     *
     * 写入/data/user/0/com.example.hello_diordna/app_cascade/lbpcascade_frontalface_improved.xml
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

        ScreenUtil.setFullScreen(this)
        ScreenUtil.setScreenOn(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e("1mean", "onConfigurationChanged")
        val mConfiguration = this.resources.configuration //获取设置的配置信息
        val ori = mConfiguration.orientation //获取屏幕方向
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            binding.cameraView.isPortrait = false
            //横屏
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            binding.cameraView.isPortrait = true
        }
        binding.cameraView.restartCamera()
    }

    override fun onCameraViewStarted(width: Int, height: Int) {
        mRgba = Mat()
        mGray = Mat()
    }

    override fun onCameraViewStopped() {
        mRgba?.release()
        mGray?.release()
    }


    private var detectIndex = 0

    /**
     * 获取每一帧的数据，进行人脸检测 Thread[OpenCVCameraBackground,5,main]
     * -
     *  - 首先要初始化级联分类器 raw里保存模型文件
     *
     *  - 一秒预览数据回调30次，额滴娘叻
     */
    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame): Mat {
        Log.e("1mean", "thread:${Thread.currentThread()}")
        Log.e("1me11111an", "onCameraFrame")
        mRgba = inputFrame.rgba()//RGBA
        mGray = inputFrame.gray()//返回单通道的灰度图

        //隔3帧进行一次人脸检测
        if (detectIndex >= 3) {//检查没有人脸时，可以一秒检测一次
            detectIndex = 0
            val mRelativeFaceSize = 0.2f
            if (mAbsoluteFaceSize == 0) {
                val height = mGray!!.rows()
                if ((height * mRelativeFaceSize).roundToInt() > 0) {
                    mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
                }
            }
            val minSize = Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble())
            Log.e("1mean", "人脸框最小尺寸： width:${minSize.width}")
            val faces = FaceManager.instance.detectFrontFace(frontFaceClassifier, mGray!!, minSize)

            //把检测到的人脸坐标存在全局变量
            facesCache = faces.toList()
            if (facesCache.isEmpty()) {//如果没有检测到人脸，可以适当加速检测速度
                detectIndex++
                trackFaces.clear()
            } else {
                //使用缓存的人脸坐标信息进行绘制 LINE_AA抗锯齿线 LINE_4和LINE_8是属于钜齿线
                if (trackFaces.size > 5) {
                    trackFaces.clear()
                }
                val hasTrackFace = trackFaces.isNotEmpty()
                for (rect in facesCache) {
                    var hasFace = false
                    var curRect = rect.clone()
                    //1,裁剪出人脸mat
                    val faceMat = FaceManager.instance.cutFace(mRgba!!, rect)
                    saveNewFace(faceMat)
                    val cutGrayMat = Mat()
                    cvtColor(faceMat, cutGrayMat, COLOR_BGRA2GRAY)
                    Log.e("asdasdsadasd212", "trackFaces的size= ${trackFaces.size}")
                    if (hasTrackFace) {
                        //2，比较该mat是否一直在画面里，如果一直在，则正框
                        //bug:ConcurrentModificationException,在foreach时有增删不被允许
                        for (index in 0 until trackFaces.size) {
                            val matRect = trackFaces[index]
                            val lastRect = matRect.rect
                            val lastMat = matRect.mat
                            val similar = FaceManager.instance.compare(this, lastMat, cutGrayMat)
                            if (similar > 0.6) {//是同一个人
                                val isSameRect = FaceManager.instance.isSameRect(rect, lastRect)
                                if (isSameRect) {
                                    curRect = lastRect
                                    hasFace = true
                                }
                                break
                            }
                        }
                        if (!hasFace) {
                            trackFaces.add(MatRect(cutGrayMat, rect))
                            Log.e("asdasd4332", "添加新人脸，总size: ${trackFaces.size}")
                        }
                    } else {
                        trackFaces.add(MatRect(cutGrayMat, rect))
                    }
                    rectangle(mRgba, curRect.tl(), curRect.br(), faceRectColor, 3, LINE_AA)
                    Imgproc.putText(
                        mRgba, "你好", rect.tl(),
                        FONT_HERSHEY_SIMPLEX, 0.5, Scalar(255.0, 0.0, 0.0, 255.0)
                    )

//                    val faceDir =
//                        FileUtils.getExternalFilePath(context, "face")
//                    val facePath =
//                        File(faceDir, System.currentTimeMillis().toString() + ".jpg").absolutePath
//                    val resultBitmap =
//                        Bitmap.createBitmap(dstMat.width(), dstMat.height(), Bitmap.Config.ARGB_8888)
//                    Utils.matToBitmap(dstMat, resultBitmap)
//                    BitmapUtils.savePngBitmap(resultBitmap, facePath)
                }
            }
        }
        detectIndex++
        return mRgba!!
    }

    private fun saveNewFace(newMat: Mat) {
        threadPool.execute {
            val mats = mAdapter.getList()
            if (mats.isNotEmpty()) {
                for (index in 0 until mats.size) {
                    val mat = mats[index]
                    val grayMat1 = Mat()
                    val grayMat2 = Mat()
                    cvtColor(mat, grayMat1, COLOR_BGRA2GRAY)
                    cvtColor(newMat, grayMat2, COLOR_BGRA2GRAY)
                    val similar = FaceManager.instance.compare(this, grayMat1, grayMat2)
                    if (similar >= 0.6) {
                        return@execute
                    }
                }
            }
            runOnUiThread {
                Log.e("sdas221edasd", "FaceDetectedAdapter add item")
                mAdapter.insertFirst(newMat)
                binding.rvFaces.post {
                    val count = mAdapter.itemCount
                    Log.e("sdas221edasd","count: $count")
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        binding.cameraView.disableView()
    }

    private val mLoaderCallback: BaseLoaderCallback = object : BaseLoaderCallback(this) {
        override fun onManagerConnected(status: Int) {
            when (status) {
                SUCCESS -> {

                    //initClassifierEye()
                    initFrontFace()
                    initProfileFace()

                    Log.i("Face-module", "OpenCV loaded successfully")
                    binding.cameraView.enableView()
                    binding.cameraView.enableFpsMeter()
                }
                else -> {
                    super.onManagerConnected(status)
                }
            }
        }
    }

    private fun initCamera(): Boolean {
        binding.cameraView.post {

            binding.cameraView.setCameraPermissionGranted() //需要已经授权可以使用摄像头再调用这个方法
            isInitSuccess = OpenCVLoader.initDebug()
            binding.cameraView.setCameraPermissionGranted() //需要已经授权可以使用摄像头再调用这个方法

            if (isInitSuccess) {
                shortToast(applicationContext, "Loading OpenCV Libraries...")
                mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
            }
        }
        return isInitSuccess
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initCamera()
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_REQUEST_CODE = 200
    }
}