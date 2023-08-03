package com.example.pandas.ui.view

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.helo_base.magic.ArgbEvaluatorHolder
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.pandas.R

/**
 * @description: 带有评论数的tabView
 * @author: dongyiming
 * @date: 7/30/22 5:03 下午
 * @version: v1.0
 */
public class VideoTabView(context: Context) : LinearLayoutCompat(context), IPagerTitleView {

    private val title: AppCompatTextView
    private val num: AppCompatTextView
    private var mSelectedColor: Int? = null
    private var mNormalColor: Int? = null

    init {
        layoutParams = ViewGroup.LayoutParams(-1, -2)
        gravity = Gravity.CENTER
        View.inflate(context, R.layout.tb_item_videoplay, this)
        title = findViewById(R.id.txt_tb_title_video)
        num = findViewById(R.id.txt_tb_comment_counts)
    }

    fun updateTitle(count: Int) {
        num.visibility = View.VISIBLE
        num.text = count.toString()
    }

    fun updateComments() {

        var nums = num.text.toString().toInt()
        nums += 1
        num.text = nums.toString()
    }

    fun hideNum() {
        num.visibility = View.GONE
    }

    fun setTextTitle(value: String) {
        title.text = value
    }

    override fun onSelected(index: Int, totalCount: Int) {
        mSelectedColor?.let {
            title.setTextColor(it)
            num.setTextColor(it)
        }
    }

    override fun onDeselected(index: Int, totalCount: Int) {

        mNormalColor?.let {
            title.setTextColor(it)
            num.setTextColor(it)
        }
    }

    override fun onLeave(index: Int, totalCount: Int, leavePercent: Float, leftToRight: Boolean) {

        val color = ArgbEvaluatorHolder.eval(
            leavePercent, mSelectedColor!!,
            mNormalColor!!
        )
        title.setTextColor(color)
        num.setTextColor(color)
    }

    override fun onEnter(index: Int, totalCount: Int, enterPercent: Float, leftToRight: Boolean) {

        val color = ArgbEvaluatorHolder.eval(
            enterPercent, mNormalColor!!,
            mSelectedColor!!
        )
        title.setTextColor(color)
        num.setTextColor(color)
    }

    fun getSelectedColor(): Int? {
        return mSelectedColor
    }

    fun setSelectedColor(selectedColor: Int) {
        mSelectedColor = selectedColor
    }

    fun getNormalColor(): Int? {
        return mNormalColor
    }

    fun setNormalColor(normalColor: Int) {
        mNormalColor = normalColor
    }
}