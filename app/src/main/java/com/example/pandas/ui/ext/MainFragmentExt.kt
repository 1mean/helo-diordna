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

/***************************************************
 * 同时包含以下五个fragment
 ******       HomeFragment           ***************
 ******       MainFragment           ***************
 ******       LiveFragment           ***************
 ******       ShortFragment          ***************
 ******       MineFragment           ***************
 ***************************************************/



private val bottomImages: Array<Array<Int>>
    get() = arrayOf(
        homeDrawable,
        dynamicDrawable,
        videoDrawable,
        videoDrawable,
        mineDrawable
    )

fun MainFragment.initBottom() {
    appViewModel.appColorType.value?.let {
        if (binding.bnvMain[0] is BottomNavigationMenuView) {
            for (i in 0..4) {
                if (i == 2) {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[2]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，默认的AppCompatImageView(图标) + BaselineLayout(文字)
                            childView.visibility = View.GONE//隐藏控件默认的两个子view
                        }
                        val publishLayout = LayoutInflater.from(mActivity)
                            .inflate(R.layout.view_bottom_navigation_publish, null)
                        if (it == 0) {
                            publishLayout.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                                .setBackgroundResource(publishDrawable[APP_COLOR_STATUS])
                        } else {
                            publishLayout.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                                .setBackgroundResource(publishDrawable[it])
                        }
                        publishLayout.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                            .setImageResource(R.mipmap.img_bottom_publish_white)
                        item.addView(publishLayout) //添加自己需要的带 + 的图标
                    }
                } else {
                    val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
                    if (item is BottomNavigationItemView) {
                        item.children.forEach { childView -> //就两个子view，AppCompatImageView(图标) + BaselineLayout(文字)
                            if (childView is ImageView) {
                                childView.setImageDrawable(
                                    ContextCompat.getDrawable(
                                        mActivity, bottomImages[i][it]
                                    )
                                )
                            } else if (childView is BaselineLayout) {

                                val text1 = childView[0] as TextView
                                val text2 = childView[1] as TextView
                                if (it == 0) {
                                    text2.setTextColor(
                                        ContextCompat.getColor(
                                            mActivity,
                                            viewColors[APP_COLOR_STATUS]
                                        )
                                    )
                                } else {
                                    text2.setTextColor(
                                        ContextCompat.getColor(
                                            mActivity,
                                            viewColors[it]
                                        )
                                    )
                                }
                                text1.setTextColor(
                                    ContextCompat.getColor(
                                        mActivity,
                                        R.color.black
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun MainFragment.appColorObserver(type: Int) {
    if (binding.bnvMain[0] is BottomNavigationMenuView) {
        for (i in 0..4) {
            val item = (binding.bnvMain[0] as BottomNavigationMenuView)[i]
            if (item is BottomNavigationItemView) {
                if (i == 2) {
                    val publishView =
                        item.findViewById<ConstraintLayout>(R.id.clayout_bottom_publish)
                    val publishImg =
                        item.findViewById<AppCompatImageView>(R.id.img_bottom_publish)
                    publishView.setBackgroundResource(publishDrawable[type])
                    publishImg.setImageResource(R.mipmap.img_bottom_publish_white)
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
                            if (type == 0) {
                                text2.setTextColor(
                                    ContextCompat.getColor(
                                        mActivity,
                                        viewColors[APP_COLOR_STATUS]
                                    )
                                )
                            } else {
                                text2.setTextColor(
                                    ContextCompat.getColor(
                                        mActivity,
                                        viewColors[type]
                                    )
                                )
                            }

                            text1.setTextColor(
                                ContextCompat.getColor(
                                    mActivity,
                                    R.color.black
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * <修改底部颜色>
 * @author: dongyiming
 * @date: 10/24/23 3:47 PM
 * @version: v1.0
 */
fun MainFragment.bottomUpDate(status: Int) {//status：变黑/白
    var indexArray = arrayOf(0, 1, 2, 3, 4)
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


}

fun MainFragment.bottomStateObserver(status: Int) {
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
        for (i in 0..4) {
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
                                publishView.setBackgroundResource(publishDrawable[APP_COLOR_STATUS])
                            } else {
                                publishView.setBackgroundResource(publishDrawable[type])
                            }
                            publishImg.setImageResource(R.mipmap.img_bottom_publish_white)
                        }
                        1 -> {//短视频底部
                            publishView.setBackgroundResource(R.drawable.shape_bottom_publish1)
                            publishImg.setImageResource(R.mipmap.img_bottom_publish1)
                        }
                    }
                } else {
                    Log.e("2mean", "333333")
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