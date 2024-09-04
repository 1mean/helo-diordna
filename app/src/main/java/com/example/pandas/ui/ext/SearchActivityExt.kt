package com.example.pandas.ui.ext;

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.pandas.R
import com.example.pandas.ui.activity.NewSearchActivity
import com.example.pandas.ui.activity.SearchActivity
import com.example.pandas.ui.fragment.search.SearchListFragment
import com.example.pandas.ui.fragment.search.SearchResultFragment

/**
 * popBackStackImmediate为同步，popBackStack为异步
 * addToBackStack添加fragment后，activity不触发任何生命周期方法
 * popBackStack后回到activity后，也不触发任何生命周期方法
 * 需要解决的，在fragment的创建和销毁里解决，触发onResume()和onDestroy()
 */
fun SearchActivity.addOrShowFragment() {
    val transaction = supportFragmentManager.beginTransaction()
    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)

    fragment?.let {
        val fragments = supportFragmentManager.fragments
        if (fragments.size > 1) {
            supportFragmentManager.popBackStack()
            transaction.show(it).commit()
        }
    }

    if (fragment == null) {
        val newFragment = SearchResultFragment()
        transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
            .addToBackStack(null).commit()
    }
}

fun NewSearchActivity.addOrShowFragment() {
    val transaction = supportFragmentManager.beginTransaction()
    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)

//    fragment?.let {
//        val fragments = supportFragmentManager.fragments
//        if (fragments.size > 1) {
//            supportFragmentManager.popBackStack()
//            transaction.show(it).commit()
//        }
//    }

    if (fragment == null) {
        val newFragment = SearchResultFragment()
        transaction.add(R.id.llayout_search_content, newFragment, TAG_SEARCH)
            .addToBackStack(null).commit()
    }
}

fun SearchActivity.backPressed() {
    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
    if (fragment == null) {
        finish()
    } else {
        supportFragmentManager.popBackStack()
    }
}


fun SearchActivity.clearEditText() {
    binding.editSearch.text = null
    binding.editSearch.requestFocus()
    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
    fragment?.let {
        supportFragmentManager.popBackStack()
        keyBoardVisible(binding.editSearch)
    }
}

fun NewSearchActivity.clearEditText() {
    binding.editSearch.text = null
    binding.editSearch.requestFocus()
    val fragment = supportFragmentManager.findFragmentByTag(TAG_SEARCH)
    fragment?.let {
        supportFragmentManager.popBackStack()
        keyBoardVisible(binding.editSearch)
    }
}

fun SearchActivity.turnToSearchResultFragment() {

    keyBoardInvisible(binding.editSearch)
    binding.editSearch.isCursorVisible = false
    //mViewModel.saveSearchHistory(this)

    addOrShowFragment()
}

fun NewSearchActivity.turnToSearchResultFragment() {

    keyBoardInvisible(binding.editSearch)
    binding.editSearch.isCursorVisible = false
    if (keyWords.isNotEmpty()) {
        mViewModel.insertSearchHistory(0, keyWords)
    }

    addOrShowFragment()
}