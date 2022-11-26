package com.example.pandas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.databinding.ViewpagerCmBannerBinding
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: RecoViewPagerAdapter
 * @author: dongyiming
 * @date: 1/23/22 12:35 下午
 * @version: v1.0
 */
public class CommonBannerAdapter(private val list: MutableList<PetVideo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ViewpagerCmBannerBinding.inflate(
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

    inner class MyHolder(binding: ViewpagerCmBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cover = binding.imgBanner

        fun handle(position: Int) {
            val data = list[position]
            data.cover?.let {
                loadCenterRoundedCornerImage(itemView.context, 20, it, cover)
            }
        }
    }
}