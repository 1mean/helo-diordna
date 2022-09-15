package com.example.pandas.ui.ext;

import androidx.appcompat.app.AppCompatActivity
import com.example.pandas.R
import com.example.pandas.ui.fragment.SearchListFragment


/**********************************************************************************************
 * 最终解决方案( 待确定的方案，先存放在各自相关的逻辑页面里 )
 *  - 1.界面相关，最优处理结果，
 *
 *
 *
 *
 *
 *
 *
 *
 * **********************************************************************************************/


/* Fragment相关 **************************************************/
fun AppCompatActivity.addOrShowFragment(tag: String) {

    val transaction = supportFragmentManager.beginTransaction()
    val fragment = supportFragmentManager.findFragmentByTag(tag)

    fragment?.let {
        val fragments = supportFragmentManager.fragments
        if (fragments.size > 1) {
            supportFragmentManager.popBackStack()
            transaction.show(it).commit()
        }
    }

    if (fragment == null) {
        val newFragment = SearchListFragment()
        transaction.add(R.id.llayout_search_content, newFragment, tag)
            .addToBackStack(null).commit()
    }
}
