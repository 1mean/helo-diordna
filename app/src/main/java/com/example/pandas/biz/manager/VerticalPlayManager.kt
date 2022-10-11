package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.sql.entity.PetVideo
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: VerticalPlayManager
 * @author: dongyiming
 * @date: 9/22/22 12:06 上午
 * @version: v1.0
 */
public class VerticalPlayManager(
    private val context: Context,
    private val exoListener: ExoPlayerListener
) {

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!
    private var oldPlayerView: StyledPlayerView? = null


    fun initPlayer() {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
    }

    fun refreshPlayer(list: MutableList<PetVideo>) {
        mPlayer.clearMediaItems()
        if (list.isNotEmpty()) {
            val mediaItems = mutableListOf<MediaItem>()
            list.forEach {
                val file = getLocalFilePath(context, it.fileName!!)
                val mediaItem =
                    MediaItem.Builder().setUri(Uri.fromFile(file))
                        .setMediaId(it.code.toString()).build()
                mediaItems.add(mediaItem)
            }
            mPlayer.addMediaItems(mediaItems)
            mPlayer.seekTo(0, 0)
            mPlayer.playWhenReady = true
            mPlayer.prepare()
        }
    }

    fun addMediaItems(list: MutableList<PetVideo>){
        if (list.isNotEmpty()) {
            val mediaItems = mutableListOf<MediaItem>()
            list.forEach {
                val file = getLocalFilePath(context, it.fileName!!)
                val mediaItem =
                    MediaItem.Builder().setUri(Uri.fromFile(file))
                        .setMediaId(it.code.toString()).build()
                mediaItems.add(mediaItem)
            }
            mPlayer.addMediaItems(mediaItems)
        }
    }

    fun initPlayer(list: MutableList<PetVideo>){

        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        val mediaItems = mutableListOf<MediaItem>()
        list.forEach {
            val file = getLocalFilePath(context, it.fileName!!)
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(file))
                    .setMediaId(it.code.toString()).build()
            mediaItems.add(mediaItem)
        }
        mPlayer.addMediaItems(mediaItems)
    }

    fun play(playerView: StyledPlayerView, list: MutableList<PetVideo>) {

        val startTime = System.currentTimeMillis()
        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        this.oldPlayerView = playerView
        val mediaItems = mutableListOf<MediaItem>()
        list.forEach {
            val file = getLocalFilePath(context, it.fileName!!)
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(file))
                    .setMediaId(it.code.toString()).build()
            mediaItems.add(mediaItem)
        }
        mPlayer.addMediaItems(mediaItems)
        mPlayer.playWhenReady = true
        mPlayer.prepare()
        Log.e("1mean", "play cost time: ${System.currentTimeMillis() - startTime}")
    }

    val mListener = object : Player.Listener {

        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                Player.STATE_BUFFERING -> {//可以通过isPlaying和seek动作来处理界面相关
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
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
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    fun seekTo(position: Int, playerView: StyledPlayerView) {
        val startTime = System.currentTimeMillis()
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        this.oldPlayerView = playerView
        mPlayer.seekTo(position, 0)
        mPlayer.playWhenReady = true
        mPlayer.prepare()
        Log.e("1mean", "play cost time: ${System.currentTimeMillis() - startTime}")
    }

    fun isPlaying(): Boolean = mPlayer.isPlaying

    fun pause() {
        mPlayer.pause()
    }

    fun continuePlayer() {
        mPlayer.playWhenReady = true
    }


    fun release() {
        mPlayer.removeListener(mListener)
        mPlayer.release()
        _mPlayer = null
    }
}