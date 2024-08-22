package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.bean.HistoryItem
import com.android.android_sqlite.dao.HistoryDao
import com.android.android_sqlite.entity.History
import com.android.base.utils.TimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * @description: 处理History表相关的数据库操作
 * @author: dongyiming
 * @date: 8/18/24 5:21 PM
 * @version: v1.0
 */
val historyRepository: HistoryRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { HistoryRepository() }

public class HistoryRepository : BaseRepository() {

    private val historyDao: HistoryDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().historyDao()
    }

    suspend fun insert(history: History) {
        withContext(Dispatchers.IO) {
            historyDao.insert(history)
        }
    }

    suspend fun deleteAllHistory(list: MutableList<History>) {
        withContext(Dispatchers.IO) {
            historyDao.deleteAllHistory(list)
        }
    }

    suspend fun deleteAllHistory() {
        withContext(Dispatchers.IO) {
            historyDao.deleteAllHistory()
        }
    }

    fun queryHistoryByPage(startIndex: Int, count: Int): Flow<MutableList<History>> =
        flowIn(historyDao.queryHistoryByPage(startIndex, count))

    fun queryHistoryByCode(code: Int): Flow<History> = flowIn(historyDao.queryHistoryByCode(code))

    suspend fun saveHistory(history: History) {
        withContext(Dispatchers.IO) {
            val localHistory = historyDao.getHistoryByCode(history.code)
            if (localHistory == null) {//不存在的，一定为null
                historyDao.insert(history)
            } else {
                localHistory.lastTime = history.lastTime
                localHistory.playPosition = history.playPosition
                historyDao.update(localHistory)
            }
        }
    }

    suspend fun removeHistory(
        list: MutableList<History>,
        isAll: Boolean
    ): MutableList<HistoryItem> {
        return withContext(Dispatchers.IO) {
            if (isAll) {
                historyDao.deleteAllHistory()
                mutableListOf()
            } else {
                historyDao.deleteAllHistory(list)
                getHistory(0, 21)
            }
        }
    }

    suspend fun getHistory(startIndex: Int, counts: Int): MutableList<HistoryItem> {
        return withContext(Dispatchers.IO) {
            var hasToday = false
            var hasYesterday = false
            var hasolder = false
            val historyList = mutableListOf<HistoryItem>()
            val history = if (startIndex != 0) {//防止下一次的第一条后，又添加一次title，导致title重复了
                historyDao.getHistoryByPage(startIndex - 1, counts)
            } else {
                historyDao.getHistoryByPage(startIndex, counts)
            }
            history.forEachIndexed { index, his ->
                val parseTime = his.lastTime
                val spaceTime = TimeUtils.getSpaceOfTime(parseTime)
                if (startIndex != 0 && index == 0) {//避免重复显示title，拿上一批数据的最后一个来判断
                    if (spaceTime == 0) {
                        hasToday = true
                    } else if (spaceTime == 1) {
                        hasYesterday = true
                    } else if (spaceTime > 1) {
                        hasolder = true
                    }
                } else {
                    if (!hasToday && spaceTime == 0) {
                        historyList.add(0, HistoryItem(type = 1, title = "今天"))
                        hasToday = true
                    } else if (!hasYesterday && spaceTime == 1) {
                        historyList.add(HistoryItem(type = 1, title = "昨天"))
                        hasYesterday = true
                    } else if (!hasolder && spaceTime > 1) {
                        historyList.add(HistoryItem(type = 1, title = "更早"))
                        hasolder = true
                    }
                    val videoUser = historyDao.getVideoUserByCode(his.code)
                    if (videoUser != null) {
                        videoUser.video.user = videoUser.user
                        videoUser.video.videoData = historyDao.getVideoDataByCode(his.code)
                        val historyItem = HistoryItem(his, videoUser.video)
                        historyList.add(historyItem)
                    }
                }
            }
            historyList
        }
    }
}