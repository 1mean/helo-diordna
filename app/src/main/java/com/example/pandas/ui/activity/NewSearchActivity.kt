package com.example.pandas.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseExActivity
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.biz.viewmodel.SearchViewModel
import com.example.pandas.databinding.ActivitySearchBinding
import com.example.pandas.ui.adapter.HotSearchAdapter
import com.example.pandas.ui.ext.backPressed
import com.example.pandas.ui.ext.clearEditText
import com.example.pandas.ui.ext.turnToSearchResultFragment
import com.example.pandas.ui.fragment.search.SearchListFragment
import com.example.pandas.utils.SoftInputUtils
import com.example.pandas.utils.StatusBarUtils
import kotlinx.coroutines.launch


/**
 * @description: 搜索界面
 * @author: dongyiming
 * @date: 2/17/22 4:23 下午
 * @version: v1.0
 */
public class NewSearchActivity : BaseExActivity<SearchViewModel, ActivitySearchBinding>(),
    ItemClickListener<String>, OnItemmmmClickListener<String> {

    val TAG_SEARCH = "fragment_search_result"

    private val mAdapter: HotSearchAdapter by lazy { HotSearchAdapter(listener = this) }

    private var isUserSet = false //edittext是否是代码设置，点击热搜和历史进入

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        window.decorView.setBackgroundResource(R.color.white)

        lifecycleScope.launch {

            binding.rvSearch.run {
                layoutManager = GridLayoutManager(this@NewSearchActivity, 2)
                adapter = mAdapter
            }

            binding.txtSearchCancel.setOnClickListener {
                SoftInputUtils.closeKeybord(this@NewSearchActivity)
                finish()
            }

            binding.clClear.setOnClickListener {
                mViewModel.clearHistory(this@NewSearchActivity)
            }

            binding.btnSearchClear.setOnClickListener {
                clearEditText()
            }
        }

        binding.editSearch.run {

            requestFocus()
            //addTextChangedListener(watch)  //输入内容变化的监听
            setOnClickListener {
                binding.editSearch.isCursorVisible = true
            }
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    if (binding.editSearch.text.isNullOrEmpty()) {
                        mViewModel.keyWords = binding.editSearch.hint.toString()
                    } else {
                        mViewModel.keyWords = binding.editSearch.text.toString()
                    }
                    //turnToSearchResultFragment()

                    keyBoardInvisible(binding.editSearch)
                    binding.editSearch.isCursorVisible = false
                    mViewModel.saveSearchHistory(this@NewSearchActivity)

                    //1,点击搜索后调入搜索结果界面
                    //2,在搜索结果界面，点击搜索，还在当前界面展示，点返回时才销毁
                    val transaction = supportFragmentManager.beginTransaction()
                    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
                    if (fragment == null) {
                        val newFragment = SearchListFragment()
                        transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
                            .addToBackStack(null).commit()
                    } else {
                        if (binding.editSearch.text.isNullOrEmpty()) {
                            supportFragmentManager.popBackStack()
                        } else {
                            //在搜索结果界面时，这里控制搜索
                            mViewModel.searchRefresh(true, binding.editSearch.text.toString())
                        }
                    }
                }
                //如果设置为false，后续会继续触发edit的点击事件
                true
            }
        }

        appViewModel.appColorType.value?.let {
            binding.clayoutSearchTitle.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.txtSearchCancel.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_text_search_cancel
                    )
                )
                binding.editSearch.setBackgroundResource(R.drawable.shape_home_search)
            } else {
                binding.txtSearchCancel.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                binding.editSearch.setBackgroundResource(R.drawable.shape_home_search_white)
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
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

            hotSearchList.observe(this@NewSearchActivity) { list ->
                mAdapter.refreshAdapter(list)
            }

            searchHistory.observe(this@NewSearchActivity) {
                binding.gridSearch.init(it, this@NewSearchActivity)
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
                binding.btnSearchClear.visibility = View.GONE
            }

            if (!isUserSet) {//代码设置的内容，不需要下面操作
                if (text?.length != 0) {
                    //mViewModel.search(text.toString())
                    turnToSearchResultFragment()
                }
            }
            isUserSet = false
        }
    }

    //当软键盘存在时，从左侧/右侧滑动屏幕时，不会关闭activity，只是会关闭软键盘，因为onkeyBack()根本不会触发，软键盘关闭后再滑动屏幕时，才会触发
    override fun onkeyBack() {

        val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
        if (fragment == null) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
            mViewModel.getSrachHistory(this)
        }
        binding.editSearch.text = null
    }

    /**
     * 热点
     */
    override fun onClick(position: Int, t: String) {
        mViewModel.keyWords = t
        isUserSet = true
        binding.editSearch.text = Editable.Factory.getInstance().newEditable(t)
        turnToSearchResultFragment()
    }

    /**
     * 搜索历史
     */
    override fun onItemClick(t: String) {
        mViewModel.keyWords = t
        isUserSet = true
        binding.editSearch.text = Editable.Factory.getInstance().newEditable(t)
        turnToSearchResultFragment()
    }

    private fun clear() {
        //mFragment.clear()
        binding.editSearch.text = null
        binding.editSearch.isCursorVisible = false
    }

}