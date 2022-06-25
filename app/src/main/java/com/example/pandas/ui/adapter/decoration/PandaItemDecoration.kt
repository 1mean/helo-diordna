package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: PandaItemDecoration
 * @author: dongyiming
 * @date: 6/24/22 9:33 上午
 * @version: v1.0
 */
public class PandaItemDecoration(private val paddingTop: Int, private val paddingHorinzontal: Int) :
    RecyclerView.ItemDecoration() {

    private val paddingMid = paddingHorinzontal / 2
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val columnIndex = position % 2
        if (position == 0) {
            outRect.set(paddingHorinzontal, paddingTop, paddingHorinzontal, 0)
        } else if (position == 1) {
            outRect.set(0, paddingTop, 0, 0)
        } else {
            if (columnIndex == 0) {//左边
                outRect.set(paddingHorinzontal, paddingTop, paddingMid, 0)
            } else {//右边
                outRect.set(paddingMid, paddingTop, paddingHorinzontal, 0)
            }
        }
    }
}