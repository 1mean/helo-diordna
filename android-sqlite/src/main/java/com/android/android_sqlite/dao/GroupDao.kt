package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.entity.*
import kotlinx.coroutines.flow.Flow

/**
 * @description: UserDao
 * @author: dongyiming
 * @date: 7/29/24 11:27 AM
 * @version: v1.0
 */
@Dao
public interface GroupDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(groupVideoItem: GroupVideoItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(group: Group): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(videoData: VideoData)

    /*delete***************************************************************/
    @Delete
    suspend fun delete(groupItem: GroupVideoItem)

    @Delete
    suspend fun delete(group: Group)

    /*update***************************************************************/
    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(group: Group)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(videoData: VideoData)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(groupItem: GroupVideoItem)

    /*query****************************************************************/

    @Query("delete from group_item where groupCode=(:groupCode)")
    suspend fun deleteGroupItems(groupCode: Int)

    @Query("delete from group_info")
    suspend fun deleteAllGroup()

    @Query("delete from group_item")
    suspend fun deleteAllGroupItems()

    @Query("delete from group_item where groupCode=(:id) and videoCode=(:videoCode)")
    suspend fun deleteGroupItem(videoCode: Int, id: Int)

    /**
     * 返回的Int：有几个数据返回几个，有一个videoCode的数据返回1，有两个videoCode的数据返回2
     */
    @Query("delete from group_item where videoCode=(:videoCode)")
    suspend fun deleteCollectVideo(videoCode: Int): Int

    @Query("select * from group_info where groupName=(:name)")
    suspend fun queryGroupByName(name: String): Group?

    @Query("select * from group_info where id=(:groupCode)")
    fun queryGroupByCode(groupCode: Int): Flow<Group?>

    @Query("select * from group_info where id=(:groupCode)")
    suspend fun getGroupByCode(groupCode: Int): Group?

    @Query("select * from group_item where groupCode=(:id) and videoCode=(:videoCode)")
    suspend fun queryGroupItem(id: Int, videoCode: Int): GroupVideoItem?

    @Query("select * from group_item where videoCode=(:videoCode)")
    suspend fun queryGroupItem(videoCode: Int): MutableList<GroupVideoItem>

    @Query("select max(groupCode) from group_info")
    fun queryMaxGroupCode(): Flow<String?>

    @Query("select max(groupCode) from group_info")
    suspend fun getMaxGroupCode(): String

    @Query("select count(*) from group_item where groupCode=(:id)")
    suspend fun queryGroupItemCounts(id: Int): Int

    @Query("select * from group_info order by createTime asc")
    fun queryAllGroups(): Flow<MutableList<Group>>

    @Query("select * from group_info order by createTime asc")
    suspend fun getAllGroups(): MutableList<Group>

    @Query("select * from group_info where type=(:type)")
    suspend fun queryGroupByType(type: Int): Group?

    @Query("select * from group_info where type!=(:type) order by createTime asc")
    suspend fun queryGroupNoType(type: Int): MutableList<Group>

    @Query("select * from group_item where groupCode=(:id)")
    fun queryGroupItems(id: Int): Flow<MutableList<GroupVideoItem>>

    @Query("select * from group_info order by createTime desc limit 1")
    suspend fun queryLastGroup(): Group?

    @Query("select * from group_item where groupCode=(:id) order by id desc limit (:startIndex),(:counts)")
    fun queryGroupItemsByPage(
        id: Int,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<GroupVideoItem>>

    @Transaction
    @Query("select * from group_item where groupCode=(:id) order by id desc limit (:startIndex),(:counts)")
    suspend fun queryGroupItemsAndVideos(
        id: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<GroupItemAndVideo>

    @Transaction
    @Query("select * from group_item where groupCode=(:id) order by id desc limit 1")
    suspend fun queryGroupItemsAndVideo(id: Int): GroupItemAndVideo

    @Query("select * from user where userCode=(:userCode)")
    suspend fun getUserByCode(userCode: Int): User?

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun queryVideoDataByCode(code: Int): VideoData?
}