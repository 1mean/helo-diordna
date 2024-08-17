package com.example.pandas.biz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * @description: UserViewModel
 * @author: dongyiming
 * @date: 7/29/24 11:36 AM
 * @version: v1.0
 */
public class UserViewModel : ViewModel() {


    fun insert(user: User) {
        viewModelScope.launch {
            //AppDataBase.getInstance().userDao().insert(user)
        }
    }

    //viewModel.getAll().collect{value->}
//    fun getAll(): Flow<MutableList<User>> {
//        return AppDataBase.getInstance()
//            .userDao()
//            .getAll()
//            .catch { e -> e.printStackTrace() }
//            .flowOn(Dispatchers.IO)
//    }
}