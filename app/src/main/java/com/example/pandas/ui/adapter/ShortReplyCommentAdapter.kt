import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.android_sqlite.entity.CommentAndUser
import com.android.android_sqlite.entity.User
import com.android.android_sqlite.entity.VideoComment
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.AdapterItemCommentReplyBinding
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.ui.ext.startUserInfoActivity

/**
 * @description: ShortReplyCommentAdapter
 * @author: dongyiming
 * @date: 12/20/22 4:15 AM
 * @version: v1.0
 */
public class ShortReplyCommentAdapter(
    private val commentUsers: MutableList<CommentAndUser>,
    val listener: ReplyItemClickListener
) :
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
        val address = binding.txtAddressReplyComment
        val likeLayout = binding.clayoutReplyLike
        val likeView = binding.imgReplyLike
        val likes = binding.txtReplyLike
        val toImg = binding.imgReplyArrow

        fun handle(position: Int) {
            val commentUser = commentUsers[position]
            val comment = commentUser.comment
            val user = commentUser.user

            user.headUrl?.let {
                loadImage(context, it, header)
            }

            if (user.ipAddress != null) {
                address.text = StringBuilder(" · ").append(user.ipAddress).toString()
            } else {
                val addressString = AppInfos.provinces.random()
                address.text = StringBuilder(" · ").append(addressString).toString()
            }

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
                        context,
                        R.color.color_txt_right_comment_item_like
                    )
                )
            } else {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.setTextColor(
                    ContextCompat.getColor(
                        context,
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
                            context,
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
                            context,
                            R.color.color_txt_right_comment_item_liked
                        )
                    )
                    comment.likeNum += 1
                    likes.visibility = View.VISIBLE
                    likes.text = comment.likeNum.toString()
                }
                comment.like = !comment.like
                //listener.updateComment(comment)
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

            itemView.setOnClickListener {
                listener.reply(
                    convertCommentAndUser(
                        comment.videoCode,
                        comment.topCommentId,
                        user.userCode,
                        user.userName!!,
                        3,
                        comment.content
                    )
                )
            }

            fromName.setOnClickListener {
                startUserInfoActivity(context, user.userCode)
            }

            toName.setOnClickListener {
                startUserInfoActivity(context, user.userCode)
            }
        }
    }

    interface ReplyItemClickListener {
        fun reply(commentUser: CommentAndUser)
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