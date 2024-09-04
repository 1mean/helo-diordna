package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.lifecycle.LifecycleHandler
import com.example.pandas.biz.viewmodel.HistoryViewModeL
import com.example.pandas.databinding.ActivityHistoryBinding
import com.example.pandas.ui.adapter.HistoryAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: HistoryActivity
 * @author: dongyiming
 * @date: 3/11/22 12:05 上午
 * @version: v1.0
 */
public class HistoryActivity : BaseActivity<HistoryViewModeL, ActivityHistoryBinding>() {

    private var selectAll: Boolean = false
    private var popWindow: PopupWindow? = null

    private val mHandler = LifecycleHandler(Looper.getMainLooper(), this)
    private val mAdapter: HistoryAdapter by lazy {
        HistoryAdapter(mutableListOf(), {
            binding.clayoutHistoryBottom.visibility = View.VISIBLE
            binding.txtHistoryManager.text = resources.getString(R.string.str_cancel)
        }, {
            binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
            selectAll = false
        })
    }

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutHistoryTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnHistoryBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtHistoryTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    binding.txtHistoryManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_manager
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[0])
                } else {
                    binding.ibnHistoryBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtHistoryTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    binding.txtHistoryManager.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.rvHistory.init(
            null,
            mAdapter,
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getPageHistory(false)
                }
            })

        binding.txtHistoryManager.setOnClickListener {
            val manager = binding.txtHistoryManager.text
            if (manager == "管理") {
                mAdapter.manager(false)
                binding.clayoutHistoryBottom.visibility = View.VISIBLE
                binding.txtHistoryManager.text = resources.getString(R.string.str_cancel)
            } else {
                selectAll = false
                mAdapter.manager(true)
                binding.imgSelectAll.setImageResource(R.mipmap.img_history_unselect)
                binding.clayoutHistoryBottom.visibility = View.GONE
                binding.txtHistoryManager.text = resources.getString(R.string.str_manager)
            }
        }

        binding.ibnHistoryBack.setOnClickListener {
            finish()
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

        binding.txtHistoryDelete.setOnClickListener {

            val selectList = mAdapter.getSelectList()
            if (selectList.isNotEmpty()) {
                val popuView = layoutInflater.inflate(R.layout.dialog_history_delete_layout, null)
                val sure = popuView.findViewById<AppCompatButton>(R.id.txt_history_dialog_yes)
                val cancel = popuView.findViewById<AppCompatButton>(R.id.txt_history_dialog_no)
                popWindow = PopupWindow(popuView, 972, 330, true)
                popWindow!!.isOutsideTouchable = true

                //设置背景变暗
                val lp = window.attributes
                lp.alpha = 0.7f //代表透明程度，范围为0 - 1.0f
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window.attributes = lp

                popWindow!!.showAtLocation(binding.clayoutSelectAll, Gravity.CENTER, 0, 0)


                popWindow!!.setOnDismissListener {
                    lp.alpha = 1.0f
                    window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window.attributes = lp
                }

                sure.setOnClickListener {

                    if (selectList.size == mAdapter.itemCount) {//删除所有
                        mViewModel.removeHistory(selectList, true)
                    } else {
                        mViewModel.removeHistory(selectList, false)
                    }
                }

                cancel.setOnClickListener {
                    popWindow!!.dismiss()
                }
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getPageHistory(true)
    }

    override fun createObserver() {

        mViewModel.historyResult.observe(this) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    mAdapter.onRefreshAdapter(it.listData)
                    binding.rvHistory.isRefreshing(false)
                } else {
                    mAdapter.onLoadMore(it.listData)
                }
                binding.rvHistory.loadMoreFinished(it.isEmpty, it.hasMore)
            }
        }

        mViewModel.removeHistoryResult.observe(this) {
            if (it.isSuccess) {
                mAdapter.onRefreshAdapter(it.listData)
                //binding.rvHistory.isRefreshing(false)
                binding.rvHistory.loadMoreFinished(it.isEmpty, it.hasMore)

                //mAdapter.delete()
                mHandler.post {
                    binding.clayoutHistoryBottom.visibility = View.GONE
                    binding.txtHistoryManager.text = resources.getString(R.string.str_manager)
                }
            }
            popWindow?.dismiss()
        }
    }
}