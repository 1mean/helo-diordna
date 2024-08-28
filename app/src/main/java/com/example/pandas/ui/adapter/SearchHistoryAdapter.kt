package com.example.pandas.ui.adapter

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.SearchHistory
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.example.pandas.biz.interaction.ItemClickListener

/**
 * @description: SearchHistorydapter
 * @author: dongyiming
 * @date: 8/25/24 6:06 PM
 * @version: v1.0
 */
public class SearchHistorydapter(
    private val list: MutableList<SearchHistory> = mutableListOf(),
    private val listener: ItemClickListener<String>
) :
    BaseCommonAdapter<SearchHistory>(list) {

    override fun getLayoutId(): Int = R.layout.item_adapter_history_search

    override fun convert(holder: BaseViewHolder, data: SearchHistory, position: Int) {

        val content = holder.getWidget<AppCompatTextView>(R.id.txt_history_content)
        val updateTime = holder.getWidget<AppCompatTextView>(R.id.txt_history_update)

        content.text = data.reservedString

        if (position in 5..9) {
            updateTime.visibility = View.VISIBLE
            val time = TimeUtils.descriptiveData(data.updateTime) + "搜索"
            updateTime.text = time.toString()

            holder.itemView.post {
                val totalWidth = holder.itemView.width - 48
                Log.e("1maaaaean", "totalWidth:$totalWidth")
                val space = totalWidth - updateTime.width
                val contentParams = content.layoutParams
                contentParams.width = space
                content.layoutParams = contentParams
            }
        } else {
            updateTime.visibility = View.GONE
            holder.itemView.post {
                val totalWidth = holder.itemView.width - 48
                Log.e("1maaaaean", "totalWidth:$totalWidth")
                val contentParams = content.layoutParams
                contentParams.width = totalWidth
                content.layoutParams = contentParams
            }
        }

        holder.itemView.setOnClickListener {
            data.reservedString?.let {
                listener.onItemClick(it)
            }
        }
    }
}