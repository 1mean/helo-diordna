package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.android_sqlite.entity.MusicVo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.interaction.OnItemmmmClickListener

/**
 * @description: MusicListAdapter
 * @author: dongyiming
 * @date: 3/2/22 7:25 下午
 * @version: v1.0
 */
public class MusicListAdapter(
    private val list: MutableList<MusicVo>,
    private val onClick: (position: Int, t: String) -> Unit
) :
    BaseCommonAdapter<MusicVo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_music_list

    override fun convert(holder: BaseViewHolder, data: MusicVo, position: Int) {
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cover_music)
        val audioName = holder.getWidget<AppCompatTextView>(R.id.txt_audio_name)
        val singerName = holder.getWidget<AppCompatTextView>(R.id.txt_singer_name)
        val layoutMore = holder.getWidget<ConstraintLayout>(R.id.layout_more)

        val options = RequestOptions.bitmapTransform(RoundedCorners(20))
        val music = list[position]
        Glide.with(holder.itemView.context).load(music.cover).apply(options).into(cover)
        audioName.text = music.audioName
        singerName.text = music.singerName
        holder.itemView.setOnClickListener {
            data.fileName?.let { it1 -> onClick(position, it1) }
        }
    }

}