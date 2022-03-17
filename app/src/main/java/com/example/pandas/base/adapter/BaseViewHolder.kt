package com.example.pandas.base.adapter

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: BaseViewHolder
 * @author: dongyiming
 * @date: 2021/12/16 5:59 下午
 * @version: v1.0
 */
public open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private var widgetViews: SparseArray<View>? = null
    private var mView: View? = null

    init {
        widgetViews = SparseArray()
        mView = itemView
    }

    /**
     * 通过layoutId创建viewholder
     *
     * @param mContext
     * @param layoutId
     * @param parent
     * @param convertView
     * @return
     */
    open fun build(
        mContext: Context,
        layoutId: Int,
        parent: ViewGroup,
        convertView: View
    ): BaseViewHolder? {
        val itemView = LayoutInflater.from(mContext).inflate(
            layoutId, parent,
            false
        )
        return BaseViewHolder(itemView)
    }

    /**
     * 通过控件的ID获取到Widget
     *
     * @param widgetId
     * @param <T>
     * @return
    </T> */
    open fun <T : View> getWidget(widgetId: Int): T {
        var view: View? = null
        if (widgetViews != null) {
            view = widgetViews!!.get(widgetId)//get()为null赋值给view会报错，所以view必须初始化为null
            if (view == null) {
                view = mView!!.findViewById(widgetId)
                widgetViews!!.put(widgetId, view)
            }
        } else {
            view = mView!!.findViewById(widgetId)
            widgetViews!!.put(widgetId, view)
        }
        return view as T
    }

    /**
     * 填充TextView
     *
     * @param viewId
     * @param text
     * @return
     */
    open fun setText(viewId: Int, text: String?): BaseViewHolder? {
        val tv = getWidget<View>(viewId) as TextView
        tv.text = text
        return this
    }

    /**
     * @param viewId
     * @param res
     * @return
     */
    open fun setTextColor(viewId: Int, res: Int): BaseViewHolder? {
        val tv = getWidget<View>(viewId) as TextView
        tv.setTextColor(res)
        return this
    }

    /**
     * imageview填充
     *
     * @param viewId
     * @param imgResource
     * @return
     */
    open fun setImageView(viewId: Int, imgResource: Int): BaseViewHolder? {
        val imageView = getWidget<View>(viewId) as ImageView
        imageView.setImageResource(imgResource)
        return this
    }

    /**
     * 设置隐藏
     *
     * @param viewId
     */
    open fun setGone(viewId: Int) {
        val view = getWidget<View>(viewId)
        view.visibility = View.GONE
    }

    /**
     * 设置显示
     *
     * @param viewId
     */
    open fun setVisible(viewId: Int) {
        val view = getWidget<View>(viewId)
        view.visibility = View.VISIBLE
    }

}