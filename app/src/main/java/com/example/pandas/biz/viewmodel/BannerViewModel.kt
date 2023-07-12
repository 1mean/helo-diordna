package com.example.pandas.biz.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pandas.app.AppInfos
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.bean.HistoryItem
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: BannerViewModel
 * @author: dongyiming
 * @date: 7/8/23 12:29 AM
 * @version: v1.0
 */
public class BannerViewModel : BaseViewModel() {

    val bestList: MutableLiveData<UIDataWrapper<PetVideo>> by lazy { MutableLiveData() }

    private var startIndex1 = 0
    private var startIndex2 = 0
    private var startIndex3 = 0
    private var startIndex4 = 0
    private var pages = 0
    private var videoCodes1: MutableList<Int> = mutableListOf()
    private var videoCodes2: MutableList<Int> = mutableListOf()
    private var videoCodes3: MutableList<Int> = mutableListOf()

    fun getBest(isRefresh: Boolean, position: Int) {

        if (isRefresh) {
            pages = 13
            when (position) {
                0 -> {
                    startIndex1 = 0
                    videoCodes1.clear()
                    videoCodes1.addAll(AppInfos.bestPandaVideoCodes)
                }
                1 -> {
                    startIndex2 = 0
                    videoCodes2.clear()
                    videoCodes2.addAll(AppInfos.bestAnimalVideoCodes)
                }
                2 -> {
                    startIndex3 = 0
                    videoCodes3.clear()
                    videoCodes3.addAll(AppInfos.bestBeautyVideoCodes)
                }
                3 -> startIndex4 = 0
            }

        } else {
            pages = 10
        }

        val selects = mutableListOf<Int>()
        for (i in 0 until pages) {
            when (position) {
                0 -> {
                    if (videoCodes1.isEmpty()) {
                        break
                    }
                    val selected = videoCodes1.random()
                    selects.add(selected)
                    videoCodes1.remove(selected)
                }
                1 -> {
                    if (videoCodes2.isEmpty()) {
                        break
                    }
                    val selected = videoCodes2.random()
                    selects.add(selected)
                    videoCodes2.remove(selected)
                }
                2 -> {
                    if (videoCodes3.isEmpty()) {
                        break
                    }
                    val selected = videoCodes3.random()
                    selects.add(selected)
                    videoCodes3.remove(selected)
                }
            }
        }

        request({
            when (position) {
                0, 1, 2 -> PetManagerCoroutine.getSelectedVideo(selects)
                else -> PetManagerCoroutine.getCutePetByType(
                    VideoType.BIRD.ordinal, startIndex4, pages + 1
                )
            }
        },
            {
                var hasMore = false
                when (position) {
                    0 -> {
                        if (videoCodes1.isNotEmpty()) {
                            hasMore = true
                        }
                    }
                    1 -> {
                        if (videoCodes2.isNotEmpty()) {
                            hasMore = true
                        }
                    }
                    2 -> {
                        if (videoCodes3.isNotEmpty()) {
                            hasMore = true
                        }
                    }
                    3 -> {
                        if (it.size > pages) {
                            hasMore = true
                            it.removeLast()
                        }
                        startIndex4 += pages
                    }
                }

                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    listData = it
                )
                bestList.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetVideo>()
                )
                bestList.value = dataList
            })
    }
}