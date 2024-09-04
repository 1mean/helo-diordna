package com.example.pandas.ui.fragment.main.home.music

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.android_sqlite.entity.MusicVo
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.ext.getMusicUrl
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.MoreDataViewModel
import com.example.pandas.databinding.FragmentMusicListBinding
import com.example.pandas.ui.activity.AudioPlayActivity
import com.example.pandas.ui.adapter.MusicListAdapter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView2
import kotlinx.coroutines.launch

/**
 * @description: MusicListFragment
 * @author: dongyiming
 * @date: 3/2/22 5:01 下午
 * @version: v1.0
 */
public class MusicListFragment : BaseFragment<MoreDataViewModel, FragmentMusicListBinding>(),
    LoadMoreRecyclerView2.ILoadMoreListener {

    private val mAdapter: MusicListAdapter by lazy {
        MusicListAdapter(mutableListOf()) { position: Int, t: String ->
            val filePath = getMusicUrl(mActivity, t)
            if (filePath.isNotEmpty()) {

                val intent = Intent(mActivity, AudioPlayActivity::class.java).apply {
                    putExtra("fileName", t)
                    putExtra("position", position)
                }
                mActivity.startActivity(intent)
            } else {
                showToast("找不到音频文件")
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerMusicList.apply {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@MusicListFragment)
        }

        binding.clayoutPlay.setOnClickListener {

        }
    }

    override fun createObserver() {

        lifecycleScope.launch {
            mViewModel.musicCountFlow.collect {
                binding.txtMusicTopCounts.text = it.toString()
            }
        }

        mViewModel.musicResult.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                if (it.isEmpty) {//数据为空，或是没有更多的数据，如只有一页的数据
                    //binding.recyclerMusicList.notifyFooter()
                } else if (it.isRefresh) {
                    //initBottomMenu(it.listData[0])
                    mAdapter.refreshAdapter(it.listData)
                    if (!it.hasMore) {
                        binding.recyclerMusicList.noMoreData()
                    }
                } else {
                    Log.e("1mean", "hasmore: ${it.hasMore}")
                    if (!it.hasMore) {
                        binding.recyclerMusicList.noMoreData()
                    } else {
                        binding.recyclerMusicList.loadMoreFinished()
                    }
                    mAdapter.loadMore(it.listData)
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getPageMusic()
        mViewModel.getMusicCounts()
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onLoadMore() {
        mViewModel.getPageMusic()
    }

    private fun initBottomMenu(music: MusicVo) {
//        loadCircleImage(mActivity, music.cover!!, binding.imgMusicListCover)
//        binding.txtMusicListSong.text = music.audioName
//        binding.txtMusicListName.text = music.singerName
    }
}