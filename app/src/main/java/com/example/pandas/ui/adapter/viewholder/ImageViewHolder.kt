package com.example.pandas.ui.adapter.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/6 4:09 下午
 * @version: v1.0
 */
public class ImageViewHolder(imageView: ImageView) : RecyclerView.ViewHolder(imageView) {

    public var imageView: ImageView? = null

    init {
        this.imageView = imageView
    }
}