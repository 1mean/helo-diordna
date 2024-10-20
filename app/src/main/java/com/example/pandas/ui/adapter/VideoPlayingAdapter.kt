package com.example.pandas.ui.adapter

import AppInstance
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoData
import com.android.base.utils.TextUtil
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.databinding.AdapterVideoPlayingBinding
import com.example.pandas.databinding.AdapterVideoPlayingLongBinding
import com.example.pandas.ui.activity.LoginActivity
import com.example.pandas.ui.ext.startAnyActivity
import com.google.android.exoplayer2.ui.StyledPlayerControlView
import com.google.android.exoplayer2.ui.StyledPlayerView
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

    private val TYPE_LONG = 0//长视频，宽>高
    private val TYPE_SHORT = 1//短视频，铺满全屏
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

    fun removePosition(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
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

    fun getDoubleTapVideoData(position: Int): VideoData {
        val video = list[position]
        val data = video.videoData
        if (data == null) {
            val vd = VideoData(
                videoCode = video.code,
                like = true
            )
            list[position].videoData = vd
            return vd
        } else {
            if (!data.like) {
                data.like = true
            }
            return data
        }
    }

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

    override fun getItemViewType(position: Int): Int {

        if (list[position].vertical) {
            return TYPE_SHORT
        }
        return TYPE_LONG
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_SHORT) {
            val binding =
                AdapterVideoPlayingBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ShortViewHolder(binding)
        } else {
            val binding =
                AdapterVideoPlayingLongBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return LongViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == TYPE_SHORT) {
            (holder as ShortViewHolder).handle(position)
        } else {
            (holder as LongViewHolder).handle(position)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ShortViewHolder(binding: AdapterVideoPlayingBinding) :
        MyViewHolder(binding.root) {

        val context = itemView.context
        val name = binding.txtVideoName
        val header = binding.imgVideoHeader
        val title = binding.txtVideoTitle
        val play = binding.imgVerticalPlay
        val playerView = binding.playerVertical
        val coverImage = binding.imgShortVideoCover
        val coverLayout = binding.clayoutShortVideoCover
        val attentionView = binding.txtVideoAttention
        val videoInfosLayout = binding.clayouutVerticalInfos

        override fun getPlayerView(): StyledPlayerView? {
            return playerView
        }

        override fun isViewIn(y: Float, view: View?): Boolean {
            if (view == null) {
                val location = IntArray(2)
                videoInfosLayout.getLocationOnScreen(location)
                val height = videoInfosLayout.height
                if (y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            } else {
                val location = IntArray(2)
                view.getLocationOnScreen(location)
                val height = view.height
                if (y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            }
            return false
        }

        override fun isHeaderIn(x: Float, y: Float): Boolean {
            Log.e("asdaddassssad", "x=$x,y=$y")
            val count = videoInfosLayout.childCount
            for (i in 0 until count) {
                val child = videoInfosLayout.getChildAt(i)
                Log.e("asdaddassssad", "child=$child")
                val location = IntArray(2)
                child.getLocationOnScreen(location)
                val width = child.width
                val height = child.height

                Log.e(
                    "asdaddassssad",
                    "x=${location[0]},y=${location[1]},width=$width,height=$height"
                )
                if (x.toInt() in location[0]..(location[0] + width) && y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            }
            return false
        }

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
        override fun playerChanged(position: Int, value: Int, percent: Float, upOrLeft: Boolean) {

            Log.e("1meaadasdadn", "value=$value,percent=$percent,upOrLeft=$upOrLeft")
            //bug:经常出现两次偏移的value值相同回调，会导致通过位移来判断上还是下的upOrLeft出现问题，
            // 导致在一系列up中出现几次down，导致屏幕抖动，所以相同数值的结果规避掉
            if (lastPercent == percent) {
                return
            }
            lastPercent = percent

            val video = list[position]
            val params = playerView.layoutParams as FrameLayout.LayoutParams
            val with = 1080 * (1 - lastWidthPercent * percent)
            val height = 2125 * (1 - lastHeightPercent * percent)
            params.width = with.toInt()
            params.height = height.toInt()
            playerView.layoutParams = params
        }

        override fun playerChanged(position: Int, isOpen: Boolean) {
            val video = list[position]
            if (isOpen) {//弹出//2125-1080 变成  733-x    ---> 比例0.3449 ---> 733x373
                val animationSet = AnimatorSet()
                animationSet.duration = 300
                animationSet.interpolator = DecelerateInterpolator()
                val transScaleX = ObjectAnimator.ofFloat(playerView, "scaleX", 1f, 0.3449f)
                val transScaleY = ObjectAnimator.ofFloat(playerView, "scaleY", 1f, 0.3449f)
                animationSet.play(transScaleX).with(transScaleY)
                animationSet.start()
            } else {//关闭
                val animationSet = AnimatorSet()
                animationSet.duration = 100
                animationSet.interpolator = DecelerateInterpolator()
                val transScaleX = ObjectAnimator.ofFloat(playerView, "scaleX", 0.3449f, 1f)
                val transScaleY = ObjectAnimator.ofFloat(playerView, "scaleY", 0.3449f, 1f)
                animationSet.play(transScaleX).with(transScaleY)
                animationSet.start()
            }
        }

        override fun updateAttention(position: Int, userCode: Int) {
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

        override fun updateVideoInfos(isHide: Boolean) {
            if (isHide) {
                videoInfosLayout.visibility = View.GONE
            } else {
                videoInfosLayout.visibility = View.VISIBLE
            }
        }

        override fun hidePlerView() {
            if (play.isVisible) {
                play.visibility = View.GONE
            }
        }

        override fun coverShow(isCoverShow: Boolean) {
            if (isCoverShow) {
                if (!coverLayout.isVisible) {
                    coverLayout.visibility = View.VISIBLE
                }
            } else {
                if (coverLayout.isVisible) {
                    coverLayout.visibility = View.GONE
                }
            }
        }

        override fun pauseViewShow(pauseViewShow: Boolean) {
            if (pauseViewShow) {
                play.visibility = View.VISIBLE
            } else {
                play.visibility = View.GONE
            }
        }

        override fun updatePauseView() {
            if (play.isVisible) {
                play.visibility = View.GONE
            } else {
                play.visibility = View.VISIBLE
            }
        }

        override fun updateFullScreen(position: Int, isFull: Boolean) {
        }

        override fun updateController() {
            if (playerView.isControllerFullyVisible) {
                playerView.hideController()
            } else {
                playerView.showController()
            }
        }

        override fun handle(position: Int) {
            val video = list[position]
            val user = video.user

            //BUG:不同长短视频尺寸的实现
            //app:resize_mode="zoom" + playerView.post{}实现短视频和长视频的不同尺寸的切换
            //如果只修改width和height是无效的，因为这是播放器的尺寸，播放器内视频的尺寸仍然不会是全屏
            playerView.post {
                val params = playerView.layoutParams
                params.width = 1080
                params.height = 2125
                playerView.layoutParams = params
                Log.e(
                    "1mean",
                    "position=$position , video=${video.vertical}, height=${playerView.height}, width=${playerView.width}"
                )
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

    open inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {

        open fun getPlayerView(): StyledPlayerView? = null
        open fun isViewIn(y: Float, view: View?): Boolean = false
        open fun isHeaderIn(x: Float, y: Float): Boolean = false
        open fun playerChanged(position: Int, value: Int, percent: Float, upOrLeft: Boolean) {

        }

        open fun playerChanged(position: Int, isOpen: Boolean) {

        }

        open fun updateAttention(position: Int, userCode: Int) {

        }

        open fun updateVideoInfos(isHide: Boolean) {

        }

        open fun hidePlerView() {

        }

        open fun coverShow(isCoverShow: Boolean) {

        }

        open fun pauseViewShow(pauseViewShow: Boolean) {

        }

        open fun updatePauseView() {

        }

        open fun updateFullScreen(position: Int, isFull: Boolean) {

        }

        open fun updateController() {

        }

        open fun handle(position: Int) {

        }
    }

    inner class LongViewHolder(binding: AdapterVideoPlayingLongBinding) :
        MyViewHolder(binding.root) {

        val context = itemView.context
        val name = binding.txtVideoName
        val header = binding.imgVideoHeader
        val title = binding.txtVideoTitle
        val play = binding.imgVerticalPlay
        val playerView = binding.playerVertical
        val coverImage = binding.imgShortVideoCover
        val coverLayout = binding.clayoutShortVideoCover
        val attentionView = binding.txtVideoAttention
        val videoInfosLayout = binding.clayouutVerticalInfos

        override fun getPlayerView(): StyledPlayerView? {
            return playerView
        }

        override fun isViewIn(y: Float, view: View?): Boolean {
            if (view == null) {
                val location = IntArray(2)
                videoInfosLayout.getLocationOnScreen(location)
                val height = videoInfosLayout.height
                if (y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            } else {
                val location = IntArray(2)
                view.getLocationOnScreen(location)
                val height = view.height
                if (y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            }
            return false
        }

        override fun isHeaderIn(x: Float, y: Float): Boolean {
            Log.e("asdaddassssad", "x=$x,y=$y")
            val count = videoInfosLayout.childCount
            for (i in 0 until count) {
                val child = videoInfosLayout.getChildAt(i)
                Log.e("asdaddassssad", "child=$child")
                val location = IntArray(2)
                child.getLocationOnScreen(location)
                val width = child.width
                val height = child.height

                Log.e(
                    "asdaddassssad",
                    "x=${location[0]},y=${location[1]},width=$width,height=$height"
                )
                if (x.toInt() in location[0]..(location[0] + width) && y.toInt() in location[1]..(location[1] + height)) {
                    return true
                }
            }
            return false
        }

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
        override fun playerChanged(position: Int, value: Int, percent: Float, upOrLeft: Boolean) {

            Log.e("1meaadasdadn", "value=$value,percent=$percent,upOrLeft=$upOrLeft")
            //bug:经常出现两次偏移的value值相同回调，会导致通过位移来判断上还是下的upOrLeft出现问题，
            // 导致在一系列up中出现几次down，导致屏幕抖动，所以相同数值的结果规避掉
            if (lastPercent == percent) {
                return
            }
            lastPercent = percent

            val video = list[position]
            val params = playerView.layoutParams as FrameLayout.LayoutParams
            params.topMargin = ((1 - percent) * 750).toInt()
            playerView.layoutParams = params
        }

        override fun playerChanged(position: Int, isOpen: Boolean) {
            val video = list[position]
            if (isOpen) {//弹出 //2125-1080 变成  733-x    ---> 比例0.3449 ---> 733x373
                val animationSet = AnimatorSet()
                animationSet.duration = 300
                animationSet.interpolator = DecelerateInterpolator()
                val transScaleX = ObjectAnimator.ofFloat(playerView, "translationY", 0f, -750f)
                animationSet.play(transScaleX)
                animationSet.start()
            } else {//关闭
                val animationSet = AnimatorSet()
                animationSet.duration = 100
                animationSet.interpolator = DecelerateInterpolator()
                val transScaleX = ObjectAnimator.ofFloat(playerView, "translationY", -750f, 0f)
                animationSet.play(transScaleX)
                animationSet.start()
            }
        }

        override fun updateAttention(position: Int, userCode: Int) {
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

        override fun updateVideoInfos(isHide: Boolean) {
            if (isHide) {
                videoInfosLayout.visibility = View.GONE
            } else {
                videoInfosLayout.visibility = View.VISIBLE
            }
        }

        override fun hidePlerView() {
            if (play.isVisible) {
                play.visibility = View.GONE
            }
        }

        override fun coverShow(isCoverShow: Boolean) {
            if (isCoverShow) {
                if (!coverLayout.isVisible) {
                    coverLayout.visibility = View.VISIBLE
                }
            } else {
                if (coverLayout.isVisible) {
                    coverLayout.visibility = View.GONE
                }
            }
        }

        override fun pauseViewShow(pauseViewShow: Boolean) {
            if (pauseViewShow) {
                play.visibility = View.VISIBLE
            } else {
                play.visibility = View.GONE
            }
        }

        override fun updatePauseView() {
            if (play.isVisible) {
                play.visibility = View.GONE
            } else {
                play.visibility = View.VISIBLE
            }
        }

        override fun updateFullScreen(position: Int, isFull: Boolean) {
            val video = list[position]
            if (isFull) {//设置全屏
                playerView.post {
                    val params = playerView.layoutParams as FrameLayout.LayoutParams
                    params.width = 1920
                    params.height = 1080
                    //BUG:必须添加topMargin，不然playerview只会显示的高度只有1/4
                    params.topMargin = 0
                    params.bottomMargin = 0
                    params.rightMargin = 42
                    playerView.layoutParams = params
                    attentionView.visibility = View.GONE
                }
            } else {
                val params = playerView.layoutParams as FrameLayout.LayoutParams
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
                params.height = 624
                val topMargin = (itemView.height - 624) / 2
                params.topMargin = 750
                //必须加上rightMargin=0，不然右侧会有一个margin，是横屏时隐藏顶部而来的间隙
                params.rightMargin = 0
                playerView.layoutParams = params
            }
        }

        override fun updateController() {
            if (playerView.isControllerFullyVisible) {
                playerView.hideController()
            } else {
                playerView.showController()
            }
        }

        override fun handle(position: Int) {
            val video = list[position]
            val user = video.user

            //BUG:不同长短视频尺寸的实现
            //app:resize_mode="zoom" + playerView.post{}实现短视频和长视频的不同尺寸的切换
            //如果只修改width和height是无效的，因为这是播放器的尺寸，播放器内视频的尺寸仍然不会是全屏
            playerView.post {
                val topMargin = (itemView.height - 624) / 2
                val params = playerView.layoutParams as FrameLayout.LayoutParams
                params.width = 1080
                params.height = 624
                params.topMargin = topMargin
                playerView.layoutParams = params
                Log.e(
                    "1mean",
                    "position=$position , video=${video.vertical}, height=${playerView.height}, width=${playerView.width}"
                )
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

        fun onDoubleTap(videoData: VideoData?)

        fun onSingleTap(isOuter: Boolean)//点击的是播放器/播放器外

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