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
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.VideoRecoListAdapter
import com.example.pandas.ui.ext.initLikeContainer
import com.example.pandas.ui.ext.initUser
import com.example.pandas.ui.ext.initVideo
import com.example.pandas.ui.ext.setAnimation
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
    OnVideoItemClickLIstener, View.OnClickListener {

    private val mAdapter: VideoRecoListAdapter by lazy { VideoRecoListAdapter(listener = this) }

    private lateinit var videoData: VideoData
    private var userCode: Int = -1
    private var isAttention = false
    override fun lazyLoadTime(): Long = 0

    private val bottomSheetDialog: AttentionBottomSheetDialog by lazy {
        AttentionBottomSheetDialog(
            mActivity,
            itemClickListener
        )
    }

    private val shareDialog by lazy { ShareBottomSheetDialog(mActivity, shareItemListener) }


    override fun initView(savedInstanceState: Bundle?) {

        binding.rvVideoRecommend.run {

            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }

        binding.clayoutVideoInfoFollow.setOnClickListener {

        }

        binding.itemLike.setOnClickListener(this)
        binding.itemDislike.setOnClickListener(this)
        binding.itemLove.setOnClickListener(this)
        binding.itemShare.setOnClickListener(this)
        binding.itemCollect.setOnClickListener(this)
    }

    private val shareItemListener = object : ItemClickListener<String> {
        override fun onItemClick(t: String) {

            mViewModel.videos.value?.let {
                if (t == "微信") {
                    shareManager.shareLocalVideo(mActivity, it.videoInfo, SHARE_MEDIA.WEIXIN)
                } else if (t == "QQ") {
                    shareManager.shareLocalVideo(mActivity, it.videoInfo, SHARE_MEDIA.QQ)
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

            videoData = it.videoInfo.videoData ?: VideoData(it.videoInfo.code)

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

        val code = mActivity.intent.getIntExtra("code", -1)
        mViewModel.getVideoInfoAndRelations(code)
    }


    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(position: Int, code: Int) {
        mViewModel.setVideoItemClick(code)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.item_like -> {
                if (videoData.like) {
                    binding.imgLike.setImageResource(R.mipmap.img_video_like)
                    videoData.likes -= 1
                } else {
                    setAnimation(binding.imgLike)
                    binding.imgLike.setImageResource(R.mipmap.img_video_liked)
                    if (videoData.hate) {
                        binding.imgDislike.setImageResource(R.mipmap.img_video_dislike)
                        videoData.hate = false
                    }
                    videoData.likes += 1
                }
                if (videoData.likes > 0) {
                    binding.txtVideoLike.text = videoData.likes.toString()
                } else {
                    binding.txtVideoLike.text = "点赞"
                }
                videoData.like = !videoData.like
                mViewModel.addOrUpdateVideoData(videoData)
            }
            R.id.item_dislike -> {
                if (videoData.hate) {
                    binding.imgDislike.setImageResource(R.mipmap.img_video_dislike)
                } else {
                    binding.imgDislike.setImageResource(R.mipmap.img_video_disliked)
                    if (videoData.like) {
                        binding.imgLike.setImageResource(R.mipmap.img_video_like)
                        videoData.like = false
                        videoData.likes -= 1
                        if (videoData.likes > 0) {
                            binding.txtVideoLike.text = videoData.likes.toString()
                        } else {
                            binding.txtVideoLike.text = "点赞"
                        }
                    }
                }
                videoData.hate = !videoData.hate
                mViewModel.addOrUpdateVideoData(videoData)
            }
            R.id.item_love -> {
                if (videoData.love) {
                    binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
                } else {
                    binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
                }
                videoData.love = !videoData.love
                mViewModel.addOrUpdateVideoData(videoData)
            }
            R.id.item_collect -> {
                if (videoData.collect) {
                    videoData.collects -= 1
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_unpress)
                    binding.txtVideoLike.text = videoData.likes.toString()
                } else {
                    videoData.collects += 1
                    binding.imgCollect.setImageResource(R.mipmap.img_collect_pressed)
                }
                if (videoData.collects > 0) {
                    binding.txtVideoCollect.text = videoData.collects.toString()
                } else {
                    binding.txtVideoCollect.text = "收藏"
                }
                videoData.collect = !videoData.collect
                mViewModel.addOrUpdateVideoData(videoData)
            }
            R.id.item_share -> {
                shareDialog.addData().onShow()
            }
        }
    }
}