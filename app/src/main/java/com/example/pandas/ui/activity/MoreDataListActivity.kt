package com.example.pandas.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.viewmodel.MoreDataViewModel
import com.example.pandas.databinding.ActivityMoreBinding
import com.example.pandas.ui.fragment.main.home.music.MusicListFragment
import com.example.pandas.ui.fragment.video.VideoListFragment
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 更多数据
 * @author: dongyiming
 * @date: 3/1/22 11:22 下午
 * @version: v1.0
 */
public class MoreDataListActivity : BaseActivity<MoreDataViewModel, ActivityMoreBinding>() {


    override fun initView(savedInstanceState: Bundle?) {

        initToolBar()

        appViewModel.appColorType.value?.let {
            binding.clayoutMoreTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.btnMoreBack.setImageResource(R.mipmap.img_topview_back)
                binding.txtMoreTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_history_title
                    )
                )
            } else {
                binding.btnMoreBack.setImageResource(R.mipmap.img_topview_back_white)
                binding.txtMoreTitle.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }
    }

    override fun createObserver() {
    }

    private fun initToolBar() {

        when (val type = intent.getIntExtra("type", -1)) {
            VideoType.MUSIC.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_video_music)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            AppInfos.TYPE_MP3 -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_music)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, MusicListFragment()).commit()
            }
            VideoType.FOOTBALL.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_football)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            VideoType.ART.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_art)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            VideoType.BABY.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_baby)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            VideoType.HONGLOU.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_honglou)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }
            VideoType.BEAUTY.ordinal -> {
                mViewModel.currentType = type
                binding.txtMoreTitle.text = this.getString(R.string.str_beauty)
                supportFragmentManager.beginTransaction()
                    .add(R.id.flayout_more, VideoListFragment()).commit()
            }

        }
        binding.btnMoreBack.setOnClickListener {
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