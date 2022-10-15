package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.pandas.R
import com.example.pandas.bean.LiveVideoData
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.Item1AdapterLiveVideoBinding
import com.example.pandas.databinding.Item3AdapterLiveVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.adapter.decoration.LiveVisitorItemDecoration
import com.example.pandas.ui.ext.setAnimation
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.utils.TimeUtils

/**
 * @description: 动态-视频
 * @author: dongyiming
 * @date: 10/10/22 5:11 下午
 * @version: v1.0
 */
public class LiveVideoAdapter(
    private var data: LiveVideoData = LiveVideoData(),
    private val listener: LiveVideoListener
) :
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

    fun getItemData(position: Int): PetVideo = data.lives[position - 2]

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

    override fun getItemCount(): Int {

        if (data.visitors.isEmpty()) {
            return 0
        }
        return data.lives.size + 2
    }

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
        val playshelter = binding.clayoutLiveShelter
        val player = binding.playerLive
        var tagView = binding.llayoutLiveTag
        var dialog: ShareBottomSheetDialog? = null

        fun updateItemView(hidePlayer: Boolean) {
            if (hidePlayer) {
                playshelter.visibility = View.VISIBLE
            } else {
                playshelter.visibility = View.GONE
                player.showController()
            }
        }

        fun handle(position: Int) {

            val video = data.lives[position - 2]
            val user = video.user
            val videoData = video.videoData ?: VideoData(videoCode = video.code)

            if (video.vertical) {
                tagView.visibility = View.VISIBLE
            } else {
                tagView.visibility = View.GONE
            }

            user?.let {
                it.headUrl?.let { url ->
                    loadCircleImage(context, url, userIcon)
                }
                userName.text = it.userName

                if (it.vip == 1) {
                    userName.setTextColor(ContextCompat.getColor(context, R.color.color_live_vip))
                } else {
                    userName.setTextColor(ContextCompat.getColor(context, R.color.color_live_name))
                }
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

            if (videoData.like) {
                likeImg.setImageResource(R.mipmap.img_eye_item_liked)
            } else {
                likeImg.setImageResource(R.mipmap.img_eye_item_like)
            }

            if (videoData.likes == 0) {
                likeTxt.text = "点赞"
            } else {
                likeTxt.text = videoData.likes.toString()
            }

            if (videoData.comments == 0) {
                likeTxt.text = "评论"
            } else {
                comments.text = videoData.comments.toString()
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

            shareView.setOnClickListener {
                if (dialog == null) {
                    dialog =
                        ShareBottomSheetDialog(context, object : ItemClickListener<String> {
                            override fun onItemClick(t: String) {
                            }
                        })
                    dialog!!.addData()
                }
                dialog!!.onShow()
            }

            likeView.setOnClickListener {

                if (videoData.like) {
                    likeImg.setImageResource(R.mipmap.img_eye_item_like)
                    videoData.likes -= 1
                } else {
                    setAnimation(likeImg)
                    likeImg.setImageResource(R.mipmap.img_eye_item_liked)
                    videoData.likes += 1
                }
                if (videoData.likes > 0) {
                    likeTxt.text = videoData.likes.toString()
                } else {
                    likeTxt.text = "点赞"
                }
                videoData.like = !videoData.like
                listener.updateVideoData(videoData)
            }
        }
    }

    interface LiveVideoListener {
        fun updateVideoData(videoData: VideoData)
    }
}