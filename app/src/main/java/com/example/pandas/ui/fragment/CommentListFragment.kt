package com.example.pandas.ui.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.bean.ReplyInfo
import com.example.pandas.biz.interaction.CommentsListener
import com.example.pandas.biz.manager.KeyboardManager
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentCommentListBinding
import com.example.pandas.ui.adapter.CommentListAdapter
import com.example.pandas.ui.adapter.decoration.CommentItemDecoration
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @description: 弹幕列表
 * @author: dongyiming
 * @date: 6/9/22 4:53 下午
 * @version: v1.0
 */
public class CommentListFragment : BaseFragment<VideoViewModel, FragmentCommentListBinding>(),
    CommentListAdapter.ItemClickListener {

    private var commentId: Int? = null
    private var commentListener: CommentsListener? = null
    private var loadingPopup: LoadingPopupView? = null
    private var replyInfo: ReplyInfo? = null
    private var isKeyBoardShow = false

    private val mAdapter: CommentListAdapter by lazy { CommentListAdapter(mutableListOf(), this) }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    private val km: KeyboardManager by lazy { KeyboardManager(mActivity) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CommentsListener) {
            commentListener = context as CommentsListener
        } else {
            throw RuntimeException("$context must implement CommentsListener")
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        commentId = requireArguments().getInt("commentId")
        val paddingBottom = mActivity.resources.getDimension(R.dimen.common_lh_10_dimens).toInt()
        binding.recyclerLayout.init(
            CommentItemDecoration(paddingBottom),
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    commentId?.let {
                        mViewModel.getCommentReply(false, it)
                    }
                }
            })
        binding.swipRefresh.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                commentId?.let {
                    mViewModel.getCommentReply(true, it)
                }
            }
        }
        binding.btnClose.setOnClickListener {
            commentListener?.closeCommentFragment()
        }

        val color1 = ContextCompat.getColor(mActivity, R.color.color_name_vip)
        val color2 = ContextCompat.getColor(mActivity, R.color.silver)
        binding.editVideo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                s?.let {
                    if (it.isNotEmpty()) {
                        binding.txtCommentSend.setTextColor(color1)
                    } else {
                        binding.txtCommentSend.setTextColor(color2)
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        km.setOnSoftKeyBoardChangeListener(object :
            KeyboardManager.OnSoftKeyBoardChangeListener {
            override fun keyBoardShow(height: Int) {
                isKeyBoardShow = true
                binding.imgCommentSmile.visibility = View.GONE
                binding.txtCommentSend.visibility = View.VISIBLE
            }

            override fun keyBoardHide(height: Int) {
                replyInfo = null
                isKeyBoardShow = false
                binding.imgCommentSmile.visibility = View.VISIBLE
                binding.txtCommentSend.visibility = View.GONE
                binding.editVideo.clearFocus()
                binding.editVideo.setText("")
                binding.editVideo.hint = "发一条友善的评论"
            }
        })

        binding.txtCommentSend.setOnClickListener { sendMessage() } //发送弹幕
    }

    override fun createObserver() {

        mViewModel.commentReply.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.update(true, it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.update(false, it.listData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipRefresh.isRefreshing = false
        }

        mViewModel.createReply.observe(viewLifecycleOwner) {

            binding.recyclerLayout.scrollToPosition(2)
            loadingPopup?.dismiss()
            mAdapter.addComment(it)
            km.hideKeyBoard(mActivity, binding.editVideo)

        }
    }

    override fun firstOnResume() {
        commentId?.let {
            mViewModel.getCommentReply(true, it)
        }
    }

    private fun sendMessage() {
        binding.editVideo.text?.let {
            val content = it.toString()
            if (content.isNotEmpty()) {
                if (loadingPopup == null) {
                    loadingPopup = XPopup.Builder(mActivity).dismissOnBackPressed(true)
                        .isLightNavigationBar(true)
                        .isViewMode(false)
                        .asLoading(null, R.layout.layout_sending)
                    loadingPopup!!.show()
                } else {
                    loadingPopup!!.show()
                }
                if (replyInfo == null) {
                    val commentUser = mAdapter.getItemPisition(0)
                    val comment = commentUser.comment
                    val user = commentUser.user
                    mViewModel.saveReply(
                        ReplyInfo(
                            comment.commentId,
                            comment.videoCode,
                            2,
                            user.userName!!,
                            user.userCode
                        ), content
                    )
                } else {
                    mViewModel.saveReply(replyInfo!!, content)
                }
            }
        }
    }

    companion object {

        fun newInstance(commentId: Int): CommentListFragment {
            val args = Bundle().apply {
                putInt("commentId", commentId)
            }
            val fragment = CommentListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun reply(reply: ReplyInfo) {
        this.replyInfo = reply
        binding.editVideo.isFocusable = true
        binding.editVideo.isFocusableInTouchMode = true
        binding.editVideo.requestFocus()
        binding.editVideo.hint = "回复 @${reply.replyUserName} :"
        if (!isKeyBoardShow) {//可以加edit已经获取了焦点
            km.showKeyBoard(mActivity, binding.editVideo)
        }
    }

    override fun onPause() {
        super.onPause()
        km.ondestory()
        loadingPopup = null
        isKeyBoardShow = false
    }
}