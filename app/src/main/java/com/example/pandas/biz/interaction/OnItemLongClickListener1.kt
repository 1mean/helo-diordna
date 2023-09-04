package com.example.pandas.biz.interaction

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface OnItemLongClickListener {
    fun onItemLongClick(holder: RecyclerView.ViewHolder, position: Int, v: View)
}