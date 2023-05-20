package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
import com.example.pandas.ui.ext.addItemAnimation
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.utils.TimeUtils
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.ui.TimeBar
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

    inner class MyViewHolder(binding: AdapterVideoVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val name = binding.txtVerticalName
        val header = binding.imgVerticalHead
        val time = binding.txtVerticalTime
        val title = binding.txtVerticalTitle
        val rightView = binding.layoutVerticalRight
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

        //val clear = binding.ibnVerticalEmpty
        //val reduce = binding.ibnVerticalReduce
        val playerView = binding.playerVertical
        val timebar = playerView.findViewById<DefaultTimeBar>(R.id.exo_progress)
        val music = binding.txtVerticalMusic

        fun init() {
            play.visibility = View.GONE
            playerView.showController()
            timebar.setPlayedColor(
                ContextCompat.getColor(
                    context,
                    R.color.color_vertical_played
                )
            )
            rightView.visibility = View.VISIBLE
            bottomView.visibility = View.VISIBLE
        }

        fun handle(position: Int) {
            val video = list[position]
            val user = video.user
            val videoData = video.videoData

            hideView = false

            time.text = TimeUtils.parseTime(video.releaseTime)
            title.text = video.title

            user?.let {
                name.text = "@" + it.userName
                loadCircleImage(context, it.headUrl!!, header)
                music.text = it.userName + "的作品原声" + "       " + it.userName + "的作品原声"
                music.run {
                    isSingleLine = true
                    isSelected = true
                    isFocusable = true
                    isFocusableInTouchMode = true
                }
            }

            if (videoData == null) {
                likes.text = "点赞"
                comments.text = "抢首评"
                collects.text = "收藏"
                shares.text = "分享"
            }


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
                    collectImg.setImageResource(R.mipmap.img_vertical_collected)
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
                    addScaleAnimation(collectImg)
                    collectImg.setImageResource(R.mipmap.img_vertical_collected)
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
                            addScaleAnimation(collectImg)
                            collectImg.setImageResource(R.mipmap.img_vertical_collected)
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

                val dialog = ShareBottomSheetDialog(context, object : ItemClickListener<String> {
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
                        timebar.setPlayedColor(
                            ContextCompat.getColor(
                                context,
                                R.color.color_vertical_played
                            )
                        )
                    } else {
                        play.visibility = View.VISIBLE
                        timebar.setPlayedColor(
                            ContextCompat.getColor(
                                context,
                                R.color.color_home_tab_text_selected
                            )
                        )
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

            timebar.addListener(object : TimeBar.OnScrubListener {
                override fun onScrubStart(timeBar: TimeBar, position: Long) {

                    (timeBar as DefaultTimeBar).setPlayedColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_home_tab_text_selected
                        )
                    )
                }

                override fun onScrubMove(timeBar: TimeBar, position: Long) {
                }

                override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                    (timeBar as DefaultTimeBar).setPlayedColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_vertical_played
                        )
                    )
                }
            })

            commentItem.setOnClickListener {
                val commentCounts = videoData?.comments ?: 0
                listener.showComments(video.code, commentCounts)
            }
        }

        fun handleItemLike(position: Int) {
            val data = list[position]
            if (data.videoData == null) {
                addItemAnimation(likeImg)
                likeImg.setImageResource(R.mipmap.img_vertical_liked)
                likes.text = "1"
                val vd = VideoData(videoCode = data.code, like = true, likes = 1)
                data.videoData = vd
                listener.updataVideoData(vd)
            } else {
                data.videoData?.let {
                    var likeCount: Int
                    if (!it.like) {
                        addItemAnimation(likeImg)
                        likeImg.setImageResource(R.mipmap.img_vertical_liked)
                        likeCount = it.likes + 1
                        likes.text = likeCount.toString()
                        it.likes = likeCount
                    } else {
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
    }
}