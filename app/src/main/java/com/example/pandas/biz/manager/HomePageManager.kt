package com.example.pandas.biz.manager

import android.content.Context
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
import com.example.pandas.utils.SPUtils
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

    private val petDao: PetVideoDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().petVideoDao()
    }

    suspend fun getPetByPage(
        startIndex: Int,
        counts: Int,
        isRefresh: Boolean
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {
            delay(200)
            val list = petDao.queryLovedPanda(startIndex, counts)
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
            delay(200)
            petDao.queryVideosByVideoType(type, startIndex, counts)
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
            val recommendData = RecommendData<PetVideo>()
            if (startIndex == 0) {//首页
                recommendData.bannerList = petDao.queryRecoBanner(1)
                val list = petDao.queryStarByPage(startIndex, counts)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                        it.videoData = petDao.queryVideoDataByCode(it.code)
                    }
                }
                recommendData.itemList = list
            } else {
                val list = petDao.queryStarByPage(startIndex, counts)
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
    suspend fun getCutePetBannerData(): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            delay(500)
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

        return withContext(Dispatchers.IO) {

            delay(500)
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
    suspend fun getPageMusic(startIndex: Int, counts: Int): MutableList<MusicVo> {

        return withContext(Dispatchers.IO) {
            petDao.queryMusicByPage(0, startIndex, counts)
        }
    }

    suspend fun getLandscapeData(startIndex: Int, counts: Int): LandscapeData {

        return withContext(Dispatchers.IO) {

            delay(500)
            val itemList = petDao.queryVideoByType(VideoType.LANDSCAPE.ordinal, startIndex, counts)
            itemList.forEach {
                it.user = petDao.queryUserByCode(it.authorId)
            }
            var bannerList = mutableListOf<PetViewData>()
            if (startIndex == 0) {
                bannerList = petDao.queryBannerByType(VideoType.LANDSCAPE.ordinal)
            }
            LandscapeData(bannerList, itemList)
        }
    }

    suspend fun getHotData(startIndex: Int, counts: Int): MutableList<PetVideo> {

        return withContext(Dispatchers.IO) {

            delay(500)
            val list = petDao.queryHotVideo(startIndex, counts)
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
    ): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {

            delay(500)
            petDao.queryVideosByCode(code, startIndex, counts)
        }
    }

    suspend fun getAllPetCoverUrl(): MutableList<CoverDownLoad> {

        return withContext(Dispatchers.IO) {
            petDao.queryAllPetCovers()
        }
    }

    suspend fun saveHistory(history: History) {
        withContext(Dispatchers.IO) {
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

    /**
     * 获取当前视频信息，用户信息，和推荐视频
     */
    suspend fun getVideoInfo(code: Int, counts: Int): VideoInfo {

        return withContext(Dispatchers.Default) {
            val video = petDao.queryVideoByCode(code)
            val user = petDao.queryUserByCode(video.authorId)
            user.videoCounts = petDao.queryUserVideoCounts(video.authorId)
            video.user = user

            val videoData = petDao.queryVideoDataByCode(code)
            Log.e("1mean", "videoData: $videoData")
            val comments = petDao.queryCommentCounts(code)
            if (videoData == null) {
                if (comments > 0) {
                    val vd = VideoData(videoCode = code, comments = comments)
                    petDao.insertVideoData(vd)
                    video.videoData = vd
                }
            } else {
                if (videoData.comments != comments) {
                    videoData.comments = comments
                    petDao.updateVideoData(videoData)
                }
                video.videoData = videoData
            }
            val list = petDao.queryRecommendVideos(video.type, video.authorId, code, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            if (list.size < counts) {
                val list1 =
                    petDao.queryRecoVideosByType(video.type, video.authorId, (counts - list.size))
                if (list1.isNotEmpty()) {
                    list1.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                    }
                }
                list.addAll(list1)
            }
            VideoInfo(video, list)
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
            petDao.queryByKeyWords("%$words%")
        }
    }

    suspend fun searchPeriod(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetVideo> {

        return withContext(Dispatchers.Default) {
            delay(300)
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
                "成长记录" -> {
                    petDao.queryByPeried(PeriodType.ALL.ordinal, startIndex, counts)
                }
                "熊猫科普" -> {
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

        return withContext(Dispatchers.IO) {

            val historyList = mutableListOf<HistoryItem>()
            val history = petDao.queryHistoryByPage(startIndex, counts)
            history.forEach {
                val viewData = petDao.queryViewDataByCode(it.code)
                val historyItem = HistoryItem(it, viewData)
                historyList.add(historyItem)
            }
            historyList
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
                petDao.updateVideoData(videoData)
            }
        }
    }

    suspend fun addOrUpdateVideoData(videoCode: Int, playPos: Long) {

        withContext(Dispatchers.IO) {

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

    suspend fun getAllFollowUsers(context: Context): MutableList<User> {

        return withContext(Dispatchers.IO) {

            delay(300)
            val list = SPUtils.getList<String>(context, AppInfos.ATTENTION_KEY)
            Log.e("111111mean", "list:$list")
            val users = mutableListOf<User>()
            if (list.isNotEmpty()) {
                list.forEach {
                    Log.e("111111mean", "it:$it")
                    val user = petDao.queryUserByCode(it.toInt())
                    users.add(user)
                }
            }
            users
        }
    }

    /****视频弹幕界面*************************************************************************/
    suspend fun getVideoCommentByPage(
        videoCode: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<CommentAndUser> {

        return withContext(Dispatchers.IO) {

            //先获取一级弹幕
            val list = petDao.queryVideoCommentByPage(videoCode, startIndex, counts, 1)
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
                Log.e("HomePageMnanger", "size: ${comments.size}")
                comments
            } else {
                petDao.queryReplyByPage(videoCode, commentId, startIndex, counts)
            }
        }
    }

    suspend fun saveComment(
        replyInfo: ReplyInfo?,
        content: String,
        videoCode: Int
    ): CommentAndUser {
        return withContext(Dispatchers.IO) {
            val comment = VideoComment()
            //当没有评论时，获取到的id是null，以String类型返回
            var maxCommentId = petDao.queryMaxCommentId(videoCode)
            if (maxCommentId.isNullOrEmpty()) {
                maxCommentId = "0"
            }
            comment.commentId = maxCommentId.toInt() + 1
            if (replyInfo == null) {
                comment.type = 1
            } else {
                comment.type = 2
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
            //petDao.insertComment(comment)
            delay(300)
            CommentAndUser(comment, user)
        }
    }

    suspend fun saveReply(
        replyInfo: ReplyInfo,
        content: String
    ): CommentAndUser {
        return withContext(Dispatchers.IO) {
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
            //petDao.insertComment(comment)
            delay(300)
            CommentAndUser(comment, user)
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