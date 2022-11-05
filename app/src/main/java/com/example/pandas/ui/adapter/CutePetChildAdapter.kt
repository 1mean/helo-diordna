package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.VideoData
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: CutePetChildAdapter
 * @author: dongyiming
 * @date: 3/17/22 11:57 下午
 * @version: v1.0
 */
public class CutePetChildAdapter(
    private val list: MutableList<PetVideo>,
    private val listener: OnLikeClickListener
) :
    BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.layout_child_cutepet

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cute_cover)
        val header = holder.getWidget<AppCompatImageView>(R.id.img_cute_author)
        //val durationView = holder.getWidget<AppCompatTextView>(R.id.txt_cute_duration)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_cute_name)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_cute_title)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_counts_like)
        val likeLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_like)
        val likeView = holder.getWidget<AppCompatImageView>(R.id.img_pet_like)


        val petVideo = list[position]
        val duration = TimeUtils.getDuration(petVideo.duration.toLong())

        //把http图片换成https就能加载出来
        petVideo.cover?.let {
            loadCenterImage(context, it, cover)
        }

        var videoData = data.videoData
        if (videoData == null) {
            val count = (1..1000).random()
            counts.text = count.toString()
            likeView.setImageResource(R.mipmap.img_pet_like)
            videoData = VideoData(videoCode = data.code, likes = count)

            data.videoData = videoData
        } else {
            counts.text = videoData.likes.toString()
            if (videoData.like) {
                likeView.setImageResource(R.mipmap.img_pet_liked)
            } else {
                likeView.setImageResource(R.mipmap.img_pet_like)
            }
        }
        likeLayout.setOnClickListener {
            if (videoData.like) {
                likeView.setImageResource(R.mipmap.img_pet_like)
                videoData.like = false
                val count = videoData.likes - 1
                counts.text = count.toString()
                videoData.likes = count
                listener.likeClick(videoData)
            } else {
                likeView.setImageResource(R.mipmap.img_pet_liked)
                videoData.like = true
                val count = videoData.likes + 1
                counts.text = count.toString()
                videoData.likes = count
                listener.likeClick(videoData)
            }
        }

        petVideo.user?.let {
            it.headUrl?.let { url ->
                loadCircleImage(context, url, header)
            }
            name.text = it.userName
        }

        //durationView.text = duration
        title.text = petVideo.title

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, data)
        }
    }

    interface OnLikeClickListener {
        fun likeClick(videoData: VideoData)
    }
}