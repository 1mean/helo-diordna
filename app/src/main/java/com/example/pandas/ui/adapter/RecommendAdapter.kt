package com.example.pandas.ui.adapter

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.VibrateUtils
import com.example.pandas.R
import com.example.pandas.bean.pet.RecommendData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.CardItemLayoutBinding
import com.example.pandas.databinding.ItemBannerRecommendBinding
import com.example.pandas.databinding.ItemRecommendVideoBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
import com.example.pandas.ui.view.viewpager.Indicator
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: 首页-推荐
 * @author: dongyiming
 * @date: 1/4/22 3:27 下午
 * @version: v1.0
 */
public class RecommendAdapter(
    private val lifecycle: Lifecycle,
    private var data: RecommendData<PetVideo> = RecommendData(),
    private val listener: RecoViewListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isOpenVoice = false
    private val TYPE_BANNER = 1//轮播图
    private val TYPE_ITEM = 2//普通视频，一行2列
    private val TYPE_VIDEO = 3//横屏视频，一行一列
    private var isBannerFresh = true //是否刷新banner

    private val mHandler = Handler(Looper.getMainLooper())

    fun updateVoice(isOpen: Boolean) {
        this.isOpenVoice = isOpen
    }

    //会导致item里播放器的playview视图的绑定关系解除，需要重启绑定
    fun updateVideoItem(isHide: Boolean, position: Int) {

        if (position < 0) return
        val petVideo = data.itemList[position - 1]
        petVideo.booleanFlag = isHide
        mHandler.post {//滑动时不允许刷新界面 <Cannot call this method while RecyclerView is computing a layout or scrolling>
            notifyItemChanged(position)
        }
    }

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

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)

//        if (holder is VideoHolder) {
//            val position = holder.itemView.tag as Int
//            //updateVideoItem(true, position)
//            listener.itemDetachedFromWindow(position)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tag = position

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

    override fun getItemCount(): Int =
        if (data.bannerList.isEmpty() && data.itemList.isEmpty()) {
            0
        } else {
            data.itemList.size + 1
        }

    inner class CardHolder(binding: CardItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

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
        private val header = binding.imgRecoHeader
        private val num = 1 * 1000 * 100
        private val commentNum = 1 * 100

        fun handle(position: Int) {

            val petVideo = data.itemList[position - 1]
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
                header.visibility = View.GONE
                follow.setTextColor(ContextCompat.getColor(context, R.color.color_bg_reco_type))
                follow.setBackgroundResource(R.drawable.shape_bg_reco_type)
                follow.text = context.resources.getString(R.string.str_hl)
            } else {
                if (petVideo.vertical) {//是竖屏
                    follow.visibility = View.VISIBLE
                    up.visibility = View.GONE
                    header.visibility = View.GONE
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
                            header.visibility = View.GONE
                            follow.setTextColor(
                                ContextCompat.getColor(
                                    context,
                                    R.color.color_txt_reco_followed
                                )
                            )
                            follow.setBackgroundResource(R.drawable.shape_bg_reco_followed)
                            follow.text = context.resources.getString(R.string.str_followed)
                        } else {
                            if (petVideo.type != VideoType.PANDA.ordinal) {
                                follow.visibility = View.GONE
                                up.visibility = View.GONE
                                header.visibility = View.VISIBLE
                                it.headUrl?.let { url ->
                                    loadImage(context, url, header)
                                }
                            } else {
                                follow.visibility = View.GONE
                                up.visibility = View.VISIBLE
                                header.visibility = View.GONE
                            }
                        }
                    }
                }
            }

            itemView.setOnLongClickListener {
                showDialog(petVideo.code)
                VibrateUtils.vibrate(2000)
                //VibrateUtils.vibrate(context, 500)
                true
            }

            moreView.setOnClickListener {
                showDialog(petVideo.code)
            }

            title.text = petVideo.title

            itemView.setOnClickListener {
                listener.onClick(petVideo)
            }
        }

        private fun showDialog(videoCode: Int) {

            if (dialog == null) {
                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        if (t == 0) {//添加到稍后再看
                            listener.addLaterPLay(videoCode)
                        }
                    }
                })
            }
            dialog!!.onShow()
        }
    }

    inner class BannerHolder(binding: ItemBannerRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {

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

                this.banner.setLifecycleRegistry(lifecycle)
                    .setAdapter(adapter)
                    .setIndicator(indicator, true)
                    .setAutoPlayed(true)
            }
        }
    }

    inner class VideoHolder(binding: ItemRecommendVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var dialog: MoreBottomSheetDialog? = null

        val context = itemView.context
        val playView = binding.playerReco
        val cover = binding.imgRecoVideo
        val shelter = binding.layoutRecoVideoShelter
        val title = binding.txtRecoVideoTitle
        val playerView = binding.playerReco
        val moreView = binding.btnMore
        val duration = binding.txtHomeVideoDuration
        val voice = binding.playerReco.findViewById<AppCompatImageButton>(R.id.exo_voice)

        fun updateItemView(hidePlayer: Boolean) {
            if (hidePlayer) {
                shelter.visibility = View.VISIBLE
            } else {
                shelter.visibility = View.GONE
                playerView.showController()
            }
        }

        fun handle(position: Int) {

            val petVideo = data.itemList[position - 1]
            if (petVideo.booleanFlag) {//正在播放中
                shelter.visibility = View.GONE
                playerView.showController()
            } else {
                shelter.visibility = View.VISIBLE
            }

            //把http图片换成https就能加载出来
            // l = petVideo.cover.replace("http", "https")
            loadCenterImage(itemView.context, petVideo.cover, cover)
            title.text = petVideo.title
            duration.text = TimeUtils.getDuration(petVideo.duration.toLong())

            if (isOpenVoice) {
                voice.setImageResource(R.mipmap.img_voice_open)
            } else {
                voice.setImageResource(R.mipmap.img_voice_close)
            }
            itemView.setOnClickListener {
                shelter.postDelayed({ shelter.visibility = View.VISIBLE }, 150)
                listener.onClick(petVideo)
            }

            playView.setOnClickListener {
                shelter.postDelayed({ shelter.visibility = View.VISIBLE }, 150)
                listener.onClick(petVideo)
            }

            moreView.setOnClickListener {
                showDialog(petVideo.code)
            }

            voice.setOnClickListener {
                if (isOpenVoice) {
                    voice.setImageResource(R.mipmap.img_voice_close)
                } else {
                    voice.setImageResource(R.mipmap.img_voice_open)
                }
                listener.updatePlayerVoice(!isOpenVoice)
                isOpenVoice = !isOpenVoice
            }
        }

        private fun showDialog(videoCode: Int) {

            if (dialog == null) {
                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        if (t == 0) {//添加到稍后再看
                            listener.addLaterPLay(videoCode)
                        }
                    }
                })
            }
            dialog!!.onShow()
        }
    }

    public interface RecoViewListener {

        fun onClick(video: PetVideo)

        fun updatePlayerVoice(isOpen: Boolean)

        fun addLaterPLay(videoCode: Int)
    }
}