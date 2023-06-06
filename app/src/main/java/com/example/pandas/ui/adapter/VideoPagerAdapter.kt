package com.example.pandas.ui.adapter

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.databinding.AdapterVideoVerticalBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.ext.addShortEndAnimation
import com.example.pandas.ui.ext.addShortStartAnimation
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.utils.TimeUtils
import java.util.*

/**
 * @description: VideoPagerAdapter
 * @author: dongyiming
 * @date: 9/19/22 7:27 下午
 * @version: v1.0
 */
public class VideoPagerAdapter(
    private val list: MutableList<PetVideo> = mutableListOf(),
    private val listener: VerticalVideoListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var recyclerView: RecyclerView? = null
    var hideView: Boolean = false

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            AdapterVideoVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    /**
     * 方法为什么不写在viewHolder里，因为viewholder的预加载导致position不对
     *  handle(position)执行
     *  第一次加载0 1
     *  第二次加载2
     *  第三次加载3
     *
     */
    private var animationList: MutableMap<Int, ObjectAnimator> = mutableMapOf()
    fun startAnimation(position: Int) {

        val animatom = animationList.get(position)
        if (animatom == null) {
            val vh = recyclerView?.findViewHolderForAdapterPosition(position)
            vh?.let {
                if (it is MyViewHolder) {
                    val music = (it as MyViewHolder).musicImg
                    val transRotation = ObjectAnimator.ofFloat(music, "rotation", 0f, 360f)
                    transRotation.interpolator = LinearInterpolator()
                    transRotation.repeatCount = -1 //动画永不停止
                    transRotation.duration = 7000
                    transRotation.start()
                    list[position].booleanFlag = true
                    animationList[position] = transRotation
                }
            }
        } else {
            if (animatom.isPaused) {
                animatom.resume()
            } else {
                animatom.start()
            }
        }
    }

    //通过获取musicImg(同一个对象)，通过clearAnimation()/animation.cancel()方法都无效，只能通过transRotation对象
    fun pauseAnimation(position: Int) {
        val transRotation = animationList.get(position)
        if (transRotation != null && transRotation.isRunning) {
            transRotation.pause()
        }
    }

    fun clearAnimation() {
        if (animationList.isNotEmpty()) {
            animationList.values.forEach {
                it.cancel()
            }
        }
    }

    inner class MyViewHolder(binding: AdapterVideoVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val name = binding.txtVerticalName
        val header = binding.imgVerticalHead
        val time = binding.txtVerticalTime
        val title = binding.txtVerticalTitle

        //val rightView = binding.layoutVerticalRight
        val rightView = binding.clayoutShortRight
        val bottomView = binding.clayoutVerticalVideoInfo
        val likeItem = binding.llayoutVerticalLike
        val likeImg = binding.ibnVerticalLike
        val likes = binding.txtVerticalLike
        val commentItem = binding.llayoutVerticalComment
        val comments = binding.txtVerticalComment
        val collectItem = binding.llayoutVerticalCollect
        val collectImg = binding.ibnVerticalCollect
        val collects = binding.txtVerticalCollect
        val shareItem = binding.llayoutVerticalShare
        val shareImg = binding.ibnVerticalShare
        val shares = binding.txtVerticalShare
        val play = binding.imgVerticalPlay
        val musicImg = binding.imgVerticalMusic
        val attentionView = binding.btnVerticalAttention

        //val clear = binding.ibnVerticalEmpty
        //val reduce = binding.ibnVerticalReduce
        val playerView = binding.playerVertical
        //val timebar = playerView.findViewById<DefaultTimeBar>(R.id.exo_progress)
        //val music = binding.txtVerticalMusic

        /**
         * 弹窗被拖拽时执行，适用于能拖拽的弹窗，比如Bottom弹窗和Drawer弹窗
         * @param value  拖拽的距离
         * @param percent  拖拽的百分比
         * @param upOrLeft 是否是向上或者向左；垂直拖拽时，true表示向上，false表现向下；
         *                 水平拖拽时，true表示向左，false表示向右
         */

        val lastWidthPercent = 0.5
        val lastHeightPercent = 0.4053
        var lastPercent = 0f
        fun playerChanged(value: Int, percent: Float, upOrLeft: Boolean) {

            //bug:经常出现两次偏移的value值相同回调，会导致通过位移来判断上还是下的upOrLeft出现问题，
            // 导致在一系列up中出现几次down，导致屏幕抖动，所以相同数值的结果规避掉
            if (lastPercent == percent) {
                return
            }
            lastPercent = percent

            if (percent == 0f) {
                rightView.visibility = View.VISIBLE
                bottomView.visibility = View.VISIBLE
            }

            val params = playerView.layoutParams
            val with = 1080 * (1 - lastWidthPercent * percent)
            val height = 2226 * (1 - lastHeightPercent * percent)
//            val height = 2125 * (1 - lastHeightPercent * percent)
            Log.e("lidandan", "value : $value , percent: $percent, with=$with")
            params.width = with.toInt()
            params.height = height.toInt()
            playerView.layoutParams = params


            if (upOrLeft) {//向上或者向左
                rightView.visibility = View.GONE
                bottomView.visibility = View.GONE

                //statusbar = 101 pHeight=2226
                //val scaleY = 835 / 2125.0


                //playerView.scrollY = 1400 * percent.toInt()


                //playerView.offsetTopAndBottom(2)

//                val transScaleX = ObjectAnimator.ofFloat(playerView, "scaleX", 1f, 0.5f)
//                val transScaleY = ObjectAnimator.ofFloat(playerView, "scaleY", 1f, scaleY.toFloat())
//                //偏移坐标是不包含状态栏高度的，即从状态栏以下开始计算，状态栏高度101
//                val translationY = ObjectAnimator.ofFloat(playerView, "translationY", 0f,-730f)
//                val animationSet = AnimatorSet()
//                animationSet.duration = 400
//                animationSet.interpolator = DecelerateInterpolator()
//                animationSet.play(transScaleX).with(transScaleY).with(translationY)
//                animationSet.start()


                //1390f
//                playerView.animate().translationX(200f).translationY(0f)
//                    .setListener(object : AnimatorListener {
//                        override fun onAnimationStart(animation: Animator?) {
//
//                        }
//
//                        override fun onAnimationEnd(animation: Animator?) {
//                            val params = playerView.layoutParams
//                            params.height = 834
//                            //params.width = (834 / 2226) * 1080
//                            params.width = 454
//                            playerView.layoutParams = params
//
//                        }
//
//                        override fun onAnimationCancel(animation: Animator?) {
//                        }
//
//                        override fun onAnimationRepeat(animation: Animator?) {
//                        }
//                    }).setDuration(300).start()
            } else {//向下或向右

//                rightView.visibility = View.VISIBLE
//                bottomView.visibility = View.VISIBLE
            }
        }

        fun init() {
            play.visibility = View.GONE
            playerView.showController()
//            timebar.setPlayedColor(
//                ContextCompat.getColor(
//                    context,
//                    R.color.color_vertical_played
//                )
//            )
            rightView.visibility = View.VISIBLE
            bottomView.visibility = View.VISIBLE
        }

        fun handle(position: Int) {
            val video = list[position]
            val user = video.user
            val videoData = video.videoData

            hideView = false

            time.text = TimeUtils.getStringDate2(video.releaseTime * 1000)
            title.text = video.title

            user?.let {
                name.text = "@" + it.userName
                loadCircleImage(context, it.headUrl!!, header)
                loadCircleImage(context, it.headUrl!!, musicImg)

                if (it.attention) {
                    attentionView.visibility = View.GONE
                } else {
                    attentionView.setBackgroundResource(R.drawable.shape_bg_vertical_attention)
                    attentionView.setImageResource(R.mipmap.img_vertical_attention_add)
                    attentionView.visibility = View.VISIBLE
                }
            }

            if (videoData == null) {
                likes.text = "点赞"
                comments.text = "抢首评"
                collects.text = "收藏"
                shares.text = "分享"
            }

            //listener.startMusicAnimation(musicImg)

            videoData?.let {

                if (it.like) {
                    likeImg.setImageResource(R.mipmap.img_vertical_liked)
                } else {
                    likeImg.setImageResource(R.mipmap.img_vertical_like)
                }

                if (it.likes == 0) {
                    likes.text = "点赞"
                } else {
                    likes.text = it.likes.toString()
                }

                if (it.collect) {
                    collectImg.setImageResource(R.mipmap.img_vertical_collected1)
                } else {
                    collectImg.setImageResource(R.mipmap.img_vertical_collect)
                }

                if (it.comments == 0) {
                    comments.text = "抢首评"
                } else {
                    comments.text = it.comments.toString()
                }

                if (it.collects == 0) {
                    collects.text = "收藏"
                } else {
                    collects.text = it.collects.toString()
                }

                if (it.shares == 0) {
                    shares.text = "分享"
                } else {
                    shares.text = it.shares.toString()
                }
            }

            likeItem.setOnClickListener {
                handleItemLike(position)
            }

            collectItem.setOnClickListener {
                val data = list[position]
                if (data.videoData == null) {
                    addShortStartAnimation(collectImg)
                    collectImg.setImageResource(R.mipmap.img_vertical_collected1)
                    collects.text = "1"
                    val vd = VideoData(
                        videoCode = data.code,
                        collect = true,
                        collects = 1,
                        collectTime = System.currentTimeMillis()
                    )
                    data.videoData = vd
                    listener.updataVideoData(vd)
                    listener.collect(true, data.code)
                } else {
                    data.videoData?.let { vd ->
                        if (vd.collect) {
                            addShortEndAnimation(collectImg)
                            collectImg.setImageResource(R.mipmap.img_vertical_collect)
                            var collectCount = vd.collects - 1
                            if (collectCount > 0) {
                                collects.text = collectCount.toString()
                            } else {
                                collects.text = "收藏"
                                collectCount = 0
                            }
                            vd.collects = collectCount
                            listener.collect(false, data.code)
                        } else {
                            addShortStartAnimation(collectImg)
                            collectImg.setImageResource(R.mipmap.img_vertical_collected1)
                            val collectCount = vd.collects + 1
                            collects.text = collectCount.toString()
                            vd.collectTime = System.currentTimeMillis()
                            vd.collects = collectCount
                            listener.collect(true, data.code)
                        }
                        vd.collect = !vd.collect
                        listener.updataVideoData(vd)
                    }
                }
            }

            shareItem.setOnClickListener {

                val dialog =
                    ShareBottomSheetDialog(context, object : ItemClickListener<String> {
                        override fun onItemClick(t: String) {
                        }
                    })
                dialog.addData().onShow()
            }

            header.setOnClickListener {
                user?.let {
                    listener.startUserActivity(it)
                }
            }
            name.setOnClickListener {
                user?.let {
                    listener.startUserActivity(it)
                }
            }

            playerView.controller(object : PlayerDoubleTapListener {

                override fun onSingleTapConfirmed() {
                    listener.onSingleTap()
                    if (play.isVisible) {
                        play.visibility = View.GONE
//                        timebar.setPlayedColor(
//                            ContextCompat.getColor(
//                                context,
//                                R.color.color_vertical_played
//                            )
//                        )
                    } else {
                        play.visibility = View.VISIBLE
//                        timebar.setPlayedColor(
//                            ContextCompat.getColor(
//                                context,
//                                R.color.color_home_tab_text_selected
//                            )
//                        )
                    }
                }

                override fun onDoubleTap() {
                    listener.onDoubleTap()
                    list[position].videoData?.let {
                        if (it.like) {
                            return
                        }
                    }
                    handleItemLike(position)
                }


            })

//            timebar.addListener(object : TimeBar.OnScrubListener {
//                override fun onScrubStart(timeBar: TimeBar, position: Long) {
//
//                    (timeBar as DefaultTimeBar).setPlayedColor(
//                        ContextCompat.getColor(
//                            context,
//                            R.color.color_home_tab_text_selected
//                        )
//                    )
//                }
//
//                override fun onScrubMove(timeBar: TimeBar, position: Long) {
//                }
//
//                override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
//                    (timeBar as DefaultTimeBar).setPlayedColor(
//                        ContextCompat.getColor(
//                            context,
//                            R.color.color_vertical_played
//                        )
//                    )
//                }
//            })

            commentItem.setOnClickListener {
                val commentCounts = videoData?.comments ?: 0
                listener.showComments(video.code, commentCounts)
            }

            attentionView.setOnClickListener {

                val alphaAnimation = ObjectAnimator.ofFloat(attentionView, "alpha", 1f, 0f)
                alphaAnimation.duration = 200
                alphaAnimation.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {

                        attentionView.setBackgroundResource(R.drawable.shape_bg_vertical_attentioned)
                        attentionView.setImageResource(R.mipmap.img_short_attentioned)

                        val alphaAnimation1 =
                            ObjectAnimator.ofFloat(attentionView, "alpha", 0f, 1f)
                        val transScaleX =
                            ObjectAnimator.ofFloat(attentionView, "scaleX", 0f, 1.3f, 1f)
                        val transScaleY =
                            ObjectAnimator.ofFloat(attentionView, "scaleY", 0f, 1.3f, 1f)

                        val animatorSet = AnimatorSet()
                        animatorSet.play(alphaAnimation1).with(transScaleX).with(transScaleY)
                        animatorSet.duration = 500
                        animatorSet.start()

                        val alphaAnimation2 =
                            ObjectAnimator.ofFloat(attentionView, "alpha", 1f, 0f)
                        alphaAnimation2.duration = 200
                        alphaAnimation2.startDelay = 2000
                        alphaAnimation2.start()

                        alphaAnimation2.addListener(object : Animator.AnimatorListener {
                            override fun onAnimationStart(animation: Animator?) {
                            }

                            override fun onAnimationEnd(animation: Animator?) {
                                attentionView.visibility = View.GONE
                            }

                            override fun onAnimationCancel(animation: Animator?) {
                            }

                            override fun onAnimationRepeat(animation: Animator?) {
                            }
                        })
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationRepeat(animation: Animator?) {
                    }
                })
                alphaAnimation.start()

                user?.let {
                    it.attention = true
                    listener.addAttention(it.userCode)
                }
            }
        }

        fun handleItemLike(position: Int) {
            val data = list[position]
            if (data.videoData == null) {
                addShortStartAnimation(likeImg)
                likeImg.setImageResource(R.mipmap.img_vertical_liked)
                likes.text = "1"
                val vd = VideoData(videoCode = data.code, like = true, likes = 1)
                data.videoData = vd
                listener.updataVideoData(vd)
            } else {
                data.videoData?.let {
                    var likeCount: Int
                    if (!it.like) {
                        addShortStartAnimation(likeImg)
                        likeImg.setImageResource(R.mipmap.img_vertical_liked)
                        likeCount = it.likes + 1
                        likes.text = likeCount.toString()
                        it.likes = likeCount
                    } else {
                        addShortEndAnimation(likeImg)
                        likeImg.setImageResource(R.mipmap.img_vertical_like)
                        likeCount = it.likes - 1
                        if (likeCount > 0) {
                            likes.text = likeCount.toString()
                        } else {
                            likeCount = 0
                            likes.text = "点赞"
                        }
                    }
                    it.likes = likeCount
                    it.like = !it.like
                    listener.updataVideoData(data.videoData!!)
                }
            }
        }
    }

    interface VerticalVideoListener {

        fun onDoubleTap()

        fun onSingleTap()

        fun updataVideoData(videoData: VideoData)

        fun collect(isAdd: Boolean, videoCode: Int)

        fun updateUserAttention(userCode: Int)

        fun startUserActivity(user: User)

        fun showComments(videoCode: Int, commentCounts: Int)

        fun addAttention(userCode: Int)
    }
}