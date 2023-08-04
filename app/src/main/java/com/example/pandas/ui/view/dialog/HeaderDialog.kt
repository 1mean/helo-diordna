import android.R.attr.duration
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.ScreenUtil
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File


/**
 * @description: 我的，点开头像
 * @author: dongyiming
 * @date: 7/20/23 1:51 PM
 * @version: v1.0
 */
@SuppressLint("ClickableViewAccessibility")
public class HeaderDialog(
    private val activity: Activity,
    private val coroutineScope: CoroutineScope,
    private val listener: ItemClickListener<Int>
) :
    PopupWindow() {

    var headerImg: AppCompatImageView? = null

    init {

        val view = activity.layoutInflater.inflate(R.layout.dialog_header, null)
        contentView = view

        headerImg = view.findViewById<AppCompatImageView>(R.id.img_dialog_header)
        val download = view.findViewById<ConstraintLayout>(R.id.clayout_header_download)
        val capture = view.findViewById<ConstraintLayout>(R.id.clayout_header_capture)
        val picture = view.findViewById<ConstraintLayout>(R.id.clayout_header_picture)
        val close = view.findViewById<ConstraintLayout>(R.id.clayout_header_close)

        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.MATCH_PARENT

        isFocusable = true

        //去掉默认的动画效果，因为showAsDropDown会自带默认动画
        animationStyle = R.style.style_header_dialog_animation

        coroutineScope.launch(Dispatchers.Default) {

            val faceDir = FileUtils.getExternalFilePath(contentView.context, "face")
            val faceFile = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")
            val url = if (faceFile.exists()) {
                faceFile.absolutePath
            } else {
                AppInfos.HEAD_URL
            }
            withContext(Dispatchers.Main) {
                Glide.with(contentView.context).asBitmap().load(url)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)//配合使用，不然一直加载的上一次的缓存文件
                    .into(object : CustomTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            addImageView(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
            }
        }

        close.setOnClickListener {
            dismiss()
        }

        capture.setOnClickListener {
            listener.onItemClick(0)
        }

        picture.setOnClickListener {
            listener.onItemClick(1)
        }

        download.setOnClickListener {
            listener.onItemClick(2)
        }

        setTouchInterceptor { v, event ->

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                    val rects = mutableListOf<Rect>()
                    val views = arrayListOf<View>(download, capture, picture)
                    views.forEach {
                        val rect = Rect()
                        val coordinates = IntArray(2)
                        it.getLocationOnScreen(coordinates)
                        rect.set(
                            0,
                            coordinates[1],
                            it.width,
                            coordinates[1] + it.height
                        )
                        rects.add(rect)
                    }
                    val x = event.x.toInt()
                    val y = event.y.toInt()
                    var isInside = false
                    rects.forEach {
                        if (it.contains(x, y)) {
                            isInside = true
                        }
                    }
                    if (!isInside) {
                        animationStyle = R.style.style_header_dialog_animation
                        dismiss()
                    }
                }
            }
            false
        }
    }

    fun onShow(parent: View) {
        isOutsideTouchable = true
        showAtLocation(parent, Gravity.CENTER, 0, 0)
    }

    override fun showAtLocation(parent: View?, gravity: Int, x: Int, y: Int) {
        super.showAtLocation(parent, gravity, x, y)
        parent?.postDelayed({
            val animation = AnimationUtils.loadAnimation(activity, R.anim.animate_header_dialog_in)
            contentView.startAnimation(animation)
        }, 1)
    }

    private var loadingPopup: LoadingPopupView? = null
    fun loadingShow() {
        if (loadingPopup == null) {
            loadingPopup =
                XPopup.Builder(activity).dismissOnBackPressed(true)
                    .isLightNavigationBar(true)
                    .isViewMode(false)
                    .asLoading(
                        null,
                        R.layout.layout_waiting,
                        LoadingPopupView.Style.ProgressBar
                    )
            loadingPopup!!.show()
        } else {
            loadingPopup!!.show()
        }
    }

    fun downLoadHeader(isSuccess: Boolean) {

        contentView.postDelayed({
            loadingPopup?.dismiss()
            if (isSuccess) {
                Toast.makeText(activity, "已保存到相册", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "图片保存失败！！", Toast.LENGTH_SHORT).show()
            }
        }, 500)
    }

    fun setHeader(resource: Bitmap) {
        headerImg?.let {
            it.postDelayed({
                loadingPopup?.dismiss()
                addImageView(resource)
            }, 500)
        }
    }

    private fun addImageView(resource: Bitmap) {

        val resourceWidth = resource.width
        val resourceHeight = resource.height

        val finalWidth = ScreenUtil.getScreenWidth(contentView.context)
        val finalHeight =
            (resourceHeight / resourceWidth.toDouble()) * finalWidth

        val params = headerImg?.layoutParams
        params?.width = finalWidth
        if (finalHeight > 1200) {
            params?.height = 1200
        } else {
            params?.height = finalHeight.toInt()
        }

        Log.e("1mean", "finalHeight: $finalHeight")
        headerImg?.layoutParams = params

        headerImg?.setImageBitmap(resource)
    }

    override fun dismiss() {

        val animation = AnimationUtils.loadAnimation(activity, R.anim.animate_header_dialog_out)
        contentView.startAnimation(animation)
        contentView.postDelayed({ super.dismiss() }, 500)
    }
}