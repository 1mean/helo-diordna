package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: BackgroundItemDecoration
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class BackgroundItemDecoration(
    private val topSpace: Int = 0,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val manager = parent.layoutManager as GridLayoutManager
        val spanCounts = manager.spanCount

        val curPos = parent.getChildAdapterPosition(view)
        if (curPos / spanCounts == 0) {//第一行
            outRect.top = 0
        } else {
            outRect.top = topSpace
        }
    }
}