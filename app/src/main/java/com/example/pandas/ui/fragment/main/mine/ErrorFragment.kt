package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.os.FileUtils
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentErrorBinding
import java.io.File

/**
 * @description: 我的-缓存
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class ErrorFragment : BaseFragment<BaseViewModel, FragmentErrorBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        var list = mutableListOf<File>()
        val localFile = com.example.pandas.utils.FileUtils.getExternalFileDirectory(mActivity, "")
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
        //binding.webError.loadData(list[0].absolutePath,"text/text","utf-8")
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }
}