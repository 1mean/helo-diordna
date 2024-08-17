package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import java.io.File

/**
 * @description: ErrorAdapter
 * @author: dongyiming
 * @date: 3/25/22 12:18 上午
 * @version: v1.0
 */
public class ErrorAdapter(list: MutableList<File>, val listener: ErrorListener) :
    BaseCommonAdapter<File>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_error

    override fun convert(holder: BaseViewHolder, data: File, position: Int) {

        val name = holder.getWidget<AppCompatTextView>(R.id.txt_log_name)

        name.text = data.name

        holder.itemView.setOnClickListener {
            listener.clickErrorItem(data)
        }
    }

    interface ErrorListener {

        fun clickErrorItem(file: File)
    }

}