package com.example.pandas.biz.manager

import android.content.Context
import android.net.Uri
import com.example.pandas.bean.eyes.EyepetozerBean
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
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

    private var mCurVideoCode: Int = -1 //当前播放的视频id

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!

    private var oldPlayView: StyledPlayerView? = null

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = ExoPlayerManager()
    }

    fun initPlayer(context: Context, listener: Player.Listener) {

        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(listener)
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
    fun setUpPlay(
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
    fun play(playInfo: PlayingInfo,position:Int): ExoPlayerManager {

        if (playInfo.videoCode == 0 || playInfo.playUrl.isEmpty()) {
            throw Exception("PlayInfo is error : videoCode=${playInfo.videoCode},playUrl=${playInfo.playUrl}")
        }

        if (mCurVideoCode == playInfo.videoCode) {//继续播放之前的资源
            mPlayer.prepare()
        } else {
            mCurVideoCode = playInfo.videoCode
            tempVideoMap[mCurVideoCode] = playInfo

//            val currentMediaItem = MediaItem.fromUri(playInfo.playUrl)
//            mPlayer.clearMediaItems()//清空之前的资源文件
//            mPlayer.addMediaItem(currentMediaItem)
            mPlayer.seekTo(position,0)
            mPlayer.playWhenReady = true
            mPlayer.prepare()
        }
        return this
    }

    fun addMediaItems(list: MutableList<EyepetozerBean>) {

        if (list.isEmpty()) return

        list.forEach {
            val currentMediaItem = MediaItem.fromUri(it.playUrl!!)
            mPlayer.addMediaItem(currentMediaItem)
        }
    }

    fun refreshMediaItem(list: MutableList<EyepetozerBean>) {

        if (list.isEmpty()) return
        if (mPlayer.mediaItemCount > 0) mPlayer.clearMediaItems()
        list.forEach {
            val currentMediaItem = MediaItem.fromUri(it.playUrl!!)
            mPlayer.addMediaItem(currentMediaItem)
        }
    }

    fun stopPlayer() {

        if (mPlayer.isPlaying) {
            val playInfo = tempVideoMap.get(mCurVideoCode)
            playInfo?.playPos = mPlayer.currentPosition
            mPlayer.stop()
        }
    }

    fun prePare(){

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

    data class PlayingInfo(
        var videoCode: Int = 0,
        var playUrl: String = "",
        var playPos: Long = 0
    )
}