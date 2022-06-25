package com.example.pandas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.databinding.AdapterSleepVideoItemBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder

/**
 * @description: SleepVideoItemAdapter
 * @author: dongyiming
 * @date: 2/3/22 10:05 下午
 * @version: v1.0
 */
public class SleepVideoItemAdapter(private val list: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        val binding =
            AdapterSleepVideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    private inner class MyViewHolder(binding: AdapterSleepVideoItemBinding) :
        BaseEmptyViewHolder(binding.root) {
        val cover = binding.imgSleepCover
        val title = binding.txtSleepTitle

        fun handle(position: Int) {

            if (list.isNotEmpty()) {

                val options = RequestOptions.bitmapTransform(RoundedCorners(20))
                val video = list[position]
                Glide.with(itemView.context).load(video.cover).apply(options).into(cover)
                title.text = video.title

                itemView.setOnClickListener {
                    startVideoPlayActivity(itemView.context, video.code,false)
                }
            }
        }
    }
}