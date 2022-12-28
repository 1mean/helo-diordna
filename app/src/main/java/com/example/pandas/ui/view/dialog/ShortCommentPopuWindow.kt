package com.example.pandas.ui.view.dialog

import ShortCommentAdapter
import ShortReplyCommentAdapter
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.biz.manager.PetManagerCoroutine
import com.example.pandas.biz.manager.SoftInputManager
import com.example.pandas.biz.viewmodel.CommentViewModel
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.core.BottomPopupView
import com.lxj.xpopup.interfaces.SimpleCallback
import kotlinx.coroutines.*


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
public class ShortCommentPopuWindow(private val mContext: Context) : BottomPopupView(mContext),
    ShortCommentAdapter.CommentListener {

    private var videoCode: Int = 0
    private var commentCounts: Int = 0

    private var mViewModel: CommentViewModel? = null
    private var _binding: DialogBottomCommentBinding? = null
    val binding: DialogBottomCommentBinding get() = _binding!!

    private val mAdapter: ShortCommentAdapter by lazy { ShortCommentAdapter(mutableListOf(), this) }
    private var inputPopWindow: ShortInputPopuWindow? = null
    private val mHandler: Handler = Handler(Looper.getMainLooper())
    private var keyBoardManager: SoftInputManager? = null

    private lateinit var txtShortComments: AppCompatTextView
    private lateinit var txtCommentIn: AppCompatTextView
    private lateinit var recyclerView: SwipRecyclerView
    private lateinit var btnSend: AppCompatButton
    private lateinit var inputView: ConstraintLayout

    private var startIndex = 0
    private val pageCount = 21

    private val commentScope = CoroutineScope(Job() + Dispatchers.Main)

    constructor(context: Context, videoCode: Int, commentCounts: Int) : this(context) {
        this.videoCode = videoCode
        this.commentCounts = commentCounts
    }

    override fun getImplLayoutId(): Int = R.layout.dialog_bottom_comment

    override fun onShow() {
        super.onShow()
        txtShortComments.post {
            txtShortComments.text = "${commentCounts}条评论"
        }
    }

    override fun onCreate() {
        super.onCreate()

        txtShortComments = findViewById(R.id.txt_short_comments)
        txtCommentIn = findViewById(R.id.txt_short_comment_in)
        recyclerView = findViewById(R.id.rv_short_comment)
        btnSend = findViewById(R.id.btn_short_comment_send)
        inputView = findViewById(R.id.clayout_short_comment_input)

        recyclerView.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    //mViewModel.getLandScapeData(false)
                    commentScope.launch {
                        val list = PetManagerCoroutine.getPageComments(
                            true,
                            videoCode,
                            startIndex,
                            pageCount
                        )
                        val hasMore = list.size > 20
                        if (hasMore) {
                            startIndex += 20
                            list.removeLast()
                        }
                        mAdapter.loadMore(list)
                        recyclerView.loadMoreFinished(list.isEmpty(), hasMore)
                    }
                }
            })


        commentScope.launch {
            val list = PetManagerCoroutine.getPageComments(true, videoCode, startIndex, pageCount)
            val hasMore = list.size > 20
            if (hasMore) {
                startIndex += 20
                list.removeLast()
            }
            mAdapter.refreshAdapter(list)
            recyclerView.isRefreshing(false)
            recyclerView.loadMoreFinished(list.isEmpty(), hasMore)
        }

        inputView.setOnClickListener {
            //弹出新的弹窗用来输入
            val textBottomPopup = ShortCommentInputPop(mContext)
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
        /*
        mViewModel!!.pageComments.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                binding.rvShortComment.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.rvShortComment.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.rvShortComment.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
        */
    }

    suspend fun getComments() {
        coroutineScope {
            PetManagerCoroutine.getPageComments(true, videoCode, startIndex, pageCount)
        }
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
        isRefreshing: Boolean,
        position: Int,
        videoCode: Int,
        commentId: Int,
        startIndex: Int
    ) {
        commentScope.launch {
            val list = PetManagerCoroutine.getPageReplyComments(videoCode, commentId, startIndex, 3)
            val holder =
                recyclerView.findViewHolderForAdapterPosition(position) as? ShortCommentAdapter.ReplyCommentViewHolder
            holder?.let {
                it.replyRecyclerView.adapter?.let { adapter ->
                    if (adapter is ShortReplyCommentAdapter) {
                        (adapter as ShortReplyCommentAdapter).refreshAdapter(list)
                    }
                }
                it.comments.text = "展开更多回复"
            }
        }
    }

    /*private fun showCommentPopuWindow() {
        mHandler.postDelayed({
            if (inputPopWindow == null) {
                inputPopWindow = ShortInputPopuWindow(
                    activity!!,
                    binding.editShortComment.text.toString(),
                    object :
                        ShortInputPopuWindow.ShortPopuListener {
                        override fun openEmoji(view: View) {
                            Log.e("1mean", "隐藏软键盘")
                            keyBoardManager?.hideKeyBoard(activity!!, view)
                        }

                        override fun sendComment(comment: String) {
                            //sendVideoComment(comment)
                        }

                        override fun dissmiss(comment: String) {
                            if (comment.isNotEmpty()) {
                                mHandler.post {
                                    val message =
                                        QqEmoticons.parseAndShowEmotion(
                                            context!!,
                                            comment
                                        )
                                    binding.editShortComment.text =
                                        Editable.Factory.getInstance().newEditable(message)
                                    binding.btnShortCommentSend.visibility = View.VISIBLE
                                }
                            }
                        }
                    })
            }
//            inputPopWindow!!.setBackDark().onShow(this@ShortVideoActivity.currentFocus!!)

            inputPopWindow!!.setBackDark().onShow(this.view!!)
            keyBoardManager?.showKeyBoard(activity!!, this.view!!)
        }, 200)
    }*/

}