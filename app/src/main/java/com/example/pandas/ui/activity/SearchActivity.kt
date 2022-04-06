package com.example.pandas.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnItemClickListener
import com.example.pandas.biz.interaction.OnItemSelectedListener
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.ActivitySearchBinding
import com.example.pandas.ui.adapter.HotSearchAdapter
import com.example.pandas.ui.adapter.SearchResultAdapter
import com.example.pandas.ui.fragment.SearchListFragment
import com.example.pandas.utils.KeyboardUtils
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: 搜索界面
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class SearchActivity : BaseActivity<SearchViewModel, ActivitySearchBinding>(),
    OnItemClickListener<String>, OnItemSelectedListener, ItemClickListener<String> {

    private var keywords: String = ""

    private val mFragment: SearchListFragment by lazy { SearchListFragment() }

    private val rAdapter: SearchResultAdapter by lazy { SearchResultAdapter(mutableListOf(), this) }

    private val mAdapter: HotSearchAdapter by lazy { HotSearchAdapter(mutableListOf(), this) }

    private var isFragmentShow = false
    private var isUserSet = false //edittext是否是代码设置，代码设置的不需要显示搜索条目列表

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, false, R.color.white)

        binding.rvSearch.run {
            layoutManager = GridLayoutManager(this@SearchActivity, 2)
            adapter = mAdapter
        }
        mViewModel.getHotSearch()

        binding.gridSearch.init(mViewModel.getSrachHistory(this), this)

        binding.rvList.layoutManager = LinearLayoutManager(this@SearchActivity)
        binding.rvList.adapter = rAdapter

        binding.edit.run {
            requestFocus()
            addTextChangedListener(watch)
        }
        binding.edit.setOnClickListener {
            Log.e("1mean", "isFragmentShow: $isFragmentShow")
            binding.edit.isCursorVisible = true
            if (isFragmentShow && supportFragmentManager.fragments.size == 2) {//fragment显示中
                supportFragmentManager.beginTransaction().remove(mFragment).commit()
                mFragment.clear()
                isFragmentShow = false
            }
        }

        binding.edit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                if (binding.edit.text.isNullOrEmpty()) {
                    keywords = binding.edit.hint.toString()
                }
                callback()
            }
            //如果设置为false，后续会继续触发edit的点击事件
            true
        }

        binding.txtSearchCancel.setOnClickListener {
            KeyboardUtils.closeKeybord(this)
            finish()
        }

        binding.clClear.setOnClickListener {
            mViewModel.clearHistory(this)
            binding.gridSearch.init(mViewModel.getSrachHistory(this), this)
        }
    }

    private val watch = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        //start: 有变动的字符串的序号..before: 被改变的字符串长度，如果是新增则为0..count: 添加的字符串长度，如果是删除则为0
        //添加4个时 0 0 4，删除1个时 3 1 0，
        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

            Log.e("1mean", "onTextChanged: $isUserSet")
            if (!isUserSet) {//代码设置的内容，不需要下面操作

                if (text?.length != 0) {
                    binding.rvList.visibility = View.VISIBLE
                    keywords = text.toString()
                    mViewModel.search(keywords)
                } else {
                    binding.rvList.visibility = View.GONE
                }
            }
            isUserSet = false
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    override fun createObserver() {

        mViewModel.hotSearchList.observe(this) { list ->
            mAdapter.refreshAdapter(list)
        }

        mViewModel.resultList.observe(this) {

            if (it.isSuccess) {

                if (it.isEmpty) {
                    rAdapter.clear()
                } else {
                    rAdapter.refreshAdapter(it.listData)
                }
            }
        }
    }

    override fun onkeyBack() {
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (manager.isActive) {
            manager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
        }
        val fragments = supportFragmentManager.fragments
        //remove后集合里只有SupportRequestManagerFragment，size为1，否则是加上SearchListFragment
        //当搜索最终展示页面为空时，fragments里也是只有一个fragment
        if (fragments.isEmpty() || !isFragmentShow) {
            finish()
        } else {
            supportFragmentManager.beginTransaction().remove(mFragment).commit()
            clear()
            binding.gridSearch.init(mViewModel.getSrachHistory(this), this)
        }
    }

    /**
     * 搜索历史
     */
    override fun callback() {
        val bundle = Bundle()
        bundle.putString("keywords", keywords)
        mFragment.arguments = bundle
        KeyboardUtils.closeKeybord(this)
        binding.edit.isCursorVisible = false
        isFragmentShow = true
        supportFragmentManager.beginTransaction()
            .add(R.id.llayout_search_content, mFragment).commit()
    }

    /**
     * 热点
     */
    override fun onClick(position: Int, t: String) {
        keywords = t
        isUserSet = true
        binding.edit.text = Editable.Factory.getInstance().newEditable(t)
        callback()
    }

    /**
     * 搜索历史
     */
    override fun onItemClick(t: String) {
        this.keywords = t
        isUserSet = true
        binding.edit.text = Editable.Factory.getInstance().newEditable(t)
        callback()
    }

    private fun clear() {

        isFragmentShow = false
        mFragment.clear()
        binding.edit.text = null
        binding.edit.isCursorVisible = false
        binding.rvList.visibility = View.GONE
    }

}