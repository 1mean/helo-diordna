package com.example.pandas.ui.view.refresh

import BaseEmptyViewHolder
import ILoadMoreListener
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.*
import com.example.pandas.R
import kotlinx.coroutines.Runnable

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/27/21 6:30 下午
 * @version: v1.0
 */
public class RefreshRecyclerView : RecyclerView {

    private val TYPE_FOOTER = 999
    private var wrapAdapter: WrapAdapter? = null
    private var isLoadingData = false //正在上拉加载数据中
    private var isFreshing = false //正在下拉刷新数据中
    private var isNoMore = false //是否没有更多数据

    private var mOnRefreshLoadListener: ILoadMoreListener? = null

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        itemAnimator = DefaultItemAnimator() //设置默认ItemAnimator
    }

    /**
     * 设置adapter
     * @return:
     * @date: 12/28/21 12:19 上午
     * @version: v1.0
     */
    fun setRefreshAdapter(adapter: Adapter<BaseEmptyViewHolder>, listener: ILoadMoreListener) {

        mOnRefreshLoadListener = listener
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

        Log.e("aaaan", "onScrollStateChanged: state: $state")
        if (state == RecyclerView.SCROLL_STATE_IDLE && mOnRefreshLoadListener != null && !isFreshing && !isLoadingData) {

            var lastVisibleItemPosition = 0
            if (layoutManager is GridLayoutManager) {
                lastVisibleItemPosition =
                    (layoutManager as GridLayoutManager).findLastVisibleItemPosition()
            } else if (layoutManager is StaggeredGridLayoutManager) {

                val manager = layoutManager as StaggeredGridLayoutManager
                val array = IntArray(manager.spanCount)
                manager.findLastVisibleItemPositions(array)
                lastVisibleItemPosition = findMax(array)
            } else {
                lastVisibleItemPosition =
                    (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            }
            val total = wrapAdapter!!.realCount()
            val childCount = layoutManager!!.childCount // 未隐藏的数目 childCount = count - hiddenCount

            Log.e(
                "aaaan",
                "lastVisibleItemPosition: $lastVisibleItemPosition, total: $total, childCount: $childCount, isFreshing: $isFreshing, isNoMore: $isNoMore"
            )
            if (childCount > 0 && lastVisibleItemPosition >= total - 1 && total > childCount

                && !isFreshing && !isNoMore
            ) {
                isLoadingData = true
                postDelayed(Runnable { mOnRefreshLoadListener!!.onLoadMore() }, 10000)

            }
        }
    }

    inner class DataObserver : AdapterDataObserver() {
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

        private var _footer: View? = null
        private val footer get() = _footer!!

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
                _footer = LayoutInflater.from(parent.context).inflate(R.layout.footer_recyclerview,parent,false)
                return FooterViewHolder(footer)
            } else {
                return adapter.onCreateViewHolder(parent, viewType)
            }
        }

        override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

            Log.e("aaabbb","position: $position, type: " + getItemViewType(position))
            if (getItemViewType(position) != TYPE_FOOTER) {
                adapter.onBindViewHolder(holder, position)
            }
        }

        override fun getItemCount(): Int = adapter.itemCount + 1

        fun close() {
            //footer.close()
        }

        fun noMore() {
            //footer.noMore()
        }

        fun loading() {
            //footer.loading()
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
                    override fun getSpanSize(position: Int): Int =
                        if (isFooter(position)) 1 else manager.spanCount
                }
//            }else if(manager is StaggeredGridLayoutManager){
//                manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//                    override fun getSpanSize(position: Int): Int =
//                        if (isFooter(position)) 1 else manager.spanCount
//                }
            }
        }

        inner class FooterViewHolder(itemView:View):BaseEmptyViewHolder(itemView){

            val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)
            val txtFooter = itemView.findViewById<AppCompatTextView>(R.id.txt_footer)
        }
    }

    interface OnRefreshLoadListener {
        fun onLoadMore()
    }

    fun isFreshing(freshing: Boolean) {
        isFreshing = freshing
    }

    fun loadMoreFinished() {

        isLoadingData = false
        isLoadingData = false
        wrapAdapter?.close()
    }

    fun noMoreData(isNoMore: Boolean) {
        this.isNoMore = isNoMore
        isLoadingData = false
        if (isNoMore) {
            wrapAdapter?.noMore()
        } else {
            wrapAdapter?.close()
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
}