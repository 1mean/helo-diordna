package com.example.pandas.ui.view.recyclerview

import OnItemClickListener
import OnItemLongClickListener
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.math.abs


/**
 * @description: 加载更多
 * @author: dongyiming
 * @date: 12/27/19 6:30 下午
 * @version: v1.0
 */
open class SwipRecyclerView : RecyclerView {

    private var wrapAdapter: AdapterWrapper? = null
    private var isLoadingData = false //正在上拉加载数据中，不允许下拉刷新
    private var isRefreshing = false //正在下拉刷新数据中，不允许上拉加载
    private var hasMore = true //是否有更多数据
    private var autoLoadMore = true //滚动到最后一个时会加载更多
    private var hasIntercept = true
    private var isLoadError = false //是否加载错误

    private var onItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: OnItemLongClickListener? = null

    private var mDownX = 0
    private var mDownY = 0
    private var mScaleTouchSlop = 0

    private var mListener: ILoadMoreListener? = null
    private var footerView: View? = null
    private var loadMoreView: SwipLoadMoreView? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        mScaleTouchSlop = ViewConfiguration.get(getContext()).scaledTouchSlop
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }

    /**
     * 设置adapter
     * @return:
     * @date: 12/28/21 12:19 上午
     * @version: v1.0
     */
    fun setRefreshAdapter(adapter: Adapter<out ViewHolder>, listener: ILoadMoreListener?) {

        mListener = listener
        wrapAdapter = AdapterWrapper(adapter as Adapter<ViewHolder>)
        footerView?.let {
            wrapAdapter!!.addFooter(it)
        }
        onItemClickListener?.let {
            wrapAdapter!!.setOnItemClickListener(it)
        }
        onItemLongClickListener?.let {
            wrapAdapter!!.setOnItemLongClickListener(it)
        }

        val observer = DataObserver()
        adapter.registerAdapterDataObserver(observer)
        observer.onChanged()
        setAdapter(wrapAdapter)
        if (hasIntercept) {
            addOnItemTouchListener(touchListener)
        }
    }

    fun setRefreshAdapterIgnore(adapter: Adapter<out ViewHolder>, listener: ILoadMoreListener?) {

        mListener = listener
        wrapAdapter = AdapterWrapper(adapter as Adapter<ViewHolder>)
        footerView?.let {
            wrapAdapter!!.addFooter(it)
        }
        onItemClickListener?.let {
            wrapAdapter!!.setOnItemClickListener(it)
        }
        onItemLongClickListener?.let {
            wrapAdapter!!.setOnItemLongClickListener(it)
        }

        val observer = DataObserver()
        adapter.registerAdapterDataObserver(observer)
        observer.onChanged()
        setAdapter(wrapAdapter)
    }

    /**
     * 滑动状态改变的回调
     * @author: dongyiming
     * @date: 12/28/21 12:25 上午
     * @version: v1.0
     */
    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)

        if (state == SCROLL_STATE_IDLE && mListener != null && !isRefreshing && !isLoadingData && autoLoadMore) {

            val lastVisibleItemPosition = if (layoutManager is GridLayoutManager) {
                (layoutManager as GridLayoutManager).findLastVisibleItemPosition()
            } else if (layoutManager is StaggeredGridLayoutManager) {

                val manager = layoutManager as StaggeredGridLayoutManager
                val array = IntArray(manager.spanCount)
                manager.findLastVisibleItemPositions(array)
                findMax(array)
            } else {
                (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            }
            wrapAdapter?.let {
                val total = wrapAdapter!!.getCurrentItemCount()
                layoutManager?.let {
                    val childCount =
                        layoutManager!!.childCount // 未隐藏的数目 childCount = count - hiddenCount
                    if (childCount > 0 && lastVisibleItemPosition >= total - 1 && total > childCount

                        && !isRefreshing && hasMore
                    ) {
                        dispatchLoadMore()
                    }
                }
            }
        }
    }

    private fun dispatchLoadMore() {

        isLoadingData = true
        loadMoreView?.onLoading()//显示正在加载中
        mListener?.onLoadMore()
    }

    inner class DataObserver : AdapterDataObserver() {

        //每次执行adapter notifyDataSetChanged 时调用，第一次添加adapter时不会执行
        @SuppressLint("NotifyDataSetChanged")
        override fun onChanged() {
            wrapAdapter?.notifyDataSetChanged()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            wrapAdapter?.notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            wrapAdapter?.notifyItemRangeChanged(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            wrapAdapter?.notifyItemRangeChanged(positionStart, itemCount, payload)
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            wrapAdapter?.notifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            wrapAdapter?.notifyItemMoved(fromPosition, toPosition)
        }
    }


    private fun findMax(lastPositions: IntArray): Int {
        var max = lastPositions[0]
        for (value in lastPositions) {
            if (value > max) {
                max = value
            }
        }
        return max
    }

    /*--提供调用方法------------------------------------------------------------------------------*/


    /**
     * 正在下拉刷新数据
     */
    fun isRefreshing(refreshing: Boolean) {
        isRefreshing = refreshing
        isLoadingData = false
    }


    fun loadMoreFinished(isEmpty: Boolean, hasMore: Boolean) {
        isLoadingData = false
        this.hasMore = hasMore

        loadMoreView?.onLoadFinished(isEmpty, hasMore)
    }

    interface ILoadMoreListener {
        fun onLoadMore()
    }

    fun addFooterView(footerView: View) {
        this.footerView = footerView
        this.loadMoreView = footerView as SwipLoadMoreView
    }

    fun setAutoLoadMore(autoLoadMore: Boolean): SwipRecyclerView {
        this.autoLoadMore = autoLoadMore
        return this
    }

    fun setIntercept(hasIntercept: Boolean): SwipRecyclerView {
        this.hasIntercept = hasIntercept
        return this
    }

    var initialX: Float = 0f
    var initialY: Float = 0f
    private val touchListener = object : OnItemTouchListener {
        override fun onInterceptTouchEvent(rv: RecyclerView, ev: MotionEvent): Boolean {

            when (ev.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = ev.x
                    initialY = ev.y
                    Log.e("vp2vp2","recyclerview down 111")
                    parent.requestDisallowInterceptTouchEvent(true)
                }
                MotionEvent.ACTION_MOVE -> {
                    val dx = ev.x - initialX
                    val dy = ev.y - initialY

                    val deltaX = abs(dx)
                    val deltaY = abs(dy)

                    Log.e("vp2vp2","deltaX: $deltaX, deltaY: $deltaY")
                    //bug:这里如果不设置两个.5f的话，左右滑动会比较吃力
                    if (deltaX > mScaleTouchSlop * .5f || deltaY > mScaleTouchSlop) {
                        if (deltaX > deltaY) {
                            //bug:还有个问题未解决：下拉刷新时，再继续上下滑动，容易触发往左右滑动
                            Log.e("vp2vp2","recyclerview down 222")
                            Log.d("vp2vp2", "recyclerVIew  move  111")
                            parent.requestDisallowInterceptTouchEvent(false)
                        } else {
                            Log.e("vp2vp2","recyclerview down 333")
                            Log.d("vp2vp2", "recyclerVIew  move  222")
                            parent.requestDisallowInterceptTouchEvent(true)
                        }
                    }
                }
                MotionEvent.ACTION_UP -> {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
            return false
        }

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        }
    }
}