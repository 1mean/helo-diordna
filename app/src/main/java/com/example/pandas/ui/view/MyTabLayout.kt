package com.example.pandas.ui.view
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.ui.ext.setTextType
import com.google.android.material.tabs.TabLayout

/**
 * @description: MyTabLayout
 * @author: dongyiming
 * @date: 6/28/22 4:00 下午
 * @version: v1.0
 */
public class MyTabLayout : TabLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        //init()
    }

    private fun init() {


        addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {

                tab?.let {
                    it.customView?.let { view ->
                        val title = view.findViewById<AppCompatTextView>(R.id.txt_music_title_name)
                        val paint = title.paint
                        paint.isFakeBoldText = true
                        title.setTextColor(ContextCompat.getColor(context, R.color.black))
                        title.setBackgroundResource(R.drawable.shape_title_music_item)
                    }
                }
            }

            override fun onTabUnselected(tab: Tab?) {

                tab?.let {
                    it.customView?.let { view ->
                        val title = view.findViewById<AppCompatTextView>(R.id.txt_music_title_name)
                        val paint = title.paint
                        paint.isFakeBoldText = false
                        title.setTextColor(
                            ContextCompat.getColor(
                                context,
                                R.color.color_home_music_text_unselected
                            )
                        )
                        title.background = null
                    }
                }
            }

            override fun onTabReselected(tab: Tab?) {
            }
        })


    }

    fun setTitles(titles: Array<String>) {

        if (titles.isNotEmpty()) {
            titles.forEach {
                val tab = newTab()
                tab.setCustomView(R.layout.item_music_title)
                if (tab.customView != null) {
                    val title =
                        tab.customView!!.findViewById<AppCompatTextView>(R.id.txt_music_title_name)
                    title.text = it
                }
                this.addTab(tab)
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        parent.requestDisallowInterceptTouchEvent(true)
        return super.dispatchTouchEvent(ev)
    }
}