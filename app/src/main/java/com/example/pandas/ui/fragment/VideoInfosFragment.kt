package com.example.pandas.ui.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.startUserInfoActivity
import com.example.pandas.biz.interaction.OnVideoItemClickLIstener
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentInformationBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.adapter.VideoRecoListAdapter

/**
 * @description: VideoInfosFragment
 * @author: dongyiming
 * @date: 2/14/22 9:48 下午
 * @version: v1.0
 */
public class VideoInfosFragment : BaseFragment<VideoViewModel, FragmentInformationBinding>(),
    View.OnClickListener, OnVideoItemClickLIstener {

    private val mAdapter: VideoRecoListAdapter by lazy {
        VideoRecoListAdapter(
            mutableListOf(),
            this
        )
    }

    private var isLike = false
    private var isLove = false
    private var isCollect = false

    private var user: User? = null

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.itemLike.setOnClickListener(this)
        binding.itemLove.setOnClickListener(this)
        binding.itemCollect.setOnClickListener(this)
        binding.itemShare.setOnClickListener(this)

        binding.rvVideoRecommend.run {

            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }

        binding.imgVideoInfoHead.setOnClickListener {
            user?.let {
                startUserInfoActivity(mActivity, it)
            }
        }
    }

    override fun createObserver() {

        mViewModel.videoInfo.observe(viewLifecycleOwner) {

            if (it.isStar) {
                isLove = true
                binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
            }

            it.user?.let { author ->

                author.headUrl?.let { loadCircleImage(mActivity, it, binding.imgVideoInfoHead) }
                if (author.isVip == 1) {//是会员
                    binding.txtVideoInfoName.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    binding.txtVideoInfoName.setTextColor(
                        ContextCompat.getColor(
                            mActivity,
                            R.color.color_name_txt
                        )
                    )
                }
                user = author
            }

            if (it.user == null) {
                it.cover?.let { cover ->
                    loadCircleImage(mActivity, cover, binding.imgVideoInfoHead)
                }
            }

            it.user?.let { user ->
                binding.txtVideoInfoName.text = user.userName
            }

            it.releaseTime?.let { time ->
                binding.txtVideoInfoTime.text = time
            }
            it.title?.let { title ->
                binding.txtVideoInfoTitle.text = title
            }

            binding.viewVideoInfo.visibility = View.VISIBLE
        }

        mViewModel.recommendVideos.observe(viewLifecycleOwner) { list ->

            mAdapter.refresh(list)
        }
    }

    override fun firstOnResume() {
        mViewModel.getRecommendVideos()
    }


    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(v: View?) {

        when (v!!.id) {

            R.id.item_like -> {
                if (isLike) {
                    binding.imgLike.setImageResource(R.mipmap.img_like_unpress)
                } else {
                    binding.imgLike.setImageResource(R.mipmap.img_like_pressed)
                }
                isLike = !isLike
            }

            R.id.item_love -> {
                if (isLove) {
                    binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
                } else {
                    binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
                }
                isLove = !isLove
            }
            R.id.item_collect -> {
                if (isCollect) {
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_unpress)
                } else {
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_pressed)
                }
                isCollect = !isCollect
            }
            R.id.item_share -> {

            }
        }
    }

    override fun onClick(position: Int, code: Int) {
        mViewModel.setVideoItemClick(code)
    }
}