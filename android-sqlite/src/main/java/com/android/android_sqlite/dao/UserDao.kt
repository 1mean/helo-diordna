package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.User
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface UserDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: MutableList<User>)

    /*delete***************************************************************/
    @Delete
    suspend fun delete(user: User)

    /*update***************************************************************/
    @Update(onConflict = OnConflictStrategy.ABORT)//发生冲突解决办法：终止操作，抛出异常
    suspend fun update(user: User): Int

    /*query****************************************************************/
    @Query("select * from user")
    fun getAll(): Flow<MutableList<User>>//返回Flow和Livedata不需要suspend关键字，编译后内部是Flow和suspend

    @Query("select * from user where userCode=(:userCode)")
    fun getUserByCode(userCode: Int): Flow<User>

    @Query("select * from user where userCode=(:userCode)")
    suspend fun queryUserByCode(userCode: Int): User

    @Query("select * from user where reservedString=(:reservedString)")
    fun getLoginUser(reservedString: String): Flow<User>

    @Query("select * from user where attention=1 limit 0,30")
    fun queryLiveAttentionUsers(): Flow<MutableList<User>>

    @Query("select * from user where attention=1")
    fun queryAllAttentionUsers(): Flow<MutableList<User>>

    @Query("select count(*) from user where attention=1")
    fun queryAllAttentionCounts(): Flow<Int>

    @Query("select userCode from user where attention=1 limit 0,30")
    fun queryLiveAttentionUserCodes(): Flow<MutableList<Int>>

    @Query("select * from user where userName like '%' || :like || '%' limit (:startIndex),(:pageCount)")
    fun queryLikedPageUser(like: String, startIndex: Int, pageCount: Int): Flow<MutableList<User>>

    @Query("select * from user where userName like '%' || :like || '%' limit (:startIndex),(:pageCount)")
    suspend fun getLikedPageUser(like: String, startIndex: Int, pageCount: Int): MutableList<User>
}