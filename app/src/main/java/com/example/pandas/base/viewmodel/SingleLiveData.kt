package com.example.pandas.base.viewmodel

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @description: SingleLiveData
 * @author: dongyiming
 * @date: 7/22/23 3:30 PM
 * @version: v1.0
 */
public class SingleLiveData<T> : MutableLiveData<T>() {

    private val mPending: AtomicBoolean = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        setValue(null)
    }

    @MainThread
    override fun setValue(@Nullable t: T?) {
        mPending.set(true)
        super.setValue(t)
    }
}