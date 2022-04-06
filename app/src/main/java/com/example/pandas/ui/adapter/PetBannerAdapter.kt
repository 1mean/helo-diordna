package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.LayoutImageBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/6 2:23 下午
 * @version: v1.0
 */
public class PetBannerAdapter(private var data: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(list: MutableList<PetViewData>) {

        if (list.isNotEmpty() && list != data) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        val binding = LayoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    inner class MyViewHolder(binding: LayoutImageBinding) : BaseEmptyViewHolder(binding.root) {
        val image = binding.imgView
        fun handle(position: Int) {
            //Glide.with(itemView.context).load(url).into(image)
            when (position) {
                0 -> {
                    Glide.with(itemView.context)
                        .load("https://i0.hdslb.com/bfs/archive/7643dcb1726a5ec7b0f446edc015b5f7042476bf.jpg")
                        .into(image)
                }
                1 -> {
                    Glide.with(itemView.context)
                        .load("https://i2.hdslb.com/bfs/archive/0965af132bcf1ad6edda79215167f90d7ebc8cae.jpg")
                        .into(image)
                }
                2 -> {
                    Glide.with(itemView.context)
                        .load("https://i0.hdslb.com/bfs/archive/cccb3eb504f603095f08ae34c62a49b852a22883.jpg")
                        .into(image)
                }
                3 -> {
                    Glide.with(itemView.context)
                        .load("https://i0.hdslb.com/bfs/archive/6490900ea5b3cc8b2951644f8d5be997b3663068.jpg")
                        .into(image)
                }
                else -> {
                    Glide.with(itemView.context).load(data[position].cover).into(image)
                }
            }
        }
    }
}