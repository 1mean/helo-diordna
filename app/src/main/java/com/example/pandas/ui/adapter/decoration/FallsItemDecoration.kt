package com.example.pandas.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * @description: falls瀑布流的itemDecoration
 * @author: dongyiming
 * @date: 2/5/22 2:52 下午
 * @version: v1.0
 */
public class FallsItemDecoration(
    private val spanCounts: Int = 2,
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

        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            val manager = layoutManager as GridLayoutManager
            val spanCounts = manager.spanCount

            val totalSpace = leftSpace + rightSpace + midSpace * (spanCounts - 1)
            val itemNeedSpace = totalSpace / spanCounts

            val curPos = parent.getChildAdapterPosition(view)
            if (curPos % spanCounts == 0) {//最左边
                outRect.left = leftSpace
                outRect.right = itemNeedSpace - leftSpace
            } else if (curPos % spanCounts == spanCounts - 1) {
                outRect.left = itemNeedSpace - rightSpace
                outRect.right = rightSpace
            } else {
                outRect.left = itemNeedSpace / 2
                outRect.right = itemNeedSpace / 2
            }
            outRect.top = topSpace
            outRect.bottom = bottomSpace
        } else {
            val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
            val totalSpace = leftSpace + rightSpace + midSpace * (spanCounts - 1)
            val itemNeedSpace = totalSpace / spanCounts

            val spanIndex = lp.spanIndex
            if (spanIndex == 0) {//最左边
                outRect.left = leftSpace
                outRect.right = itemNeedSpace - leftSpace
            } else if (spanIndex == spanCounts - 1) {//最右侧
                outRect.left = itemNeedSpace - rightSpace
                outRect.right = rightSpace
            } else {//最右边
                outRect.left = itemNeedSpace / 2
                outRect.right = itemNeedSpace / 2
            }
            outRect.top = topSpace
            outRect.bottom = bottomSpace
        }
    }

    //如果有banner，StaggeredGridLayoutManager添加如下设置
//    open fun onViewAttachedToWindow(holder: BaseHolder) {
//        super.onViewAttachedToWindow(holder)
//        val index: Int = holder.getLayoutPosition()
//        //判断若为banner类型，占满一行
//        if (getItemViewType(index) === 0) {
//            val lp: ViewGroup.LayoutParams = holder.itemView.getLayoutParams()
//            if (lp != null && lp is StaggeredGridLayoutManager.LayoutParams) {
//                lp.isFullSpan = true
//            }
//        }
//    }

    //如果有占满一行的
//    manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//        override fun getSpanSize(position: Int): Int {
//            if (isFooter(position)) {
//                return 2
//            } else if (getItemViewType(position) == 1 || getItemViewType(position) == 3) {//轮播图和横屏
//                return 2
//            } else {
//                return 1
//            }
//        }
//    }


}