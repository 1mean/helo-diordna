package com.example.pandas.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.RelativeLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.interaction.OnItemLongClickListener
import com.example.pandas.biz.pictureselector.*
import com.example.pandas.databinding.ActivityPublishBinding
import com.example.pandas.ui.adapter.GridImageAdapter
import com.example.pandas.ui.view.camera.CustomLoadingDialog
import com.example.pandas.ui.view.recyclerview.FullyGridLayoutManager
import com.example.pandas.utils.ExoPlayerEngine
import com.example.pandas.utils.GlideEngine
import com.luck.picture.lib.animators.AnimationType
import com.luck.picture.lib.basic.*
import com.luck.picture.lib.config.*
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.*
import com.luck.picture.lib.language.LanguageConfig
import com.luck.picture.lib.style.BottomNavBarStyle
import com.luck.picture.lib.style.PictureSelectorStyle
import com.luck.picture.lib.style.SelectMainStyle
import com.luck.picture.lib.style.TitleBarStyle
import com.luck.picture.lib.utils.*
import com.yalantis.ucrop.UCrop
import java.io.File
import java.util.*

/**
 * @description: SettingActivity
 * @author: dongyiming
 * @date: 8/20/22 12:28 上午
 * @version: v1.0
 */
public class PublishActivity : BaseActivity<BaseViewModel, ActivityPublishBinding>(),
    IBridgePictureBehavior {

    private val TAG = "PictureSelectorTag"

    private val maxSelectNum = 9
    private val maxSelectVideoNum = 1
    private val mData = mutableListOf<LocalMedia>()
    private val showAlbumOrTakePhoto = true//直接显示相册 还是 直接弹出系统拍照和摄影，默认相册
    private val showSelectMask = false //是否显示蒙层，选中maxSelectNum后，其他相册加蒙层
    private val isCompress = false //是否压缩图片
    private val isCrop = false //是否裁剪图片
    private val useLoading = false //自定义loading
    private val isOriginal = false //是否开启原图功能
    private val addPermission = false //权限说明
    private val useCustomCamera = false //是否使用自定义相机
    private val useImageEditor = true //是否开启图片编辑
    private val isCustomPreview = false //自定义预览
    private val injectLayout = false //注入自定义布局
    private val isSortOrder = false //(降序/升序) 查询
    private val isUseOwnerPath = false //是否使用自定义路径
    private val isSelectAnim = false //自定义选中动画
    private val useActivityForAlbum = false //使用Activity承载系统相册
    private val useActivityForCamera = false //使用Activity承载Camera相机
    private var needScaleBig = true
    private var needScaleSmall = false
    private val ACTIVITY_RESULT = 1
    private val CALLBACK_RESULT = 2
    private val LAUNCHER_RESULT = 3
    private var aspect_ratio_x: Int = -1
    private var aspect_ratio_y: Int = -1
    private val resultMode = LAUNCHER_RESULT //ACTIVITY_RESULT=1,CALLBACK_RESULT=2,LAUNCHER_RESULT=3
    private var selectorStyle: PictureSelectorStyle? = null
    private var launcherResult: ActivityResultLauncher<Intent>? = null
    private var p_flag = false

    /**
     * 主题样式
     *      AnimationType.DEFAULT_ANIMATION
     *      AnimationType.ALPHA_IN_ANIMATION
     *      AnimationType.SLIDE_IN_BOTTOM_ANIMATION
     */
    private val animationMode = AnimationType.DEFAULT_ANIMATION
    private val mAdapter: GridImageAdapter by lazy { GridImageAdapter(this, mData) }

    override fun initView(savedInstanceState: Bundle?) {

        selectorStyle = PictureSelectorStyle()

        mAdapter.selectMax = maxSelectNum + maxSelectVideoNum

//        binding.recyclerPublish.run {
//            itemAnimator?.let {
//                (it as SimpleItemAnimator).supportsChangeAnimations = false
//            }
//            layoutManager = FullyGridLayoutManager(
//                this@PublishActivity,
//                4, GridLayoutManager.VERTICAL, false
//            )
//            addItemDecoration(
//                GridSpacingItemDecoration(
//                    4,
//                    DensityUtil.dip2px(this@PublishActivity, 8f),
//                    false
//                )
//            )
//            adapter = mAdapter
//        }

        // 注册需要写在onCreate或Fragment onAttach里，否则会报java.lang.IllegalStateException异常
        launcherResult = createActivityResultLauncher()
        val imageEngine = GlideEngine.createGlideEngine()
        val videoPlayerEngine = ExoPlayerEngine()
        val language = LanguageConfig.UNKNOWN_LANGUAGE
        val chooseMode = SelectMimeType.ofImage()


        // 进入相册
        val selectionModel: PictureSelectionModel =
            PictureSelector.create(this@PublishActivity)
                .openGallery(chooseMode)//最关键一步
                .setSelectorUIStyle(selectorStyle)
                .setImageEngine(imageEngine)
                .setVideoPlayerEngine(videoPlayerEngine)
                .setCropEngine(
                    if (isCrop) ImageFileCropEngine(
                        this@PublishActivity,
                        selectorStyle
                    ) else null
                )
                .setCompressEngine(if (isCompress) ImageFileCompressEngine() else null)
                .setSandboxFileEngine(MeSandboxFileEngine())
                .setCameraInterceptListener(
                    if (useCustomCamera) MeOnCameraInterceptListener(
                        this@PublishActivity,
                        addPermission,
                        isUseOwnerPath
                    ) else null
                )
                .setRecordAudioInterceptListener(MeOnRecordAudioInterceptListener())
                .setSelectLimitTipsListener(meOnSelectLimitTipsListener)
                .setEditMediaInterceptListener(
                    if (useImageEditor) MeOnMediaEditInterceptListener(
                        getSandboxPath(),
                        buildOptions()
                    ) else null
                )
                .setPermissionDescriptionListener(
                    if (addPermission) MeOnPermissionDescriptionListener(
                        this@PublishActivity
                    ) else null
                )
                .setPreviewInterceptListener(if (isCustomPreview) MeOnPreviewInterceptListener() else null)
                .setPermissionDeniedListener(if (addPermission) MeOnPermissionDeniedListener() else null)
                .setAddBitmapWatermarkListener(null)
                .setVideoThumbnailListener(null)
                .isAutoVideoPlay(true)
                .isLoopAutoVideoPlay(false)
                .isUseSystemVideoPlayer(false)
                .isPageSyncAlbumCount(true)
                .setCustomLoadingListener(getCustomLoadingListener())
                .setQueryFilterListener(OnQueryFilterListener { false }) //.setExtendLoaderEngine(getExtendLoaderEngine())
                .setInjectLayoutResourceListener(if (injectLayout) MeOnInjectLayoutResourceListener() else null)
                .setSelectionMode(SelectModeConfig.MULTIPLE)
                .setLanguage(language)
                .setQuerySortOrder(if (isSortOrder) MediaStore.MediaColumns.DATE_MODIFIED + " ASC" else "")
                .setOutputCameraDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                .setOutputAudioDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                .setQuerySandboxDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                .isDisplayTimeAxis(true)//显示资源时间轴
                .isOnlyObtainSandboxDir(false)//查询指定目录
                .isPageStrategy(true)//分页模式
                .isOriginalControl(isOriginal)
                .isDisplayCamera(true)//显示or隐藏拍摄
                .isOpenClickSound(false)//是否开启点击声音
                .setSkipCropMimeType(
                    PictureMimeType.ofGIF(),
                    PictureMimeType.ofWEBP()
                )
                .isFastSlidingSelect(true) //滑动选择
                //.setOutputCameraImageFileName("luck.jpeg")
                //.setOutputCameraVideoFileName("luck.mp4")
                .isWithSelectVideoImage(true)//图片视频同选
                .isPreviewFullScreenMode(true)//全屏预览(点击)
                .isVideoPauseResumePlay(false)//视频暂停与继续
                .isPreviewZoomEffect(true)//预览缩放效果
                .isPreviewImage(true)//是否预览图片
                .isPreviewVideo(true)//是否预览视频
                .isPreviewAudio(false)//是否预览音频
                .setGridItemSelectAnimListener(if (isSelectAnim) OnGridItemSelectAnimListener { view, isSelected ->//自定义选中动画
                    val set = AnimatorSet()
                    set.playTogether(
                        ObjectAnimator.ofFloat(
                            view,
                            "scaleX",
                            if (isSelected) 1f else 1.12f,
                            if (isSelected) 1.12f else 1.0f
                        ),
                        ObjectAnimator.ofFloat(
                            view,
                            "scaleY",
                            if (isSelected) 1f else 1.12f,
                            if (isSelected) 1.12f else 1.0f
                        )
                    )
                    set.duration = 350
                    set.start()
                } else null)
                .setSelectAnimListener(if (isSelectAnim) OnSelectAnimListener { view ->
                    val animation = AnimationUtils.loadAnimation(
                        this@PublishActivity,
                        R.anim.ps_anim_modal_in
                    )
                    view.startAnimation(animation)
                    animation.duration
                } else null) //.setQueryOnlyMimeType(PictureMimeType.ofGIF())
                .isMaxSelectEnabledMask(showSelectMask)//是否显示蒙层(达到最大可选数量)
                .isDirectReturnSingle(false)//单选模式直接返回
                .setMaxSelectNum(maxSelectNum)
                .setMaxVideoSelectNum(maxSelectVideoNum)
                .setRecyclerAnimationMode(animationMode)
                .isGif(true)//是否显示Gif图片
        //.setSelectedData(mAdapter.getData())
        forSelectResult(selectionModel)//进入图片预览的Activity。PictureSelectorSupporterActivity

        if (p_flag) {
            mAdapter.setOnItemClickListener(object : GridImageAdapter.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Log.e("1mean", "onItemClick: position:$position")
                    // 预览图片、视频、音频
                    PictureSelector.create(this@PublishActivity)
                        .openPreview()
                        .setImageEngine(imageEngine)
                        .setVideoPlayerEngine(videoPlayerEngine)
                        .setSelectorUIStyle(selectorStyle)
                        .setLanguage(language)
                        .isAutoVideoPlay(true)
                        .isLoopAutoVideoPlay(false)
                        .isPreviewFullScreenMode(true)
                        .isVideoPauseResumePlay(false)
                        .isUseSystemVideoPlayer(false)
                        .setCustomLoadingListener(getCustomLoadingListener())
                        .isPreviewZoomEffect(true, binding.recyclerPublish)
                        .setAttachViewLifecycle(object : IBridgeViewLifecycle {
                            override fun onViewCreated(
                                fragment: Fragment,
                                view: View,
                                savedInstanceState: Bundle
                            ) {
                            }

                            override fun onDestroy(fragment: Fragment) {
                            }
                        })
                        .setInjectLayoutResourceListener { _, resourceSource ->
                            if (resourceSource == InjectResourceSource.PREVIEW_LAYOUT_RESOURCE)
                                R.layout.ps_custom_fragment_preview
                            else
                                InjectResourceSource.DEFAULT_LAYOUT_RESOURCE
                        }
                        //.setInjectActivityPreviewFragment({ if (cb_custom_preview.isChecked()) CustomPreviewFragment.newInstance() else null })
                        .startActivityPreview(position, true, mAdapter.getData())
                }

                override fun openPicture() {

                    if (showAlbumOrTakePhoto) {
                        // 进入系统相册
                        if (showSelectMask) {
                            val systemGalleryMode: PictureSelectionSystemModel =
                                PictureSelector.create(this@PublishActivity)
                                    .openSystemGallery(chooseMode)
                                    .setSelectionMode(SelectModeConfig.MULTIPLE)
                                    .setCompressEngine(if (isCompress) ImageFileCompressEngine() else null)
                                    .setCropEngine(
                                        if (isCrop) ImageFileCropEngine(
                                            this@PublishActivity,
                                            selectorStyle
                                        ) else null
                                    )
                                    .setSkipCropMimeType(
                                        PictureMimeType.ofGIF(),
                                        PictureMimeType.ofWEBP()
                                    )
                                    .setSelectLimitTipsListener(meOnSelectLimitTipsListener)
                                    .setAddBitmapWatermarkListener(null)//添加水印
                                    .setVideoThumbnailListener(null)//处理视频缩略图
                                    .setCustomLoadingListener(getCustomLoadingListener())//自定义loading
                                    .isOriginalControl(isOriginal)//是否开启原图功能
                                    .setPermissionDescriptionListener(
                                        if (addPermission) MeOnPermissionDescriptionListener(
                                            this@PublishActivity
                                        ) else null
                                    )//添加权限说明
                                    .setSandboxFileEngine(MeSandboxFileEngine())
                            forSystemResult(systemGalleryMode)
                        } else {
                            // 进入相册
                            val selectionModel: PictureSelectionModel =
                                PictureSelector.create(this@PublishActivity)
                                    .openGallery(chooseMode)//最关键一步
                                    .setSelectorUIStyle(selectorStyle)
                                    .setImageEngine(imageEngine)
                                    .setVideoPlayerEngine(videoPlayerEngine)
                                    .setCropEngine(
                                        if (isCrop) ImageFileCropEngine(
                                            this@PublishActivity,
                                            selectorStyle
                                        ) else null
                                    )
                                    .setCompressEngine(if (isCompress) ImageFileCompressEngine() else null)
                                    .setSandboxFileEngine(MeSandboxFileEngine())
                                    .setCameraInterceptListener(
                                        if (useCustomCamera) MeOnCameraInterceptListener(
                                            this@PublishActivity,
                                            addPermission,
                                            isUseOwnerPath
                                        ) else null
                                    )
                                    .setRecordAudioInterceptListener(
                                        MeOnRecordAudioInterceptListener()
                                    )
                                    .setSelectLimitTipsListener(meOnSelectLimitTipsListener)
                                    .setEditMediaInterceptListener(
                                        if (useImageEditor) MeOnMediaEditInterceptListener(
                                            getSandboxPath(),
                                            buildOptions()
                                        ) else null
                                    )
                                    .setPermissionDescriptionListener(
                                        if (addPermission) MeOnPermissionDescriptionListener(
                                            this@PublishActivity
                                        ) else null
                                    )
                                    .setPreviewInterceptListener(if (isCustomPreview) MeOnPreviewInterceptListener() else null)
                                    .setPermissionDeniedListener(if (addPermission) MeOnPermissionDeniedListener() else null)
                                    .setAddBitmapWatermarkListener(null)
                                    .setVideoThumbnailListener(null)
                                    .isAutoVideoPlay(true)
                                    .isLoopAutoVideoPlay(false)
                                    .isUseSystemVideoPlayer(false)
                                    .isPageSyncAlbumCount(true)
                                    .setCustomLoadingListener(getCustomLoadingListener())
                                    .setQueryFilterListener(OnQueryFilterListener { false }) //.setExtendLoaderEngine(getExtendLoaderEngine())
                                    .setInjectLayoutResourceListener(if (injectLayout) MeOnInjectLayoutResourceListener() else null)
                                    .setSelectionMode(SelectModeConfig.MULTIPLE)
                                    .setLanguage(language)
                                    .setQuerySortOrder(if (isSortOrder) MediaStore.MediaColumns.DATE_MODIFIED + " ASC" else "")
                                    .setOutputCameraDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                                    .setOutputAudioDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                                    .setQuerySandboxDir(if (chooseMode == SelectMimeType.ofAudio()) getSandboxAudioOutputPath() else getSandboxCameraOutputPath())
                                    .isDisplayTimeAxis(true)//显示资源时间轴
                                    .isOnlyObtainSandboxDir(false)//查询指定目录
                                    .isPageStrategy(true)//分页模式
                                    .isOriginalControl(isOriginal)
                                    .isDisplayCamera(true)//显示or隐藏拍摄
                                    .isOpenClickSound(false)//是否开启点击声音
                                    .setSkipCropMimeType(
                                        PictureMimeType.ofGIF(),
                                        PictureMimeType.ofWEBP()
                                    )
                                    .isFastSlidingSelect(true) //滑动选择
                                    //.setOutputCameraImageFileName("luck.jpeg")
                                    //.setOutputCameraVideoFileName("luck.mp4")
                                    .isWithSelectVideoImage(true)//图片视频同选
                                    .isPreviewFullScreenMode(true)//全屏预览(点击)
                                    .isVideoPauseResumePlay(false)//视频暂停与继续
                                    .isPreviewZoomEffect(true)//预览缩放效果
                                    .isPreviewImage(true)//是否预览图片
                                    .isPreviewVideo(true)//是否预览视频
                                    .isPreviewAudio(false)//是否预览音频
                                    .setGridItemSelectAnimListener(if (isSelectAnim) OnGridItemSelectAnimListener { view, isSelected ->//自定义选中动画
                                        val set = AnimatorSet()
                                        set.playTogether(
                                            ObjectAnimator.ofFloat(
                                                view,
                                                "scaleX",
                                                if (isSelected) 1f else 1.12f,
                                                if (isSelected) 1.12f else 1.0f
                                            ),
                                            ObjectAnimator.ofFloat(
                                                view,
                                                "scaleY",
                                                if (isSelected) 1f else 1.12f,
                                                if (isSelected) 1.12f else 1.0f
                                            )
                                        )
                                        set.duration = 350
                                        set.start()
                                    } else null)
                                    .setSelectAnimListener(if (isSelectAnim) OnSelectAnimListener { view ->
                                        val animation = AnimationUtils.loadAnimation(
                                            this@PublishActivity,
                                            R.anim.ps_anim_modal_in
                                        )
                                        view.startAnimation(animation)
                                        animation.duration
                                    } else null) //.setQueryOnlyMimeType(PictureMimeType.ofGIF())
                                    .isMaxSelectEnabledMask(true)//是否显示蒙层(达到最大可选数量)
                                    .isDirectReturnSingle(false)//单选模式直接返回
                                    .setMaxSelectNum(maxSelectNum)
                                    .setMaxVideoSelectNum(maxSelectVideoNum)
                                    .setRecyclerAnimationMode(animationMode)
                                    .isGif(true)//是否显示Gif图片
                                    .setSelectedData(mAdapter.getData())
                            forSelectResult(selectionModel)
                        }
                    } else {
                        // 单独拍照
                        val cameraModel: PictureSelectionCameraModel =
                            PictureSelector.create(this@PublishActivity)
                                .openCamera(chooseMode)
                                .setCameraInterceptListener(
                                    if (useCustomCamera) MeOnCameraInterceptListener(
                                        this@PublishActivity,
                                        addPermission,
                                        isUseOwnerPath
                                    ) else null
                                )
                                .setRecordAudioInterceptListener(MeOnRecordAudioInterceptListener())
                                .setCropEngine(
                                    if (isCrop) ImageFileCropEngine(
                                        this@PublishActivity,
                                        selectorStyle
                                    ) else null
                                )
                                .setCompressEngine(if (isCompress) ImageFileCompressEngine() else null)
                                .setSelectLimitTipsListener(meOnSelectLimitTipsListener)
                                .setAddBitmapWatermarkListener(null)
                                .setVideoThumbnailListener(null)
                                .setCustomLoadingListener(getCustomLoadingListener())
                                .setLanguage(language)
                                .setSandboxFileEngine(MeSandboxFileEngine())
                                .isOriginalControl(isOriginal)
                                .setPermissionDescriptionListener(
                                    if (addPermission) MeOnPermissionDescriptionListener(
                                        this@PublishActivity
                                    ) else null
                                )
                                .setOutputAudioDir(getSandboxAudioOutputPath())
                                .setSelectedData(mAdapter.getData())
                        forOnlyCameraResult(cameraModel)
                    }
                }
            })
        }
//        mAdapter.setItemLongClickListener(object : OnItemLongClickListener {
//            override fun onItemLongClick(holder: RecyclerView.ViewHolder, position: Int, v: View) {
//                val itemViewType = holder.itemViewType
//                if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
//                    mItemTouchHelper.startDrag(holder)
//                }
//            }
//        })
        // 绑定拖拽事件
        // 绑定拖拽事件
        // mItemTouchHelper.attachToRecyclerView(binding.recyclerPublish)

        initLayout()
    }

    private fun initLayout() {

        val whiteTitleBarStyle = TitleBarStyle()
        whiteTitleBarStyle.titleBackgroundColor =
            ContextCompat.getColor(this, R.color.black)
        //whiteTitleBarStyle.titleDrawableRightResource = R.drawable.ic_orange_arrow_down
        //whiteTitleBarStyle.titleLeftBackResource = R.drawable.ps_ic_black_back
        whiteTitleBarStyle.titleTextColor =
            ContextCompat.getColor(this, R.color.white)
        whiteTitleBarStyle.titleCancelTextColor =
            ContextCompat.getColor(this, R.color.white)
        whiteTitleBarStyle.isDisplayTitleBarLine = false
        whiteTitleBarStyle.isHideCancelButton = true

        val whiteBottomNavBarStyle = BottomNavBarStyle()
        whiteBottomNavBarStyle.bottomNarBarBackgroundColor =
            ContextCompat.getColor(this, R.color.black)
        whiteBottomNavBarStyle.bottomPreviewSelectTextColor =
            ContextCompat.getColor(this, R.color.white)

        whiteBottomNavBarStyle.bottomPreviewNormalTextColor =
            ContextCompat.getColor(this, R.color.white)
        whiteBottomNavBarStyle.bottomPreviewSelectTextColor =
            ContextCompat.getColor(this, R.color.color_bg_pink)
        whiteBottomNavBarStyle.isCompleteCountTips = false
        whiteBottomNavBarStyle.bottomEditorTextColor =
            ContextCompat.getColor(this, R.color.white)
        whiteBottomNavBarStyle.bottomOriginalTextColor =
            ContextCompat.getColor(this, R.color.white)

        val selectMainStyle = SelectMainStyle()
        selectMainStyle.statusBarColor =
            ContextCompat.getColor(this, R.color.ps_color_white)
        //selectMainStyle.isDarkStatusBarBlack = true//不显示状态栏字体，都设置为黑色就看不到了
        selectMainStyle.selectNormalTextColor =
            ContextCompat.getColor(this, R.color.ps_color_9b)
        selectMainStyle.adapterDurationGravity =
            intArrayOf(RelativeLayout.ALIGN_PARENT_RIGHT)
//        selectMainStyle.adapterItemSpacingSize = resources.getDimension(R.dimen.common_lh_4_dimens).toInt()
//        selectMainStyle.isAdapterItemIncludeEdge = true
        selectMainStyle.selectTextColor =
            ContextCompat.getColor(this, R.color.color_bg_pink)
        selectMainStyle.previewSelectBackground = R.drawable.ps_demo_white_preview_selector
        selectMainStyle.selectBackground = R.drawable.ps_checkbox_selector
        selectMainStyle.setSelectText(R.string.ps_done_front_num)
        selectMainStyle.mainListBackgroundColor =
            ContextCompat.getColor(this, R.color.ps_color_black)

        selectorStyle!!.titleBarStyle = whiteTitleBarStyle
        selectorStyle!!.bottomBarStyle = whiteBottomNavBarStyle
        selectorStyle!!.selectMainStyle = selectMainStyle
    }


    private val mItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {

        override fun isLongPressDragEnabled(): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val itemViewType = viewHolder.itemViewType
            if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                viewHolder.itemView.alpha = 0.7f
            }
            return makeMovementFlags(
                ItemTouchHelper.DOWN or ItemTouchHelper.UP
                        or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT, 0
            )
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            try {
                //得到item原来的position
                val fromPosition = viewHolder.absoluteAdapterPosition
                //得到目标position
                val toPosition = target.absoluteAdapterPosition
                val itemViewType = target.itemViewType
                if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                    if (fromPosition < toPosition) {
                        for (i in fromPosition until toPosition) {
                            Collections.swap(mAdapter.getData(), i, i + 1)
                        }
                    } else {
                        for (i in fromPosition downTo toPosition + 1) {
                            Collections.swap(mAdapter.getData(), i, i - 1)
                        }
                    }
                    mAdapter.notifyItemMoved(fromPosition, toPosition)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return true
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dx: Float,
            dy: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
//            val itemViewType = viewHolder.itemViewType
//            if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
//                if (needScaleBig) {
//                    needScaleBig = false
//                    val animatorSet = AnimatorSet()
//                    animatorSet.playTogether(
//                        ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.0f, 1.1f),
//                        ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.0f, 1.1f)
//                    )
//                    animatorSet.duration = 50
//                    animatorSet.interpolator = LinearInterpolator()
//                    animatorSet.start()
//                    animatorSet.addListener(object : AnimatorListenerAdapter() {
//                        override fun onAnimationEnd(animation: Animator) {
//                            needScaleSmall = true
//                        }
//                    })
//                }
//                val targetDy: Int = tvDeleteText.getTop() - viewHolder.itemView.bottom
//                if (dy >= targetDy) {
//                    //拖到删除处
//                    mDragListener.deleteState(true)
//                    if (isHasLiftDelete) {
//                        //在删除处放手，则删除item
//                        viewHolder.itemView.visibility = View.INVISIBLE
//                        mAdapter.delete(viewHolder.absoluteAdapterPosition)
//                        resetState()
//                        return
//                    }
//                } else {
//                    //没有到删除处
//                    if (View.INVISIBLE == viewHolder.itemView.visibility) {
//                        //如果viewHolder不可见，则表示用户放手，重置删除区域状态
//                        mDragListener.dragState(false)
//                    }
//                    mDragListener.deleteState(false)
//                }
//                super.onChildDraw(
//                    c,
//                    recyclerView,
//                    viewHolder,
//                    dx,
//                    dy,
//                    actionState,
//                    isCurrentlyActive
//                )
//            }
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
//            val itemViewType = viewHolder?.itemViewType ?: GridImageAdapter.TYPE_CAMERA
//            if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
//                if (ItemTouchHelper.ACTION_STATE_DRAG == actionState) {
//                    mDragListener.dragState(true)
//                }
//                super.onSelectedChanged(viewHolder, actionState)
//            }
        }

        override fun getAnimationDuration(
            recyclerView: RecyclerView,
            animationType: Int,
            animateDx: Float,
            animateDy: Float
        ): Long {
            //isHasLiftDelete = true
            return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy)
        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
            val itemViewType = viewHolder.itemViewType
            if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                viewHolder.itemView.alpha = 1.0f
                if (needScaleSmall) {
                    needScaleSmall = false
                    val animatorSet = AnimatorSet()
                    animatorSet.playTogether(
                        ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.1f, 1.0f),
                        ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.1f, 1.0f)
                    )
                    animatorSet.interpolator = LinearInterpolator()
                    animatorSet.duration = 50
                    animatorSet.start()
                    animatorSet.addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            needScaleBig = true
                        }
                    })
                }
                super.clearView(recyclerView, viewHolder)
                mAdapter.notifyItemChanged(viewHolder.absoluteAdapterPosition)
                //resetState()
            }
        }
    })

    override fun createObserver() {
    }

    /**
     * 拦截自定义提示
     */
    private val meOnSelectLimitTipsListener = object : OnSelectLimitTipsListener {

        override fun onSelectLimitTips(
            context: Context?,
            media: LocalMedia?,
            config: SelectorConfig,
            limitType: Int
        ): Boolean {
            if (limitType == SelectLimitType.SELECT_MIN_SELECT_LIMIT) {
                ToastUtils.showToast(context, "图片最少不能低于" + config.minSelectNum + "张")
                return true
            } else if (limitType == SelectLimitType.SELECT_MIN_VIDEO_SELECT_LIMIT) {
                ToastUtils.showToast(context, "视频最少不能低于" + config.minVideoSelectNum + "个")
                return true
            } else if (limitType == SelectLimitType.SELECT_MIN_AUDIO_SELECT_LIMIT) {
                ToastUtils.showToast(context, "音频最少不能低于" + config.minAudioSelectNum + "个")
                return true
            }
            return false
        }
    }

    /**
     * 自定义loading
     *
     * @return
     */
    private fun getCustomLoadingListener(): OnCustomLoadingListener? {
        return if (useLoading) {
            OnCustomLoadingListener { context -> CustomLoadingDialog(context) }
        } else null
    }

    private fun forSystemResult(model: PictureSelectionSystemModel) {
        if (useActivityForAlbum) {
            when (resultMode) {
                ACTIVITY_RESULT -> model.forSystemResultActivity(PictureConfig.REQUEST_CAMERA)
                CALLBACK_RESULT -> model.forSystemResultActivity(meOnResultCallbackListener)
                else -> model.forSystemResultActivity(launcherResult)
            }
        } else {
            if (resultMode == CALLBACK_RESULT) {
                model.forSystemResult(meOnResultCallbackListener)
            } else {
                model.forSystemResult()
            }
        }
    }

    /**
     * 选择结果
     */
    private val meOnResultCallbackListener = object : OnResultCallbackListener<LocalMedia> {
        override fun onResult(result: ArrayList<LocalMedia>) {
            analyticalSelectResults(result)
        }

        override fun onCancel() {
            Log.i("PictureSelectorTag", "PictureSelector Cancel")
        }
    }

    /**
     * 处理选择结果
     *
     * @param result
     */
    private fun analyticalSelectResults(result: ArrayList<LocalMedia>) {
        for (media in result) {
            if (media.width == 0 || media.height == 0) {
                if (PictureMimeType.isHasImage(media.mimeType)) {
                    val imageExtraInfo = MediaUtils.getImageSize(this, media.path)
                    media.width = imageExtraInfo.width
                    media.height = imageExtraInfo.height
                } else if (PictureMimeType.isHasVideo(media.mimeType)) {
                    val videoExtraInfo = MediaUtils.getVideoSize(this, media.path)
                    media.width = videoExtraInfo.width
                    media.height = videoExtraInfo.height
                }
            }
            Log.i("PictureSelectorTag", "文件名: " + media.fileName)
            Log.i("PictureSelectorTag", "是否压缩:" + media.isCompressed)
            Log.i("PictureSelectorTag", "压缩:" + media.compressPath)
            Log.i("PictureSelectorTag", "初始路径:" + media.path)
            Log.i("PictureSelectorTag", "绝对路径:" + media.realPath)
            Log.i("PictureSelectorTag", "是否裁剪:" + media.isCut)
            Log.i("PictureSelectorTag", "裁剪路径:" + media.cutPath)
            Log.i("PictureSelectorTag", "是否开启原图:" + media.isOriginal)
            Log.i("PictureSelectorTag", "原图路径:" + media.originalPath)
            Log.i("PictureSelectorTag", "沙盒路径:" + media.sandboxPath)
            Log.i("PictureSelectorTag", "水印路径:" + media.watermarkPath)
            Log.i("PictureSelectorTag", "视频缩略图:" + media.videoThumbnailPath)
            Log.i("PictureSelectorTag", "原始宽高: " + media.width + "x" + media.height)
            Log.i(
                "PictureSelectorTag",
                "裁剪宽高: " + media.cropImageWidth + "x" + media.cropImageHeight
            )
            Log.i(
                "PictureSelectorTag",
                "文件大小: " + PictureFileUtils.formatAccurateUnitFileSize(media.size)
            )
            Log.i("PictureSelectorTag", "文件时长: " + media.duration)
        }
    }

    /**
     * 创建一个ActivityResultLauncher
     *
     * @return
     */
    private fun createActivityResultLauncher(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val resultCode = result.resultCode
            if (resultCode == Activity.RESULT_OK) {

                result.data?.let {
                    if (SDK_INT >= 33) {
                        val list = it.extras?.getParcelableArrayList("data", LocalMedia::class.java)
                        Log.e("1mean", "1 list size: ${list?.size}")
                    } else {
                        @Suppress("DEPRECATION")
                        val list = it.extras?.getParcelableArrayList<LocalMedia>("data")
                        Log.e("1mean", "2 list size: ${list?.size}")
                    }
                }
                finish()
//                val selectList = PictureSelector.obtainSelectorList(result.data)
//                analyticalSelectResults(selectList)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("PictureSelectorTag", "onActivityResult PictureSelector Cancel")
            } else if (resultCode == 5) {//PictureSelectorSupporterActivity左滑屏幕退出
                finish()
            }
        }
    }

    /**
     * 创建自定义输出目录
     *
     * @return
     */
    private fun getSandboxPath(): String {
        val externalFilesDir = getExternalFilesDir("")
        val customFile = File(externalFilesDir?.absolutePath, "Sandbox")
        if (!customFile.exists()) {
            customFile.mkdirs()
        }
        return customFile.absolutePath + File.separator
    }

    /**
     * 配制UCrop，可根据需求自我扩展
     *
     * @return
     */
    private fun buildOptions(): UCrop.Options {
        val options = UCrop.Options()
        options.setHideBottomControls(true)//是否显示裁剪菜单栏
        options.setFreeStyleCropEnabled(true)//裁剪框or图片拖动
        options.setShowCropFrame(true)//是否显示裁剪边框
        options.setShowCropGrid(true)//是否显示裁剪框网格
        options.setCircleDimmedLayer(false)//圆形头像裁剪模式
        options.withAspectRatio(
            aspect_ratio_x.toFloat(),
            aspect_ratio_y.toFloat()
        )//比例，默认和1:1/3:4/3:2/16:9
        options.setCropOutputPathDir(getSandboxPath())
        options.isCropDragSmoothToCenter(false)
        options.setSkipCropMimeType(
            PictureMimeType.ofGIF(),
            PictureMimeType.ofWEBP()
        )//跳过裁剪的类型，gif和webp
        options.isForbidCropGifWebp(false)//不支持剪辑gif和webp
        options.isForbidSkipMultipleCrop(true)
        options.setMaxScaleMultiplier(100f)
        if (selectorStyle != null && selectorStyle!!.selectMainStyle.statusBarColor != 0) {
            val mainStyle: SelectMainStyle = selectorStyle!!.selectMainStyle
            val isDarkStatusBarBlack = mainStyle.isDarkStatusBarBlack
            val statusBarColor = mainStyle.statusBarColor
            options.isDarkStatusBarBlack(isDarkStatusBarBlack)
            if (StyleUtils.checkStyleValidity(statusBarColor)) {
                options.setStatusBarColor(statusBarColor)
                options.setToolbarColor(statusBarColor)
            } else {
                options.setStatusBarColor(ContextCompat.getColor(this, R.color.ps_color_grey))
                options.setToolbarColor(ContextCompat.getColor(this, R.color.ps_color_grey))
            }
            val titleBarStyle: TitleBarStyle = selectorStyle!!.titleBarStyle
            if (StyleUtils.checkStyleValidity(titleBarStyle.titleTextColor)) {
                options.setToolbarWidgetColor(titleBarStyle.titleTextColor)
            } else {
                options.setToolbarWidgetColor(
                    ContextCompat.getColor(this, R.color.ps_color_white)
                )
            }
        } else {
            options.setStatusBarColor(ContextCompat.getColor(this, R.color.ps_color_grey))
            options.setToolbarColor(ContextCompat.getColor(this, R.color.ps_color_grey))
            options.setToolbarWidgetColor(
                ContextCompat.getColor(this, R.color.ps_color_white)
            )
        }
        return options
    }

    /**
     * 创建音频自定义输出目录
     *
     * @return
     */
    private fun getSandboxAudioOutputPath(): String {
        return if (isUseOwnerPath) {
            val externalFilesDir = getExternalFilesDir("")
            val customFile = File(externalFilesDir?.absolutePath, "Sound")
            if (!customFile.exists()) {
                customFile.mkdirs()
            }
            customFile.absolutePath + File.separator
        } else {
            ""
        }
    }

    /**
     * 创建相机自定义输出目录
     *
     * @return
     */
    private fun getSandboxCameraOutputPath(): String {
        return if (isUseOwnerPath) {
            val externalFilesDir = getExternalFilesDir("")
            val customFile = File(externalFilesDir?.absolutePath, "Sandbox")
            if (!customFile.exists()) {
                customFile.mkdirs()
            }
            customFile.absolutePath + File.separator
        } else {
            ""
        }
    }


    private fun forSelectResult(model: PictureSelectionModel) {
        when (resultMode) {
            ACTIVITY_RESULT -> model.forResult(PictureConfig.CHOOSE_REQUEST)
            CALLBACK_RESULT -> model.forResult(meOnResultCallbackListener)
            else -> model.forResult(launcherResult)
        }
    }

    private fun forOnlyCameraResult(model: PictureSelectionCameraModel) {
        if (useActivityForCamera) {
            when (resultMode) {
                ACTIVITY_RESULT -> model.forResultActivity(PictureConfig.REQUEST_CAMERA)
                CALLBACK_RESULT -> model.forResultActivity(meOnResultCallbackListener)
                else -> model.forResultActivity(launcherResult)
            }
        } else {
            if (resultMode == CALLBACK_RESULT) {
                model.forResult(meOnResultCallbackListener)
            } else {
                model.forResult()
            }
        }
    }

    override fun onSelectFinish(result: PictureCommonFragment.SelectorResult?) {
        if (result == null) {
            return
        }
        if (result.mResultCode == Activity.RESULT_OK) {
            val selectorResult = PictureSelector.obtainSelectorList(result.mResultData)
            analyticalSelectResults(selectorResult)
        } else if (result.mResultCode == Activity.RESULT_CANCELED) {
            Log.i(TAG, "onSelectFinish PictureSelector Cancel")
        }
    }
}