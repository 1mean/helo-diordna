package com.example.pandas.ui.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadEmptyCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.activity.EyePlayingActivity
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: EyepetozerAdapter
 * @author: dongyiming
 * @date: 2021/12/23 10:28 上午
 * @version: v1.0
 */
public class EyepetozerAdapter(private val list: MutableList<EyepetozerBean>) :
    BaseCommonAdapter<EyepetozerBean>(list) {

    fun getItemData(position: Int): EyepetozerBean {
        return list[position]
    }

    fun prePlayView(position: Int, holder: RecyclerView.ViewHolder?, isHide: Boolean) {

        holder?.let {
            val hd = holder as BaseViewHolder
            val playshelter = hd.getWidget<ConstraintLayout>(R.id.clayout_eye_item)
            val cover = hd.getWidget<AppCompatImageView>(R.id.img_video)
            if (isHide) {
                playshelter.visibility = View.GONE
                cover.visibility = View.GONE

            } else {
                playshelter.visibility = View.VISIBLE
                cover.visibility = View.VISIBLE
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.item_video_eye

    override fun convert(holder: BaseViewHolder, data: EyepetozerBean, position: Int) {

        val cover = holder.getWidget<AppCompatImageView>(R.id.img_video)
        val userIcon = holder.getWidget<AppCompatImageView>(R.id.img_user)
        val descripetion = holder.getWidget<AppCompatTextView>(R.id.txt_descripetion)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_eye_time)
        val userName = holder.getWidget<AppCompatTextView>(R.id.txt_user)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_eye_item_duration)
        val shareView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_eye_item_share)
        val commentView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_eye_item_comments)
        val likeView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_eye_item_like)
        val likeImg = holder.getWidget<AppCompatImageView>(R.id.img_eye_item_Like)
        val likeTxt = holder.getWidget<AppCompatTextView>(R.id.txt_eye_item_like)
        val comments = holder.getWidget<AppCompatTextView>(R.id.txt_eye_item_comments)
        val playImg = holder.getWidget<AppCompatImageView>(R.id.img_eye_item_play)
        val playshelter = holder.getWidget<ConstraintLayout>(R.id.clayout_eye_item)

        val context = holder.itemView.context
        val user = data.user

        if (data.isLiked) {
            likeImg.setImageResource(R.mipmap.img_eye_item_liked)
        } else {
            likeImg.setImageResource(R.mipmap.img_eye_item_like)
        }
        descripetion.text = data.title
        duration.text = TimeUtils.getMMDuration(data.duration.toLong())

        data.coverUrl?.let {
            loadImage(context, it, cover)
        }

        if (user == null) {
            loadEmptyCircleImage(context, userIcon)
            userName.text = "开眼视频"
            val cTime = TimeUtils.getMdTime(System.currentTimeMillis())
            time.text = StringBuilder(cTime).append(" · 投稿了视频").toString()
        } else {
            user.let {
                it.userIcon?.let { url ->
                    loadCircleImage(context, url, userIcon)
                }
                val cTime = TimeUtils.getMdTime(it.latestReleaseTime)
                time.text = StringBuilder(cTime).append(" · 投稿了视频").toString()
                userName.text = it.userName
            }
        }

        if (data.collectionCount == 0) {
            likeTxt.text = "赞"
        } else {
            likeTxt.text = NumUtils.getShortNum(data.collectionCount)
        }

        comments.text = NumUtils.getShortNum(data.replyCount)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, EyePlayingActivity::class.java)
            intent.putExtra("EyepetozerBean", data)
            context.startActivity(intent)
        }

        shareView.setOnClickListener {


        }

        commentView.setOnClickListener {

        }

        likeView.setOnClickListener {

            if (data.isLiked) {
                data.isLiked = false
                data.collectionCount -= 1
                if (data.collectionCount == 0) {
                    likeTxt.text = "赞"
                } else {
                    likeTxt.text = NumUtils.getShortNum(data.collectionCount)
                }
                likeImg.setImageResource(R.mipmap.img_eye_item_like)
            } else {
                data.isLiked = true
                data.collectionCount += 1
                likeTxt.text = NumUtils.getShortNum(data.collectionCount)
                likeImg.setImageResource(R.mipmap.img_eye_item_liked)
            }
        }
    }
}