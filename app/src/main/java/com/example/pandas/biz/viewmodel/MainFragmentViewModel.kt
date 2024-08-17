package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.android.base.vm.BaseViewModel

/**
 * @description: 全局viewmodel
 * @author: dongyiming
 * @date: 7/5/22 12:09 上午
 * @version: v1.0
 */
public class MainFragmentViewModel : BaseViewModel() {


    val bottomState: MutableLiveData<Int> by lazy { MutableLiveData() }

    val refreshPosition: MutableLiveData<Int> by lazy { MutableLiveData() }

    fun updateBottomBackground(status: Int) {//0为常规底部，1为短视频底部
        bottomState.value = status
    }

    fun updateRefreshPosition(position:Int){
        refreshPosition.value = position
    }
}
