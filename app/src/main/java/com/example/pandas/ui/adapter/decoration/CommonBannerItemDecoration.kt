package com.example.pandas.ui.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: CacheListItemDecoration
 * @author: dongyiming
 * @date: 7/18/22 5:32 下午
 * @version: v1.0
 */
public class CommonBannerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var paddingTop1: Int = context.resources.getDimension(R.dimen.common_lh_8_dimens).toInt()
    private var paddingTop2: Int = context.resources.getDimension(R.dimen.common_lh_16_dimens).toInt()
    private var paddingHorizontal: Int = context.resources.getDimension(R.dimen.dimen_padding_panda_child).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val columnIndex = position % 2
        val paddingMid = paddingHorizontal / 2

        if (columnIndex == 0) {
            if (position == 0) {
                outRect.set(paddingHorizontal, paddingTop1, paddingMid, 0)
            } else {
                outRect.set(paddingHorizontal, paddingTop2, paddingMid, 0)
            }
        } else {
            if (position == 1) {
                outRect.set(paddingMid, paddingTop1, paddingHorizontal, 0)
            } else {
                outRect.set(paddingMid, paddingTop2, paddingHorizontal, 0)
            }
        }
    }
}