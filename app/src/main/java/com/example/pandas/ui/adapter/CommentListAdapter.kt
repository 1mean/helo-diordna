package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.bean.ReplyInfo
import com.example.pandas.biz.ext.loadHeadCircleImage
import com.example.pandas.biz.ext.startUserInfoActivity
import com.example.pandas.biz.interaction.SpanClickListener
import com.example.pandas.databinding.ItemAdapterCommentTitleBinding
import com.example.pandas.databinding.ItemCommentsBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.ui.ext.setTextType
import com.example.pandas.utils.SpannableStringUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: CommentListAdapter
 * @author: dongyiming
 * @date: 6/9/22 5:02 下午
 * @version: v1.0
 */
public class CommentListAdapter(
    private val list: MutableList<CommentAndUser>,
    private val listener: ItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun getItemPisition(position: Int): CommentAndUser = list[position]

    override fun getItemCount(): Int = if (list.isEmpty()) 0 else list.size + 1

    override fun getItemViewType(position: Int): Int = if (position == 1) 2 else 1

    @SuppressLint("NotifyDataSetChanged")
    fun addComment(comment: CommentAndUser) {

        list.add(1, comment)
        notifyItemInserted(2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == 1) {
            val holder =
                ItemCommentsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            CommentHolder(holder)
        } else {
            val holder =
                ItemAdapterCommentTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            TopHolder(holder)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == 1) {
            (holder as CommentHolder).handle(position)
        } else {
            (holder as TopHolder).handle()
        }
    }

    inner class TopHolder(binding: ItemAdapterCommentTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val settingLayout = binding.txtCommentTitle
        fun handle() {

        }
    }

    inner class CommentHolder(binding: ItemCommentsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context: Context = itemView.context
        private val header = binding.imgCommentItemHead
        val name = binding.txtCommentItemName
        val level = binding.imgCommentItemLevel
        val content = binding.txtCommentItemContent
        private val likeLayout = binding.llayoutCommentItemLike
        private val likes = binding.txtCommentItemLikes
        private val likeImg = binding.imgCommentItemLike
        private val unLikeImg = binding.imgCommentUnlike
        val more = binding.clayoutCommentItemMore
        private val unLikeView = binding.clayoutCommentItemDislike
        private val shareView = binding.clayoutCommentItemShare
        private val commentSendView = binding.clayoutCommentItemComment
        val date = binding.txtCommentItemDate
        private val upLikeView = binding.clayoutCommentUplike

        private val comment1 = binding.txtComment1
        private val comment2 = binding.txtComment2
        private val layoutAll = binding.clayoutMessageAll
        private val replyView = binding.llayoutCommentMore
        private val commentCounts = binding.txtItemCommentCounts
        private val clickableColor =
            ContextCompat.getColor(context, R.color.color_comment_reply_user)

        fun handle(position: Int) {

            val comment: VideoComment
            val user: User
            if (position > 0) {
                comment = list[position - 1].comment
                user = list[position - 1].user
            } else {
                comment = list[position].comment
                user = list[position].user
            }
            loadHeadCircleImage(context, user.headUrl!!, header)
            setLevelImageResourse(user.level, level)
            if (user.isVip == 1) {
                name.setTextColor(ContextCompat.getColor(context, R.color.color_name_vip))
                setTextType(true, name)
            } else {
                setTextType(false, name)
                name.setTextColor(ContextCompat.getColor(context, R.color.color_comment_name))
            }
            name.text = user.userName
            date.text = TimeUtils.parseTime(comment.commitTime)

            if (comment.type == 3) {
                val builder = SpannableStringUtils.replyOneBuilder(clickableColor, comment, object :
                    SpanClickListener<Int> {
                    override fun spanClick(t: Int) {
                        Log.e("CommentListAdapter", "点击了回复的用户")
                        startUserInfoActivity(context, t)
                    }
                })
                content.text = builder
                content.movementMethod = LinkMovementMethod.getInstance()
            } else {
                content.text = comment.content
            }
            viewInit(comment)
            onClick(comment, user, position)
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

        private fun onClick(videoComment: VideoComment, user: User, position: Int) {
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

            name.setOnClickListener {
                startUserInfoActivity(context, videoComment.fromUserCode)
            }
            header.setOnClickListener {
                startUserInfoActivity(context, videoComment.fromUserCode)
            }
            itemView.setOnClickListener {
                Log.e("CommentListAdapter", "点击了item")
                reply(videoComment, user, position)
            }

            content.setOnClickListener {
                Log.e("CommentListAdapter", "点击了评论")
                reply(videoComment, user, position)
            }
        }

        private fun reply(comment: VideoComment, user: User, position: Int) {

            val type = if (position == 0) 2 else 3

            listener.reply(
                ReplyInfo(
                    comment.commentId,
                    comment.videoCode,
                    type,
                    user.userName!!,
                    user.userCode
                )
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(isRefresh: Boolean, data: MutableList<CommentAndUser>) {

        if (isRefresh) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        } else {
            list.addAll(data)
            notifyItemRangeInserted(list.size + 1, data.size)
        }
    }

    interface ItemClickListener {
        fun reply(reply: ReplyInfo)
    }
}