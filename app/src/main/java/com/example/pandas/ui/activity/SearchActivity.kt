package com.example.pandas.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseExActivity
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.ActivitySearchBinding
import com.example.pandas.ui.adapter.HotSearchAdapter
import com.example.pandas.ui.adapter.SearchResultAdapter
import com.example.pandas.ui.ext.backPressed
import com.example.pandas.ui.ext.clearEditText
import com.example.pandas.ui.ext.turnToSearchResultFragment
import com.example.pandas.utils.SoftInputUtils
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch


/**
 * @description: 搜索界面
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class SearchActivity : BaseExActivity<SearchViewModel, ActivitySearchBinding>(),
    ItemClickListener<String>, SearchResultAdapter.SearchItemSelectedListener,
    OnItemmmmClickListener<String> {

    val TAG_SEARCH = "fragment_search_result"

    private val rAdapter: SearchResultAdapter by lazy { SearchResultAdapter(listener = this) }

    private val mAdapter: HotSearchAdapter by lazy { HotSearchAdapter(listener = this) }

    private var isUserSet = false //edittext是否是代码设置，点击热搜和历史进入

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        lifecycleScope.launch {

            binding.rvSearch.run {
                layoutManager = GridLayoutManager(this@SearchActivity, 2)
                adapter = mAdapter
            }

            binding.rvList.run {
                layoutManager = LinearLayoutManager(this@SearchActivity)
                adapter = rAdapter
            }

            binding.txtSearchCancel.setOnClickListener {
                SoftInputUtils.closeKeybord(this@SearchActivity)
                finish()
            }

            binding.clClear.setOnClickListener {
                mViewModel.clearHistory(this@SearchActivity)
            }

            binding.btnSearchClear.setOnClickListener {
                clearEditText()
            }
        }

        binding.editSearch.run {

            requestFocus()
            addTextChangedListener(watch)
            setOnClickListener {
                binding.editSearch.isCursorVisible = true
                val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
                if (fragment != null) {
                    supportFragmentManager.popBackStack()
                    binding.rvList.visibility = View.VISIBLE
                    mViewModel.search(mViewModel.keyWords)
                }
            }
            setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    if (binding.editSearch.text.isNullOrEmpty()) {
                        mViewModel.keyWords = binding.editSearch.hint.toString()
                    }
                    turnToSearchResultFragment()
                }
                //如果设置为false，后续会继续触发edit的点击事件
                true
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()
        mViewModel.getHotSearch()
        mViewModel.getSrachHistory(this)
    }


    override fun createObserver() {

        mViewModel.run {

            hotSearchList.observe(this@SearchActivity) { list ->
                mAdapter.refreshAdapter(list)
            }

            resultList.observe(this@SearchActivity) {
                binding.rvList.visibility = View.VISIBLE
                if (it.isSuccess) {
                    if (it.isEmpty) {
                        rAdapter.clear()
                    } else {
                        rAdapter.refreshAdapter(mViewModel.keyWords, it.listData)
                    }
                }
            }

            searchHistory.observe(this@SearchActivity) {
                binding.gridSearch.init(it, this@SearchActivity)
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
                mViewModel.keyWords = text.toString()
            } else {
                rAdapter.clear()
                binding.btnSearchClear.visibility = View.GONE
                binding.rvList.visibility = View.GONE
            }

            if (!isUserSet) {//代码设置的内容，不需要下面操作
                if (text?.length != 0) {
                    mViewModel.search(text.toString())
                }
            }
            isUserSet = false
        }
    }

    override fun onkeyBack() {
        backPressed()
        binding.editSearch.text = null
    }

    /**
     * 热点
     */
    override fun onClick(position: Int, t: String) {
        mViewModel.keyWords = t
        isUserSet = true
        binding.editSearch.text = Editable.Factory.getInstance().newEditable(t)
        turnToSearchListFragment()
    }

    /**
     * 搜索历史
     */
    override fun onItemClick(t: String) {
        mViewModel.keyWords = t
        isUserSet = true
        binding.editSearch.text = Editable.Factory.getInstance().newEditable(t)
        turnToSearchListFragment()
    }

    private fun clear() {

        //mFragment.clear()
        binding.editSearch.text = null
        binding.editSearch.isCursorVisible = false
        binding.rvList.visibility = View.GONE
    }

    override fun turnToSearchListFragment() {
        turnToSearchResultFragment()
    }
}