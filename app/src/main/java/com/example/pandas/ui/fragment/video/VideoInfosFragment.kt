package com.example.pandas.ui.fragment.video

import AppInstance
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentInformationBinding
import com.example.pandas.ui.activity.LoginActivity
import com.example.pandas.ui.adapter.VideoRecoListAdapter
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.view.dialog.AttentionBottomSheetDialog
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.um.shareManager
import com.umeng.socialize.bean.SHARE_MEDIA

/**
 * @description: VideoInfosFragment
 * @author: dongyiming
 * @date: 2/14/22 9:48 下午
 * @version: v1.0
 */
public class VideoInfosFragment : BaseFragment<VideoViewModel, FragmentInformationBinding>(),
    View.OnClickListener {

    private val loginSuccess: Boolean
        get() = AppInstance.instance.isLoginSuccess

    private val mAdapter: VideoRecoListAdapter by lazy { VideoRecoListAdapter() }

    private var isTitleShow: Boolean = false

    private lateinit var videoData: VideoData
    private var userCode: Int = -1
    private var isAttention = false

    var status: Int = 0

    override fun lazyLoadTime(): Long = 0

    private val bottomSheetDialog: AttentionBottomSheetDialog by lazy {
        AttentionBottomSheetDialog(mActivity) {
            when (it) {
                0 -> {//加入特别关注
                    Toast.makeText(mActivity, "加入特别关注", Toast.LENGTH_SHORT).show()
                }
                1 -> {//设置分组
                    Toast.makeText(mActivity, "加入默认分组", Toast.LENGTH_SHORT).show()
                }
                2 -> {//取消关注
                    mViewModel.updateAttention(userCode)

                    val status = appViewModel.appColorType.value
                    binding.txtVideoAttention.text = "关注"
                    if (status == null || status == 0) {
                        binding.clayoutVideoInfoFollow.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
                        binding.txtVideoAttention.setTextColor(
                            ContextCompat.getColor(
                                mActivity, R.color.white
                            )
                        )
                    } else {
                        binding.clayoutVideoInfoFollow.setBackgroundResource(shape_20_drawables[status])
                        binding.txtVideoAttention.setTextColor(
                            ContextCompat.getColor(
                                mActivity, R.color.white
                            )
                        )
                    }

                    Toast.makeText(mActivity, "已取消关注", Toast.LENGTH_SHORT).show()
                    isAttention = false
                }
            }
        }
    }

    private val shareDialog by lazy { ShareBottomSheetDialog(mActivity, {}) }


    override fun initView(savedInstanceState: Bundle?) {

        binding.rvVideoRecommend.run {
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }

        binding.itemLike.setOnClickListener(this)
        //binding.itemDislike.setOnClickListener(this)
        //binding.itemLove.setOnClickListener(this)
        binding.itemShare.setOnClickListener(this)
        binding.itemCollect.setOnClickListener(this)

        binding.btnTitleShow.setOnClickListener {
            with(binding.txtVideoInfoTitle) {
                if (!isTitleShow) {
                    maxLines = Int.MAX_VALUE
                    minLines = 1
                    binding.btnTitleShow.setImageResource(R.mipmap.img_title_hide)
                } else {
                    maxLines = 1
                    minLines = 1
                    binding.btnTitleShow.setImageResource(R.mipmap.img_title_show)
                }
            }
            isTitleShow = !isTitleShow
        }

        val type = appViewModel.appColorType.value
        status = if (type == null || type == 0) {
            APP_COLOR_STATUS
        } else {
            type
        }
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

    override fun createObserver() {

        mViewModel.videos.observe(viewLifecycleOwner) {

            videoData = it.videoInfo.videoData ?: VideoData(videoCode = it.videoInfo.code)

            Log.e("22mean", "videoData: $videoData")

            initVideo(it.videoInfo)
            initLikeContainer(it)

            it.videoInfo.user?.let { author ->

                initUser(author)

                userCode = author.userCode

                if (author.attention) {//已关注
                    isAttention = true
                    binding.txtVideoAttention.text = "已关注"
                    binding.txtVideoAttention.setTextColor(
                        ContextCompat.getColor(
                            mActivity,
                            R.color.color_txt_panda_list_item
                        )
                    )
                    binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                } else {
                    val status = appViewModel.appColorType.value
                    binding.txtVideoAttention.text = "关注"
                    if (status == null || status == 0) {
                        binding.clayoutVideoInfoFollow.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
                        binding.txtVideoAttention.setTextColor(
                            ContextCompat.getColor(
                                mActivity, R.color.white
                            )
                        )
                    } else {
                        binding.clayoutVideoInfoFollow.setBackgroundResource(shape_20_drawables[status])
                        binding.txtVideoAttention.setTextColor(
                            ContextCompat.getColor(
                                mActivity, R.color.white
                            )
                        )
                    }
                }

                binding.clayoutVideoInfoFollow.setOnClickListener {
                    if (loginSuccess) {
                        if (isAttention) {
                            bottomSheetDialog.onShow()
                        } else {
                            mViewModel.updateAttention(userCode)
                            binding.txtVideoAttention.text = "已关注"
                            binding.txtVideoAttention.setTextColor(
                                ContextCompat.getColor(
                                    mActivity,
                                    R.color.color_txt_panda_list_item
                                )
                            )
                            binding.clayoutVideoInfoFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                            Toast.makeText(mActivity, "已关注", Toast.LENGTH_SHORT).show()
                            author.attention = !author.attention
                            isAttention = !isAttention
                        }
                    } else {
                        startAnyActivity(mActivity, LoginActivity::class.java)
                    }
                }
            }
            mAdapter.refreshAdapter(it.recoVideos)
            binding.viewVideoInfo.visibility = View.VISIBLE
        }
    }

    override fun firstOnResume() {

        val video = mActivity.intent.getParcelableExtra<PetVideo>("petVideo")
        video?.let {
            mViewModel.getVideoInfoAndRelations(it.code)
        }
    }


    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.item_like -> {
                addScaleAnimation(binding.imgLike, 1.3f)
                if (videoData.like) {
                    binding.imgLike.setImageResource(R.mipmap.img_video_new_like)
                    videoData.likes -= 1
                } else {
                    binding.imgLike.setImageResource(likeRes[status])
                    if (videoData.hate) {
                        //binding.imgDislike.setImageResource(R.mipmap.img_video_dislike)
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
//            R.id.item_dislike -> {
//                addScaleAnimation(binding.imgDislike, 1.3f)
//                if (videoData.hate) {
//                    binding.imgDislike.setImageResource(R.mipmap.img_video_dislike)
//                } else {
//                    binding.imgDislike.setImageResource(R.mipmap.img_video_disliked)
//                    if (videoData.like) {
//                        binding.imgLike.setImageResource(R.mipmap.img_video_like)
//                        videoData.like = false
//                        videoData.likes -= 1
//                        if (videoData.likes > 0) {
//                            binding.txtVideoLike.text = videoData.likes.toString()
//                        } else {
//                            binding.txtVideoLike.text = "点赞"
//                        }
//                    }
//                }
//                videoData.hate = !videoData.hate
//                mViewModel.addOrUpdateVideoData(videoData)
//            }
//            R.id.item_love -> {
//                addScaleAnimation(binding.imgLove, 1.3f)
//                if (videoData.love) {
//                    binding.imgLove.setImageResource(R.mipmap.img_love_unpress)
//                    videoData.loves -= 1
//                    videoData.shareTime = 0
//                } else {
//                    videoData.loves += 1
//                    binding.imgLove.setImageResource(R.mipmap.img_love_pressed)
//                    videoData.shareTime = System.currentTimeMillis() //暂时当喜欢时间用
//                }
//                if (videoData.loves > 0) {
//                    binding.txtVideoLoves.text = videoData.loves.toString()
//                } else {
//                    binding.txtVideoLoves.text = "喜欢"
//                    videoData.loves = 0
//                }
//                videoData.love = !videoData.love
//                mViewModel.addOrUpdateVideoData(videoData)
//            }
            R.id.item_collect -> {
                if (loginSuccess) {
                    addScaleAnimation(binding.imgCollect, 1.3f)
                    if (videoData.collect) {
                        videoData.collects -= 1
                        binding.imgCollect.setImageResource(R.mipmap.img_video_new_collect)
                        binding.txtVideoCollect.text = videoData.collects.toString()
                    } else {
                        videoData.collects += 1
                        binding.imgCollect.setImageResource(collectRes[status])
                    }
                    if (videoData.collects > 0) {
                        binding.txtVideoCollect.text = videoData.collects.toString()
                    } else {
                        binding.txtVideoCollect.text = "收藏"
                        videoData.collects = 0
                    }
                    videoData.collect = !videoData.collect
                    mViewModel.addOrUpdateVideoData(videoData)
                } else {
                    startAnyActivity(mActivity, LoginActivity::class.java)
                }
            }
            R.id.item_share -> {
                shareDialog.addData().onShow()
            }
        }
    }
}