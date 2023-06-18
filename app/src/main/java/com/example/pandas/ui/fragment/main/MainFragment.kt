package com.example.pandas.ui.fragment.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
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


/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    private val tabTitles = arrayListOf("首页", "动态", "发布", "视频", "我的")

    private val colors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected),
            ContextCompat.getColor(mActivity, R.color.color_txt_bottom_selected)
        )

    private val bottomBgColors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_bg_home_bottomview),
            ContextCompat.getColor(mActivity, R.color.black)
        )

    override fun initView(savedInstanceState: Bundle?) {

        binding.vpHome.apply {
            adapter = HomeAdapter(mActivity)
            offscreenPageLimit = 5
            //setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

        binding.bnvMain.getOrCreateBadge(R.id.menu_news).run {
            badgeGravity = BadgeDrawable.BOTTOM_END
            backgroundColor =
                ContextCompat.getColor(mActivity, R.color.color_groupbutton_text_selected)
            maxCharacterCount = 3
            number = 99
            badgeTextColor = Color.WHITE
        }

        binding.bnvMain.run {
            itemIconTintList = null //必须代码设置，点击后变化的图片才能显示
            setOnItemSelectedListener { item ->
                updateBottom(false)
                when (item.itemId) {
                    R.id.menu_home -> binding.vpHome.setCurrentItem(0, false)
                    R.id.menu_news -> binding.vpHome.setCurrentItem(1, false)
                    R.id.menu_add -> binding.vpHome.setCurrentItem(2, false)
                    R.id.menu_more -> {
                        binding.vpHome.setCurrentItem(3, false)
                        updateBottom(true)
                    }
                    R.id.menu_mine -> binding.vpHome.setCurrentItem(4, false)
                }
                true //true表示拦截，不跳转
            }
        }

        //修改第2个item的样式为自定义样式
        if (binding.bnvMain[0] is BottomNavigationMenuView) {
            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[2]
            if (item is BottomNavigationItemView) {
                item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                    childView.visibility = View.GONE
                }
                val publishView = LayoutInflater.from(mActivity)
                    .inflate(R.layout.view_bottom_navigation_publish, null)
                item.addView(publishView)
            }
        }
    }

    private var isShortVideo = false
    override fun createObserver() {
        mViewModel.bottomState.observe(viewLifecycleOwner) { isUpdate ->
            Log.e("lidandan3", "改变了: $isUpdate")
            if (isUpdate) {
                isShortVideo = true
                binding.bnvMain.setBackgroundColor(bottomBgColors[1])
            } else {
                if (isShortVideo) {
                    binding.bnvMain.setBackgroundColor(bottomBgColors[0])
                }
            }
        }
    }

    private var update: Boolean = false
    private fun updateBottom(isUpdate: Boolean) {

        if (isUpdate) {//修改底部效果
            if (binding.bnvMain[0] is BottomNavigationMenuView) {
                for (i in 0..4) {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            childView.visibility = View.GONE
                        }
                        if (i == 2) {
                            val publishView =
                                item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                            publishView.setBackgroundResource(R.drawable.shape_bottom_publish1)
                        } else {
                            val titleView = LayoutInflater.from(mActivity)
                                .inflate(R.layout.view_bottom_navigation_name, null)
                            (item as BottomNavigationItemView).addView(titleView)
                            val title =
                                titleView.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                            title.text = tabTitles[i]
                            if (i == 3) {
                                title.setTextColor(colors[1])
                            } else {
                                title.setTextColor(colors[0])
                            }
                        }
                    }
                }
            }
            update = true
        } else {
            if (!update) {
                return
            }
            if (binding.bnvMain[0] is BottomNavigationMenuView) {
                for (i in 0..4) {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            Log.e("lidandan3","childVIew: $childView")
                            if (childView is ConstraintLayout) {
                                childView.visibility = View.GONE
                            } else {
                                childView.visibility = View.VISIBLE
                            }
                        }

//                        if (i == 2) {
//                            val publishView =
//                                item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
//                            publishView.setBackgroundResource(R.drawable.shape_bottom_publish)
//                        } else {
//                            val size = item.childCount
//                            for (i in 0 until size) {
//                                val childView = item[i]
//                                if (childView is ConstraintLayout && childView.id == R.id.clayout_title1) {
//                                    item.removeView(childView)
//                                }
//                            }
//                        }
                    }
                }
            }


            update = false
        }
    }

    override fun firstOnResume() {
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}