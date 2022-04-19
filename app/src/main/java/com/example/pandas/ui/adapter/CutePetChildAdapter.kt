package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.utils.TimeUtils

/**
 * @description: CutePetChildAdapter
 * @author: dongyiming
 * @date: 3/17/22 11:57 下午
 * @version: v1.0
 */
public class CutePetChildAdapter(private val list: MutableList<PetVideo>) :
    BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.layout_child_cutepet

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cute_cover)
        val header = holder.getWidget<AppCompatImageView>(R.id.img_cute_author)
        //val durationView = holder.getWidget<AppCompatTextView>(R.id.txt_cute_duration)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_cute_name)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_cute_title)


        val petVideo = list[position]
        val duration = TimeUtils.getDuration(petVideo.duration.toLong())

        //把http图片换成https就能加载出来
        petVideo.cover?.let {
            loadImage(context, it, cover)
        }

        petVideo.user?.let {
            it.headUrl?.let { url ->
                loadCircleImage(context, url, header)
            }
        }

        //durationView.text = duration
        name.text = petVideo.authorName
        title.text = petVideo.title

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code)
        }
    }
}