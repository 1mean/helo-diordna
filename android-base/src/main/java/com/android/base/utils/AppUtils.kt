package com.android.base.utils

import android.app.Activity
import android.app.usage.StorageStats
import android.app.usage.StorageStatsManager
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Process
import android.os.UserHandle
import android.os.storage.StorageManager
import android.os.storage.StorageVolume
import android.provider.Settings
import android.text.format.Formatter
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.IOException
import java.util.*

object AppUtils {

    private val mActivityList = LinkedList<Activity>()

    @RequiresApi(api = Build.VERSION_CODES.O)
    fun getAppCache(context: Context): String {
        if (!hasUsageStatsPermission(context)) {
            requestAppUsagePermission(context)
        } else {
            val packageName = context.packageName
            val storageStatsManager =
                context.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager
            val storageManager =
                context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
            val storageVolumes: List<StorageVolume> = storageManager.storageVolumes
            val user: UserHandle = Process.myUserHandle()
            try {
                for (storageVolume in storageVolumes) {
                    val uuidStr: String? = storageVolume.getUuid()
                    val uuid =
                        if (uuidStr == null) StorageManager.UUID_DEFAULT else UUID.fromString(
                            uuidStr
                        )
                    val storageStats =
                        storageStatsManager.queryStatsForPackage(uuid, packageName, user)
                    return Formatter.formatShortFileSize(context, storageStats.cacheBytes)
                }
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return ""
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    fun getAppSize(context: Context, packageName: String) {
        if (!hasUsageStatsPermission(context)) {
            requestAppUsagePermission(context)
        } else {
            Thread {
                val storageStatsManager: StorageStatsManager =
                    context.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager
                val storageManager: StorageManager =
                    context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
                val storageVolumes: List<StorageVolume> = storageManager.storageVolumes
                val user: UserHandle = Process.myUserHandle()
                try {
                    for (storageVolume in storageVolumes) {
                        val uuidStr: String? = storageVolume.getUuid()
                        val uuid =
                            if (uuidStr == null) StorageManager.UUID_DEFAULT else UUID.fromString(
                                uuidStr
                            )
                        Log.d(
                            "AppLog",
                            "storage:" + uuid + " : " + storageVolume.getDescription(context) + " : " + storageVolume.getState()
                        )
                        Log.d(
                            "AppLog",
                            "getFreeBytes:" + Formatter.formatShortFileSize(
                                context,
                                storageStatsManager.getFreeBytes(uuid)
                            )
                        )
                        Log.d(
                            "AppLog",
                            "getTotalBytes:" + Formatter.formatShortFileSize(
                                context,
                                storageStatsManager.getTotalBytes(uuid)
                            )
                        )
                        val storageStats: StorageStats =
                            storageStatsManager.queryStatsForPackage(uuid, packageName, user)
                        Log.d("AppLog", "storage stats for app of package name:$packageName : ")
                        Log.d(
                            "AppLog",
                            "getAppBytes:" + Formatter.formatShortFileSize(
                                context,
                                storageStats.appBytes
                            ).toString() + " getCacheBytes:" + Formatter.formatShortFileSize(
                                context,
                                storageStats.cacheBytes
                            ).toString() + " getDataBytes:" + Formatter.formatShortFileSize(
                                context,
                                storageStats.dataBytes
                            )
                        )
                    }
                } catch (e: PackageManager.NameNotFoundException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }

    private fun hasUsageStatsPermission(context: Context): Boolean {
        var usageStatsManager: UsageStatsManager? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            usageStatsManager =
                context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        }
        if (usageStatsManager == null) {
            return false
        }
        val currentTime = System.currentTimeMillis()
        // try to get app usage state in last 2 min
        val stats: List<UsageStats> = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            currentTime - 2 * 60 * 1000,
            currentTime
        )
        return stats.isNotEmpty()
    }

    private fun requestAppUsagePermission(context: Context) {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e("AppLog", "Start usage access settings activity fail!", e)
        }
    }

    /**
     * Exit the application.
     */
    fun exitApp() {
        finishAllActivities(false)
        System.exit(0)
    }

    /**
     * Finish all of activities.
     *
     * @param isLoadAnim True to use animation for the outgoing activity, false otherwise.
     */
    fun finishAllActivities(isLoadAnim: Boolean) {

        val activityList = getActivityList()
        for (act in activityList) {
            // sActivityList remove the index activity at onActivityDestroyed
            act.finish()
            if (!isLoadAnim) {
                act.overridePendingTransition(0, 0)
            }
        }
    }

    fun getActivityList(): List<Activity> {
        if (!mActivityList.isEmpty()) {
            return LinkedList(mActivityList)
        }
        val reflectActivities: List<Activity> = getActivitiesByReflect()
        mActivityList.addAll(reflectActivities)
        return LinkedList(mActivityList)
    }

    /**
     * @return the activities which topActivity is first position
     */
    private fun getActivitiesByReflect(): List<Activity> {
        val list = LinkedList<Activity>()
        var topActivity: Activity? = null
        try {
            val activityThread: Any? = getActivityThread()
            val mActivitiesField = activityThread?.javaClass?.getDeclaredField("mActivities")
            mActivitiesField?.isAccessible = true
            val mActivities = mActivitiesField?.get(activityThread) as? Map<*, *>
                ?: return list
            val binder_activityClientRecord_map = mActivities as Map<Any, Any>
            for (activityRecord in binder_activityClientRecord_map.values) {
                val activityClientRecordClass: Class<*> = activityRecord.javaClass
                val activityField = activityClientRecordClass.getDeclaredField("activity")
                activityField.isAccessible = true
                val activity = activityField[activityRecord] as Activity
                if (topActivity == null) {
                    val pausedField = activityClientRecordClass.getDeclaredField("paused")
                    pausedField.isAccessible = true
                    if (!pausedField.getBoolean(activityRecord)) {
                        topActivity = activity
                    } else {
                        list.add(activity)
                    }
                } else {
                    list.add(activity)
                }
            }
        } catch (e: Exception) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.message)
        }
        if (topActivity != null) {
            list.addFirst(topActivity)
        }
        return list
    }

    private fun getActivityThread(): Any? {
        val activityThread: Any? = getActivityThreadInActivityThreadStaticField()
        return activityThread ?: getActivityThreadInActivityThreadStaticMethod()
    }

    private fun getActivityThreadInActivityThreadStaticField(): Any? {
        return try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val sCurrentActivityThreadField =
                activityThreadClass.getDeclaredField("sCurrentActivityThread")
            sCurrentActivityThreadField.isAccessible = true
            sCurrentActivityThreadField[null]
        } catch (e: java.lang.Exception) {
            Log.e(
                "UtilsActivityLifecycle",
                "getActivityThreadInActivityThreadStaticField: " + e.message
            )
            null
        }
    }

    private fun getActivityThreadInActivityThreadStaticMethod(): Any? {
        return try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            activityThreadClass.getMethod("currentActivityThread").invoke(null)
        } catch (e: java.lang.Exception) {
            Log.e(
                "UtilsActivityLifecycle",
                "getActivityThreadInActivityThreadStaticMethod: " + e.message
            )
            null
        }
    }
}