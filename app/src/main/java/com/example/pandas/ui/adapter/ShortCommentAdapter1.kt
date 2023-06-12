import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.AdapterShortCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.utils.TimeUtils

/**
 * @description: ShortCommentAdapter
 * @author: dongyiming
 * @date: 12/10/22 8:56 PM
 * @version: v1.0
 */
public class ShortCommentAdapter1(
    private val data: MutableList<CommentAndUser>,
    private val listener: CommentListener
) :
    Adapter<ViewHolder>() {

    fun refreshAdapter(list: MutableList<CommentAndUser>) {

        if (list.isNotEmpty() && list != data) {
            list.forEach {
                val comment = it.comment
                if (comment.replyCounts > 0) {
                    comment.state = 2
                }
            }
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加更多数据
     */
    fun loadMore(list: MutableList<CommentAndUser>) {
        if (list.isNotEmpty()) {
            list.forEach {
                val comment = it.comment
                if (comment.replyCounts > 0) {
                    comment.state = 2
                }
            }
            val size = data.size
            data.addAll(list)
            notifyItemRangeInserted(size, list.size)
        }
    }

    /**
     * 添加一条回复
     * - 一级弹幕直接放在第一个位置，并且弹到该位置
     * - 二级三级弹幕，放在当前页面最后一个位置
     */
    fun loadOne(comment: CommentAndUser, position: Int, type: Int) {
        if (type == 1) {//一级评论
            Log.e("comment", "comment:$comment, position:$position")
            data.add(0, comment)
            notifyItemInserted(0)
        } else {
            val topComment = data[position].comment
            //回复空的一级评论，此时不用展示"加载更多"和"收起"，以后再回复这个item也不用展示
            if (topComment.replyCounts == 0 || topComment.booleanFlag2) {
                topComment.booleanFlag2 = true
                topComment.replyComments.add(0, comment)
            } else {
                if (topComment.booleanFlag) {//有回复，并且已经展开了，放置在该页面的最后
                    val index = topComment.intFlag
                    topComment.replyComments.add(index + 1, comment)
                    topComment.intFlag += 1
                } else {//有回复，但是没有展开，此时展开只显示这一条回复，其他的需要加载更多
                    topComment.replyComments.add(0, comment)
                    topComment.intFlag = 0
                }
            }
            Log.e(
                "shortAdapter",
                "intFlag: ${topComment.intFlag}, size:${topComment.replyComments.size}"
            )
            topComment.replyCounts += 1
            topComment.booleanFlag = true
            notifyItemChanged(position)
        }
    }

    //RecyclerView的adapter会出现复用的情况，RecyclerView从展开变为收起，RecyclerView对象完全变了，adapter也同样变化
    override fun getItemViewType(position: Int): Int {
        return data[position].comment.commentId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = AdapterShortCommentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReplyCommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ReplyCommentViewHolder).handle(position)
    }

    override fun getItemCount(): Int = data.size

    inner class ReplyCommentViewHolder(binding: AdapterShortCommentBinding) :
        ViewHolder(binding.root) {

        val mContext = itemView.context
        val header = binding.imgHeaderItemShortComment
        val name = binding.txtNameItemShortComment
        val content = binding.txtContentItemShortComment
        val time = binding.txtTimeItemShortComment
        val address = binding.txtAddressItemShortComment
        val reply = binding.txtReplyItemShortComment
        val likeLayout = binding.clayoutLikeItemShort
        val itemContentView = binding.clayoutContentItemShortComment
        val likes = binding.txtLikesItemShort
        val likeView = binding.imgLikeItemShort
        val comments = binding.txtCommentsItemShort
        private val arrows = binding.imgCommentsItemShort
        val replyCountsLayout = binding.flayoutReplyItemShort
        val replyCountView = binding.llayoutReplyItemShort
        private val replyLoadingView = binding.clayoutReplyLoading
        private val replyRecyclerView = binding.rvReply

        fun loadReplyData(position: Int, replies: MutableList<CommentAndUser>) {

            val topComment = data[position].comment
            val replyCounts = topComment.replyCounts
            val visiableSize =
                if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount
            val hasMore = (visiableSize + replies.size) < replyCounts

            if (replyRecyclerView.adapter == null) {
                replyRecyclerView.run {
                    visibility = View.VISIBLE
                    layoutManager = LinearLayoutManager(mContext)
                    adapter = ShortReplyCommentAdapter(replies)
                }
            } else {
                (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadMore(replies)
            }
            replyRecyclerView.post {
                replyLoadingView.visibility = View.GONE
                if (hasMore) {
                    comments.text = "展开更多回复"
                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                } else {
                    comments.text = "收起"
                    arrows.setImageResource(R.mipmap.img_short_comment_up)
                }
            }
            topComment.state = 4
            topComment.replyComments.addAll(replies)
        }

        fun handle(position: Int) {

            val comment = data[position].comment
            val user = data[position].user
            val replyCounts = comment.replyCounts
            initWeget(comment, user)

            if (comment.replyCounts == 0 && comment.state == 0) {
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
            } else if (comment.state == 1) {
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
            } else if (comment.state == 2) {//有评论，但是未点开
                replyCountsLayout.visibility = View.VISIBLE
                replyLoadingView.visibility = View.GONE
                comments.text = "展开$replyCounts 条回复"
            } else if (comment.state == 3) {//原始评论未展开，只是我回复的在显示
                replyRecyclerView.visibility = View.VISIBLE
                comments.text = "展开$replyCounts 条回复"
            } else if (comment.state == 4) {//有评论，也展开了
                val visiableCounts = replyRecyclerView.adapter!!.itemCount
                if (visiableCounts < replyCounts) {
                    replyRecyclerView.visibility = View.VISIBLE
                    comments.text = "展开更多回复"
                } else {
                    comments.text = "收起"
                }
            }

            //点开回复 或 加载更多 或 收起
            replyCountsLayout.setOnClickListener {
                val replySize = comment.replyCounts
                val replyCacheSize = comment.replyComments.size
                val visiableSize =
                    if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount

                when (comment.state) {
                    2, 3 -> {//有评论，但是未点开
                        if (replyCacheSize > 0) {
                            //bug:这里直接对comment.replyComments进行subList方法，会导致多次操作后，原始comment的replyComments进行叠加
                            //这里只对同样数据的新list做处理，不涉及原始对象
                            val replyList = comment.replyComments.toMutableList()
                            val currentPageList = replyList.subList(0, 3)
                            if (replyRecyclerView.adapter == null) {
                                replyRecyclerView.run {
                                    visibility = View.VISIBLE
                                    layoutManager = LinearLayoutManager(mContext)
                                    adapter = ShortReplyCommentAdapter(currentPageList)
                                }
                            } else {
                                (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadMore(
                                    currentPageList
                                )
                            }
                            comment.state = 4
                            replyRecyclerView.post {
                                if (replyRecyclerView.adapter!!.itemCount == comment.replyCounts) {
                                    comments.text = "收起"
                                    arrows.setImageResource(R.mipmap.img_short_comment_up)
                                } else {
                                    comments.text = "展开更多回复"
                                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                                }
                            }
                        } else {
                            listener.loadMore(
                                position,
                                0,
                                3,
                                comment.videoCode,
                                comment.id
                            )
                            replyLoadingView.visibility = View.VISIBLE
                        }
                    }
                    4 -> {//有评论
                        if (replyCacheSize > visiableSize) {//先加载本地数据
                            val replyList = comment.replyComments.toMutableList()
                            val currentPageList = replyList.subList(visiableSize, visiableSize + 10)
                            if (replyRecyclerView.adapter == null) {
                                replyRecyclerView.run {
                                    visibility = View.VISIBLE
                                    layoutManager = LinearLayoutManager(mContext)
                                    adapter = ShortReplyCommentAdapter(currentPageList)
                                }
                            } else {
                                (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadMore(
                                    currentPageList
                                )
                            }
                            replyRecyclerView.post {
                                if (replyRecyclerView.adapter!!.itemCount == comment.replyCounts) {
                                    comments.text = "收起"
                                    arrows.setImageResource(R.mipmap.img_short_comment_up)
                                } else {
                                    comments.text = "展开更多回复"
                                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                                }
                            }
                        } else {

                            listener.loadMore(
                                position,
                                comment.commitTime,
                                10,
                                comment.videoCode,
                                comment.id
                            )
                            replyLoadingView.visibility = View.VISIBLE
                        }
                    }
                }
            }

            reply.setOnClickListener {
                listener.reply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.commentId,
                        user.userCode,
                        user.userName!!,
                        2,
                        comment.content
                    ), position
                )
            }

            //避免使用itemview的点击，导致点击空余地方也会触发item的渐变和点击效果
            itemContentView.setOnClickListener {
                listener.reply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.commentId,
                        user.userCode,
                        user.userName!!,
                        2,
                        comment.content
                    ), position
                )
            }
        }

        private fun initWeget(comment: VideoComment, user: User) {
            loadImage(mContext, user.headUrl!!, header)

            if (user.ipAddress != null) {
                address.text = StringBuilder(" · ").append(user.ipAddress).toString()
            } else {
                val addressString = AppInfos.provinces.random()
                address.text = StringBuilder(" · ").append(addressString).toString()
            }

            name.text = user.userName
            val spannableStringBuilder = QqEmoticons.parseAndShowEmotion(mContext, comment.content)
            content.text = spannableStringBuilder
            time.text = TimeUtils.descriptiveData(comment.commitTime)

            if (comment.likeNum == 0) {
                likes.visibility = View.GONE
            } else {
                likes.visibility = View.VISIBLE
                likes.text = comment.likeNum.toString()
            }

            if (!comment.like) {
                likeView.setImageResource(R.mipmap.img_item_comment_like)
                likes.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.color_txt_right_comment_item_like
                    )
                )
            } else {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.color_txt_right_comment_item_liked
                    )
                )
            }

            likeLayout.setOnClickListener {
                likeView.post {
                    addScaleAnimation(likeView, 1.3f)
                }
                if (comment.like) {
                    likeView.setImageResource(R.mipmap.img_item_comment_like)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color_txt_right_comment_item_like
                        )
                    )
                    comment.likeNum -= 1
                    likes.text = comment.likeNum.toString()
                    if (comment.likeNum == 0) {
                        likes.visibility = View.GONE
                    }
                } else {
                    likeView.setImageResource(R.mipmap.img_item_comment_liked)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color_txt_right_comment_item_liked
                        )
                    )
                    comment.likeNum += 1
                    likes.visibility = View.VISIBLE
                    likes.text = comment.likeNum.toString()
                }
                comment.like = !comment.like
                listener.updateComment(comment)
            }
        }
    }

    interface CommentListener {
        fun loadMore(
            topCommentPosition: Int,
            commitTime: Long,
            pageCount: Int,
            videoCode: Int,
            commentId: Int
        )

        fun reply(commentUser: CommentAndUser, position: Int)

        fun updateComment(comment: VideoComment)
    }

    fun convertCommentAndUser(
        videoCode: Int,
        topCommentId: Int,
        toUserCode: Int,
        toUserName: String,
        type: Int,
        content: String
    ): CommentAndUser {

        val comment = VideoComment(
            videoCode = videoCode,
            topCommentId = topCommentId,
            toUserCode = toUserCode,
            toUserName = toUserName,
            type = type,
            content = content,
            fromUserCode = AppInfos.AUTHOR_ID,
            fromUserName = AppInfos.AUTHOR_NAME
        )
        val user = User(
            userCode = AppInfos.AUTHOR_ID,
            userName = AppInfos.AUTHOR_NAME,
            headUrl = AppInfos.HEAD_URL
        )
        return CommentAndUser(comment, user)
    }
}