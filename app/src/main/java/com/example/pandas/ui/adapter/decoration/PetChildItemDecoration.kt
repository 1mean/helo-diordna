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
public class PetChildItemDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val columnIndex = position % 2
        val paddingMid = padding / 2

        if (columnIndex == 0) {
            if (position == 0) {
                outRect.set(padding, 0, paddingMid, 0)
            } else {
                outRect.set(padding, padding, paddingMid, 0)
            }
        } else {
            if (position == 1) {
                outRect.set(paddingMid, 0, padding, 0)
            } else {
                outRect.set(paddingMid, padding, padding, 0)
            }
        }
    }
}