package com.example.pandas.ui.adapter

import android.content.Intent
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.bean.GridItem
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.activity.PandaActivity
import com.example.pandas.ui.activity.TwoVerticalActivity
import de.hdodenhof.circleimageview.CircleImageView

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
        val image = holder.getWidget<CircleImageView>(R.id.img_pandas_top)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_pandas_top)

        name.text = data.item1

        when (position) {
//            8 -> image.setImageResource(R.mipmap.img_old)
//            9 -> image.setImageResource(R.mipmap.img_kepu)
            else ->
                loadImage(holder.itemView.context, data.item2, image)
        }

        holder.itemView.setOnClickListener {

            if (position == 0) {
                val intent = Intent(context, PandaActivity::class.java)
                intent.putExtra("title", data.item1)
                context.startActivity(intent)
            } else {
                val intent = Intent(context, TwoVerticalActivity::class.java)
                intent.putExtra("title", data.item1)
                context.startActivity(intent)
            }
        }
    }

}