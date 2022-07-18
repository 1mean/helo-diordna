package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: CacheListItemDecoration
 * @author: dongyiming
 * @date: 7/18/22 5:32 下午
 * @version: v1.0
 */
public class CacheListItemDecoration : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(15, 0, 15, 45)
    }
}