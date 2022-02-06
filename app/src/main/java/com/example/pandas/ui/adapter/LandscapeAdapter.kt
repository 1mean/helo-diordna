import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.databinding.AdapterItemTitleBinding
import com.example.pandas.databinding.AdapterLandscapeItemBinding
import com.example.pandas.databinding.ItemBannerRecommendBinding
import com.example.pandas.ui.view.viewpager.Indicator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/4/22 5:31 下午
 * @version: v1.0
 */
public class LandscapeAdapter(private var data: LandscapeData) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_BANNER = 1 //山水轮播图
    private val TYPE_TITLE = 2
    private val TYPE_ITEM = 3 //grid item

    @SuppressLint("NotifyDataSetChanged")
    fun updata(isRefresh: Boolean, landData: LandscapeData) {

        if (landData.itemList.isNotEmpty()) {

            if (isRefresh) {
                data = landData
                notifyDataSetChanged()
            } else {
                data.itemList.addAll(landData.itemList)
                notifyItemRangeInserted(data.itemList.size + 2, landData.itemList.size)
            }
        }
    }

    override fun getItemCount(): Int {
        val bannerList = data.bannerList
        val itemList = data.itemList
        if (bannerList.isNotEmpty() && itemList.isNotEmpty()) {
            return itemList.size + 2
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> TYPE_BANNER
            1 -> TYPE_TITLE
            else -> TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        when (viewType) {
            TYPE_BANNER -> {
                val binding = ItemBannerRecommendBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BannerHolder(binding)
            }
            TYPE_TITLE -> {
                val binding = AdapterItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TitleViewHolder(binding)
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

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_BANNER -> {
                (holder as BannerHolder).handle(position)
            }
            TYPE_TITLE -> {
                (holder as TitleViewHolder).handle()
            }
            else -> {
                (holder as ItemViewHolder).handle(position)
            }
        }
    }

    inner class BannerHolder(binding: ItemBannerRecommendBinding) :
        BaseEmptyViewHolder(binding.root) {

        private val banner = binding.banner
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
                val adapter = RecoViewPagerAdapter(list)

                this.banner.setAdapter(adapter)
                    .setIndicator(indicator!!, true)
                    .setAutoPlayed(true)
            }
        }
    }

    inner class TitleViewHolder(binding: AdapterItemTitleBinding) :
        BaseEmptyViewHolder(binding.root) {

        private val title = binding.txtLandscapeTitle
        fun handle() {
            title.text = "精选山水"
        }
    }

    private inner class ItemViewHolder(binding: AdapterLandscapeItemBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgLandscape
        val duration = binding.txtLandscapeDuration
        val title = binding.txtLandscapeName
        val name = binding.txtLandscapeAuthor
        val layoutMore = binding.itemLandscapeMore

        fun handle(position: Int) {

            val video = data.itemList[position - 2]

            loadRoundedCornerImage(itemView.context, 10, video.cover, cover)
            duration.text = TimeUtils.getMMDuration(video.duration.toLong())
            title.text = video.title
            name.text = video.authorName
            layoutMore.setOnClickListener {

            }
        }
    }
}