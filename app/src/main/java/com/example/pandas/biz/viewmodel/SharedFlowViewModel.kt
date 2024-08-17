package com.example.pandas.biz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pandas.biz.viewmodel.event.Event
import com.example.pandas.biz.viewmodel.event.LocalEventBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @description: SharedFlowViewModel
 * @author: dongyiming
 * @date: 7/29/24 3:12 PM
 * @version: v1.0
 */
public class SharedFlowViewModel : ViewModel() {

    private lateinit var job: Job

    fun startRefresh() {
        job = viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                LocalEventBus.postEvent(Event(System.currentTimeMillis()))
            }
        }
    }

    fun stopRefresh() {
        job.cancel()
    }
}