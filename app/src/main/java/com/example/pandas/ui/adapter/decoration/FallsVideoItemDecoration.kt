package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: falls瀑布流的itemDecoration
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class FallsVideoItemDecoration(
    val mSpanCounts: Int,
    val leftSpace: Int = 0,
    val topSpace: Int = 0,
    val rightSpace: Int = 0,
    val bottomSpace: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val itemPos = parent.getChildAdapterPosition(view)
        val currentRow = itemPos / mSpanCounts //当前view所处的行,从0开始
        val currentColumn = itemPos % mSpanCounts //当前view所处的列,从0开始

        //outRect.set(leftSpace, topSpace, rightSpace, 0)
//        if (currentRow == 0) { //第一行
//            outRect.top = 0
//        }

        if (currentColumn == 0) {//最后一列，right为0
            outRect.set(leftSpace, topSpace, rightSpace / 2, 0)
        } else {
            outRect.set(leftSpace / 2, topSpace, rightSpace, 0)
        }
    }
}