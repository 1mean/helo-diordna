package com.example.pandas.biz.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.viewmodel.BaseViewModel

/**
 * @description: 全局viewmodel
 * @author: dongyiming
 * @date: 7/5/22 12:09 上午
 * @version: v1.0
 */
public class MainFragmentViewModel : BaseViewModel() {


    val bottomState: MutableLiveData<Int> by lazy { MutableLiveData() }

    fun updateBottomBackground(status: Int) {
        bottomState.value = status
    }

}
