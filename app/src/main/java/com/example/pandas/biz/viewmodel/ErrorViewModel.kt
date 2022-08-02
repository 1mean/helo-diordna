package com.example.pandas.biz.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * @description: ErrorViewModel
 * @author: dongyiming
 * @date: 3/24/22 11:44 下午
 * @version: v1.0
 */
public class ErrorViewModel : BaseViewModel() {

    val filesResult: MutableLiveData<MutableList<File>> by lazy { MutableLiveData() }

    fun getAllLogFile(context: Context) {

        viewModelScope.launch {

            filesResult.value = withContext(Dispatchers.IO) {

                var list = mutableListOf<File>()
                val localFile = FileUtils.getExternalFileDirectory(context, "")
                localFile?.let { it ->
                    val logPath =
                        StringBuilder(it.absolutePath).append(File.separator).append("log")
                            .toString()
                    val logFile = File(logPath)
                    if (!logFile.exists()) {
                        logFile.mkdirs()
                    }
                    logFile.listFiles()?.let {
                        list = it.toMutableList()
                        list.reverse()
                    }
                }
                list
            }
        }
    }
}