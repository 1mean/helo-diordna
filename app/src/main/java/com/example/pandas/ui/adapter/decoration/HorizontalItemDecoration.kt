package com.example.pandas.ui.adapter.decoration
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: 只有水平间隔
 * @author: dongyiming
 * @date: 1/31/22 2:19 下午
 * @version: v1.0
 */
public class HorizontalItemDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.left = padding
        } else
            outRect.left = 0
        outRect.right = padding
    }
}