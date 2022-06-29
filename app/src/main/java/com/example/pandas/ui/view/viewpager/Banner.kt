package com.example.pandas.ui.view.viewpager

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * 无限循环的思路(offscreenPageLimit = 1)：
 *      - 解决position=0时预加载问题，原生viewpager在第一次显示position=0时，只会预加载position=1,无法左滑
 *          - 解决：展示position=1作为起始界面，这样系统会预先加载position=0和2,可以左右滑动
 *      - 设置预先加载左右各一个页面，假设viewpager第一次展示在界面上的position=1，即图片数据的第二张图片，
 *  那么，系统会为我们预加载第1张(position=0)和第3张(position=)
 *
 *
 *
 *
 *
 * @description:
 * @author: dongyiming
 * @date: 2021/12/24 10:55 上午
 * @version: v1.0
 */
class Banner : RelativeLayout, LifecycleObserver {

    private var scaledTouchSlop: Int = 0
    private var _mViewPager: ViewPager2? = null
    private val mViewPager get() = _mViewPager!!
    private var wrapAdapter: BannerAdapterWrapper? = null
    private var compositePageTransformer: CompositePageTransformer? = null

    private var addPage: Int = 2//左右各添加一个page，当真实item总数为1时也能轮循
    private var sidePage: Int = 1//每边添加的page数
    private var tempPosition: Int = 0//

    private var isAutoPlay = false
    private var isStartPlaying = false

    private var startX = 0f
    private var startY = 0f
    private var lastX = 0f
    private var lastY = 0f

    private var indicator: Indicator? = null
    private val autoTime: Long = 2500

    constructor(context: Context) : this(context, null) {
    }


    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    private fun initView(context: Context) {

        scaledTouchSlop = ViewConfiguration.get(context).scaledTouchSlop shr 1
        compositePageTransformer = CompositePageTransformer()

        _mViewPager = ViewPager2(context)
        mViewPager.run {
            layoutParams =
                ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setPageTransformer(compositePageTransformer)
            registerOnPageChangeCallback(MyOnPageChangeCallback())
        }
        addView(_mViewPager)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public fun onPause() {

        if (isAutoPlayed() && isStartPlaying && isAttached) {
            Log.e("banner", "onPause")
            stopPlaying()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun onResume() {
        if (isAutoPlayed() && getRealCount() > 1 && !isStartPlaying && isAttached) {
            Log.e("banner", "onResume")
            startPlaying()
        }
    }

    private var isAttached: Boolean = false

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isAttached = true
        Log.e("banner", "onAttachedToWindow")
        if (isAutoPlayed() && getRealCount() > 1 && !isStartPlaying) {
            startPlaying()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        isAttached = false
        Log.e("banner", "banner onDetachedFromWindow " + isAutoPlayed())
        if (isAutoPlayed()) {
            stopPlaying()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (isAutoPlayed() && mViewPager.isUserInputEnabled) {//能人为滑动viewpager2
            val action = ev.action
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_OUTSIDE) {
                startPlaying()
            } else if (action == MotionEvent.ACTION_DOWN) {
                stopPlaying()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {

        val doNotNeedIntercept = (!mViewPager.isUserInputEnabled
                || (mViewPager.adapter != null
                && mViewPager.adapter!!.itemCount <= 1))
        if (doNotNeedIntercept) {
            return super.onInterceptTouchEvent(ev)
        }

        val action = ev.action
        if (action == MotionEvent.ACTION_DOWN) {
            startX = ev.rawX
            startY = ev.rawY
            lastX = ev.rawX
            lastY = ev.rawY
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (action == MotionEvent.ACTION_MOVE) {
            lastX = ev.rawX
            lastY = ev.rawY
            if (mViewPager.isUserInputEnabled) {
                val distanceX: Float = abs(lastX - startX)
                val distanceY: Float = abs(lastY - startY)
                val disallowIntercept =
                    if (mViewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                        distanceX > scaledTouchSlop && distanceX > distanceY
                    } else {
                        distanceY > scaledTouchSlop && distanceY > distanceX
                    }
                parent.requestDisallowInterceptTouchEvent(disallowIntercept)
            }
        } else if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
//            return abs(lastX - startX) > scaledTouchSlop || abs(lastY - startY) > scaledTouchSlop
            parent.requestDisallowInterceptTouchEvent(false)
        }
        return super.onInterceptTouchEvent(ev)
    }

    /**
     * 对添加的adapter进行处理，左右增加两个page用于无限轮循
     *
     * 1页3屏，预展示页面数为1，预加载page position = 0,1,2,3,4 设置currentitem=2顺序2，3，4，1，0
     * @date: 2021/12/24 11:30 上午
     */
    private inner class BannerAdapterWrapper : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private lateinit var mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            return mAdapter.onCreateViewHolder(parent, viewType)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            mAdapter.onBindViewHolder(holder, realPosition(position))
        }

        override fun getItemCount(): Int {

            return if (mAdapter.itemCount > 1) getRealCount() + addPage else getRealCount()
        }


        override fun getItemId(position: Int): Long {
            return mAdapter.getItemId(realPosition(position))
        }

        fun getRealCount(): Int = mAdapter.itemCount

        fun registerAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {

            mAdapter = adapter
            //mAdapter.registerAdapterDataObserver(adapterObserver)
        }
    }

    /**
     * 数据改变或刷新时执行
     * @date: 2021/12/24 5:40 下午
     */
    private val adapterObserver = object : RecyclerView.AdapterDataObserver() {

        //每次执行adapter notifyDataSetChanged 时调用，第一次添加adapter时不会执行
        override fun onChanged() {
            //startViewPager(realPosition(tempPosition))
        }

        //减少一页时，触发了
        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            onChanged()
        }

        //adapter增加一页时调用
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            if (positionStart > 1) onChanged()
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            onChanged()
        }
    }

    private fun setCurrentPage(position: Int) {
        setCurrentPage(position, true)
    }

    /**
     * 当前界面展示的page，从1开始，多屏模式下mViewPager从传入的adapter的2开始展示
     * @date: 2021/12/24 1:19 下午
     */
    private fun setCurrentPage(position: Int, smoothScroll: Boolean) {

        tempPosition = position + sidePage
        mViewPager.setCurrentItem(tempPosition, smoothScroll)
    }

    /**
     * realPosition：传入的adapter会展示realPosition的数据
     * position：wrapAdapter的页面position，从第0页开始
     *
     * @param:
     * @date: 2021/12/24 7:09 下午
     * @version: v1.0
     */
    private fun realPosition(position: Int): Int {

        var realPosition = 0
        if (getRealCount() > 1) {
            realPosition = (position - sidePage) % getRealCount()
        }
        if (realPosition < 0) {
            realPosition += getRealCount()
        }
        return realPosition
    }

    /**
     * <监听page滑动>
     *     onPageScrolled：position和移动距离的回调，如从0到1会回调很多次
     *     onPageSelected: 新page被选中时执行，返回新page的position
     *     onPageScrollStateChanged:滑动状态变化时回调
     *          SCROLL_STATE_IDLE：空闲状态，当前界面全部在view里和无动画执行
     *          SCROLL_STATE_DRAGGING：正在被滑动。用户或程序拖动
     *          SCROLL_STATE_SETTLING：viewpager2处在被调整到最终位置的过程中
     *     拖动执行顺序：
     *          SCROLL_STATE_DRAGGING
     *          SCROLL_STATE_IDLE
     *          onPageSelected：position
     *          SCROLL_STATE_IDLE
     * @version: v1.0
     */
    private inner class MyOnPageChangeCallback : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            val realPosition: Int = realPosition(position)
            if (indicator != null) {
                indicator!!.onPageScrolled(realPosition, positionOffset, positionOffsetPixels)
            }
        }

        override fun onPageSelected(position: Int) {

            if (getRealCount() > 1) {
                tempPosition = position
            }
        }

        //实现无限循环，系统默认是无法在首/尾位置左滑/右滑
        override fun onPageScrollStateChanged(state: Int) {
            if (state == ViewPager2.SCROLL_STATE_DRAGGING) {//自动模式下不会调用

                if (tempPosition == sidePage - 1) {
                    mViewPager.setCurrentItem(getRealCount() + tempPosition, false)
                } else if (tempPosition == getRealCount() + sidePage) {
                    mViewPager.setCurrentItem(sidePage, false)
                }
            }
        }
    }

    /**
     * 自动轮播情况下切换位置
     * @date: 2/8/22 3:32 下午
     * @version: v1.0
     */
    private val task: Runnable by lazy {
        object : Runnable {
            override fun run() {
                if (isAutoPlayed()) {
                    //实际位置
                    tempPosition++
                    //自动模式下实现最两边的切换
                    if (tempPosition == getRealCount() + sidePage + 1) {
                        mViewPager.setCurrentItem(sidePage, false)
                        post(this)
                    } else {
                        mViewPager.currentItem = tempPosition
                        postDelayed(this, autoTime)
                    }
                }
            }
        }
    }

    private fun isAutoPlayed(): Boolean = isAutoPlay && getRealCount() > 1

    private fun getRealCount(): Int = wrapAdapter!!.getRealCount()


    private fun addPageTransformer(transformer: ViewPager2.PageTransformer): Banner {
        compositePageTransformer?.addTransformer(transformer)
        return this
    }

    fun setLifecycleRegistry(lifecycleRegistry: Lifecycle): Banner {
        lifecycleRegistry.addObserver(this)
        return this
    }

    /* --对外暴露的方法--------------------------------------------------------------------------- */

    fun startPlaying() {

        stopPlaying()
        Log.e("1mean", "startPlaying")
        postDelayed(task, autoTime)
        isStartPlaying = true
    }

    fun stopPlaying() {

        Log.e("1mean", "stopPlaying: $isStartPlaying")
        if (isStartPlaying) {
            removeCallbacks(task)
            isStartPlaying = false
        }
    }

    /**
     * 设置一屏3页
     * 当一个屏幕展示三个页面时，需要左右两边都预留2个页面做滑动
     *
     * @param lastPageWidth     左边页面显露出来的宽度
     * @param nextPageWidth    右边页面露出来的宽度
     * @param itemPadding    item与item之间的宽度
     */
    public fun setPagePadding(lastPageWidth: Int, nextPageWidth: Int, itemPadding: Int): Banner {

        addPageTransformer(MarginPageTransformer(itemPadding))
        val recyclerView = mViewPager.getChildAt(0) as RecyclerView
        if (mViewPager.orientation == ViewPager2.ORIENTATION_VERTICAL) {
            recyclerView.setPadding(
                mViewPager.paddingLeft, lastPageWidth + abs(itemPadding),
                mViewPager.paddingRight, nextPageWidth + abs(itemPadding)
            )
        } else {
            recyclerView.setPadding(
                lastPageWidth + abs(itemPadding), mViewPager.paddingTop,
                nextPageWidth + abs(itemPadding), mViewPager.paddingBottom
            )
        }
        recyclerView.clipToPadding = false//分屏设置，最关键的部分
        addPage = 4
        sidePage = 2
        return this
    }

    //设置轮播指示器
    fun setIndicator(mIndicator: Indicator, attachToBanner: Boolean): Banner {

        if (indicator != null) {
            removeView(indicator?.getView())
        }

        this.indicator = mIndicator
        if (attachToBanner) {
            addView(indicator?.getView(), indicator?.getParams())
        }
        return this
    }

    /**
     * 传入的adapter
     * @return:
     * @date: 1/24/22 3:13 下午
     * @version: v1.0
     */
    fun setAdapter(adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>): Banner {

        wrapAdapter = BannerAdapterWrapper()
        wrapAdapter!!.registerAdapter(adapter as RecyclerView.Adapter<RecyclerView.ViewHolder>)
        mViewPager.adapter = wrapAdapter

        mViewPager.offscreenPageLimit = 1

        setCurrentPage(0, false)
        return this
    }

    /**
     * 设置自由轮播
     * @date: 2021/12/24 12:39 下午
     */
    fun setAutoPlayed(autoPlay: Boolean): Banner {
        Log.e("1mean", "setAutoPlayed")
        isAutoPlay = autoPlay
        if (isAutoPlay && getRealCount() > 1) {
            //onAttachedToWindow里执行了开始轮播
            startPlaying()
        }
        return this
    }
}