package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.File

/**
 * @description: 处理全局的Exoplayer
 * @author: dongyiming
 * @date: 2/28/22 4:38 下午
 * @version: v1.0
 */
public class ExoPlayerManager private constructor() {

    private var mCurPos: Int = -1 //当前视频播放的位置
    private var mLastPos: Int = mCurPos //上次播放的位置，用于恢复播放


    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var oldPlayView: StyledPlayerView? = null

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = ExoPlayerManager()
    }

    fun initPlayer(context: Context) {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
    }

    /**
     * 配置相关
     * @param:
     *      repeatMode:
     *          REPEAT_MODE_OFF(0):不重复
     *          REPEAT_MODE_ONE(1):循环当前视频
     *          REPEAT_MODE_ALL(2):循环播放整个资源列表
     * @return:
     * @date: 5/12/22 10:02 下午
     * @version: v1.0
     */
    fun setUpPlay(playerView: StyledPlayerView, repeatMode: Int): ExoPlayerManager {

        playerView.player = null
        playerView.player = mPlayer

        mPlayer.repeatMode = repeatMode

        return this
    }

    fun swithPlayerView(newPlayView: StyledPlayerView) {
        StyledPlayerView.switchTargetView(mPlayer, oldPlayView, newPlayView)
    }

    fun playLocalFile(file: File): ExoPlayerManager {

        val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))
        mPlayer.addMediaItem(firstLocalMediaItem)

        return this
    }

    fun play(url:String):ExoPlayerManager{

        if (mPlayer.playbackState == Player.STATE_IDLE) {

            val currentMediaItem = MediaItem.fromUri(url)
            mPlayer.addMediaItem(currentMediaItem)
            mPlayer.playWhenReady = true
            mPlayer.prepare()
        }
        return this
    }

    fun stop(){

        if (mPlayer.isPlaying) {
            mPlayer.stop()
        }
    }

    private val mListener: Player.Listener = object : Player.Listener {

        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }

        override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
            super.onMediaItemTransition(mediaItem, reason)
        }

        override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
            super.onPlayWhenReadyChanged(playWhenReady, reason)
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
        }
    }


    fun release() {
        mPlayer.release()
        mPlayer.removeListener(mListener)
        _mPlayer = null
        mCurPos = -1
    }
}