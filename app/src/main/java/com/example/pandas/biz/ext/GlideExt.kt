package com.example.pandas.biz.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import jp.wasabeef.glide.transformations.BlurTransformation


/**
 * 加载圆角图片
 * @date: 2/6/22 12:27 上午
 * @version: v1.0
 */
fun loadRoundedCornerImage(context: Context, radius: Int, url: String, view: ImageView) {
    val options = RequestOptions.bitmapTransform(RoundedCorners(radius))
    Glide.with(context).load(url).apply(options).into(view)
}

/**
 *
 * 设置图片样式为居中显示，然后裁剪边框
 *
 * 布局中设置Image的style为center时，裁剪不会生效
 */
fun loadCenterRoundedCornerImage(context: Context, radius: Int, url: String?, view: ImageView) {
    val options =
        RequestOptions.bitmapTransform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
    //url是可以为null的
    Glide.with(context).load(url).apply(options).placeholder(R.color.color_bg_video_item)
        .into(view)
    //}
//    if (url == null) {
//        Glide.with(context).load(R.mipmap.img_null_01).apply(options).into(view)
//    } else {
//        Glide.with(context).load(url).apply(options).placeholder(R.color.color_bg_video_item).into(view)
//    }
}

/**
 * 常规居中 url == null也行
 */
fun loadCenterImage(context: Context, url: String?, view: ImageView) {
    val options =
        RequestOptions.bitmapTransform(MultiTransformation(CenterCrop()))
    Glide.with(context).asBitmap()
        //.diskCacheStrategy(DiskCacheStrategy.NONE)//不要在disk硬盘中缓存
        //.skipMemoryCache(true)//跳过内存缓存，本项目不建议
        .load(url).listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(
                exception: GlideException?,
                model: Any?,
                target: Target<Bitmap>?,
                isFirstResource: Boolean
            ): Boolean {
                Log.e("1mean", "exception:$exception, thread:${Thread.currentThread()}")
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

        }).apply(options).placeholder(R.color.color_bg_video_item)
        .into(view)
}

/**
 * 圆形居中的bitmap
 */
fun loadCircleBitmap(context: Context, bitmap: Bitmap, view: ImageView) {
    val options =
        RequestOptions.bitmapTransform(MultiTransformation(CenterCrop(), CircleCrop()))
    Glide.with(context).load(bitmap).apply(options).into(view)
}

/**
 * 加载圆形图片
 */
fun loadCircleImage(context: Context, url: String, view: ImageView) {
    val options = RequestOptions.bitmapTransform(CircleCrop())
    Glide.with(context).load(url).apply(options).placeholder(R.color.color_bg_video_item).into(view)
}

fun loadLocalCircleImage(context: Context, urlRes: Int, view: ImageView) {
    val options = RequestOptions.bitmapTransform(CircleCrop())
    Glide.with(context).load(urlRes).apply(options).placeholder(R.color.color_bg_video_item)
        .into(view)
}

fun loadImage(context: Context, url: String, view: ImageView) {
    Glide.with(context).load(url).placeholder(R.color.color_bg_video_item).into(view)
}

fun loadEmptyCircleImage(context: Context, view: ImageView) {
    val options = RequestOptions.bitmapTransform(CircleCrop())
    Glide.with(context).load(R.mipmap.img_holder).apply(options).into(view)
}

fun loadHeadCircleImage(context: Context, url: String, view: ImageView) {
    val options = RequestOptions.bitmapTransform(CircleCrop())
    Glide.with(context).load(url).placeholder(R.mipmap.img_place_header).apply(options).into(view)
}

fun loadLayoutBackGround(context: Context, url: String, view: View) {

//    Glide.with(mContext)
//        .load(R.drawable.img_menu_top)
//        .bitmapTransform(
//            BlurTransformation(
//                mContext,
//                25,
//                20
//            )
//        )
//        .into(object : SimpleTarget<GlideDrawable?>() {
//            override fun onResourceReady(
//                resource: GlideDrawable,
//                glideAnimation: GlideAnimation<in GlideDrawable?>?
//            ) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    rlayout_header.setBackground(resource.getCurrent())
//                }
//            }
//        })

    /*设置高斯模糊效果,服务器请求的图片失真严重 sampling值越大颜色值会越浓*/
    /*设置背景 glide3.7的为Bitmap,兼容高斯模糊的glide是GlideDrawable,getCurrent()再转换成drawable*/
    Glide.with(context).asBitmap().load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 20)))
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                view.background = BitmapDrawable(context.resources, resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
}

fun loadPandaBackGround(context: Context, url: String, view: View) {

    /*设置高斯模糊效果,服务器请求的图片失真严重 sampling值越大颜色值会越浓*/
    /*设置背景 glide3.7的为Bitmap,兼容高斯模糊的glide是GlideDrawable,getCurrent()再转换成drawable*/
    Glide.with(context).asBitmap().load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(50, 10)))
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                view.background = BitmapDrawable(context.resources, resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
}

fun loadMusicBackGround(context: Context, url: String, view: View) {

    /*设置高斯模糊效果,服务器请求的图片失真严重 sampling值越大颜色值会越浓*/
    /*设置背景 glide3.7的为Bitmap,兼容高斯模糊的glide是GlideDrawable,getCurrent()再转换成drawable*/
    Glide.with(context).asBitmap().load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(30, 10)))
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                view.background = BitmapDrawable(context.resources, resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
}

fun clearMemoryCache(context: Context) {
    Glide.get(context).clearMemory()
}

fun clearFileCache(context: Context) {
    Thread {
        Glide.get(context).clearDiskCache()
    }.start()
}

