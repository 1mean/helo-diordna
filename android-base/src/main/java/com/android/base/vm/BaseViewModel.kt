package com.android.base.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.base.exception.AppException
import com.android.base.exception.ExceptionHandle
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @description: BaseViewModel
 * @author: dongyiming
 * @date: 1/19/22 1:16 下午
 * @version: v1.0
 */
open class BaseViewModel : ViewModel() {

    //val commentResult: MutableLiveData<VideoComment> by lazy { MutableLiveData() }
//    val updateUserResult: SingleLiveData<User> by lazy { SingleLiveData() }
    //val user: SingleLiveData<User> by lazy { SingleLiveData() }

    fun <T> request(
        block: suspend () -> MutableList<T>,
        success: (MutableList<T>) -> Unit,
        error: (AppException) -> Unit = {}
    ): Job {
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                success(it)
            }.onFailure {
                //it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

    fun <T> requests(
        block: suspend () -> T,
        success: (T) -> Unit,
        error: (AppException) -> Unit = {}
    ): Job {
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                success(it)
            }.onFailure {
                //it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }

//    fun isAttention(context: Context, id: Int): Boolean {
//
//        val list = SPUtils.getList<String>(context, AppInfos.ATTENTION_KEY)
//        if (list.isEmpty()) {
//            return false
//        } else {
//            return list.contains(id.toString())
//        }
//    }

//    fun follow(context: Context, userCode: Int) {
//        viewModelScope.launch {
//            withContext(Dispatchers.Default) {
//                SPUtils.saveList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
//            }
//        }
//    }

//    fun unFollow(context: Context, userCode: Int) {
//        viewModelScope.launch {
//            withContext(Dispatchers.Default) {
//                SPUtils.removeFromList<String>(context, AppInfos.ATTENTION_KEY, userCode.toString())
//            }
//        }
//    }

//    fun addOrUpdateVideoData(videoData: VideoData) {
//        viewModelScope.launch {
//            PetManagerCoroutine.addOrUpdateVideoData(videoData)
//        }
//    }

//    fun updatePetVideo(video: PetVideo) {
//        viewModelScope.launch {
//            PetManagerCoroutine.updatePetVideo(video)
//        }
//    }

//    fun addLaterPlayer(videoCode: Int) {
//        viewModelScope.launch {
//            PetManagerCoroutine.addLater(videoCode)
//        }
//    }

//    fun sendComment(comment: VideoComment) {
//        viewModelScope.launch {
//            commentResult.value = PetManagerCoroutine.sendComment(comment)
//        }
//    }

//    fun updateUser(user: User) {
//        viewModelScope.launch {
//            updateUserResult.value = PetManagerCoroutine.updateUser(user)
//        }
//    }

//    fun reName(userName: String, userCode: Int) {
//        viewModelScope.launch {
//            PetManagerCoroutine.reName(userName, userCode)
//        }
//    }

//    fun reSign(sign: String, userCode: Int) {
//        viewModelScope.launch {
//            PetManagerCoroutine.reSign(sign, userCode)
//        }
//    }

//    fun reSex(sex: Int, userCode: Int) {
//        viewModelScope.launch {
//            PetManagerCoroutine.reSex(sex, userCode)
//        }
//    }

//    fun getUserByCode(userCode: Int) {
//        viewModelScope.launch {
//            user.value = PetManagerCoroutine.getUser(userCode)
//        }
//    }
}