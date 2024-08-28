package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.dao.GroupDao
import com.android.android_sqlite.entity.Group
import com.android.android_sqlite.entity.GroupItemAndVideo
import com.android.android_sqlite.entity.GroupVideoItem
import com.android.android_sqlite.entity.PetVideo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
val groupRepository: GroupRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { GroupRepository() }

public class GroupRepository : BaseRepository() {

    private val groupDao: GroupDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().groupDao()
    }

    suspend fun insert(groupVideoItem: GroupVideoItem) {
        withContext(Dispatchers.IO) {
            groupDao.insert(groupVideoItem)
        }
    }

    suspend fun insert(group: Group) {
        withContext(Dispatchers.IO) {
            groupDao.insert(group)
        }
    }

    suspend fun delete(groupItem: GroupVideoItem) {
        withContext(Dispatchers.IO) {
            groupDao.delete(groupItem)
        }
    }

    suspend fun delete(group: Group) {
        withContext(Dispatchers.IO) {
            groupDao.delete(group)
        }
    }

    suspend fun update(group: Group) {
        withContext(Dispatchers.IO) {
            groupDao.update(group)
        }
    }

    suspend fun update(groupItem: GroupVideoItem) {
        withContext(Dispatchers.IO) {
            groupDao.update(groupItem)
        }
    }

    suspend fun deleteGroupItems(groupCode: Int) {
        withContext(Dispatchers.IO) {
            groupDao.deleteGroupItems(groupCode)
        }
    }

    fun queryGroupByCode(groupCode: Int): Flow<Group?> =
        flowIn(groupDao.queryGroupByCode(groupCode))

    fun queryMaxGroupCode(): Flow<String?> = flowIn(groupDao.queryMaxGroupCode())

    fun queryAllGroups(): Flow<MutableList<Group>> = flowIn(groupDao.queryAllGroups())

    fun queryGroupItems(groupCode: Int): Flow<MutableList<GroupVideoItem>> =
        flowIn(groupDao.queryGroupItems(groupCode))

    fun queryGroupItemsByPage(
        groupCode: Int,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<GroupVideoItem>> =
        flowIn(groupDao.queryGroupItemsByPage(groupCode, startIndex, counts))

//    fun queryGroupItemsAndVideos(
//        groupCode: Int,
//        startIndex: Int,
//        counts: Int
//    ): Flow<MutableList<GroupItemAndVideo>> =
//        flowIn(groupDao.queryGroupItemsAndVideos(groupCode, startIndex, counts))

    suspend fun createGroup(groupName: String, groupDesc: String, isOpen: Boolean): Boolean {

        return withContext(Dispatchers.IO) {
            val maxCode = groupDao.getMaxGroupCode()
            val currentGroupCode = if (maxCode.isNullOrEmpty()) {
                0
            } else {
                maxCode.toInt() + 1
            }
            val group = Group(
                groupName = groupName,
                groupDesc = groupDesc,
                open = isOpen,
                groupCode = currentGroupCode,
                createTime = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                creatorCode = 1074309089//Appinfos.AUTHOR_ID
            )
            groupDao.insert(group)
            delay(1000)
            true
        }
    }

    suspend fun removeGroup(groupCode: Int): Boolean {

        return withContext(Dispatchers.IO) {

            val group = groupDao.getGroupByCode(groupCode)
            group?.let {
                groupDao.delete(it)
                groupDao.deleteGroupItems(it.groupCode)
            }
            delay(1000)
            true
        }
    }

    fun getGroups(): Flow<MutableList<Group>> = flowIn(groupDao.queryAllGroups())

    suspend fun getCollects(): MutableList<Group> {
        return withContext(Dispatchers.IO) {
            val groupInfos = groupDao.queryGroupNoType(99)
            val group = groupDao.queryGroupByType(99)
            group?.let {
                groupInfos.add(0, it)
            }

            if (groupInfos.isNotEmpty()) {
                groupInfos.forEach {
                    val counts = groupDao.queryGroupItemCounts(it.groupCode)
                    if (counts > 0) {
                        it.videoCounts = counts
                        val topItem = groupDao.queryGroupItemsAndVideo(it.groupCode)
                        it.groupCover = topItem.video.cover
                    }
                }
            }
            groupInfos
        }
    }

    suspend fun getPageGroupItems(
        groupCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> = withContext(Dispatchers.IO) {
        mutableListOf<PetVideo>().apply {
            val items = groupDao.queryGroupItemsAndVideos(groupCode, startIndex, counts)
            if (items.isNotEmpty()) {
                items.forEach {
                    val video = it.video
                    video.user = groupDao.getUserByCode(video.authorId)
                    video.videoData = groupDao.queryVideoDataByCode(video.code)
                    add(video)
                }
            }
        }
    }

    suspend fun addCollection(groupName: String, videoCode: Int) {
        withContext(Dispatchers.IO) {
            val group = groupDao.queryGroupByName(groupName)
            group?.let {
                val item = groupDao.queryGroupItem(it.groupCode, videoCode)
                if (item == null) {
                    val groupItem = GroupVideoItem(groupCode = it.groupCode, videoCode = videoCode)
                    groupDao.insert(groupItem)
                }
                val counts = groupDao.queryGroupItemCounts(it.groupCode)
                it.updateTime = System.currentTimeMillis()
                it.videoCounts = counts
                groupDao.update(it)
            }

            if (group == null) {

                val maxCode = groupDao.getMaxGroupCode()
                val currentGroupCode = if (maxCode.isNullOrEmpty()) {
                    0
                } else {
                    maxCode.toInt() + 1
                }
                val groupInfo = Group().apply {
                    groupCode = currentGroupCode
                    this.groupName = groupName
                    videoCounts = 1
                    createTime = System.currentTimeMillis()
                    updateTime = System.currentTimeMillis()
                    creatorCode = 1074309089//Appinfos.AUTHOR_ID
                    type = 99
                }
                groupDao.insert(groupInfo)

                val item = groupDao.queryGroupItem(currentGroupCode, videoCode)
                if (item == null) {
                    val groupItem =
                        GroupVideoItem(groupCode = currentGroupCode, videoCode = videoCode)
                    groupDao.insert(groupItem)
                }
            }
        }
    }

    suspend fun deleteCollection(groupName: String, videoCode: Int) {
        withContext(Dispatchers.IO) {
            val group = groupDao.queryGroupByName(groupName)
            group?.let {
                val item = groupDao.queryGroupItem(it.groupCode, videoCode)
                item?.let { groupItem ->
                    groupDao.delete(groupItem)
                    it.videoCounts = groupDao.queryGroupItemCounts(it.groupCode)
                    it.updateTime = System.currentTimeMillis()
                    groupDao.update(it)
                }
            }
        }
    }

    fun addGroupItem(videoCode: Int, group: Group): Flow<String> = flow {
        val groupItem = groupDao.queryGroupItem(group.groupCode, videoCode)
        if (groupItem == null) {
            val result =
                groupDao.insert(GroupVideoItem(groupCode = group.groupCode, videoCode = videoCode))
            if (result > 0) {
                emit("已加入\"${group.groupName}\"")
            } else {
                emit("收藏失败!!")
            }
        } else {
            emit("")
        }
    }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO)
}