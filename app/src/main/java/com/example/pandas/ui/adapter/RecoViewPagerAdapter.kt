package com.example.pandas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.PetVideo
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.ViewpagerRecommendBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: RecoViewPagerAdapter
 * @author: dongyiming
 * @date: 1/23/22 12:35 下午
 * @version: v1.0
 */
public class RecoViewPagerAdapter(private val list: MutableList<PetVideo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ViewpagerRecommendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MyHolder(binding: ViewpagerRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cover = binding.imgRecommendBg
        val title = binding.txtRecommendTitle

        fun handle(position: Int) {
            val data = list[position]
            data.cover?.let {
                loadCenterImage(itemView.context, it, cover)
            }
            title.text = data.title
            itemView.setOnClickListener {
                startVideoPlayingActivity(itemView.context, data)
            }
        }
    }
}