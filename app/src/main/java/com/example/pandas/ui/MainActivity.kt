package com.example.pandas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.example.pandas.R
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableLiveData:MutableLiveData<String> = MutableLiveData()
        mutableLiveData.observe(this,
            Observer<String> { t -> Log.d("LiveData", t!!) })

        thread {
            mutableLiveData.postValue("通知")
        }.start()

    }

    override fun onResume() {
        super.onResume()
    }
}
