package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.LandscapeData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.databinding.AdapterLandscapeItemBinding
import com.example.pandas.databinding.LayoutBannerLandscapeBinding
import com.example.pandas.ui.view.viewpager.Indicator
import com.example.pandas.utils.TimeUtils

/**
 * @description: LandscapeAdapter
 * @author: dongyiming
 * @date: 2/4/22 5:31 下午
 * @version: v1.0
 */
public class LandscapeAdapter(private val lifecycle: Lifecycle, private var data: LandscapeData) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_BANNER = 1 //山水轮播图
    private val TYPE_ITEM = 2 //grid item

    @SuppressLint("NotifyDataSetChanged")
    fun updata(isRefresh: Boolean, landData: LandscapeData) {

        if (landData.itemList.isNotEmpty()) {

            if (isRefresh) {
                data = landData
                notifyDataSetChanged()
            } else {
                val size = data.itemList.size
                data.itemList.addAll(landData.itemList)
                notifyItemRangeInserted(size + 1, landData.itemList.size)
            }
        }
    }

    override fun getItemCount(): Int {
        val bannerList = data.bannerList
        val itemList = data.itemList
        if (bannerList.isNotEmpty() && itemList.isNotEmpty()) {
            return itemList.size + 1
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> TYPE_BANNER
            else -> TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_BANNER -> {
                val binding = LayoutBannerLandscapeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BannerHolder(binding)
            }
            else -> {
                val binding = AdapterLandscapeItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            TYPE_BANNER -> {
                (holder as BannerHolder).handle(position)
            }
            else -> {
                (holder as ItemViewHolder).handle(position)
            }
        }
    }

    inner class BannerHolder(binding: LayoutBannerLandscapeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val banner = binding.bannerLandscape
        var indicator: Indicator? = null
        fun handle(position: Int) {
            //轮播图数据
            val list = data.bannerList

            //避免重复创建，刷新banner位置到起始位
            if (indicator == null) {
                indicator = Indicator(itemView.context)
                indicator!!.initIndicator(
                    list.size,
                    ContextCompat.getColor(itemView.context, R.color.white)
                )
                val adapter = LandViewPagerAdapter(list)

                this.banner.setLifecycleRegistry(lifecycle).setAdapter(adapter)
                    .setPagePadding(20, 40, 15)
                    //.setIndicator(indicator!!, true)
                    //.setAutoPlayed(true)
            }
        }
    }

    private inner class ItemViewHolder(binding: AdapterLandscapeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cover = binding.imgLandscape
        val duration = binding.txtLandscapeDuration
        val title = binding.txtLandscapeName
        val name = binding.txtLandscapeAuthor
        val layoutMore = binding.itemLandscapeMore
        val counts = binding.txtVideoPlayCounts
        val comments = binding.txtVideoPlayComment

        fun handle(position: Int) {

            val video = data.itemList[position - 1]

            loadRoundedCornerImage(itemView.context, 10, video.cover, cover)
            duration.text = TimeUtils.getDuration(video.duration.toLong())
            title.text = video.title
            video.user?.let {
                name.text = it.userName
            }
            val count = (1..1000).random()
            Log.e("1mean", "$count")
            counts.text = StringBuilder(count.toString()).append("观看").toString()
            comments.text = (1..100).random().toString()
            layoutMore.setOnClickListener {

            }
            itemView.setOnClickListener {
                startVideoPlayActivity(itemView.context, video.code, false)
            }
        }
    }
}