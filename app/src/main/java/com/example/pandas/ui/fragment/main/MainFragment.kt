package com.example.pandas.ui.fragment.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.adapter.HomeAdapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.internal.BaselineLayout
import com.google.android.material.tabs.TabLayout




/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        binding.vpHome.apply {
            adapter = HomeAdapter(mActivity)
            offscreenPageLimit = 5
            //setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

        binding.bnvMain.getOrCreateBadge(R.id.menu_news).run {
            badgeGravity = BadgeDrawable.BOTTOM_END
            backgroundColor = ContextCompat.getColor(mActivity, R.color.color_groupbutton_text_selected)
            maxCharacterCount = 3
            number = 99
            badgeTextColor = Color.WHITE
        }

        binding.bnvMain.run {
            itemIconTintList = null //必须代码设置，点击后变化的图片才能显示
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> binding.vpHome.setCurrentItem(0, false)
                    R.id.menu_news -> binding.vpHome.setCurrentItem(1, false)
                    R.id.menu_add -> binding.vpHome.setCurrentItem(2, false)
                    R.id.menu_more -> binding.vpHome.setCurrentItem(3, false)
                    R.id.menu_mine -> binding.vpHome.setCurrentItem(4, false)
                }
                true //true表示拦截，不跳转
            }
        }

        val view = binding.bnvMain[0]
        if (view is BottomNavigationMenuView) {
            for (i in 0..4) {
                val item = (view as BottomNavigationMenuView).get(i)
                if (item is BottomNavigationItemView) {
                    val lineLayout =
                        item.findViewById<BaselineLayout>(R.id.navigation_bar_item_labels_group)
                    val image = item.findViewById<ImageView>(R.id.navigation_bar_item_icon_view)
                    val text1 =
                        item.findViewById<TextView>(R.id.navigation_bar_item_small_label_view)
                    val text2 =
                        item.findViewById<TextView>(R.id.navigation_bar_item_large_label_view)
                    if (i == 2) {
                        image.visibility = View.GONE
                        lineLayout.visibility = View.GONE
                        val publishView = LayoutInflater.from(mActivity)
                            .inflate(R.layout.view_bottom_navigation_publish, null)
                        (item as BottomNavigationItemView).addView(publishView)
                    } else {
                        //text1.visibility = View.GONE

//                        lineLayout.visibility = View.GONE
//                        val titleView = LayoutInflater.from(mActivity)
//                            .inflate(R.layout.view_bottom_navigation_name, null)
//                        (item as BottomNavigationItemView).addView(titleView)
//                        val title = titleView.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
//                        title.text = text1.text.toString()
                    }
                }
            }
        }
    }

    override fun createObserver() {

        mViewModel.bottomState.observe(viewLifecycleOwner) { isUpdate ->
            Log.e("lidandan3", "改变了: $isUpdate")
            if (isUpdate) {
                binding.bnvMain.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.black))
            } else {
                binding.bnvMain.setBackgroundColor(
                    ContextCompat.getColor(
                        mActivity,
                        R.color.color_bg_home_bottomview
                    )
                )
            }
        }
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}