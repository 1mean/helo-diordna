package com.example.pandas.ui.adapter

import android.animation.Animator
import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.pandas.R
import com.example.pandas.bean.LiveVideoData
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.AnimationListener
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.Item1AdapterLiveVideoBinding
import com.example.pandas.databinding.Item2AdapterLiveVideoBinding
import com.example.pandas.databinding.Item3AdapterLiveVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.activity.FollowAndFansActivity
import com.example.pandas.ui.adapter.decoration.LiveVisitorItemDecoration
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.ui.ext.setLikeAnimation
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startUserInfoActivity
import com.example.pandas.ui.view.dialog.LiveBottomSheetDialog
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.utils.TimeUtils

/**
 * @description: 动态-综合
 * @author: dongyiming
 * @date: 10/10/22 5:11 下午
 * @version: v1.0
 */
public class LiveVideoAdapter(
    private var data: LiveVideoData = LiveVideoData(),
    private val listener: LiveVideoListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(liveData: LiveVideoData) {
        this.data = liveData
        notifyDataSetChanged()
    }

    fun loadMore(liveData: LiveVideoData) {

        if (liveData.lives.isNotEmpty()) {
            val startIndex = data.lives.size + 1
            data.lives.addAll(liveData.lives)
            notifyItemRangeInserted(startIndex, liveData.lives.size)
        }
    }

    fun getItemData(position: Int): PetVideo = data.lives[position - 1]

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> 1
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
                val binding = Item2AdapterLiveVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HistoryViewHolder(binding)
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
                (holder as HistoryViewHolder).handle()
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
        return data.lives.size + 1
    }

    inner class VisitorViewHolder(binding: Item1AdapterLiveVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val recyclerView = binding.rvLiveVisitor
        val more = binding.llayoutLiveVisitor
        var mAdapter: LiveVisitorAdapter? = null

        fun handle() {
            val paddingSide =
                itemView.context.resources.getDimension(R.dimen.common_lh_16_dimens).toInt()
            val paddingMide =
                itemView.context.resources.getDimension(R.dimen.common_lh_12_dimens).toInt()

            if (mAdapter == null) {
                mAdapter = LiveVisitorAdapter(data.visitors)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, HORIZONTAL, false)
                    adapter = mAdapter
                    addItemDecoration(LiveVisitorItemDecoration(paddingSide, paddingMide))
                }
            } else {
                mAdapter = LiveVisitorAdapter(data.visitors)
                recyclerView.adapter = mAdapter
            }

            more.setOnClickListener {
                startAnyActivity(itemView.context, FollowAndFansActivity::class.java)
            }
        }
    }

    inner class HistoryViewHolder(binding: Item2AdapterLiveVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val recyclerView = binding.rvLiveHistory
        var mAdapter: LiveHistoryAdapter? = null

        fun handle() {

            val paddingSide =
                itemView.context.resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
            val paddingMide =
                itemView.context.resources.getDimension(R.dimen.common_lh_6_dimens).toInt()

            if (mAdapter == null) {
                mAdapter = LiveHistoryAdapter(data.follows)
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
        val title = binding.txtTitle
        val time = binding.txtLiveTime
        val userName = binding.txtUser
        val duration = binding.txtLiveItemDuration
        val bottomImg = binding.imgLiveItemBottom
        val commentView = binding.clayoutItem2
        val likeView = binding.clayoutItem3
        val likeImg = binding.imgLiveItemLike
        val likeTxt = binding.txtLiveItemLike
        val comments = binding.txtLiveItemComments
        val playshelter = binding.clayoutLiveShelter
        val player = binding.playerLive
        var moreView = binding.clayoutLiveMore
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

            val video = data.lives[position - 1]
            val user = video.user
            val videoData = video.videoData ?: VideoData(videoCode = video.code)

            user?.let {
                it.headUrl?.let { url ->
                    loadImage(context, url, userIcon)
                }
                userName.text = it.userName

                if (it.vip == 1) {
                    userName.setTextColor(ContextCompat.getColor(context, R.color.color_live_vip))
                } else {
                    userName.setTextColor(ContextCompat.getColor(context, R.color.color_live_name))
                }
            }

            loadCenterRoundedCornerImage(context, 20, video.cover, bottomImg)

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
                likeImg.setImageResource(R.mipmap.img_live_liked2)
            } else {
                likeImg.setImageResource(R.mipmap.img_live_like2)
            }

            if (videoData.likes == 0) {
                likeTxt.text = "点赞"
            } else {
                likeTxt.text = videoData.likes.toString()
            }

            if (videoData.comments == 0) {
                comments.text = "评论"
            } else {
                comments.text = videoData.comments.toString()
            }

            title.text = video.title
            if (video.description != null) {
                descripetion.text = video.description
            } else {
                descripetion.text = "${user?.userName}发布了视频"
            }
            duration.text = TimeUtils.getMMDuration(video.duration.toLong())


            time.text = TimeUtils.parseTime(video.releaseTime * 1000).toString()

            video.cover?.let {
                if (video.vertical) {//竖屏
                    Log.e("6mean", "111")
                    loadImage(context, it, cover)
                } else {
                    Log.e("6mean", "222")
                    loadCenterImage(context, it, cover)
                }
            }

            likeView.setOnClickListener {

                addScaleAnimation(likeImg, 1.4f)
                if (videoData.like) {
                    likeImg.setImageResource(R.mipmap.img_live_like2)
                    videoData.likes -= 1
                    if (videoData.likes > 0) {
                        likeTxt.text = videoData.likes.toString()
                    } else {
                        likeTxt.text = "点赞"
                    }
                    videoData.like = !videoData.like
                    listener.updateVideoData(videoData)
                } else {
                    setLikeAnimation(likeImg, object : AnimationListener {
                        override fun onAnimationEnd(animation: Animator?) {
                            videoData.likes += 1
                            if (videoData.likes > 0) {
                                likeTxt.text = videoData.likes.toString()
                            } else {
                                likeTxt.text = "点赞"
                            }
                            videoData.like = !videoData.like
                            listener.updateVideoData(videoData)
                        }
                    })
                    likeImg.setImageResource(R.mipmap.img_live_liked2)
                }
            }

            userName.setOnClickListener {
                user?.let {
                    startUserInfoActivity(context, it.userCode)
                }
            }

            userIcon.setOnClickListener {
                user?.let {
                    startUserInfoActivity(context, it.userCode)
                }
            }

            commentView.setOnClickListener {
                listener.startVideoCommentActivity(video)
            }

            itemView.setOnClickListener {
                listener.startVideoPLayActivity(video)
            }

            moreView.setOnClickListener {
                val dialog = LiveBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        when (t) {
                            1 -> {
                                listener.addLater(video.code)
                                mHandler.post {
                                    Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show()
                                }
                            }
                            2 -> {
                                if (dialog == null) {
                                    dialog =
                                        ShareBottomSheetDialog(
                                            context,
                                            object : ItemClickListener<String> {
                                                override fun onItemClick(t: String) {
                                                }
                                            })
                                    dialog!!.addData()
                                }
                                dialog!!.onShow()
                            }
                            3 -> {

                            }
                        }
                    }
                })
                dialog.onShow()
            }
        }
    }

    interface LiveVideoListener {
        fun updateVideoData(videoData: VideoData)

        fun startVideoPLayActivity(video: PetVideo)

        fun startVideoCommentActivity(video: PetVideo)

        fun addLater(videoCode: Int)
    }
}