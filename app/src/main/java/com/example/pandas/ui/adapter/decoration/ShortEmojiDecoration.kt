package com.example.pandas.ui.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: ShortEmojiDecoration
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class ShortEmojiDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var paddingLeft: Int =
        context.resources.getDimension(R.dimen.common_lh_20_dimens).toInt()
    private var paddingMid: Int =
        context.resources.getDimension(R.dimen.common_lh_6_dimens).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.set(paddingLeft, 0, 0, 0)
        } else{
            outRect.set(paddingMid, 0, 0, 0)
        }
    }
}