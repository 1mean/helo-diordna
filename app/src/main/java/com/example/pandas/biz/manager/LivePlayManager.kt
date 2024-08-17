package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.android_sqlite.entity.PetVideo
import com.example.pandas.bean.MediaInfo
import com.example.pandas.bean.MediaItemWrapper
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.File

/**
 * @description: LivePlayManager
 * @author: dongyiming
 * @date: 10/13/22 4:38 下午
 * @version: v1.0
 */
public class LivePlayManager(
    private val context: Context,
    private val playerListener: ExoPlayerListener
) {

    private var playPos = -1

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var oldPlayerView: StyledPlayerView? = null //上一个加载的Playerview

    private val mediaIndexs = RecoPlayManager.MediaIndexMap()//存储资源文件信息,目前只用于推荐界面

    //一、播放器初始化
    fun initPlayer(context: Context): LivePlayManager {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener) //添加监听器
        }
        return this
    }

    //二、添加视图
    fun addPlayerView(playerView: StyledPlayerView): LivePlayManager {

        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        oldPlayerView = playerView
        return this
    }

    /**
     * //三、设置循环模式。几个功能模块的重复模式是不同的
     *   - REPEAT_MODE_OFF(0):不重复,播放结束后继续资源列表里的下一个视频，直至列表结束到Player.STATE_ENDED
     *   - REPEAT_MODE_ONE(1):循环当前视频
     *   - REPEAT_MODE_ALL(2):循环播放整个资源列表
     */
    fun setRepeatMode(repeatMode: Int): LivePlayManager {

        mPlayer.repeatMode = repeatMode
        return this
    }

    /**
     * 四、开始播放
     *  - 舍弃利用mPlayer里的Playlist的位置来直接跳转切换视频
     *  - 舍弃本地存储视频在Playlist的位置和进度
     */
    fun startPlay(isLocalSource: Boolean, mediaInfo: MediaInfo, position: Int) {

        if (isLocalSource) {//播放本地视频
            val videoCode = mediaInfo.videoCode
            val playPos = mediaInfo.playPos
            if (mediaIndexs.exist(videoCode)) {
                mediaIndexs.get(mediaInfo.videoCode)?.let {
                    mPlayer.seekTo(mediaIndexs.indexOf(mediaInfo.videoCode), it.playPos)
                }
            } else {
                if (PlayerConfig.instance.hasMediaItem(videoCode)) {
                    Log.e("LiveVIdeosss", "6666")
                    val mediaItemWrapper = PlayerConfig.instance.getMediaItem(videoCode)
                    mediaItemWrapper!!.mediaItem?.let {
                        mPlayer.addMediaItem(it)
                        val index = mediaIndexs.add(mediaInfo)
                        Log.e("LiveVIdeosss", "playPosition: ${mediaItemWrapper.playPosition}")
                        mPlayer.seekTo(index, mediaItemWrapper.playPosition)
                    }
                } else {
                    val mediaItem =
                        MediaItem.Builder().setUri(Uri.fromFile(File(mediaInfo.playUrl)))
                            .setMediaId(mediaInfo.videoCode.toString()).build()
                    val index = mediaIndexs.add(mediaInfo)
                    PlayerConfig.instance.addMediaItem(
                        videoCode,
                        MediaItemWrapper(playPos, mediaItem)
                    )
                    mPlayer.addMediaItem(mediaItem)
                    mPlayer.seekTo(index, playPos)
                }
            }
            this.playPos = position
            mPlayer.playWhenReady = true
            mPlayer.prepare()
        }
    }

    /**
     * 仅仅暂停视频，同时存储最新进度
     */
    fun pause() {
        if (mPlayer.isPlaying) {
            mPlayer.pause()
            mPlayer.currentMediaItem?.let {
                val videoCode = it.mediaId.toInt()
                PlayerConfig.instance.updatePosition(videoCode, mPlayer.currentPosition)
                mediaIndexs.updatePlayingPosition(videoCode.toInt(), mPlayer.currentPosition)
            }
        }
    }

    /**
     * 停止播放，闲置播放器，释放播放所需要的加载的media和sources
     *
     * 再次调用prepare()时，player对象能继续被使用
     */
    fun stopPlayer() {
        if (mPlayer.isPlaying) {
            mPlayer.stop()
            playPos = -1
            mPlayer.currentMediaItem?.let {
                val videoCode = it.mediaId.toInt()
                PlayerConfig.instance.updatePosition(videoCode, mPlayer.currentPosition)
                mediaIndexs.updatePlayingPosition(videoCode.toInt(), mPlayer.currentPosition)
            }
        }
    }

    /**
     * 彻底释放播放器，存储不释放
     */
    fun releasePlayer() {
        _mPlayer?.let { _ ->
            mPlayer.currentMediaItem?.let {
                val videoCode = it.mediaId.toInt()
                PlayerConfig.instance.updatePosition(videoCode, mPlayer.currentPosition)
                mediaIndexs.updatePlayingPosition(videoCode.toInt(), mPlayer.currentPosition)
            }
            oldPlayerView?.player = null
            mPlayer.removeListener(mListener)
            mPlayer.clearMediaItems()
            mPlayer.release()
            mediaIndexs.clear()
            _mPlayer = null
            oldPlayerView = null//切记
            playPos = -1
        }
    }


    /**
     * 设置倍速和音量
     */
    fun setPlaybackParameters(speed: Float, pitch: Float): LivePlayManager {

        val playbackParameters = PlaybackParameters(speed, pitch)
        mPlayer.playbackParameters = playbackParameters
        return this
    }

    /**
     * 添加获取到的资源文件列表
     */
    fun addMediaItems(list: MutableList<PetVideo>) {
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

    /**
     * 是否是当前正在播放中的item
     */
    fun isCurrentPlayingItem(videoCode: Int): Boolean {
        if (mPlayer.isPlaying) {
            mPlayer.currentMediaItem?.let {
                val code = it.mediaId.toInt()
                if (code == videoCode) {
                    return true
                }
            }
        }
        return false
    }

    fun resumePlay(position: Int) {
        if (!mPlayer.isPlaying && mPlayer.playbackState == Player.STATE_READY) {
            mPlayer.playWhenReady = true
            this.playPos = position
        }
    }

    fun getCurPosition(): Int = playPos

//    fun isPlaying():Boolean{
//        if (_mPlayer == null) {
//            return false
//        }
//        return _mPlayer!!.isPlaying
//    }

    fun isPlaying(): Boolean {
        return if (_mPlayer == null) {
            false
        } else {
            mPlayer.isPlaying
        }
    }

    private val mListener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                Player.STATE_BUFFERING -> {//可以通过isPlaying和seek动作来处理界面相关
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                }
                Player.STATE_IDLE -> {//暂停不会触发
                }
                Player.STATE_ENDED -> {//播放结束
                }
            }
        }

        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            playerListener.isPlayingChanged(isPlaying)
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

}