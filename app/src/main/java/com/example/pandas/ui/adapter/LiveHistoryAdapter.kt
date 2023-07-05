package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: LiveVisitorAdapter
 * @author: dongyiming
 * @date: 10/10/22 5:49 下午
 * @version: v1.0
 */
public class LiveHistoryAdapter(list: MutableList<PetVideo>) : BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_live_history

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val header = holder.getWidget<AppCompatImageView>(R.id.img_live_history)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_live_history)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_live_item_name)

        data.cover?.let {
            loadCenterImage(context, it, header)
        }
        val type = data.type
        title.text = data.title
//        if (type != VideoType.PANDA.ordinal && type != VideoType.BEAUTY.ordinal) {
//            title.text = data.tags
//        } else {
//            title.text = data.title
//        }

        name.text = data.user?.userName

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, data)
        }
    }

}