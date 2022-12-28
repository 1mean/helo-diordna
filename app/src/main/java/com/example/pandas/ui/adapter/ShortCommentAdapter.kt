import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
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

    override fun getItemViewType(position: Int): Int {
        val count = data[position].comment.replyCounts
        if (count == 0) {
            return 0
        } else {
            return 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == 0) {
            val binding = AdapterShortCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return CommentViewHolder(binding)
        } else {
            val binding = AdapterShortCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ReplyCommentViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            (holder as CommentViewHolder).handle(position)
        } else {
            (holder as ReplyCommentViewHolder).handle(position)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class CommentViewHolder(binding: AdapterShortCommentBinding) : ViewHolder(binding.root) {

        val startIndex = 0

        val mContext = itemView.context
        val header = binding.imgHeaderItemShortComment
        val name = binding.txtNameItemShortComment
        val content = binding.txtContentItemShortComment
        val time = binding.txtTimeItemShortComment
        val reply = binding.txtReplyItemShortComment
        val likeLayout = binding.clayoutLikeItemShort
        val likes = binding.txtLikesItemShort
        val likeView = binding.imgLikeItemShort
        val comments = binding.txtCommentsItemShort
        val replyCountsView = binding.llayoutReplyItemShort
        val replyRecyclerView = binding.rvReply

        fun handle(position: Int) {

            val comment = data[position].comment
            val user = data[position].user

            loadImage(mContext, user.headUrl!!, header)

            name.text = user.userName
            val spannableStringBuilder = QqEmoticons.parseAndShowEmotion(mContext, comment.content)
            content.text = spannableStringBuilder
            time.text = TimeUtils.descriptiveData(comment.commitTime)
            likes.text = comment.likeNum.toString()

            replyCountsView.visibility = View.GONE
        }
    }

    private val adapterMap = HashMap<Int, ShortReplyCommentAdapter>()
    inner class ReplyCommentViewHolder(binding: AdapterShortCommentBinding) :
        ViewHolder(binding.root) {

        val startIndex = 0

        val mContext = itemView.context
        val header = binding.imgHeaderItemShortComment
        val name = binding.txtNameItemShortComment
        val content = binding.txtContentItemShortComment
        val time = binding.txtTimeItemShortComment
        val reply = binding.txtReplyItemShortComment
        val likeLayout = binding.clayoutLikeItemShort
        val likes = binding.txtLikesItemShort
        val likeView = binding.imgLikeItemShort
        val comments = binding.txtCommentsItemShort
        val replyCountsView = binding.llayoutReplyItemShort
        val replyRecyclerView = binding.rvReply

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
            replyCountsView.visibility = View.VISIBLE
            comments.text = "展开$replyCounts 条回复"


            if (comment.booleanFlag) {//已经被点开了
                replyRecyclerView.visibility = View.VISIBLE
                Log.e("comment_adapter","${adapterMap.containsKey(position)}")
                Log.e("comment_adapter","${adapterMap[position]}")
                if (adapterMap.containsKey(position)) {
                    replyRecyclerView.run {
                        layoutManager = LinearLayoutManager(mContext)
                        adapter = adapterMap[position]
                    }
                }
            } else {
                replyRecyclerView.visibility = View.GONE
                replyRecyclerView.adapter = null
            }

            val mAdapter = replyRecyclerView.adapter
            if (mAdapter == null) {
                Log.e(
                    "comment_adapter",
                    "position:$position ,${comment.booleanFlag}, adapter is null"
                )
            } else {
                val count = (mAdapter as ShortReplyCommentAdapter).itemCount
                Log.e(
                    "comment_adapter",
                    "position:$position ,${comment.booleanFlag}, itemCounts:$count"
                )
            }

            var isInit = false
            replyCountsView.setOnClickListener {

                if (!replyRecyclerView.isVisible) {
                    replyRecyclerView.visibility = View.VISIBLE
                    data[position].comment.booleanFlag = true
                }
                if (!isInit) {
                    isInit = true
//                    replyRecyclerView.setAutoLoadMore(false).setIntercept(false)
//                        .initNoFooter(null, adapter = ShortReplyCommentAdapter(mutableListOf()))
                    val replyAdapter = ShortReplyCommentAdapter(mutableListOf())
                    replyRecyclerView.run {
                        layoutManager = LinearLayoutManager(mContext)
                        adapter = replyAdapter
                    }
                    adapterMap[position] = replyAdapter
                }
                listener.loadMore(true, position, comment.videoCode, comment.commentId, startIndex)
            }
        }
    }

    interface CommentListener {
        fun loadMore(
            isRefreshing: Boolean,
            position: Int,
            videoCode: Int,
            commentId: Int,
            startIndex: Int
        )
    }
}