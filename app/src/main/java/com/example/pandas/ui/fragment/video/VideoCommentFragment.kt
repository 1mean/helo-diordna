package com.example.pandas.ui.fragment.video

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
import com.example.pandas.databinding.FragmentCommentBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.adapter.CommentAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView


/**
 * @description: video评论
 * @author: dongyiming
 * @date: 12/29/21 11:42 下午
 * @version: v1.0
 */
public class VideoCommentFragment : BaseFragment<VideoViewModel, FragmentCommentBinding>(),
    CommentAdapter.OnCommentClickListener {

    private var code = -1

    private var loadingPopup: LoadingPopupView? = null

    private var replyInfo: ReplyInfo? = null

    private var commentListener: CommentsListener? = null

    private val km: KeyboardManager by lazy { KeyboardManager(mActivity) }

    private val mAdapter: CommentAdapter by lazy { CommentAdapter(mutableListOf(), this) }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CommentsListener) {
            commentListener = context as CommentsListener
        } else {
            throw RuntimeException("$context must implement CommentsListener")
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        val video = mActivity.intent.getParcelableExtra<PetVideo>("petVideo")
        video?.let {
            code = it.code
        }
        binding.rvComment.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getCommentsByOrder(code, false, mAdapter.getOrder())
                }
            })

        binding.refreshComment.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.rvComment.isRefreshing(true)
                mViewModel.getCommentsByOrder(code, true, mAdapter.getOrder())
            }
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
                binding.imgCommentSmile.visibility = View.GONE
                binding.txtCommentSend.visibility = View.VISIBLE
            }

            override fun keyBoardHide(height: Int) {
                replyInfo = null
                val content = binding.editVideo.text
                if (content.isNullOrEmpty()) {
                    binding.editVideo.hint = "发一条友善的评论"
                }
                binding.imgCommentSmile.visibility = View.VISIBLE
                binding.txtCommentSend.visibility = View.GONE
                binding.editVideo.clearFocus()
            }
        })

        binding.txtCommentSend.setOnClickListener { sendMessage() } //发送弹幕
    }


    override fun createObserver() {

        mViewModel.comments.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isRefresh -> {
                        mAdapter.update(true, it.listData)
                        binding.rvComment.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.update(false, it.listData)
                    }
                }
                binding.rvComment.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.clayoutComment.visibility = View.VISIBLE
            binding.refreshComment.isRefreshing = false
        }

        mViewModel.createComment.observe(viewLifecycleOwner) {

            if (it.comment.type == 1) {
                binding.rvComment.scrollToPosition(0)
            }
            loadingPopup!!.dismiss()
            mAdapter.addComment(it)
            binding.editVideo.setText("")
            binding.editVideo.hint = "发一条友善的评论"
            km.hideKeyBoard(mActivity, binding.editVideo)
        }
    }

    override fun firstOnResume() {

        binding.refreshComment.isRefreshing = true
        mViewModel.getCommentsByOrder(code, true, false)
    }

    /**
     * isOrderByTime
     *  - true: 当前按照时间排序，切换到按热度排序
     *  - false: 当前按照热度排序，切换到按时间排序
     */
    override fun orderClcik(isOrderByTime: Boolean) {
        binding.refreshComment.isRefreshing = true
        mViewModel.getCommentsByOrder(code, true, !isOrderByTime)
    }

    override fun addItemReply(replyInfo: ReplyInfo) {
        this.replyInfo = replyInfo
        binding.editVideo.isFocusable = true
        binding.editVideo.isFocusableInTouchMode = true
        binding.editVideo.requestFocus()
        binding.editVideo.hint = "回复 @${replyInfo.replyUserName} :"
        km.showKeyBoard(mActivity, binding.editVideo)
    }

    override fun showAllComment(commentId: Int) {
        commentListener?.showCommentsFragment(commentId)
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
                mViewModel.saveComment(code, replyInfo, content)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        km.onDestroy()
        commentListener = null
    }
}