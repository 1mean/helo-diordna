package com.example.pandas

import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * @description: WanAndroid api test
 * @author: dongyiming
 * @date: 8/15/24 7:23 PM
 * @version: v1.0
 */
public class WanAndroidTest {

    @Test
    fun `test_wanandroid_register`() = runBlocking<Unit> {

        val viewModel = WanAndroidViewModel()
        viewModel.register("董一鸣", "Ccz19650405", "Ccz19650405")
        viewModel.register.collect {
            println("name=${it.data.username}")
            println("name=${it.data.id}")
            println("name=${it.data.collectIds}")
            println("name=${it.data.icon}")
            println("name=${it.data.password}")
            println("name=${it.data.type}")
        }
    }


}