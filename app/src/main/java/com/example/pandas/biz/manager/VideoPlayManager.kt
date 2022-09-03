package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.bean.MediaInfo
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.STATE_READY
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.File

/**
 * @description: RecoPlayManager
 * @author: dongyiming
 * @date: 8/28/22 4:20 下午
 * @version: v1.0
 */
public class VideoPlayManager(private val context: Context) {

    private var isOpenVoice = true //默认声音开放
    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    fun initPlayer() {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
    }

    fun play(playerView: StyledPlayerView, mediaInfo: MediaInfo) {

        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        playerView.player = mPlayer

        val mediaItems = PlayerManager.instance.mediaItems
        if (mediaItems.containsKey(mediaInfo.videoCode)) {
            mediaItems[mediaInfo.videoCode]?.let {
                mPlayer.addMediaItem(it)
                mPlayer.seekTo(mediaInfo.playPos)
            }
        } else {
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(File(mediaInfo.playUrl)))
                    .setMediaId(mediaInfo.videoCode.toString()).build()
            PlayerManager.instance.mediaItems[mediaInfo.videoCode] = mediaItem
            mPlayer.addMediaItem(mediaItem)
            mediaInfo.playPos = mediaInfo.playPos//从0开始播放新视频
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }


    val mListener = object : Player.Listener {

        //回调后，立马执行 STATE_BUFFERING
        override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
            super.onPlayWhenReadyChanged(playWhenReady, reason)
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
        }

        //当 #{isPlaying()} 的值改变时调用 ，是否player正在播放中
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            Log.e("RecoPlayManager", "isPlaying: $isPlaying")
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    /**
     * 存储PlayingInfo,播放器内的资源位置和存入时的位置相同
     */
    class MediaIndexMap {

        // 添加的顺序 = 播放器内资源文件的顺序
        private val playInfoMap = LinkedHashMap<Int, MediaInfo>()

        fun add(playInfo: MediaInfo): Int = if (playInfoMap.size <= 0) {
            playInfoMap[playInfo.videoCode] = playInfo
            0
        } else {
            if (playInfoMap.containsKey(playInfo.videoCode)) {
                playInfoMap.keys.indexOf(playInfo.videoCode)
            } else {
                playInfoMap[playInfo.videoCode] = playInfo
                playInfoMap.size - 1
            }
        }

        fun get(videoCode: Int): MediaInfo? = playInfoMap[videoCode]

        fun updatePlayingPosition(videoCode: Int, playPos: Long) {

            val playInfo =
                playInfoMap[videoCode] ?: throw Exception("playInfoMap no key: $videoCode")
            playInfo.playPos = playPos
            playInfoMap[videoCode] = playInfo
        }

        fun exist(videoCode: Int): Boolean = playInfoMap.containsKey(videoCode)

        fun indexOf(videoCode: Int): Int = playInfoMap.keys.indexOf(videoCode)

        fun clear() {
            if (playInfoMap.isNotEmpty()) playInfoMap.clear()
        }
    }


    //***对外方法*********************************************************************************

    fun pausePlayer() {
        if (mPlayer.isPlaying) {
            val videoCode = mPlayer.currentMediaItem?.mediaId
            requireNotNull(videoCode)
            mPlayer.pause()
        }
    }

    fun releasePlayer() {
        mPlayer.removeListener(mListener)
        mPlayer.release()
        _mPlayer = null
    }

    fun isPlaying(): Boolean = mPlayer.isPlaying
    fun getCurrentPos(): Long = mPlayer.currentPosition
    fun getDuration(): Long = mPlayer.duration
    fun bufferedPos(): Long = mPlayer.bufferedPosition

    fun resumePlay(position: Int) {
        if (!mPlayer.isPlaying && mPlayer.playbackState == STATE_READY) {
            mPlayer.playWhenReady = true
        }
    }

    /**
     * deviceVolume [0,16]
     * volume [0,1.0]
     */
    fun updateVolume(isOpen: Boolean) {

        this.isOpenVoice = isOpen
        if (isOpen) {//打开视频声音
            mPlayer.volume = mPlayer.deviceVolume.toFloat() / 16
        } else {
            mPlayer.volume = 0f
        }
    }

    fun updateVolume() {
        if (isOpenVoice) {
            mPlayer.volume = mPlayer.deviceVolume.toFloat() / 16
        }
    }

    fun seekTo(position: Long) {
        mPlayer.seekTo(position)
    }

    fun doubleTap() {

        Log.e("asdjasjdaksd", "12")
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        } else {
            mPlayer.playWhenReady = true
        }
    }
}



