package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.bean.eyes.EyepetozerItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.File

/**
 * @description: 处理全局的Exoplayer
 * @author: dongyiming
 * @date: 5/12/22 4:38 下午
 * @version: v1.0
 */
public class ExoPlayerManager private constructor() {

    private var mCurPos: Int = -1 //当前视频播放的位置
    private var mLastPos: Int = mCurPos //上次播放的位置，用于恢复播放

    //用于存储临时的记录信息，针对从网络获取的视频
    private val tempVideoMap = HashMap<Int, PlayingInfo>()

    private var mCurVideoCode2: Int = -1 //当前播放的视频id

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var isSeekTo = false
    private var oldPlayView: StyledPlayerView? = null

    private var exoListener: OnExoListListener? = null

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = ExoPlayerManager()
    }

    fun initPlayer(context: Context): ExoPlayerManager {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
        return this
    }

    //添加界面相关回调
    fun addExoListener(exoListener: OnExoListListener) {
        this.exoListener = exoListener
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
    fun addPlayerView(
        playerView: StyledPlayerView,
        repeatMode: Int
    ): ExoPlayerManager {

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

    /**
     * 开始播放 并存储播放视频的基本信息
     *
     * @date: 5/13/22 9:10 下午
     * @version: v1.0
     */
    fun play(playInfo: PlayingInfo, position: Int) {

        if (playInfo.videoCode == 0 || playInfo.playUrl.isEmpty()) {
            throw Exception("PlayInfo is error : videoCode=${playInfo.videoCode},playUrl=${playInfo.playUrl}")
        }

        mCurVideoCode2 = playInfo.videoCode
        tempVideoMap[mCurVideoCode2] = playInfo

        mLastPos = mCurPos
        mCurPos = position

        mPlayer.seekTo(position, 0)
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    fun addMediaItems(list: MutableList<EyepetozerItem>) {

        if (list.isEmpty()) return

        list.forEach {
            val currentMediaItem = MediaItem.fromUri(it.playUrl!!)
            mPlayer.addMediaItem(currentMediaItem)
        }
    }

    fun refreshMediaItem(list: MutableList<EyepetozerItem>) {

        if (list.isEmpty()) return
        if (mPlayer.mediaItemCount > 0) mPlayer.clearMediaItems()
        list.forEach {
            val currentMediaItem = MediaItem.fromUri(it.playUrl!!)
            mPlayer.addMediaItem(currentMediaItem)
        }
    }

    fun stopPlayer() {

        if (mPlayer.isPlaying) {
            val playInfo = tempVideoMap.get(mCurVideoCode2)
            playInfo?.playPos = mPlayer.currentPosition
            mPlayer.stop()
        }
    }

    fun prePare() {

        mPlayer.prepare()
    }

    fun stop() {
        if (mPlayer.isPlaying) {
            mPlayer.stop()
        }
    }

    fun switchVideo() {

        mPlayer.seekTo(2, 2)
    }


    fun getCurrentState(): Int {
        return mPlayer.playbackState
    }

    fun isPlayIng(): Boolean = mPlayer.isPlaying

    fun release() {
        mPlayer.release()
        _mPlayer = null
        mCurPos = -1
    }

    private val mListener = object : Player.Listener {
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
                    Log.e("ExoPlayManager", "STATE_BUFFERING")
                    if (mLastPos != -1 && !mPlayer.isPlaying && !isSeekTo) {//关闭上一个视频
                        exoListener!!.closeLastPlayedView(mLastPos)
                    }
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e("ExoPlayManager", "STATE_READY: ${mPlayer.isPlaying}")
                    if (mPlayer.isPlaying) {
                        exoListener!!.updateCurPlayerView(mCurPos)
                    }
                }
                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("ExoPlayManager", "STATE_IDLE")
                }
                Player.STATE_ENDED -> {//播放结束
                    Log.e("ExoPlayManager", "STATE_ENDED")
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
            Log.e("ExoPlayManager", "isPlaying: $isPlaying")
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    data class PlayingInfo(
        var videoCode: Int = 0,
        var playUrl: String = "",
        var playPos: Long = 0
    )

    //专门处理list列表播放的回调
    interface OnExoListListener {

        //lastPos:上一个播放的Item在RecyclerView里的位置
        fun closeLastPlayedView(lastPos: Int)

        //防止加载时的黑屏，从buff到ready需要几百毫秒
        fun updateCurPlayerView(curPos: Int)
    }
}