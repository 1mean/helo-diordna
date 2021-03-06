package com.example.pandas.ui.adapter.decoration
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: CommentItemDecoration
 * @author: dongyiming
 * @date: 6/9/22 5:32 下午
 * @version: v1.0
 */
public class CommentItemDecoration(private val paddingBottom: Int = 0) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.bottom = paddingBottom
        }
    }
}