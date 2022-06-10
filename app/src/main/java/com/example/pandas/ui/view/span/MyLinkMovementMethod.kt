package com.example.pandas.ui.view.span

import android.os.Build
import android.text.Selection
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi

/**
 * @description: com.example.pandas.ui.view.span.MyLinkMovementMethod
 * @author: dongyiming
 * @date: 6/7/22 6:19 下午
 * @version: v1.0
 */
val LickMovementMethodInstance: MyLinkMovementMethod by lazy { MyLinkMovementMethod() }

public class MyLinkMovementMethod : LinkMovementMethod() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {

        val action = event.action
        if (action == MotionEvent.ACTION_UP ||
            action == MotionEvent.ACTION_DOWN
        ) {
            var x = event.x.toInt()
            var y = event.y.toInt()
            x -= widget.totalPaddingLeft
            y -= widget.totalPaddingTop
            x += widget.scrollX
            y += widget.scrollY
            val layout = widget.layout
            val line = layout.getLineForVertical(y)
            val off = layout.getOffsetForHorizontal(line, x.toFloat())
            val link = buffer.getSpans(off, off, ClickableSpan::class.java)
            if (link.isNotEmpty()) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget)
                } else if (action == MotionEvent.ACTION_DOWN) {
                    Selection.setSelection(
                        buffer,
                        buffer.getSpanStart(link[0]),
                        buffer.getSpanEnd(link[0])
                    )
                }
                return true
            } else {
                Selection.removeSelection(buffer)
            }
        }
        return super.onTouchEvent(widget, buffer, event)
    }

    /**
     * 当点击点和textview的父布局发生冲突时，替换掉上面的代码
     */
    fun doTopLayoutInflect(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        val isConsume = super.onTouchEvent(widget, buffer, event);
        if (!isConsume && event.action == MotionEvent.ACTION_UP) {
            val parent = widget.parent;
            if (parent is ViewGroup) {
                // 获取被点击控件的父容器，让父容器执行点击；
                (parent as ViewGroup).performClick();
            }
        }
        return isConsume
    }
}