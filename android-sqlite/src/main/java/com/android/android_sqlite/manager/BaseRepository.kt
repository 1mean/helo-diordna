package com.android.android_sqlite.manager

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 * @description: BaseRepository
 * @author: dongyiming
 * @date: 8/19/24 5:23 PM
 * @version: v1.0
 */
public open class BaseRepository {

    private val delayTime = 500L

    fun <T> flowIn(flow: Flow<T>): Flow<T> {
        return flow.flowOn(Dispatchers.IO).catch { e ->
            e.printStackTrace()
        }
    }

    fun <T> flowInDelay(flow: Flow<T>): Flow<T> {
        return flow
            .map {
                delay(delayTime)
                it
            }
            .flowOn(Dispatchers.IO)
            .catch { e ->
                e.printStackTrace()
            }
    }
}