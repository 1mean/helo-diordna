package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class LiveVisitorItemDecoration(private val paddingSide: Int, private val paddingMid: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildAdapterPosition(view)

        if (position == 0) {
            outRect.left = paddingSide
        }
        outRect.right = paddingMid
    }
}