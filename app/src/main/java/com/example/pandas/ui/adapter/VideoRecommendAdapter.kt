package com.example.pandas.ui.adapter

import com.example.pandas.bean.eyes.EyepetozerItem

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/30/21 10:49 下午
 * @version: v1.0
 */
public class VideoRecommendAdapter(private val mutableList: MutableList<EyepetozerItem>) {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//
//        val binding =
//            ItemVideoIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.onBind(position)
//    }
//
//    override fun getItemCount(): Int = mutableList.size
//
//    inner class MyViewHolder(binding: ItemVideoIntroBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        val cover = binding.imgVideoRecoCover
//        val duration = binding.txtVideoRecoDuration
//        val title = binding.txtVideoRecoTitle
//        val name = binding.txtVideoRecoName
//        val time = binding.textVideoRecoTime
//
//        fun onBind(position: Int) {
//
//            val eyepetozerBean = mutableList[position]
//            Glide.with(itemView.context).load(eyepetozerBean.coverUrl).apply(
//                RequestOptions.bitmapTransform(
//                    RoundedCorners(10)
//                )
//            ).into(cover)
//            title.text = eyepetozerBean.title
//            name.text = eyepetozerBean.user?.userName
//            duration.text = TimeUtils.getDuration(eyepetozerBean.duration.toLong())
//            time.text = TimeUtils.getStringDate(eyepetozerBean.releaseTime)
//        }
//    }
}