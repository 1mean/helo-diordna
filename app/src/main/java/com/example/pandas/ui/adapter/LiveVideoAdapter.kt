package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.pandas.R
import com.example.pandas.bean.LiveVideoData
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.Item1AdapterLiveVideoBinding
import com.example.pandas.databinding.Item3AdapterLiveVideoBinding
import com.example.pandas.ui.adapter.decoration.LiveVisitorItemDecoration
import com.example.pandas.utils.TimeUtils

/**
 * @description: 动态-视频
 * @author: dongyiming
 * @date: 10/10/22 5:11 下午
 * @version: v1.0
 */
public class LiveVideoAdapter(private var data: LiveVideoData = LiveVideoData()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(liveData: LiveVideoData) {
        this.data = liveData
        notifyDataSetChanged()
    }

    fun loadMore(liveData: LiveVideoData) {

        if (liveData.lives.isNotEmpty()) {

            val startIndex = data.lives.size + 2
            data.lives.addAll(liveData.lives)
            notifyItemRangeInserted(startIndex, liveData.lives.size)
        }
    }

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> 1
        1 -> 2
        else -> 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            1 -> {
                val binding = Item1AdapterLiveVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return VisitorViewHolder(binding)
            }
            2 -> {
                val binding = Item1AdapterLiveVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return VisitorViewHolder(binding)
            }
            else -> {
                val binding = Item3AdapterLiveVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return LiveViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            1 -> {
                (holder as VisitorViewHolder).handle()
            }
            2 -> {
                (holder as VisitorViewHolder).handle()
            }
            else -> {
                (holder as LiveViewHolder).handle(position)
            }
        }
    }

    override fun getItemCount(): Int = data.lives.size + 2

    inner class VisitorViewHolder(binding: Item1AdapterLiveVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val recyclerView = binding.rvLiveVisitor
        var mAdapter: LiveVisitorAdapter? = null

        fun handle() {
            val paddingSide =
                itemView.context.resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
            val paddingMide =
                itemView.context.resources.getDimension(R.dimen.common_lh_14_dimens).toInt()

            if (mAdapter == null) {
                mAdapter = LiveVisitorAdapter(data.visitors)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, HORIZONTAL, false)
                    adapter = mAdapter
                    addItemDecoration(LiveVisitorItemDecoration(paddingSide, paddingMide))
                }
            }
        }
    }

    inner class LiveViewHolder(binding: Item3AdapterLiveVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val cover = binding.imgVideo
        val userIcon = binding.imgUser
        val descripetion = binding.txtDescripetion
        val time = binding.txtLiveTime
        val userName = binding.txtUser
        val duration = binding.txtLiveItemDuration
        val shareView = binding.llayoutLiveItemShare
        val commentView = binding.llayoutLiveItemComments
        val likeView = binding.llayoutLiveItemLike
        val likeImg = binding.imgLiveItemLike
        val likeTxt = binding.txtLiveItemLike
        val comments = binding.txtLiveItemComments
        val playImg = binding.imgLiveItemPlay
        val playshelter = binding.clayoutLiveItem
        val player = binding.playerLive

        fun handle(position: Int) {

            val video = data.lives[position - 2]
            val user = video.user
            val videoData = video.videoData

            user?.let {
                it.headUrl?.let { url ->
                    loadCircleImage(context, url, userIcon)
                }
                userName.text = it.userName
            }

            if (video.booleanFlag) {
                //player.visibility = View.VISIBLE
                playshelter.visibility = View.GONE
                cover.visibility = View.GONE
            } else {
                //player.visibility = View.GONE
                playshelter.visibility = View.VISIBLE
                cover.visibility = View.VISIBLE
            }

            if (videoData != null && videoData.like) {
                likeImg.setImageResource(R.mipmap.img_eye_item_liked)
            } else {
                likeImg.setImageResource(R.mipmap.img_eye_item_like)
            }

            if (videoData != null) {
                comments.text = videoData.comments.toString()
                likeTxt.text = videoData.likes.toString()
            } else {
                comments.text = "评论"
                likeTxt.text = "点赞"
            }

            descripetion.text = video.title
            duration.text = TimeUtils.getMMDuration(video.duration.toLong())
            video.releaseTime?.let {
                val fTime = TimeUtils.formatTime(it)
                val r_time = TimeUtils.parseTime(fTime)
                time.text = StringBuilder(r_time).append(" · 投稿了视频").toString()
            }

            video.cover?.let {
                loadImage(context, it, cover)
            }
        }
    }
}