package com.android.base.ui.lifecycle

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.*

/**
 * @description: LifecycleHandler
 * @author: dongyiming
 * @date: 11/9/23 2:10 PM
 * @version: v1.0
 */
public class LifecycleHandler : Handler, DefaultLifecycleObserver {

    private var lifecycleOwner: LifecycleOwner? = null

    constructor(looper: Looper, lifecycleOwner: LifecycleOwner) : super(looper) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    constructor(looper: Looper, callback: Callback, lifecycleOwner: LifecycleOwner) : super(
        looper,
        callback
    ) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    private fun addObserver() {
        lifecycleOwner?.lifecycle?.addObserver(this)
    }

    /**
     * 主动释放，不需要再书写资源释放的代码
     */
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        removeCallbacksAndMessages(null)
        lifecycleOwner?.lifecycle?.removeObserver(this)
    }
}