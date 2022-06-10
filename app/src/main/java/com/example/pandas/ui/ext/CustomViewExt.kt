package com.example.pandas.ui.ext;

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.pandas.R
import com.example.pandas.ui.adapter.SleepVideoItemAdapter
import com.example.pandas.ui.adapter.decoration.CommonItemDecoration
import com.example.pandas.ui.adapter.decoration.RecommendDecoration
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.view.recyclerview.CommonFooter
import com.example.pandas.ui.view.recyclerview.LoadMoreRecyclerView
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView


/**
 * 绑定上拉加载RecyclerView
 */
fun LoadMoreRecyclerView.initReco(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: LoadMoreRecyclerView.ILoadMoreListener
): LoadMoreRecyclerView {

    val padding: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter, listener)
    addItemDecoration(RecommendDecoration(context))
//    addItemDecoration(CommonItemDecoration(true, 2, padding, padding))
    return this
}

fun LoadMoreRecyclerView.initPanda(
    manger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<BaseEmptyViewHolder>,
    listener: LoadMoreRecyclerView.ILoadMoreListener
): LoadMoreRecyclerView {
    val paddingTop: Int = context.resources.getDimension(R.dimen.item_panda_paddingTop).toInt()
    val paddingHorinzontal: Int =
        context.resources.getDimension(R.dimen.item_panda_paddingLeft).toInt()
    this.layoutManager = manger
    setRefreshAdapter(bindAdapter, listener)
    addItemDecoration(CommonItemDecoration(true, 2, paddingTop, paddingHorinzontal))
    return this
}

fun SwipeRefreshLayout.setRefreshColor(): SwipeRefreshLayout {
    this.setColorSchemeResources(R.color.color_tab_indicator)
    return this
}

fun SwipRecyclerView.init(
    itemDecoration: RecyclerView.ItemDecoration? = null,
    adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
    manager: RecyclerView.LayoutManager,
    listener: SwipRecyclerView.ILoadMoreListener
): SwipRecyclerView {

    addFooterView(CommonFooter(context))
    layoutManager = manager
    itemDecoration?.let {
        addItemDecoration(it)
    }
    setRefreshAdapter(adapter, listener)
    return this
}

fun SwipRecyclerView.initNoFooter(
    itemDecoration: RecyclerView.ItemDecoration? = null,
    adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
    manager: RecyclerView.LayoutManager,
    listener: SwipRecyclerView.ILoadMoreListener?
): SwipRecyclerView {

    layoutManager = manager
    itemDecoration?.let {
        addItemDecoration(it)
    }
    setRefreshAdapter(adapter, listener)
    return this
}

fun RecyclerView.initRv(context: Context, mAdapter: SleepVideoItemAdapter): RecyclerView {
    val padding: Int = context.resources.getDimension(R.dimen.item_horizontal_padding).toInt()
    addItemDecoration(CommonItemDecoration(false, 2, 0, padding, padding))
    layoutManager = GridLayoutManager(context, 2)
    adapter = mAdapter
    return this
}

/**
 * 隐藏软键盘
 */
fun hideSoftKeyboard(activity: Activity?) {
    activity?.let { act ->
        val view = act.currentFocus
        view?.let {
            val inputMethodManager =
                act.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                it.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}

/**
 * 设置字体加粗
 */
fun setTextType(isBold: Boolean, value: TextView) {
    if (isBold) {
        value.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
    } else {
        value.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    }
}

/**
 * 图片像素为65px
 */
fun setLevelImageResourse(level: Int, imageView: AppCompatImageView) {

    when (level) {
        0 -> imageView.setImageResource(R.mipmap.img_level_0)
        1 -> imageView.setImageResource(R.mipmap.img_level_1)
        2 -> imageView.setImageResource(R.mipmap.img_level_2)
        3 -> imageView.setImageResource(R.mipmap.img_level_3)
        4 -> imageView.setImageResource(R.mipmap.img_level_4)
        5 -> imageView.setImageResource(R.mipmap.img_level_5)
        6 -> imageView.setImageResource(R.mipmap.img_level_6)
        7 -> imageView.setImageResource(R.mipmap.img_level7)
        8 -> imageView.setImageResource(R.mipmap.img_level8)
        9 -> imageView.setImageResource(R.mipmap.img_level9)
    }
}
