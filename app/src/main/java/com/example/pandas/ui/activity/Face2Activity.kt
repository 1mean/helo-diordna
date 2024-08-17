/*
package com.example.pandas.ui.activity

import FaceManager
import android.Manifest
import android.annotation.TargetApi
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.*
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.android.base.vm.BaseViewModel
import com.example.pandas.bean.MatRect
import com.example.pandas.databinding.ActivityFaceBinding
import com.example.pandas.ui.adapter.FaceDetectedAdapter
import com.example.pandas.ui.ext.shortToast
import com.example.pandas.ui.view.CustomJavaCameraView
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
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


*/
/**
 * 1-完成基本人脸识别功能
 * 2-调优opencv
 * 3-调优人脸算法
 *
 *
 * @description: face camera
 * @author: dongyiming
 * @date: 11/2/22 9:20 AM
 * @version: v1.0
 *//*

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

    */
/**
     * 注意：
     * CameraBridgeViewBase里checkCurrentState()方法判断mCameraPermissionGranted=false不会启动camera，会导致黑屏
     * 故必须申请此权限，否则只能自己手动启动camera，如restart connect方法
     *//*

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

    */
/**
     * 初始化正脸分类器 初始化级联分类器
     *
     * 写入/data/user/0/com.example.hello_diordna/app_cascade/lbpcascade_frontalface_improved.xml
     *//*

    private fun initFrontFace() {
        try {
            //读取存放在raw的文件
            val `is` = resources.openRawResource(R.raw.haarcascade_frontalface_alt2)
            val cascadeDir = getDir("cascade", MODE_PRIVATE)
            val cascadeFile = File(cascadeDir, "haarcascade_frontalface_alt2.xml")
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

    */
/**
     * 初始化侧脸分类器
     *//*

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

    */
/**
     * 眼睛
     * 初始化级联分类器
     *//*

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

    */
/**
     * 设置全屏/常亮/强制横屏
     *
     * JavaCameraView默认横屏，当改成竖屏时，预览会发生逆时针90度旋转。需要对预览帧进行实时处理才能正确显示图像
     * 处理：翻转预览帧，导致帧率降低，此处强制横屏来简化处理
     *//*

    private fun initWindow() {
//        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
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
    }

    override fun onCameraViewStopped() {
        mRgba?.release()
    }

    */
/**
     * 获取每一帧的数据，进行人脸检测 Thread[OpenCVCameraBackground,5,main] 异步线程
     *  - 首先要初始化级联分类器 raw里保存模型文件
     *  - 一秒预览数据回调30次，额滴娘叻
     *//*

    private var currentMat: Mat? = null //返回的每一帧的Mat数据
    private val mRelativeFaceSize = 0.1f
    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame): Mat {

        Log.e("1mean", "开始新的一帧人脸的检测")
        mRgba = inputFrame.rgba()

        threadPool.execute {

            if (mRgba!!.width() == 0) {
                return@execute
            }
            Log.e("1m1e1a1n1","${mRgba!!.width()}")
            val mGray = Mat()
            val srcMat = mRgba!!.clone()
            Log.e("1m1e1a1n1","${mRgba!!.cols()}")
            cvtColor(mRgba!!, mGray, COLOR_BGRA2GRAY)

            //一、设置最小检测的人脸框size
            if (mAbsoluteFaceSize == 0) {
                val height = mGray.rows()
                if ((height * mRelativeFaceSize).roundToInt() > 0) {
                    mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
                }
            }
            val minSize = Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble())
            Log.e("1mean", "人脸框最小尺寸： width:${minSize.width}")

            //二、进行人脸检测
            val faces = FaceManager.instance.detectFrontFace(frontFaceClassifier, mGray, minSize)
            facesCache = faces.toList()

            if (facesCache.isNotEmpty()) {
                //三、对检测到的人脸框进行处理
                for (rect in facesCache) {

                    //四、判断是否有人眼
                    val start_time = System.currentTimeMillis()
//                val hasEyes = selectEyesArea(rect, mRgba!!, classifierEye)
                    val hasEyes = true
                    val end_time = System.currentTimeMillis()
                    Log.e("1m1e1a1n1", "人眼消耗时间= ${end_time - start_time}")
                    if (hasEyes) {
                        Log.e("1m1e1a1n1","开始绘制人脸")
                        //五、绘制人脸框
                        //rectangle(mRgba, rect.tl(), rect.br(), faceRectColor, 3, LINE_AA)
                    }
                }
            } else {
                trackFaces.clear()
            }

        }
        return mRgba!!
    }

    private fun onCameraFrame1(inputFrame: CameraBridgeViewBase.CvCameraViewFrame): Mat {

        mRgba = inputFrame.rgba()
//        mGray = inputFrame.gray()
//
//        if (mAbsoluteFaceSize == 0) {
//            val height = mGray!!.rows()
//            if ((height * mRelativeFaceSize).roundToInt() > 0) {
//                mAbsoluteFaceSize = (height * mRelativeFaceSize).roundToInt()
//            }
//        }
//        val minSize = Size(mAbsoluteFaceSize.toDouble(), mAbsoluteFaceSize.toDouble())
//        Log.e("1mean", "人脸框最小尺寸： width:${minSize.width}")
//
//        val faces = FaceManager.instance.detectFrontFace(frontFaceClassifier, mGray!!, minSize)
//
//        //把检测到的人脸坐标存在全局变量
//        facesCache = faces.toList()
//        if (facesCache.isEmpty()) {//当前帧没有检测到人脸，清空人脸数据
//            trackFaces.clear()
//        } else {
//            if (trackFaces.size > 5) {
//                trackFaces.clear()
//            }
//            val hasTrackFace = trackFaces.isNotEmpty()
//            for (rect in facesCache) {
//                var hasFace = false
//                var curRect = rect.clone()
//                //1,裁剪出人脸mat
//                val faceMat = FaceManager.instance.cutFace(mRgba!!, rect)
//                Log.e("1mean", "检测到人脸")
//                //2,判断是人脸，这里不知道怎么判断，总有识别其他东西成人脸
//                val hasEyes = selectEyesArea(rect, mRgba!!, classifierEye)
//                if (hasEyes) {//识别出人眼，才算人脸，，，总能检测出非人脸
//                    saveNewFace(faceMat)
//                    val cutGrayMat = Mat()
//                    cvtColor(faceMat, cutGrayMat, COLOR_BGRA2GRAY)
//                    Log.e("asdasdsadasd212", "trackFaces的size= ${trackFaces.size}")
//                    if (hasTrackFace) {
//                        //2，比较该mat是否一直在画面里，如果一直在，则正框
//                        //bug:ConcurrentModificationException,在foreach时有增删不被允许
//                        for (index in 0 until trackFaces.size) {
//                            val matRect = trackFaces[index]
//                            val lastRect = matRect.rect
//                            val lastMat = matRect.mat
//                            val similar =
//                                FaceManager.instance.compare(this, lastMat, cutGrayMat)
//                            if (similar > 0.6) {//是同一个人
//                                val isSameRect = FaceManager.instance.isSameRect(rect, lastRect)
//                                if (isSameRect) {
//                                    curRect = lastRect
//                                    hasFace = true
//                                }
//                                break
//                            }
//                        }
//                        if (!hasFace) {
//                            trackFaces.add(MatRect(cutGrayMat, rect))
//                            Log.e("asdasd4332", "添加新人脸，总size: ${trackFaces.size}")
//                        }
//                    } else {
//                        trackFaces.add(MatRect(cutGrayMat, rect))
//                    }
//                    //使用缓存的人脸坐标信息进行绘制 LINE_AA抗锯齿线 LINE_4和LINE_8是属于钜齿线
//                    rectangle(mRgba, rect.tl(), rect.br(), faceRectColor, 3, LINE_AA)
//                    Imgproc.putText(
//                        mRgba, "你好", rect.tl(),
//                        FONT_HERSHEY_SIMPLEX, 0.5, Scalar(255.0, 0.0, 0.0, 255.0)
//                    )
//                }
//            }
//        }
        return mRgba!!
    }

    private val mHandler: Handler = FaceHandler()

    private class FaceHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) {

            }
        }
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
                    Log.e("sdas221edasd", "count: $count")
                }
            }
        }
    }

    private var eyes: MatOfRect? = null
    fun selectEyesArea(
        faceRect: Rect,
        mRgba: Mat,
        classifierEye: CascadeClassifier?
    ): Boolean {

        val offY = (faceRect.height * 0.15f).toInt()//人眼距离顶部
        val offx = (faceRect.width * 0.12f).toInt()//人眼距离左侧
        val sh = (faceRect.height * 0.35f).toInt()//人眼区域的检测高度
        val sw = (faceRect.width * 0.3f).toInt()//单人眼的宽度
        val gap = (faceRect.width * 0.025f).toInt()

        //左眼
        val lp_eye = Point(faceRect.tl().x + offx, faceRect.tl().y + offY)//人眼检测区域左上角
        val lp_end = Point(lp_eye.x + sw, lp_eye.y + sh)//右下角
        //rectangle(mRgba, lp_eye, lp_end, Scalar(255.0, 255.0, 0.0, 255.0), 2)

        //右眼
        val right_offx = (faceRect.width * 0.08f).toInt()
        val rp_eye = Point(
            faceRect.tl().x + faceRect.width / 2 + right_offx,
            faceRect.tl().y + offY
        )//人眼检测区域左上角
        val rp_end = Point(rp_eye.x + sw, rp_eye.y + sh)//右下角

        //rectangle(mRgba, rp_eye, rp_end, Scalar(255.0, 255.0, 0.0, 255.0), 2)

        eyes = MatOfRect()
        val left_eye_roi = Rect()
        left_eye_roi.x = lp_eye.x.toInt()
        left_eye_roi.y = lp_eye.y.toInt()
        left_eye_roi.width = (lp_end.x - lp_eye.x).toInt()
        left_eye_roi.height = (lp_end.y - lp_eye.y).toInt()

        val right_eye_roi = Rect()
        right_eye_roi.x = rp_eye.x.toInt()
        right_eye_roi.y = rp_eye.y.toInt()
        right_eye_roi.width = (rp_end.x - rp_eye.x).toInt()
        right_eye_roi.height = (rp_end.y - rp_eye.y).toInt()

        classifierEye?.detectMultiScale(
            mRgba.submat(left_eye_roi),
            eyes,
            1.15,
            2,
            0,
            Size(30.0, 30.0),
            Size()
        )
        val leftEyeArray = eyes!!.toArray()
        eyes?.release()

        eyes = MatOfRect()
        classifierEye?.detectMultiScale(
            mRgba.submat(right_eye_roi),
            eyes,
            1.15,
            2,
            0,
            Size(30.0, 30.0),
            Size()
        )
        val rightEyeArray = eyes!!.toArray()
        eyes?.release()
        if (leftEyeArray.isNotEmpty() || rightEyeArray.isNotEmpty()) {
            Log.e("1mean", "检测到右眼")
            return true
        }
        return false
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
                    initClassifierEye()
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
}*/
