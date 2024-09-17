package com.example.pandas.ui.activity

import AppInstance
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.KeyboardUtils
import com.android.base.utils.SoftInputUtils
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.ActivityWanSearchBinding
import com.example.pandas.ui.adapter.HotSearchAdapter
import com.example.pandas.ui.adapter.SearchHistorydapter
import com.example.pandas.ui.adapter.decoration.FallsItemDecoration
import com.example.pandas.ui.ext.setEditText
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.search.WanSearchListFragment
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.launch

/**
 * @description: WanAndroidActivity
 * @author: dongyiming
 * @date: 8/22/24 11:53 PM
 * @version: v1.0
 */
public open class WanSearchActivity : BaseActivity<SearchViewModel, ActivityWanSearchBinding>() {

    val TAG_SEARCH = "fragment_search_result"
    private var loadingPopup: LoadingPopupView? = null

    private val mAdapter: HotSearchAdapter by lazy {
        HotSearchAdapter(mutableListOf()) { _: Int, t: String ->
            mViewModel.keyWords = t
            //isUserSet = true
            setEditText(binding.editSearch, t)
            turnToSearchResultFragment()
        }
    }

    private val hAdapter: SearchHistorydapter by lazy {
        SearchHistorydapter(mutableListOf()) { t: String ->
            mViewModel.keyWords = t
            setEditText(binding.editSearch, t)
            turnToSearchResultFragment()
        }
    }


    override fun initView(savedInstanceState: Bundle?) {

        binding.rvSearch.run {
            layoutManager = GridLayoutManager(this@WanSearchActivity, 2)
            adapter = mAdapter
        }

        binding.txtSearch.setOnClickListener {
            SoftInputUtils.closeKeybord(this@WanSearchActivity)
            finish()
        }

        binding.txtSearch.setOnClickListener {
            startSearch()
        }

        binding.ibtnSearchLeave.setOnClickListener {
            leave()
        }

        val paddingLeft = resources.getDimension(R.dimen.common_lh_5_dimens).toInt()
        val paddingMid = resources.getDimension(R.dimen.common_lh_7_dimens).toInt()
        val paddingTop = resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
        with(binding.rvHistory) {
            layoutManager = GridLayoutManager(this@WanSearchActivity, 2)
            adapter = hAdapter
            addItemDecoration(
                FallsItemDecoration(
                    topSpace = paddingTop,
                    leftSpace = paddingLeft,
                    rightSpace = paddingLeft,
                    midSpace = paddingMid
                )
            )
        }

        binding.ibtnSearchClear.setOnClickListener {
            XPopup.Builder(this).asConfirm(null, "将删除全部搜索历史记录，确定删除吗？", "取消", "确定",
                {
                    if (loadingPopup == null) {
                        loadingPopup = XPopup.Builder(this).dismissOnBackPressed(true)
                            .isLightNavigationBar(true)
                            .isViewMode(false)
                            .asLoading(
                                null,
                                R.layout.loading_delete,
                                LoadingPopupView.Style.ProgressBar
                            )
                        loadingPopup!!.show()
                    } else {
                        loadingPopup!!.show()
                    }
                    mViewModel.clearAllHistory(1)
                }, { Log.e("1mean", "取消") }, false, R.layout.dialog_login_out
            ).show()
        }

        binding.btnSearchClear.setOnClickListener {
            binding.editSearch.text = null
            binding.editSearch.requestFocus()
            val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
            fragment?.let {
                supportFragmentManager.popBackStack()
                KeyboardUtils.hideSoftInput(this)
            }
        }

        binding.editSearch.run {
            requestFocus()
            addTextChangedListener(watch)  //输入内容变化的监听
            setOnClickListener {
                binding.editSearch.isCursorVisible = true
            }
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    startSearch()
                }
                //如果设置为false，后续会继续触发edit的点击事件
                true
            }
        }

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutSearchTitle.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.txtSearch.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_text_search
                        )
                    )
                    binding.editSearch.setBackgroundResource(R.drawable.shape_home_search)
                    binding.ibtnSearchLeave.setImageResource(R.mipmap.img_setting_top_back_black33)
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.txtSearch.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    binding.ibtnSearchLeave.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.editSearch.setBackgroundResource(R.drawable.shape_home_search_white)
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }
        mViewModel.hotkey()
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getAllHistory(1)
    }

    private val watch = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        //start: 有变动的字符串的序号..before: 被改变的字符串长度，如果是新增则为0..count: 添加的字符串长度，如果是删除则为0
        //添加4个时 0 0 4，删除1个时 3 1 0，
        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
            if (text?.length != 0) {
                binding.btnSearchClear.visibility = View.VISIBLE
            } else {
                binding.btnSearchClear.visibility = View.GONE
            }
            false
        }
    }

    override fun createObserver() {
        lifecycleScope.launch {
            mViewModel.hotkey.collect {
                if (it.errorCode == 0) {
                    val list = mutableListOf<String>().apply {
                        it.data.forEach { key ->
                            add(key.name)
                        }
                    }
                    mAdapter.refreshAdapter(list)
                }
                binding.clayoutSearchContent.visibility = View.VISIBLE
            }
        }

        lifecycleScope.launch {
            mViewModel.queryAllHistoryFlow.collect {
                if (it.isNotEmpty()) {
                    hAdapter.refreshAdapter(it)
                } else {
                    hAdapter.clear()
                }
            }
        }

        lifecycleScope.launch {
            mViewModel.deleteAllFlow.collect {//这个返回值表示被删除的行数。如果没有行被删除，则返回值为0
                if (it > 0) {//删除成功
                    toastTopShow(this@WanSearchActivity, "删除成功")
                    mViewModel.getAllHistory(1)
                } else {
                    toastTopShow(this@WanSearchActivity, "删除失败")
                }
                loadingPopup?.dismiss()
            }
        }
    }

    //当软键盘存在时，从左侧/右侧滑动屏幕时，不会关闭activity，只是会关闭软键盘，因为onkeyBack()根本不会触发，软键盘关闭后再滑动屏幕时，才会触发
    override fun onkeyBack() {
        leave()
    }

    private fun turnToSearchResultFragment() {
        Log.e("1mean", "11111111")
        KeyboardUtils.hideSoftInput(this)
        binding.editSearch.isCursorVisible = false
        mViewModel.insertSearchHistory(1, mViewModel.keyWords)

        addOrShowFragment()
    }

    private fun addOrShowFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            val newFragment = WanSearchListFragment()
            transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
                .addToBackStack(null).commit()
        }
    }

    private fun startSearch() {
        val content = if (binding.editSearch.text.isNullOrEmpty()) {
            binding.editSearch.hint.toString()
        } else {
            binding.editSearch.text.toString()
        }
        mViewModel.keyWords = content
        binding.editSearch.postDelayed({
            KeyboardUtils.hideSoftInput(this@WanSearchActivity)
        }, 50)
        binding.editSearch.isCursorVisible = false
        mViewModel.insertSearchHistory(1, content)
        //1,点击搜索后调入搜索结果界面
        //2,在搜索结果界面，点击搜索，还在当前界面展示，点返回时才销毁
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            val newFragment = WanSearchListFragment()
            transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
                .addToBackStack(null).commit()
        } else {
            if (binding.editSearch.text.isNullOrEmpty()) {
                supportFragmentManager.popBackStack()
            } else {
                //在搜索结果界面时，这里控制搜索
                mViewModel.pageSearch(0, content)
            }
        }
    }

    private fun leave() {
        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
            mViewModel
            mViewModel.getAllHistory(1)
        }
        binding.editSearch.text = null
    }
}