package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.LandscapeData
import com.example.pandas.bean.MusicBean
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoAndUser
import kotlinx.coroutines.launch

/**
 * @description: homefragment viewmodel
 * @author: dongyiming
 * @date: 1/18/22 6:07 下午
 * @version: v1.0
 */
class HomePageViewModel : BaseViewModel() {

    var startIndex = 0//分页起始
    var petIndex = 0
    var recoIndex = 0
    var landIndex = 0
    var hotIndex = 0
    var musicIndex = 0
    var hasMore = true//是否有更多
    var hotHasMore = true//是否有更多
    var pandaHasMore = true//是否有更多
    private var videoCodes: MutableList<Int> = mutableListOf()

    /***********************************************************************************
     * LiveData是不可变的，MutableLiveData是可变的
     * - 官方框架里：ViewModel内部使用了private的MutableLiveData实例，但对外暴露的是LiveData类型
     * *
     *   private val _user =  MutableLiveData<User>()
     *   val user:LiveData<User> = _user
     *   init{
     *       viewModelScope.launch{
     *               _user.value = dao.getUser(userId)
     *       }
     *   }
     ************************************************************************************/

    val petDataWrapper: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    val recommendDataWrapper: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    val loveDataWrapper: MutableLiveData<UIDataWrapper<PageCommonData>> by lazy { MutableLiveData() }

    val landScapeDataWrapper: MutableLiveData<UIDataWrapper<LandscapeData>> by lazy { MutableLiveData() }

    val hotDataWrapper: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    val musicData: MutableLiveData<MutableList<VideoAndUser>> by lazy { MutableLiveData() }

    val songDataWrapper: MutableLiveData<UIDataWrapper<MusicVo>> by lazy { MutableLiveData() }

    val musicData2: MutableLiveData<UIDataWrapper<MusicBean>> by lazy { MutableLiveData() }

    fun getPagePet(isRefresh: Boolean) {

        if (isRefresh) {
            videoCodes.clear()
            videoCodes.addAll(AppInfos.bestPandaVideoCodes)
        }
        val selects = mutableListOf<Int>()
        for (i in 0 until 20) {
            if (videoCodes.isEmpty()) {
                break
            }
            val selected = videoCodes.random()
            selects.add(selected)
            videoCodes.remove(selected)
        }

        request({ PetManagerCoroutine.getSelectedVideo(selects) },
            {
                //请求数据成功
                pandaHasMore = videoCodes.isNotEmpty()

                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = pandaHasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                petDataWrapper.value = dataList
            },
            {
                //请求数据失败
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                petDataWrapper.value = dataList
            })
    }

    private var hasMoreReco = false

    /**
     *  首页-推荐
     *
     * @author: dongyiming
     * @date: 2/7/22 5:26 下午
     * @version: v1.0
     */
    fun getRecommendData(isRefresh: Boolean) {

        var page = 0
        if (isRefresh) {
            recoIndex = 0
            page = 23
        } else {
            page = 12
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getRecommendByPage(recoIndex, page)
            }.onSuccess {
                hasMoreReco = it.itemList.isNotEmpty() && it.itemList.size >= page
                if (hasMoreReco) {
                    it.itemList.removeLast()
                }
                val wrapper = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    hasMore = hasMoreReco,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    recoData = it
                )
                recoIndex += if (isRefresh) 22 else 11
                recommendDataWrapper.value = wrapper
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PetVideo>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    recoData = RecommendData()
                )
                recommendDataWrapper.value = dataList
            }
        }
    }

    fun getLoveData(isRefresh: Boolean) {

        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getLoveData(isRefresh, startIndex)
            }.onSuccess {
                startIndex += if (startIndex == 0) 10 else 11
                val dataList = UIDataWrapper<PageCommonData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    loveData = it
                )
                loveDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PageCommonData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                )
                loveDataWrapper.value = dataList
            }
        }
    }

    fun getLandScapeData(isRefresh: Boolean) {

        if (isRefresh) {
            landIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getLandscapeData(landIndex, 11)
            }.onSuccess {

                hasMore = if (it.itemList.size > 10) {
                    it.itemList.removeLast()
                    true
                } else {
                    false
                }

                val dataList = UIDataWrapper<LandscapeData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    landscapeData = it
                )
                landIndex += 10
                landScapeDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<LandscapeData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    landscapeData = LandscapeData()
                )
                landScapeDataWrapper.value = dataList
            }
        }
    }

    fun getHotData(isRefresh: Boolean) {

        if (isRefresh) {
            hotIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getHotData(hotIndex, 11)
            }.onSuccess {

                hotHasMore = if (it.size > 10) {
                    it.removeLast()
                    true
                } else {
                    false
                }

                val dataList = UIDataWrapper<PetVideo>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hotHasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                hotIndex += 10
                hotDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PetVideo>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf()
                )
                hotDataWrapper.value = dataList
            }
        }
    }

    fun getMusicTopData() {
        viewModelScope.launch {
            musicData.value =
                PetManagerCoroutine.getVideosByVideoType(VideoType.MUSIC.ordinal, 0, 2)
        }
    }

    fun getMusic() {

        viewModelScope.launch {
            kotlin.runCatching {
                PetManagerCoroutine.getMusic()
            }.onSuccess {
                val musicBean = UIDataWrapper<MusicBean>(
                    isSuccess = true,
                    musicBean = it
                )
                musicData2.value = musicBean
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val musicBean = UIDataWrapper<MusicBean>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    musicBean = MusicBean()
                )
                musicData2.value = musicBean
            }
        }
    }

    var songHasMore = false
    fun getSongData(isRefresh: Boolean, type: Int) {

        if (isRefresh) {
            musicIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getPageMusic(type, musicIndex, 21)
            }.onSuccess {
                if (type == 0) {
                    songHasMore = if (it.size > 20) {
                        it.removeLast()
                        true
                    } else {
                        false
                    }
                    val dataList = UIDataWrapper(
                        isSuccess = true,
                        isRefresh = isRefresh,
                        isEmpty = it.isEmpty(),
                        hasMore = songHasMore,
                        isFirstEmpty = isRefresh && it.isEmpty(),
                        listData = it
                    )
                    musicIndex += 20
                    songDataWrapper.value = dataList
                } else {
                    val dataList = UIDataWrapper(
                        isSuccess = true,
                        isRefresh = isRefresh,
                        isEmpty = it.isEmpty(),
                        hasMore = false,
                        isFirstEmpty = isRefresh && it.isEmpty(),
                        listData = it
                    )
                    songDataWrapper.value = dataList
                }
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<MusicVo>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    landscapeData = LandscapeData()
                )
                songDataWrapper.value = dataList
            }
        }
    }
}