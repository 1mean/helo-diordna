import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import com.example.pandas.utils.BitmapUtils
import com.example.pandas.utils.FileUtils
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import org.opencv.objdetect.CascadeClassifier
import java.io.*
import java.lang.Math.abs


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 11/7/22 3:15 AM
 * @version: v1.0
 */

//private val faceManager: FaceManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { FaceManager() }

class FaceManager private constructor() {

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = FaceManager()
    }

    /**
     * 正脸检测
     * @param:
     * @return: MatOfRect，获取到的人脸的坐标，用于绘制框框
     * @author: dongyiming
     * @date: 11/17/22 7:19 PM
     * @version: v1.0
     */
    fun detectFrontFace(
        frontFaceClassifier: CascadeClassifier?,
        grayMat: Mat,
        minSize: Size,
        maxSize: Size = Size()
    ): MatOfRect {
        val faceRect = MatOfRect()
        frontFaceClassifier?.detectMultiScale(
            grayMat,
            faceRect,//被检测物体的矩形框向量组
            1.1,//前后两次的扫描，窗口的搜索比例系数，默认1.1(每次搜索窗口依次扩大10%)
            5,//构成检测目标的相邻矩形的个数 默认是3，同时检测3个单位
            2,//排除检测不到的区域
            minSize,//这个size设置成Size(55.0, 55.0)，值越小会导致画面拖动特别特别卡顿
            maxSize//2个size是限制得到的目标区域的范围，越小检测距离越远
        )
        return faceRect
    }

    /**
     * 人脸比对
     *    - 必须比对两个 <size> 和 <type> 都相同的Mat对象，点对点的运行
     *    - 使用单通道的灰度图进行比较，否则结果会为负值
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 11/17/22 6:41 PM
     * @version: v1.0
     */
    private var isFirlst = true
    fun compare(context: Context, mat1: Mat, mat2: Mat): Double {

        if (!isFirlst) {
            val faceDir =
                FileUtils.getExternalFilePath(context, "face")
            val facePath1 =
                File(faceDir, System.currentTimeMillis().toString() + "1.jpg").absolutePath
            val facePath2 =
                File(faceDir, System.currentTimeMillis().toString() + "2.jpg").absolutePath
            val resultBitmap1 =
                Bitmap.createBitmap(mat1.width(), mat1.height(), Bitmap.Config.ARGB_8888)
            val resultBitmap2 =
                Bitmap.createBitmap(mat2.width(), mat2.height(), Bitmap.Config.ARGB_8888)
            Utils.matToBitmap(mat1, resultBitmap1)
            Utils.matToBitmap(mat2, resultBitmap2)
            BitmapUtils.savePngBitmap(resultBitmap1, facePath1)
            BitmapUtils.savePngBitmap(resultBitmap2, facePath2)

            isFirlst = true
        }
        val startTime = System.currentTimeMillis()
        val compare1Mat = Mat()
        val compare2Mat = Mat()
        Imgproc.resize(mat1, compare1Mat, Size(300.0, 300.0))
        Imgproc.resize(mat2, compare2Mat, Size(300.0, 300.0))
        compare1Mat.convertTo(compare1Mat, CvType.CV_32F)//CV_32F：单通道的32位图像
        compare2Mat.convertTo(compare2Mat, CvType.CV_32F)
//        val grayMat = Mat()
//        val grayMat2 = Mat()
//        Imgproc.cvtColor(compare1Mat, grayMat, Imgproc.COLOR_BGRA2GRAY)
//        Imgproc.cvtColor(compare2Mat, grayMat2, Imgproc.COLOR_BGRA2GRAY)
//        val similar = Imgproc.compareHist(grayMat, grayMat2, Imgproc.CV_COMP_CORREL)
        val similar = Imgproc.compareHist(compare1Mat, compare2Mat, Imgproc.CV_COMP_CORREL)
        Log.e("1mean22123", "相似度=$similar")
        val endTime = System.currentTimeMillis()
        Log.e("1mean22123", "一次识别的时间：${endTime - startTime}")
        return similar
    }

    /**
     * 当同一张人脸，下一个框的中心在标记框的中心附近并且框的大小震荡为20以内，保持框的位置不变（上一次框的位置），否则更新追踪map中的人脸框
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 11/18/22 4:49 PM
     * @version: v1.0
     */
    fun isSameRect(rect1: Rect, rect2: Rect): Boolean {

        val center1_x = rect1.x + rect1.width / 2
        val center1_y = rect1.y + rect1.height / 2
        val center2_x = rect2.x + rect2.width / 2
        val center2_y = rect2.y + rect2.height / 2
        val rect_width_abs = abs(rect1.width - rect2.width)
        val rect_x_abs = abs(center1_x - center2_x)
        val rect_y_abs = abs(center1_y - center2_y)
        if (rect_width_abs <= 20 && rect_x_abs <= 10 && rect_y_abs <= 10) {
            return true
        }
        return false
    }

    /**
     * 从灰度图里按照人脸坐标切割出人脸图，用于后续界面展示和人脸比对
     *   - 手动切割，先确定切割点，这样运算快，速度快
     * @param: <grayMat>单通道灰度图
     * @return:
     * @author: dongyiming
     * @date: 11/17/22 7:40 PM
     * @version: v1.0
     */
    fun cutFace(graySrcMat: Mat, rect: Rect): Mat {

        val x_start = rect.x
        val y_start = rect.y
        val x_end = rect.x + rect.width
        val y_end = rect.y + rect.height
        //其他几种裁剪方式得到的mat转换成bitmap后存储在本地都是空照片
        return graySrcMat.submat(y_start, y_end, x_start, x_end)
    }

    /**
     * CV_8U and CV_8S -> byte[]
     * CV_16U and CV_16S -> short[]
     * CV_32S -> int[]
     * CV_32F -> float[]
     * CV_64F-> double[]
     */
    fun serializeMat(mat: Mat): ByteArray? {
        val bos = ByteArrayOutputStream()
        return try {
            val data = FloatArray(mat.total().toInt() * mat.channels())
            mat[0, 0, data]
            val out: ObjectOutput = ObjectOutputStream(bos)
            out.writeObject(data)
            out.close()
            // Get the bytes of the serialized object
            bos.toByteArray()
        } catch (ioe: IOException) {
            ioe.printStackTrace()
            null
        }
    }

    fun matToJson(mat: Mat): String? {
        val obj = JsonObject()
        if (mat.isContinuous) {
            val cols = mat.cols()
            val rows = mat.rows()
            val elemSize = mat.elemSize().toInt()
            val data = ByteArray(cols * rows * elemSize)
            mat[0, 0, data]
            obj.addProperty("rows", mat.rows())
            obj.addProperty("cols", mat.cols())
            obj.addProperty("type", mat.type())

            // We cannot set binary data to a json object, so:
            // Encoding data byte array to Base64.
            val dataString: String = String(Base64.encode(data, Base64.DEFAULT))
            obj.addProperty("data", dataString)
            val gson = Gson()
            return gson.toJson(obj)
        } else {
            //Log.e(TAG, "Mat not continuous.")
        }
        return "{}"
    }

    fun matFromJson(json: String?): Mat? {
        val parser = JsonParser()
        val JsonObject: JsonObject = parser.parse(json).asJsonObject
        val rows: Int = JsonObject.get("rows").asInt
        val cols: Int = JsonObject.get("cols").asInt
        val type: Int = JsonObject.get("type").asInt
        val dataString: String = JsonObject.get("data").asString
        val data: ByteArray = Base64.decode(dataString.toByteArray(), Base64.DEFAULT)
        val mat = Mat(rows, cols, type)
        mat.put(0, 0, data)
        return mat
    }
}