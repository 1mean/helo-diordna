package com.example.pandas.ui.adapter.decoration
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * 【等分必须满足，paddingleft + paddingright 的和相同】
 * @description: common ItemDecoration
 * @author: dongyiming
 * @date: 4/12/22 6:06 下午
 * @version: v1.0
 */
public class CommonItemDecoration(
    private val hasTop: Boolean = false,//是否有单独的top
    private val spanCount: Int = 1,
    private val paddingTop: Int = 0,//垂直方向的padding
    private val paddingHorizontal: Int = 0, //水平方向的padding
    private val paddingBottom: Int = 0//垂直方向的padding
) : RecyclerView.ItemDecoration() {

    private var columnIndex = 0//当前view属于第几列
    private val paddingMid = paddingHorizontal / 2

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        columnIndex = if (hasTop) {
            (position - 1) % spanCount
        } else {
            position % spanCount
        }

        if (hasTop && position == 0) {
            outRect.set(paddingHorizontal, paddingTop, paddingHorizontal, paddingBottom)
        } else {
            //最左边和最右边的padding和中间位置的padding不同
            if (columnIndex == 0) {
                outRect.set(paddingHorizontal, paddingTop, paddingMid, paddingBottom)
            } else if (columnIndex == (spanCount - 1)) {
                outRect.set(paddingMid, paddingTop, paddingHorizontal, paddingBottom)
            } else {
                outRect.set(paddingMid, paddingTop, paddingMid, paddingBottom)
            }
        }
    }

    /**
     * <绘制背景的效果，内容在上面，即在getItemOffsets的padding区域作画>
     * @param:
     * @version: v1.0
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

    }

    /**
     * <绘制在内容的上面，覆盖内容>
     * @param:
     * @version: v1.0
     */
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
}