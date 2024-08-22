package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.History
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.entity.VideoData
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface HistoryDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE) //发生冲突解决办法：终止操作，抛出异常
    suspend fun insert(history: History)

    /*delete***************************************************************/
    @Delete
    suspend fun delete(history: History)

    @Delete
    suspend fun deleteAllHistory(list: MutableList<History>)

    /*update***************************************************************/
    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(history: History)

    /*query****************************************************************/
    @Query("delete from history")
    suspend fun deleteAllHistory()

    @Query("select * from history order by lastTime desc limit (:startIndex),(:count)")
    fun queryHistoryByPage(startIndex: Int, count: Int): Flow<MutableList<History>>

    @Query("select * from history order by lastTime desc limit (:startIndex),(:count)")
    suspend fun getHistoryByPage(startIndex: Int, count: Int): MutableList<History>

    @Query("select * from history where code=(:code)")
    fun queryHistoryByCode(code: Int): Flow<History>

    @Query("select * from history where code=(:code)")
    suspend fun getHistoryByCode(code: Int): History

    @Transaction
    @Query("select * from pet_video where code=(:videoCode)")
    suspend fun getVideoUserByCode(videoCode: Int): VideoAndUser

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun getVideoDataByCode(code: Int): VideoData
}