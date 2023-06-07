package com.example.pandas.ui.view.dialog

import ShortCommentAdapter
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.UIDataWrapper
import com.example.pandas.biz.interaction.ICommentCallback
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.biz.manager.ShortCommentManage
import com.example.pandas.biz.manager.SoftInputManager
import com.example.pandas.biz.viewmodel.CommentViewModel
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.sql.entity.CommentAndUser
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.core.BottomPopupView
import com.lxj.xpopup.interfaces.SimpleCallback
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
    ShortCommentAdapter.CommentListener, ICommentCallback, SwipRecyclerView.ILoadMoreListener {

    private var videoCode: Int = 0
    private var commentCounts: Int = 0

    private var mViewModel: CommentViewModel? = null
    private var _binding: DialogBottomCommentBinding? = null
    val binding: DialogBottomCommentBinding get() = _binding!!

    private val mAdapter: ShortCommentAdapter by lazy { ShortCommentAdapter(mutableListOf(), this) }
    private var inputPopWindow: ShortBottoomPopuWindow? = null
    private val mHandler: Handler = Handler(Looper.getMainLooper())
    private var keyBoardManager: SoftInputManager? = null
    private var commentManage: ShortCommentManage? = null

    private lateinit var txtShortComments: AppCompatTextView
    private lateinit var txtCommentIn: AppCompatTextView
    private lateinit var recyclerView: SwipRecyclerView
    private lateinit var btnSend: AppCompatButton
    private lateinit var inputView: ConstraintLayout
    private lateinit var progress: ProgressBar

    private var startIndex = 0
    private val pageCount = 21

    private val commentScope = CoroutineScope(Job() + Dispatchers.Main)

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

        txtShortComments.post {
            txtShortComments.text = "${commentCounts}条评论"
        }

        recyclerView.init(null, mAdapter, listener = this)

        inputView.setOnClickListener {
            val content = txtCommentIn.text.toString()
            //弹出新的弹窗用来输入
            val textBottomPopup = ShortReplyPopuWindow(mContext, content,
                object : ShortReplyPopuWindow.CommentInputListener {
                    override fun sendComment(message: String) {
                        commentCounts += 1
                        val comment = VideoComment(
                            videoCode = videoCode,
                            fromUserCode = AppInfos.AUTHOR_ID,
                            type = 1,
                            commentId = commentCounts,
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
                })
            XPopup.Builder(mContext)
                .autoOpenSoftInput(true)
                .autoFocusEditText(true)
                .setPopupCallback(object : SimpleCallback() {
                    override fun onShow(popupView: BasePopupView) {

                    }

                    override fun onDismiss(popupView: BasePopupView) {
                        val comment: String = textBottomPopup.getComment()
                        if (comment.isNotEmpty()) {

                        }
                    }
                })
                .asCustom(textBottomPopup)
                .show()
        }
    }

    //显示之后，相当于onresume
    override fun onShow() {
        super.onShow()
        commentManage!!.getPageComment(videoCode, startIndex, pageCount, this)
    }

    private fun showSheetDialog() {

        mHandler.postDelayed({
            val dialog = CommentReplySheetDialog(context!!,
                object : CommentReplySheetDialog.ShortPopuListener {
                    override fun openEmoji(view: View) {
                    }

                    override fun sendComment(comment: String) {
                    }

                    override fun dissmiss(comment: String) {
                    }
                })
            dialog.onShow()

//            keyBoardManager!!.showSoftInput(binding.editShortComment)
//            val imm =
//                binding.editShortComment.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            binding.editShortComment.isFocusable = true
//            binding.editShortComment.isFocusableInTouchMode = true
//            binding.editShortComment.requestFocus()
//            imm.showSoftInput(binding.editShortComment, 0)
            //keyBoardManager!!.showSoftInput(activity!!.window!!.decorView)
        }, 200)
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
    override fun reply(
        fromName: String,
        fromUserCode: Int,
        position: Int,
        commentId: Int,
        videoCode: Int,
        type: Int
    ) {
        val textBottomPopup = ShortReplyPopuWindow(
            mContext,
            fromName,
            object : ShortReplyPopuWindow.CommentInputListener {
                override fun sendComment(message: String) {

                    commentCounts += 1
                    val comment = VideoComment(
                        videoCode = videoCode,
                        topCommentId = commentId,
                        fromUserCode = AppInfos.AUTHOR_ID,
                        toUserCode = fromUserCode,
                        toUserName = fromName,
                        commentId = commentCounts,
                        type = type,
                        commitTime = System.currentTimeMillis(),
                        content = message
                    )
                    val user = User(
                        userCode = AppInfos.AUTHOR_ID,
                        userName = AppInfos.AUTHOR_NAME,
                        headUrl = AppInfos.HEAD_URL
                    )
                    val commentAndUser = CommentAndUser(comment, user)
                    val holder =
                        recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter.ReplyCommentViewHolder
                    holder?.loadOne(commentAndUser, position)
                }
            })
        XPopup.Builder(mContext)
            .autoOpenSoftInput(true)
            .autoFocusEditText(true)
            .setPopupCallback(object : SimpleCallback() {
                override fun onShow(popupView: BasePopupView) {

                }

                override fun onDismiss(popupView: BasePopupView) {
                    val comment: String = textBottomPopup.getComment()
                    if (comment.isNotEmpty()) {

                    }
                }
            })
            .asCustom(textBottomPopup)
            .show()
    }

    override fun getPageComments(data: UIDataWrapper<CommentAndUser>) {

        if (startIndex == 0) {//刷新
            if (!data.isEmpty) {
                progress.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE

                mAdapter.refreshAdapter(data.listData)
            }
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
}