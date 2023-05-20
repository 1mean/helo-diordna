package com.example.pandas.ui.fragment.main.mine

import FollowFragmentAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.ext.setRefreshColor
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: 我的-粉丝-我的关注
 * @author: dongyiming
 * @date: 5/10/22 2:39 下午
 * @version: v1.0
 */
public class FollowFragment : BaseFragment<SelfViewModel, LayoutSwipRefreshBinding>(),
    FollowFragmentAdapter.OnFollowViewClickListener {

    private var _bottomSheetDialog: BottomSheetDialog? = null
    private val bottomSheetDialog get() = _bottomSheetDialog!!

    private var _dBinding: DialogAttentionCancelBinding? = null
    private val dBinding get() = _dBinding!!

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
            setBackgroundResource(R.color.white)
            setRefreshColor()
            setOnRefreshListener {
                mViewModel.getAllFollowUser()
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
    }

    override fun createObserver() {

        mViewModel.followUser.observe(viewLifecycleOwner) {

            if (it.isEmpty()) {
                binding.recyclerLayout.visibility = View.GONE
                binding.layoutEmpty.llayoutEmpty.visibility = View.VISIBLE
            } else {
                binding.recyclerLayout.visibility = View.VISIBLE
                binding.layoutEmpty.llayoutEmpty.visibility = View.GONE
                mAdapter.refreshAdapter(it)
            }
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        binding.swipLayout.isRefreshing = true
        mViewModel.getAllFollowUser()
    }

    override fun followViewClick(position: Int, userCode: Int) {

        if (_bottomSheetDialog == null) {

            _bottomSheetDialog = BottomSheetDialog(mActivity)
            _dBinding = DialogAttentionCancelBinding.inflate(LayoutInflater.from(mActivity))

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