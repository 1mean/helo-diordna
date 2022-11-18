package com.example.pandas.learn;

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

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


