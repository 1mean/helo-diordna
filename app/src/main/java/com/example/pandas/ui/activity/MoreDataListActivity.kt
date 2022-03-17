package com.example.pandas.ui.activity

import MusicListFragment
import StatusBarUtils
import VideoListFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.viewmodel.MoreDataViewModel
import com.example.pandas.databinding.ActivityMoreBinding

/**
 * @description: 更多数据
 * @author: dongyiming
 * @date: 3/1/22 11:22 下午
 * @version: v1.0
 */
public class MoreDataListActivity : BaseActivity<MoreDataViewModel, ActivityMoreBinding>() {


    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)
        initToolBar()

    }

    override fun createObserver() {
    }

    private fun initToolBar() {

        when (val type = intent.getIntExtra("type", -1)) {
            VideoType.MUSIC.ordinal -> {
                mViewModel.currentType = type
                binding.txtTitleName.text = this.getString(R.string.str_video_music)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            AppInfos.TYPE_MP3 -> {
                mViewModel.currentType = type
                binding.txtTitleName.text = this.getString(R.string.str_music)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, MusicListFragment()).commit()
            }
            VideoType.FOOTBALL.ordinal -> {
                mViewModel.currentType = type
                binding.txtTitleName.text = this.getString(R.string.str_football)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }

        }
        binding.barTitle.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {

        fun startMoreDataActivity(context: Context, dataType: Int) {

            val intent = Intent(context, MoreDataListActivity::class.java).apply {
                putExtra("type", dataType)
            }
            context.startActivity(intent)
        }
    }
}