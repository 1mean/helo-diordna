package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.interaction.ExoPlayerListener
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
public class VideoPlayManager(
    private val context: Context,
    private val exoListener: ExoPlayerListener
) {

    private var isOpenVoice = true //默认声音开放
    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    fun initPlayer() {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
    }

    private var startTime: Long = 0

    /**
     * 开始播放，涉及进度的问题
     */
    fun play(playerView: StyledPlayerView, mediaInfo: MediaInfo) {

        startTime = System.currentTimeMillis()
        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        StyledPlayerView.switchTargetView(mPlayer, null, playerView)

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
            mPlayer.seekTo(mediaInfo.playPos)
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    val mListener = object : Player.Listener {

        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                /***
                 * 三种调用的日志如下
                 * 1，第一次播放时
                 *      - 播放视频，需要缓冲回调 STATE_BUFFERING
                 *      - 缓冲完成，大概需要790ms，然后回调 STATE_READY 且isPlaying一定为true
                 *      - 立马回调 onIsPlayingChanged(): isPlaying=true
                 * 2，滑动到其他视频(视频资源列表，直接seekTo其他资源)
                 *      - 回调 STATE_BUFFERING
                 *      - 立马回调 onIsPlayingChanged(): isPlaying=false ，关闭上一个视频的回调吧
                 *      - 300ms后，回调 STATE_READY isPlaying=true
                 *      - 立马回调 onIsPlayingChanged(): isPlaying=true
                 * 3，拖动到某一个时刻继续播放
                 *      - 松手后，触发回调 STATE_BUFFERING
                 *      - 立马回调 onIsPlayingChanged(): isPlaying=false
                 *      - 42ms后，回调 STATE_READY isPlaying=true
                 *      - 立马回调 onIsPlayingChanged(): isPlaying=true
                 */
                Player.STATE_BUFFERING -> {//可以通过isPlaying和seek动作来处理界面相关
                    Log.e(
                        "RecoPlayManager",
                        "buuffering cost time: " + (System.currentTimeMillis() - startTime)
                    )
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e(
                        "RecoPlayManager",
                        "ready cost time: " + (System.currentTimeMillis() - startTime)
                    )
                }
                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("RecoPlayManager", "STATE_IDLE")
                }
                Player.STATE_ENDED -> {//播放结束
                    Log.e("RecoPlayManager", "STATE_ENDED")
                }
            }
        }

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
            exoListener.isPlayingChanged(isPlaying)
            Log.e(
                "RecoPlayManager",
                "$isPlaying cost time: " + (System.currentTimeMillis() - startTime)
            )
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
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

    fun onPause() {
        mPlayer.pause()
    }

    fun continuePlay() {
        if (mPlayer.playbackState == STATE_READY) {
            mPlayer.playWhenReady = true
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

    fun setPlaySpeed(speed: Float) {
        mPlayer.setPlaybackSpeed(speed)
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
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        } else {
            mPlayer.playWhenReady = true
        }
    }
}



