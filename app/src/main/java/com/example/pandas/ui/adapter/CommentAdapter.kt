package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.ReplyInfo
import com.example.pandas.biz.ext.loadHeadCircleImage
import com.example.pandas.biz.interaction.SpanClickListener
import com.example.pandas.databinding.ItemCommentsBinding
import com.example.pandas.databinding.ItemTopCommentsBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.ui.ext.setTextType
import com.example.pandas.ui.ext.startUserInfoActivity
import com.example.pandas.utils.SpannableStringUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: 视频评论页面
 * @author: dongyiming
 * @date: 5/28/22 3:02 上午
 * @version: v1.0
 */
public class CommentAdapter(
    private val list: MutableList<CommentAndUser>,
    private val listener: OnCommentClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_TOP = 1
    private val TYPE_ITEM = 2
    private var isOrderByTime = false//默认'按热度'排序
    private var replyPosition = -1

    override fun getItemViewType(position: Int): Int = if (position == 0) TYPE_TOP else TYPE_ITEM

    override fun getItemCount(): Int = if (list.isEmpty()) 0 else list.size + 1

    fun getOrder(): Boolean = isOrderByTime

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

    @SuppressLint("NotifyDataSetChanged")
    fun addComment(comment: CommentAndUser) {

        val type = comment.comment.type
        if (type == 1) {
            list.add(0, comment)
            notifyDataSetChanged()
        } else {
            val list = list[replyPosition - 1].comment.replyComments
            list.add(0, comment)
            notifyItemChanged(replyPosition)
        }
    }

    inner class TopHolder(binding: ItemTopCommentsBinding) : RecyclerView.ViewHolder(binding.root) {

        private val settingLayout = binding.llayoutCommentSetting
        private val settingText = binding.txtCommentSetting

        fun handle() {
            if (isOrderByTime) {
                settingText.text = itemView.context.getString(R.string.str_by_time)
            } else {
                settingText.text = itemView.context.getString(R.string.str_by_hot)
            }
            settingLayout.setOnClickListener {
                listener.orderClcik(isOrderByTime)
                isOrderByTime = !isOrderByTime
            }
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
        val more = binding.clayoutCommentItemMore
        private val unLikeView = binding.ibCommentItemUnlike
        private val shareView = binding.ibCommentItemShare
        private val commentSendView = binding.ibCommentItemComment
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

            val comment = list[position - 1].comment
            val replys = comment.replyComments
            val user = list[position - 1].user

            loadHeadCircleImage(context, user.headUrl!!, header)
            setLevelImageResourse(user.level, level)

            if (user.vip == 1) {
                name.setTextColor(ContextCompat.getColor(context, R.color.color_name_vip))
                setTextType(true, name)
            } else {
                setTextType(false, name)
                name.setTextColor(ContextCompat.getColor(context, R.color.color_comment_name))
            }
            name.text = user.userName

            if (replys.isEmpty()) {
                replyView.visibility = View.GONE
            } else {
                replyView.visibility = View.VISIBLE
                when (val counts = replys.size) {
                    1 -> {
                        comment1.visibility = View.VISIBLE
                        layoutAll.visibility = View.GONE
                        comment2.visibility = View.GONE
                        val builder = parseComment(replys[0].comment, replys[0].user)
                        comment1.text = builder
                        comment1.movementMethod = LinkMovementMethod.getInstance()
                    }
                    2 -> {
                        layoutAll.visibility = View.GONE
                        comment1.visibility = View.VISIBLE
                        comment2.visibility = View.VISIBLE
                        val builder1 = parseComment(replys[0].comment, replys[0].user)
                        comment1.text = builder1
                        val builder2 = parseComment(replys[1].comment, replys[1].user)
                        comment2.text = builder2
                        comment1.movementMethod = LinkMovementMethod.getInstance()
                        comment2.movementMethod = LinkMovementMethod.getInstance()
                    }
                    else -> {
                        layoutAll.visibility = View.VISIBLE
                        comment1.visibility = View.VISIBLE
                        comment2.visibility = View.VISIBLE
                        commentCounts.text = StringBuilder("共").append(counts).append("条回复")
                        val builder1 = parseComment(replys[0].comment, replys[0].user)
                        comment1.text = builder1
                        val builder2 = parseComment(replys[1].comment, replys[1].user)
                        comment2.text = builder2
                        comment1.movementMethod = LinkMovementMethod.getInstance()
                        comment2.movementMethod = LinkMovementMethod.getInstance()
                    }
                }
            }
            date.text = TimeUtils.parseTime(comment.commitTime)
            content.text = comment.content
            viewInit(comment)
            onClick(comment, user, position)
        }

        private fun parseComment(comment: VideoComment, user: User): SpannableStringBuilder {

            return SpannableStringUtils.replyBuilder(
                clickableColor,
                comment,
                user,
                object : SpanClickListener<Int> {
                    override fun spanClick(t: Int) {
                        startUserInfoActivity(context, user)
                    }
                })
        }

        private fun viewInit(videoComment: VideoComment) {

            if (videoComment.likeNum > 0) {
                likes.visibility = View.VISIBLE
                likes.text = videoComment.likeNum.toString()
            } else {
                likes.visibility = View.GONE
            }

            if (videoComment.like) {
                likeImg.setImageResource(R.mipmap.img_comment_liked)
                unLikeView.setImageResource(R.mipmap.img_comment_dislike)
            } else {
                likeImg.setImageResource(R.mipmap.img_comment_like)
            }

            if (videoComment.unLike) {
                likeImg.setImageResource(R.mipmap.img_comment_like)
                unLikeView.setImageResource(R.mipmap.img_comment_disliked)
            } else {
                unLikeView.setImageResource(R.mipmap.img_comment_dislike)
            }

            if (videoComment.upLike) {
                upLikeView.visibility = View.VISIBLE
            } else {
                upLikeView.visibility = View.GONE
            }
        }

        private fun onClick(videoComment: VideoComment, user: User, position: Int) {
            likeLayout.setOnClickListener {
                if (videoComment.like) {
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
                    if (videoComment.unLike) {
                        unLikeView.setImageResource(R.mipmap.img_comment_dislike)
                        videoComment.unLike = false
                    }
                    videoComment.likeNum = num
                }
                videoComment.like = !videoComment.like
            }

            commentSendView.setOnClickListener {

                replyPosition = position
                listener.addItemReply(
                    ReplyInfo(
                        videoComment.commentId,
                        videoComment.videoCode,
                        2,
                        user.userName!!,
                        user.userCode
                    )
                )
            }

            more.setOnClickListener {
                Toast.makeText(context, "更多", Toast.LENGTH_SHORT).show()
            }

            content.setOnClickListener {
                replyPosition = position
                listener.addItemReply(
                    ReplyInfo(
                        videoComment.commentId,
                        videoComment.videoCode,
                        2,
                        user.userName!!,
                        user.userCode
                    )
                )
            }

            comment1.setOnClickListener {
                replyPosition = position
                val comment1_user = videoComment.replyComments[0].user
                listener.addItemReply(
                    ReplyInfo(
                        videoComment.commentId,
                        videoComment.videoCode,
                        3,
                        comment1_user.userName!!,
                        comment1_user.userCode
                    )
                )
            }
            comment2.setOnClickListener {
                replyPosition = position
                val comment2_user = videoComment.replyComments[1].user
                listener.addItemReply(
                    ReplyInfo(
                        videoComment.commentId,
                        videoComment.videoCode,
                        3,
                        comment2_user.userName!!,
                        comment2_user.userCode
                    )
                )
            }
            unLikeView.setOnClickListener {
                if (videoComment.unLike) {
                    unLikeView.setImageResource(R.mipmap.img_comment_dislike)
                } else {
                    unLikeView.setImageResource(R.mipmap.img_comment_disliked)
                    if (videoComment.like) {
                        likeImg.setImageResource(R.mipmap.img_comment_like)
                        val num = videoComment.likeNum - 1
                        if (num == 0) {
                            likes.visibility = View.GONE
                        } else {
                            likes.visibility = View.VISIBLE
                            likes.text = num.toString()
                        }
                        videoComment.likeNum = num
                        videoComment.like = false
                    }
                }
                videoComment.unLike = !videoComment.unLike
            }

            shareView.setOnClickListener {
                Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show()
            }

            layoutAll.setOnClickListener {
                listener.showAllComment(videoComment.commentId)
            }

            name.setOnClickListener {
                startUserInfoActivity(context, user)
            }

            header.setOnClickListener {
                startUserInfoActivity(context, user)
            }
        }
    }

    interface OnCommentClickListener {

        fun orderClcik(isOrderByTime: Boolean)

        fun addItemReply(replyInfo: ReplyInfo)

        fun showAllComment(commentId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPE_TOP) {
            val holder =
                ItemTopCommentsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            TopHolder(holder)
        } else {
            val holder =
                ItemCommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CommentHolder(holder)
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