package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.base.utils.NumUtils
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadEmptyCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.ItemVideoEyeBinding
import com.example.pandas.ui.activity.EyePlayingActivity

/**
 * @description: EyepetozerAdapter
 * @author: dongyiming
 * @date: 2021/12/23 10:28 上午
 * @version: v1.0
 */
public class EyepetozerAdapter(
    private var list: MutableList<PetVideo>,
    private val listener: EyeAdapterListener
) :
    Adapter<ViewHolder>() {

    fun getItemData(position: Int): PetVideo {
        return list[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(data: MutableList<PetVideo>) {
        list.clear()
        this.list = data
        notifyDataSetChanged()
    }

    fun loadMore(data: MutableList<PetVideo>) {

        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size, data.size)
        }
    }

//    fun updateItemView(position: Int, isPlaying: Boolean, holder: ViewHolder?) {
//
//        holder?.let {
//
//            val hd = holder as BaseViewHolder
//            val playshelter = hd.getWidget<ConstraintLayout>(R.id.clayout_eye_item)
//            val cover = hd.getWidget<AppCompatImageView>(R.id.img_video)
//            val player = hd.getWidget<StyledPlayerView>(R.id.player_eye)
//            if (isPlaying) {
//                playshelter.visibility = View.GONE
//                cover.visibility = View.GONE
//                player.showController()
//            } else {
//                playshelter.visibility = View.VISIBLE
//                cover.visibility = View.VISIBLE
//            }
//            val data = list[position]
//            data.isPlaying = isPlaying
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVideoEyeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EyeViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as EyeViewHolder).handle(position)
    }

    inner class EyeViewHolder(binding: ItemVideoEyeBinding) : ViewHolder(binding.root) {

        val cover = binding.imgVideo
        val userIcon = binding.imgUser
        val descripetion = binding.txtDescripetion
        val time = binding.txtEyeTime
        val userName = binding.txtUser
        val duration = binding.txtEyeItemDuration
        val shareView = binding.llayoutEyeItemShare
        val commentView = binding.llayoutEyeItemComments
        val likeView = binding.llayoutEyeItemLike
        val comments = binding.txtEyeItemComments
        val playshelter = binding.clayoutEyeItem
        val likeImg = binding.imgEyeItemLike
        val likeTxt = binding.txtEyeItemLike
        val playImg = binding.imgEyeItemPlay
        val player = binding.playerEye
        val context = itemView.context

        fun updateItemView(hidePlayer: Boolean) {
            if (hidePlayer) {
                playshelter.visibility = View.VISIBLE
                cover.visibility = View.VISIBLE
            } else {
                playshelter.visibility = View.GONE
                cover.visibility = View.GONE
                player.showController()
            }
        }

        fun handle(position: Int) {

            val data = list[position]
            if (data.booleanFlag) {
                //player.visibility = View.VISIBLE
                playshelter.visibility = View.GONE
                cover.visibility = View.GONE
            } else {
                //player.visibility = View.GONE
                playshelter.visibility = View.VISIBLE
                cover.visibility = View.VISIBLE
            }


            val user = data.user
            val vd = data.videoData

            vd?.let { videoData ->
                if (videoData.like) {
                    likeImg.setImageResource(R.mipmap.img_eye_item_liked)
                } else {
                    likeImg.setImageResource(R.mipmap.img_eye_item_like)
                }
            }

            descripetion.text = data.title
            duration.text = TimeUtils.getMMDuration(data.duration.toLong())

            data.cover?.let {
                loadImage(context, it, cover)
            }

            if (user == null) {
                loadEmptyCircleImage(context, userIcon)
                userName.text = "开眼视频"
                val cTime = TimeUtils.getMdTime(System.currentTimeMillis())
                time.text = StringBuilder(cTime).append(" · 投稿了视频").toString()
            } else {
                user.let {
                    it.headUrl?.let { url ->
                        loadCircleImage(context, url, userIcon)
                    }
                    userName.text = it.userName
                }
            }

            val cTime = TimeUtils.getMdTime(data.releaseTime)
            time.text = StringBuilder(cTime).append(" · 投稿了视频").toString()

            vd?.let { videoData ->

                if (videoData.collects == 0) {
                    likeTxt.text = "赞"
                } else {
                    likeTxt.text = NumUtils.getShortNum(videoData.collects)
                }
                comments.text = NumUtils.getShortNum(videoData.comments)
            }

            itemView.setOnClickListener {
                listener.startVideoPLayActivity(data)
            }

            shareView.setOnClickListener {

            }

            commentView.setOnClickListener {
                listener.startVideoCommentActivity(data)
            }

            likeView.setOnClickListener {

                vd?.let { videoData ->
                    if (videoData.like) {
                        videoData.like = false
                        videoData.collects -= 1
                        if (videoData.collects == 0) {
                            likeTxt.text = "赞"
                        } else {
                            likeTxt.text = NumUtils.getShortNum(videoData.collects)
                        }
                        likeImg.setImageResource(R.mipmap.img_eye_item_like)
                    } else {
                        videoData.like = true
                        videoData.collects += 1
                        likeTxt.text = NumUtils.getShortNum(videoData.collects)
                        likeImg.setImageResource(R.mipmap.img_eye_item_liked)
                    }
                }
            }
        }
    }

    interface EyeAdapterListener {

        fun startVideoPLayActivity(eyepetozerItem: PetVideo)

        fun startVideoCommentActivity(eyepetozerItem: PetVideo)

        fun addLater(videoCode: Int)
    }
}