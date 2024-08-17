package com.example.pandas.ui.adapter
import android.graphics.Typeface
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.android.android_sqlite.entity.MusicVo
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.OnItemmmmClickListener

/**
 * @description: AudioMenuAdapter
 * @author: dongyiming
 * @date: 3/21/22 8:50 下午
 * @version: v1.0
 */
public class AudioMenuAdapter(
    list: MutableList<MusicVo>, private var fileName: String,
    private val listener: OnItemmmmClickListener<MusicVo>
) :
    BaseCommonAdapter<MusicVo>(list) {

    private var mPosition = 0
    fun updateSelectItem(selectFileName: String, position: Int) {
        fileName = selectFileName
        notifyItemChanged(mPosition)
        notifyItemChanged(position)
        mPosition = position
    }

    override fun getLayoutId(): Int = R.layout.adapter_item_audio_menu

    override fun convert(holder: BaseViewHolder, data: MusicVo, position: Int) {

        val context = holder.itemView.context
        val normalNameColor = ContextCompat.getColor(context, R.color.color_txt_music_dialog_name)
        val normalSingerColor = ContextCompat.getColor(context, R.color.color_audio_menu_singer)
        val playingColor = ContextCompat.getColor(context, R.color.color_tab_text_selected)
        val num = holder.getWidget<AppCompatTextView>(R.id.txt_audio_menu_num)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_audio_menu_name)
        val singer = holder.getWidget<AppCompatTextView>(R.id.txt_audio_menu_singer)
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_menu_song_cover)
        val item = holder.getWidget<ConstraintLayout>(R.id.clayout_menu_item)

        num.text = (position + 1).toString()
        name.text = data.audioName
        singer.text = data.singerName

        val isPlaying = data.fileName.equals(fileName)
        if (isPlaying) {
            mPosition = position
            //会覆盖顶部menu圆角
            item.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.color_music_menu_item_selected
                )
            )
            name.setTextColor(playingColor)
            singer.setTextColor(playingColor)
            name.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            singer.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            cover.visibility = View.VISIBLE
            num.visibility = View.GONE
            loadCircleImage(context, data.cover!!, cover)
        } else {
            item.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.color_bg_music_dialog
                )
            )
            name.setTextColor(normalNameColor)
            singer.setTextColor(normalSingerColor)
            name.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
            singer.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
            cover.visibility = View.GONE
            num.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            if (!isPlaying) {
                listener.onClick(position, data)
            }
        }
    }

}