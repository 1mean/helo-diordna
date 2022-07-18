package com.example.pandas.ui.adapter

import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.GridItem
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.ui.activity.ListActivity
import com.example.pandas.ui.activity.PandaActivity
import com.example.pandas.ui.activity.VideoItemListActivity

/**
 * @description: PandasGridAdapter
 * @author: dongyiming
 * @date: 3/25/22 11:55 下午
 * @version: v1.0
 */
public class PandasGridAdapter(list: MutableList<GridItem>) : BaseCommonAdapter<GridItem>(list) {

    override fun getLayoutId(): Int = R.layout.item_adapter_pandas_top

    override fun convert(holder: BaseViewHolder, data: GridItem, position: Int) {

        val context = holder.itemView.context
        val image = holder.getWidget<AppCompatImageView>(R.id.img_pandas_top)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_pandas_top)

        loadCircleImage(holder.itemView.context, data.item2, image)
        if (position == 0) {
            name.setTextColor(ContextCompat.getColor(context,R.color.color_txt_item_name))
        }else {
            name.setTextColor(ContextCompat.getColor(context,R.color.color_video_name_txt))
        }
        name.text = data.item1

        holder.itemView.setOnClickListener {

            if (position == 0) {
                val intent = Intent(context, PandaActivity::class.java)
                intent.putExtra("title", data.item1)
                context.startActivity(intent)
            } else {
//                val intent = Intent(context, VideoItemListActivity::class.java)
                val intent = Intent(context, ListActivity::class.java)
                intent.putExtra("title", data.item1)
                intent.putExtra("list_type", 1)
                context.startActivity(intent)
            }
        }
    }

}