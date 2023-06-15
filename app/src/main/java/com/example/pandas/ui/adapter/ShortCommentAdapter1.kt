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
import com.example.pandas.biz.interaction.ShortCommentListener
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
    private val listener: ShortCommentListener
) :
    Adapter<ViewHolder>() {

    //已显示的回复的id，防止出现有重复的回复，主要是自己会发送回复，导致时间和id顺序都没办法弄
    //private val visiableReplyComments = mutableMapOf<Int, MutableList<Int>>()

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

    fun loadOneCmMessage(videoComment: CommentAndUser) {
        Log.e("lidandan", "add one message: $videoComment")
        data.add(0, videoComment)
        //bug:在数据首位添加一个元素后，list的缓存里的position并未改变，只有当我们滑动后，缓存更改后，position才会改变，所以我们必须使用notifyItemRangeChanged进行局部刷新
        notifyItemInserted(0)
        //notifyItemRangeChanged(0, data.size)
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

        /**
         * 添加一条回复
         * - 一级弹幕直接放在第一个位置，并且弹到该位置
         * - 二级三级弹幕，放在当前页面最后一个位置
         */
        fun loadOne(comment: CommentAndUser, position: Int) {
            val topComment = data[position].comment
            val topCommentId = comment.comment.topCommentId
            Log.e(
                "lidandan",
                "loadOne() position:$position, topCommentId:$topCommentId, commentId:${topComment.id}"
            )
//            if (topComment.id != topCommentId) {
//                throw IllegalArgumentException("不是该条消息的回复内容，请重新确认！")
//            }
            if (replyRecyclerView.adapter == null) {
                replyRecyclerView.run {
                    visibility = View.VISIBLE
                    layoutManager = LinearLayoutManager(mContext)
                    adapter = ShortReplyCommentAdapter(mutableListOf(comment), object :
                        ShortReplyCommentAdapter.ReplyItemClickListener {
                        override fun reply(commentUser: CommentAndUser) {
                            val commentId = data[position].comment.id
                            val commentId1 = commentUser.comment.topCommentId
                            Log.e(
                                "lidandan",
                                "commentId:$commentId, commentId1:$commentId1, position:$position"
                            )
//                            if (commentId != commentId1) {
//                                throw IllegalArgumentException("不是该条消息的回复内容，请重新确认！")
//                            }
                            var curPos = 0
                            data.forEachIndexed { index, commentAndUser ->

                                if (commentAndUser.comment.id == commentUser.comment.topCommentId) {
                                    curPos = index
                                }
                            }
                            listener.reply(commentUser, curPos)
                        }
                    })
                }
            } else {
                (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadOne(comment)
            }
            when (topComment.state) {
                0 -> {//1，没有评论的item,添加回复
                    data[position].comment.state = 1
                }
                2 -> {//3,有评论，但是未点开
                    data[position].comment.state = 3
                }
            }
            if (replyRecyclerView.adapter!!.itemCount < topComment.replyCounts) {
                topComment.replyComments.add(replyRecyclerView.adapter!!.itemCount - 1, comment)
            } else {
                topComment.replyComments.add(comment)
            }
            topComment.newReplyCounts += 1
            topComment.replyCounts += 1
        }

        fun loadReplyData(position: Int, replies: MutableList<CommentAndUser>) {

            val topComment = data[position].comment
            if (topComment.id != replies[0].comment.topCommentId) {
                throw IllegalArgumentException("不是该条消息的回复内容，请重新确认！")
            }
            val replyCounts = topComment.replyCounts
            val visibleSize =
                if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount
            val hasMore = (visibleSize + replies.size) < replyCounts

            if (replyRecyclerView.adapter == null) {
                replyRecyclerView.run {
                    visibility = View.VISIBLE
                    layoutManager = LinearLayoutManager(mContext)
                    adapter = ShortReplyCommentAdapter(replies, object :
                        ShortReplyCommentAdapter.ReplyItemClickListener {
                        override fun reply(commentUser: CommentAndUser) {
                            var curPos = 0
                            data.forEachIndexed { index, commentAndUser ->

                                if (commentAndUser.comment.id == commentUser.comment.topCommentId) {
                                    curPos = index
                                }
                            }
                            listener.reply(commentUser, curPos)
                        }
                    })
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

            Log.e(
                "1mean111",
                "position: $position, replyRecyclerView.adapter=${replyRecyclerView.adapter}"
            )
            val comment = data[position].comment
            val user = data[position].user
            val replyCounts = comment.replyCounts
            initWedget(comment, user)

            if (comment.replyCounts == 0 && comment.state == 0) {
                replyRecyclerView.visibility = View.GONE
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
            } else if (comment.state == 1) {
                replyRecyclerView.visibility = View.VISIBLE
                replyCountsLayout.visibility = View.GONE  //不显示加载更多
            } else if (comment.state == 2) {//有评论，但是未点开
                replyRecyclerView.visibility = View.VISIBLE
                replyCountsLayout.visibility = View.VISIBLE
                replyLoadingView.visibility = View.GONE
                comments.text = "展开$replyCounts 条回复"
            } else if (comment.state == 3) {//原始评论未展开，只是我回复的在显示
                val visibleCounts = replyRecyclerView.adapter!!.itemCount
                replyRecyclerView.visibility = View.VISIBLE
                comments.text = "展开${replyCounts - visibleCounts} 条回复"
            } else if (comment.state == 4) {//有评论，也展开了
                Log.e("1mean", "position:$position ,adapter:${replyRecyclerView.adapter}")
                val visibleCounts = replyRecyclerView.adapter!!.itemCount
                if (visibleCounts < replyCounts) {
                    replyRecyclerView.visibility = View.VISIBLE
                    comments.text = "展开更多回复"
                } else {
                    comments.text = "收起"
                }
            }

            Log.e(
                "lidandan",
                "position=$position--------recyclerView:$replyRecyclerView, adapter:${replyRecyclerView.adapter}"
            )

            //点开回复 或 加载更多 或 收起
            replyCountsLayout.setOnClickListener {
                val replySize = comment.replyCounts
                val visibleSize =
                    if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount

                if (visibleSize == replySize) {//评论已全部展示，点击收起
                    Log.e("1mean", "replyRecyclerView.adapter=null")
                    replyRecyclerView.adapter = null
                    replyRecyclerView.visibility = View.GONE
                    comments.text = "展开$replySize 条回复"
                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                    data[position].comment.state = 2
                    data[position].comment.newReplyCounts = 0 //涉及到下次startIndex的计算会出问题，必须重制
                    return@setOnClickListener
                }

                //1,计算出需要获取的数据
                var startIndex: Int
                val pageCounts: Int
                if (visibleSize == 0) {
                    startIndex = 0
                    pageCounts = if (replySize < 3) replySize else 3
                } else {
                    startIndex = visibleSize - comment.newReplyCounts
                    val inVisibleSize = replySize - visibleSize
                    pageCounts = if (startIndex >= 3) {
                        if (inVisibleSize < 10) inVisibleSize else 10
                    } else {
                        if (inVisibleSize < 3) inVisibleSize else 3
                    }
                }

                //2，当有缓存数据时，优先加载缓存数据
                if (comment.replyComments.size > 0 && comment.replyComments.size > visibleSize) {
                    //bug:这里直接对comment.replyComments进行subList方法，会导致多次操作后，原始comment的replyComments进行叠加
                    //这里只对同样数据的新list做处理，不涉及原始对象
                    startIndex = visibleSize
                    val replyList = comment.replyComments.toMutableList()
                    val currentPageList = replyList.subList(startIndex, startIndex + pageCounts)
                    if (replyRecyclerView.adapter == null) {
                        replyRecyclerView.run {
                            visibility = View.VISIBLE
                            layoutManager = LinearLayoutManager(mContext)
                            adapter = ShortReplyCommentAdapter(currentPageList, object :
                                ShortReplyCommentAdapter.ReplyItemClickListener {
                                override fun reply(commentUser: CommentAndUser) {
                                    var curPos = 0
                                    data.forEachIndexed { index, commentAndUser ->

                                        if (commentAndUser.comment.id == commentUser.comment.topCommentId) {
                                            curPos = index
                                        }
                                    }
                                    listener.reply(commentUser, curPos)
                                }
                            })
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
                    data[position].comment.state = 4
                } else {
                    var curPos = 0
                    data.forEachIndexed { index, commentAndUser ->

                        if (commentAndUser.comment.id == comment.id) {
                            curPos = index
                        }
                    }
                    //3，缓存数据加载完成了后，从网络加载数据
                    listener.loadMore(
                        curPos,
                        startIndex,
                        pageCounts,
                        comment.videoCode,
                        comment.id
                    )
                    replyLoadingView.visibility = View.VISIBLE
                }
            }

            reply.setOnClickListener {
                var curPos = 0
                data.forEachIndexed { index, commentAndUser ->

                    if (commentAndUser.comment.id == comment.id) {
                        curPos = index
                    }
                }
                listener.reply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.id,
                        user.userCode,
                        user.userName!!,
                        2,
                        comment.content
                    ), curPos
                )
            }

            //避免使用itemview的点击，导致点击空余地方也会触发item的渐变和点击效果
            itemContentView.setOnClickListener {

                Log.e("1mean111", "item click position: $position")
                var curPos = 0
                data.forEachIndexed { index, commentAndUser ->

                    if (commentAndUser.comment.id == comment.id) {
                        curPos = index
                    }
                }
                listener.reply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.id,
                        user.userCode,
                        user.userName!!,
                        2,
                        comment.content
                    ), curPos
                )
            }
        }

        private fun initWedget(comment: VideoComment, user: User) {
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
            headUrl = AppInfos.HEAD_URL,
            ipAddress = "湖北"
        )
        return CommentAndUser(comment, user)
    }
}