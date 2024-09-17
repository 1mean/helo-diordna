package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.pandas.bean.MediaInfo
import com.example.pandas.bean.MediaItemWrapper
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.STATE_READY
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util
import com.helo.video.ExoMedia
import java.io.File
import java.util.concurrent.ConcurrentHashMap

/**
 * @description: ExoPlayer统一处理，后续升级成Media3
 * @author: dongyiming
 * @date: 8/28/22 4:20 下午
 * @version: v1.0
 */
public class ExoMediaManager(
    private val context: Context,
    private val listener: ExoListener,
    private val lifecycleOwner: LifecycleOwner
) : DefaultLifecycleObserver {

    private var isOpenVoice = false
    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var startTime: Long = 0
    private var oldPlayerView: StyledPlayerView? = null

    //private val mediaItemsCache: ConcurrentHashMap<Int, MediaItemInfo> = ConcurrentHashMap()
    private val mediaIndexs = MediaIndexMap()

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    /**
     * - 跳转到其他activity回来，会执行onStart()和onResume()
     * - 切换到其他fragment，只会执行onPause()和onResume()
     * - onStart()比fragment的onStart()后执行
     */
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if (Util.SDK_INT > 23) {
            if (_mPlayer == null) {
                Log.e("1mesdadan", "life onstart")
                _mPlayer = ExoPlayer.Builder(context).build()
                _mPlayer?.addListener(mListener)
            }
        }
    }

    /**
     * onPause()比fragment的onPause()先执行
     */
//    override fun onPause(owner: LifecycleOwner) {
//        super.onPause(owner)
//        Log.e("1mesdadan","manager onPause")
//        releasePlayer()
//    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        releasePlayer()
        lifecycleOwner.lifecycle.removeObserver(this)
    }

    fun play(playerView: StyledPlayerView, mediaInfo: MediaInfo) {

        startTime = System.currentTimeMillis()
        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
//        if (isOpenVoice) {
//            mPlayer.volume = mPlayer.deviceVolume.toFloat() / 16
//        } else {
//            mPlayer.volume = 0f
//        }
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        oldPlayerView = playerView

        val videoCode = mediaInfo.videoCode
        val playPos = mediaInfo.playPos

        if (mediaIndexs.exist(mediaInfo.videoCode)) {
            Log.e("1mean","manager 777")
            mediaIndexs.get(mediaInfo.videoCode)?.let {
                mPlayer.seekTo(mediaIndexs.indexOf(videoCode), it.playPos)
            }
        } else {
            synchronized(this) {
                if (PlayerConfig.instance.hasMediaItem(videoCode)) {
                    Log.e("1mean","manager 888")
                    PlayerConfig.instance.getMediaItem(videoCode)?.let {
                        it.mediaItem?.let { item ->
                            mPlayer.addMediaItem(item)
                        }
                        val index = mediaIndexs.add(mediaInfo)
                        mPlayer.seekTo(index, it.playPosition)
                    }
                } else {
                    Log.e("1mean","manager 999")
                    val mediaItem = if (mediaInfo.playUrl.startsWith("http")) {
                        MediaItem.Builder().setUri(mediaInfo.playUrl)
                            .setMediaId(mediaInfo.videoCode.toString()).build()
                    } else {
                        MediaItem.Builder().setUri(Uri.fromFile(File(mediaInfo.playUrl)))
                            .setMediaId(mediaInfo.videoCode.toString()).build()
                    }
                    val index = mediaIndexs.add(mediaInfo)
                    PlayerConfig.instance.addMediaItem(
                        videoCode,
                        MediaItemWrapper(playPos, mediaItem)
                    )
                    mPlayer.addMediaItem(mediaItem)
                    mPlayer.seekTo(index, playPos)
                }
            }
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
                    Log.e("ExoMediaManager", "STATE_BUFFERING")
                }

                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                    Log.e("ExoMediaManager", "STATE_READY: ${mPlayer.isPlaying}")
                }

                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("ExoMediaManager", "STATE_IDLE")
                }

                Player.STATE_ENDED -> {//播放结束
                    Log.e("ExoMediaManager", "STATE_ENDED")
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
            Log.e("1mean","onIsPlayingChanged isPlaying=$isPlaying")
            listener.OnPlayerViewShow(isPlaying)
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
            synchronized(this) {
                mPlayer.currentMediaItem?.mediaId?.let { code ->
                    if (PlayerConfig.instance.hasMediaItem(code.toInt())) {
                        PlayerConfig.instance.updatePosition(code.toInt(), mPlayer.currentPosition)
                    } else {
                        Log.e("1mean", "Pause Error: 当前播放的MediaItem，并未存储 .")
                    }
                    mediaIndexs.updatePlayingPosition(code.toInt(), mPlayer.currentPosition)
                }
            }
            mPlayer.pause()
        }
    }

    fun refreshPlayer() {
        if (mPlayer.isPlaying) {
            mPlayer.pause()
            //因为要刷新数据，同时再次播放也要执行mPlayer.seekTo(index)。如果媒体库数据不清空会播放之前的老数据
            mPlayer.clearMediaItems()
        }
        mediaIndexs.clear()
    }

    fun releasePlayer() {
        mPlayer.currentMediaItem?.mediaId?.let {
            val videoCode = it.toInt()
            synchronized(this) {
                if (PlayerConfig.instance.hasMediaItem(videoCode)) {
                    PlayerConfig.instance.updatePosition(videoCode, mPlayer.currentPosition)
                } else {
                    Log.e("1mean", "Pause Error: 当前播放的MediaItem，并未存储 .")
                }
            }
            mediaIndexs.updatePlayingPosition(videoCode, mPlayer.currentPosition)
        }
        mPlayer.removeListener(mListener)
        mPlayer.release()
        mediaIndexs.clear()
        oldPlayerView = null
        _mPlayer = null
    }

    fun isPlaying(): Boolean = mPlayer.isPlaying

    fun resumePlay() {
        if (!mPlayer.isPlaying && mPlayer.playbackState == STATE_READY) {
            mPlayer.playWhenReady = true
        }
    }

    /**
     * deviceVolume [0,16]
     * volume [0,1.0]
     *
     */
    fun updateVolume(isOpen: Boolean) {

        this.isOpenVoice = isOpen
        if (isOpen) {//打开视频声音
            mPlayer.volume = mPlayer.deviceVolume.toFloat() / 16
        } else {
            mPlayer.volume = 0f
        }
    }

    interface ExoListener {
        fun OnPlayerViewShow(isShow: Boolean)
    }
}