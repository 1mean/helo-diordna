package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.VideoComment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadHeadCircleImage
import com.example.pandas.databinding.ItemCommentsBinding
import com.example.pandas.databinding.ItemTopCommentsBinding
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.ui.ext.setTextType
import com.example.pandas.utils.TimeUtils

/**
 * @description: 视频评论页面
 * @author: dongyiming
 * @date: 5/28/22 3:02 上午
 * @version: v1.0
 */
public class CommentAdapter(
    private val list: MutableList<VideoComment>,
    private val listener: OnCommentClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_TOP = 1
    private val TYPE_ITEM = 2
    private var orderMode = 0//默认按点赞数热度排列

    override fun getItemViewType(position: Int): Int = if (position == 0) TYPE_TOP else TYPE_ITEM

    override fun getItemCount(): Int = if (list.isEmpty()) {
        0
    } else {
        list.size + 1
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(isRefresh: Boolean, data: MutableList<VideoComment>) {

        if (isRefresh) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        } else {
            list.addAll(data)
            notifyItemRangeInserted(list.size + 1, data.size + 1)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun sendComment(comment: VideoComment) {
        Log.e("1mean", "comment: $comment")
        list.add(0, comment)
        notifyDataSetChanged()
    }

    inner class TopHolder(binding: ItemTopCommentsBinding) : RecyclerView.ViewHolder(binding.root) {

        val settingLayout = binding.llayoutCommentSetting
        val settingText = binding.txtCommentSetting

        fun handle() {
            settingLayout.setOnClickListener {
                listener.orderClcik(orderMode)
            }
        }

        fun updateName() {
            if (orderMode == 0) {
                settingText.text = itemView.context.getString(R.string.str_by_hot)
                orderMode = 1
            } else {
                settingText.text = itemView.context.getString(R.string.str_by_time)
                orderMode = 0
            }
        }
    }

    inner class CommentHolder(binding: ItemCommentsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val header = binding.imgCommentItemHead
        val name = binding.txtCommentItemName
        val level = binding.imgCommentItemLevel
        val content = binding.txtCommentItemContent
        val likeLayout = binding.llayoutCommentItemLike
        val likes = binding.txtCommentItemLikes
        val likeImg = binding.imgCommentItemLike
        val unLikeImg = binding.imgCommentUnlike
        val more = binding.clayoutCommentItemMore
        val unLikeView = binding.clayoutCommentItemDislike
        val shareView = binding.clayoutCommentItemShare
        val commentSendView = binding.clayoutCommentItemComment
        val date = binding.txtCommentItemDate
        val upLikeView = binding.clayoutCommentUplike

        fun handle(position: Int) {

            val videoComment = list[position - 1]

            videoComment.user?.let {
                loadHeadCircleImage(context, it.headUrl!!, header)
                setLevelImageResourse(it.level, level)
                if (it.isVip == 1) {
                    name.setTextColor(ContextCompat.getColor(context, R.color.color_name_vip))
                    setTextType(true, name)
                } else {
                    setTextType(false, name)
                    name.setTextColor(ContextCompat.getColor(context, R.color.color_comment_name))
                }
                name.text = it.userName
            }

            content.setContent("林清", videoComment.content, 0)
//            content.text = videoComment.content
            date.text = TimeUtils.parseTime(videoComment.commitTime)

            viewInit(videoComment)
            onClick(videoComment)

        }

        private fun viewInit(videoComment: VideoComment) {

            if (videoComment.likeNum > 0) {
                likes.visibility = View.VISIBLE
                likes.text = videoComment.likeNum.toString()
            } else {
                likes.visibility = View.GONE
            }

            if (videoComment.isLike) {
                likeImg.setImageResource(R.mipmap.img_comment_liked)
                unLikeImg.setImageResource(R.mipmap.img_comment_dislike)
            } else {
                likeImg.setImageResource(R.mipmap.img_comment_like)
            }

            if (videoComment.isUnLike) {
                likeImg.setImageResource(R.mipmap.img_comment_like)
                unLikeImg.setImageResource(R.mipmap.img_comment_disliked)
            } else {
                unLikeImg.setImageResource(R.mipmap.img_comment_dislike)
            }

            if (videoComment.isUpLike) {
                upLikeView.visibility = View.VISIBLE
            } else {
                upLikeView.visibility = View.GONE
            }
        }

        private fun onClick(videoComment: VideoComment) {
            likeLayout.setOnClickListener {
                if (videoComment.isLike) {
                    likeImg.setImageResource(R.mipmap.img_comment_like)
                    val num = videoComment.likeNum - 1
                    if (num == 0) {
                        likes.visibility = View.GONE
                    } else {
                        likes.visibility = View.VISIBLE
                        likes.text = num.toString()
                    }
                    videoComment.likeNum = num
                } else {
                    likes.visibility = View.VISIBLE
                    val num = videoComment.likeNum + 1
                    likes.text = num.toString()
                    likeImg.setImageResource(R.mipmap.img_comment_liked)
                    if (videoComment.isUnLike) {
                        unLikeImg.setImageResource(R.mipmap.img_comment_dislike)
                        videoComment.isUnLike = false
                    }
                    videoComment.likeNum = num
                }
                videoComment.isLike = !videoComment.isLike
            }
            unLikeView.setOnClickListener {
                if (videoComment.isUnLike) {
                    unLikeImg.setImageResource(R.mipmap.img_comment_dislike)
                } else {
                    unLikeImg.setImageResource(R.mipmap.img_comment_disliked)
                    if (videoComment.isLike) {
                        likeImg.setImageResource(R.mipmap.img_comment_like)
                        val num = videoComment.likeNum - 1
                        if (num == 0) {
                            likes.visibility = View.GONE
                        } else {
                            likes.visibility = View.VISIBLE
                            likes.text = num.toString()
                        }
                        videoComment.likeNum = num
                        videoComment.isLike = false
                    }
                }
                videoComment.isUnLike = !videoComment.isUnLike
            }
            shareView.setOnClickListener {
                Toast.makeText(context, "待开发", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface OnCommentClickListener {
        fun orderClcik(orderMode: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_TOP) {
            val holder =
                ItemTopCommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TopHolder(holder)
        } else {
            val holder =
                ItemCommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CommentHolder(holder)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_TOP) {
            (holder as TopHolder).handle()
        } else {
            (holder as CommentHolder).handle(position)
        }
    }
}