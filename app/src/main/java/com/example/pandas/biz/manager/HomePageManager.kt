package com.example.pandas.biz.manager

import com.example.pandas.bean.CoverDownLoad
import com.example.pandas.bean.HistoryItem
import com.example.pandas.bean.LandscapeData
import com.example.pandas.bean.SearchInfo
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.History
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User
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

    suspend fun getPetByPage(startIndex: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            val list = petDao.queryByTypeAndPage(VideoType.PANDA.ordinal, startIndex, 20)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            list
        }
    }

    /**
     * 获取相关videoType的分页数据
     */
    suspend fun getPageByType(type: Int, startIndex: Int, counts: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            val list = petDao.queryVideoByType(type, startIndex, counts)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            list
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


    suspend fun getVideoByFileName(fileName: String): PetViewData {

        val video = petDao.queryVideoByFileName(fileName)
        video.user = petDao.queryUserByCode(video.authorId)
        return video
    }


    /**
     * 获取首页推荐栏数据
     * @param: pageNo ： 只有第一页才有轮播图
     * @return: 页面分布：轮播图+star视频+横屏视频
     * @date: 1/22/22 7:47 下午
     * @version: v1.0
     */
    suspend fun getRecommendByPage(startIndex: Int): RecommendData<PetViewData> {

        return withContext(Dispatchers.IO) {
            val recommendData = RecommendData<PetViewData>()
            if (startIndex == 0) {//首页
                recommendData.bannerList = petDao.queryRecoBanner(1)
                val list = petDao.queryStarByPage(startIndex, 10)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
                    }
                }
                recommendData.itemList = list
            } else {
                val list = petDao.queryStarByPage(startIndex, 11)
                if (list.isNotEmpty()) {
                    list.forEach {
                        it.user = petDao.queryUserByCode(it.authorId)
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

            val data = PageCommonData()
            if (isFresh) {
                data.run {
                    horizontalVideos = getHorVideos()
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

            delay(300)
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

            delay(300)
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

            delay(300)
            petDao.queryVideosByCode(code, startIndex, counts)
        }
    }

    suspend fun getAllPetCoverUrl(): MutableList<CoverDownLoad> {

        return withContext(Dispatchers.IO) {
            petDao.queryAllPetCovers()
        }
    }

    fun saveHistory(history: History) {
        val localHistory = petDao.queryHistoryByCode(history.code)
        if (localHistory == null) {//不存在的，一定为null
            petDao.insertHistory(history)
        } else {
            localHistory.lastTime = history.lastTime
            localHistory.playPosition = history.playPosition
            petDao.updateHistory(localHistory)
        }
    }

    suspend fun getVideoByCode(code: Int): PetVideo {

        return withContext(Dispatchers.IO) {
            val video = petDao.queryVideoByCode(code)
            if (video.authorId != 0) {
                val user = petDao.queryUserByCode(video.authorId)
                video.user = user
            }
            video
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

        return withContext(Dispatchers.IO) {
            petDao.queryByKeyWords("%$words%")
        }
    }

    suspend fun searchPeriod(
        words: String,
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            petDao.queryPeriedByKey("%$words%", period, startIndex, counts)
        }
    }

    suspend fun searchByPeriod(
        period: Int,
        startIndex: Int,
        counts: Int
    ): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            petDao.queryByPeried(period, startIndex, counts)
        }
    }

    suspend fun searchByPage(words: String, startIndex: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            val list = petDao.queryWordsByPage("%$words%", startIndex, 10)
            if (list.isNotEmpty()) {
                list.forEach {
                    it.user = petDao.queryUserByCode(it.authorId)
                }
            }
            list
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

    fun getHorVideos(): MutableList<PetViewData> {

        val list = mutableListOf<PetViewData>()
        val pandaUrl =
            "https://i1.hdslb.com/bfs/archive/e6e38cd16c7050cfbd510b8d44eb2e82919a78f9.jpg"
        val foxUrl = "https://i0.hdslb.com/bfs/archive/c917011116fbe1dda527e580532b639514c47899.jpg"
        val penguinUrl =
            "https://i1.hdslb.com/bfs/archive/a6cf9cee1d99141c99741c86146e18398c620539.jpg"
        val monkeyUrl =
            "https://i0.hdslb.com/bfs/archive/6bb9554e8b9615019b4be1e9aa8aef621b1f0588.jpg"
        val birdUrl =
            "https://i2.hdslb.com/bfs/archive/7e4d79c66f22e8f0565cf2122c2248d95e17a557.jpg"
        val redPandaUrl =
            "https://i0.hdslb.com/bfs/archive/e7706c050c879e64ebbbeb4c9ae30a7d8518ac1d.png"
        val bearUrl =
            "https://i2.hdslb.com/bfs/archive/f1242657c843475898357e783da668d4201d78e7.jpg"
        val tigerUrl =
            "https://i0.hdslb.com/bfs/archive/4b58d5f6a462f534d02fc8d2856fe7e5aece389f.jpg"

        val panda = PetViewData(cover = pandaUrl, title = "大熊猫")
        val fox = PetViewData(cover = foxUrl, title = "狐狸")
        val penguin = PetViewData(cover = penguinUrl, title = "企鹅")
        val monkey = PetViewData(cover = monkeyUrl, title = "金丝猴")
        val bird = PetViewData(cover = birdUrl, title = "白鹭")
        val redPanda = PetViewData(cover = redPandaUrl, title = "小熊猫")
        val bear = PetViewData(cover = bearUrl, title = "北极熊")
        val tiger = PetViewData(cover = tigerUrl, title = "老虎")

        return list.apply {
            add(panda)
            add(fox)
            add(penguin)
            add(monkey)
            add(bird)
            add(redPanda)
            add(bear)
            add(tiger)
        }
    }

}