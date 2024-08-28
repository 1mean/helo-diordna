package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.dao.SearchHistoryDao
import com.android.android_sqlite.entity.SearchHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

/**
 * @description: 处理History表相关的数据库操作
 * @author: dongyiming
 * @date: 8/18/24 5:21 PM
 * @version: v1.0
 */
val searchHistoryRepository: SearchHistoryRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SearchHistoryRepository() }

public class SearchHistoryRepository : BaseRepository() {

    private val searchHistoryDao: SearchHistoryDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().searchHistoryDao()
    }

    suspend fun insert(history: SearchHistory) {
        withContext(Dispatchers.IO) {
            history.reservedString?.let { content ->
                val localHistory = searchHistoryDao.queryHistoryByContent(history.type, content)
                if (localHistory == null) {
                    searchHistoryDao.insert(history)
                } else {
                    localHistory.updateTime = System.currentTimeMillis()
                    searchHistoryDao.update(localHistory)
                }
            }
        }
    }

    suspend fun deleteAllHistory(list: MutableList<SearchHistory>) {
        withContext(Dispatchers.IO) {
            searchHistoryDao.deleteAll(list)
        }
    }

    fun deleteAllHistory(type: Int): Flow<Int> = flow {
        emit(searchHistoryDao.deleteAll(type))
    }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO)

    fun queryHistoryByPage(
        type: Int,
        startIndex: Int,
        count: Int
    ): Flow<MutableList<SearchHistory>> =
        flowIn(searchHistoryDao.querySearchHistoryByPage(type, startIndex, count))

    fun queryAll(type: Int): Flow<MutableList<SearchHistory>> =
        flowIn(searchHistoryDao.queryAll(type))

}