package com.example.pandas.ui.adapter
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
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.databinding.AdapterOtherFragmentBinding
import com.example.pandas.databinding.ItemTitleEyeBinding
import com.example.pandas.databinding.ItemVpEyeBinding
import com.example.pandas.ui.activity.EyePlayingActivity
import com.example.pandas.ui.activity.VerticalVideoActivity
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder
import com.example.pandas.ui.view.viewpager.ConflictBanner
import com.example.pandas.utils.TimeUtils

/**
 * @description: EyeOtherAdapter
 * @author: dongyiming
 * @date: 5/19/22 6:16 下午
 * @version: v1.0
 */
public class EyeOtherAdapter(private val list: MutableList<EyepetozerItem>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    /**
     * 刷新界面
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshAdapter(data: MutableList<EyepetozerItem>) {

        if (data.isNotEmpty() && data != list) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    /**
     * 添加更多数据
     */
    fun loadMore(data: MutableList<EyepetozerItem>) {
        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size, data.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        var holder: BaseEmptyViewHolder? = null
        when (viewType) {
            2 -> {
                val binding =
                    ItemTitleEyeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = TitleHolder(binding)
            }
            3 -> {
                val binding =
                    AdapterOtherFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = VideoHolder(binding)
            }
        }
        return holder!!
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        when (getItemViewType(position)) {
            2 -> doTitleHodler(holder, position)
            3 -> (holder as VideoHolder).handle(position)
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
            val intent = Intent(context, VerticalVideoActivity::class.java)
            intent.putExtra("currentVideo", bean)
            context.startActivity(intent)
        }
    }

    private fun doTitleHodler(holder: BaseEmptyViewHolder, position: Int) {
        val mHolder = holder as TitleHolder
        val bean = list[position]
        mHolder.title.text = bean.title
    }

    class ViewPagerHolder(binding: ItemVpEyeBinding) : BaseEmptyViewHolder(binding.root) {
        val viewPager: ConflictBanner = binding.vpEye
    }

    inner class VideoHolder(binding: AdapterOtherFragmentBinding) :
        BaseEmptyViewHolder(binding.root) {
        val cover: AppCompatImageView = binding.imgVideo
        val userIcon: AppCompatImageView = binding.imgUser
        val descripetion: AppCompatTextView = binding.txtDescripetion
        val userName: AppCompatTextView = binding.txtUser
        val duration: AppCompatTextView = binding.txtEyeItemDuration

        fun handle(position: Int) {
            val context = itemView.context
            val bean = list[position]
            val user = bean.user
            userName.text = user?.userName
            descripetion.text = bean.title
            duration.text = TimeUtils.getMMDuration(bean.duration.toLong())
            Glide.with(context).load(bean.coverUrl).into(cover)
            Glide.with(context).load(user?.userIcon).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(userIcon)
            itemView.setOnClickListener {
                val intent = Intent(context, EyePlayingActivity::class.java)
                intent.putExtra("EyepetozerItem", bean)
                context.startActivity(intent)
            }
        }
    }

    class TitleHolder(binding: ItemTitleEyeBinding) : BaseEmptyViewHolder(binding.root) {
        val title: AppCompatTextView = binding.txtTitle
    }

}