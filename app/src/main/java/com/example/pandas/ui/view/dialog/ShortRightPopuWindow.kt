package com.example.pandas.ui.view.dialog

import ShortCommentAdapter
import ShortCommentAdapter1
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.pandas.R
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.biz.interaction.ShortCommentListener
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.biz.manager.ShortCommentManage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
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
    ShortCommentListener, ICommentCallback, SwipRecyclerView.ILoadMoreListener,
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
    private val mAdapter: ShortCommentAdapter1 by lazy {
        ShortCommentAdapter1(
            mutableListOf(),
            this
        )
    }

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

    /**
     * 弹出回复弹窗
     * 1,第一次创建，只可能显示空的输入/回复谁，通过content是否为""来判断
     * 2,第二次创建时，textBottomPopup已存在，只需要修改输入框里面的内容,也通过content是否为""来判断
     *      - 传入的content为空，说明仍然按原来的内容，不需要修改.仍然显示默认的hint或是默认的内容
     *      - 传入的content不为空，显示为回复@
     */
    private fun showReplyDialog(showEmotion: Boolean, content: String) {

        if (textBottomPopup == null) {//第一次创建，只可能显示空的输入/回复谁，通过content是否为""来判断
            textBottomPopup = ShortReplyPopuWindow(mContext, content, this)
        } else {//第二次创建时，textBottomPopup已存在，只需要修改输入框里面的内容,也通过content是否为""来判断
            val inputContent = txtCommentIn.text.toString()
            if (content.isEmpty()) {//传入的content为空，说明仍然按原来的内容，不需要修改
                //不做处理，仍然显示默认的hint或是默认的内容
            } else {//传入的content不为空，显示为回复@
                textBottomPopup!!.updateHint(content)
            }
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
        topCommentPosition: Int,
        startIndex: Int,
        pageCount: Int,
        videoCode: Int,
        commentId: Int
    ) {
        commentManage!!.getPageReply(
            topCommentPosition,
            startIndex,
            pageCount,
            videoCode,
            commentId,
            this
        )
    }

    private var replyPosition: Int = 0

    /**
     * 这里回复的都是2级和3级弹幕
     * 回复的如果是同一条消息，输入的内容需要保留。不是回复的同一人，输入内容才需要清空
     */
    override fun reply(commentUser: CommentAndUser, position: Int) {

        Log.e("11mean","position: $position")
        replyPosition = position
        if (this.commentUser == null) {
            this.commentUser = commentUser
            showReplyDialog(false, commentUser.comment.toUserName)
        } else {
            if (this.commentUser!!.comment.toUserCode == commentUser.comment.toUserCode
                && this.commentUser!!.comment.content == commentUser.comment.content
            ) {//两次回复的是同一个人的同一条消息，不做处理，仍然保持原来的输入框内容
                showReplyDialog(false, "")
            } else {
                this.commentUser = commentUser
                showReplyDialog(false, commentUser.comment.toUserName)
            }
        }
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

    override fun getPageReply(position: Int, list: MutableList<CommentAndUser>) {
        val holder =
            recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter1.ReplyCommentViewHolder
        holder?.loadReplyData(position, list)
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

        if (message.isEmpty()) return
        Log.e("comment", "commentUser:$commentUser")
        if (commentUser == null) {//自己发送的一级弹幕
            val commentUser = commentManage!!.buildCommentUser(videoCode, message)
            Log.e("comment", "commentUser1:$commentUser")
            mAdapter.loadOneCmMessage(commentUser)
            recyclerView.scrollToPosition(0)
        } else {//发送的二级弹幕
            val commentUser = commentManage!!.buildCommentUser(commentUser!!, message)
            val holder =
                recyclerView.findViewHolderForAdapterPosition(replyPosition) as? ShortCommentAdapter1.ReplyCommentViewHolder
            holder?.loadOne(commentUser, replyPosition)
        }
        if (!recyclerView.isVisible) {
            recyclerView.visibility = View.VISIBLE
        }
        recoverInputView()
        textBottomPopup?.clearInput()
    }

    /**
     * 输入弹窗关闭后，两种情况
     *
     * 1- 清空输入框
     * 2- 输入框设置输入内容
     */
    override fun dissmiss(comment: String, isSending: Boolean) {
        if (isSending) {//1.发送完成后，关闭输入框
            recoverInputView()
            this.commentUser = null
        } else {//2.输入内容后，关闭输入框
            if (comment.isNotEmpty()) {
                mHandler.post {
                    val message = QqEmoticons.parseAndShowEmotion(mContext, comment)
                    txtCommentIn.text = Editable.Factory.getInstance().newEditable(message)
                    btnSend.visibility = View.VISIBLE
                }
            } else {
                recoverInputView()
            }
        }
    }

    private fun recoverInputView() {
        txtCommentIn.text = null
        txtCommentIn.hint = resources.getString(R.string.str_hint_edit_short)
        btnSend.visibility = View.GONE
    }
}