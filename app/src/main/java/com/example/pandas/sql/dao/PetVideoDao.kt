package com.example.pandas.sql.dao

import androidx.room.*
import com.example.pandas.bean.CoverDownLoad
import com.example.pandas.bean.HeaderDownLoad
import com.example.pandas.bean.SearchInfo
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.*
import com.google.common.graph.MutableNetwork

/**
 * @description:
 * @author: dongyiming
 * @date: 2022/1/11 12:09 上午
 * @version: v1.0
 */
@Dao
interface PetVideoDao {

    /* -----------增------------------------------------- */

    @Insert(onConflict = OnConflictStrategy.REPLACE) //发生冲突解决办法：终止操作，抛出异常
    fun insert(video: PetVideo)

    @Insert(onConflict = OnConflictStrategy.REPLACE) //发生冲突解决办法：终止操作，抛出异常
    fun insertHistory(history: History)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: MutableList<PetVideo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusics(songs: MutableList<MusicVo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: MutableList<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comments: MutableList<VideoComment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideoData(videoData: VideoData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroupItem(groupVideoItem: GroupVideoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroupInfo(groupInfo: Group)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: VideoComment): Long

    /* -----------删------------------------------------- */

    @Delete
    fun delete(video: PetVideo)

    @Delete
    fun deleteGroupItem(groupItem: GroupVideoItem)

    @Delete
    fun deleteGroup(group: Group)

    @Delete
    fun deleteAll(list: MutableList<PetVideo>)

    @Delete
    fun deleteAllMusic(list: MutableList<MusicVo>)

    @Delete
    fun deleteAllVideoData(list: MutableList<VideoData>)

    @Delete
    fun deleteVideoData(videoData: VideoData)

    @Delete
    fun deleteAllComments(list: MutableList<VideoComment>)

    @Query("delete from comment where videoCode=(:videoCode) and commentId=(:commentId)")
    fun deleteComment(videoCode: Int, commentId: Int)

    @Delete
    fun deleteComment(comment: VideoComment)

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("delete from history")
    suspend fun deleteAllHistory()

    @Query("delete from group_item where groupCode=(:groupCode)")
    fun deleteGroupItems(groupCode: Int)

    @Delete
    suspend fun deleteAllHistory(list: MutableList<History>)


    /* -----------更新------------------------------------- */

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun update(video: PetVideo)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateAll(list: MutableList<PetVideo>)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateHistory(history: History)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun updateVideoComment(videoComment: VideoComment)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateVideoData(data: VideoData)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateGroupInfo(group: Group)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun updateUser(user: User)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateGroupItem(groupItem: GroupVideoItem)

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updatePetVideo(video: PetVideo)

    /* -----------查------------------------------------- */
    //如果查询多个结果返回的数据类不是数据实体类，无需给 Room 解析对应数据表，也无需添加 @Entity 注解
    //Room不允许在UI线程中访问数据库，而造成ui卡顿，需要将查询操作定义成异步，通过不同框架的集成

    /**
     * 数据库查询可分为三类
     *  - 一次性写查询：往数据库中插入、更新或者删除数据
     *         - kotlin：Coroutines（suspend）:添加suspend关键字后就不能在主线程调用，否则报错
     *         - RxJava：Single, Maybe, Completable
     *  - 一次性读查询：单次从数据库读取数据，并且返回查询执行时数据库快照对应的结果
     *         - kotlin：Coroutines（suspend）
     *         - RxJava：Single, Maybe
     *  - 观察者读查询：每次底层数据库表发生变更时，从数据库中读取新数据，并用新数据体现这些变更
     *         - kotlin：Flow
     *         - RxJava：Flowable, Publisher, Observable
     *         - Jetpack Lifecycle：LiveData
     */

    @Query("select * from pet_video")
    fun getAll(): MutableList<PetVideo>

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun queryVideoDataByCode(code: Int): VideoData?

    @Query("select * from video_data where videoCode=(:code)")
    fun queryVideoDataByCode2(code: Int): VideoData

    @Query("select * from comment where commentId=(:commentId) and videoCode=(:videoCode)")
    fun queryCommentById(videoCode: Int, commentId: Int): VideoComment

    @Query("select * from comment where id=(:commentId)")
    suspend fun queryCommentById(commentId: Int): VideoComment

    @Query("select * from comment where videoCode=(:videoCode)")
    fun queryCommentByVideoCode(videoCode: Int): MutableList<VideoComment>

    /**
     *  这里编译一直失败，记录一下，下面四条为stack overflow上的普遍解决办法
     *    - 报错 Room "Not sure how to convert a Cursor to this method's return type"
     *    - 解决办法无非都是suspend和Flow/LiveData不能同时用，但是
     *     - 使用 suspend fun queryByPage(page: Int): ArrayList<PetViewData> 编译失败
     *     - 使用 fun queryByPage(page: Int): Flow<ArrayList<PetViewData>> 编译失败
     *     - 使用 fun queryByPage(page: Int): LiveData<ArrayList<PetViewData>> 编译失败
     *     - 使用 fun queryByPage(page: Int): MutableLiveData<ArrayList<PetViewData>> 编译失败
     *    - 解决办法：
     *     - 组装出现了问题
     *     - 这里修改sql语句和修改存储PetViewData为PetVideo同样是这个编译错误
     */
    //@Query("select code,title,cover,authorId,duration from pet_video limit (:startIndex),20")
    @Query("select code,title,cover,authorId,duration,videoType from pet_video limit (:startIndex),20")
    suspend fun queryByPage(startIndex: Int): MutableList<PetViewData>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where type = (:type) and videoType=0")
    suspend fun queryByType(type: Int): MutableList<PetViewData>

    @Query("select code,title,cover,authorId,duration,videoType,releaseTime from pet_video where type = (:type) and videoType=0 and code!=(:code) limit 0,(:count)")
    suspend fun queryByType(code: Int, type: Int, count: Int): MutableList<PetViewData>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryByTypeAndPage(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideoByPage(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where  type=0 and videoType=0 and star=1 limit (:startIndex),(:count)")
    suspend fun queryLovedPanda(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=0 and videoType=0 and star=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryLovedPanda1(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryPageType(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) order by releaseTime desc")
    fun queryAllTypeVideos(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType = (:type)")
    suspend fun queryByVideoType(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType = (:type) limit 0,4")
    suspend fun queryRecoBanner(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where star=1 and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryStarByPage(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where star=1 and videoType=0 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryStarByPage1(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType = (:videoType)")
    suspend fun queryVideoType(videoType: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType=0 and star=1 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryHotVideo(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType=0 and star=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryHotVideo1(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from music where type=(:type) limit (:startIndex),(:count)")
    suspend fun queryMusicByPage(type: Int, startIndex: Int, count: Int): MutableList<MusicVo>

    @Query("select * from music where type=(:type) order by random()")
    suspend fun queryRandomMusic(type: Int): MusicVo

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where star=1 limit 0,(:counts)")
    suspend fun queryByCounts(counts: Int): MutableList<PetViewData>

    @Transaction
    @Query("select * from pet_video where authorId=(:code) order by releaseTime desc limit (:startIndex),(:counts)")
    suspend fun quertUserVideos(
        code: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndData>

    @Query("select * from pet_video where type=(:type) and videoType=1")
    suspend fun queryBannerByType(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideoByType(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryVideoByType1(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Transaction
    @Query("select * from pet_video where fileName=(:fileName)")
    suspend fun queryVideoByFileName(fileName: String): VideoAndUser

    @Transaction
    @Query("select * from pet_video where code=(:videoCode)")
    suspend fun queryVideoUserByCode(videoCode: Int): VideoAndUser

    @Transaction
    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideosByVideoType(
        type: Int,
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>

    @Query("select count(*) from pet_video where vertical=1")
    suspend fun queryVerticalCounts(): Int

    @Transaction
    @Query("select * from pet_video where vertical=1 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryVerticalVideos(
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>

    @Query("select * from pet_video where vertical=1 order by releaseTime desc")
    fun queryVerticalVideos(): MutableList<PetVideo>

    @Transaction
    @Query("select * from pet_video where vertical=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryVerticalVideos1(
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where vertical=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryRandomVerticalVideos(
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where vertical=1 and code!=(:videoCode) order by random() desc limit (:startIndex),(:count)")
    suspend fun queryRandomVerticalVideos1(
        startIndex: Int,
        count: Int,
        videoCode: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where period=(:period) and type=0 and videoType=0 limit (:startIndex),(:counts)")
    suspend fun queryByPeried(
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where type=0 and videoType=0 and title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryPandaByName(
        words: String,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Query("select count(*) from music")
    suspend fun queryMusicCounts(): Int

    @Query("select count(*) from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) and type != 1")
    suspend fun queryCommentReplyCounts(videoCode: Int, topCommentCode: Int): Int

    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode)")
    suspend fun queryCommentReply(videoCode: Int, topCommentCode: Int): MutableList<VideoComment>

    @Query("select * from music where type=0 and fileName=(:fileName)")
    suspend fun queryMusicByFileName(fileName: String): MusicVo

    @Query("select * from music where type=0")
    suspend fun queryAllMusic(): MutableList<MusicVo>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where videoType=(:videoType) limit (:startIndex),(:count)")
    suspend fun queryVideoByVideoType(
        videoType: Int,
        startIndex: Int,
        count: Int
    ): MutableList<PetViewData>

    @Query("select cover,fileName from pet_video")
    suspend fun queryAllPetCovers(): MutableList<CoverDownLoad>

    @Query("select userCode,headUrl from user")
    suspend fun queryAllUserCovers(): MutableList<HeaderDownLoad>

    @Query("select * from pet_video where code=(:code)")
    suspend fun queryVideoByCode(code: Int): PetVideo

    @Query("select * from pet_video where code=(:code)")
    fun queryVideoByCode1(code: Int): PetVideo

    @Query("select * from pet_video where authorId=(:code)")
    suspend fun queryUserVideos(code: Int): MutableList<PetVideo>

    @Query("select title,code from pet_video where title like (:words) limit 0,(:count)")
    suspend fun queryByKeyWords(words: String, count: Int): MutableList<SearchInfo>

    @Query("select * from pet_video where title like (:words) limit 0,(:count)")
    suspend fun queryVideosByKeyWords(words: String, count: Int): MutableList<PetVideo>

    @Transaction
    @Query("select * from pet_video where period=(:period) and type=0 and videoType=0 and title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryPeriedByKey(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where type=0 and videoType=0 and star=1 and title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryLovedByKey(
        words: String,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where star=1 order by random() desc limit (:startIndex),(:counts)")
    suspend fun queryRandomList(
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryWordsByPage(
        words: String,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser>

    @Query("select * from history order by lastTime desc limit (:startIndex),(:count)")
    suspend fun queryHistoryByPage(startIndex: Int, count: Int): MutableList<History>

    @Query("select * from video_data where laterPlay=1 order by laterTime desc limit (:startIndex),(:count)")
    suspend fun queryLaterByPage(startIndex: Int, count: Int): MutableList<VideoData>

    @Query("select * from video_data where love=1 order by shareTime desc limit (:startIndex),(:count)")
    suspend fun queryLoveByPage(startIndex: Int, count: Int): MutableList<VideoData>

    @Query("select * from video_data where laterPlay=1")
    suspend fun queryAllLaters(): MutableList<VideoData>

    @Query("select * from pet_video where vertical=1 limit (:startIndex),(:count)")
    fun queryVerticalVideoByPage(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video limit (:startIndex),(:count)")
    fun queryVideosByPage(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from user where userCode=(:userCode)")
    fun queryVerticalUser(userCode: Int): User

    @Query("select * from video_data where love=1")
    suspend fun queryAllLoves(): MutableList<VideoData>

    @Query("select code,title,cover,authorId,duration from pet_video where code=(:code)")
    suspend fun queryViewDataByCode(code: Int): PetViewData

    @Query("select * from history where code=(:code)")
    fun queryHistoryByCode(code: Int): History

    @Query("select * from User where userCode=(:code)")
    suspend fun queryUserByCode(code: Int): User

    @Query("select count(*) from pet_video where authorId=(:userCode)")
    suspend fun queryUserVideoCounts(userCode: Int): Int

    @Query("select * from pet_video where type = (:type) and authorId=(:authorId) and code!=(:code) limit 0,(:counts)")
    suspend fun queryRecommendVideos(
        type: Int,
        authorId: Int,
        code: Int,
        counts: Int
    ): MutableList<PetVideo>

    @Query("select * from pet_video where type = (:type) and authorId !=(:authorId) limit 0,(:counts)")
    suspend fun queryRecoVideosByType(
        type: Int,
        authorId: Int,
        counts: Int
    ): MutableList<PetVideo>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and type=(:type) order by commitTime desc limit (:startIndex),(:page)")
    suspend fun queryPageCommentsByType(
        videoCode: Int,
        startIndex: Int,
        page: Int,
        type: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) and type != 1 order by commitTime asc limit (:startIndex),(:page)")
    suspend fun queryReplyComments(
        videoCode: Int,
        topCommentCode: Int,
        startIndex: Int,
        page: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and type=(:type) order by likeNum desc limit (:startIndex),(:page)")
    suspend fun queryCommentsByHot(
        videoCode: Int,
        startIndex: Int,
        page: Int,
        type: Int
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:topCommentCode) order by commitTime asc")
    suspend fun queryVideoChildComment(
        videoCode: Int,
        topCommentCode: Int,
    ): MutableList<CommentAndUser>

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and commentId=(:commentId)")
    suspend fun queryCommentUserByCommentId(
        videoCode: Int,
        commentId: Int
    ): CommentAndUser

    @Transaction
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:commentId) order by commitTime desc limit (:startIndex),(:page)")
    suspend fun queryReplyByPage(
        videoCode: Int,
        commentId: Int,
        startIndex: Int,
        page: Int
    ): MutableList<CommentAndUser>

    /**
     * 查询最大的commentId,当视频没有任何评论时，如果直接返回Int类型会报错，转换成String返回，哪怕是null
     */
    @Query("select max(commentId) from comment where videoCode=(:videoCode)")
    suspend fun queryMaxCommentId(videoCode: Int): String?

    @Query("select count(*) from comment where videoCode=(:videoCode)")
    suspend fun queryCommentCounts(videoCode: Int): Int


    /**群组************************************************************************************/

    @Query("select * from group_info where groupName=(:name)")
    suspend fun queryGroupByName(name: String): Group?

    @Query("select * from group_info where groupCode=(:groupCode)")
    suspend fun queryGroupByCode(groupCode: Int): Group?

    @Query("select * from group_item where groupCode=(:groupCode) and videoCode=(:videoCode)")
    suspend fun queryGroupItem(groupCode: Int, videoCode: Int): GroupVideoItem?

    @Query("select max(groupCode) from group_info")
    suspend fun queryMaxGroupCode(): String?

    @Query("select count(*) from group_item where groupCode=(:groupCode)")
    suspend fun queryGroupItemCounts(groupCode: Int): Int

    @Query("select * from group_info order by updateTime desc")
    suspend fun queryAllGroups(): MutableList<Group>

    @Query("select * from group_info where type=(:type)")
    suspend fun queryGroupByType(type: Int): Group?

    @Query("select * from group_info where type!=(:type) order by updateTime desc")
    suspend fun queryGroupNoType(type: Int): MutableList<Group>

    @Query("select * from group_item where groupCode=(:groupCode)")
    suspend fun queryGroupItems(groupCode: Int): MutableList<GroupVideoItem>


    @Query("select * from group_item where groupCode=(:groupCode) order by id desc limit (:startIndex),(:counts)")
    suspend fun queryGroupItemsByPage(
        groupCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<GroupVideoItem>

    @Transaction
    @Query("select * from group_item where groupCode=(:groupCode) order by id desc limit (:startIndex),(:counts)")
    suspend fun queryGroupItemsAndVideos(
        groupCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<GroupItemAndVideo>

    @Transaction
    @Query("select * from group_item where groupCode=(:groupCode) order by id desc limit 1")
    suspend fun queryGroupItemsAndVideo(groupCode: Int): GroupItemAndVideo

    @Query("select * from user where attention=1 limit 0,30")
    suspend fun queryLiveAttentionUsers(): MutableList<User>

    @Query("select * from user where attention=1")
    suspend fun queryAllAttentionUsers(): MutableList<User>

    @Query("select count(*) from user where attention=1")
    suspend fun queryAllAttentionCounts(): Int

    @Query("select userCode from user where attention=1 limit 0,30")
    suspend fun queryLiveAttentionUserCodes(): MutableList<Int>

    @Query("select * from pet_video where authorId in (:userCodes) order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryLiveVideos(
        userCodes: MutableList<Int>,
        startIndex: Int,
        count: Int
    ): MutableList<PetVideo>

    @Query("select * from pet_video where authorId in (:userCodes) and vertical=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryVerticalVideos(
        userCodes: MutableList<Int>,
        startIndex: Int,
        count: Int
    ): MutableList<PetVideo>

    @Query("select * from pet_video where star=1 order by random() desc limit 30,35")
    suspend fun queryMaxPlayedVideos(): MutableList<PetVideo>

    @Transaction
    @Query("select * from pet_video order by random() desc limit (:startIndex),(:count)")
    suspend fun queryVideosByReleaseTime(startIndex: Int, count: Int): MutableList<VideoAndUser>

}