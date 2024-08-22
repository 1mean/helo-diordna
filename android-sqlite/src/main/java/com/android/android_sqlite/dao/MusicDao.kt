package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.MusicVo
import com.android.android_sqlite.entity.VideoAndUser
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface MusicDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(songs: MutableList<MusicVo>)

    /*delete***************************************************************/
    @Delete
    fun delete(list: MutableList<MusicVo>)

    /*query****************************************************************/
    @Query("select * from music where type=(:type) limit (:startIndex),(:count)")
    suspend fun queryMusicByPage(type: Int, startIndex: Int, count: Int): MutableList<MusicVo>

    @Query("select * from music where type=(:type) order by random()")
    suspend fun queryRandomMusic(type: Int): MusicVo

    @Query("select * from music where type=0 and fileName=(:fileName)")
    suspend fun queryMusicByFileName(fileName: String): MusicVo

    @Query("select * from music where type=0")
    suspend fun queryAllMusic(): MutableList<MusicVo>

    @Query("select count(*) from music")
    fun queryMusicCounts(): Flow<Int>

    @Transaction
    @Query("select * from pet_video where type=(:type) limit (:startIndex),(:count)")
    suspend fun queryVideosByVideoType(
        type: Int,
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>
}