package com.example.pandas.ui.ext;

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
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.ui.fragment.main.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.internal.BaselineLayout


private val publishDrawable
    get() = arrayOf(
        R.drawable.shape_bottom_publish_pink,
        R.drawable.shape_bottom_publish_pink,
        R.drawable.shape_bottom_publish_pink,
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

private val bottomImages: Array<Array<Int>>
    get() = arrayOf(
        homeDrawable,
        dynamicDrawable,
        videoDrawable,
        videoDrawable,
        mineDrawable
    )

private val publishImages
    get() = arrayOf(
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
        R.mipmap.img_bottom_publish_white,
    )

private val publishImages1
    get() = arrayOf(
        R.mipmap.img_bottom_publish_pink,
        R.mipmap.img_bottom_publish_pink,
        R.mipmap.img_bottom_publish_pink,
        R.mipmap.img_bottom_publish_red,
        R.mipmap.img_bottom_publish_yellow,
        R.mipmap.img_bottom_publish_grey,
        R.mipmap.img_bottom_publish_blue,
        R.mipmap.img_bottom_publish_purple,
    )


fun MainFragment.initBottom(indexArray: Array<Int>) {
    val status = appViewModel.appColorType.value
    if (status != null) {
        Log.e("1mean","111")
        if (binding.bnvMain[0] is BottomNavigationMenuView) {
            for (i in indexArray) {
                if (i == 2) {
                    Log.e("1mean","222")
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[2]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，默认的AppCompatImageView(图标) + BaselineLayout(文字)
                            childView.visibility = View.GONE//隐藏控件默认的两个子view
                        }
                        val publishLayout = LayoutInflater.from(mActivity)
                            .inflate(R.layout.view_bottom_navigation_publish, null)
                        publishLayout.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                            .setBackgroundResource(publishDrawable[status])
                        publishLayout.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                            .setImageResource(publishImages[status])
                        item.addView(publishLayout) //添加自己需要的带 + 的图标
                    }
                } else {
                    Log.e("1mean","3333")
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            if (childView is ImageView) {
                                Log.e("1mean","4444")
                                childView.setImageDrawable(
                                    ContextCompat.getDrawable(
                                        mActivity, bottomImages[i][status]
                                    )
                                )
                            } else if (childView is BaselineLayout) {

                                Log.e("1mean","5555")
                                val text1 = childView[0] as TextView
                                val text2 = childView[1] as TextView
                                Log.e("1mean", "status:$status")
                                text2.setTextColor(
                                    ContextCompat.getColor(mActivity, AppInfos.viewColors[status])
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
    } else {
        Log.e("1mean","6666")
        //修改第2个item的样式为自定义样式
        if (binding.bnvMain[0] is BottomNavigationMenuView) {
            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[2]
            if (item is BottomNavigationItemView) {
                Log.e("1mean","7777")
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

fun MainFragment.appColorObserver(indexArray: Array<Int>, type: Int) {
    if (binding.bnvMain[0] is BottomNavigationMenuView) {
        for (i in indexArray) {
            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
            if (item is BottomNavigationItemView) {
                if (i == 2) {
                    val publishView =
                        item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                    val publishImg =
                        item.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                    publishView.setBackgroundResource(publishDrawable[type])
                    publishImg.setImageResource(publishImages[type])
                } else {
                    item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                        if (childView is ImageView) {
                            childView.setImageDrawable(
                                ContextCompat.getDrawable(
                                    mActivity, bottomImages[i][type]
                                )
                            )
                        } else if (childView is BaselineLayout) {//文字

                            val text1 = childView[0] as TextView
                            val text2 = childView[1] as TextView
                            text2.setTextColor(
                                ContextCompat.getColor(
                                    mActivity,
                                    AppInfos.viewColors[type]
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

fun MainFragment.bottomStateObserver(indexArray: Array<Int>, status: Int) {
    val bottomBgColors = arrayOf(
        ContextCompat.getColor(mActivity, R.color.color_bg_home_bottomview),
        ContextCompat.getColor(mActivity, R.color.black)
    )

    val shortVideoColors = arrayOf(
        ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected),
        ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected),
        ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected),
        ContextCompat.getColor(mActivity, R.color.color_txt_bottom_selected),
        ContextCompat.getColor(mActivity, R.color.color_txt_bottom_unselected)
    )

    binding.bnvMain.setBackgroundColor(bottomBgColors[status])//底部背景颜色
    if (binding.bnvMain[0] is BottomNavigationMenuView) {
        for (i in indexArray) {
            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
            if (item is BottomNavigationItemView) {
                if (i == 2) {//中间item
                    val publishView =
                        item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                    val publishImg =
                        item.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                    when (status) {
                        0 -> {//常规底部
                            val type = appViewModel.appColorType.value
                            if (type == null) {
                                publishView.setBackgroundResource(publishDrawable[0])
                                publishImg.setImageResource(publishImages[0])
                            } else {
                                publishView.setBackgroundResource(publishDrawable[type])
                                publishImg.setImageResource(publishImages[0])
                            }
                        }
                        1 -> {//短视频底部
                            publishView.setBackgroundResource(R.drawable.shape_bottom_publish1)
                            publishImg.setImageResource(R.mipmap.img_bottom_publish1)
                        }
                    }
                } else {
                    when (status) {
                        0 -> {//常规底部
                            item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                                if (childView is ConstraintLayout) {
                                    childView.visibility = View.GONE
                                } else {
                                    childView.visibility = View.VISIBLE
                                }
                            }
                        }
                        1 -> {//短视频底部
                            var hasTitleView = false
                            item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                                if (childView is ConstraintLayout) {
                                    childView.visibility = View.VISIBLE
                                    hasTitleView = true
                                    val title =
                                        childView.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                                    title.setTextColor(shortVideoColors[i])
                                } else {
                                    childView.visibility = View.GONE
                                }
                            }
                            if (!hasTitleView) {
                                val titleView = LayoutInflater.from(mActivity)
                                    .inflate(R.layout.view_bottom_navigation_name, null)
                                (item as BottomNavigationItemView).addView(titleView)
                                val title =
                                    item.findViewById<AppCompatTextView>(R.id.txt_bottom_title)
                                title.text = tabTitles[i]
                                title.setTextColor(shortVideoColors[i])
                            }
                        }
                    }
                }
            }
        }
    }
}