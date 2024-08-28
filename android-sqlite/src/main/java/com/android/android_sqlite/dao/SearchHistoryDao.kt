package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.SearchHistory
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface SearchHistoryDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE) //发生冲突解决办法：终止操作，抛出异常
    suspend fun insert(history: SearchHistory)

    /*delete***************************************************************/
    @Delete
    suspend fun delete(history: SearchHistory)

    @Delete
    suspend fun deleteAll(list: MutableList<SearchHistory>)

    /*update***************************************************************/
    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(history: SearchHistory)

    /*query****************************************************************/
    //返回的Int值：这个返回值表示被删除的行数。如果没有行被删除，则返回值为0
    @Query("delete from search_history where type=(:type)")
    suspend fun deleteAll(type:Int): Int //deleteAll方法只能返回Int，返回Flow<Int>就会报错

    @Query("select * from search_history where type=(:type) order by updateTime desc limit (:startIndex),(:count)")
    fun querySearchHistoryByPage(
        type: Int,
        startIndex: Int,
        count: Int
    ): Flow<MutableList<SearchHistory>>

    @Query("select * from search_history where type=(:type) order by updateTime desc")
    fun queryAll(type: Int): Flow<MutableList<SearchHistory>>

    @Query("select * from search_history where type=(:type) and reservedString=(:content)")
    suspend fun queryHistoryByContent(type: Int,content: String): SearchHistory?
}