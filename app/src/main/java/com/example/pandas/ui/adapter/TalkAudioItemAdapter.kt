package com.example.pandas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.databinding.AdapterTalkItemBinding
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/3/22 10:05 下午
 * @version: v1.0
 */
public class TalkAudioItemAdapter(private val list: MutableList<MusicVo>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        val binding =
            AdapterTalkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    private inner class MyViewHolder(binding: AdapterTalkItemBinding) :
        BaseEmptyViewHolder(binding.root) {
        val name = binding.txtTalkName
        val item = binding.layoutTalkItem
        val color = ContextCompat.getColor(itemView.context, R.color.color_talk_item_pressed)
        fun handle(position: Int) {
            if (list.isNotEmpty()) {
                val audio = list[position]
                name.text = audio.audioName


            }
        }
    }
}