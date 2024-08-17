package com.example.pandas.ui.activity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityLaterBinding
import com.example.pandas.ui.adapter.LaterAdapter
import com.example.pandas.ui.ext.initNoFooter
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: 稍后再看
 * @author: dongyiming
 * @date: 8/13/22 11:18 上午
 * @version: v1.0
 */
public class LaterActivity : BaseActivity<HistoryViewModeL, ActivityLaterBinding>(),
    LaterAdapter.LaterListener {

    private var selectAll: Boolean = false

    private val mAdapter: LaterAdapter by lazy { LaterAdapter(listener = this) }

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutLaterTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnLaterBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtLaterTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.txtLaterManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_manager
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnLaterBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtLaterTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    binding.txtLaterManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.rvLater.initNoFooter(
            null,
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPageHistory(false)
                }
            })

        binding.ibnLaterBack.setOnClickListener {
            finish()
        }

        binding.txtLaterManager.setOnClickListener {
            val manager = binding.txtLaterManager.text
            if (manager == "管理") {
                mAdapter.manager(false)
                binding.clayoutLaterBottom.visibility = View.VISIBLE
                binding.txtLaterManager.text = resources.getString(R.string.str_cancel)
            } else {
                selectAll = false
                mAdapter.manager(true)
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
                binding.clayoutLaterBottom.visibility = View.GONE
                binding.txtLaterManager.text = resources.getString(R.string.str_manager)
            }
        }

        binding.clayoutSelectAll.setOnClickListener {

            mAdapter.isSelectAll(selectAll)
            if (selectAll) {
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
            } else {
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_selected)
            }
            selectAll = !selectAll
        }

        binding.txtLaterDelete.setOnClickListener {

            val selectList = mAdapter.getSelectList()
            if (selectList.isNotEmpty()) {
                val popuView = layoutInflater.inflate(R.layout.dialog_history_delete_layout, null)
                val sure = popuView.findViewById<AppCompatButton>(R.id.txt_history_dialog_yes)
                val cancel = popuView.findViewById<AppCompatButton>(R.id.txt_history_dialog_no)
                val popWindow = PopupWindow(popuView, 972, 330, true)
                popWindow.isOutsideTouchable = true

                //设置背景变暗
                val lp = window.attributes
                lp.alpha = 0.7f //代表透明程度，范围为0 - 1.0f
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window.attributes = lp

                popWindow.showAtLocation(binding.clayoutSelectAll, Gravity.CENTER, 0, 0)

                popWindow.setOnDismissListener {
                    lp.alpha = 1.0f
                    window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window.attributes = lp
                }

                sure.setOnClickListener {

                    if (selectList.size == mAdapter.itemCount) {//删除所有
                        mViewModel.removeLaters(selectList, true)
                    } else {
                        mViewModel.removeLaters(selectList, false)
                    }
                    mAdapter.delete()
                    popWindow.dismiss()
                    binding.clayoutLaterBottom.visibility = View.GONE
                    binding.txtLaterManager.text = resources.getString(R.string.str_manager)
                }

                cancel.setOnClickListener {
                    popWindow.dismiss()
                }
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getPageLater(true)
    }

    override fun createObserver() {

        mViewModel.laterResult.observe(this) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    mAdapter.refreshAdapter(it.listData)
                    binding.rvLater.isRefreshing(false)
                } else {
                    mAdapter.onLoadMore(it.listData)
                }
                binding.rvLater.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }
    }

    override fun onLongClick() {

        binding.clayoutLaterBottom.visibility = View.VISIBLE
        binding.txtLaterManager.text = resources.getString(R.string.str_cancel)
    }

    override fun cancelAllSelected() {
        binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
        selectAll = false
    }

}