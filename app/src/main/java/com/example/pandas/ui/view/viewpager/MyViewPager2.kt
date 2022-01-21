package com.example.pandas.ui.view.viewpager

import com.example.pandas.ui.adapter.viewholder.ImageViewHolder
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import java.lang.ref.WeakReference

/**
 * @description: 自定义viewpager2
 * @author: dongyiming
 * @date: 2021/11/28 9:57 下午
 * @version: v1.0
 */
class MyViewPager2 : FrameLayout {

    private lateinit var vp2: ViewPager2
    private lateinit var mRoundPaint: Paint
    private lateinit var indicator: Indicator
    private lateinit var mAdapter: RecyclerView.Adapter<ImageViewHolder>
    private lateinit var mLoopTask: AutoLoopTask
    private var mStartX: Float = 0f
    private var mStartY: Float = 0f
    private var mTouchSlop: Int = 0
    private val mBannerRadius = 70f
    private var currentPosition = 0

    constructor(context: Context) : this(context, null) {
    }


    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
        initialize(context, attrs)
    }

    private fun init(context: Context) {

        mTouchSlop = ViewConfiguration.get(context).scaledTouchSlop / 2
        //定义水平滑动的RecyclerView
        vp2 = ViewPager2(context)
        vp2.layoutParams = ViewGroup.LayoutParams(
            LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        vp2.setPageTransformer(CompositePageTransformer())
        vp2.registerOnPageChangeCallback(MyOnPageChangeCallback())
        vp2.offscreenPageLimit = 1

        mRoundPaint = Paint()
        mRoundPaint.color = ContextCompat.getColor(context, R.color.color_room_tab_bg)


        val left = ScreenUtil.dp2px(context, 276.6f)
        val top = ScreenUtil.dp2px(context, 243.3f)
        val right = ScreenUtil.dp2px(context, 333.3f)
        val bottom = ScreenUtil.dp2px(context, 247.6f)
        indicator = Indicator(context)
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
//        params.setMargins(830, 733, 1000, 743) //像素值
        params.setMargins(left, top, right, bottom)
        indicator.layoutParams = params


        mLoopTask = AutoLoopTask(this)

        addView(vp2)
        addView(indicator)
    }


    private fun initialize(context: Context, attrs: AttributeSet?) {

        if (attrs != null) {

            val a = context.obtainStyledAttributes(attrs, R.styleable.MyViewPager2)
            val isAutoLoop = a.getBoolean(R.styleable.MyViewPager2_auto_loop, true)
            val loop_time = a.getInt(R.styleable.MyViewPager2_loop_time, 0)
            val indicator_width =
                a.getDimensionPixelSize(R.styleable.MyViewPager2_indicator_width, 0)
            val indicator_height =
                a.getDimensionPixelSize(R.styleable.MyViewPager2_indicator_height, 0)
            val indicator_space =
                a.getDimensionPixelSize(R.styleable.MyViewPager2_indicator_space, 0)
            a.recycle()
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        drawTopLeft(canvas)
        drawTopRight(canvas)
        drawBottomLeft(canvas)
        drawBottomRight(canvas)
    }

    private fun drawTopLeft(canvas: Canvas) {
        val path = Path()
        path.moveTo(0f, mBannerRadius)
        path.lineTo(0f, 0f)
        path.lineTo(mBannerRadius, 0f)
        path.arcTo(RectF(0f, 0f, mBannerRadius * 2, mBannerRadius * 2), -90f, -90f)
        path.close()
        canvas.drawPath(path, mRoundPaint)
    }

    private fun drawTopRight(canvas: Canvas) {
        val width = width
        val path = Path()
        path.moveTo(width - mBannerRadius, 0f)
        path.lineTo(width.toFloat(), 0f)
        path.lineTo(width.toFloat(), mBannerRadius)
        path.arcTo(
            RectF(width - 2 * mBannerRadius, 0f, width.toFloat(), mBannerRadius * 2),
            0f,
            -90f
        )
        path.close()
        canvas.drawPath(path, mRoundPaint)
    }

    private fun drawBottomLeft(canvas: Canvas) {
        val height = height
        val path = Path()
        path.moveTo(0f, height - mBannerRadius)
        path.lineTo(0f, height.toFloat())
        path.lineTo(mBannerRadius, height.toFloat())
        path.arcTo(
            RectF(0f, height - 2 * mBannerRadius, mBannerRadius * 2, height.toFloat()),
            90f,
            90f
        )
        path.close()
        canvas.drawPath(path, mRoundPaint)
    }

    private fun drawBottomRight(canvas: Canvas) {
        val height = height
        val width = width
        val path = Path()
        path.moveTo(width - mBannerRadius, height.toFloat())
        path.lineTo(width.toFloat(), height.toFloat())
        path.lineTo(width.toFloat(), height - mBannerRadius)
        path.arcTo(
            RectF(
                width - 2 * mBannerRadius, height - 2 * mBannerRadius, width.toFloat(),
                height.toFloat()
            ), 0f, 90f
        )
        path.close()
        canvas.drawPath(path, mRoundPaint)
    }

    /**
     * <配置adapter>
     * @param:
     * @return:
     * @version: v1.0
     */
    fun setAdapter(mAdapter: RecyclerView.Adapter<ImageViewHolder>) {

        this.mAdapter = mAdapter
        mAdapter.registerAdapterDataObserver(myAdapterDataObserver)
        vp2.setCurrentItem(0, false)
        vp2.adapter = mAdapter

    }


    /**
     * 观察者：AdapterDataObserver
     * 被观察者：AdapterDataObservable-->notifyChanged()-->adapter notifyDataSetChanged()通知改变
     * @version: v1.0
     */
    private final val myAdapterDataObserver = object : RecyclerView.AdapterDataObserver() {

        override fun onChanged() {
            super.onChanged()
            Log.e("1mean", "adapter onChange()")
            startTask()
        }
    }

    fun startTask() {
        removeCallbacks(mLoopTask)
        postDelayed(mLoopTask, 4000)
    }

    fun stopTask() {
        removeCallbacks(mLoopTask)
    }

    /**
     * activity的onResume()后执行，fragment的onResume()之前执行
     * @version: v1.0
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e("1mean", "onAttachedToWindow()")
        startTask()
    }

    /**
     * fragment的onPause()后执行
     * @version: v1.0
     */
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e("1mean", "onDetachedFromWindow()")
        stopTask()
    }

    class AutoLoopTask(myViewPager2: MyViewPager2) : Runnable {
        private var reference: WeakReference<MyViewPager2>

        init {
            reference = WeakReference<MyViewPager2>(myViewPager2)
        }

        override fun run() {
            val viewpager = reference.get()
            val next: Int = viewpager!!.vp2.currentItem + 1
            viewpager.vp2.currentItem = next
            viewpager.postDelayed(viewpager.mLoopTask, 4000)
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

                mStartX = event.x
                mStartY = event.y
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {

                val endX = event.x
                val endY = event.y
                val distanceX = Math.abs(endX - mStartX)
                val distanceY = Math.abs(endY - mStartY)
                val mIsViewPager2Drag: Boolean = distanceX > mTouchSlop && distanceX > distanceY
                parent.requestDisallowInterceptTouchEvent(mIsViewPager2Drag)
            }
            MotionEvent.ACTION_UP -> {
            }
            MotionEvent.ACTION_CANCEL ->
                parent.requestDisallowInterceptTouchEvent(false)
        }
        return super.onInterceptTouchEvent(event)
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
    inner class MyOnPageChangeCallback :
        ViewPager2.OnPageChangeCallback() {

        final var isScrolled = false
        final var mPosition = -1

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            Log.e("9mean","=============================onPageSelected: $position")

            indicator.setCurrentPage(position)

            currentPosition = position
//            if (isScrolled) {
//                mPosition = position
//            }
        }

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)

            when (state) {
                ViewPager2.SCROLL_STATE_DRAGGING -> {

                    Log.e("9mean","DRAGGING")
                }
                ViewPager2.SCROLL_STATE_IDLE -> {
                    Log.e("9mean","IDLE")
                }
                ViewPager2.SCROLL_STATE_SETTLING -> {
                    Log.e("9mean","SETTLING")
                }
            }
        }
    }

    public class Indicator : View {

        private val indiWidth = ScreenUtil.dp2px(context, 7f)
        private val indiHeight = ScreenUtil.dp2px(context, 4f)
        private val indiSpace = ScreenUtil.dp2px(context, 4f)
        private var mPaint: Paint = Paint()
        private var currentPage = 0
        private var indiColor:Int
        private var indiSecletColor:Int

        constructor(context: Context) : this(context, null) {
        }


        constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        }

        constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
            context,
            attrs,
            defStyleAttr
        ) {
            mPaint.color = Color.GRAY
            indiColor = ContextCompat.getColor(context,R.color.color_indicator)
            indiSecletColor = ContextCompat.getColor(context,R.color.color_indicator_select)

        }

        fun setCurrentPage(currentPage: Int) {
            this.currentPage = currentPage % 6
            requestLayout()
        }


        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)

            val width = indiWidth * 6 + indiSpace * 5
            setMeasuredDimension(width, indiHeight)
        }


        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var left: Float = 0f
            for (i in 0..5) {

                mPaint.color = if (i == currentPage) indiSecletColor else indiColor
                canvas.drawRect(
                    left,
                    0f,
                    left + indiWidth,
                    indiHeight.toFloat(),
                    mPaint
                )
                left += indiWidth + indiSpace
            }
        }
    }

    public fun registerAdapterRecycle(owner: LifecycleOwner) {

        owner.lifecycle.addObserver(object : DefaultLifecycleObserver {

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                startTask()
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                removeCallbacks(mLoopTask)
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                stopTask()
            }
        })
    }

}