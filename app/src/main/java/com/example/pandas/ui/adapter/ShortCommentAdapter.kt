import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pandas.R
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.AdapterShortCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.utils.TimeUtils

/**
 * @description: ShortCommentAdapter
 * @author: dongyiming
 * @date: 12/10/22 8:56 PM
 * @version: v1.0
 */
public class ShortCommentAdapter(
    private val data: MutableList<CommentAndUser>,
    private val listener: CommentListener
) :
    Adapter<ViewHolder>() {

    //commentId - adapter
    private val adapterMap = HashMap<Int, ShortReplyCommentAdapter>()

    fun refreshAdapter(list: MutableList<CommentAndUser>) {

        if (list.isNotEmpty() && list != data) {
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
            val newReplyCounts = topComment.newReplyCounts
            val itemCounts =
                if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount
            val hasMore = (itemCounts + replies.size) < replyCounts + newReplyCounts

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
            topComment.booleanFlag = true
            topComment.replyComments.addAll(replies)
        }

        //添加一个2级评论或3级评论，不需要刷新，刷新每次都需要重新加载adapter
        fun loadOne(commentUser: CommentAndUser, position: Int) {
            Log.e("shortAdapter", "asdasda")
            val topComment = data[position].comment
            if (topComment.booleanFlag2) {//不用展示加载更多的item
                if (replyCountsLayout.isVisible) {
                    replyCountsLayout.visibility = View.GONE
                }
                if (replyRecyclerView.adapter != null) {
                    (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadOne(commentUser)
                }
            } else {
                if (topComment.booleanFlag) {//已经被点开了
                    require(replyRecyclerView.adapter != null) {
                        Log.e("1mean", "Current reply item is open,but adapter is null")
                    }
                    val adapter = (replyRecyclerView.adapter as ShortReplyCommentAdapter)
                    val itemCounts = adapter.itemCount
                    adapter.loadOne(commentUser)
                    topComment.replyComments.add(itemCounts, commentUser)
                } else {
                    //没有回复的一级评论 或 有评论但是未展开的一级评论
                    if (replyRecyclerView.adapter == null) {
                        if (!replyRecyclerView.isVisible) {
                            replyRecyclerView.visibility = View.VISIBLE
                        }
                        replyRecyclerView.run {
                            layoutManager = LinearLayoutManager(mContext)
                            adapter = ShortReplyCommentAdapter(mutableListOf(commentUser))
                        }
                        if (topComment.replyCounts == 0) {//没有回复的一级评论，标记为不用展示加载更多
                            if (replyCountsLayout.isVisible) {
                                replyCountsLayout.visibility = View.GONE
                            }
                            topComment.booleanFlag2 = true
                        }
                        topComment.replyComments.add(0, commentUser)
                    }
                }
            }
            topComment.newReplyCounts += 1
            topComment.booleanFlag = true
        }

        fun handle(position: Int) {

            val comment = data[position].comment
            val user = data[position].user
            val replyCounts = comment.replyCounts

            loadImage(mContext, user.headUrl!!, header)

            name.text = user.userName
            val spannableStringBuilder = QqEmoticons.parseAndShowEmotion(mContext, comment.content)
            content.text = spannableStringBuilder
            time.text = TimeUtils.descriptiveData(comment.commitTime)
            likes.text = comment.likeNum.toString()


            //无回复 或 自己对无回复的一级评论进行评论，标记该item为不用展示加载更多
            if (comment.replyCounts == 0 || comment.booleanFlag2) {
                replyCountsLayout.visibility = View.GONE
            } else {
                replyCountsLayout.visibility = View.VISIBLE
                replyLoadingView.visibility = View.GONE
                //comments.text = "展开${replyCounts + comment.newReplyCounts} 条回复"
                if (comment.booleanFlag) {
                    replyRecyclerView.visibility = View.VISIBLE
                    if (replyCounts + comment.newReplyCounts == replyRecyclerView.adapter!!.itemCount) {
                        Log.e("1mean", "-----------")
                        comments.text = "收起"
                    } else if (comment.newReplyCounts == replyRecyclerView.adapter!!.itemCount) {
                        Log.e("1mean", "二二二二二二二二")
                        comments.text = "展开$replyCounts 条回复"
                    } else {
                        Log.e("1mean", "三三三三三三三三三")
                        comments.text = "展开更多回复"
                    }
                } else {
                    Log.e("1mean", "四四四四四四四四四四四四四四四四四四")
                    replyRecyclerView.visibility = View.GONE
                    comments.text = "展开${replyCounts + comment.newReplyCounts} 条回复"
                }
            }

            //点开回复 或 加载更多 或 收起
            replyCountsLayout.setOnClickListener {

                val replySize = comment.replyCounts
                val newReplySize = comment.newReplyCounts
                val replyListSize = comment.replyComments.size
                Log.e("11mean", "replyListSize:$replyListSize")
                val itemCounts =
                    if (replyRecyclerView.adapter == null) 0 else replyRecyclerView.adapter!!.itemCount

                //收起
                if (replyRecyclerView.adapter != null && replyRecyclerView.adapter!!.itemCount == replySize + newReplySize) {
                    comment.intFlag = 0
                    replyRecyclerView.adapter = null
                    replyRecyclerView.visibility = View.GONE
                    comments.text = "展开${replyCounts + newReplySize} 条回复"
                    data[position].comment.booleanFlag = false

                    arrows.setImageResource(R.mipmap.img_short_comment_down)
                } else {//加载数据
//                    require(replyRecyclerView.adapter != null) {
//                        Log.e("1mean", "Current reply item is open,but adapter is null")
//                    }
                    if (replyListSize > itemCounts) {//先把本地以缓存的全部加载完成
                        //val sub = itemCounts - newReplySize//已展示和新加入的差值
                        //bug:这里直接对comment.replyComments进行subList方法，会导致多次操作后，原始comment的replyComments进行叠加
                        //这里只对同样数据的新list做处理，不涉及原始对象
                        val replyList = comment.replyComments.toMutableList()
                        val list = if (comment.intFlag == 0) {//展示第一页
                            if (replyListSize - itemCounts >= 3) {//考虑在点开前，又输入了新评论，所以不能从0开始
                                replyList.subList(itemCounts, itemCounts + 3)
                            } else {
                                replyList.subList(itemCounts, replyListSize - newReplySize)
                            }
                        } else {
                            //bug: sublist()方法导致了loadMore(list)出现ConcurrentModificationException异常
                            //解决办法：再套一层toMutableList()
                            if (replyListSize - itemCounts >= 10) {
                                replyList.subList(
                                    itemCounts,
                                    itemCounts + 10
                                ).toMutableList()
                            } else {
                                replyList.subList(
                                    itemCounts,
                                    replyListSize
                                ).toMutableList()
                            }
                        }

                        if (replyRecyclerView.adapter == null) {
                            replyRecyclerView.run {
                                visibility = View.VISIBLE
                                layoutManager = LinearLayoutManager(mContext)
                                adapter = ShortReplyCommentAdapter(list)
                            }
                        } else {
                            (replyRecyclerView.adapter as ShortReplyCommentAdapter).loadMore(list)
                        }

                        data[position].comment.booleanFlag = true
                        data[position].comment.intFlag++

                        replyRecyclerView.post {
                            if (replyRecyclerView.adapter!!.itemCount == replySize + newReplySize) {
                                comments.text = "收起"
                                arrows.setImageResource(R.mipmap.img_short_comment_up)
                            } else {
                                comments.text = "展开更多回复"
                                arrows.setImageResource(R.mipmap.img_short_comment_down)
                            }
                        }
                    } else if (replyListSize < replySize + newReplySize) {//再从服务器加载剩余数据
                        val sub = itemCounts - newReplySize//已经从网络获取并展示的数量
                        val sub2 = replySize + newReplySize - itemCounts//还需要从网络获取的数量
                        val pageCount = if (sub < 3) {
                            if (sub2 < 3) {
                                sub2
                            } else {
                                3
                            }
                        } else {
                            if (sub2 < 10) {
                                sub2
                            } else {
                                10
                            }
                        }
                        listener.loadMore(
                            sub,
                            pageCount,
                            position,
                            comment.videoCode,
                            comment.commentId
                        )
                        replyLoadingView.visibility = View.VISIBLE
                    }
                }
            }

            reply.setOnClickListener {
                listener.reply(
                    user.userName!!,
                    user.userCode,
                    position,
                    comment.commentId,
                    comment.videoCode,
                    2
                )
            }

            //避免使用itemview的点击，导致点击空余地方也会触发item的渐变和点击效果
            itemContentView.setOnClickListener {
                listener.reply(
                    user.userName!!,
                    user.userCode,
                    position,
                    comment.commentId,
                    comment.videoCode,
                    2
                )
            }
        }
    }

    interface CommentListener {
        fun loadMore(
            startIndex: Int,
            pageCount: Int,
            position: Int,
            videoCode: Int,
            commentId: Int
        )

        fun reply(
            fromName: String,
            fromUserCode: Int,
            position: Int,
            commentId: Int,
            videoCode: Int,
            type: Int
        )
    }
}