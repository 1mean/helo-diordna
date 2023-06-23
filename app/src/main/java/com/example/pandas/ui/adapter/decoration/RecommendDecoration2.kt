package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: 推荐page分割线 padding不要为0容易出现不均分
 * @author: dongyiming
 * @date: 1/4/22 6:02 下午
 * @version: v1.0
 */
public class RecommendDecoration2(
    private val leftSpace: Int = 0,
    private val topSpace: Int = 0,
    private val rightSpace: Int = 0,
    private val midSpace: Int = 0,
    private val bottomSpace: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            val manager = layoutManager as GridLayoutManager
            val spanCounts = manager.spanCount

            val totalSpace = leftSpace + rightSpace + midSpace * (spanCounts - 1)
            val itemNeedSpace = totalSpace / spanCounts

            val curPos = parent.getChildAdapterPosition(view)

            if (curPos == 0) { //轮播图和横屏视频播放item
                outRect.set(leftSpace, topSpace, rightSpace, bottomSpace)
            } else if (curPos % 11 == 0) {
                outRect.set(leftSpace, 0, rightSpace, bottomSpace)
            } else if (((curPos % 11) % 2) == 0) {//最右边
                outRect.top = 0
                outRect.bottom = bottomSpace
                outRect.right = rightSpace
                outRect.left = itemNeedSpace - rightSpace
            } else {//最左边
                outRect.top = 0
                outRect.bottom = bottomSpace
                outRect.left = leftSpace
                outRect.right = itemNeedSpace - leftSpace
            }
        }
    }
}