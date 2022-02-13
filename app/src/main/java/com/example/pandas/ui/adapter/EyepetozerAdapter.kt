import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.ItemTitleEyeBinding
import com.example.pandas.databinding.ItemVideoEyeBinding
import com.example.pandas.databinding.ItemVpEyeBinding
import com.example.pandas.ui.activity.VideoPlayingActivity
import com.example.pandas.ui.view.viewpager.Banner

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/23 10:28 上午
 * @version: v1.0
 */
public class EyepetozerAdapter(
    val list: MutableList<EyepetozerBean>,
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = list.size
    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(items: MutableList<EyepetozerBean>) {

        if (items.isNotEmpty()) {
            list.addAll(items)
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(items: MutableList<EyepetozerBean>) {
        if (items.isNotEmpty()) {
            list.clear()
            list.addAll(items)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        var holder: BaseEmptyViewHolder? = null
        when (viewType) {
            1 -> {//viewpager
                val binding =
                    ItemVpEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = ViewPagerHolder(binding)
            }
            2 -> {
                val binding =
                    ItemTitleEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = TitleHolder(binding)
            }
            3 -> {
                val binding =
                    ItemVideoEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = VideoHolder(binding)
            }
        }
        return holder!!
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        when (getItemViewType(position)) {
            1 -> doViewPagerHodler(holder, position)
            2 -> doTitleHodler(holder, position)
            3 -> doVideoHodler(holder, position)
        }
    }

    private fun doViewPagerHodler(holder: BaseEmptyViewHolder, position: Int) {
        val mHolder = holder as ViewPagerHolder
        val mPager = mHolder.viewPager

        mPager.setPagePadding(50, 50, 9)
            .setAdapter(EyeViewPagerAdapter(list[position].horizontalCardList!!))
    }

    private fun doVideoHodler(holder: BaseEmptyViewHolder, position: Int) {

        val context = holder.itemView.context
        val bean = list[position]
        val user = bean.user
        val videoHolder = holder as VideoHolder
        videoHolder.userName.text = user?.userName
        videoHolder.descripetion.text = bean.title
        Glide.with(context).load(bean.coverUrl).into(videoHolder.cover)
        Glide.with(context).load(user?.userIcon).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(videoHolder.userIcon)
        videoHolder.itemView.setOnClickListener {
//            val intent = Intent(context, VideoPlayingActivity::class.java).apply {
//                putExtra("EyepetozerBean",bean)
//            }
//            context.startActivity(intent)
        }
    }

    private fun doTitleHodler(holder: BaseEmptyViewHolder, position: Int) {
        val mHolder = holder as TitleHolder
        val bean = list[position]
        mHolder.title.text = bean.title
    }

    class ViewPagerHolder(binding: ItemVpEyeBinding) : BaseEmptyViewHolder(binding.root) {
        val viewPager: Banner = binding.vpEye
    }

    class VideoHolder(binding: ItemVideoEyeBinding) :
        BaseEmptyViewHolder(binding.root) {
        val cover: AppCompatImageView = binding.imgVideo
        val userIcon: AppCompatImageView = binding.imgUser
        val descripetion: AppCompatTextView = binding.txtDescripetion
        val userName: AppCompatTextView = binding.txtUser
    }

    class TitleHolder(binding: ItemTitleEyeBinding) : BaseEmptyViewHolder(binding.root) {
        val title: AppCompatTextView = binding.txtTitle
    }
}