package com.example.pandas.ui.adapter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.android.android_sqlite.entity.PetVideo
import com.android.android_sqlite.entity.VideoData
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.utils.ScreenUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.ui.ext.startShortVideoActivity
import com.example.pandas.ui.ext.startVideoActivity
import com.example.pandas.ui.ext.startVideoPlayingActivity
import de.hdodenhof.circleimageview.CircleImageView


/**
 * @description: LaterAdapter
 * @author: dongyiming
 * @date: 8/13/22 11:25 上午
 * @version: v1.0
 */
public class FallsShortVideoAdapter(
    list: MutableList<PetVideo> = mutableListOf(),
    private val updataVideoData: (videoData: VideoData) -> Unit,
    private val updatePetVideo: (video: PetVideo) -> Unit
) :
    BaseCommonAdapter<PetVideo>(list) {

    override fun getLayoutId(): Int = R.layout.fragment_falls_short_video

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {
        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_short_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_short_title)
        val header = holder.getWidget<CircleImageView>(R.id.img_short_header)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_short_name)
        val likes = holder.getWidget<AppCompatTextView>(R.id.txt_counts_short_like)
        val likeLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_falls_short_like)
        val likeView = holder.getWidget<AppCompatImageView>(R.id.img_falls_short_like)

        val textColors =
            arrayOf(
                ContextCompat.getColor(context, R.color.color_txt_right_comment_item_like),
                ContextCompat.getColor(context, R.color.color_txt_right_comment_item_liked)
            )

        val user = data.user
        var videoData = data.videoData

        user?.let {
            it.headUrl?.let { headerUrl ->
                loadImage(context, headerUrl, header)
            }
            name.text = it.userName
        }

        data.cover?.let {

            val width = data.width
            val height = data.height
            if (width == 0 && height == 0) {

                //卡顿的原因是由于要加载图片完成后，根据bitmap的宽高比设置给imageview对应的高度
                //没有太好的办法，让后台返回图片尺寸，直接设置给imageview，这种方法效果是最好的
                //可还要考虑后台不一定返回的情况，就需要自己按原样请求了，只是请求成功计算出imageview高度保存一下，以后的滑动就不会每次请求了，只是第一次卡顿了
                Glide.with(context).asBitmap().load(it)
                    .listener(object : RequestListener<Bitmap> {
                        override fun onLoadFailed(
                            exception: GlideException?,
                            model: Any?,
                            target: Target<Bitmap>?,
                            isFirstResource: Boolean
                        ): Boolean {

                            return false
                        }

                        override fun onResourceReady(
                            resource: Bitmap?,
                            model: Any?,
                            target: Target<Bitmap>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                    })
                    //.apply(requestOptions)
                    .into(object : CustomTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            //只能通过屏幕宽/高这种固定大小，才能保证不会出现空白item和长宽错乱的item
                            val resourceWidth = resource.width
                            val resourceHeight = resource.height

                            data.width = resourceWidth
                            data.height = resourceHeight
                            Log.e(
                                "1mean",
                                "code:${data.code}, width=$resourceWidth, height=$resourceHeight"
                            )
                            updatePetVideo(data)

                            //val finalWidth = cover.width
                            val finalWidth = ScreenUtil.getScreenWidth(context) / 2
                            //val finalHeight = if (resourceWidth > finalWidth) {
                            //   (resourceWidth / finalWidth.toDouble()) * resourceHeight
                            //} else {
                            //  (finalWidth / resourceWidth.toDouble()) * resourceHeight
                            //}
                            val finalHeight =
                                (resourceHeight / resourceWidth.toDouble()) * finalWidth
                            val params = cover.layoutParams
                            //params.width = finalWidth
                            cover.layoutParams = params

                            cover.setImageBitmap(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
            } else {
                val finalWidth = ScreenUtil.getScreenWidth(context) / 2
                val finalHeight = (height / width.toDouble()) * finalWidth
                val params = cover.layoutParams
                params.width = finalWidth
                params.height = finalHeight.toInt()
                cover.layoutParams = params
                loadCenterImage(context, it, cover)
            }

            holder.itemView.setOnClickListener {
                startVideoPlayingActivity(context, data)
            }
        }

        title.text = data.title

        if (videoData == null) {
            likes.text = "0"
            likeView.setImageResource(R.mipmap.img_item_comment_like)
            likes.setTextColor(textColors[0])
        }

        videoData?.let {

            likes.text = it.likes.toString()

            if (!it.like) {
                likeView.setImageResource(R.mipmap.img_item_comment_like)
                likes.setTextColor(textColors[0])
            } else {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.setTextColor(textColors[1])
            }
        }

        likeLayout.setOnClickListener {
            addScaleAnimation(likeView, 1.3f)
            if (videoData == null) {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.text = "1"
                videoData = VideoData(videoCode = data.code, like = true, likes = 1)
                data.videoData = videoData
                likes.setTextColor(textColors[1])
            } else {
                if (videoData!!.like) {
                    likeView.setImageResource(R.mipmap.img_item_comment_like)
                    likes.setTextColor(textColors[0])
                    videoData!!.likes -= 1
                    likes.text = videoData!!.likes.toString()
                } else {
                    likeView.setImageResource(R.mipmap.img_item_comment_liked)
                    likes.setTextColor(textColors[1])
                    videoData!!.likes += 1
                    likes.text = videoData!!.likes.toString()
                }
                videoData!!.like = !videoData!!.like
            }
            updataVideoData(videoData!!)
        }
    }
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        val manager = recyclerView.layoutManager
//        if (manager is GridLayoutManager) {
//
//            manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//                override fun getSpanSize(position: Int): Int {
//                    return 2
//                }
//            }
//        }
//    }
}