package com.example.pandas.ui.activity

import AudioServiceListener
import StatusBarUtils
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.viewmodel.AudioViewModel
import com.example.pandas.databinding.ActivityAudioBinding
import com.example.pandas.ui.service.AudioPlayService
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.util.Util
import java.util.*

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 3/1/22 6:41 下午
 * @version: v1.0
 */
public class AudioPlayActivity : BaseActivity<AudioViewModel, ActivityAudioBinding>(),
    View.OnClickListener {

    private var isTimeBarMoving = false //正在拖动时间bar

    //时间处理
    private var formatBuilder: StringBuilder? = null
    private var formatter: Formatter? = null

    private var fileName: String? = null
    private var url: String? = null
    private var mService: AudioPlayService? = null

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)

        formatBuilder = StringBuilder()
        formatter = Formatter(formatBuilder, Locale.getDefault())

        fileName = intent.getStringExtra("fileName").toString()
        url = intent.getStringExtra("url").toString()
        val intent = Intent(this, AudioPlayService::class.java)
        bindService(intent, conn, Service.BIND_AUTO_CREATE)
        binding.imgAudioPlay.setOnClickListener(this)
        binding.barAudioTime.addListener(barListener)
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getMusicInfo(fileName!!)
    }

    override fun createObserver() {
        mViewModel.musicResult.observe(this) { music ->
            music.cover?.let { loadRoundedCornerImage(this, 10, it, binding.imgAudioCover) }
            binding.txtAudioSongName.text = music.audioName
            binding.txtAudioSingerName.text = music.singerName
        }
    }


    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {

            Log.e("1mean", "success to connect service")
            val binder = service as AudioPlayService.LocalBinder
            mService = binder.getService()
            mService!!.addListener(audiolistener)
            url?.let { mService!!.startExoPlayer(it) }
        }

        override fun onServiceDisconnected(name: ComponentName?) {

            mService = null
        }

    }

    private val audiolistener = object : AudioServiceListener {
        override fun getMusicDuration(duration: String, lDuration: Long) {
            binding.txtAudioDuration.text = duration
            binding.barAudioTime.setDuration(lDuration)
        }

        override fun getCurrentPosition(position: String) {
            if (!isTimeBarMoving) {
                binding.txtAudioTimePosition.text = position
            }
        }

        override fun getTimeBarPosition(position: Long, bufferedPosition: Long) {
            if (!isTimeBarMoving) {
                binding.barAudioTime.setPosition(position)
                binding.barAudioTime.setBufferedPosition(bufferedPosition)
            }
        }

        override fun playStateChanged(state: Int) {//player状态变化的回调
            when (state) {
                5 -> binding.imgAudioPlay.setImageResource(R.mipmap.img_audio_play)
                3 -> binding.imgAudioPlay.setImageResource(R.mipmap.img_audio_pause)
            }
        }

    }

    //目前只有停止时做时间处理
    private val barListener = object : TimeBar.OnScrubListener {
        override fun onScrubStart(timeBar: TimeBar, position: Long) {
            isTimeBarMoving = true
            binding.txtAudioTimePosition.text =
                Util.getStringForTime(formatBuilder!!, formatter!!, position)
        }

        override fun onScrubMove(timeBar: TimeBar, position: Long) {
            isTimeBarMoving = true
            binding.txtAudioTimePosition.text =
                Util.getStringForTime(formatBuilder!!, formatter!!, position)
        }

        override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
            isTimeBarMoving = false
            if (!canceled) {
                mService?.seekTo(position)
            }
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_audio_play -> {
                mService?.dispatchPause()
            }
        }
    }

}