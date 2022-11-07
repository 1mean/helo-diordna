import android.util.Base64
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.opencv.core.Mat
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectOutput
import java.io.ObjectOutputStream


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 11/7/22 3:15 AM
 * @version: v1.0
 */
public class FaceManager {

    /**
     * 统一的存储抓取到的人脸图片，用于展示
     */
    fun saveFacePic() {

    }

    /**
     * 通过bitmap和人脸区域，得到人脸的特征
     *
     */
    fun getFaceFeature(): FloatArray {

        return floatArrayOf()
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