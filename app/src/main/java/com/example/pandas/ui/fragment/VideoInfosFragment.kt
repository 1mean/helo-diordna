package com.example.pandas.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.startUserInfoActivity
import com.example.pandas.biz.interaction.OnVideoItemClickLIstener
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.databinding.FragmentInformationBinding
import com.example.pandas.ui.adapter.VideoRecoListAdapter
import com.example.pandas.ui.ext.initLikeContainer
import com.example.pandas.ui.ext.initUser
import com.example.pandas.ui.ext.initVideo
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: VideoInfosFragment
 * @author: dongyiming
 * @date: 2/14/22 9:48 下午
 * @version: v1.0
 */
public class VideoInfosFragment : BaseFragment<VideoViewModel, FragmentInformationBinding>(),
    View.OnClickListener, OnVideoItemClickLIstener {

    private val mAdapter: VideoRecoListAdapter by lazy { VideoRecoListAdapter(listener = this) }

    var isLike = false
    private var isLove = false
    private var isCollect = false
    private var isAttention = false
    private lateinit var bottomSheetDialog: BottomSheetDialog

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

        binding.clayoutVideoInfoFollow.setOnClickListener {

        }
    }

    override fun createObserver() {

        mViewModel.videos.observe(viewLifecycleOwner) {

            initVideo(it.videoInfo)
            initLikeContainer(it)

            it.videoInfo.user?.let { author ->

                initUser(author)

                isAttention = mViewModel.isAttention(mActivity, author.userCode)

                if (isAttention) {//已关注
                    binding.llayoutInfoAttention.visibility = View.GONE
                    binding.llayoutInfoAttentioned.visibility = View.VISIBLE
                    binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                }

                binding.clayoutVideoInfoFollow.setOnClickListener {
                    if (isAttention) {
                        bottomSheetDialog = BottomSheetDialog(mActivity)
                        val dBinding =
                            DialogAttentionCancelBinding.inflate(LayoutInflater.from(mActivity))

                        dBinding.rlayoutAdd.setOnClickListener {
                            Toast.makeText(mActivity, "加入特别关注", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                        dBinding.rlayoutGroup.setOnClickListener {
                            Toast.makeText(mActivity, "加入默认分组", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                        dBinding.rlayoutCancel.setOnClickListener { _ ->
                            mViewModel.deleteAttention(mActivity, author.userCode)
                            binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_attention)
                            binding.llayoutInfoAttention.visibility = View.VISIBLE
                            binding.llayoutInfoAttentioned.visibility = View.GONE
                            Toast.makeText(mActivity, "已取消关注", Toast.LENGTH_SHORT).show()
                            isAttention = false
                            bottomSheetDialog.dismiss()
                        }
                        dBinding.txtCancel.setOnClickListener {
                            bottomSheetDialog.dismiss()
                        }
                        bottomSheetDialog.setContentView(dBinding.root)
                        bottomSheetDialog.setCancelable(true)
                        bottomSheetDialog.setCanceledOnTouchOutside(true)
                        bottomSheetDialog.show()
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

    override fun firstOnResume() {
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