package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.bean.*
import com.android.android_sqlite.dao.PetVideoDao
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoAndData
import com.android.android_sqlite.entity.VideoAndUser
import com.android.android_sqlite.entity.VideoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * @description: 处理所有PetVideo表相关的数据库操作
 * @author: dongyiming
 * @date: 8/21/24 12:17 AM
 * @version: v1.0
 */
val videoRepository: VideoRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { VideoRepository() }

public class VideoRepository : BaseRepository() {

    private val delayTime = 500L

    private val petDao: PetVideoDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().petVideoDao()
    }

    fun getPetByPage(startIndex: Int, counts: Int): Flow<MutableList<VideoAndUser>> =
        flowInDelay(petDao.getPageVideoByType(0, 1, startIndex, counts))

    /**
     * <获取VideoTpe类型，获取视频的分页数据，数据包括video和相关联的user>
     * @return: VideoAndUser
     */
    fun getVideosByType(type: Int, startIndex: Int, counts: Int): Flow<MutableList<VideoAndUser>> =
        flowInDelay(petDao.queryVideosByType(type, startIndex, counts))

    suspend fun getVerticalVideos(
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {
        return withContext(Dispatchers.IO) {
            val petVideos = mutableListOf<PetVideo>()
            val list = petDao.queryRandomVerticalVideos(startIndex, counts)
            list.forEach {
                val video = it.video
                val videoData = petDao.getVideoDataByCode(video.code)
                val comments = petDao.getCommentCounts(video.code)
                if (videoData == null) {
                    if (comments > 0) {
                        val vd = VideoData(videoCode = video.code, comments = comments)
                        video.videoData = vd
                    }
                } else {
                    videoData.comments = comments
                    video.videoData = videoData
                }
                video.user = it.user
                petVideos.add(video)
            }
            petVideos
        }
    }

    suspend fun getVerticalVideos1(
        startIndex: Int,
        counts: Int,
        videoCode: Int
    ): MutableList<PetVideo> {
        return withContext(Dispatchers.IO) {
            val petVideos = mutableListOf<PetVideo>()
            val list = if (startIndex == 0) {
                val list = petDao.queryRandomVerticalVideos1(0, 20, videoCode)
                val firstVideo = petDao.getVideoUserByCode(videoCode)
                list.add(0, firstVideo)
                list
            } else {
                petDao.queryRandomVerticalVideos1(startIndex, counts, videoCode)
            }
            list.forEach {
                val video = it.video
                val videoData = petDao.getVideoDataByCode(video.code)
                val comments = petDao.getCommentCounts(video.code)
                if (videoData == null) {
                    if (comments > 0) {
                        val vd = VideoData(videoCode = video.code, comments = comments)
                        video.videoData = vd
                    }
                } else {
                    videoData.comments = comments
                    video.videoData = videoData
                }
                video.user = it.user
                petVideos.add(video)
            }
            petVideos
        }
    }

    suspend fun getFallsShortVideos(
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {
        return withContext(Dispatchers.IO) {
            delay(delayTime)
            val petVideos = mutableListOf<PetVideo>()
            val list = petDao.queryRandomVerticalVideos(startIndex, counts)
            list.forEach {
                val video = it.video
                video.videoData = petDao.getVideoDataByCode(video.code)
                video.user = it.user
                petVideos.add(video)
            }
            petVideos
        }
    }

    suspend fun getAttentionFallsShortVideos(
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {
        return withContext(Dispatchers.IO) {
            delay(delayTime)
            val userCodes = petDao.queryLiveAttentionUserCodes()
            if (userCodes.isEmpty()) {
                mutableListOf()
            } else {
                val videos = petDao.queryVerticalVideos(userCodes, startIndex, counts)
                videos.forEach {
                    it.user = petDao.getUserByCode(it.authorId)
                    it.videoData = petDao.getVideoDataByCode(it.code)
                }
                videos
            }
        }
    }

    suspend fun getVideoByFileName(fileName: String): VideoAndUser =
        petDao.queryVideoByFileName(fileName)

    /**
     * 获取首页推荐栏数据
     * @param: pageNo ： 只有第一页才有轮播图
     * @return: 页面分布：轮播图+star视频+横屏视频
     * @date: 1/22/22 7:47 下午
     * @version: v1.0
     */
    suspend fun getRecommendByPage(startIndex: Int, counts: Int): RecommendData<PetVideo> {
        return withContext(Dispatchers.IO) {
            val recommendData = RecommendData<PetVideo>()
            if (startIndex == 0) {//首页
                recommendData.bannerList = petDao.queryRecoBanner(1)
//                val list = petDao.queryStarByPage(startIndex, counts)
                val list = petDao.queryStarByPage1(startIndex, counts)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.getUserByCode(it.authorId)
                        it.videoData = petDao.getVideoDataByCode(it.code)
                    }
                }
                recommendData.itemList = list
            } else {
                delay(delayTime)
                val list = petDao.queryStarByPage1(startIndex, counts)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.getUserByCode(it.authorId)
                        it.videoData = petDao.getVideoDataByCode(it.code)
                    }
                }
                recommendData.itemList = list
            }
            recommendData
        }
    }

    fun getCutePetBannerData(): Flow<MutableList<PetVideo>> = flowIn(petDao.queryByVideoType(3))

    suspend fun getSelectedVideo(selects: MutableList<Int>): MutableList<PetVideo> =
        withContext(Dispatchers.IO) {
            mutableListOf<PetVideo>().apply {
                if (selects.isNotEmpty()) {
                    selects.forEach {
                        val videoUser = petDao.getVideoUserByCode(it)
                        val video = videoUser.video
                        video.user = videoUser.user
                        add(video)
                    }
                }
            }
        }

    suspend fun getVideosByVideoType(
        type: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser> {
        return withContext(Dispatchers.IO) {
            delay(delayTime)
            petDao.queryVideosByVideoType(type, startIndex, counts)
        }
    }

    suspend fun getCutePetByType(
        type: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {
        return withContext(Dispatchers.IO) {
            val list = petDao.queryPageType(type, startIndex, counts)
            list.forEach { video ->
                if (video.authorId != 0) {
                    val user = petDao.getUserByCode(video.authorId)
                    video.user = user
                    val data = petDao.getVideoDataByCode(video.code)
                    video.videoData = data
                }
            }
            list
        }
    }

    suspend fun getLoveData(isFresh: Boolean, startIndex: Int): PageCommonData {
        return withContext(Dispatchers.IO) {

            delay(delayTime)
            val data = PageCommonData()
            if (isFresh) {
                data.run {
                    bannerList = getBannerList()
                    footBallModel = petDao.queryByTypeAndPage(VideoType.FOOTBALL.ordinal, 0, 4)
                    artList = petDao.queryVideoByType(VideoType.ART.ordinal, 0, 4)
                    babyList = petDao.queryVideoByType(VideoType.BABY.ordinal, 0, 4)
                    honglouList = petDao.queryVideoByType(VideoType.HONGLOU.ordinal, 0, 4)
                    beautyList = petDao.queryVideoByType(VideoType.BEAUTY.ordinal, 0, 4)
                }
            }
            data
        }
    }

    suspend fun getLandscapeData(startIndex: Int, counts: Int): LandscapeData {

        return withContext(Dispatchers.IO) {

            delay(delayTime)
            val itemList = petDao.queryVideoByType1(VideoType.LANDSCAPE.ordinal, startIndex, counts)
            itemList.forEach {
                it.user = petDao.getUserByCode(it.authorId)
                it.videoData = petDao.getVideoDataByCode(it.code)
            }
            var bannerList = mutableListOf<PetVideo>()
            if (startIndex == 0) {
                bannerList = petDao.queryBannerByType(VideoType.LANDSCAPE.ordinal)
                bannerList.forEach {
                    it.user = petDao.getUserByCode(it.authorId)
                    it.videoData = petDao.getVideoDataByCode(it.code)
                }
            }
            LandscapeData(bannerList, itemList)
        }
    }

    suspend fun getHotData(startIndex: Int, counts: Int): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {

            delay(delayTime)
            val list = petDao.queryHotVideo(startIndex, counts)

            list.forEach {
                val code = it.authorId
                if (code != 0) {
                    it.user = petDao.getUserByCode(code)
                }
            }
            list
        }
    }

    suspend fun getUserVideos(
        code: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndData> {

        return withContext(Dispatchers.IO) {
            val user = petDao.getUserByCode(code)
            val list = petDao.quertUserVideos(code, startIndex, counts)
            list.forEach {
                it.video.user = user
            }
            list
        }
    }

    fun getAllPetCoverUrl(): Flow<MutableList<CoverDownLoad>> = flowIn(petDao.queryAllPetCovers())
    fun getAllUserCovers(): Flow<MutableList<HeaderDownLoad>> = flowIn(petDao.queryAllUserCovers())

    suspend fun removeLaters(list: MutableList<PetVideo>, isAll: Boolean) {
        withContext(Dispatchers.IO) {
            if (isAll) {
                val laters = petDao.queryAllLaters()
                laters.forEach {
                    it.laterPlay = false
                    petDao.update(it)
                }
            } else {
                list.forEach {
                    it.videoData?.let { data ->
                        data.laterPlay = false
                        petDao.update(data)
                    }
                }
            }
        }
    }

    suspend fun removeLoves(list: MutableList<PetVideo>, isAll: Boolean) {
        withContext(Dispatchers.IO) {
            if (isAll) {
                val laters = petDao.queryAllLoves()
                laters.forEach {
                    it.love = false
                    if (it.loves >= 1) {
                        it.loves -= 1
                    }
                    petDao.update(it)
                }
            } else {
                list.forEach {
                    it.videoData?.let { data ->
                        data.love = false
                        if (data.loves >= 1) {
                            data.loves -= 1
                        }
                        petDao.update(data)
                    }
                }
            }
        }
    }

    suspend fun addLater(videoCode: Int) {
        withContext(Dispatchers.IO) {
            val videoData = petDao.getVideoDataByCode(videoCode)
            if (videoData == null) {
                val vd = VideoData(
                    videoCode = videoCode,
                    laterPlay = true,
                    laterTime = System.currentTimeMillis()
                )
                petDao.insert(vd)
            } else {
                videoData.laterPlay = true
                videoData.laterTime = System.currentTimeMillis()
                petDao.update(videoData)
            }
        }
    }

    /**
     * 获取当前视频信息，用户信息，和推荐视频
     */
    suspend fun getVideoInfo(code: Int, counts: Int): VideoInfo {

        return withContext(Dispatchers.IO) {
            val startTime = System.currentTimeMillis()
            val videoUser = petDao.getVideoUserByCode(code)
            val user = videoUser.user
            val video = videoUser.video

            user.videoCounts = petDao.queryUserVideoCounts(video.authorId)
            video.user = user

            video.videoData = petDao.getVideoDataByCode(code)
            val list = petDao.queryRecommendVideos(video.type, video.authorId, code, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.getUserByCode(it.authorId)
                    it.videoData = petDao.getVideoDataByCode(it.code)
                }
            }
            if (list.size < counts) {
                val list1 =
                    petDao.queryRecoVideosByType(video.type, video.authorId, (counts - list.size))
                if (list1.isNotEmpty()) {
                    list1.forEach {
                        it.user = petDao.getUserByCode(it.authorId)
                        it.videoData = petDao.getVideoDataByCode(it.code)
                    }
                }
                list.addAll(list1)
            }
            VideoInfo(video, list)
        }
    }

    /**
     * 视频播放界面，播放源需要的视频进度数据
     */
    suspend fun getVideoInfoData(code: Int): PetVideo {
        return withContext(Dispatchers.IO) {
            val video = petDao.getVideoByCode(code)
            val videoData = petDao.getVideoDataByCode(code)
            if (videoData == null) {
                video.videoData = VideoData(videoCode = code)
                video
            } else {
                videoData.comments = petDao.queryCommentCounts(code)
                video.videoData = videoData
                video
            }
        }
    }

    fun search(words: String): Flow<MutableList<SearchInfo>> =
        flowIn(petDao.queryByKeyWords("%$words%", 10))

    fun searchPeriod(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>> {
        return if (period == PeriodType.CUTE.ordinal) {
            flowIn(petDao.queryLovedByKey("%$words%", startIndex, counts))
        } else {
            flowIn(petDao.queryPeriedByKey("%$words%", period, startIndex, counts))
        }
    }

    fun getPandas(
        name: String,
        startIndex: Int,
        counts: Int
    ): Flow<MutableList<VideoAndUser>> = when (name) {
        "熊猫宝宝" -> {
            flowIn(petDao.queryByPeried(PeriodType.BABY.ordinal, startIndex, counts))
        }
        "熊猫妈妈" -> {
            flowIn(petDao.queryByPeried(PeriodType.MOM.ordinal, startIndex, counts))
        }
        "幼年班" -> {
            flowIn(petDao.queryByPeried(PeriodType.GROUP.ordinal, startIndex, counts))
        }
        "成长记" -> {
            flowIn(petDao.queryByPeried(PeriodType.ALL.ordinal, startIndex, counts))
        }
        "科普" -> {
            flowIn(petDao.queryByPeried(PeriodType.KNOWLEDGE.ordinal, startIndex, counts))
        }
        else -> {
            flowIn(petDao.queryPandaByName("%$name%", startIndex, counts))
        }
    }

    fun searchByPage(words: String, startIndex: Int): Flow<MutableList<VideoAndUser>> =
        flowIn(petDao.queryWordsByPage("%$words%", startIndex, 10))

    suspend fun getSelectedVideoUser(selects: MutableList<Int>): MutableList<VideoAndUser> =
        withContext(Dispatchers.IO) {
            mutableListOf<VideoAndUser>().apply {
                if (selects.isNotEmpty()) {
                    selects.forEach { select ->
                        val videoUser = petDao.getVideoUserByCode(select)
                        add(videoUser)
                    }
                }
            }
        }

    suspend fun getLater(startIndex: Int, counts: Int): MutableList<PetVideo> =
        withContext(Dispatchers.IO) {
            mutableListOf<PetVideo>().apply {
                petDao.queryLaterByPage(startIndex, counts).forEach {
                    val videoUser = petDao.getVideoUserByCode(it.videoCode)
                    val video = videoUser.video
                    video.user = videoUser.user
                    video.videoData = it
                    add(video)
                }
            }
        }

    suspend fun getLove(startIndex: Int, counts: Int): MutableList<PetVideo> =
        withContext(Dispatchers.IO) {
            mutableListOf<PetVideo>().apply {
                petDao.queryLoveByPage(startIndex, counts).forEach {
                    val videoUser = petDao.getVideoUserByCode(it.videoCode)
                    if (videoUser != null) {
                        val video = videoUser.video
                        video.user = videoUser.user
                        video.videoData = it
                        add(video)
                    }
                }
            }
        }

    suspend fun addOrUpdateVideoData(videoData: VideoData) {
        withContext(Dispatchers.IO) {
            val data = petDao.getVideoDataByCode(videoData.videoCode)
            if (data == null) {
                petDao.insert(videoData)
            } else {
                videoData.id = data.id
                petDao.update(videoData)
            }
        }
    }

    suspend fun updatePetVideo(petVideo: PetVideo) {
        withContext(Dispatchers.IO) {
            val video = petDao.getVideoByCode(petVideo.code)
            if (video == null) {
                throw NullPointerException("no video by videoCode=${petVideo.code}")
            } else {
                petVideo.id = video.id
                petDao.update(petVideo)
            }
        }
    }

    suspend fun addOrUpdateVideoData(videoCode: Int, isLike: Boolean) {
        withContext(Dispatchers.IO) {
            val data = petDao.getVideoDataByCode(videoCode)
            data?.let {
                it.like = isLike
                if (isLike) {
                    it.likes += 1
                } else {
                    it.likes -= 1
                }
                petDao.update(it)
            }
            if (data == null) {
                val videoData =
                    VideoData(videoCode = videoCode, like = isLike, plays = 1)
                if (isLike) {
                    videoData.likes = 1
                }
                petDao.insert(videoData)
            }
        }
    }

    suspend fun addOrUpdateVideoData(videoCode: Int, playPos: Long) {
        withContext(Dispatchers.IO) {
            val data = petDao.getVideoDataByCode(videoCode)
            if (data == null) {
                val videoData = VideoData(videoCode = videoCode, playPosition = playPos)
                petDao.insert(videoData)
            } else {
                if (data.playPosition != playPos) {
                    data.playPosition = playPos
                    petDao.update(data)
                }
            }
        }
    }

    fun getPageRanks(startIndex: Int, counts: Int): Flow<MutableList<VideoAndUser>> =
        flowIn(petDao.queryVideosByReleaseTime(startIndex, counts))

    suspend fun getLiveVides(isRefresh: Boolean, startIndex: Int, counts: Int): LiveVideoData {

        return withContext(Dispatchers.IO) {

            val startTime = System.currentTimeMillis()
            val data = LiveVideoData()
            if (isRefresh) {
                delay(350)
                val users = petDao.queryLiveAttentionUsers()
                data.visitors = users
            }
            val userCodes = petDao.queryLiveAttentionUserCodes()
            val videos = petDao.queryLiveVideos(userCodes, startIndex, counts)
            videos.forEach {
                it.user = petDao.getUserByCode(it.authorId)
                it.videoData = petDao.getVideoDataByCode(it.code)
            }
            val videoDatas = petDao.queryMaxPlayedVideos()
            videoDatas.forEach {
                it.user = petDao.getUserByCode(it.authorId)
                data.follows.add(it)
            }
            data.lives = videos
            data
        }
    }

    private fun getBannerList(): MutableList<BannerItem> {

        val list = mutableListOf<BannerItem>()

//        val bannerItem1 = BannerItem(
//            "https://i1.hdslb.com/bfs/archive/9b90018d3acfe1a1c6a66e42fd658eb45dd8df03.jpg",
//            1384
//        )
//        val bannerItem2 = BannerItem(
//            "https://i1.hdslb.com/bfs/archive/eba5e50279a3573a75a60c7dd4c50e79a2e524e6.jpg",
//            2024
//        )
//        val bannerItem3 = BannerItem(
//            "https://i1.hdslb.com/bfs/archive/39c0e958687971efcd5c954d514169144bde472d.png",
//            1139
//        )
        val bannerItem2 = BannerItem(
            "https://i1.hdslb.com/bfs/archive/ee94e3b7d40c952cc0d788756ee9aba2c70cfbab.jpg",
            1384
        )
        val bannerItem1 = BannerItem(
            "https://i0.hdslb.com/bfs/archive/379515e38a37fdd2f1499878ce828d41b2aa4c7c.jpg",
            2024
        )
        val bannerItem3 = BannerItem(
            "https://i0.hdslb.com/bfs/archive/b70c22b3cf19ece328cca80d89d95d0f35aaeb1a.jpg",
            1139
        )
        list.add(bannerItem1)
        list.add(bannerItem2)
        list.add(bannerItem3)
        return list
    }
}