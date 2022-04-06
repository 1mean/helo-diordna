package com.example.pandas.ui.adapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity

/**
 * @description: PandaListAdapter
 * @author: dongyiming
 * @date: 3/28/22 2:56 下午
 * @version: v1.0
 */
public class PandaListAdapter(list: MutableList<PetViewData>) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_pandas_list

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_pandas_item_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_pandas_item_title)

        loadRoundedCornerImage(context, 10, data.cover, cover)
        title.text = data.title

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code)
        }
    }

}