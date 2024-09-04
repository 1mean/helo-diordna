package com.example.pandas.ui.fragment.search

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.adapter.SearchUserAdapter
import com.example.pandas.ui.ext.*
import com.example.pandas.ui.view.dialog.UnAttentionBottomSheetDialog
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.lxj.xpopup.XPopup
import kotlinx.coroutines.launch

/**
 * @description: SearchUserFragment
 * @author: dongyiming
 * @date: 8/25/24 2:27 AM
 * @version: v1.0
 */
public class SearchUserFragment : BaseFragment<SearchViewModel, LayoutSwipRefreshBinding>() {

    private var unAttentionDialog: UnAttentionBottomSheetDialog? = null

    private var pageIndex = 0
    private var pageCounts = 20

    companion object {
        fun newInstance() = SearchUserFragment()
    }

    var keyWords: String = ""
    override fun onAttach(context: Context) {
        super.onAttach(context)
        keyWords = (context as NewSearchActivity).keyWords
    }

    private val mAdapter: SearchUserAdapter by lazy {
        SearchUserAdapter(mutableListOf()) { position: Int, userCode: Int, isFollow: Boolean ->
            follow(position, userCode, isFollow)
        }
    }

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_home)
            setRefreshColor()
            setOnRefreshListener {
                pageIndex = 0
                mViewModel.getLikeUser(keyWords, pageIndex, pageCounts)
            }
        }

        binding.recyclerLayout.run {
            init(
                null,
                mAdapter,
                LinearLayoutManager(mActivity),
                object : SwipRecyclerView.ILoadMoreListener {
                    override fun onLoadMore() {
                        mViewModel.getLikeUser(
                            keyWords,
                            pageIndex * pageCounts,
                            pageCounts
                        )
                    }
                }
            )
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
            }
        }
    }

    override fun createObserver() {

        mViewModel.likedUsersFlow.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                if (pageIndex == 0) {
                    mAdapter.clear()
                    binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                    binding.recyclerLayout.visibility = View.GONE
                }
            } else {
                binding.recyclerLayout.visibility = View.VISIBLE
                binding.layoutEmpty.llayoutEmpty.visibility = View.GONE
                if (pageIndex == 0) {
                    mAdapter.refreshAdapter(it)
                } else {
                    mAdapter.loadMore(it)
                }
                pageIndex++
            }
            binding.swipLayout.isRefreshing = false
            binding.recyclerLayout.loadMoreFinished(it.isEmpty(), it.size >= pageCounts)
        }

        mViewModel.attentionFlow.observe(viewLifecycleOwner) {
            toastTopShow(mActivity, "关注成功")
        }

        mViewModel.unAttentionFlow.observe(viewLifecycleOwner) {
            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(it)
            mAdapter.updateItem(it, holder)
            toastTopShow(mActivity, "取消关注")
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getLikeUser(keyWords, pageIndex * pageCounts, pageCounts)
    }

    private fun follow(position: Int, userCode: Int, isFollow: Boolean) {
        if (isFollow) {
            mViewModel.attention(userCode, position)
        } else {
            if (unAttentionDialog == null) {
                unAttentionDialog = UnAttentionBottomSheetDialog(mActivity) {
                    mViewModel.removeAttention(userCode, position)

                    val view = mActivity.currentFocus
                    if (view is AppCompatEditText) {
                        //view.isFocusable = false
                        val imm =
                            mActivity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                        if (mActivity.currentFocus != null) {
                            imm.hideSoftInputFromWindow(mActivity.currentFocus?.windowToken, 0);
                        }
                    }
                    Log.e("1mean", "view:$view")
                }
            }
            unAttentionDialog?.onShow()
        }
    }

    fun reSearch(key: String) {
        binding.swipLayout.isRefreshing = true
        pageIndex = 0
        this.keyWords = key
        mViewModel.getLikeUser(key, pageIndex, pageCounts)
    }
}