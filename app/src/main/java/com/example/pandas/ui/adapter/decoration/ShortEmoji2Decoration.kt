package com.example.pandas.ui.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: ShortEmojiDecoration
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class ShortEmoji2Decoration(context: Context) : RecyclerView.ItemDecoration() {

    private var paddingTop: Int =
        context.resources.getDimension(R.dimen.common_lh_16_dimens).toInt()
    private var paddingSide: Int =
        context.resources.getDimension(R.dimen.common_lh_6_dimens).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val columnIndex = position % 7
        val rowIndex = position / 7
        val paddingMid = paddingSide / 2

        if (rowIndex == 0) {
            outRect.top = paddingTop
        } else {
            outRect.top = 0
        }
        if (columnIndex == 0) {//最左边第一列
            outRect.left = paddingSide
            outRect.right = paddingMid
        } else if (columnIndex == 6) {//最右边
            outRect.left = paddingMid
            outRect.right = paddingSide
        } else {
            outRect.left = paddingMid
            outRect.right = paddingMid
        }
        outRect.bottom = 0
    }
}