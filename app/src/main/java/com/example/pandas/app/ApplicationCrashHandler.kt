package com.example.pandas.app

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Process
import android.util.Log
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.TimeUtils
import java.io.*

/**
 * @description: ApplicationCrashHandler
 * @author: dongyiming
 * @date: 3/24/22 2:35 下午
 * @version: v1.0
 */
val CrashHandler: ApplicationCrashHandler by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ApplicationCrashHandler() }

public class ApplicationCrashHandler() :
    Thread.UncaughtExceptionHandler {

    private var mContext: Context? = null

    //private var context: Context? = null
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null

    private val LOG_DIR = "log"

    fun init(context: Context) {
        mContext = context.applicationContext
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * @param:
     * @author: dongyiming
     * @date: 3/24/22 7:45 下午
     * @version: v1.0
     */
    override fun uncaughtException(t: Thread, e: Throwable) {

        try {
            saveInFiles(e)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        e.printStackTrace()
        if (mDefaultHandler != null) {
            mDefaultHandler?.uncaughtException(t, e)
        } else {
            Process.killProcess(Process.myPid())
        }
    }

    //目录：File/log/
    private fun saveInFiles(ex: Throwable) {

        val localFile = FileUtils.getExternalFileDirectory(mContext!!, "")//File目录
        localFile?.let {
            val logPath =
                StringBuilder(it.absolutePath).append(File.separator).append(LOG_DIR).toString()
            val logFile = File(logPath)
            if (!logFile.exists()) {
                logFile.mkdirs()
            }
            val currentDate = TimeUtils.getCurrentDate()
            val crashPath =
                StringBuilder(logPath).append(File.separator).append(currentDate).append(".txt")
                    .toString()
            val crashFile = File(crashPath)
            if (!crashFile.exists()) {
                val isSuccess = crashFile.createNewFile()
                if (isSuccess) {
                    writeLogcat(crashFile, ex)
                }
            }
        }
    }

    private fun writeLogcat(file: File, ex: Throwable) {

        try {
            val writer = BufferedWriter(FileWriter(file))
            val pw = PrintWriter(writer)

            val pm = mContext?.packageManager
            val pi = pm?.getPackageInfo(mContext?.packageName!!, PackageManager.GET_ACTIVITIES)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                pw.print("App Version: ${pi?.versionName + "_" + pi?.longVersionCode}")
            }
            pw.also {
                print("OS Version: ${Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT}")
                print("Vendor: ${Build.MANUFACTURER}")//手机制造商
                print("Model: ${Build.MODEL}")//手机型号
                print("CPU ABI: ${Build.SUPPORTED_ABIS}")//CPU架构
                println()
            }
            ex.printStackTrace(pw)
            pw.println()
            pw.close()
        } catch (ex: Exception) {
            Log.d(AppInfos.DEBUG_LOG_TAG, "failed to save crash logs")
        }
    }
}