package com.example.pandas.ui.view.recyclerview

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.pandas.R

/**
 * @description: 通用footer
 * @author: dongyiming
 * @date: 12/27/21 6:11 下午
 * @version: v1.0
 */
public class CommonFooter(context: Context) : LinearLayoutCompat(context), SwipLoadMoreView,
    View.OnClickListener {

    private val message: AppCompatTextView
    private val mProgressBar: ProgressBar

    init {
        layoutParams = ViewGroup.LayoutParams(-1, -2)
        gravity = Gravity.CENTER
        visibility = View.GONE
        View.inflate(context, R.layout.footer_recyclerview, this)
        message = findViewById(R.id.txt_footer)
        mProgressBar = findViewById(R.id.progressBar)
        setOnClickListener(this)
    }

    override fun onLoading() {
        visibility = View.VISIBLE
        mProgressBar.visibility = View.VISIBLE
        message.visibility = View.GONE
    }

    override fun onLoadFinished(isEmpty: Boolean, hasMore: Boolean) {

        if (hasMore) {
            visibility = View.GONE
        } else {
            visibility = View.VISIBLE
            if (isEmpty) {
                mProgressBar.visibility = View.GONE
                message.visibility = View.VISIBLE
                message.postDelayed({
                    message.text = "暂时没有数据"
                },350)
            } else {
                mProgressBar.visibility = View.GONE
                message.visibility = View.VISIBLE
                message.postDelayed({//延时是为了避免每次加载时都显示文字，效果比较突兀
                    message.text = "没有更多数据啦"
                },350)
            }
        }
    }

    override fun onLoadError(errorCode: Int, errorMessage: String) {

        visibility = View.VISIBLE
        mProgressBar.visibility = View.GONE
        message.visibility = View.VISIBLE
        message.text = errorMessage
    }

    override fun onClick(v: View?) {
    }
}