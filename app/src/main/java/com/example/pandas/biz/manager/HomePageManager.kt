package com.example.pandas.biz.manager

import android.util.Log
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.*
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * @description: 处理所有pet相关
 * @author: dongyiming
 * @date: 1/20/22 1:11 上午
 * @version: v1.0
 */
val PetManagerCoroutine: PetManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { PetManager() }

class PetManager {

    private val delayTime = 500L

    private val petDao: PetVideoDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().petVideoDao()
    }

    suspend fun getPetByPage(
        startIndex: Int,
        counts: Int,
        isRefresh: Boolean
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {
            delay(delayTime)
            val list = petDao.queryLovedPanda1(startIndex, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            list
        }
    }

    /**
     * <获取VideoTpe类型，获取视频的分页数据，数据包括video和相关联的user>
     * @param:
     * @return: VideoAndUser
     * @author: dongyiming
     * @date: 6/27/22 3:25 下午
     * @version: v1.0
     */
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

    suspend fun getVerticalVideos(
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {
            val petVideos = mutableListOf<PetVideo>()
            val list = petDao.queryRandomVerticalVideos(startIndex, counts)
            list.forEach {
                val video = it.video
                val videoData = petDao.queryVideoDataByCode(video.code)
                val comments = petDao.queryCommentCounts(video.code)
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

        return withContext(Dispatchers.Default) {
            val petVideos = mutableListOf<PetVideo>()
            val list = if (startIndex == 0) {
                val list = petDao.queryRandomVerticalVideos1(0, 20, videoCode)
                val firstVideo = petDao.queryVideoUserByCode(videoCode)
                list.add(0, firstVideo)
                list
            } else {
                petDao.queryRandomVerticalVideos1(startIndex, counts, videoCode)
            }
            list.forEach {
                val video = it.video
                val videoData = petDao.queryVideoDataByCode(video.code)
                val comments = petDao.queryCommentCounts(video.code)
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

        return withContext(Dispatchers.Default) {
            delay(delayTime)
            val petVideos = mutableListOf<PetVideo>()
            val list = petDao.queryVerticalVideos1(startIndex, counts)
            list.forEach {
                val video = it.video
                video.videoData = petDao.queryVideoDataByCode(video.code)
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
        return withContext(Dispatchers.Default) {
            delay(delayTime)
            val userCodes = petDao.queryLiveAttentionUserCodes()
            if (userCodes.isEmpty()) {
                mutableListOf()
            } else {
                val videos = petDao.queryVerticalVideos(userCodes, startIndex, counts)
                videos.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                    it.videoData = petDao.queryVideoDataByCode(it.code)
                }
                videos
            }
        }
    }

    suspend fun getMusicCounts(): Int {

        return withContext(Dispatchers.IO) {
            petDao.queryMusicCounts()
        }
    }

    suspend fun getMusic(fileName: String): MusicVo {

        return withContext(Dispatchers.IO) {
            petDao.queryMusicByFileName(fileName)
        }
    }

    suspend fun getAllMusic(): MutableList<MusicVo> {

        return withContext(Dispatchers.IO) {
            petDao.queryAllMusic()
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
            delay(delayTime)
            val recommendData = RecommendData<PetVideo>()
            if (startIndex == 0) {//首页
                recommendData.bannerList = petDao.queryRecoBanner(1)
//                val list = petDao.queryStarByPage(startIndex, counts)
                val list = petDao.queryStarByPage1(startIndex, counts)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                        it.videoData = petDao.queryVideoDataByCode(it.code)
                    }
                }
                recommendData.itemList = list
            } else {
                val list = petDao.queryStarByPage1(startIndex, counts)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                        it.videoData = petDao.queryVideoDataByCode(it.code)
                    }
                }
                recommendData.itemList = list
            }
            recommendData
        }
    }

    /**
     * 通过videoType获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getCutePetBannerData(): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {
            petDao.queryByVideoType(3)
        }
    }

    /**
     * 通过type获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getCutePetByType(
        type: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {
            val list = petDao.queryPageType(type, startIndex, counts)
            list.forEach { video ->
                if (video.authorId != 0) {
                    val user = petDao.queryUserByCode(video.authorId)
                    video.user = user
                    val data = petDao.queryVideoDataByCode(video.code)
                    video.videoData = data
                }
            }
            list
        }
    }

    /**
     * 通过type获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getLoveData(isFresh: Boolean, startIndex: Int): PageCommonData {

        return withContext(Dispatchers.Default) {

            delay(delayTime)
            val data = PageCommonData()
            if (isFresh) {
                data.run {
                    bannerList = getBannerList()
                    movieModel = petDao.queryByTypeAndPage(VideoType.MUSIC.ordinal, 0, 4)
                    songs = petDao.queryMusicByPage(0, 0, 5)
                    footBallModel = petDao.queryByTypeAndPage(VideoType.FOOTBALL.ordinal, 0, 4)
                    talkAudios = petDao.queryMusicByPage(0, 0, 5)
                    artList = petDao.queryVideoByType(VideoType.ART.ordinal, 0, 4)
                    babyList = petDao.queryVideoByType(VideoType.BABY.ordinal, 0, 4)
                    honglouList = petDao.queryVideoByType(VideoType.HONGLOU.ordinal, 0, 4)
                    beautyList = petDao.queryVideoByType(VideoType.BEAUTY.ordinal, 0, 4)
                }
            }
            data
        }
    }

    /**
     * 获取分页的music数据
     */
    suspend fun getPageMusic(type: Int, startIndex: Int, counts: Int): MutableList<MusicVo> {

        return withContext(Dispatchers.Default) {
            if (type != 0) {
                val startDex = (8 - type) * 10
                petDao.queryMusicByPage(0, startDex, 10)
            } else {
                petDao.queryMusicByPage(0, startIndex, counts)
            }
        }
    }

    suspend fun getMusic(): MusicBean {

        return withContext(Dispatchers.Default) {
            val musicBean = MusicBean()

            for (i in 0 until 6) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicBanners.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicItem1.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicItem2.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicItem3.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicItem4.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = petDao.queryRandomMusic(0)
                musicBean.musicItem5.add(musicVo)
            }

            musicBean.musicVideos = petDao.queryVideosByVideoType(VideoType.MUSIC.ordinal, 0, 4)

            musicBean
        }
    }

    suspend fun getLandscapeData(startIndex: Int, counts: Int): LandscapeData {

        return withContext(Dispatchers.Default) {

            delay(delayTime)
            val itemList = petDao.queryVideoByType1(VideoType.LANDSCAPE.ordinal, startIndex, counts)
            itemList.forEach {
                it.user = petDao.queryUserByCode(it.authorId)
                it.videoData = petDao.queryVideoDataByCode(it.code)
            }
            var bannerList = mutableListOf<PetVideo>()
            if (startIndex == 0) {
                bannerList = petDao.queryBannerByType(VideoType.LANDSCAPE.ordinal)
                bannerList.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                    it.videoData = petDao.queryVideoDataByCode(it.code)
                }
            }
            LandscapeData(bannerList, itemList)
        }
    }

    suspend fun getHotData(startIndex: Int, counts: Int): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {

            delay(delayTime)
            val list = petDao.queryHotVideo1(startIndex, counts)
            list.forEach {
                val code = it.authorId
                if (code != 0) {
                    it.user = petDao.queryUserByCode(code)
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

        return withContext(Dispatchers.Default) {
            val list = petDao.queryUserVideos(code)
            val user = petDao.queryUserByCode(code)
            petDao.quertUserVideos(code, startIndex, counts)
        }
    }

    suspend fun getAllPetCoverUrl(): MutableList<CoverDownLoad> {

        return withContext(Dispatchers.Default) {
            petDao.queryAllPetCovers()
        }
    }

    suspend fun getAllUserCovers(): MutableList<HeaderDownLoad> {

        return withContext(Dispatchers.Default) {
            petDao.queryAllUserCovers()
        }
    }

    suspend fun saveHistory(history: History) {
        withContext(Dispatchers.Default) {
            val localHistory = petDao.queryHistoryByCode(history.code)
            if (localHistory == null) {//不存在的，一定为null
                petDao.insertHistory(history)
            } else {
                localHistory.lastTime = history.lastTime
                localHistory.playPosition = history.playPosition
                petDao.updateHistory(localHistory)
            }
        }
    }

    suspend fun removeHistory(list: MutableList<History>, isAll: Boolean) {
        withContext(Dispatchers.Default) {
            if (isAll) {
                petDao.deleteAllHistory()
            } else {
                petDao.deleteAllHistory(list)
            }
        }
    }

    suspend fun removeLaters(list: MutableList<PetVideo>, isAll: Boolean) {
        withContext(Dispatchers.Default) {
            if (isAll) {
                val laters = petDao.queryAllLaters()
                laters.forEach {
                    it.laterPlay = false
                    petDao.updateVideoData(it)
                }
            } else {
                list.forEach {
                    it.videoData?.let { data ->
                        data.laterPlay = false
                        petDao.updateVideoData(data)
                    }
                }
            }
        }
    }

    suspend fun removeLoves(list: MutableList<PetVideo>, isAll: Boolean) {
        withContext(Dispatchers.Default) {
            if (isAll) {
                val laters = petDao.queryAllLoves()
                laters.forEach {
                    it.love = false
                    if (it.loves >= 1) {
                        it.loves -= 1
                    }
                    petDao.updateVideoData(it)
                }
            } else {
                list.forEach {
                    it.videoData?.let { data ->
                        data.love = false
                        if (data.loves >= 1) {
                            data.loves -= 1
                        }
                        petDao.updateVideoData(data)
                    }
                }
            }
        }
    }

    suspend fun addLater(videoCode: Int) {

        withContext(Dispatchers.Default) {

            val videoData = petDao.queryVideoDataByCode(videoCode)
            if (videoData == null) {
                val vd = VideoData(
                    videoCode = videoCode,
                    laterPlay = true,
                    laterTime = System.currentTimeMillis()
                )
                petDao.insertVideoData(vd)
            } else {
                videoData.laterPlay = true
                videoData.laterTime = System.currentTimeMillis()
                petDao.updateVideoData(videoData)
            }
        }
    }

    suspend fun createGroup(groupName: String, groupDesc: String, isOpen: Boolean): Boolean {

        return withContext(Dispatchers.Default) {

            val maxCode = petDao.queryMaxGroupCode()
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
                creatorCode = AppInfos.AUTHOR_ID
            )
            petDao.insertGroupInfo(group)
            delay(1000)
            true
        }
    }

    suspend fun removeGroup(groupCode: Int): Boolean {

        return withContext(Dispatchers.Default) {

            val group = petDao.queryGroupByCode(groupCode)
            group?.let {
                petDao.deleteGroup(it)
                petDao.deleteGroupItems(it.groupCode)
            }
            delay(1000)
            true
        }
    }

    /**
     * 获取当前视频信息，用户信息，和推荐视频
     */
    suspend fun getVideoInfo(code: Int, counts: Int): VideoInfo {

        return withContext(Dispatchers.Default) {
            val startTime = System.currentTimeMillis()
            val videoUser = petDao.queryVideoUserByCode(code)
            val user = videoUser.user
            val video = videoUser.video

            user.videoCounts = petDao.queryUserVideoCounts(video.authorId)
            video.user = user

            video.videoData = petDao.queryVideoDataByCode(code)
            val list = petDao.queryRecommendVideos(video.type, video.authorId, code, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                    it.videoData = petDao.queryVideoDataByCode(it.code)
                }
            }
            if (list.size < counts) {
                val list1 =
                    petDao.queryRecoVideosByType(video.type, video.authorId, (counts - list.size))
                if (list1.isNotEmpty()) {
                    list1.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                        it.videoData = petDao.queryVideoDataByCode(it.code)
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

        return withContext(Dispatchers.Default) {
            val video = petDao.queryVideoByCode(code)
            val videoData = petDao.queryVideoDataByCode(code)
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

    suspend fun getAiRecommend(code: Int, type: Int, counts: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            val list = petDao.queryByType(code, type, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            list
        }
    }

    suspend fun search(words: String): MutableList<SearchInfo> {

        return withContext(Dispatchers.Default) {
            petDao.queryByKeyWords("%$words%", 10)
        }
    }

    suspend fun getPetVideoByKeys(keys: String, counts: Int): MutableList<PetVideo> {
        return withContext(Dispatchers.Default) {
            petDao.queryVideosByKeyWords("%$keys%", counts)
        }
    }

    suspend fun searchPeriod(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser> {

        return withContext(Dispatchers.Default) {

            if (startIndex == 0) {
                delay(500)
            }
            if (period == PeriodType.CUTE.ordinal) {
                petDao.queryLovedByKey("%$words%", startIndex, counts)
            } else {
                petDao.queryPeriedByKey("%$words%", period, startIndex, counts)
            }
//            if (list.isNotEmpty()) {
//                list.forEach {
//                    it.user = petDao.queryUserByCode(it.authorId)
//                }
//            }
        }
    }

    suspend fun getCMBannerList(
        startIndex: Int,
        counts: Int
    ): BannerListBean {

        return withContext(Dispatchers.Default) {

            val bannerListBean = BannerListBean()
            val list = petDao.queryRandomList(startIndex, counts)
            Log.e("1mean", "banner list : ${list.size}")
            if (startIndex == 0 && list.isNotEmpty() && list.size > 5) {
                list.forEachIndexed { index, videoAndUser ->
                    if (index < 5) {
                        bannerListBean.bannerList.add(videoAndUser.video)
                    } else {
                        bannerListBean.itemList.add(videoAndUser)
                    }
                }
            } else {
                bannerListBean.itemList.addAll(list)
            }
            bannerListBean
        }
    }

    suspend fun getPandas(
        name: String,
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser> {

        return withContext(Dispatchers.Default) {

            when (name) {
                "熊猫宝宝" -> {
                    petDao.queryByPeried(PeriodType.BABY.ordinal, startIndex, counts)
                }
                "熊猫妈妈" -> {
                    petDao.queryByPeried(PeriodType.MOM.ordinal, startIndex, counts)
                }
                "幼年班" -> {
                    petDao.queryByPeried(PeriodType.GROUP.ordinal, startIndex, counts)
                }
                "成长记" -> {
                    petDao.queryByPeried(PeriodType.ALL.ordinal, startIndex, counts)
                }
                "科普" -> {
                    petDao.queryByPeried(PeriodType.KNOWLEDGE.ordinal, startIndex, counts)
                }
                else -> {
                    petDao.queryPandaByName("%$name%", startIndex, counts)
                }
            }
        }
    }

    suspend fun searchByPage(words: String, startIndex: Int): MutableList<VideoAndUser> {

        return withContext(Dispatchers.Default) {
            petDao.queryWordsByPage("%$words%", startIndex, 10)
        }
    }

    suspend fun getHistory(startIndex: Int, counts: Int): MutableList<HistoryItem> {

        return withContext(Dispatchers.Default) {

            val historyList = mutableListOf<HistoryItem>()
            val history = petDao.queryHistoryByPage(startIndex, counts)
            history.forEach {
                val videoUser = petDao.queryVideoUserByCode(it.code)
                if (videoUser != null) {
                    videoUser.video.user = videoUser.user
                    videoUser.video.videoData = petDao.queryVideoDataByCode(it.code)
                    val historyItem = HistoryItem(it, videoUser.video)
                    historyList.add(historyItem)
                }
            }
            historyList
        }
    }

    suspend fun getSelectedVideo(selects: MutableList<Int>): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {
            val list = mutableListOf<PetVideo>()
            if (selects.isNotEmpty()) {
                selects.forEach {
                    val videoUser = petDao.queryVideoUserByCode(it)
                    val video = videoUser.video
                    video.user = videoUser.user
                    list.add(video)
                }
            }
            list
        }
    }

    suspend fun getLater(startIndex: Int, counts: Int): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {

            val laters = mutableListOf<PetVideo>()
            val videoDatas = petDao.queryLaterByPage(startIndex, counts)
            videoDatas.forEach {

                val videoUser = petDao.queryVideoUserByCode(it.videoCode)
                val video = videoUser.video
                video.user = videoUser.user
                video.videoData = it
                laters.add(video)
            }
            laters
        }
    }

    suspend fun getLove(startIndex: Int, counts: Int): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {

            val laters = mutableListOf<PetVideo>()
            val videoDatas = petDao.queryLoveByPage(startIndex, counts)
            videoDatas.forEach {
                val videoUser = petDao.queryVideoUserByCode(it.videoCode)
                if (videoUser != null) {
                    val video = videoUser.video
                    video.user = videoUser.user
                    video.videoData = it
                    laters.add(video)
                }
            }
            laters
        }
    }

    suspend fun getCollects(): MutableList<Group> {

        return withContext(Dispatchers.Default) {

            val groupInfos = petDao.queryGroupNoType(99)
            val group = petDao.queryGroupByType(99)
            group?.let {
                groupInfos.add(0, it)
            }

            if (groupInfos.isNotEmpty()) {
                groupInfos.forEach {
                    val counts = petDao.queryGroupItemCounts(it.groupCode)
                    if (counts > 0) {
                        it.videoCounts = counts
                        val topItem = petDao.queryGroupItemsAndVideo(it.groupCode)
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
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {
            val list = mutableListOf<PetVideo>()
            val items = petDao.queryGroupItemsAndVideos(groupCode, startIndex, counts)
            if (items.isNotEmpty()) {
                items.forEach {
                    val video = it.video
                    video.user = petDao.queryUserByCode(video.authorId)
                    video.videoData = petDao.queryVideoDataByCode(video.code)
                    list.add(video)
                }
            }
            list
        }
    }

    suspend fun getUser(userCode: Int): User {

        return withContext(Dispatchers.IO) {
            petDao.queryUserByCode(userCode)
        }
    }

    /**
     * 更新VideoData
     */
    suspend fun addOrUpdateVideoData(videoData: VideoData) {

        withContext(Dispatchers.Default) {
            val data = petDao.queryVideoDataByCode(videoData.videoCode)
            if (data == null) {
                petDao.insertVideoData(videoData)
            } else {
                videoData.id = data.id
                petDao.updateVideoData(videoData)
            }
        }
    }

    suspend fun updatePetVideo(petVideo: PetVideo) {

        withContext(Dispatchers.Default) {
            val video = petDao.queryVideoByCode(petVideo.code)
            if (video == null) {
                throw NullPointerException("no video by videoCode=${petVideo.code}")
            } else {
                petVideo.id = video.id
                Log.e("1mean", "petvideo:$petVideo")
                petDao.updatePetVideo(petVideo)
            }
        }
    }

    suspend fun addOrUpdateVideoData(videoCode: Int, isLike: Boolean) {

        withContext(Dispatchers.Default) {
            val data = petDao.queryVideoDataByCode(videoCode)
            data?.let {
                it.like = isLike
                if (isLike) {
                    it.likes += 1
                } else {
                    it.likes -= 1
                }
                petDao.updateVideoData(it)
            }
            if (data == null) {
                val videoData =
                    VideoData(videoCode = videoCode, like = isLike, plays = 1)
                if (isLike) {
                    videoData.likes = 1
                }
                petDao.insertVideoData(videoData)
            }
        }
    }

    suspend fun updateIsCollect(videoCode: Int, isCollect: Boolean) {

        withContext(Dispatchers.Default) {
            val data = petDao.queryVideoDataByCode(videoCode)
            data?.let {
                it.collect = isCollect
                if (isCollect) {
                    it.collectTime = System.currentTimeMillis()
                } else {
                    it.collectTime = 0L
                }
                petDao.updateVideoData(it)
            }
        }
    }

    suspend fun updateLove(videoCode: Int, isLove: Boolean) {

        withContext(Dispatchers.Default) {
            val data = petDao.queryVideoDataByCode(videoCode)
            data?.let {
                it.love = isLove
                petDao.updateVideoData(it)
            }
        }
    }

    suspend fun updateAttention(userCode: Int) {

        withContext(Dispatchers.Default) {
            val user = petDao.queryUserByCode(userCode)
            user.attention = !user.attention
            petDao.updateUser(user)
        }
    }

    suspend fun addCollection(groupName: String, videoCode: Int) {

        withContext(Dispatchers.Default) {

            val group = petDao.queryGroupByName(groupName)

            group?.let {

                val item = petDao.queryGroupItem(it.groupCode, videoCode)
                if (item == null) {
                    val groupItem = GroupVideoItem(groupCode = it.groupCode, videoCode = videoCode)
                    petDao.insertGroupItem(groupItem)
                }
                val counts = petDao.queryGroupItemCounts(it.groupCode)
                it.updateTime = System.currentTimeMillis()
                it.videoCounts = counts
                petDao.updateGroupInfo(it)
            }

            if (group == null) {

                val maxCode = petDao.queryMaxGroupCode()
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
                    creatorCode = AppInfos.AUTHOR_ID
                    type = 99
                }
                petDao.insertGroupInfo(groupInfo)

                val item = petDao.queryGroupItem(currentGroupCode, videoCode)
                if (item == null) {
                    val groupItem =
                        GroupVideoItem(groupCode = currentGroupCode, videoCode = videoCode)
                    petDao.insertGroupItem(groupItem)
                }
            }
        }
    }

    suspend fun deleteCollection(groupName: String, videoCode: Int) {

        withContext(Dispatchers.Default) {

            val group = petDao.queryGroupByName(groupName)
            group?.let {
                val item = petDao.queryGroupItem(it.groupCode, videoCode)
                item?.let { groupItem ->
                    petDao.deleteGroupItem(groupItem)
                    it.videoCounts = petDao.queryGroupItemCounts(it.groupCode)
                    it.updateTime = System.currentTimeMillis()
                    petDao.updateGroupInfo(it)
                }
            }
        }
    }

    suspend fun addOrUpdateVideoData(videoCode: Int, playPos: Long) {

        withContext(Dispatchers.Default) {

            val data = petDao.queryVideoDataByCode(videoCode)
            if (data == null) {
                val videoData = VideoData(videoCode = videoCode, playPosition = playPos)
                petDao.insertVideoData(videoData)
            } else {
                if (data.playPosition != playPos) {
                    data.playPosition = playPos
                    petDao.updateVideoData(data)
                }
            }
        }
    }

    suspend fun getAllFollowUsers(): MutableList<User> {

        return withContext(Dispatchers.Default) {
            delay(delayTime)
            petDao.queryAllAttentionUsers()
        }
    }

    suspend fun getAllFollowCounts(): Int {
        return withContext(Dispatchers.Default) {
            petDao.queryAllAttentionCounts()
        }
    }

    /****视频弹幕界面*************************************************************************/
    suspend fun getVideoCommentByPage(
        isOrderByTime: Boolean,
        videoCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.Default) {

            delay(500)
            //先获取一级弹幕
            val list = if (isOrderByTime) {//获取时间顺序的数据
                petDao.queryPageCommentsByType(videoCode, startIndex, counts, 1)
            } else {
                petDao.queryCommentsByHot(videoCode, startIndex, counts, 1)
            }

            if (list.isNotEmpty()) {
                list.forEach {
                    val childList =
                        petDao.queryVideoChildComment(it.comment.videoCode, it.comment.commentId)
                    if (childList.isNotEmpty()) {
                        it.comment.replyComments = childList
                    }
                }
            }
            list
        }
    }

    suspend fun getPageComments(
        isOrderByTime: Boolean,
        videoCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.Default) {
            //先获取一级弹幕
            val list = if (isOrderByTime) {//获取时间顺序的数据
                petDao.queryPageCommentsByType(videoCode, startIndex, counts, 1)
            } else {
                petDao.queryCommentsByHot(videoCode, startIndex, counts, 1)
            }
            if (list.isNotEmpty()) {
                list.forEach {
                    val count =
                        petDao.queryCommentReplyCounts(it.comment.videoCode, it.comment.id)
                    if (count > 0) {
                        it.comment.replyCounts = count
                    } /*else{
                        it.comment.replyCounts = (1..10).random()
                    }*/
                }
            }
            list
        }
    }

    suspend fun getPageRanks(
        startIndex: Int,
        counts: Int
    ): MutableList<VideoAndUser> {

        return withContext(Dispatchers.Default) {
            petDao.queryVideosByReleaseTime(startIndex, counts)
        }
    }

    suspend fun getPageReplyComments(
        startIndex: Int,
        pageCounts: Int,
        videoCode: Int,
        topCommentId: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.Default) {
            delay(200)
            petDao.queryReplyComments(videoCode, topCommentId, startIndex, pageCounts)
        }
    }

    /**
     * 获取弹幕的回复信息
     */
    suspend fun getCommentReplyByPage(
        videoCode: Int,
        commentId: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.IO) {

            if (startIndex == 0) {
                val comments = mutableListOf<CommentAndUser>()
                val topComment = petDao.queryCommentUserByCommentId(videoCode, commentId)
                comments.add(0, topComment)
                val list = petDao.queryReplyByPage(videoCode, commentId, startIndex, counts - 1)
                if (list.isNotEmpty()) {
                    comments.addAll(list)
                }
                comments
            } else {
                petDao.queryReplyByPage(videoCode, commentId, startIndex, counts)
            }
        }
    }

    /**
     * 发送一条弹幕，同时videodata列表应该+1
     */
    suspend fun sendComment(comment: VideoComment): VideoComment {
        return withContext(Dispatchers.Default) {
            val commentId = petDao.insertComment(comment)
            val videoComment = petDao.queryCommentById(commentId.toInt())
            if (videoComment != null) {//消息个数+1
                val videoData = petDao.queryVideoDataByCode(comment.videoCode)
                if (videoData == null) {
                    val vd = VideoData(videoCode = comment.videoCode, comments = 1)
                    petDao.insertVideoData(vd)
                } else {
                    videoData.comments += 1
                    petDao.updateVideoData(videoData)
                }
            }
            videoComment
        }
    }

    suspend fun updateVideoComment(comment: VideoComment) {
        return withContext(Dispatchers.Default) {
            petDao.updateVideoComment(comment)
        }
    }

    suspend fun saveComment(
        replyInfo: ReplyInfo?,
        content: String,
        videoCode: Int
    ): CommentAndUser {
        return withContext(Dispatchers.Default) {
            val comment = VideoComment()
            //当没有评论时，获取到的id是null，以String类型返回
            //不使用id是因为可能每一次调整数据库，该数据的id会不同，不能保证唯一性
            var maxCommentId = petDao.queryMaxCommentId(videoCode)
            if (maxCommentId.isNullOrEmpty()) {
                maxCommentId = "0"
            }
            comment.commentId = maxCommentId.toInt() + 1
            if (replyInfo == null) {
                comment.type = 1
            } else {
                comment.type = replyInfo.type
                comment.fromUserName = AppInfos.AUTHOR_NAME
                comment.toUserName = replyInfo.replyUserName
                comment.toUserCode = replyInfo.replyUserCode
                comment.topCommentId = replyInfo.commentId
            }
            val user = petDao.queryUserByCode(AppInfos.AUTHOR_ID)
            comment.fromUserCode = AppInfos.AUTHOR_ID
            comment.commitTime = System.currentTimeMillis()
            comment.content = content
            comment.videoCode = videoCode
            petDao.insertComment(comment)
            val videodata = petDao.queryVideoDataByCode(videoCode)
            videodata?.let {
                it.comments += 1
                petDao.updateVideoData(it)
            }
            delay(300)
            CommentAndUser(comment, user)
        }
    }

    suspend fun saveReply(
        replyInfo: ReplyInfo,
        content: String
    ): CommentAndUser {
        return withContext(Dispatchers.Default) {
            val comment = VideoComment()
            //当没有评论时，获取到的id是null，以String类型返回
            var maxCommentId = petDao.queryMaxCommentId(replyInfo.videoCode)
            if (maxCommentId.isNullOrEmpty()) {
                maxCommentId = "0"
            }
            comment.commentId = maxCommentId.toInt() + 1
            comment.type = replyInfo.type
            comment.fromUserName = AppInfos.AUTHOR_NAME
            comment.toUserName = replyInfo.replyUserName
            comment.toUserCode = replyInfo.replyUserCode
            comment.topCommentId = replyInfo.commentId
            val user = petDao.queryUserByCode(AppInfos.AUTHOR_ID)
            comment.fromUserCode = AppInfos.AUTHOR_ID
            comment.commitTime = System.currentTimeMillis()
            comment.content = content
            comment.videoCode = replyInfo.videoCode
            petDao.insertComment(comment)
            delay(300)
            CommentAndUser(comment, user)
        }
    }

    suspend fun getLiveVides(isRefresh: Boolean, startIndex: Int, counts: Int): LiveVideoData {

        return withContext(Dispatchers.Default) {

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
                it.user = petDao.queryUserByCode(it.authorId)
                it.videoData = petDao.queryVideoDataByCode(it.code)
            }
            val videoDatas = petDao.queryMaxPlayedVideos()
            videoDatas.forEach {
                it.user = petDao.queryUserByCode(it.authorId)
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