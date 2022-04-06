package com.example.pandas.ui.adapter.decoration
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: 只有一个方向offset的ItemDecoration
 * @author: dongyiming
 * @date: 2/4/22 2:31 上午
 * @version: v1.0
 */
public class OneDirectionItemDecoration(
    private val isLeft: Boolean = false,
    private val isTop: Boolean = false,
    private val isRight: Boolean = false,
    private val isBottom: Boolean = false,
    private val padding: Int
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        when {
            isLeft -> outRect.left = padding
            isTop -> outRect.top = padding
            isRight -> outRect.right = padding
            isBottom -> outRect.bottom = padding
        }
    }
}