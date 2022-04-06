package com.example.pandas.ui.view.refresh

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.R
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import kotlin.math.abs


/**
 * @description: 加载更多
 * @author: dongyiming
 * @date: 12/27/19 6:30 下午
 * @version: v1.0
 */
class LoadMoreRecyclerView : RecyclerView {

    private val TYPE_FOOTER = 999
    private var wrapAdapter: WrapAdapter? = null
    private var isLoadingData = false //正在上拉加载数据中
    private var isFreshing = false //正在下拉刷新数据中
    private var isNoMore = false //是否没有更多数据

    private var mDownX = 0
    private var mDownY = 0
    private var mScaleTouchSlop = 0

    private var mListener: ILoadMoreListener? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        mScaleTouchSlop = ViewConfiguration.get(getContext()).scaledTouchSlop
    }

    /**
     * 设置adapter
     * @return:
     * @date: 12/28/21 12:19 上午
     * @version: v1.0
     */
    fun setRefreshAdapter(adapter: Adapter<BaseEmptyViewHolder>, listener: ILoadMoreListener) {

        mListener = listener
        wrapAdapter = WrapAdapter(adapter)
        setAdapter(wrapAdapter)
        val observer = DataObserver()
        adapter.registerAdapterDataObserver(observer)
        observer.onChanged()
    }

    /**
     * 滑动状态改变的回调
     * @author: dongyiming
     * @date: 12/28/21 12:25 上午
     * @version: v1.0
     */
    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)

        if (state == SCROLL_STATE_IDLE && mListener != null && !isFreshing && !isLoadingData) {

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
                val total = wrapAdapter!!.realCount()
                layoutManager?.let {
                    val childCount =
                        layoutManager!!.childCount // 未隐藏的数目 childCount = count - hiddenCount
                    if (childCount > 0 && lastVisibleItemPosition >= total - 1 && total > childCount

                        && !isFreshing && !isNoMore
                    ) {
                        isLoadingData = true
                        mListener!!.onLoadMore()

                    }
                }
            }
        }
    }

    /**
     * 解决Viewpager2和Viewpager2以及RecyclerView的滑动冲突问题
     */
    private var startX = 0
    private var startY = 0
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = ev.x.toInt()
                startY = ev.y.toInt()
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = ev.x.toInt()
                val endY = ev.y.toInt()
                val disX = abs(endX - startX)
                val disY = abs(endY - startY)

                if (disY > disX) {
                    //如果是纵向滑动，告知父布局不进行事件拦截，交由子布局消费，　requestDisallowInterceptTouchEvent(true)
                    parent.requestDisallowInterceptTouchEvent(true)
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> parent.requestDisallowInterceptTouchEvent(
                false
            )
        }
        return super.onInterceptTouchEvent(ev)
    }

//    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
//
//        var isIntercepted = super.onInterceptTouchEvent(e)
//        Log.e("1mean", "pointerCount:${e.pointerCount}")
//        if (e.pointerCount > 1) return true
//
////    var touchPosition: Int = getChildAdapterPosition(findChildViewUnder(x, y)!!)
////    var touchVH = findViewHolderForAdapterPosition(touchPosition)
////    var touchView: SwipeMenuLayout? = null
////    if (touchVH != null)
////    {
////        val itemView: View = getSwipeMenuView(touchVH!!.itemView)
////        if (itemView is SwipeMenuLayout) {
////            touchView = itemView as SwipeMenuLayout
////        }
////    }
//
//        val action = e.action
//        val x = e.x.toInt()
//        val y = e.y.toInt()
//        when (action) {
//            MotionEvent.ACTION_DOWN -> {
//                mDownX = x
//                mDownY = y
//                isIntercepted = false
//            }
//            MotionEvent.ACTION_MOVE -> {
//                run { isIntercepted = handleUnDown(x, y, isIntercepted) }
//            }
//            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
//                isIntercepted = handleUnDown(x, y, isIntercepted)
//            }
//        }
//        return isIntercepted
//    }
//
//    private fun handleUnDown(x: Int, y: Int, defaultValue: Boolean): Boolean {
//        val disX: Int = mDownX - x
//        val disY: Int = mDownY - y
//
//        // swipe
//        if (abs(disX) > mScaleTouchSlop && abs(disX) > abs(disY)) return false
//        // click
//        return if (abs(disY) < mScaleTouchSlop && abs(disX) < mScaleTouchSlop) false else defaultValue
//    }

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

    inner class WrapAdapter(private val adapter: Adapter<BaseEmptyViewHolder>) :
        Adapter<BaseEmptyViewHolder>() {

        fun isFooter(position: Int): Boolean {

            return position == itemCount - 1
        }

        fun realCount(): Int = adapter.itemCount

        override fun getItemViewType(position: Int): Int {

            if (position == itemCount - 1) {
                return TYPE_FOOTER
            } else
                return adapter.getItemViewType(position)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

            if (viewType == TYPE_FOOTER) {
                val footer = LayoutInflater.from(parent.context)
                    .inflate(R.layout.footer_recyclerview, parent, false)
                return FooterViewHolder(footer)
            } else {
                return adapter.onCreateViewHolder(parent, viewType)
            }
        }

        override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

            if (getItemViewType(position) != TYPE_FOOTER) {
                adapter.onBindViewHolder(holder, position)
            } else {
                (holder as FooterViewHolder).handle()
            }
        }

        override fun getItemCount(): Int {
            val count = adapter.itemCount
            return if (count == 0) 0 else count + 1
        }

        override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
            adapter.onDetachedFromRecyclerView(recyclerView)
        }

        override fun onViewAttachedToWindow(holder: BaseEmptyViewHolder) {

            val layoutParams = holder.itemView.layoutParams

            if (layoutParams is StaggeredGridLayoutManager.LayoutParams && isFooter(holder.layoutPosition)) {
                layoutParams.isFullSpan = true
            }
            adapter.onViewAttachedToWindow(holder)
        }

        override fun onViewDetachedFromWindow(holder: BaseEmptyViewHolder) {
            adapter.onViewAttachedToWindow(holder)
        }

        override fun unregisterAdapterDataObserver(observer: AdapterDataObserver) {
            adapter.unregisterAdapterDataObserver(observer)
        }

        override fun registerAdapterDataObserver(observer: AdapterDataObserver) {
            adapter.registerAdapterDataObserver(observer)
        }


        override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
            super.onAttachedToRecyclerView(recyclerView)
            val manager = recyclerView.layoutManager
            if (manager is GridLayoutManager) {

                manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        if (isFooter(position)) {
                            return 2
                        } else if (getItemViewType(position) == 1 || getItemViewType(position) == 3) {//轮播图和横屏
                            return 2
                        } else {
                            return 1
                        }
                    }
                }
            }
        }

        inner class FooterViewHolder(itemView: View) : BaseEmptyViewHolder(itemView) {

            private val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
            private val txtFooter: AppCompatTextView = itemView.findViewById(R.id.txt_footer)
            private val footer: ConstraintLayout = itemView.findViewById(R.id.footer)

            fun handle() {
                if (isNoMore) {//没有更多数据
                    progressBar.visibility = GONE
                    txtFooter.visibility = VISIBLE
                } else {
                    progressBar.visibility = VISIBLE
                    txtFooter.visibility = GONE
                }
            }
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

    fun isLoading(): Boolean {
        return isLoadingData
    }

    fun isFreshing(freshing: Boolean) {
        isFreshing = freshing
        isLoadingData = false
        isNoMore = false
    }

    fun loadMoreFinished() {
        isLoadingData = false
        isNoMore = false
    }

    fun noMoreData() {
        isNoMore = true
        isLoadingData = false
    }

    interface ILoadMoreListener {
        fun onLoadMore()
    }

}