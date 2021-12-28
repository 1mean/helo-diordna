import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import java.util.*

/**
 * @description: 全局crash处理
 * @author: dongyiming
 * @date: 11/16/21 1:55 PM
 * @version: v1.0
 */
class ApplicationCrashHandler(mContext: Context) : Thread.UncaughtExceptionHandler {


    private var mContext: Context
    private var crashCallback: CrashCallback? = null
    private var mDefaultHandler: Thread.UncaughtExceptionHandler

    init {
        this.mContext = mContext
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * <设置回调>
     * @param:
     * @return:
     */
    fun setCrashCallback(crashCallback: CrashCallback) {

        this.crashCallback = crashCallback
    }

    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     * @param t the thread
     * @param e the exception
     */
    override fun uncaughtException(thread: Thread?, exception: Throwable?) {

        if (exception == null || this.crashCallback == null) {

            this.mDefaultHandler.uncaughtException(thread, exception)
        } else {
            crashCallback!!.handleCrashResult(exception, collectDeviceInfo(this.mContext))
        }
    }

    @SuppressLint("WrongConstant")
    fun collectDeviceInfo(mContext: Context): Map<String, String> {

        val deviceInfo = HashMap<String, String>()
        try {
            val manager: PackageManager = mContext.packageManager
            val info: PackageInfo = manager.getPackageInfo(mContext.packageName, 1)
            val versionName = if (info.versionName == null) "null" else info.versionName
            deviceInfo.put("versionName", versionName)
            deviceInfo.put("versionCode", info.versionCode.toString())
        } catch (exception: PackageManager.NameNotFoundException) {
            Log.e("dongyiming", "NameNotFoundException: $exception")
        }

        val var11 = Build::class.java.declaredFields
        val var13 = var11.size

        for (var14 in 0 until var13) {
            val field = var11[var14]
            try {
                field.isAccessible = true
                deviceInfo.put(field.name, field.get(null as Any?).toString())
            } catch (exception: Exception) {
                Log.e("dongyiming", "an error occured when collect crash info : $exception")
            }
        }
        return deviceInfo
    }

}