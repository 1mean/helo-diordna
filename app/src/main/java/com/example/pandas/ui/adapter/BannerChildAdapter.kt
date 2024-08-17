package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.entity.PetVideo
import com.android.base.utils.NumUtils
import com.android.base.utils.TimeUtils
import com.android.base.utils.VibrateUtils
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.AdapterItemBannerChildBinding
import com.example.pandas.databinding.ItemBannerBannerListBinding
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
import com.example.pandas.ui.view.viewpager.Indicator

/**
 * @description:
 * @author: dongyiming
 * @date: 1/4/22 3:27 下午
 * @version: v1.0
 */
public class BannerChildAdapter(
    private val lifecycle: Lifecycle,
    private var data: MutableList<PetVideo> = mutableListOf(),
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_BANNER = 1//轮播图
    private val TYPE_ITEM = 2//普通视频，一行2列
    private var isBannerFresh = true //是否刷新banner

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        TYPE_BANNER
    } else {
        TYPE_ITEM
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(list: MutableList<PetVideo>) {

        if (list.isNotEmpty()) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadMore(list: MutableList<PetVideo>) {
        if (list.isNotEmpty()) {
            val size = data.size
            data.addAll(list)
            if (size <= 3) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted((size - 2), list.size)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_ITEM -> {//普通视频
                val binding = AdapterItemBannerChildBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CardHolder(binding)
            }
            else -> {//轮播图视频

                val binding = ItemBannerBannerListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BannerHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tag = position

        when (getItemViewType(position)) {
            TYPE_ITEM -> {
                (holder as CardHolder).handle(position)
            }
            TYPE_BANNER -> {
                (holder as BannerHolder).handle()
            }
        }
    }

    override fun getItemCount(): Int {

        if (data.isNotEmpty()) {
            return if (data.size < 3) {
                0
            } else {
                data.size - 2
            }
        }
        return 0
    }

    inner class CardHolder(binding: AdapterItemBannerChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var dialog: MoreBottomSheetDialog? = null
        val context = itemView.context
        val cover = binding.imgCover
        val duration = binding.txtDuration
        val name = binding.txtName
        val title = binding.txtTitle
        private val follow = binding.txtRecoFollow
        private val up = binding.imgRecoAuthor
        private val videoCounts = binding.txtRecoVideoCounts
        private val comments = binding.txtRecoVideoComments
        private val moreView = binding.clayoutRecoItemMore
        private val num = 1 * 1000 * 100
        private val commentNum = 1 * 100

        fun handle(position: Int) {

            val petVideo = data[position + 2]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            //val url = petVideo.cover.replace("http", "https")
            //Glide.with(context).load(petVideo.cover).into(cover)
            loadCenterImage(context, petVideo.cover, cover)
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
                if (petVideo.vertical) {//是竖屏
                    follow.visibility = View.VISIBLE
                    up.visibility = View.GONE
                    follow.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_txt_reco_followed
                        )
                    )
                    follow.setBackgroundResource(R.drawable.shape_bg_reco_followed)
                    follow.text = context.resources.getString(R.string.str_vertical)
                } else {
                    petVideo.user?.let {
                        if (it.attention) {
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
                }
            }

            itemView.setOnLongClickListener {
                showDialog(petVideo.code)
                VibrateUtils.vibrate(2000)
                true
            }

            moreView.setOnClickListener {
                showDialog(petVideo.code)
            }
            title.text = petVideo.title

            itemView.setOnClickListener {
                startVideoPlayingActivity(context, petVideo)
            }
        }

        private fun showDialog(videoCode: Int) {

            if (dialog == null) {
                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        if (t == 0) {//添加到稍后再看
                        }
                    }
                })
            }
            dialog!!.onShow()
        }
    }

    inner class BannerHolder(binding: ItemBannerBannerListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val banner = binding.banner
        fun handle() {

            if (isBannerFresh) {//避免重复刷新
                //轮播图数据
                val list = mutableListOf<PetVideo>()
                if (data.isNotEmpty()) {
                    data.forEachIndexed { index, petVideo ->
                        if (index < 3) {
                            list.add(petVideo)
                        }
                    }
                }
                //避免重复创建，刷新banner位置到起始位
                val indicator = Indicator(itemView.context)
                indicator.initIndicator(
                    list.size,
                    ContextCompat.getColor(itemView.context, R.color.white)
                )
                val adapter = RecoViewPagerAdapter(list)

                this.banner.setLifecycleRegistry(lifecycle)
                    .setAdapter(adapter)
                    .setIndicator(indicator, true)
                    .setAutoPlayed(true)
            }
        }
    }

}