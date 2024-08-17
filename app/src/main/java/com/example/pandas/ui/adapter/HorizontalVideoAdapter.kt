package com.example.pandas.ui.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.bean.PetViewData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.databinding.FragmentItemLoveBinding
import com.example.pandas.ui.adapter.viewholder.BaseEmptyViewHolder

/**
 * @description: itemvideo
 * @author: dongyiming
 * @date: 1/31/22 2:22 下午
 * @version: v1.0
 */
public class HorizontalVideoAdapter(private val list: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        return MyAdapter(
            FragmentItemLoveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyAdapter).handle(position)
    }

    override fun getItemCount(): Int = list.size

    private inner class MyAdapter(binding: FragmentItemLoveBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgHorizontalCover
        val name = binding.txtHorizontalName
        fun handle(position: Int) {

            val options = RequestOptions.bitmapTransform(RoundedCorners(10))
            val video = list[position]
            Glide.with(itemView.context).load(video.cover).apply(options).into(cover)
            name.text = video.title
            cover.setOnClickListener {
            }
        }
    }
}