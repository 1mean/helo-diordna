package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.MediaInfo
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * @description: PlayerManager
 * @author: dongyiming
 * @date: 6/17/22 11:57 下午
 * @version: v1.0
 */
public class PlayerManager private constructor() {

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var mCurPos: Int = -1 //当前视频播放的位置

    private var playerListener: ExoPlayerListener? = null

    private val tempMediaIndexMap = MediaIndexMap()//存储资源文件信息

    private var oldPlayerView: StyledPlayerView? = null //上一个加载的Playerview

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = PlayerManager()
    }

    fun initPlayer(context: Context): PlayerManager {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
        }
        return this
    }

    /**
     * 将播放器附加到视图上
     */
    fun addPlayerView(playerView: StyledPlayerView): PlayerManager {

        //方式一：直接设置，必须置为null
        //playerView.player = null
        //playerView.player = mPlayer

        //方式二，直接切换view
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        oldPlayerView = playerView
        return this
    }

    /**
     * 添加界面操作的回调
     */
    fun addPlayerListener(mListener: ExoPlayerListener): PlayerManager {

        playerListener = null
        this.playerListener = mListener
        return this
    }

    /**
     * 设置循环模式
     *      - REPEAT_MODE_OFF(0):不重复,播放结束后继续资源列表里的下一个视频，直至列表结束到Player.STATE_ENDED
     *      - REPEAT_MODE_ONE(1):循环当前视频
     *      - REPEAT_MODE_ALL(2):循环播放整个资源列表
     */
    fun setRepeatMode(repeatMode: Int): PlayerManager {
        mPlayer.repeatMode = repeatMode
        return this
    }

    /**
     * 设置倍速和音量
     */
    fun setPlaybackParameters(speed: Float, pitch: Float): PlayerManager {
        val playbackParameters = PlaybackParameters(speed, pitch)
        mPlayer.playbackParameters = playbackParameters
        return this
    }

    /**
     * 开始播放
     *  - isLocalSource：是否是本地资源文件
     */
    fun startPlay(isLocalSource: Boolean, position: Int, mediaInfo: MediaInfo) {

        if (isLocalSource) {
            playLocalFile(mediaInfo, position)
        }
    }

    /**
     * 播放本地资源文件，并存储播放记录等信息
     *    - sdcard/Android/data/com.example.hello_diordna/files
     */
    private fun playLocalFile(mediaInfo: MediaInfo, position: Int) {

        if (mediaInfo.videoCode == 0 || !mediaInfo.file.exists()) {
            Log.e(
                AppInfos.DEBUG_LOG_TAG,
                "MediaInfo has a error with: videoCode=${mediaInfo.videoCode},file=${mediaInfo.file}"
            )
            return
        }
        val videoCode = mediaInfo.videoCode
        val playPos = mediaInfo.playPos

        if (mPlayer.playbackState == Player.STATE_READY && !mPlayer.playWhenReady) {//pause()后的状态
            mPlayer.currentMediaItem?.let {
                if (it.mediaId == mediaInfo.videoCode.toString()) {//继续播放同一个视频
                    mPlayer.playWhenReady = true
                    return
                }
            }
        }
        this.mCurPos = position
        val playItem = tempMediaIndexMap.get(videoCode)
        if (playItem != null) {//已经存在于播放器内，直接切换至即可

            val index = tempMediaIndexMap.indexOf(videoCode)
            val mediaItem = mPlayer.getMediaItemAt(index)
            if (mediaItem.mediaId == videoCode.toString()) {
                mPlayer.seekTo(index, playItem.playPos)
            } else {
                Log.e(AppInfos.DEBUG_LOG_TAG, "media source is error")
            }
        } else {
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(mediaInfo.file))
                    .setMediaId(mediaInfo.videoCode.toString()).build()
            mPlayer.addMediaItem(mPlayer.mediaItemCount, mediaItem)
            val index = tempMediaIndexMap.add(mediaInfo)
            mPlayer.seekTo(index, playPos)
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    /**
     * 暂停正在播放的视频
     * - stop()：
     *   - 停止播放，不会清理playlist，不会重制播放位置或播放错误。如果只是暂停播放器，推荐pause()
     *   - 播放器闲置(STATE_IDLE)，释放播放所需要的加载的media和sources
     *   - 再次调用prepare()时，player对象能继续被使用
     *   - 如果不需要使用播放器了，仍然需要调用release()方法彻底释放
     * - pause():
     *   - 暂停播放，相当于setPlayWhenReady(false)
     *   - 此时播放器状态是STATE_READY，但是 playWhenReady = false
     *   - playWhenReady = true 或者 play() 恢复播放
     */
    fun stopPlayer() {
        if (mPlayer.isPlaying) {
            val videoCode = mPlayer.currentMediaItem?.mediaId
            videoCode?.let {
                if (it.isEmpty()) {
                    Log.e(AppInfos.DEBUG_LOG_TAG, "mediaId is null")
                    return
                }
                tempMediaIndexMap.updatePlayingPosition(it.toInt(), mPlayer.currentPosition)
                mPlayer.pause()
            }
        }
    }

    /**
     * 注销、释放资源
     */
    fun releasePlayer() {

        _mPlayer?.let { _ ->
            mPlayer.removeListener(mListener)
            mPlayer.clearMediaItems()
            mPlayer.release()
            _mPlayer = null
            mCurPos = -1
        }
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
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e("ExoPlayManager", "STATE_READY")
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
            playerListener?.updatePlayerView(isPlaying, mCurPos)
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    /**
     * 存储PlayingInfo,播放器内的资源位置和存入时的位置相同
     */
    inner class MediaIndexMap {

        // 添加的顺序 = 播放器内资源文件的顺序
        private val playInfoMap = LinkedHashMap<Int, MediaInfo>()

        fun add(playInfo: MediaInfo): Int = if (playInfoMap.size <= 0) {
            playInfoMap[playInfo.videoCode] = playInfo
            0
        } else {
            val keys = playInfoMap.keys
            if (playInfo.videoCode in keys) {
                keys.indexOf(playInfo.videoCode)
            } else {
                playInfoMap[playInfo.videoCode] = playInfo
                playInfoMap.size
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

}