package com.example.pandas.ui.fragment.search

import FollowFragmentAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.launch

/**
 * @description: SearchUserFragment
 * @author: dongyiming
 * @date: 8/25/24 2:27 AM
 * @version: v1.0
 */
public class SearchUserFragment :
    BaseFragment<SearchViewModel, LayoutSwipRefreshBinding>(),
    FollowFragmentAdapter.OnFollowViewClickListener {

    private var _bottomSheetDialog: BottomSheetDialog? = null
    private val bottomSheetDialog get() = _bottomSheetDialog!!

    private var _dBinding: DialogAttentionCancelBinding? = null
    private val dBinding get() = _dBinding!!

    private var startIndex = 0
    private var pageCounts = 20

    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val mAdapter: FollowFragmentAdapter by lazy {
        FollowFragmentAdapter(
            mutableListOf(),
            this
        )
    }

    override fun lazyLoadTime(): Long = 0

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.run {
            setBackgroundResource(R.color.color_bg_home)
            setRefreshColor()
            setOnRefreshListener {
                startIndex = 0
                mViewModel.getLikeUser(mViewModel.keyWords, startIndex, pageCounts)
            }
        }

        binding.recyclerLayout.run {
            initNoFooter(
                null,
                mAdapter,
                LinearLayoutManager(mActivity),
                null
            )
        }

        appViewModel.appColorType.value?.let {
            if (it == 0) {
                binding.swipLayout.setColorSchemeResources(viewColors[APP_COLOR_STATUS])
                mAdapter.setVipColor(
                    ContextCompat.getColor(
                        mActivity,
                        viewColors[APP_COLOR_STATUS]
                    )
                )
            } else {
                binding.swipLayout.setColorSchemeResources(viewColors[it])
                mAdapter.setVipColor(ContextCompat.getColor(mActivity, viewColors[it]))
            }
        }
    }

    override fun createObserver() {

        lifecycleScope.launch {
            mViewModel.likedUsersFlow.collect {
                Log.e("1madasdasdean","size=" + it.size)
                if (it.isEmpty()) {
                    if (startIndex == 0) {
                        mAdapter.clear()
                        binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
                        binding.recyclerLayout.visibility = View.GONE
                    }
                } else {
                    binding.recyclerLayout.visibility = View.VISIBLE
                    binding.layoutEmpty.llayoutEmpty.visibility = View.GONE
                    if (startIndex == 0) {
                        mAdapter.refreshAdapter(it)
                    } else {
                        mAdapter.loadMore(it)
                    }
                    startIndex = (startIndex + 1) * pageCounts
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty(), it.size >= pageCounts)
                binding.swipLayout.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        Log.e("1madasdasdean","key= ${mViewModel.keyWords}")
        mViewModel.getLikeUser(mViewModel.keyWords, startIndex, pageCounts)
    }

    override fun followViewClick(position: Int, userCode: Int) {

        if (_bottomSheetDialog == null) {

            _bottomSheetDialog = BottomSheetDialog(mActivity)
            _dBinding = DialogAttentionCancelBinding.inflate(LayoutInflater.from(mActivity))
            dBinding.root.setBackgroundResource(R.color.color_bg_delete_dialog)
            dBinding.rlayoutAdd.setOnClickListener {
                Toast.makeText(mActivity, "加入特别关注", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            dBinding.rlayoutGroup.setOnClickListener {
                Toast.makeText(mActivity, "加入默认分组", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            dBinding.txtCancel.setOnClickListener {
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(dBinding.root)
            bottomSheetDialog.setCancelable(true)
            bottomSheetDialog.setCanceledOnTouchOutside(true)
        }
        dBinding.rlayoutCancel.setOnClickListener { _ ->

            mViewModel.updateAttention(userCode)
            val holder = binding.recyclerLayout.findViewHolderForLayoutPosition(position)
            mAdapter.updateItem(position, holder)
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }

    override fun unFollowViewClick(position: Int, userCode: Int) {
        mViewModel.follow(mActivity, userCode)
    }
}