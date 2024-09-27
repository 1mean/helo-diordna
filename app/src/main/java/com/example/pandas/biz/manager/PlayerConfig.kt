package com.example.pandas.biz.manager

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.pandas.bean.MediaItemWrapper
import java.util.concurrent.ConcurrentHashMap

/**
 * @description: 播放器相关
 * @author: dongyiming
 * @date: 10/13/22 4:42 下午
 * @version: v1.0
 */
public class PlayerConfig private constructor() {

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = PlayerConfig()
    }

    //缓存所有创建的mediaItems。该创建是相对耗时的操作，缓存起来重用<videoCode,mediaItem>
    private val mediaItems: ConcurrentHashMap<Int, MediaItemWrapper> by lazy { ConcurrentHashMap() }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getAll(){
        mediaItems.forEach { (t, u) ->
            Log.e("1mean","videoCode=$t, MediaItemWrapper=$u")
        }
    }

    fun hasMediaItem(videoCode: Int): Boolean {
        return mediaItems.containsKey(videoCode)
    }

    fun addMediaItem(videoCode: Int, mMedia: MediaItemWrapper) {
        mediaItems[videoCode] = mMedia
    }

    fun getMediaItem(videoCode: Int): MediaItemWrapper? {
        return mediaItems[videoCode]
    }

    fun updatePosition(videoCode: Int, position: Long) {

        if (mediaItems.containsKey(videoCode)) {
            mediaItems[videoCode]?.let {
                it.playPosition = position
                mediaItems.put(videoCode, it)
            }
        } else {
            throw IllegalArgumentException("当前播放的MediaItem，并未存储")
        }
    }
}