package com.example.pandas.ui.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: 推荐page分割线 padding不要为0容易出现不均分
 * @author: dongyiming
 * @date: 1/4/22 6:02 下午
 * @version: v1.0
 */
public class RecommendDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val midPadding = padding / 2
        if (position == 0 || position % 11 == 0) { //轮播图
            outRect.set(padding, padding, padding, 0)
        } else if (((position % 11) % 2) == 0) {//GlideView右列
            outRect.set(midPadding, padding, padding, 0)
        } else {//GlideView左列
            outRect.set(padding, padding, midPadding, 0)
        }
    }
}