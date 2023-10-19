package com.example.pandas.utils

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

}