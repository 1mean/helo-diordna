package com.example.pandas.sql.dao

import androidx.room.*
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.bean.CoverDownLoad
import com.example.pandas.bean.SearchInfo
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.sql.entity.*

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
    suspend fun insertComment(comment: VideoComment)

    /* -----------删------------------------------------- */

    @Delete
    fun delete(video: PetVideo)

    @Delete
    fun deleteAll(list: MutableList<PetVideo>)

    @Delete
    fun deleteAllMusic(list: MutableList<MusicVo>)

    @Delete
    fun deleteAllVideoData(list: MutableList<VideoData>)

    @Delete
    fun deleteAllComments(list: MutableList<VideoComment>)


    /* -----------更新------------------------------------- */

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun update(video: PetVideo)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateAll(list: MutableList<PetVideo>)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateHistory(history: History)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    fun updateVideoData(data: VideoData)

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

    @Query("select * from music")
    fun getAllMusic(): MutableList<MusicVo>

    @Query("select * from pet_video where title like :name")
    suspend fun queryByName(name: String): List<PetVideo>

    @Query("select * from pet_video where title in (:names)")
    suspend fun queryByNames(vararg names: String): List<PetVideo>

    @Query("select * from pet_video where code=(:code)")
    fun queryByCode(code: Int): PetVideo

    @Query("select * from pet_video where id=(:id)")
    fun queryById(id: Int): PetVideo

    @Query("select count(*) from pet_video")
    fun getAllSize(): Int

    @Query("select * from video_data")
    fun queryVideoData(): MutableList<VideoData>

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun queryVideoDataByCode(code: Int): VideoData?

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

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryByTypeAndPage(type: Int, startIndex: Int, count: Int): MutableList<PetViewData>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideoByPage(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where  type=0 and videoType=0 and isStar=1 limit (:startIndex),(:count)")
    suspend fun queryLovedPanda(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryPageType(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where videoType = (:type)")
    suspend fun queryByVideoType(type: Int): MutableList<PetViewData>

    @Query("select * from pet_video where videoType = (:type) limit 0,4")
    suspend fun queryRecoBanner(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where isStar=1 and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryStarByPage(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType = (:videoType)")
    suspend fun queryVideoType(videoType: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType=0 and isStar=1 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryHotVideo(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from music where type=(:type) limit (:startIndex),(:count)")
    suspend fun queryMusicByPage(type: Int, startIndex: Int, count: Int): MutableList<MusicVo>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where isStar=1 limit 0,(:counts)")
    suspend fun queryByCounts(counts: Int): MutableList<PetViewData>

    @Query("select code,title,cover,authorId,duration,videoType,releaseTime from pet_video where authorId=(:code) order by releaseTime desc limit (:startIndex),(:counts)")
    suspend fun queryVideosByCode(
        code: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetViewData>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where type=(:type) and videoType=1")
    suspend fun queryBannerByType(type: Int): MutableList<PetViewData>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideoByType(type: Int, startIndex: Int, count: Int): MutableList<PetViewData>

    @Transaction
    @Query("select * from pet_video where fileName=(:fileName)")
    suspend fun queryVideoByFileName(fileName: String): VideoAndUser

    @Transaction
    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryVideosByVideoType(
        type: Int,
        startIndex: Int,
        count: Int
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

    @Query("select * from pet_video where code=(:code)")
    suspend fun queryVideoByCode(code: Int): PetVideo

    @Query("select title,code from pet_video where title like (:words) limit 0,20")
    suspend fun queryByKeyWords(words: String): MutableList<SearchInfo>

    @Query("select * from pet_video where period=(:period) and type=0 and videoType=0 and title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryPeriedByKey(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo>

    @Query("select * from pet_video where type=0 and videoType=0 and isStar=1 and title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryLovedByKey(
        words: String,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where title like (:words) limit (:startIndex),(:counts)")
    suspend fun queryWordsByPage(
        words: String,
        startIndex: Int,
        counts: Int
    ): MutableList<PetViewData>

    @Query("select * from history order by lastTime desc limit (:startIndex),(:count)")
    suspend fun queryHistoryByPage(startIndex: Int, count: Int): MutableList<History>

    @Query("select code,title,cover,authorId,duration from pet_video where code=(:code)")
    suspend fun queryViewDataByCode(code: Int): PetViewData

    @Query("select * from history where code=(:code)")
    fun queryHistoryByCode(code: Int): History

    @Query("select * from User where userCode=(:code)")
    suspend fun queryUserByCode(code: Int): User

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
    @Query("select * from comment where videoCode=(:videoCode) and type=(:type) order by commitTime asc limit (:startIndex),(:page)")
    suspend fun queryVideoCommentByPage(
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
    @Query("select * from comment where videoCode=(:videoCode) and topCommentId=(:commentId) order by commitTime asc limit (:startIndex),(:page)")
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
    suspend fun queryMaxCommentId(videoCode: Int): String
}