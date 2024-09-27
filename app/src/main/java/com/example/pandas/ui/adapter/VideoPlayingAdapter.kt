package com.example.pandas.ui.adapter

import AppInstance
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import androidx.core.view.ViewConfigurationCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoData
import com.android.base.utils.TextUtil
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.databinding.AdapterVideoPlayingBinding
import com.example.pandas.ui.activity.LoginActivity
import com.example.pandas.ui.ext.startAnyActivity
import com.lxj.xpopup.XPopup
import java.util.*

/**
 * @description: VideoPagerAdapter
 * @author: dongyiming
 * @date: 9/19/22 7:27 下午
 * @version: v1.0
 */
public class VideoPlayingAdapter(
    private val list: MutableList<PetVideo> = mutableListOf(),
    private val listener: VerticalVideoListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var recyclerView: RecyclerView? = null

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(data: MutableList<PetVideo>) {
        if (data.isNotEmpty()) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    fun loadMore(data: MutableList<PetVideo>) {
        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size, data.size)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    fun getPetVide(position: Int) = list[position]

    fun likedClick(position: Int) {
        val video = list[position]
        val data = video.videoData
        if (data == null) {
            val vd = VideoData(
                videoCode = video.code,
                like = true,
            )
            video.videoData = vd
            listener.updateLikedView(true, vd)
        } else {
            listener.updateLikedView(!data.like, data)
            data.like = !data.like
        }
    }

    fun collectedClick(position: Int) {
        val video = list[position]
        val data = video.videoData
        if (data == null) {
            val vd = VideoData(
                videoCode = video.code,
                collect = true,
                collectTime = System.currentTimeMillis()
            )
            video.videoData = vd
            listener.updateCollectedView(true, video)
        } else {
            listener.updateCollectedView(!data.collect, video)
            data.collect = !data.collect
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            AdapterVideoPlayingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(binding: AdapterVideoPlayingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val name = binding.txtVideoName
        val header = binding.imgVideoHeader
        val title = binding.txtVideoTitle
        val play = binding.imgVerticalPlay
        val playerView = binding.playerVertical
        val coverImage = binding.imgShortVideoCover
        val coverLayout = binding.clayoutShortVideoCover
        val attentionView = binding.txtVideoAttention
        val switchToHorizontal = binding.clayoutVideoSwitch
        val videoInfosLayout = binding.clayouutVerticalInfos

        /**
         * 弹窗被拖拽时执行，适用于能拖拽的弹窗，比如Bottom弹窗和Drawer弹窗
         * @param value  拖拽的距离
         * @param percent  拖拽的百分比
         * @param upOrLeft 是否是向上或者向左；垂直拖拽时，true表示向上，false表现向下；
         *                 水平拖拽时，true表示向左，false表示向右
         */
        private val lastWidthPercent = 0.5
        private val lastHeightPercent = 0.6253

        //private val lastHeightPercent = 0.3747
        private var lastPercent = 0f
        fun playerChanged(position: Int, value: Int, percent: Float, upOrLeft: Boolean) {

            Log.e("1meaadasdadn", "value=$value,percent=$percent,upOrLeft=$upOrLeft")
            //bug:经常出现两次偏移的value值相同回调，会导致通过位移来判断上还是下的upOrLeft出现问题，
            // 导致在一系列up中出现几次down，导致屏幕抖动，所以相同数值的结果规避掉
            if (lastPercent == percent) {
                return
            }
            lastPercent = percent

            val video = list[position]
            if (video.vertical) {
                val params = playerView.layoutParams as FrameLayout.LayoutParams
                val with = 1080 * (1 - lastWidthPercent * percent)
                val height = 2125 * (1 - lastHeightPercent * percent)
                params.width = with.toInt()
                params.height = height.toInt()
                playerView.layoutParams = params
            } else {
                val params = playerView.layoutParams as FrameLayout.LayoutParams
                params.topMargin = ((1 - percent) * 750).toInt()
                playerView.layoutParams = params
            }
        }

        fun playerChanged(position: Int, isOpen: Boolean) {
            val video = list[position]
            if (isOpen) {//弹出
                if (video.vertical) {//2125-1080 变成  733-x    ---> 比例0.3449 ---> 733x373
                    val animationSet = AnimatorSet()
                    animationSet.duration = 300
                    animationSet.interpolator = DecelerateInterpolator()
                    val transScaleX = ObjectAnimator.ofFloat(playerView, "scaleX", 1f, 0.3449f)
                    val transScaleY = ObjectAnimator.ofFloat(playerView, "scaleY", 1f, 0.3449f)
                    animationSet.play(transScaleX).with(transScaleY)
                    animationSet.start()
                } else {
                    val animationSet = AnimatorSet()
                    animationSet.duration = 300
                    animationSet.interpolator = DecelerateInterpolator()
                    val transScaleX = ObjectAnimator.ofFloat(playerView, "translationY", 0f, -750f)
                    animationSet.play(transScaleX)
                    animationSet.start()
                }
            } else {//关闭
                if (video.vertical) {
                    val animationSet = AnimatorSet()
                    animationSet.duration = 100
                    animationSet.interpolator = DecelerateInterpolator()
                    val transScaleX = ObjectAnimator.ofFloat(playerView, "scaleX", 0.3449f, 1f)
                    val transScaleY = ObjectAnimator.ofFloat(playerView, "scaleY", 0.3449f, 1f)
                    animationSet.play(transScaleX).with(transScaleY)
                    animationSet.start()
                } else {
                    val animationSet = AnimatorSet()
                    animationSet.duration = 100
                    animationSet.interpolator = DecelerateInterpolator()
                    val transScaleX = ObjectAnimator.ofFloat(playerView, "translationY", -750f, 0f)
                    animationSet.play(transScaleX)
                    animationSet.start()
                }
            }
        }

        fun updateAttention(position: Int, userCode: Int) {
            val video = list[position]
            val user = video.user
            user?.let {
                if (it.userCode == userCode) {
                    if (it.attention) {
                        attentionView.setBackgroundResource(R.drawable.shape_video_bg_attention)
                        attentionView.text = "关注"
                    } else {
                        attentionView.setBackgroundResource(R.drawable.shape_video_bg_unattention)
                        attentionView.text = "已关注"
                    }
                    it.attention = !it.attention
                }
            }
        }

        fun updateVideoInfos(isHide: Boolean) {
            if (isHide) {
                videoInfosLayout.visibility = View.GONE
            } else {
                videoInfosLayout.visibility = View.VISIBLE
            }
        }

        fun hidePlerView() {
            if (play.isVisible) {
                play.visibility = View.GONE
            }
        }

        fun coverShow(isCoverShow: Boolean) {
            if (isCoverShow) {
                if (!coverLayout.isVisible) {
                    coverLayout.visibility = View.VISIBLE
                }
                play.visibility = View.GONE
            } else {
                if (coverLayout.isVisible) {
                    coverLayout.visibility = View.GONE
                }
            }
        }

        fun handle(position: Int) {
            val video = list[position]
            val user = video.user

            //BUG:不同长短视频尺寸的实现
            //app:resize_mode="zoom" + playerView.post{}实现短视频和长视频的不同尺寸的切换
            //如果只修改width和height是无效的，因为这是播放器的尺寸，播放器内视频的尺寸仍然不会是全屏
            playerView.post {
                if (video.vertical) {
                    val params = playerView.layoutParams
                    params.width = 1080
                    params.height = 2125
                    playerView.layoutParams = params
                } else {
                    val topMargin = (itemView.height - 624) / 2
                    val params = playerView.layoutParams as FrameLayout.LayoutParams
                    params.width = 1080
                    params.height = 624
                    params.topMargin = topMargin
                    playerView.layoutParams = params
                }
            }

            if (video.vertical) {
                switchToHorizontal.visibility = View.GONE
            } else {
                switchToHorizontal.visibility = View.VISIBLE
            }

            TextUtil.toggleEllipsize(
                context,
                title,
                1,
                video.title!!,
                "展开",
                R.color.color_video_bottom_zhankai,
                false
            )

            with(title) {
                maxLines = 1
                minLines = 1
            }

            list[position].cover?.let {
                loadImage(context, it, coverImage)
            }
            coverLayout.visibility = View.VISIBLE

            val params = playerView.layoutParams
            //coverShow(true)

            Log.e("1mean", "user=$user")
            user?.let {
                name.text = it.userName
                loadCircleImage(context, it.headUrl!!, header)
                //loadCircleImage(context, it.headUrl!!, musicImg)

                if (it.attention) {
                    attentionView.setBackgroundResource(R.drawable.shape_video_bg_unattention)
                    //attentionView.setTextColor(ContextCompat.getColor(context,R.color.white))
                } else {
                    attentionView.setBackgroundResource(R.drawable.shape_video_bg_attention)
                }
            }

            header.setOnClickListener {
                user?.let {
                    if (video.videoType == 3 || video.videoType == 4) {
                        listener.startUserActivity(it.userCode, it)
                    } else {
                        listener.startUserActivity(it.userCode, null)
                    }
                }
            }
            name.setOnClickListener {
                user?.let {
                    if (video.videoType == 3 || video.videoType == 4) {
                        listener.startUserActivity(it.userCode, it)
                    } else {
                        listener.startUserActivity(it.userCode, null)
                    }
                }
            }

            //长视频没有铺满播放器，会导致播放器外的区域无法点击暂停/播放
            itemView.setOnClickListener {
                if (!video.vertical) {
                    Log.e("1mean","点击了播放界面外的其他区域")
                    listener.onSingleTap()
                    if (play.isVisible) {
                        play.visibility = View.GONE
                    } else {
                        Log.e("1mean","22222222222")
                        play.visibility = View.VISIBLE
                    }
                }
            }

            playerView.controller(object : PlayerDoubleTapListener {

                override fun onLongPress(event: MotionEvent) {
                    super.onLongPress(event)
                    val action = event.action
                    Log.e("1mean","playerview longClick x = " + event.x)

                }

                override fun onSingleTapConfirmed() {
                    Log.e("1mean","player onSingleTapConfirmed")
                    listener.onSingleTap()
                    if (play.isVisible) {
                        play.visibility = View.GONE
                    } else {
                        Log.e("1mean","1111111111111")
                        play.visibility = View.VISIBLE
                    }
                }

                override fun onDoubleTapFinished() {
                    super.onDoubleTapFinished()
                    val data = list[position].videoData
                    if (data == null) {
                        val vd = VideoData(
                            videoCode = video.code,
                            like = true
                        )
                        list[position].videoData = vd
                        listener.onDoubleTap(vd)
                    } else {
                        if (!data.like) {
                            data.like = true
                            listener.onDoubleTap(data)
                        }
                    }
                }
            })

            attentionView.setOnClickListener {
                if (AppInstance.instance.isLoginSuccess) {
                    user?.let {
                        if (it.attention) {
                            XPopup.Builder(context).asConfirm(null, "确定不再关注？", "取消", "确认",
                                {
                                    attentionView.setBackgroundResource(R.drawable.shape_video_bg_attention)
                                    attentionView.text = "关注"
                                    listener.updateUserAttention(it.userCode)
                                    it.attention = !it.attention
                                }, { }, false, R.layout.dialog_login_out
                            ).show()
                        } else {
                            attentionView.setBackgroundResource(R.drawable.shape_video_bg_unattention)
                            attentionView.text = "已关注"
                            it.attention = !it.attention
                            listener.updateUserAttention(it.userCode)
                        }
                    }
                } else {
                    startAnyActivity(context, LoginActivity::class.java)
                }
            }
        }
    }

    interface VerticalVideoListener {

        fun onDoubleTap(videoData: VideoData)

        fun onSingleTap()

        fun collectItemLongClick(petVideo: PetVideo)

        fun updataVideoData(videoData: VideoData)

        fun collect(isAdd: Boolean, petVideo: PetVideo)

        fun updateUserAttention(userCode: Int)

        fun startUserActivity(userCode: Int, user: User?)

        fun showComments(videoCode: Int, commentCounts: Int)

        fun addAttention(userCode: Int)

        fun updateLikedView(liked: Boolean, videoData: VideoData)

        fun updateCollectedView(collected: Boolean, petVideo: PetVideo)

    }
}