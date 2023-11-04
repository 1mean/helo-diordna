package com.example.pandas.ui.view.popuwindow

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
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.CommentWindowListener
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.biz.interaction.ShortCommentListener
import com.example.pandas.biz.manager.ShortCommentManage
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.adapter.ShortCommentAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BottomPopupView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


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
    private var mListener: CommentWindowListener? = null

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
    private var clickPosition: Int = -1
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    private var currentVideoComment: VideoComment? = null
    private val commentScope = CoroutineScope(Job() + Dispatchers.Main)
    private val mAdapter: ShortCommentAdapter by lazy {
        ShortCommentAdapter(
            mutableListOf(),
            this
        )
    }

    constructor(
        context: Context,
        videoCode: Int,
        commentCounts: Int,
        mListener: CommentWindowListener
    ) : this(context) {
        this.videoCode = videoCode
        this.commentCounts = commentCounts
        this.commentManage = ShortCommentManage(context, commentScope)
        this.mListener = mListener
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

        recyclerView.init(null, mAdapter, listener = this)
        recyclerView.setIntercept(false)
        inputView.setOnClickListener { showInputToReply(null, 0, false) }
        emotionView.setOnClickListener { showInputToReply(null, 0, true) }
        eitView.setOnClickListener { showInputToReply(null, 0, false) }
        btnSend.setOnClickListener { sendComment(txtCommentIn.text.toString()) }

        txtShortComments.post { txtShortComments.text = "${commentCounts}条评论" }
    }

    var isFirst = true

    //显示之后，相当于onresume
    override fun onShow() {
        super.onShow()
        if (isFirst) {//防止每次都重新加载数据
            commentManage!!.getPageComment(videoCode, startIndex, pageCount, this)
            isFirst = false
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

    /**
     * <弹出软键盘，并进行发送评论>
     *     弹出条件：
     *        1，点击底部输入框，计划输入一级评论
     *        2，回复一级或二级评论，输入的是二级或三级评论
     *
     *     几种情况
     *        1，当回复某人并已经输入了内容，未发送，点击取消软键盘，滑动消息列表后，再点击输入弹出软键盘，里面仍然是上一条回复其他人的消息
     * @param:
     * @return:
     * @author: dongyiming
     * @date: 7/11/23 9:43 PM
     * @version: v1.0
     */
    override fun showInputToReply(
        commentUser: CommentAndUser?,
        position: Int,
        showEmotion: Boolean
    ) {

        Log.e("1mean", "position111: $position")
        this.clickPosition = position
        //如果再方法调用前，输入框就已经有内容了，这种情况考虑的就比较多了
        val inputContent = txtCommentIn.text.toString()
        if (inputContent.isNotEmpty()) {
            if (commentUser == null) {//直接点击的输入框，仍然保持之前的currentVideoComment

            } else {//判断和上一次回复的是否是同一人
                val currentTopCommentId = currentVideoComment?.topCommentId
                val newReplyTopCommentId = commentUser.comment.topCommentId
                //第二次创建时，textBottomPopup已存在，只需要修改输入框里面的内容,也通过content是否为""来判断
                //   1,注意当输入框已经有内容时，需要处理是否和上一次是回复的同一条消息
                //          -   如果是的，就不需要改变，还是同样显示
                //          -   如果是回复其他的人，需要修改输入框为 "回复 @xxx"
                if (currentTopCommentId != newReplyTopCommentId) {//回复的不是同一人，需要更新输入框的内容
                    //一、弹出输入框
                    //   问题：如何让当前window输入框内容和弹出的输入框里的内容保持一致
                    if (textBottomPopup == null) {
                        textBottomPopup =
                            ShortReplyPopuWindow(mContext, commentUser.comment.toUserName, this)
                    } else {
                        textBottomPopup!!.updateHint(commentUser.comment.toUserName)
                    }
                    currentVideoComment = commentUser.comment
                }
            }
        } else {//在点击回复之前，输入框里就没有任何内容
            if (commentUser == null) {//输入一级评论
                if (textBottomPopup == null) {
                    textBottomPopup = ShortReplyPopuWindow(mContext, "", this)
                } else {
                    textBottomPopup!!.clearInput()
                }
            } else {//回复的二级/三级评论，显示 "回复@xxx"
                if (textBottomPopup == null) {
                    textBottomPopup =
                        ShortReplyPopuWindow(mContext, commentUser.comment.toUserName, this)
                } else {
                    textBottomPopup!!.updateHint(commentUser.comment.toUserName)
                }
                currentVideoComment = commentUser.comment
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

        val comment =
            if (currentVideoComment == null || currentVideoComment!!.type == 1) {//自己发送的一级弹幕
                VideoComment(
                    videoCode = videoCode,
                    fromUserCode = AppInfos.AUTHOR_ID,
                    fromUserName = AppInfos.AUTHOR_NAME,
                    type = 1,
                    commitTime = System.currentTimeMillis(),
                    content = message,
                )
            } else {//发送的二级三级弹幕
                currentVideoComment!!.run {
                    content = message
                    commitTime = System.currentTimeMillis()
                }
                currentVideoComment!!
            }
        commentManage?.sendComment(comment, this)

        Log.e("1mean", "currentVideoComment: $currentVideoComment")
        if (!recyclerView.isVisible) {
            recyclerView.visibility = View.VISIBLE
        }
    }

    /**
     * 最难的部分：处理二级和三级评论
     */
    override fun sendCommentResult(videoComment: VideoComment) {
        val commentUser = CommentAndUser(
            comment = videoComment, user = User(
                userCode = AppInfos.AUTHOR_ID,
                userName = AppInfos.AUTHOR_NAME,
                headUrl = AppInfos.HEAD_URL,
                ipAddress = "湖北"
            )
        )
        Log.e("1mean", "result: $videoComment")
        if (videoComment.type == 1) {
            mAdapter.loadOneCmMessage(commentUser)
            recyclerView.smoothScrollToPosition(0)
        } else {
            val holder =
                recyclerView.findViewHolderForAdapterPosition(clickPosition) as? ShortCommentAdapter.ReplyCommentViewHolder
            Log.e("1mean", "holder: $holder , clickPosition:$clickPosition")
            holder?.loadOne(commentUser, clickPosition)
        }
        this.currentVideoComment = null
        commentCounts += 1
        this.clickPosition = -1

        Log.e("2mean","mListener:$mListener, commentCounts:$commentCounts")
        mListener?.updateComments(commentCounts)
        mHandler.post {
            txtShortComments.text = "${commentCounts}条评论"
        }
    }

    override fun updateComment(comment: VideoComment) {
        commentManage?.updateComment(comment)
    }

    override fun getPageComments(data: UIDataWrapper<CommentAndUser>) {

        Log.e("1mean", "getPageComments")
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
            recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter.ReplyCommentViewHolder
        holder?.loadReplyData(position, list)
    }

    override fun onLoadMore() {
        commentManage!!.getPageComment(videoCode, startIndex, pageCount, this)
    }

    fun addComment(comment: VideoComment) {
        val user = User(
            userCode = AppInfos.AUTHOR_ID,
            userName = AppInfos.AUTHOR_NAME,
            headUrl = AppInfos.HEAD_URL
        )
        mAdapter.addOneMessage(CommentAndUser(comment, user))
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
            //this.clickPosition = -1   //sendingResult需要使用到这个position
        } else {//2.输入内容后，关闭输入框
            if (comment.isNotEmpty()) {
                val inputStr = txtCommentIn.text.toString()
                if (inputStr != comment) {
                    mHandler.post {
                        val message = QqEmoticons.parseAndShowEmotion(mContext, comment)
                        txtCommentIn.text = Editable.Factory.getInstance().newEditable(message)
                        btnSend.visibility = View.VISIBLE

                        currentVideoComment?.content = txtCommentIn.text.toString()
                    }
                }
            } else {
                recoverInputView()
                this.currentVideoComment = null
                Log.e("1mean", "1222222")
                this.clickPosition = -1
            }
        }
    }

    private fun recoverInputView() {
        txtCommentIn.text = null
        txtCommentIn.hint = resources.getString(R.string.str_hint_edit_short)
        btnSend.visibility = View.GONE
    }
}