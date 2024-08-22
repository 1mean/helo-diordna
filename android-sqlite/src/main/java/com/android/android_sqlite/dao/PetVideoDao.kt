package com.android.android_sqlite.dao

import androidx.room.*
import com.android.android_sqlite.bean.CoverDownLoad
import com.android.android_sqlite.bean.HeaderDownLoad
import com.android.android_sqlite.bean.PetViewData
import com.android.android_sqlite.bean.SearchInfo

import com.android.android_sqlite.entity.*
import kotlinx.coroutines.flow.Flow

/**
 * @description:
 * @author: dongyiming
 * @date: 2022/1/11 12:09 上午
 * @version: v1.0
 */
@Dao
interface PetVideoDao {

    /*add******************************************************************/
    @Insert(onConflict = OnConflictStrategy.REPLACE) //发生冲突解决办法：终止操作，抛出异常
    suspend fun insert(video: PetVideo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(videos: MutableList<PetVideo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(videoData: VideoData)

    /* -----------删------------------------------------- */

    @Delete
    suspend fun delete(video: PetVideo)

    @Delete
    suspend fun delete(list: MutableList<PetVideo>)

    @Delete
    suspend fun delete(videoData: VideoData)


    /* -----------更新------------------------------------- */

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(video: PetVideo)

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun update(list: MutableList<PetVideo>)

    @Update(onConflict = OnConflictStrategy.ABORT) //发生冲突解决办法：终止操作，抛出异常
    suspend fun update(data: VideoData)

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
    fun getAll(): Flow<MutableList<PetVideo>>

    @Query("select * from video_data where videoCode=(:code)")
    fun queryVideoDataByCode(code: Int): Flow<VideoData?>

    @Query("select * from video_data where videoCode=(:code)")
    suspend fun getVideoDataByCode(code: Int): VideoData?

    @Query("select * from video_data where videoCode=(:code)")
    fun queryVideoDataByCode2(code: Int): Flow<VideoData>

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
    @Query("select code,title,cover,authorId,duration,videoType from pet_video limit (:startIndex),20")
    fun queryByPage(startIndex: Int): Flow<MutableList<PetViewData>>

    @Query("select code,title,cover,authorId,duration,videoType from pet_video where type = (:type) and videoType=0")
    fun queryByType(type: Int): Flow<MutableList<PetViewData>>

    @Query("select code,title,cover,authorId,duration,videoType,releaseTime from pet_video where type = (:type) and videoType=0 and code!=(:code) limit 0,(:count)")
    fun queryByType(code: Int, type: Int, count: Int): Flow<MutableList<PetViewData>>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    suspend fun queryByTypeAndPage(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 limit (:startIndex),(:count)")
    fun queryVideoByPage(type: Int, startIndex: Int, count: Int): Flow<MutableList<PetVideo>>

    @Query("select * from pet_video where  type=0 and videoType=0 and star=1 limit (:startIndex),(:count)")
    fun queryLovedPanda(startIndex: Int, count: Int): Flow<MutableList<PetVideo>>

    @Transaction
    @Query("select * from pet_video where type=(:type) and videoType=0 and star=(:star) order by random() desc limit (:startIndex),(:count)")
    fun getPageVideoByType(
        type: Int,
        star: Int,
        startIndex: Int,
        count: Int
    ): Flow<MutableList<VideoAndUser>>

    @Query("select * from pet_video where type=(:type) and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    suspend fun queryPageType(type: Int, startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) order by releaseTime desc")
    fun queryAllTypeVideos(type: Int): Flow<MutableList<PetVideo>>

    @Query("select * from pet_video where videoType = (:type)")
    fun queryByVideoType(type: Int): Flow<MutableList<PetVideo>>

    @Query("select * from pet_video where videoType = (:type) and type!=14 order by random()")
    suspend fun queryRecoBanner(type: Int): MutableList<PetVideo>

    @Query("select * from pet_video where star=1 and videoType=0 order by releaseTime desc limit (:startIndex),(:count)")
    fun queryStarByPage(startIndex: Int, count: Int): Flow<MutableList<PetVideo>>

    @Query("select * from pet_video where star=1 and videoType=0 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryStarByPage1(startIndex: Int, count: Int): MutableList<PetVideo>

    @Query("select * from pet_video where videoType=0 and star=1 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryHotVideo(startIndex: Int, count: Int): MutableList<PetVideo>

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
    suspend fun queryVideoByType(
        type: Int,
        startIndex: Int,
        count: Int
    ): MutableList<PetVideo>

    @Query("select * from pet_video where type=(:type) and videoType=0 order by random() desc limit (:startIndex),(:count)")
    suspend fun queryVideoByType1(
        type: Int,
        startIndex: Int,
        count: Int
    ): MutableList<PetVideo>

    @Transaction
    @Query("select * from pet_video where fileName=(:fileName)")
    suspend fun queryVideoByFileName(fileName: String): VideoAndUser

    @Transaction
    @Query("select * from pet_video where code=(:videoCode)")
    fun queryVideoUserByCode(videoCode: Int): Flow<VideoAndUser>

    @Transaction
    @Query("select * from pet_video where code=(:videoCode)")
    suspend fun getVideoUserByCode(videoCode: Int): VideoAndUser

    @Transaction
    @Query("select * from pet_video where type=(:type) limit (:startIndex),(:count)")
    fun queryVideosByType(
        type: Int,
        startIndex: Int,
        count: Int
    ): Flow<MutableList<VideoAndUser>>

    @Query("select * from pet_video where vertical=1 order by releaseTime desc")
    fun queryVerticalVideos(): Flow<MutableList<PetVideo>>

    @Query("select userCode from user where attention=1 limit 0,30")
    suspend fun queryLiveAttentionUserCodes(): MutableList<Int>

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
    fun queryByPeried(
        period: Int,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>>

    @Transaction
    @Query("select * from pet_video where type=0 and videoType=0 and title like (:words) limit (:startIndex),(:counts)")
    fun queryPandaByName(
        words: String,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>>

    @Query("select cover,fileName from pet_video")
    fun queryAllPetCovers(): Flow<MutableList<CoverDownLoad>>

    @Query("select userCode,headUrl from user")
    fun queryAllUserCovers(): Flow<MutableList<HeaderDownLoad>>

    @Query("select * from pet_video where code=(:code)")
    fun queryVideoByCode(code: Int): Flow<PetVideo>

    @Query("select * from pet_video where code=(:code)")
    suspend fun getVideoByCode(code: Int): PetVideo

    @Query("select title,code from pet_video where title like (:words) limit 0,(:count)")
    fun queryByKeyWords(words: String, count: Int): Flow<MutableList<SearchInfo>>

    @Transaction
    @Query("select * from pet_video where period=(:period) and type=0 and videoType=0 and title like (:words) limit (:startIndex),(:counts)")
    fun queryPeriedByKey(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>>

    @Transaction
    @Query("select * from pet_video where type=0 and videoType=0 and star=1 and title like (:words) limit (:startIndex),(:counts)")
    fun queryLovedByKey(
        words: String,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>>

    @Transaction
    @Query("select * from pet_video where title like (:words) limit (:startIndex),(:counts)")
    fun queryWordsByPage(
        words: String,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>>

    @Query("select * from video_data where laterPlay=1 order by laterTime desc limit (:startIndex),(:count)")
    suspend fun queryLaterByPage(startIndex: Int, count: Int): MutableList<VideoData>

    @Query("select * from video_data where love=1 order by shareTime desc limit (:startIndex),(:count)")
    suspend fun queryLoveByPage(startIndex: Int, count: Int): MutableList<VideoData>

    @Query("select * from video_data where laterPlay=1")
    suspend fun queryAllLaters(): MutableList<VideoData>

    @Query("select * from pet_video where vertical=1 limit (:startIndex),(:count)")
    fun queryVerticalVideoByPage(startIndex: Int, count: Int): Flow<MutableList<PetVideo>>

    @Query("select * from video_data where love=1")
    suspend fun queryAllLoves(): MutableList<VideoData>

    @Query("select * from pet_video where type = (:type) and authorId=(:authorId) and code!=(:code) limit 0,(:counts)")
    suspend fun queryRecommendVideos(
        type: Int,
        authorId: Int,
        code: Int,
        counts: Int
    ): MutableList<PetVideo>

    @Query("select count(*) from pet_video where authorId=(:userCode)")
    suspend fun queryUserVideoCounts(userCode: Int): Int

    @Query("select * from pet_video where type = (:type) and authorId !=(:authorId) limit 0,(:counts)")
    suspend fun queryRecoVideosByType(
        type: Int,
        authorId: Int,
        counts: Int
    ): MutableList<PetVideo>


    @Query("select count(*) from comment where videoCode=(:videoCode)")
    suspend fun queryCommentCounts(videoCode: Int): Int

    @Query("select count(*) from comment where videoCode=(:videoCode)")
    suspend fun getCommentCounts(videoCode: Int): Int


    /**群组************************************************************************************/

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
    fun queryVideosByReleaseTime(
        startIndex: Int,
        count: Int
    ): Flow<MutableList<VideoAndUser>>

    @Query("select * from user where userCode=(:userCode)")
    suspend fun getUserByCode(userCode: Int): User?

    @Query("select * from user where attention=1 limit 0,30")
    suspend fun queryLiveAttentionUsers(): MutableList<User>

    @Transaction
    @Query("select * from pet_video where type=(:type) limit (:startIndex),(:count)")
    suspend fun queryVideosByVideoType(
        type: Int,
        startIndex: Int,
        count: Int
    ): MutableList<VideoAndUser>
}