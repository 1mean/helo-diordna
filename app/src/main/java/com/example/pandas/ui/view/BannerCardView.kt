package com.example.pandas.ui.view

import BaseEmptyViewHolder
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.ui.view.viewpager.Banner

/**
 * @description: BannerCardView
 * @author: dongyiming
 * @date: 3/19/22 10:55 下午
 * @version: v1.0
 */
public class BannerCardView : CardView {

    private var bannerWidth = 0f
    private var card2Width = 0f
    private var card3Width = 0f
    //private var bgColor = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    @SuppressLint("Recycle", "CustomViewStyleable")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.BannerCardView)
        bannerWidth = array.getDimension(R.styleable.BannerCardView_bannerWidth, 0F)
        card2Width = array.getDimension(R.styleable.BannerCardView_card2Width, 0F)
        card3Width = array.getDimension(R.styleable.BannerCardView_card3Width, 0F)
        //bgColor = array.getResourceId(R.styleable.BannerCardView_bgColor, 0)
        initBanner()
    }

    private fun initBanner() {
        val banner = Banner(context)
        banner.setAdapter(MyAdapter())
        val lp = banner.layoutParams
        lp.width = bannerWidth.toInt()
        lp.height = RelativeLayout.LayoutParams.MATCH_PARENT
        banner.layoutParams = lp
        addView(banner)

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    inner class MyAdapter : RecyclerView.Adapter<BaseEmptyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
            val image = AppCompatImageView(parent.context)
            image.layoutParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            return MyViewHolder(image)
        }

        override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

            (holder as MyViewHolder).handle()
        }

        override fun getItemCount(): Int = 3

        inner class MyViewHolder(private val itemView: AppCompatImageView) :
            BaseEmptyViewHolder(itemView.rootView) {

            val img = itemView as AppCompatImageView
            fun handle() {
                img.setImageResource(R.mipmap.liuyifei)
            }
        }
    }

}