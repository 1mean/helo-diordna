package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: CacheItemAdapter
 * @author: dongyiming
 * @date: 3/9/22 3:10 下午
 * @version: v1.0
 */
public class CacheItemAdapter(private val list: MutableList<PetViewData>) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_cache_item

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cache)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_cache_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_cache_name)
        val author = holder.getWidget<AppCompatTextView>(R.id.txt_cache_author)
        val more = holder.getWidget<ConstraintLayout>(R.id.item_cache_load_more)
        val file = holder.getWidget<AppCompatTextView>(R.id.txt_cache_file)

        loadRoundedCornerImage(context, 15, data.cover, cover)
        duration.text = TimeUtils.getMMDuration(data.duration.toLong())
        title.text = data.title
        author.text = data.authorName
        file.text = data.fileName

        more.setOnClickListener { }
        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code)
        }
    }

}