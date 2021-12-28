package com.example.pandas.ui.view.refresh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R

/**
 * @description: 自定义RecyclerView的上拉加载
 * @author: dongyiming
 * @date: 12/27/21 6:11 下午
 * @version: v1.0
 */
public class Footer(context: Context) : FrameLayout(context) {

    //private var image: AppCompatImageView? = null
    private var message: AppCompatTextView? = null

    init {
        val footer = LayoutInflater.from(context).inflate(R.layout.footer_recyclerview, this)
        //image = footer.findViewById<AppCompatImageView>(R.id.img_footer)
        message = footer.findViewById<AppCompatTextView>(R.id.txt_footer)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    fun loading() {
        //启动动画
        //image?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.img_panda1))
        message?.text = context.getString(R.string.string_loading)
        visibility = View.VISIBLE
    }

    fun noMore() {
        //关闭动画
        message?.text = context.getString(R.string.string_nomore)
        visibility = View.VISIBLE
    }

    fun close() {
        message?.text = context.getString(R.string.string_load_finished)
        visibility = View.GONE
    }
}