package com.example.pandas.biz.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.coroutineScope

/**
 * @description: 全局viewmodel
 * @author: dongyiming
 * @date: 7/5/22 12:09 上午
 * @version: v1.0
 */
public class ApplicationViewModel(application: Application) : AndroidViewModel(application) {


    suspend fun corountinfun(){

        coroutineScope {

        }
    }
}
