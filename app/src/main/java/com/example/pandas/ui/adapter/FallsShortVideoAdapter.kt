package com.example.pandas.ui.adapter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.addScaleAnimation
import com.example.pandas.utils.ScreenUtil
import de.hdodenhof.circleimageview.CircleImageView


/**
 * @description: LaterAdapter
 * @author: dongyiming
 * @date: 8/13/22 11:25 上午
 * @version: v1.0
 */
public class FallsShortVideoAdapter(
    private val list: MutableList<PetVideo> = mutableListOf(),
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

        val user = data.user
        val videoData = data.videoData

        user?.let {
            it.headUrl?.let { headerUrl ->
                loadImage(context, headerUrl, header)
            }
            name.text = it.userName
        }

        data.cover?.let {

//            val option = BitmapFactory.Options()
//            option.inJustDecodeBounds = true
//            BitmapFactory.decodeStream()

//            val requestOptions = RequestOptions()
//                .fitCenter()
//                .error(R.mipmap.liuyifei)
//                .skipMemoryCache(false)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

            Glide.with(context).asBitmap().load(it)
                .listener(object :RequestListener<Bitmap>{
                    override fun onLoadFailed(
                        exception: GlideException?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e("lidandan3","exception: ${exception.toString()}")

                        val finalWidth = ScreenUtil.getScreenWidth(context) / 2
                        val finalHeight = ScreenUtil.getScreenWidth(context) / 2
                        val params = cover.layoutParams
                        //params.width = finalWidth
                        params.width = finalWidth
                        params.height = finalHeight
                        cover.layoutParams = params

                        cover.setImageResource(R.mipmap.liuyifei)


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
                        //val finalWidth = cover.width
                        val finalWidth = ScreenUtil.getScreenWidth(context) / 2
//                    val finalHeight = if (resourceWidth > finalWidth) {
//                        (resourceWidth / finalWidth.toDouble()) * resourceHeight
//                    } else {
//                        (finalWidth / resourceWidth.toDouble()) * resourceHeight
//                    }
                        val finalHeight = (resourceHeight / resourceWidth.toDouble()) * finalWidth
                        Log.e("lidandan3", "title:${data.title}, header:${data.cover}")
                        Log.e(
                            "lidandan3",
                            "宽=$resourceWidth, 高=$resourceHeight , width=$finalWidth, finalHeight:$finalHeight"
                        )
                        val params = cover.layoutParams
                        //params.width = finalWidth
                        params.width = finalWidth
                        params.height = finalHeight.toInt()
                        cover.layoutParams = params

                        cover.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                })


        }

        title.text = data.title

        if (videoData == null) {
            likes.visibility = View.GONE
            likeView.setImageResource(R.mipmap.img_item_comment_like)
        }

        videoData?.let {
            if (it.likes > 0) {
                likes.visibility = View.VISIBLE
                likes.text = it.likes.toString()
            } else {
                likes.visibility = View.GONE
            }

            if (!it.like) {
                likeView.setImageResource(R.mipmap.img_item_comment_like)
                likes.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_txt_right_comment_item_like
                    )
                )
            } else {
                likeView.setImageResource(R.mipmap.img_item_comment_liked)
                likes.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.color_txt_right_comment_item_liked
                    )
                )
            }
        }

        likeLayout.setOnClickListener {
            likeView.post {
                addScaleAnimation(likeView, 1.3f)
            }
            videoData?.let {
                if (it.like) {
                    likeView.setImageResource(R.mipmap.img_item_comment_like)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_txt_right_comment_item_like
                        )
                    )
                    it.likes -= 1
                    likes.text = it.likes.toString()
                    if (it.likes == 0) {
                        likes.visibility = View.GONE
                    }
                } else {
                    likeView.setImageResource(R.mipmap.img_item_comment_liked)
                    likes.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.color_txt_right_comment_item_liked
                        )
                    )
                    it.likes += 1
                    likes.visibility = View.VISIBLE
                    likes.text = it.likes.toString()
                }
                it.like = !it.like
            }
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