package com.android.android_sqlite.manager

import android.util.Log
import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.dao.GroupDao
import com.android.android_sqlite.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

    fun getGroups1(): Flow<MutableList<Group>> = groupDao.queryAllGroups().map {
        if (it.isEmpty()) {//群组为空
            val newGroup = Group().apply {
                groupName = "默认收藏夹"
                createTime = System.currentTimeMillis()
                updateTime = System.currentTimeMillis()
            }
            val result = groupDao.insert(newGroup)
            if (result >= 1) {
                delay(1000)
                val defaultGroup = groupDao.queryGroupByName("默认收藏夹")
                if (defaultGroup != null) {
                    it.add(defaultGroup)
                }
            }
        }
        it
    }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO)

    /**
     * 上面getGroups1()有bug，会在viewmodel里collect里收到两次emit的数据
     */
    suspend fun getGroups(): MutableList<Group> {
        return withContext(Dispatchers.IO) {
            groupDao.getAllGroups().apply {
                if (isEmpty()) {//群组为空
                    val newGroup = Group().apply {
                        groupName = "默认收藏夹"
                        createTime = System.currentTimeMillis()
                        updateTime = System.currentTimeMillis()
                    }
                    val result = groupDao.insert(newGroup)
                    if (result >= 1) {
                        val defaultGroup = groupDao.queryGroupByName("默认收藏夹")
                        if (defaultGroup != null) {
                            add(defaultGroup)
                        }
                    }
                } else {
                    forEach {
                        it.videoCounts = groupDao.queryGroupItemCounts(it.id)
                    }
                }
            }
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

    /**
     * 考虑有可能是自动创建的默认收藏夹，需要我们为这个收藏夹添加背景图
     */
    private fun addGroupItem(videoCode: Int, group: Group): Flow<String> = flow {
        val groupItem = groupDao.queryGroupItem(group.id, videoCode)
        if (groupItem == null) {
            val result =
                groupDao.insert(GroupVideoItem(groupCode = group.id, videoCode = videoCode))
            if (result > 0) {
                emit("已加入\"${group.groupName}\"")
            } else {
                emit("收藏失败!!")
            }
        } else {
            emit("")
        }
    }.catch { e -> e.printStackTrace() }.flowOn(Dispatchers.IO)

    /**
     * 添加到其他常规群组
     */
    private suspend fun insertGroupItem(videoCode: Int, groupId: Int): String {
        return withContext(Dispatchers.IO) {
            val groupItem = groupDao.queryGroupItem(groupId, videoCode)
            if (groupItem == null) {
                val newGroupItem = GroupVideoItem(
                    groupCode = groupId,
                    videoCode = videoCode,
                    createTime = System.currentTimeMillis(),
                    updateTime = System.currentTimeMillis()
                )
                groupDao.insert(newGroupItem)
                "已添加成功"
            } else {//已经在该组里面了，还添加
                "不支持重复加入收藏夹"
            }
        }
    }

    /**
     * 1,直接点击收藏，往默认收藏夹里添加视频
     *  - 没有默认收藏夹，创建默认收藏夹
     *  - 有默认收藏夹，直接添加即可
     * 2,长按后，再点击group列表进行添加
     *  - 默认收藏夹只是空壳子，需要我们往里面添加新的cover
     */
    suspend fun insertGroupItem(petVideo: PetVideo, group: Group?): String {
        if (group == null) {//直接点击收藏，往默认收藏夹里添加视频
            return insertDefaultGroupItem(petVideo.code, petVideo.cover)
        } else {//长按后，再点击group列表进行添加
            if (group.groupCover == null) {//添加封面
                group.groupCover = petVideo.cover
            }
            group.updateTime = System.currentTimeMillis()
            groupDao.update(group)

            val groupItem = groupDao.queryGroupItem(group.id, petVideo.code)
            if (groupItem == null) {
                val newGroupItem = GroupVideoItem(
                    groupCode = group.id,
                    videoCode = petVideo.code,
                    createTime = System.currentTimeMillis(),
                    updateTime = System.currentTimeMillis()
                )
                groupDao.insert(newGroupItem)
                addVideoData(petVideo.code)
                return "已添加到${group.groupName}"
            } else {//已经在该组里面了，还添加
                return "不支持重复加入收藏夹"
            }
        }
    }

    /**
     * 往默认收藏夹里添加视频
     * - 没有默认收藏夹：创建默认收藏夹
     * - 有默认收藏夹：直接添加
     */
    private suspend fun insertDefaultGroupItem(videoCode: Int, coverUrl: String?): String {
        val group = groupDao.queryGroupByName("默认收藏夹")
        if (group == null) {//创建默认收藏夹
            val newGroup = Group().apply {
                groupName = "默认收藏夹"
                createTime = System.currentTimeMillis()
                updateTime = System.currentTimeMillis()
                groupCover = coverUrl
            }
            val result = groupDao.insert(newGroup)
            if (result >= 1) {//添加成功
                val defaultGroup = groupDao.queryGroupByName("默认收藏夹")
                defaultGroup?.let {
                    groupDao.insert(
                        GroupVideoItem(
                            groupCode = it.id,
                            videoCode = videoCode,
                            createTime = System.currentTimeMillis(),
                            updateTime = System.currentTimeMillis()
                        )
                    )
                }
                addVideoData(videoCode)
                return "收藏成功"
            } else {
                return "添加失败，请重新收藏"
            }
        } else {
            groupDao.insert(
                GroupVideoItem(
                    groupCode = group.id,
                    videoCode = videoCode,
                    createTime = System.currentTimeMillis(),
                    updateTime = System.currentTimeMillis()
                )
            )
            addVideoData(videoCode)
            return "收藏成功"
        }
    }

    /**
     * 只要点击取消收藏，就把所有收藏都取消
     * - 有个问题：当视频取消后，而收藏夹的封面还是该视频时，应该修改
     *      - 每次删除视频后，都必须更新一下封面图，确保封面图是最早一个视频的cover
     * - 但是，抖音是只要这个群组被创建，就用第一次创建的cover当封面，永远不变，不论该视频是否被删除
     */
    suspend fun removeGroupItemByCode(videoCode: Int): String {
        return withContext(Dispatchers.IO) {
            val int = groupDao.deleteCollectVideo(videoCode)
//            val groupItems = groupDao.queryGroupItem(videoCode)//当前视频被收藏在多个组里
//            groupItems.forEach { groupItem ->
//                //1，清理掉这个收藏组里的这个item数据
//                groupDao.deleteGroupItem(videoCode, groupItem.groupCode)
//                //2，看看这个群组里还有几个数据
//                val count = groupDao.queryGroupItemCounts(groupItem.groupCode)
//                //3，如果群组没有数据，把
//                if (count == 0) {
//                }
//            }
            removeVideoData(videoCode)
            if (int >= 1) {
                "已取消收藏"
            } else {
                "取消收藏失败"
            }
        }
    }

    suspend fun removeAll() {
        withContext(Dispatchers.IO) {
            groupDao.deleteAllGroup()
            groupDao.deleteAllGroupItems()
        }
    }

    /**
     * 重名的群组是允许的，id不同就行
     */
    suspend fun createNewGroupAndIn(group: Group, videoCode: Int): String {
        return withContext(Dispatchers.IO) {
            val result = groupDao.insert(group)
            if (result >= 1) {
                val lastGroup = groupDao.queryLastGroup()
                lastGroup?.let {
                    Log.e("1mean", "last group: name=${it.groupName}")
                    Log.e("1mean", "last group: id=${it.id}")
                    val newGroupItem = GroupVideoItem(
                        groupCode = it.id,
                        videoCode = videoCode,
                        createTime = System.currentTimeMillis(),
                        updateTime = System.currentTimeMillis()
                    )
                    groupDao.insert(newGroupItem)
                }
            }
            addVideoData(videoCode)
            "已添加到${group.groupName}"
        }
    }

    private suspend fun addVideoData(videoCode: Int) {
        val vd = groupDao.queryVideoDataByCode(videoCode)
        if (vd != null) {
            vd.collect = true
            vd.collectTime = System.currentTimeMillis()
            vd.collects += 1
            groupDao.update(vd)
        } else {
            val newVideoData = VideoData(
                videoCode = videoCode,
                collect = true,
                collects = 1,
                collectTime = System.currentTimeMillis()
            )
            groupDao.insert(newVideoData)
        }
    }

    private suspend fun removeVideoData(videoCode: Int) {
        val vd = groupDao.queryVideoDataByCode(videoCode)
        if (vd != null) {
            vd.collect = false
            if (vd.collects >= 1) {
                vd.collects -= 1
            }
            vd.collectTime = System.currentTimeMillis()
            groupDao.update(vd)
        }
    }
}