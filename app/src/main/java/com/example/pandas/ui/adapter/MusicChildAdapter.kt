package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.databinding.AdapterMusicChildBinding
import com.example.pandas.databinding.LayoutTopMusicBinding
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.ui.ext.startMusicActivity

/**
 * @description: MusicChildAdapter
 * @author: dongyiming
 * @date: 6/28/22 11:57 下午
 * @version: v1.0
 */
public class MusicChildAdapter(private val list: MutableList<MusicVo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_TOP = 1
    private val TYPE_MUSIC_ITEM = 2

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TOP
        } else {
            TYPE_MUSIC_ITEM
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(data: MutableList<MusicVo>) {

        if (data.isNotEmpty() && data != list) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加更多数据
     */
    fun loadMore(data: MutableList<MusicVo>) {
        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size + 1, data.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_MUSIC_ITEM -> {
                val binding = AdapterMusicChildBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return MusicItemViewHolder(binding)
            }
            else -> {
                val binding = LayoutTopMusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return MusicTopViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_MUSIC_ITEM) {
            (holder as MusicItemViewHolder).handle(position)
        } else if (getItemViewType(position) == TYPE_TOP) {
            (holder as MusicTopViewHolder).handle()
        }
    }

    override fun getItemCount(): Int = list.size + 1


    inner class MusicItemViewHolder(binding: AdapterMusicChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = itemView.context
        val cover = binding.imgCoverMusic
        val name = binding.txtAudioName
        val singer = binding.txtSingerName
        val likeItem = binding.clayoutMusicItemLike
        val likeView = binding.imgMusicItemLike

        fun handle(position: Int) {
            val data = list[position - 1]
            data.cover?.let {
                loadRoundedCornerImage(context, 30, it, cover)
            }
            name.text = data.audioName
            singer.text = data.singerName

            likeItem.setOnClickListener {
                likeView.setImageResource(R.mipmap.img_music_item_liked1)
            }

            itemView.setOnClickListener {
                data.fileName?.let {
                    startMusicActivity(context, it)
                }
            }
        }
    }

    inner class MusicTopViewHolder(binding: LayoutTopMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun handle() {

        }
    }
}