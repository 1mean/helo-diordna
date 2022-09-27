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
import com.example.pandas.biz.interaction.PlayerDoubleTapListener
import com.example.pandas.databinding.AdapterVideoVerticalBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.ui.TimeBar

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

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(data: MutableList<PetVideo>) {
        if (data.isNotEmpty() && data != list) {
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
        val attention = binding.txtVerticalAttention
        val title = binding.txtVerticalTitle
        val input = binding.editVertical
        val likeItem = binding.llayoutVerticalLike
        val likeImg = binding.ibnVerticalLike
        val likes = binding.txtVerticalLike
        val commentItem = binding.llayoutVerticalComment
        val commentImg = binding.ibnVerticalComment
        val comments = binding.txtVerticalComment
        val collectItem = binding.llayoutVerticalCollect
        val collectImg = binding.ibnVerticalCollect
        val collects = binding.txtVerticalCollect
        val shareItem = binding.llayoutVerticalShare
        val shareImg = binding.ibnVerticalShare
        val shares = binding.txtVerticalShare
        val play = binding.imgVerticalPlay
        val playerView = binding.playerVertical
        val timebar = playerView.findViewById<DefaultTimeBar>(R.id.exo_progress)

        fun init() {
            play.visibility = View.GONE
            playerView.showController()
            timebar.setPlayedColor(
                ContextCompat.getColor(
                    context,
                    R.color.color_vertical_played
                )
            )
        }

        fun handle(position: Int) {
            val user = list[position].user
            val videoData = list[position].videoData

            user?.let {
                if (it.vip == 1) {
                    name.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_name_vip_vertical
                        )
                    )
                } else {
                    name.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_name_vip_vertical
                        )
                    )
                }
                name.text = it.userName
                loadCircleImage(context, it.headUrl!!, header)
            }

            if (videoData == null) {
                likes.text = "点赞"
                comments.text = "评论"
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

                if (it.comments == 0) {
                    comments.text = "评论"
                } else {
                    comments.text = it.comments.toString()
                }

                if (it.collects == 0) {
                    collects.text = "收藏"
                } else {
                    collects.text = it.comments.toString()
                }

                if (it.shares == 0) {
                    shares.text = "分享"
                } else {
                    shares.text = it.shares.toString()
                }
            }

            likeItem.setOnClickListener {

                val data = list[position]
                if (data.videoData == null) {
                    likeImg.setImageResource(R.mipmap.img_vertical_liked)
                    likes.text = "1"
                    val vd = VideoData(videoCode = data.code, like = true, likes = 1)
                    data.videoData = vd
                    listener.updataVideoData(vd)
                } else {
                    data.videoData?.let {
                        val likeCount:Int
                        if (it.like) {
                            likeImg.setImageResource(R.mipmap.img_vertical_like)
                            likeCount = it.likes - 1
                            if (likeCount > 0) {
                                likes.text = likeCount.toString()
                            } else {
                                likes.text = "点赞"
                            }
                        } else {
                            likeImg.setImageResource(R.mipmap.img_vertical_liked)
                            likeCount = it.likes + 1
                            likes.text = likeCount.toString()
                        }
                        it.like = !it.like
                        it.likes = likeCount
                    }
                    listener.updataVideoData(data.videoData!!)
                }
            }

            title.text = list[position].title

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
        }
    }

    interface VerticalVideoListener {

        fun onDoubleTap()

        fun onSingleTap()

        fun updataVideoData(videoData: VideoData)
    }
}