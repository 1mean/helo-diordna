package com.example.pandas.ui.view.dialog

import ShortCommentAdapter
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.biz.manager.ShortCommentManage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BottomPopupView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * <设置圆角和固定高度>
 * - 圆角
 *  - 在oncreate()里设置setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialog)背景透明，不会遮挡圆角
 *  - 设置background圆角
 * - 高度
 *  - 具体数值和设置peekheight都没用，必须是layout里面控件确实填充到这个高度
 *
 *  - show(FragmentManager manager, String tag)
 *  - onCreate
 *  - onCreateDialog(Bundle savedInstanceState)
 *  - onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
 *  - onViewCreated
 *  - onStart
 *  - mDialog.show()
 *  - onResume
 *
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class ShortRightPopuWindow(private val mContext: Context) : BottomPopupView(mContext),
    ShortCommentAdapter.CommentListener, ICommentCallback, SwipRecyclerView.ILoadMoreListener,
    ShortReplyPopuWindow.CommentInputListener {

    private var videoCode: Int = 0
    private var commentCounts: Int = 0

    var textBottomPopup: ShortReplyPopuWindow? = null
    private var _binding: DialogBottomCommentBinding? = null
    val binding: DialogBottomCommentBinding get() = _binding!!

    private var commentManage: ShortCommentManage? = null

    private lateinit var txtShortComments: AppCompatTextView
    private lateinit var txtCommentIn: AppCompatTextView
    private lateinit var recyclerView: SwipRecyclerView
    private lateinit var btnSend: AppCompatButton
    private lateinit var inputView: ConstraintLayout
    private lateinit var progress: ProgressBar
    private lateinit var emotionView: AppCompatImageButton
    private lateinit var eitView: AppCompatImageButton

    private var startIndex = 0
    private val pageCount = 21
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    private var commentUser: CommentAndUser? = null
    private val commentScope = CoroutineScope(Job() + Dispatchers.Main)
    private val mAdapter: ShortCommentAdapter by lazy { ShortCommentAdapter(mutableListOf(), this) }

    constructor(context: Context, videoCode: Int, commentCounts: Int) : this(context) {
        this.videoCode = videoCode
        this.commentCounts = commentCounts
        this.commentManage = ShortCommentManage(context, commentScope)
    }

    override fun getImplLayoutId(): Int = R.layout.dialog_bottom_comment

    override fun onCreate() {
        super.onCreate()

        txtShortComments = findViewById(R.id.txt_short_comments)
        txtCommentIn = findViewById(R.id.txt_short_comment_in)
        recyclerView = findViewById(R.id.rv_short_comment)
        btnSend = findViewById(R.id.btn_short_comment_send)
        inputView = findViewById(R.id.clayout_short_comment_input)
        progress = findViewById(R.id.pbar_right_comment)
        emotionView = findViewById(R.id.btn_right_comment_emo)
        eitView = findViewById(R.id.img_right_comment_eit)

        txtShortComments.post { txtShortComments.text = "${commentCounts}条评论" }

        recyclerView.init(null, mAdapter, listener = this)
        inputView.setOnClickListener { inputClick(false) }
        emotionView.setOnClickListener { inputClick(true) }
        eitView.setOnClickListener { inputClick(false) }
        btnSend.setOnClickListener { sendComment(txtCommentIn.text.toString()) }
    }

    //显示之后，相当于onresume
    override fun onShow() {
        super.onShow()
        commentManage!!.getPageComment(videoCode, startIndex, pageCount, this)
    }

    private fun inputClick(showEmotion: Boolean) {
        val content = txtCommentIn.text.toString()
        showReplyDialog(showEmotion, "")
    }

    private fun showReplyDialog(showEmotion: Boolean, fromName: String) {

        //弹出新的弹窗用来输入
        if (textBottomPopup == null) {
            textBottomPopup = ShortReplyPopuWindow(mContext, fromName, this)
        } else {
            textBottomPopup!!.updateHint(fromName)
        }
        XPopup.setShadowBgColor(ContextCompat.getColor(mContext, R.color.color_bg_bottom_dialog))
        val builder = XPopup.Builder(mContext)
        builder.enableDrag(false).animationDuration(100)//动画时长，不设置时长，就是默认的301ms，效果会很差
        if (showEmotion) {
            builder.autoOpenSoftInput(false)
                .autoFocusEditText(false)
                .asCustom(textBottomPopup)
                .show()
            textBottomPopup!!.postDelayed({
                textBottomPopup!!.showEmotion()
            }, 300)
        } else {
            builder.autoOpenSoftInput(true)
                .autoFocusEditText(true)
                .asCustom(textBottomPopup)
                .show()
        }
    }


    override fun loadMore(
        startIndex: Int,
        pageCount: Int,
        position: Int,
        videoCode: Int,
        commentId: Int
    ) {
        commentScope.launch {
            //val commentIds = 33
            val list = PetManagerCoroutine.getPageReplyComments(
                videoCode,
                commentId,
                startIndex,
                pageCount
            )
            val holder =
                recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter.ReplyCommentViewHolder
            holder?.loadReplyData(position, list)
        }
    }

    /**
     * 这里回复的都是2级和3级弹幕
     */
    override fun reply(commentUser: CommentAndUser) {

        showReplyDialog(false, commentUser.comment.toUserName)
        this.commentUser = commentUser

//        val textBottomPopup = ShortReplyPopuWindow(
//            mContext,
//            commentUser.comment.toUserName,
//            object : ShortReplyPopuWindow.CommentInputListener {
//                override fun sendComment(message: String) {
//                    commentCounts += 1
//                    commentUser.comment.run {
//                        commitTime = System.currentTimeMillis()
//                        content = message
//                    }
//                    val holder =
//                        recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter.ReplyCommentViewHolder
//                    holder?.loadOne(commentAndUser, position)
//                }
//            })
//        XPopup.Builder(mContext)
//            .autoOpenSoftInput(true)
//            .autoFocusEditText(true)
//            .setPopupCallback(object : SimpleCallback() {
//                override fun onShow(popupView: BasePopupView) {
//
//                }
//
//                override fun onDismiss(popupView: BasePopupView) {
//                    val comment: String = textBottomPopup.getComment()
//                    if (comment.isNotEmpty()) {
//
//                    }
//                }
//            })
//            .asCustom(textBottomPopup)
//            .show()
    }

    override fun updateComment(comment: VideoComment) {
    }

    override fun getPageComments(data: UIDataWrapper<CommentAndUser>) {

        if (startIndex == 0) {//刷新
            if (!data.isEmpty) {
                recyclerView.visibility = View.VISIBLE
                mAdapter.refreshAdapter(data.listData)
            } else {

            }
            progress.visibility = View.GONE
        } else {//加载更多
            mAdapter.loadMore(data.listData)
        }
        if (data.hasMore) {
            startIndex += 20
        }
        recyclerView.loadMoreFinished(data.isEmpty, data.hasMore)

    }

    override fun onLoadMore() {
        commentManage!!.getPageComment(videoCode, startIndex, pageCount, this)
    }

    /**
     * 发送消息：1，reply消息回调  2，当前界面底部的发送
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 6/9/23 1:09 AM
     * @version: v1.0
     */
    override fun sendComment(message: String) {

        if (message.isEmpty()) {
            return
        }

        val comment = VideoComment(
            videoCode = videoCode,
            fromUserCode = AppInfos.AUTHOR_ID,
            type = 1,
            commentId = System.currentTimeMillis().toInt(),
            commitTime = System.currentTimeMillis(),
            content = message
        )
        val user = User(
            userCode = AppInfos.AUTHOR_ID,
            userName = AppInfos.AUTHOR_NAME,
            headUrl = AppInfos.HEAD_URL
        )
        val commentAndUser = CommentAndUser(comment, user)
        mAdapter.loadOne(commentAndUser, 0, 1)
        recyclerView.scrollToPosition(0)
    }

    /**
     * 输入弹窗关闭后
     */
    override fun dissmiss(comment: String) {

        if (comment.isNotEmpty()) {
            mHandler.post {
                val message = QqEmoticons.parseAndShowEmotion(mContext, comment)
                txtCommentIn.text = Editable.Factory.getInstance().newEditable(message)
                btnSend.visibility = View.VISIBLE
            }
        } else {
            txtCommentIn.text = null
            txtCommentIn.hint = resources.getString(R.string.str_hint_edit_short)
            btnSend.visibility = View.GONE
        }
    }
}