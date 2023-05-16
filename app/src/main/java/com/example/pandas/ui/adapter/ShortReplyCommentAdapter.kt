import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.AdapterItemCommentReplyBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.utils.TimeUtils

/**
 * @description: ShortReplyCommentAdapter
 * @author: dongyiming
 * @date: 12/20/22 4:15 AM
 * @version: v1.0
 */
public class ShortReplyCommentAdapter(private val commentUsers: MutableList<CommentAndUser>) :
    Adapter<ViewHolder>() {

    private val handler: Handler = Handler(Looper.getMainLooper())

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(list: MutableList<CommentAndUser>) {

        if (list.isNotEmpty() && list != commentUsers) {
            commentUsers.clear()
            commentUsers.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun loadMore(list: MutableList<CommentAndUser>) {
        if (list.isNotEmpty()) {
            val size = commentUsers.size
            Log.e("1mean", "$size , ${list.size}")
            commentUsers.addAll(list)
            notifyItemRangeInserted(size, list.size)
        }
    }

    fun loadOne(commentAndUser: CommentAndUser) {

        val size = commentUsers.size
        commentUsers.add(commentAndUser)
        notifyItemRangeInserted(size, 1)
    }

    override fun getItemViewType(position: Int): Int {

        if (commentUsers.isNotEmpty()) {
            return commentUsers[position].comment.commentType
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == 0) {//正常文字弹幕
            val binding = AdapterItemCommentReplyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TextViewHodler(binding)
        }
        val binding = AdapterItemCommentReplyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TextViewHodler(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (getItemViewType(position) == 0) {
            (holder as TextViewHodler).handle(position)
        }
    }

    override fun getItemCount(): Int = if (commentUsers.isEmpty()) {
        0
    } else {
        commentUsers.size
    }

    private inner class TextViewHodler(binding: AdapterItemCommentReplyBinding) :
        ViewHolder(binding.root) {

        val context = itemView.context
        val header = binding.imgReplyHeader
        val fromName = binding.txtReplyNameFrom
        val toName = binding.txtReplyNameTo
        val content = binding.txtReplyContent
        val time = binding.txtReplyTime
        val likeView = binding.clayoutReplyLike
        val likeImage = binding.imgReplyLike
        val likeText = binding.txtReplyLike
        val toImg = binding.imgReplyArrow

        fun handle(position: Int) {
            val commentUser = commentUsers[position]
            val comment = commentUser.comment
            val user = commentUser.user

            user.headUrl?.let {
                loadImage(context, it, header)
            }

            val contentBuilder = QqEmoticons.parseAndShowEmotion(context, comment.content)
            content.text = contentBuilder

            time.text = TimeUtils.descriptiveData(comment.commitTime)

            fromName.text = user.userName

            if (comment.type == 2) {
                toImg.visibility = View.GONE
                toName.visibility = View.GONE
            } else {
                toImg.visibility = View.VISIBLE
                toName.visibility = View.VISIBLE
                toName.text = comment.toUserName
            }
        }
    }


}