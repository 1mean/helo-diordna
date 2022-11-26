package com.example.pandas.ui.view

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.util.Log
import org.opencv.android.JavaCamera2View
import org.opencv.android.Utils
import org.opencv.core.Core
import org.opencv.core.Core.ROTATE_180
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

/**
 * @description: 解决opencv不能全屏的问题
 * @author: dongyiming
 * @date: 6/29/22 11:12 下午
 * @version: v1.0
 */
public class CustomJavaCameraView : JavaCamera2View {

    //当前是否竖屏
    var isPortrait = true

    //自动缩放到全屏取中间部分绘制 2400x1080没必要了，判断都能通过
    val autoFullScreen = false

    //是否使用前置摄像头
    var useFrontCamera = false

    private val useGray = false

    //显示Mat用的Bitmap
    private var customCacheBitmap: Bitmap? = null

    //是否使用opencv自己的方式绘制来绘制
    var addSmallScreen = false

    //接受Bitmap回调，可以在其他的地方显示
    private var onFrameReadCallBack: CustomJavaCameraView.OnFrameReadCallBack? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    fun swithCamera(useFront: Boolean) {
        useFrontCamera = useFront
        mCameraIndex = if (useFront) CAMERA_ID_FRONT else CAMERA_ID_BACK
        disconnectCamera()
        connectCamera(width, height)
    }

    fun restartCamera() {
        disconnectCamera()
        connectCamera(width, height)
    }

    override fun deliverAndDrawFrame(frame: CvCameraViewFrame?) {
        super.deliverAndDrawFrame(frame)

        val width = width
        val height = height

        //使用自定义绘制方法
        var srcMat = frame!!.rgba()
        var rotatedMat: Mat? = null
        Log.e(
            "1233mean",
            "cols: ${srcMat.cols()}, rows: ${srcMat.rows()}, height: ${srcMat.height()}"
        )
        if (isPortrait) {
            //竖屏
            if (useFrontCamera) {
                Core.flip(srcMat, srcMat, 1) //使用了前置摄像头，需要翻转左右，不然旋转90度之后会有问题
                rotatedMat = Mat(srcMat.cols(), srcMat.rows(), srcMat.type())
                Core.rotate(srcMat, rotatedMat, Core.ROTATE_90_CLOCKWISE) //旋转之后得到正确的预览图像
                srcMat.release()
                srcMat = rotatedMat
            } else {
                Log.e(
                    "1233mean",
                    "cols: ${srcMat.cols()}, rows: ${srcMat.rows()}, type: ${srcMat.type()}"
                )
                rotatedMat = Mat(srcMat.cols(), srcMat.rows(), srcMat.type())
                Core.rotate(srcMat, rotatedMat, ROTATE_180) //旋转之后得到正确的预览图像
                srcMat.release()
                srcMat = rotatedMat
            }
        } else {
            //横屏则不需要处理
        }

        //经过上述步骤得到正确方向的Mat信息
        if (null == customCacheBitmap || customCacheBitmap!!.width != srcMat.cols() || customCacheBitmap!!.getHeight() != srcMat.rows()) {
            if (null != customCacheBitmap && !customCacheBitmap!!.isRecycled) {
                customCacheBitmap!!.recycle()
            }
            customCacheBitmap =
                Bitmap.createBitmap(srcMat.cols(), srcMat.rows(), Bitmap.Config.ARGB_8888)
        }

        //竖屏
        //cols:1080, rows:1080, width: 1080, height: 2299
        //scaleWidth:1.0, scaleHeight:2.1287036, maxScale:2.1287036
        //自动缩放到全屏，原生的Opencv mscale 参数自动计算出来有缺点不能自动铺满屏幕
        mScale = if (autoFullScreen) {//cols:2400, rows:1080, width: 2304, height: 1080
            if (srcMat.cols() < width || srcMat.rows() < height) {
                val scaleWidth: Float = width * 1.0f / srcMat.cols()
                val scaleHeight: Float = height * 1.0f / srcMat.rows()
                val maxScale = Math.max(scaleHeight, scaleWidth)
                maxScale //用自带的缩放系数（当然也可以自己来缩放Mat 或者bitmap达到同样的效果）
            } else {
                1.0f
            }
        } else {
            1.0f
        }
        Log.e("1233mean", "scale: $mScale")

        var bmpValid = true
        if (srcMat != null && addSmallScreen) {
            try {
                if (useGray) {
                    Imgproc.cvtColor(srcMat, srcMat, Imgproc.COLOR_BGR2GRAY)
                }
                //                    Imgproc.cvtColor(srcMat,srcMat,Imgproc.COLOR_RGB2RGBA);//需要强制设置一个格式否则dlib无法识别landmark
                Utils.matToBitmap(
                    srcMat,
                    customCacheBitmap
                ) //这一步骤很容易出错，每次根据Mat的实际大小创建Bitmap缓存，但是太浪费时间，所以要事先创建好
            } catch (e: Exception) {
                bmpValid = false
            }
            onFrameReadCallBack?.OnFrameRead(customCacheBitmap, srcMat)
            srcMat.release() //用完释放
        }

        //如果屏蔽下面的代码不会绘制
//        if (bmpValid && customCacheBitmap != null && !customCacheBitmap!!.isRecycled) {
//            val canvas = holder.lockCanvas()
//            if (canvas != null) {
//                canvas.drawColor(0, PorterDuff.Mode.CLEAR)
//
//                Log.e("1233mean", "mScale : $mScale")
//                if (mScale != 0f) {
//                    canvas.drawBitmap(//第一个rect是绘制bitmap的哪些区域，第二个rect是绘制在屏幕的哪个地方
//                        customCacheBitmap!!,
//                        Rect(0, 0, customCacheBitmap!!.width, customCacheBitmap!!.height),
//                        Rect(
//                            ((canvas.width - mScale * customCacheBitmap!!.width) / 2).toInt(),
//                            ((canvas.height - mScale * customCacheBitmap!!.height) / 2).toInt(),
//                            ((canvas.width - mScale * customCacheBitmap!!.width) / 2 + mScale * customCacheBitmap!!.width).toInt(),
//                            ((canvas.height - mScale * customCacheBitmap!!.height) / 2 + mScale * customCacheBitmap!!.height).toInt()
//                        ),
//                        null
//                    )
//                } else {
//                    canvas.drawBitmap(
//                        customCacheBitmap!!,
//                        Rect(0, 0, customCacheBitmap!!.width, customCacheBitmap!!.height),
//                        Rect(
//                            (canvas.width - customCacheBitmap!!.width) / 2,
//                            (canvas.height - customCacheBitmap!!.height) / 2,
//                            (canvas.width - customCacheBitmap!!.width) / 2 + customCacheBitmap!!.width,
//                            (canvas.height - customCacheBitmap!!.height) / 2 + customCacheBitmap!!.height
//                        ),
//                        null
//                    )
//                }
//                if (mFpsMeter != null) {
//                    mFpsMeter.setResolution(srcMat.width(), srcMat.height()) //使用真实的图片分辨率
//                    mFpsMeter.measure()
//                    mFpsMeter.draw(canvas, 20f, 30f)
//                }
//                holder.unlockCanvasAndPost(canvas)
//            }
//        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        customCacheBitmap?.let {
            if (!it.isRecycled) {
                it.recycle()
            }
        }
    }

    override fun calculateCameraFrameSize(
        supportedSizes: List<*>?,
        accessor: ListItemAccessor?,
        surfaceWidth: Int,
        surfaceHeight: Int
    ): Size? {
        return super.calculateCameraFrameSize(supportedSizes, accessor, surfaceWidth, surfaceHeight)
    }

    interface OnFrameReadCallBack {
        fun OnFrameRead(bitmap: Bitmap?, mat: Mat?)
    }

    fun setOnFrameReadCallBack(onFrameReadCallBack: OnFrameReadCallBack) {
        this.onFrameReadCallBack = onFrameReadCallBack
    }

}