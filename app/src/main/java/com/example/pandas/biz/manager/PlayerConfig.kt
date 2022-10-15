package com.example.pandas.biz.manager

import com.example.pandas.bean.MediaItemWrapper

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
    private val mediaItems: MutableMap<Int, MediaItemWrapper> by lazy { mutableMapOf() }

    fun hasMediaItem(videoCode: Int): Boolean {
        return mediaItems.containsKey(videoCode)
    }

    fun addMediaItem(videoCode: Int, mMedia: MediaItemWrapper) {
        mediaItems.put(videoCode, mMedia)
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