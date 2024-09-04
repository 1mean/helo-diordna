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
import com.android.base.ui.activity.BaseSoftKeyBoardActivity
import com.android.base.utils.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.ActivitySearchBinding
import com.example.pandas.ui.adapter.HotSearchAdapter
import com.example.pandas.ui.adapter.SearchHistorydapter
import com.example.pandas.ui.adapter.decoration.FallsItemDecoration
import com.example.pandas.ui.ext.setEditText
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.turnToSearchResultFragment
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.fragment.search.SearchListFragment
import com.example.pandas.ui.fragment.search.SearchResultFragment
import com.example.pandas.ui.fragment.search.SearchUserFragment
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.launch


/**'
 * BUG:针对SearchUserFragment和SearchListFragment的各种离奇的数据莫名回灌的解决办法
 *  - 1，每个fragment都不共享viewmodel，自己使用自己独立的Viewmodel
 *  - 2，使用SingleLiveData代替MutableLiveData和MytableSharedFLow
 *  缺一不可，不然各种莫名其妙的操作bug
 *
 * @description: 搜索界面
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class NewSearchActivity :
    BaseSoftKeyBoardActivity<SearchViewModel, ActivitySearchBinding>() {

    var keyWords = ""
    val TAG_SEARCH = "fragment_search_result"
    private var loadingPopup: LoadingPopupView? = null

    private val mAdapter: HotSearchAdapter by lazy {
        HotSearchAdapter(mutableListOf()) { _: Int, t: String ->
            keyWords = t
            setEditText(binding.editSearch, t)
            turnToSearchResultFragment()
        }
    }

    private val hAdapter: SearchHistorydapter by lazy {
        SearchHistorydapter(mutableListOf()) { t: String ->
            keyWords = t
            setEditText(binding.editSearch, t)
            turnToSearchResultFragment()
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        binding.rvSearch.run {
            layoutManager = GridLayoutManager(this@NewSearchActivity, 2)
            adapter = mAdapter
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
            layoutManager = GridLayoutManager(this@NewSearchActivity, 2)
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

        binding.ibtnSearchClear.setOnClickListener {
            XPopup.Builder(this).asConfirm(null, "确定删除全部搜索历史记录吗？", "取消", "确定",
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

        binding.btnSearchClear.setOnClickListener {
            binding.editSearch.text = null
            //binding.editSearch.requestFocus()
            val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
            fragment?.let {
                supportFragmentManager.popBackStack()
                KeyboardUtils.hideSoftInput(this)
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getHotSearch()
        mViewModel.getAllHistory(0)
    }

    override fun createObserver() {
        mViewModel.run {
            hotSearchList.observe(this@NewSearchActivity) { list ->
                mAdapter.refreshAdapter(list)
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
                    toastTopShow(this@NewSearchActivity, "删除成功")
                    mViewModel.getAllHistory(1)
                } else {
                    toastTopShow(this@NewSearchActivity, "删除失败")
                }
                loadingPopup?.dismiss()
            }
        }
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

    //当软键盘存在时，从左侧/右侧滑动屏幕时，不会关闭activity，只是会关闭软键盘，因为onkeyBack()根本不会触发，软键盘关闭后再滑动屏幕时，才会触发
    override fun onkeyBack() {
        leave()
    }

    private fun startSearch() {
        val content = if (binding.editSearch.text.isNullOrEmpty()) {
            binding.editSearch.hint.toString()
        } else {
            binding.editSearch.text.toString()
        }
        binding.editSearch.postDelayed({
            KeyboardUtils.hideSoftInput(this@NewSearchActivity)
        }, 50)
        binding.editSearch.isCursorVisible = false
        mViewModel.insertSearchHistory(0, content)
        //1,点击搜索后调入搜索结果界面
        //2,在搜索结果界面，点击搜索，还在当前界面展示，点返回时才销毁
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            keyWords = content
            val newFragment = SearchResultFragment()
            transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
                .addToBackStack(null).commit()
        } else {
            if (binding.editSearch.text.isNullOrEmpty()) {
                keyWords = ""
                supportFragmentManager.popBackStack()
            } else {
                if (keyWords != content) {
                    keyWords = content
                    val fragments = supportFragmentManager.fragments
                    if (fragments.isNotEmpty()) {
                        fragments.forEach { fragment ->
                            if (fragment is SearchListFragment) {
                                (fragment as SearchListFragment).reSearch(keyWords)
                            } else if (fragment is SearchUserFragment) {
                                (fragment as SearchUserFragment).reSearch(keyWords)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun leave() {
        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
            mViewModel.getAllHistory(0)
        }
        binding.editSearch.text = null
    }
}