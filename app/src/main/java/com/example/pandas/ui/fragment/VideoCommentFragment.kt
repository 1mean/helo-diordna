package com.example.pandas.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.manager.KeyboardManager
import com.example.pandas.biz.viewmodel.VideoViewModel
import com.example.pandas.databinding.FragmentCommentBinding
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

    private var loadingPopup: LoadingPopupView? = null

    private val mAdapter: CommentAdapter by lazy { CommentAdapter(mutableListOf(), this) }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        val paddingTop =
            mActivity.resources.getDimension(R.dimen.dimen_comment_item_padding_top).toInt()
        val paddingBottom =
            mActivity.resources.getDimension(R.dimen.dimen_comment_item_padding_bottom).toInt()

        binding.rvComment.init(
            null,
            mAdapter,
            LinearLayoutManager(context),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getComments(false)
                }
            })

        binding.refreshComment.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.rvComment.isRefreshing(true)
                mViewModel.getComments(true)
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

        val km = KeyboardManager(mActivity)
        km.setListener(object :
            KeyboardManager.OnSoftKeyBoardChangeListener {
            override fun keyBoardShow(height: Int) {
                binding.imgCommentSmile.visibility = View.GONE
                binding.txtCommentSend.visibility = View.VISIBLE
            }

            override fun keyBoardHide(height: Int) {
                binding.imgCommentSmile.visibility = View.VISIBLE
                binding.txtCommentSend.visibility = View.GONE
                binding.editVideo.clearFocus()
                binding.editVideo.setText("")
            }
        })

        binding.txtCommentSend.setOnClickListener {

            Log.e("asdadasdasd", "发送成功")
            binding.editVideo.text?.let {
                val content = it.toString()
                if (content.isNotEmpty()) {
                    if (loadingPopup == null) {
                        loadingPopup = XPopup.Builder(mActivity).dismissOnBackPressed(false)
                            .isLightNavigationBar(true)
                            .isViewMode(false)
                            .asLoading(null, R.layout.layout_sending)
//                            .asLoading("加载中") as LoadingPopupView
                        loadingPopup!!.show()

                    } else {
                        loadingPopup!!.show()
                    }
                    loadingPopup!!.postDelayed({
                        mViewModel.createComment(content)
                    }, 300)
                }
            }
        }
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

            mAdapter.sendComment(it)
            loadingPopup!!.dismiss()
            //km.hideKeyBoard(mActivity, mActivity.window.decorView)

        }
    }

    override fun firstOnResume() {

        binding.refreshComment.isRefreshing = true
        mViewModel.getComments(true)
    }

    override fun orderClcik(orderMode: Int) {
    }
}