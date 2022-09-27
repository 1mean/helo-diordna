package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.viewmodel.VerticalVideoModel
import com.example.pandas.databinding.ActivityVerticalVideoplayBinding
import com.example.pandas.ui.adapter.VerticalVideoAdapter
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util


/**
 * @description: 横屏视频
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class VerticalVideoActivity :
    BaseActivity<VerticalVideoModel, ActivityVerticalVideoplayBinding>(),
    VerticalVideoAdapter.VideoCallBack {

    private var mPlayer: ExoPlayer? = null
    private var video: EyepetozerItem? = null
    private val mAdapter: VerticalVideoAdapter by lazy {
        VerticalVideoAdapter(
            mutableListOf(),
            this
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, false, R.color.black)

        video = intent.getParcelableExtra("currentVideo")

    }

    override fun createObserver() {
        mViewModel.recommendWrapper.observe(this) {

            if (it.isSuccess) {
                mAdapter.refreshAdapter(it.listData)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23) {
            initPlayer()
        }
    }

    /**
     * 处理翻页时，exoplayer的释放和切换播放源
     */
    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            when (newState) {
                SCROLL_STATE_IDLE -> {
                }
                SCROLL_STATE_DRAGGING -> {
                }
                SCROLL_STATE_SETTLING -> {
                }
            }
        }
    }

    override fun play(url: String?, playerView: PlayerView) {

        if (url != null) {
            playerView.player = mPlayer
            val firstLocalMediaItem = MediaItem.fromUri(url)
            mPlayer?.run {
                //clearMediaItems()
                Log.e("1mean", "mediaCounts: ${this.mediaItemCount}")
                addMediaItem(firstLocalMediaItem)
                playWhenReady = true
                prepare()
                play()
            }
        }

    }

    private fun initPlayer() {

        //1.创建SimpleExoPlayer实例
        mPlayer = ExoPlayer.Builder(this).build()
        // binding.rvPlay.player = mPlayer

        //2.创建播放菜单并添加到播放器
        // val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))

        mPlayer?.run {
            repeatMode = Player.REPEAT_MODE_ALL//设置重复播放模式
            //addListener(listener)
            //playWhenReady = true//3.设置播放方式为自动播放
            //prepare()//设置播放器状态为prepare
        }

        video?.let { mViewModel.getRecoList(it) }
    }

}