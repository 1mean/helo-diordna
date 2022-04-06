package com.example.pandas.ui.adapter.decoration
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: PandaDecoration
 * @author: dongyiming
 * @date: 1/24/22 2:31 上午
 * @version: v1.0
 */
public class PandaDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    private var padding1: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()
    private var padding2: Int = context.resources.getDimension(R.dimen.common_lh_8_dimens).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        Log.e("1mean", "position: $position")
//        if (position == 0) {
//            outRect.set(padding2, padding1, padding2, 0)
//        } else {
//            if (position % 2 == 1) {
//                outRect.left = padding2
////                outRect.set(padding2, padding1, 0, 0)
//            } else {
//                outRect.left = padding2
////                outRect.set(padding2, padding1, padding2, 0)
//            }
//            outRect.top = padding1
//        }
        if (position == 0) {
            outRect.top = padding1
        } else {
            if (position % 2 == 0) {
                outRect.left = padding2
            }
            outRect.top = padding1
        }
    }
}