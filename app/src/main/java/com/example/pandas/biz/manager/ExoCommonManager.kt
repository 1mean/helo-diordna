package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
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
public class ExoCommonManager private constructor() {

    private var mCurPos: Int = -1 //当前视频播放的位置
    private var mLastPos: Int = mCurPos //上次播放的位置，用于恢复播放

    private var mCurVideoCode2: Int = -1 //当前播放的视频id

    private val tempMediaIndexMap = MediaIndexMap()//存储资源文件信息

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var isSeekTo = false
    private var oldPlayView: StyledPlayerView? = null

    private var exoListener: OnExoListListener? = null

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = ExoCommonManager()
    }

    fun initPlayer(context: Context): ExoCommonManager {

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
     *          REPEAT_MODE_OFF(0):不重复,一旦播放列表中的最后一个项目被播放，玩家将过渡到Player.STATE_ENDED
     *          REPEAT_MODE_ONE(1):循环当前视频
     *          REPEAT_MODE_ALL(2):循环播放整个资源列表
     * @return:
     * @date: 5/12/22 10:02 下午
     * @version: v1.0
     */
    fun addPlayerView(
        playerView: StyledPlayerView,
        repeatMode: Int
    ): ExoCommonManager {

        playerView.player = null
        playerView.player = mPlayer

        mPlayer.repeatMode = repeatMode
        return this
    }

    /**
     * 播放：不清理资源列表文件
     * - 直接通过file播放
     * - 返回播放时，直接使用seekPre
     */
    fun playLocalFile(playInfo: PlayingInfo, position: Int) {

        //TODO:正式版本改掉，return
        if (playInfo.videoCode == 0 || !playInfo.file.exists()) {
            throw Exception("PlayInfo is error : videoCode=${playInfo.videoCode},file=${playInfo.file}")
        }

        Log.e("1mean","player state= ${mPlayer.playbackState}")

        val videoCode = playInfo.videoCode
        val playPos = playInfo.playPos

        this.mCurPos = position
        ///sdcard/Android/data/com.example.hello_diordna/files
        val playItem = tempMediaIndexMap.get(videoCode)
        if (playItem != null) {//已经存在于播放器内，直接切换至即可

            val index = tempMediaIndexMap.indexOf(videoCode)
            val mediaItem = mPlayer.getMediaItemAt(index)
            if (mediaItem.mediaId == videoCode.toString()) {
                mPlayer.seekTo(index, playItem.playPos)
            }
        } else {

            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(playInfo.file))
                    .setMediaId(playInfo.videoCode.toString()).build()
            mPlayer.addMediaItem(mPlayer.mediaItemCount, mediaItem)
            val index = tempMediaIndexMap.add(playInfo)
            mPlayer.seekTo(index, playPos)
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    fun stopPlayer() {

        if (mPlayer.isPlaying) {
            val videoCode = mPlayer.currentMediaItem?.mediaId
            videoCode?.let {
                if (it.isEmpty()) return
                tempMediaIndexMap.updatePlayPos(it.toInt(), mPlayer.currentPosition)
                mPlayer.pause()
            }
        }
    }

    /**
     * 继续播放之前暂停的视频，包括页面返回
     */
    fun continuePlay(videoCode: Int, repeatMode: Int, playerView: StyledPlayerView) {

        val playItem = tempMediaIndexMap.get(videoCode)
        playItem?.let {
            val index = tempMediaIndexMap.indexOf(videoCode)
            val mediaItem = mPlayer.getMediaItemAt(index)
            if (mediaItem.mediaId == videoCode.toString()) {


                playerView.player = null
                playerView.player = mPlayer
                mPlayer.repeatMode = repeatMode

                mPlayer.seekTo(index, it.playPos)
                mPlayer.playWhenReady = true
                mPlayer.prepare()
            }
        }
    }

    fun getCurrentPos(): Long = mPlayer.currentPosition
    fun isPlayIng(): Boolean = mPlayer.isPlaying
    fun getCurrentItemPos(): Int = mCurPos
    fun getCurrentVideoCode(): Int {
        mPlayer.currentMediaItem?.mediaId?.toInt()
        mPlayer.currentMediaItem?.let {
            return it.mediaId.toInt()
        }
        return -1
    }


    fun prePare() {
        mPlayer.prepare()
    }

    fun isCurrentPlayingVideo(videoCode: Int): Boolean {

        val item = mPlayer.currentMediaItem
        item?.let {
            if (it.mediaId == videoCode.toString() && mPlayer.isPlaying) {
                return true
            }
        }
        return false
    }

    fun isCurrentStopVideo(videoCode: Int): Boolean {

        val item = mPlayer.currentMediaItem
        item?.let {
            if (it.mediaId == videoCode.toString() && !mPlayer.isPlaying) {
                return true
            }
        }
        return false
    }

    fun switchVideo() {
        mPlayer.seekTo(2, 2)
    }


    fun getCurrentState(): Int {
        return mPlayer.playbackState
    }

    fun release() {
        if (_mPlayer != null) {
            mPlayer.release()
            _mPlayer = null
            mCurPos = -1
        }
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
                    Log.e("ExoCommonManager", "STATE_BUFFERING")
                    if (mLastPos != -1 && !mPlayer.isPlaying && !isSeekTo) {//关闭上一个视频
                        exoListener!!.closeLastPlayedView(mLastPos)
                    }
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e("ExoCommonManager", "STATE_READY: ${mPlayer.isPlaying}")
                    if (mPlayer.isPlaying) {
                        exoListener!!.updateCurPlayerView(mCurPos, true)
                    }
                }
                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("ExoCommonManager", "STATE_IDLE")
                    exoListener!!.updateCurPlayerView(mCurPos, false)
                }
                Player.STATE_ENDED -> {//播放结束
                    Log.e("ExoCommonManager", "STATE_ENDED")
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
            Log.e("ExoCommonManager", "isPlaying: $isPlaying")
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    //专门处理list列表播放的回调
    interface OnExoListListener {

        //lastPos:上一个播放的Item在RecyclerView里的位置
        fun closeLastPlayedView(lastPos: Int)

        //防止加载时的黑屏，从buff到ready需要几百毫秒
        fun updateCurPlayerView(curPos: Int, isHide: Boolean)
    }

    /**
     * 需要存储的资源信息
     * - videoCode：视频Id
     * - playUrl：播放网络url
     * - file:本地文件
     * - playPos：播放进度
     */
    data class PlayingInfo(
        var videoCode: Int = 0,
        var playUrl: String = "",
        var file: File,
        var playPos: Long = 0
    )

    /**
     * 目的：存储PlayingInfo和方便播放
     */
    inner class MediaIndexMap {

        // 添加的顺序 = 播放器内资源文件的顺序
        private val playInfoMap = LinkedHashMap<Int, PlayingInfo>()

        /**
         * 通过
         */
        fun add(playInfo: PlayingInfo): Int {
            val size = playInfoMap.size
            return if (size <= 0) {
                playInfoMap[playInfo.videoCode] = playInfo
                0
            } else {
                val keys = playInfoMap.keys
                if (playInfo.videoCode in keys) {
                    keys.indexOf(playInfo.videoCode)
                } else {
                    playInfoMap[playInfo.videoCode] = playInfo
                    size
                }
            }
        }

        fun get(videoCode: Int): PlayingInfo? = playInfoMap[videoCode]

        fun updatePlayPos(videoCode: Int, playPos: Long) {

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
}