package com.example.pandas.ui.adapter
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.interaction.OnItemmmmClickListener

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/17/22 5:39 下午
 * @version: v1.0
 */
public class HotSearchAdapter(
    private val list: MutableList<String>,
    private val listener: OnItemmmmClickListener<String>
) :
    BaseCommonAdapter<String>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_hot_search

    override fun convert(holder: BaseViewHolder, data: String, position: Int) {

        val context = holder.itemView.context
        val color1 = ContextCompat.getColor(context, R.color.color_video_item_title)
        val color2 = ContextCompat.getColor(context, R.color.color_text_search_num)
        val num = holder.getWidget<AppCompatTextView>(R.id.txt_search_num)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_search_title)
        val flag = holder.getWidget<AppCompatTextView>(R.id.txt_hot)

        if (position <= 3) {
            num.setTextColor(color1)
            flag.visibility = View.VISIBLE
            flag.setBackgroundResource(R.drawable.shape_hot_search)
            flag.text = context.resources.getString(R.string.str_hot)
        } else {
            if (position % 3 == 0) {
                flag.visibility = View.VISIBLE
                flag.setBackgroundResource(R.drawable.shape_new_search)
                flag.text = context.resources.getString(R.string.str_new)
            }
            num.setTextColor(color2)
        }

        num.text = (position + 1).toString()
        title.text = list[position]

        holder.itemView.setOnClickListener {
            listener.onClick(position, list[position])
        }
    }
}