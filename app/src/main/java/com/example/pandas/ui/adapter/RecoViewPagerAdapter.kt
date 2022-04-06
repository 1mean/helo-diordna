package com.example.pandas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.ViewpagerRecommendBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/23/22 12:35 下午
 * @version: v1.0
 */
public class RecoViewPagerAdapter(private val list: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        val binding = ViewpagerRecommendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MyHolder(binding: ViewpagerRecommendBinding) : BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgRecommendBg
        val title = binding.txtRecommendTitle

        fun handle(position: Int) {

            val data = list[position]
            Glide.with(itemView.context).load(data.cover)
                .into(cover)
            if (position != 0) {
                title.text = data.title
            }
        }
    }
}