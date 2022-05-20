package com.example.pandas.biz.manager

import android.util.Log
import com.example.pandas.bean.eyes.Eyepetozer
import com.example.pandas.bean.eyes.EyepetozerData
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.http.EyepetozerConvert
import com.example.pandas.biz.http.httpService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @description: 数据处理manager
 * @author: dongyiming
 * @date: 2/23/22 12:42 上午
 * @version: v1.0
 */

val httpManager: HttpInvokerManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { HttpInvokerManager() }

public class HttpInvokerManager {

    suspend fun getHotList(startIndex: Int, num: Int): MutableList<EyepetozerItem> {

        return withContext(Dispatchers.IO) {

            val list = httpService.getHotList(startIndex, num)
            EyepetozerConvert.convertOnlyVideo(list)
        }
    }

    suspend fun getTabSelected(
        isRefresh: Boolean,
        date: Long = 0,
        num: Int = 0,
        page: Int = 0
    ): EyepetozerData {

        return withContext(Dispatchers.IO) {

            val data: Eyepetozer?
            if (isRefresh) {
                data = httpService.tabsSelected()
            } else {
                data = httpService.tabsSelected(date, num, page)
            }
            EyepetozerConvert.convertEyepetozerData(data)
        }
    }

    suspend fun getRecommendVideos(videoId: Int): MutableList<EyepetozerItem> {

        return withContext(Dispatchers.IO) {

            val list = httpService.getRecommend(videoId)
            EyepetozerConvert.convertOnlyVideo(list)
        }
    }

}