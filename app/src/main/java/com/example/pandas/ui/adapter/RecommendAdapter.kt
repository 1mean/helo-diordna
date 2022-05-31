package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.R
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.interaction.OnItemmmmClickListener
import com.example.pandas.databinding.CardItemLayoutBinding
import com.example.pandas.databinding.ItemBannerRecommendBinding
import com.example.pandas.databinding.ItemRecommendVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.view.viewpager.Indicator
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.SPUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: 首页-推荐
 * @author: dongyiming
 * @date: 1/4/22 3:27 下午
 * @version: v1.0
 */
public class RecommendAdapter(
    private val lifecycle: Lifecycle,
    private var data: RecommendData<PetVideo>,
    private val listener: OnRecoItemClickListener
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_BANNER = 1//轮播图
    private val TYPE_ITEM = 2//普通视频，一行2列
    private val TYPE_VIDEO = 3//横屏视频，一行一列
    private var isBannerFresh = true //是否刷新banner


    fun getItemData(position: Int): PetVideo = data.itemList[position - 1]

    override fun getItemViewType(position: Int): Int {

        if (position == 0) {
            return TYPE_BANNER
        } else if (position % 11 == 0) {
            return TYPE_VIDEO
        } else {
            return TYPE_ITEM
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(recommendData: RecommendData<PetVideo>) {

        if (recommendData.itemList.isNotEmpty() || recommendData.bannerList.isNotEmpty()) {
            if (data != recommendData) {
                isBannerFresh = true
                if (data.bannerList == recommendData.bannerList) {
                    isBannerFresh = false
                }
                data = recommendData
                notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(recommendData: RecommendData<PetVideo>) {
        if (recommendData.itemList.isNotEmpty()) {
            val size = data.itemList.size
            data.itemList.addAll(recommendData.itemList)
            notifyItemRangeInserted((size + 1), recommendData.itemList.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        when (viewType) {
            TYPE_ITEM -> {//普通视频
                val binding = CardItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CardHolder(binding)
            }
            TYPE_BANNER -> {//轮播图视频

                val binding = ItemBannerRecommendBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BannerHolder(binding)
            }
            else -> {//横屏视频
                val binding = ItemRecommendVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return VideoHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        when (getItemViewType(position)) {

            TYPE_ITEM -> {
                (holder as CardHolder).handle(position)
            }
            TYPE_BANNER -> {
                (holder as BannerHolder).handle()
            }
            TYPE_VIDEO -> {
                (holder as VideoHolder).handle(position)
            }
        }
    }

    override fun getItemCount(): Int {

        if (data.bannerList.isEmpty() && data.itemList.isEmpty()) {
            return 0
        } else {
            return data.itemList.size + 1
        }
    }

    inner class CardHolder(binding: CardItemLayoutBinding) : BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgCover
        val duration = binding.txtDuration
        val name = binding.txtName
        val title = binding.txtTitle
        private val follow = binding.txtRecoFollow
        private val up = binding.imgRecoAuthor
        private val videoCounts = binding.txtRecoVideoCounts
        private val comments = binding.txtRecoVideoComments
        private val num = 1 * 1000 * 100
        private val commentNum = 1 * 100

        fun handle(position: Int) {

            val context = itemView.context
            val petVideo = data.itemList[position - 1]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            //val url = petVideo.cover.replace("http", "https")
            Glide.with(context).load(petVideo.cover).into(cover)
            this.duration.text = duration
            petVideo.user?.let {
                name.text = it.userName
            }

            val counts = (1..num).random()
            val commentCounts = (1..commentNum).random()
            videoCounts.text = NumUtils.getShortNum(counts)
            comments.text = commentCounts.toString()

            val type = petVideo.type
            if (type == VideoType.HONGLOU.ordinal) {
                follow.visibility = View.VISIBLE
                up.visibility = View.GONE
                follow.setTextColor(ContextCompat.getColor(context, R.color.color_bg_reco_type))
                follow.setBackgroundResource(R.drawable.shape_bg_reco_type)
                follow.text = context.resources.getString(R.string.str_hl)
            } else {
                val isAttention = SPUtils.isAttention(context, petVideo.authorId)
                if (isAttention) {
                    follow.visibility = View.VISIBLE
                    up.visibility = View.GONE
                    follow.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_txt_reco_followed
                        )
                    )
                    follow.setBackgroundResource(R.drawable.shape_bg_reco_followed)
                    follow.text = context.resources.getString(R.string.str_followed)
                } else {
                    follow.visibility = View.GONE
                    up.visibility = View.VISIBLE
                }
            }


            title.text = petVideo.title

            itemView.setOnClickListener {
                listener.onClick(position, 2, petVideo.code)
            }
        }
    }

    inner class BannerHolder(binding: ItemBannerRecommendBinding) :
        BaseEmptyViewHolder(binding.root) {

        private val banner = binding.banner
        fun handle() {

            if (isBannerFresh) {//避免重复刷新
                //轮播图数据
                val list = data.bannerList
                //避免重复创建，刷新banner位置到起始位
                val indicator = Indicator(itemView.context)
                indicator.initIndicator(
                    list.size,
                    ContextCompat.getColor(itemView.context, R.color.white)
                )
                val adapter = RecoViewPagerAdapter(list)

                this.banner.setLifecycleRegistry(lifecycle).setAdapter(adapter)
                    .setIndicator(indicator, true)
                    .setAutoPlayed(true)
            }
        }
    }

    inner class VideoHolder(binding: ItemRecommendVideoBinding) :
        BaseEmptyViewHolder(binding.root) {

        val playView = binding.playerReco
        val cover = binding.imgRecoVideo
        val shelter = binding.layoutRecoVideoShelter
        val title = binding.txtRecoVideoTitle
        val playerView = binding.playerReco

        fun updateItemView(position: Int, isHide: Boolean) {
            val petVideo = data.itemList[position - 1]
            petVideo.isPlaying = isHide
            if (isHide) {
                shelter.visibility = View.GONE
                playerView.showController()
            } else {
                shelter.visibility = View.VISIBLE
            }
        }

        fun handle(position: Int) {

            val petVideo = data.itemList[position - 1]
            if (petVideo.isPlaying) {//正在播放中
                shelter.visibility = View.GONE
                playerView.showController()
            } else {
                shelter.visibility = View.VISIBLE
            }
            //把http图片换成https就能加载出来
            // l = petVideo.cover.replace("http", "https")
            Glide.with(itemView.context).load(petVideo.cover)
                .into(cover)
            title.text = petVideo.title
            itemView.setOnClickListener {
                shelter.visibility = View.VISIBLE
                listener.onClick(position, 3, petVideo.code)
            }

            playView.setOnClickListener {
                shelter.visibility = View.VISIBLE
                listener.onClick(position, 3, petVideo.code)
            }
        }
    }

    public interface OnRecoItemClickListener {

        fun onClick(position: Int, type: Int, videoCode: Int)
    }
}