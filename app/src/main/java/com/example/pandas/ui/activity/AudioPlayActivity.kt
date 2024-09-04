package com.example.pandas.ui.activity

import android.annotation.SuppressLint
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.MusicVo
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadLayoutBackGround
import com.example.pandas.biz.interaction.AudioServiceListener
import com.example.pandas.biz.viewmodel.AudioViewModel
import com.example.pandas.databinding.ActivityAudioBinding
import com.example.pandas.ui.adapter.AudioMenuAdapter
import com.example.pandas.ui.service.AudioPlayService
import com.example.pandas.ui.view.dialog.FixedHeightBottomSheetDialog
import com.example.pandas.utils.StatusBarUtils
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.util.Util
import java.util.*

/**
 * @description: AudioPlayActivity
 * @author: dongyiming
 * @date: 3/1/22 6:41 下午
 * @version: v1.0
 */
public class AudioPlayActivity : BaseActivity<AudioViewModel, ActivityAudioBinding>() {

    private var isTimeBarMoving = false //正在拖动时间bar

    //时间处理
    private var formatBuilder: StringBuilder? = null
    private var formatter: Formatter? = null

    private var mRecyclerView: RecyclerView? = null
    private var fileName: String? = null
    private var position: Int = 0
    private var mService: AudioPlayService? = null

    private var mLayoutManager: LinearLayoutManager? = null


    //buttom dialog
    private var mDialog: FixedHeightBottomSheetDialog? = null

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)

        formatBuilder = StringBuilder()
        formatter = Formatter(formatBuilder, Locale.getDefault())

        fileName = intent.getStringExtra("fileName").toString()
        position = intent.getIntExtra("position", 0)
        val intent = Intent(this, AudioPlayService::class.java)
        bindService(intent, conn, Service.BIND_AUTO_CREATE)
        binding.clayoutAudioPlay.setOnClickListener {
            mService?.dispatchPause()
        }
        binding.barAudioTime.addListener(barListener)

        binding.imgAudioMenu.setOnClickListener {
            initMenu()
        }

        binding.clayoutAudioNext.setOnClickListener {
            mService?.switchSong(true)
        }
        binding.clayoutAudioLast.setOnClickListener {
            mService?.switchSong(false)
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getMusicInfo(fileName!!)
        mViewModel.getMenu()
    }

    override fun createObserver() {
    }


    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {

            val binder = service as AudioPlayService.LocalBinder
            mService = binder.getService()
            mService!!.addListener(audiolistener)
            val list = mViewModel.musicsResult.value
            list?.let { mService!!.startExoPlayer(fileName!!, it) }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mService = null
        }
    }

    @SuppressLint("InflateParams")
    private fun initMenu() {

        if (mDialog == null) {//menu背景设置透明，才能显示出顶部圆角
            mDialog = FixedHeightBottomSheetDialog(this, R.style.BottomSheetDialog, 1500)
            val menuView = LayoutInflater.from(this).inflate(R.layout.layout_audio_menu, null)
            mRecyclerView = menuView.findViewById<RecyclerView>(R.id.recycler_list)
            mRecyclerView?.itemAnimator = DefaultItemAnimator()
            mLayoutManager = LinearLayoutManager(this)
            mRecyclerView?.layoutManager = mLayoutManager

            val list = mViewModel.musicsResult.value
            val adapter =
                list?.let {
                    AudioMenuAdapter(it, fileName!!) { position: Int, t: MusicVo ->
                        mService?.seekToMediaItem(position)
                        (mRecyclerView?.adapter as AudioMenuAdapter).updateSelectItem(
                            t.fileName!!,
                            position
                        )
                    }
                }
            mRecyclerView!!.adapter = adapter
            mDialog!!.setContentView(menuView)
        } else {
            (mRecyclerView?.adapter as AudioMenuAdapter).updateSelectItem(fileName!!, position)
        }
        mLayoutManager?.scrollToPositionWithOffset(position, 200)
        mDialog?.show()
    }

    private val audiolistener = object : AudioServiceListener {

        override fun initPlayView(mediaIndex: Int) {
            mViewModel.musicsResult.value?.let { list ->
                val currentItem = list[mediaIndex]
                fileName = currentItem.fileName
                position = mediaIndex
                loadCenterRoundedCornerImage(
                    this@AudioPlayActivity,
                    50,
                    currentItem.cover!!,
                    binding.imgAudioCover
                )
                loadLayoutBackGround(
                    this@AudioPlayActivity,
                    currentItem.cover!!,
                    binding.flayoutAudio
                )
                binding.txtAudioSongName.text = currentItem.audioName
                binding.txtAudioSingerName.text = currentItem.singerName
            }
        }

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
                mService?.seekToPosition(position)
            }
        }

    }

    override fun onPause() {
        super.onPause()

    }

}