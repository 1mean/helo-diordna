package com.example.pandas.ui.activity

import VerticalVideoAdapter
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.viewmodel.VerticalVideoModel
import com.example.pandas.databinding.ActivityVerticalVideoplayBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import java.io.File

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/23/22 10:20 下午
 * @version: v1.0
 */
public class VerticalVideoActivity :
    BaseActivity<VerticalVideoModel, ActivityVerticalVideoplayBinding>() {

    private var mPlayer: ExoPlayer? = null

    override fun initView(savedInstanceState: Bundle?) {

        val list:MutableList<EyepetozerBean> = mutableListOf()
        for (i in 0..10){
            val eye = EyepetozerBean(videoId = i)
            list.add(eye)
        }


        binding.rvPlay.apply {
            layoutManager = LinearLayoutManager(
                this@VerticalVideoActivity,
                RecyclerView.VERTICAL, false
            )
            adapter = VerticalVideoAdapter(list)
        }
        PagerSnapHelper().attachToRecyclerView(binding.rvPlay)

    }

    override fun createObserver() {
    }

//    private fun initPlayer(file: File) {
//
//        //1.创建SimpleExoPlayer实例
//        mPlayer = ExoPlayer.Builder(this).build()
//        binding.playView.player = mPlayer
//
//        //2.创建播放菜单并添加到播放器
//        val firstLocalMediaItem = MediaItem.fromUri(Uri.fromFile(file))
//
//        mPlayer?.run {
//            setRepeatMode()//设置重复播放模式
//            addListener(listener)
//            addMediaItem(firstLocalMediaItem)
//            playWhenReady = true//3.设置播放方式为自动播放
//            prepare()//设置播放器状态为prepare
//        }
//    }

}