package com.example.pandas.biz.viewmodel

import androidx.lifecycle.ViewModel
import com.android.base.vm.UnPeekLiveData

/**
 * @description: APP全局的ViewModel，可以在这里发送全局通知替代EventBus，LiveDataBus等
 * @author: dongyiming
 * @date: 6/21/23 1:20 AM
 * @version: v1.0
 */
public class EventViewModel : ViewModel() {

    val todoEvent by lazy { UnPeekLiveData<Boolean>() }
}