package com.example.pandas.learn;

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.example.pandas.ui.activity.MainActivity

fun ViewGroup.circularClose(button: ImageButton, action: () -> Unit = {}) {
    ViewAnimationUtils.createCircularReveal(
        this,
        button.x.toInt() + button.width / 2,
        button.y.toInt() + button.height / 2,
        if (button.context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) this.width.toFloat() else this.height.toFloat(),
        0f
    ).apply {
        duration = 500
        doOnStart { action() }
        doOnEnd { visibility = View.GONE }
    }.start()
}

fun View.onWindowInsets(action: (View, WindowInsetsCompat) -> Unit) {
    ViewCompat.requestApplyInsets(this)
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        action(v, insets)
        insets
    }
}

val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)

var View.topMargin: Int
    get() = (this.layoutParams as ViewGroup.MarginLayoutParams).topMargin
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> { topMargin = value }
    }

var View.topPadding: Int
    get() = paddingTop
    set(value) {
        updateLayoutParams { setPaddingRelative(paddingStart, value, paddingEnd, paddingBottom) }
    }

var View.bottomMargin: Int
    get() = (this.layoutParams as ViewGroup.MarginLayoutParams).bottomMargin
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> { bottomMargin = value }
    }

var View.endMargin: Int
    get() = (this.layoutParams as ViewGroup.MarginLayoutParams).marginEnd
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> { marginEnd = value }
    }

var name: String = "zhang"
    // 这里使用field而不是使用lastName, 是因为如果使用lastName会造成递归调用从而造成内存溢出, 因为使用lastName也会涉及到调用set/get的问题
    get() = field.toUpperCase()

var no: Int = 0
    get() = field
    set(value) {
        if (value < 10) {
            field = value
        } else {
            field = -1
        }
    }

var classTeacher: String? = "孔子"
    set(value) = if (value == null) {
        field = "孔圣人"
    } else {
        field = value
    }


sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

//FATAL EXCEPTION: main
//Process: com.example.hello_diordna, PID: 31127
//java.util.ConcurrentModificationException
//      at java.util.ArrayList$SubList.size(ArrayList.java:1057)//这里不能点，但是能看到是SubList方法导致的bug，虽然这一步在直接报错点之前
//      at ShortReplyCommentAdapter.loadMore(ShortReplyCommentAdapter.kt:42) //这里能直接点进去，定位到报错的代码，但无法找到与报错有什么关系
//      at ShortCommentAdapter$ReplyCommentViewHolder.handle$lambda-6(ShortCommentAdapter.kt:292)


fun MainActivity.test(text: TextView) {

    kotlin.runCatching {
        val color = Color.parseColor("#433333")
        text.setTextColor(color)
    }.onFailure {
        Log.e("1mean", "test")
    }
}

