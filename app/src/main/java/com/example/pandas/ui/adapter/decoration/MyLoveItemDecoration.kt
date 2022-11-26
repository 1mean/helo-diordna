package com.example.pandas.ui.adapter.decoration
import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: love fragment
 * @author: dongyiming
 * @date: 1/31/22 1:27 上午
 * @version: v1.0
 */
public class MyLoveItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()
    private var padding2: Int = context.resources.getDimension(R.dimen.common_sz_15_dimens).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        when (parent.getChildAdapterPosition(view)) {
            0 -> outRect.set(padding, padding, padding, padding2)
            else -> outRect.set(padding, 0, padding, padding2)
        }
    }
}