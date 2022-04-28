package com.example.pandas.biz.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.app.AppInfos
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.utils.SPUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @description: UserInfoViewModel
 * @author: dongyiming
 * @date: 4/21/22 5:36 下午
 * @version: v1.0
 */
public class UserInfoViewModel : BaseViewModel() {

    var startIndex = 0//分页起始
    var hasMore = true//是否有更多
    var authorName: String? = null

    val userVideos: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    fun getUserVideos(name: String, isRefresh: Boolean) {

        if (authorName == null) {
            authorName = name
        }

        if (isRefresh) {
            startIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getUserVideos(name, startIndex, 11)
            }.onSuccess {

                hasMore = if (it.size > 10) {
                    it.removeLast()
                    true
                } else {
                    false
                }

                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 10
                userVideos.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf()
                )
                userVideos.value = dataList
            }
        }
    }

    fun addAttention(context: Context,userCode:Int){

        viewModelScope.launch(Dispatchers.IO){
            SPUtils.saveList(context,AppInfos.ATTENTION_KEY,userCode.toString())
        }
    }

    fun deleteAttention(context: Context,userCode:Int){
        viewModelScope.launch(Dispatchers.IO){
            SPUtils.removeFromList(context,AppInfos.ATTENTION_KEY,userCode.toString())
        }
    }
}