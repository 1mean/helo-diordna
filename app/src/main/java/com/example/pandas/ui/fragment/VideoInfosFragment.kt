package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnVideoItemClickLIstener
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentInformationBinding
import com.example.pandas.ui.adapter.VideoRecoListAdapter
import com.example.pandas.ui.ext.initLikeContainer
import com.example.pandas.ui.ext.initUser
import com.example.pandas.ui.ext.initVideo
import com.example.pandas.ui.view.dialog.AttentionBottomSheetDialog
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.um.shareManager
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA

/**
 * @description: VideoInfosFragment
 * @author: dongyiming
 * @date: 2/14/22 9:48 下午
 * @version: v1.0
 */
public class VideoInfosFragment : BaseFragment<VideoViewModel, FragmentInformationBinding>(),
    OnVideoItemClickLIstener {

    private val mAdapter: VideoRecoListAdapter by lazy { VideoRecoListAdapter(listener = this) }

    private var userCode: Int = -1
    private var isAttention = false
    private val bottomSheetDialog: AttentionBottomSheetDialog by lazy {
        AttentionBottomSheetDialog(
            mActivity,
            itemClickListener
        )
    }
    private val shareDialog by lazy { ShareBottomSheetDialog(mActivity, shareItemListener) }

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.rvVideoRecommend.run {

            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }

        binding.clayoutVideoInfoFollow.setOnClickListener {

        }

        binding.itemShare.setOnClickListener {
            shareDialog.addData().onShow()
        }
    }

    private val shareItemListener = object : ItemClickListener<String> {
        override fun onItemClick(t: String) {

            mViewModel.videoInfo.value?.let {
                if (t == "微信") {
                    shareManager.shareLocalVideo(mActivity, it, SHARE_MEDIA.WEIXIN)
                } else if (t == "QQ") {
                    shareManager.shareLocalVideo(mActivity, it, SHARE_MEDIA.QQ)
                }
            }
        }
    }


    private val mShareListener: UMShareListener = object : UMShareListener {
        override fun onStart(p0: SHARE_MEDIA?) {
        }

        override fun onResult(p0: SHARE_MEDIA?) {
        }

        override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {
        }

        override fun onCancel(p0: SHARE_MEDIA?) {
        }
    }


    override fun createObserver() {

        mViewModel.videos.observe(viewLifecycleOwner) {

            initVideo(it.videoInfo)
            initLikeContainer(it)

            it.videoInfo.user?.let { author ->

                initUser(author)

                userCode = author.userCode

                isAttention = mViewModel.isAttention(mActivity, author.userCode)

                if (isAttention) {//已关注
                    binding.llayoutInfoAttention.visibility = View.GONE
                    binding.llayoutInfoAttentioned.visibility = View.VISIBLE
                    binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                }

                binding.clayoutVideoInfoFollow.setOnClickListener {
                    if (isAttention) {
                        bottomSheetDialog.onShow()
                    } else {
                        isAttention = true
                        mViewModel.follow(mActivity, author.userCode)
                        binding.llayoutInfoAttention.visibility = View.GONE
                        binding.llayoutInfoAttentioned.visibility = View.VISIBLE
                        binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                        Toast.makeText(mActivity, "已关注", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            mAdapter.refreshAdapter(it.recoVideos)
            binding.viewVideoInfo.visibility = View.VISIBLE
        }
    }

    val itemClickListener: ItemClickListener<Int> = object : ItemClickListener<Int> {
        override fun onItemClick(t: Int) {

            when (t) {
                0 -> {//加入特别关注
                    Toast.makeText(mActivity, "加入特别关注", Toast.LENGTH_SHORT).show()
                }
                1 -> {//设置分组
                    Toast.makeText(mActivity, "加入默认分组", Toast.LENGTH_SHORT).show()
                }
                2 -> {//取消关注
                    mViewModel.deleteAttention(mActivity, userCode)
                    binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_attention)
                    binding.llayoutInfoAttention.visibility = View.VISIBLE
                    binding.llayoutInfoAttentioned.visibility = View.GONE
                    Toast.makeText(mActivity, "已取消关注", Toast.LENGTH_SHORT).show()
                    isAttention = false
                }
            }
        }
    }

    override fun firstOnResume() {
    }


    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(position: Int, code: Int) {
        mViewModel.setVideoItemClick(code)
    }
}