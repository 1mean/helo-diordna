package com.android.android_sqlite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("select * from user")
    fun getAll(): Flow<MutableList<User>>//Flow不需要suspend关键字
}