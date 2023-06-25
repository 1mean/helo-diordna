package com.example.pandas.ui.fragment.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.get
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.adapter.HomeAdapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.internal.BaselineLayout
import com.google.android.material.shape.CornerSize


/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    private val tabTitles = arrayListOf("首页", "动态", "发布", "视频", "我的")

    private val publishDrawable
        get() = arrayOf(
            R.drawable.shape_bottom_publish,
            R.drawable.shape_bottom_publish_pink,
            R.drawable.shape_bottom_publish,
            R.drawable.shape_bottom_publish_red,
            R.drawable.shape_bottom_publish_yellow,
            R.drawable.shape_bottom_publish_grey,
            R.drawable.shape_bottom_publish_blue,
            R.drawable.shape_bottom_publish_purple
        )

    private val homeDrawable
        get() = arrayOf(
            R.drawable.selector_button_home,
            R.drawable.selector_button_home,
            R.drawable.selector_button_home,
            R.drawable.selector_button_home_red,
            R.drawable.selector_button_home_yellow,
            R.drawable.selector_button_home_grey,
            R.drawable.selector_button_home_blue,
            R.drawable.selector_button_home_purple
        )
    private val dynamicDrawable
        get() = arrayOf(
            R.drawable.selector_button_dynamic,
            R.drawable.selector_button_dynamic,
            R.drawable.selector_button_dynamic,
            R.drawable.selector_button_dynamic_red,
            R.drawable.selector_button_dynamic_yellow,
            R.drawable.selector_button_dynamic_grey,
            R.drawable.selector_button_dynamic_blue,
            R.drawable.selector_button_dynamic_purple
        )
    private val videoDrawable
        get() = arrayOf(
            R.drawable.selector_button_video,
            R.drawable.selector_button_video,
            R.drawable.selector_button_video,
            R.drawable.selector_button_video_red,
            R.drawable.selector_button_video_yellow,
            R.drawable.selector_button_video_grey,
            R.drawable.selector_button_video_blue,
            R.drawable.selector_button_video_purple
        )
    private val mineDrawable
        get() = arrayOf(
            R.drawable.selector_button_mine,
            R.drawable.selector_button_mine,
            R.drawable.selector_button_mine,
            R.drawable.selector_button_mine_red,
            R.drawable.selector_button_mine_yellow,
            R.drawable.selector_button_mine_grey,
            R.drawable.selector_button_mine_blue,
            R.drawable.selector_button_mine_purple
        )

    private val publishImages
        get() = arrayOf(
            R.mipmap.img_bottom_publish,
            R.mipmap.img_bottom_publish_pink,
            R.mipmap.img_bottom_publish,
            R.mipmap.img_bottom_publish_red,
            R.mipmap.img_bottom_publish_yellow,
            R.mipmap.img_bottom_publish_grey,
            R.mipmap.img_bottom_publish_blue,
            R.mipmap.img_bottom_publish_purple,
        )

    private val shortVideoColors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_txt_bottom_selected),
            ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected)
        )

    private val shortColors
        get() = arrayOf(
            ContextCompat.getColor(mActivity, R.color.color_txt_short_bottom_selected),
            ContextCompat.getColor(mActivity, R.color.color_txtshort_bottom_unselected)
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
            badgeGravity = BadgeDrawable.TOP_END
            backgroundColor =
                ContextCompat.getColor(mActivity, R.color.color_groupbutton_text_selected)
            maxCharacterCount = 3 //101显示99+
            number = 23
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

        val status = appViewModel.appColorType.value
        if (status != null) {
            updateBottomView(status)
        } else {
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
    }

    private var vpStatus = 0
    private var indexArray = arrayOf(0, 1, 2, 3, 4)
    override fun createObserver() {

        appViewModel.appColorType.observe(this) { type ->
            updateBottomView(type)
        }

        mViewModel.bottomState.observe(viewLifecycleOwner) { status ->
            Log.e("lidandan3", "状态改变了: $status")
            when (status) {
                1 -> {//常规
                    if (vpStatus != 1) {
                        if (binding.bnvMain[0] is BottomNavigationMenuView) {
                            for (i in 0..4) {
                                val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                                if (item is BottomNavigationItemView) {
                                    if (i == 2) {
                                        val publishView =
                                            item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                                        val publishImg =
                                            item.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                                        publishView.setBackgroundResource(R.drawable.shape_bottom_publish)
                                        publishImg.setImageResource(R.mipmap.img_bottom_publish)
                                    } else {
                                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                                            if (childView is ConstraintLayout) {
                                                childView.visibility = View.GONE
                                            } else {
                                                childView.visibility = View.VISIBLE
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        vpStatus = 1
                        binding.bnvMain.setBackgroundColor(bottomBgColors[0])
                    }
                }
                2 -> {//白色底部的短视频界面
                    if (vpStatus != 2) {
                        if (binding.bnvMain[0] is BottomNavigationMenuView) {
                            for (i in 0..4) {
                                val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                                if (item is BottomNavigationItemView) {
                                    if (i == 2) {
                                        val publishView =
                                            item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                                        publishView.setBackgroundResource(R.drawable.shape_bottom_publish1)
                                    } else {
                                        var hasTitleView = false
                                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                                            if (childView is ConstraintLayout) {
                                                childView.visibility = View.VISIBLE
                                                hasTitleView = true
                                            } else {
                                                childView.visibility = View.GONE
                                            }
                                        }
                                        if (!hasTitleView) {
                                            val titleView = LayoutInflater.from(mActivity)
                                                .inflate(R.layout.view_bottom_navigation_name, null)
                                            (item as BottomNavigationItemView).addView(titleView)
                                        }
                                        val title =
                                            item.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                                        title.text = tabTitles[i]
                                        if (i == 3) {
                                            title.setTextColor(shortColors[0])
                                        } else {
                                            title.setTextColor(shortColors[1])
                                        }
                                    }
                                }
                            }
                        }
                        vpStatus = 2
                        binding.bnvMain.setBackgroundColor(bottomBgColors[0])
                    }
                }
                3 -> {//黑色底部的视频播放界面
                    if (binding.bnvMain[0] is BottomNavigationMenuView) {
                        for (i in 0..4) {
                            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                            if (item is BottomNavigationItemView) {

                                if (i == 2) {
                                    val publishView =
                                        item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                                    val publishImg =
                                        item.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                                    publishView.setBackgroundResource(R.drawable.shape_bottom_publish1)
                                    publishImg.setImageResource(R.mipmap.img_bottom_publish1)
                                } else {
                                    var hasTitleView = false
                                    item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                                        if (childView is ConstraintLayout) {
                                            childView.visibility = View.VISIBLE
                                            hasTitleView = true
                                            val title =
                                                childView.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                                            if (i == 3) {
                                                title.setTextColor(shortVideoColors[0])
                                            } else {
                                                title.setTextColor(shortVideoColors[1])
                                            }
                                        } else {
                                            childView.visibility = View.GONE
                                        }
                                    }
                                    if (!hasTitleView) {
                                        val titleView = LayoutInflater.from(mActivity)
                                            .inflate(R.layout.view_bottom_navigation_name, null)
                                        (item as BottomNavigationItemView).addView(titleView)
                                    }
                                    val title =
                                        item.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                                    title.text = tabTitles[i]
                                    if (i == 3) {
                                        title.setTextColor(shortVideoColors[0])
                                    } else {
                                        title.setTextColor(shortVideoColors[1])
                                    }
                                }
                            }
                        }
                    }
                    vpStatus = 3
                    binding.bnvMain.setBackgroundColor(bottomBgColors[1])
                }
            }
        }
    }

    override fun firstOnResume() {

    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    private fun updateBottomView(type: Int) {
        if (binding.bnvMain[0] is BottomNavigationMenuView) {

            for (i in indexArray) {
                if (i == 2) {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[2]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            childView.visibility = View.GONE
                        }
                        val publishLayout = LayoutInflater.from(mActivity)
                            .inflate(R.layout.view_bottom_navigation_publish, null)
                        val publishView =
                            publishLayout.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                        val publishImg =
                            publishLayout.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                        publishView.setBackgroundResource(publishDrawable[type])
                        publishImg.setImageResource(publishImages[type])
                        item.addView(publishLayout)
                    }
                } else {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            if (childView is ImageView) {
                                when (i) {
                                    0 -> {
                                        childView.setImageDrawable(
                                            ContextCompat.getDrawable(
                                                mActivity,
                                                homeDrawable[type]
                                            )
                                        )
                                    }
                                    1 -> {
                                        childView.setImageDrawable(
                                            ContextCompat.getDrawable(
                                                mActivity,
                                                dynamicDrawable[type]
                                            )
                                        )
                                    }
                                    3 -> {
                                        childView.setImageDrawable(
                                            ContextCompat.getDrawable(
                                                mActivity,
                                                videoDrawable[type]
                                            )
                                        )
                                    }
                                    4 -> {
                                        childView.setImageDrawable(
                                            ContextCompat.getDrawable(
                                                mActivity,
                                                mineDrawable[type]
                                            )
                                        )
                                    }
                                }
                            } else if (childView is BaselineLayout) {

                                val text1 = childView[0] as TextView
                                val text2 = childView[1] as TextView
                                text2.setTextColor(
                                    ContextCompat.getColor(
                                        mActivity,
                                        bgColors[type]
                                    )
                                )
                                text1.setTextColor(
                                    ContextCompat.getColor(
                                        mActivity,
                                        R.color.color_groupbutton_text
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private val bgColors = arrayOf(
        R.color.color_bg_pink,
        R.color.color_bg_pink,
        R.color.color_bg_black,
        R.color.color_bg_red,
        R.color.color_bg_yellow,
        R.color.color_bg_grey,
        R.color.color_bg_blue,
        R.color.color_bg_purple
    )
}