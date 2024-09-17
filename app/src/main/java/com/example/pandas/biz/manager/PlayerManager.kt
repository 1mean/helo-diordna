package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.TextView
import com.example.pandas.bean.MediaInfo
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.DebugTextViewHelper
import java.io.File

/**
 * 关于Exoplayer2
 *  - 1.当切换Activity时，需要释放上一个Exoplayer，同时创建一个新的Exoplayer
 *    - 当一个activity被paused/stopped,播放器player应当释放所有的资源
 *  - 2.创建一个新的media source和下载播放的media是最耗时的操作
 *    - 如MediaItem的创建MediaItem.Builder().setUri().setMediaId().build()
 *  - 3.一旦类创建完成，创建一个新的player对象是相当廉价的。并且renderers(渲染器)需要被重置来开始渲染新的media
 *  - 4.像数据源data soureces，尤其是当使用了Cache时，数据源只能被创建一次，并且被存储在一个静态变量中
 *    - 以便在创建了一个其他的player对象时，数据源能够被重用
 *
 * @description: PlayerManager
 * @author: dongyiming
 * @date: 6/17/22 11:57 下午
 * @version: v1.0
 */
public class PlayerManager private constructor() {

    private val TAG: String = "PlayerManager"
    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!
    private var mCurPos: Int = -1 //当前视频播放的位置

    private var recoPlayPos: Int = -1//推荐界面播放的item的位置

    private val tempRecoMediaIndexMap = MediaIndexMap()//存储资源文件信息,目前只用于推荐界面

    private var oldPlayerView: StyledPlayerView? = null //上一个加载的Playerview

    var isHomePageVoiceOpen = false//home页面默认关闭声音

    //缓存所有创建的mediaItems。该创建是相对耗时的操作，缓存起来重用<videoCode,mediaItem>
    val mediaItems: MutableMap<Int, MediaItem> by lazy { mutableMapOf() }

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = PlayerManager()
    }

    fun initPlayer(context: Context): PlayerManager {

        Log.e("asdjasjdaksd", "1")
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

        Log.e("asdjasjdaksd", "2")
        //方式二，直接切换view
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        oldPlayerView = playerView
        return this
    }

    /**
     * 适合只切换视图的场景,此时状态为ready，但是ready = false
     */
    fun switchViewAndGoOn(playerView: StyledPlayerView) {

        Log.e("asdjasjdaksd", "3")
        addPlayerView(playerView)
        mPlayer.playWhenReady = true
    }

    /**
     * 设置循环模式
     *   - REPEAT_MODE_OFF(0):不重复,播放结束后继续资源列表里的下一个视频，直至列表结束到Player.STATE_ENDED
     *   - REPEAT_MODE_ONE(1):循环当前视频
     *   - REPEAT_MODE_ALL(2):循环播放整个资源列表
     */
    fun setRepeatMode(repeatMode: Int): PlayerManager {

        Log.e("asdjasjdaksd", "5")
        mPlayer.repeatMode = repeatMode
        return this
    }

    /**
     * 设置倍速和音量
     */
    fun setPlaybackParameters(speed: Float, pitch: Float): PlayerManager {

        Log.e("asdjasjdaksd", "6")
        val playbackParameters = PlaybackParameters(speed, pitch)
        mPlayer.playbackParameters = playbackParameters
        return this
    }

    /**
     * 开始播放
     *  - isLocalSource：是否是本地资源文件
     */
    fun startPlay(isLocalSource: Boolean, position: Int, mediaInfo: MediaInfo) {

        Log.e("asdjasjdaksd", "7")

        mPlayer.volume = mPlayer.deviceVolume.toFloat()
        if (isLocalSource) {
            playLocalFile(mediaInfo, position)
        }
    }

    /**
     * 针对一页只有一个可播放的item的处理
     */
    fun startOneLocalPlayer(mediaInfo: MediaInfo, position: Int) {

        Log.e("asdjasjdaksd", "8")

        if (!mPlayer.isPlaying) {
            if (isHomePageVoiceOpen) {
                mPlayer.volume = mPlayer.deviceVolume.toFloat()
            } else {
                mPlayer.volume = 0f
            }
            //playLocalFile(mediaInfo, position)
            playRecoLocalFile(mediaInfo, position)
        }
    }

    /**
     * 播放本地资源文件，并存储播放记录等信息
     *    - sdcard/Android/data/com.example.hello_diordna/files
     */

    /**
     * <开始播放本地资源>
     * @param: MediaInfo：本地资源信息，标识/播放源/起始位
     * @author: dongyiming
     * @date: 8/7/22 10:58 上午
     * @version: v1.0
     */
    private fun playLocalFile(mediaInfo: MediaInfo, position: Int) {

//        require(File(mediaInfo.playUrl).exists()) {
//            "media source is null"
//        }

        Log.e("asdjasjdaksd", "9")

        if (!File(mediaInfo.playUrl).exists()) {
            Log.d(TAG, "playLocalFile: ")
            return
        }
        val playPos = mediaInfo.playPos
        val videoCode = mediaInfo.videoCode
        if (position != -1) this.mCurPos = position

        if (mediaItems.containsKey(videoCode)) {
            mediaItems[videoCode]?.let {
                mPlayer.addMediaItem(it)
            }
        } else {
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(File(mediaInfo.playUrl)))
                    .setMediaId(mediaInfo.videoCode.toString()).build()
            mediaItems[videoCode] = mediaItem
            mPlayer.addMediaItem(mediaItem)
        }
        if (playPos != 0L) {
            mPlayer.seekTo(mPlayer.mediaItemCount - 1, playPos)
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    /**
     * 运行推荐界面的video
     */
    private fun playRecoLocalFile(mediaInfo: MediaInfo, position: Int) {

        Log.e("asdjasjdaksd", "10")

        if (!File(mediaInfo.playUrl).exists()) {
            Log.d(TAG, "playLocalFile: ")
            return
        }
        val playPos = mediaInfo.playPos
        val videoCode = mediaInfo.videoCode
        if (position != -1) this.mCurPos = position

        //缓存进度，资源列表里的mediaInfo无法得到进度值，就无法通过seekTo进行切换
        val playItem = tempRecoMediaIndexMap.get(videoCode)//资源是否已存在于缓存中
        val count = mPlayer.mediaItemCount
        if (playItem == null) {
            if (mediaItems.containsKey(videoCode)) {
                mediaItems[videoCode]?.let { item ->
                    mPlayer.addMediaItem(count, item)
                    tempRecoMediaIndexMap.add(mediaInfo)
                }
            } else {
                val startTime = System.currentTimeMillis()
                Log.e(TAG, "startTime: $startTime")
                val mediaItem =
                    MediaItem.Builder().setUri(Uri.fromFile(File(mediaInfo.playUrl)))
                        .setMediaId(mediaInfo.videoCode.toString()).build()

                mediaItems[videoCode] = mediaItem
                mPlayer.addMediaItem(mediaItem)
                tempRecoMediaIndexMap.add(mediaInfo)
                Log.e(TAG, "media cost time: " + (System.currentTimeMillis() - startTime))
            }
            mPlayer.seekTo(mPlayer.mediaItemCount - 1, playPos)
        } else {
            val index = tempRecoMediaIndexMap.indexOf(videoCode)
            val mediaItem = mPlayer.getMediaItemAt(index)
            Log.d(TAG, "seekTo: $index ,$videoCode,${mediaItem.mediaId}")
            if (mediaItem.mediaId == videoCode.toString()) {
                mPlayer.seekTo(index, playItem.playPos)
            }
        }
        this.recoPlayPos = position
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
    fun pausePlayer() {

        recoPlayPos = -1
        //出现问题：快速滑到后又快速划出屏幕，此时视频还在缓存状态，无法关闭。此时界面无需处理
        if (mPlayer.isPlaying) {
            val videoCode = mPlayer.currentMediaItem?.mediaId
            requireNotNull(videoCode)
            tempRecoMediaIndexMap.updatePlayingPosition(videoCode.toInt(), mPlayer.currentPosition)
            //playerListener?.stopMedia(it, mPlayer.currentPosition)
            mPlayer.pause()
        }
    }

    fun doubleTap() {

        Log.e("asdjasjdaksd", "12")
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        } else {
            mPlayer.playWhenReady = true
        }
    }

    fun setpos() {
        mPlayer.currentPosition
    }

    /**
     * 继续同一个视频，视图不同就切换，视图相同就不做任何处理，用于切换不同场景
     * TODO:如果视图相同，是否做处理，还需要看后续业务
     */
    fun continueSameMedia(videoCode: Int, newView: StyledPlayerView): Boolean {

        Log.e("asdjasjdaksd", "13")
        val mediaId = mPlayer.currentMediaItem?.mediaId
        mediaId?.let {
            if (it.isEmpty()) {
                Log.d(TAG, "mediaId is null")
                return false
            }

            Log.e("PlayerManager", "${mPlayer.playbackState}, ${mPlayer.playWhenReady}")
            if (it == videoCode.toString()) {
                if (newView != oldPlayerView) {
                    newView.player = null
                    newView.player = mPlayer
                    //StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, newView)
                    oldPlayerView = newView

                    mPlayer.playWhenReady = true
                    return true
                }
            }
        }
        return false
    }

    /**
     * 当系统音为0时，开启视频音量，调大系统音时，视频音仍然为0，这个只能自己处理
     */
    fun updateHomePageVolumn() {

        Log.e("asdjasjdaksd", "14")
        if (isHomePageVoiceOpen) {
            mPlayer.volume = 0f
        } else {
            mPlayer.volume = mPlayer.deviceVolume.toFloat()
        }
        isHomePageVoiceOpen = !isHomePageVoiceOpen
    }

    /**
     * 监听MainActivity的音量调整
     */
    fun observeHomeSystemVoice() {

        Log.e("asdjasjdaksd", "15")
        if (_mPlayer != null) {
            if (isHomePageVoiceOpen) {
                mPlayer.volume = mPlayer.deviceVolume.toFloat()
            }
        }
    }

    /**
     * 监听常规页面声音变化
     */
    fun observeSystemVoice() {

        Log.e("asdjasjdaksd", "16")
        if (_mPlayer != null) {
            mPlayer.volume = mPlayer.deviceVolume.toFloat()
        }
    }

    fun getPlayerVoice(): Float = mPlayer.volume
    fun isPlaying(): Boolean = mPlayer.isPlaying
    fun currentMediaId(): String? = mPlayer.currentMediaItem?.mediaId
    fun currentPosition(): Long = mPlayer.currentPosition
    fun duration(): Long = mPlayer.duration
    fun bufferedPos(): Long = mPlayer.bufferedPosition

    /**
     * 注销、释放资源
     */
    fun releasePlayer() {

        Log.e("asdjasjdaksd", "17")
        _mPlayer?.let { _ ->
            mPlayer.removeListener(mListener)
            mPlayer.clearMediaItems()
            mPlayer.release()
            tempRecoMediaIndexMap.clear()
            _mPlayer = null
            mCurPos = -1
        }
    }

    fun seekTo(position: Long) {

        Log.e("asdjasjdaksd", "18")
        mPlayer.seekTo(position)
    }

    /**
     * ********当前页面只有一个可播放的视频时***************************************************
     *
     * 处理以下三种特殊/简单的情况(不需要切换view的情况)：
     *  - 满足播放条件，当前视频就是正在播放中的视频，不做处理，终止后续一切操作
     *  - 满足播放条件，当前视频为刚刚暂停的视频，直接设置 playWhenReady = true 继续播放，且终止后续一切操作
     *  - 不满足播放条件时，如果正在播放就暂停播放，没有播放不做处理，然后终止后续一切操作
     */
    fun handleOn(isOverHalf: Boolean, videoCode: Int, position: Int): Boolean {

        Log.e("asdjasjdaksd", "19")
        if (isOverHalf) {
            if (mPlayer.isPlaying) {
                mPlayer.currentMediaItem?.let {
                    if (it.mediaId == videoCode.toString()) {
                        return true
                    }
                }
            } else {
                if (mPlayer.playbackState == Player.STATE_READY && !mPlayer.playWhenReady) {//pause()后的状态
                    mPlayer.currentMediaItem?.let {
                        if (it.mediaId == videoCode.toString()) {//继续播放同一个视频
                            this.mCurPos = position

                            mPlayer.playWhenReady = true
                            return true
                        }
                    }
                }
            }
        } else {//没超过一半，如果在播放中，立即停止播放，如果没有播放不做处理
            pausePlayer()
            return true
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
                    Log.e("asdjasjdaksd", "20")
                    Log.e("PlayerManager", "STATE_BUFFERING")
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e("asdjasjdaksd", "21")
                    Log.e("PlayerManager", "STATE_READY")
                }
                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("asdjasjdaksd", "22")
                    Log.e("PlayerManager", "STATE_IDLE")
                }
                Player.STATE_ENDED -> {//播放结束
                    Log.e("asdjasjdaksd", "23")
                    Log.e("PlayerManager", "STATE_ENDED")
                }
            }
        }

        //回调后，立马执行 STATE_BUFFERING
        override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
            Log.e("asdjasjdaksd", "24")
            super.onPlayWhenReadyChanged(playWhenReady, reason)
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)

            Log.e("asdjasjdaksd", "25")
            Log.e("PlayerManager", "error:${error.message.toString()}")
        }

        //当 #{isPlaying()} 的值改变时调用 ，是否player正在播放中  切换播放源时会关闭上一个视频
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            Log.e("asdjasjdaksd", "26")
            mPlayer.currentMediaItem?.let {
                val code = it.mediaId.toInt()
                Log.e("PlayerManager", "code: ::$code")
            }
            //playerListener?.updatePlayerView(isPlaying, mCurPos)
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    //使用exoplayer自带的debug helper来显示实时调试信息
    fun debugHelper(debugTextView: TextView) {

        /* 扩展：使用exoplayer自带的debug helper来显示实时调试信息 */
        val debugViewHelper = DebugTextViewHelper(mPlayer, debugTextView)
        debugViewHelper.start()
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

    fun getRecoPlayingPos(): Int {

        Log.e("asdjasjdaksd", "27")
        if (mPlayer.isPlaying && recoPlayPos != -1) {
            return recoPlayPos
        }
        Log.d(TAG, "No playing item or 'recoPlayPos' has a value of -1")
        return -1
    }

}