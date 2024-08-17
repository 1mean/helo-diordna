package com.example.pandas.biz.viewmodel.event

import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * <LocalEventBus>
 * @author: dongyiming
 * @date: 7/29/24 2:37 PM
 * @version: v1.0
 */
object LocalEventBus {

    val events = MutableSharedFlow<Event>()

    //LocalEventBus.events.collect{}
    suspend fun postEvent(event: Event) {
        events.emit(event)
    }
}

data class Event(val timestamp: Long)