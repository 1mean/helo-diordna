package com.example.pandas.utils

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import com.example.pandas.biz.interaction.SpanClickListener
import com.example.pandas.sql.entity.User
import com.example.pandas.sql.entity.VideoComment

/**
 * @description: SpannableString
 * @author: dongyiming
 * @date: 6/7/22 4:08 下午
 * @version: v1.0
 */
object SpannableStringUtils {

    private val spanString: SpannableStringBuilder by lazy { SpannableStringBuilder() }

    fun appendOneColorSpan(
        color: Int,
        content: String,
        startIndex: Int,
        endIndex: Int,
        listener: SpanClickListener<Int>
    ): SpannableStringBuilder {

        val clickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                listener.spanClick(1)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = color//设置颜色
                ds.isUnderlineText = false//去掉下划线
            }
        }
        spanString.run {
            append(content)
            setSpan(clickSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spanString
    }

    fun appendTwoSameColorSpan(
        color: Int,
        content: String,
        startIndex1: Int,
        endIndex1: Int,
        startIndex2: Int,
        endIndex2: Int
    ): SpannableStringBuilder {
        val colorSpan1 = ForegroundColorSpan(color)
        val colorSpan2 = ForegroundColorSpan(color)
        spanString.run {
            append(content)
            setSpan(colorSpan1, startIndex1, endIndex1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(colorSpan2, startIndex2, endIndex2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spanString
    }

    fun replyBuilder(
        color: Int,
        comment: VideoComment,
        user: User,
        listener: SpanClickListener<Int>
    ): SpannableStringBuilder {

        val fromUserName = user.userName ?: ""
        val toUserName = comment.toUserName
        val fromUserNameSize: Int = fromUserName.length
        if (comment.type == 2) {
            val spanContent =
                StringBuilder(fromUserName).append(": ").append(comment.content).toString()

            val clickSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    listener.spanClick(user.userCode)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.color = color//设置颜色
                    ds.isUnderlineText = false//去掉下划线
                }
            }
            spanString.run {
                clear()
                clearSpans()
                append(spanContent)
                setSpan(clickSpan, 0, fromUserNameSize, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        } else {
            val spanContent = StringBuilder(fromUserName).append(" 回复 ")
                .append("@$toUserName :")
                .append(comment.content).toString()

            val clickSpan1 = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    listener.spanClick(comment.fromUserCode)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.color = color//设置颜色
                    ds.isUnderlineText = false//去掉下划线
                }
            }
            val clickSpan2 = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    listener.spanClick(comment.toUserCode)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.color = color//设置颜色
                    ds.isUnderlineText = false//去掉下划线
                }
            }
            spanString.run {
                clear()
                clearSpans()
                append(spanContent)
                setSpan(clickSpan1, 0, fromUserNameSize, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                setSpan(
                    clickSpan2,
                    fromUserNameSize + 4,
                    fromUserNameSize + 5 + comment.toUserName.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return spanString
    }

    fun replyOneBuilder(
        color: Int,
        comment: VideoComment,
        listener: SpanClickListener<Int>
    ): SpannableStringBuilder {

        val toUserName = comment.toUserName
        val spanContent =
            StringBuilder("回复 @").append(toUserName).append(" :${comment.content}").toString()

        val clickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                listener.spanClick(comment.toUserCode)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = color//设置颜色
                ds.isUnderlineText = false//去掉下划线
            }
        }
        spanString.run {
            clear()
            clearSpans()
            append(spanContent)
            setSpan(clickSpan, 3, toUserName.length + 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spanString
    }
}