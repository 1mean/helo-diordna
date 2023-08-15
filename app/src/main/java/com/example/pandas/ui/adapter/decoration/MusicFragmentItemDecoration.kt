package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: ShareItemDecoration
 * @author: dongyiming
 * @date: 8/4/22 5:35 下午
 * @version: v1.0
 */
public class MusicFragmentItemDecoration(val marginTop: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = marginTop



    }
}