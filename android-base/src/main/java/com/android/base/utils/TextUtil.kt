package com.android.base.utils

import android.content.Context
import android.os.Build
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.view.ViewTreeObserver
import android.widget.TextView

/**
 * TextUtil
 * @author: dongyiming
 * @date: 9/20/24 PM12:42
 * @version: v1.0
 */
object TextUtil {

    /**
     * "...展开" 的效果
     */
    fun toggleEllipsize(
        context: Context,
        textView: TextView,
        minLines: Int,
        originText: String,
        endText: String,
        endColorId: Int,
        isExpand: Boolean
    ) {
        if (TextUtils.isEmpty(originText)) return
        textView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (isExpand) {
                    textView.text = originText
                } else {
                    val paddingLeft = textView.paddingLeft
                    val paddingRight = textView.paddingRight
                    val paint = textView.paint
                    val moreText = textView.textSize * endText.length
                    val avaiableTextWidth =
                        (textView.width - paddingLeft - paddingRight) * minLines - moreText
                    val ellipsizeStr = TextUtils.ellipsize(
                        originText,
                        paint,
                        avaiableTextWidth,
                        TextUtils.TruncateAt.END
                    )
                    if (ellipsizeStr.length < originText.length) {
                        val temp = ellipsizeStr.toString() + endText
                        val ssb = SpannableStringBuilder(temp)
                        ssb.setSpan(
                            ForegroundColorSpan(context.resources.getColor(endColorId)),
                            temp.length - endText.length,
                            temp.length,
                            Spannable.SPAN_INCLUSIVE_EXCLUSIVE,
                        )
                        textView.text = ssb
                    } else {
                        textView.text = originText
                    }
                }
                if (Build.VERSION.SDK_INT == 16) {
                    textView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                } else {
                    textView.viewTreeObserver.removeGlobalOnLayoutListener(this)
                }
            }
        })
    }
}