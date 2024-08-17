package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.bean.PageCommonData
import com.android.android_sqlite.bean.VideoType
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.databinding.CardImageBinding
import com.example.pandas.databinding.LayoutSleepBinding
import com.example.pandas.ui.activity.MoreDataListActivity
import com.example.pandas.ui.activity.OneVerticalList2Activity
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.ext.initRv
import com.example.pandas.ui.view.viewpager.Indicator

/**
 * @description: EntertainmentFragmentAdapter
 * @author: dongyiming
 * @date: 1/28/22 9:39 下午
 * @version: v1.0
 */
public class EntertainmentFragmentAdapter(
    private val lifecycle: Lifecycle,
    private var data: PageCommonData
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_BANNER = 0 //图片展示
    private val TYPE_FOOTBALL = 3 //天下足球
    private val TYPE_ART = 4 //艺术
    private val TYPE_BABY = 5 //人类宝宝
    private val TYPE_HONGLOU = 6 //人类宝宝
    private val TYPE_BEAUTY = 7 //影视美人

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(newData: PageCommonData) {
        data = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = 6

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_BANNER
            1 -> TYPE_FOOTBALL
            2 -> TYPE_ART
            3 -> TYPE_BABY
            4 -> TYPE_HONGLOU
            else -> TYPE_BEAUTY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        when (viewType) {
            TYPE_BANNER -> {
                val binding =
                    CardImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImageViewHolder(binding)
            }
            TYPE_FOOTBALL -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return FootBallHolder(binding)
            }
            TYPE_ART -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ArtViewHolder(binding)
            }
            TYPE_BABY -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return BabyViewHolder(binding)
            }
            TYPE_HONGLOU -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return HongLouViewHolder(binding)
            }
            else -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return BeautyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_BANNER -> {
                (holder as ImageViewHolder).handle()
            }
            TYPE_FOOTBALL -> {
                (holder as FootBallHolder).handle(position)
            }
            TYPE_ART -> {
                (holder as ArtViewHolder).handle(position)
            }
            TYPE_BABY -> {
                (holder as BabyViewHolder).handle(position)
            }
            TYPE_HONGLOU -> {
                (holder as HongLouViewHolder).handle(position)
            }
            TYPE_BEAUTY -> {
                (holder as BeautyViewHolder).handle(position)
            }
        }
    }

    private inner class ImageViewHolder(binding: CardImageBinding) :
        BaseEmptyViewHolder(binding.root) {
        val banner = binding.bannerLove
        val card2 = binding.layoutMusic
        val card3 = binding.layoutCard3

        @SuppressLint("ClickableViewAccessibility")
        fun handle() {

            card2.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(itemView.context, AppInfos.TYPE_MP3)
            }
            card3.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "红楼评说")
                        .putExtra("type", VideoType.HONGLOU.ordinal)
                itemView.context.startActivity(intent)
            }
            val list = data.bannerList

            //避免重复创建，刷新banner位置到起始位
            val indicator = Indicator(itemView.context)
            indicator.initIndicator(
                list.size,
                ContextCompat.getColor(itemView.context, R.color.white),
                true
            )
            val adapter = ImageAdapter(list)

            this.banner.setLifecycleRegistry(lifecycle).setAdapter(adapter)
                .setIndicator(indicator, true)
                .setAutoPlayed(true)
        }
    }

    private inner class FootBallHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "天下足球"
            val videos = data.footBallModel
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.initRv(itemView.context, mAdapter!!)
            }
            titleLayout.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "天下足球")
                        .putExtra("type", VideoType.FOOTBALL.ordinal)
                itemView.context.startActivity(intent)
            }
        }
    }

    private inner class ArtViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "艺术雕塑"
            val videos = data.artList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.initRv(itemView.context, mAdapter!!)
            }

            titleLayout.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "艺术雕塑")
                        .putExtra("type", VideoType.ART.ordinal)
                itemView.context.startActivity(intent)
            }
        }
    }

    private inner class BabyViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "人类宝宝"
            val videos = data.babyList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.initRv(itemView.context, mAdapter!!)
            }

            titleLayout.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "人类宝宝")
                        .putExtra("type", VideoType.BABY.ordinal)
                itemView.context.startActivity(intent)
            }
        }
    }

    private inner class HongLouViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "红楼评说"
            val videos = data.honglouList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.initRv(itemView.context, mAdapter!!)
            }
            titleLayout.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "红楼评说")
                        .putExtra("type", VideoType.HONGLOU.ordinal)
                itemView.context.startActivity(intent)
            }
        }
    }

    private inner class BeautyViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "影视美女"
            val videos = data.beautyList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.initRv(itemView.context, mAdapter!!)
            }
            titleLayout.setOnClickListener {
                val intent =
                    Intent(itemView.context, OneVerticalList2Activity::class.java)
                        .putExtra("title", "影视美女")
                        .putExtra("type", VideoType.BEAUTY.ordinal)
                itemView.context.startActivity(intent)
            }
        }
    }
}