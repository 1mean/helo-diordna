package com.example.pandas.ui.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 10:37 下午
 * @version: v1.0
 */
public open class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public lateinit var fullImageView: ImageView
    public lateinit var imgHeader: ImageView
    public lateinit var typeValue: TextView
    public lateinit var name: TextView
    public lateinit var desc1: TextView
    public lateinit var desc2: TextView
    public lateinit var desc3: TextView
    public lateinit var position: TextView
    public lateinit var cvItem: CardView

}