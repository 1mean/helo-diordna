import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.R
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.CardItemLayoutBinding
import com.example.pandas.databinding.ItemBannerRecommendBinding
import com.example.pandas.databinding.ItemRecommendVideoBinding
import com.example.pandas.ui.view.viewpager.Indicator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 3:27 下午
 * @version: v1.0
 */
public class RecommendAdapter(private val data: RecommendData<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_BANNER = 1//轮播图
    private val TYPE_ITEM = 2//普通视频，一行2列
    private val TYPE_VIDEO = 3//横屏视频，一行一列

    fun closeBanner() {

    }

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
    fun refreshData(recommendData: RecommendData<PetViewData>) {

        if (recommendData.itemList.isNotEmpty() || recommendData.bannerList.isNotEmpty()) {
            data.bannerList.clear()
            data.itemList.clear()
            data.bannerList = recommendData.bannerList
            data.itemList = recommendData.itemList
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(recommendData: RecommendData<PetViewData>) {
        if (recommendData.itemList.isNotEmpty()) {
            data.itemList.addAll(recommendData.itemList)
            notifyItemRangeInserted((data.itemList.size + 1), recommendData.itemList.size)
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

        fun handle(position: Int) {

            val petVideo = data.itemList[position - 1]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            //val url = petVideo.cover.replace("http", "https")
            Glide.with(itemView.context).load(petVideo.cover)
                .into(cover)
            this.duration.text = duration
            name.text = petVideo.authorName
            title.text = petVideo.title
        }
    }

    inner class BannerHolder(binding: ItemBannerRecommendBinding) :
        BaseEmptyViewHolder(binding.root) {

        private val banner = binding.banner
        var indicator: Indicator? = null
        fun handle() {
            //轮播图数据
            val list = data.bannerList

            //避免重复创建，刷新banner位置到起始位
            if (indicator == null) {
                indicator = Indicator(itemView.context)
                indicator!!.initIndicator(
                    list.size,
                    ContextCompat.getColor(itemView.context, R.color.white)
                )
                val adapter = RecoViewPagerAdapter(list)

                this.banner.setAdapter(adapter)
                    .setIndicator(indicator!!, true)
                    .setAutoPlayed(true)
            }
        }
    }

    inner class VideoHolder(binding: ItemRecommendVideoBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgVideo
        val title = binding.txtTitle

        fun handle(position: Int) {
            val petVideo = data.itemList[position - 1]
            //把http图片换成https就能加载出来
            //val url = petVideo.cover.replace("http", "https")
            Glide.with(itemView.context).load(petVideo.cover)
                .into(cover)
            title.text = petVideo.title
        }
    }

}