package com.example.pandas.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.android.android_sqlite.entity.User
import com.android.base.ui.activity.BaseActivity
import com.android.base.utils.BitmapUtils
import com.android.base.utils.FileUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.android.base.ui.lifecycle.LifecycleHandler
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.dialog.FaceAddSheetDialog
import com.example.pandas.ui.view.dialog.SexSelectDialog
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import com.lxj.xpopup.interfaces.OnSelectListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

/**
 * @description: 个人信息
 * @author: dongyiming
 * @date: 4/13/22 5:38 下午
 * @version: v1.0
 */
public class SelfInfoActivity : BaseActivity<SelfViewModel, ActivityMineInfoBinding>() {

    private var mDialog: FaceAddSheetDialog? = null
    private var sDialog: SexSelectDialog? = null
    private var loadingPopup: LoadingPopupView? = null
    private var tempCameraPicName: String = ""
    private var hasHeader: Boolean = false
    val TAG_INFO = "fragment_mine_info"
    private var type: Int = -1
    private var sexType: Int = 0
    private var user: User? = null
    private val sexs
        get() = mapOf<Int, String>(0 to "男", 1 to "女", 2 to "保密")

    @RequiresApi(Build.VERSION_CODES.R)
    private val albumLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.let { intent ->
                    intent.data?.let { uri ->
                        if (loadingPopup == null) {
                            loadingPopup =
                                XPopup.Builder(this@SelfInfoActivity).dismissOnBackPressed(true)
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
                        trackPicture(uri)
                    }
                }
            }
        }

    @RequiresApi(Build.VERSION_CODES.R)
    private val takePictureLauncher =
        //TakePicturePreview()返回bitmap预览图，是缩略图，比较模糊
        registerForActivityResult(ActivityResultContracts.TakePicture()) { result ->
            if (result) {
                if (loadingPopup == null) {
                    loadingPopup =
                        XPopup.Builder(this@SelfInfoActivity).dismissOnBackPressed(true)
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
                trackFace()
            }
        }

    private val reNameLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.let { intent ->
                    val newName = intent.getStringExtra("newName")
                    newName?.let {
                        user?.let { u ->
                            u.userName = it
                        }
                        binding.txtMineInfoName.text = it
                    }
                }
            }
        }

    private val reSignLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.let { intent ->
                    val newSign = intent.getStringExtra("newSign")
                    newSign?.let {
                        user?.let { u ->
                            u.signature = it
                        }
                        binding.txtSelfSign.text = it
                    }
                }
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(
            this,
            !AppInstance.instance.isNightMode,//深色模式
            R.color.color_bg_activity_setting
        )

        binding.btnSelfBack.setOnClickListener {
            backFinish()
        }

        binding.clayoutSelfHeader.setOnClickListener {
            showDialog()
        }

        binding.clayoutSelfName.setOnClickListener {
            user?.let {
                val intent = Intent(this, ReNameActivity::class.java)
                intent.putExtra("name", it.userName)
                reNameLauncher.launch(intent)
            }
        }

        binding.clayoutInfoSex.setOnClickListener {
            showSexDialog()
        }

        binding.clayoutInfoSign.setOnClickListener {
            user?.let {
                val intent = Intent(this, SignActivity::class.java)
                intent.putExtra("sign", it.signature)
                reSignLauncher.launch(intent)
            }
        }

        if (!AppInstance.instance.isNightMode) {
            appViewModel.appColorType.value?.let {
                if (it == 0) {
                    binding.clayoutInfoTop.setBackgroundResource(R.color.color_bg_activity_setting)
                    binding.btnSelfBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtSelfInfo.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                } else {
                    binding.clayoutInfoTop.setBackgroundResource(viewColors[it])
                    binding.btnSelfBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtSelfInfo.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.white
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }
    }

    override fun onkeyBack() {
        backFinish()
    }

    private fun showDialog() {

        if (mDialog == null) {
            mDialog = FaceAddSheetDialog(this, object : ItemClickListener<Int> {
                @RequiresApi(Build.VERSION_CODES.R)
                override fun onItemClick(t: Int) {
                    if (t == 1) {
                        val faceDir =
                            FileUtils.getExternalFilePath(this@SelfInfoActivity, "face")
                        if (faceDir.isEmpty()) {
                            return
                        }
                        val facePic = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")
                        tempCameraPicName = facePic.absolutePath

                        val authority = "${applicationContext.packageName}.fileProvider"
                        val uri = FileProvider.getUriForFile(
                            this@SelfInfoActivity,
                            authority,
                            facePic
                        )
                        takePictureLauncher.launch(uri)
                    } else {
                        val intent = Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        );
                        //参数一:对应的数据的URI 参数二:使用该函数表示要查找文件的MIME类型
                        intent.setDataAndType(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            "image/*"
                        );
                        albumLauncher.launch(intent)
                    }
                }
            })
        }
        mDialog!!.onShow()
    }

    private fun showSexDialog() {

        val sDialog = SexSelectDialog(this, sexType, object : ItemClickListener<Int> {
            @RequiresApi(Build.VERSION_CODES.R)
            override fun onItemClick(t: Int) {
                binding.txtSelfSex.text = sexs[t]
                mViewModel.reSex(t)
                appViewModel.sexUpdate.value = t
                sexType = t
            }
        })
        sDialog.onShow()
    }

    override fun createObserver() {

        lifecycleScope.launch {
            mViewModel.user.collect {

                this@SelfInfoActivity.user = it
//                if (!hasHeader) {
//                    user.headUrl?.let {
//                        loadCircleImage(this, it, binding.imgMineInfoHeader)
//                    }
//                }
                binding.txtMineInfoName.text = it.userName
                sexType = it.sex
                when (it.sex) {
                    0 -> binding.txtSelfSex.text = "男"
                    1 -> binding.txtSelfSex.text = "女"
                    else -> binding.txtSelfSex.text = "保密"
                }
                binding.txtMineInfoNum.text = "ID:${it.userCode.toString()}"
                it.signature?.let { sign->
                    binding.txtSelfSign.text = sign
                }
            }
        }
    }

    override fun firstOnResume() {
        super.firstOnResume()

        lifecycleScope.launch {
            val bitmap = getUserHeader(this@SelfInfoActivity)
            if (bitmap != null) {
                hasHeader = true
                loadCircleBitmap(this@SelfInfoActivity, bitmap, binding.imgMineInfoHeader)
            }
            mViewModel.getUser()
        }
    }

    /**
     * 原始图片5M-->直接压缩存储，哪怕quality=10，也有近200kb-->需要先压缩一下，然后再压缩保存，大小40-60kb
     * @param:
     * @author: dongyiming
     * @date: 11/9/22 3:45 AM
     * @version: v1.0
     */
    @RequiresApi(Build.VERSION_CODES.R)
    private fun trackFace() {
        lifecycleScope.launch(Dispatchers.Default) {
            val compressedBitmap = BitmapUtils.compressBitmap(tempCameraPicName, 400, 400)
            compressedBitmap?.let {
                //1,二次压缩存储
                BitmapUtils.saveCompressedBitmap(
                    it,
                    Bitmap.CompressFormat.WEBP_LOSSY,
                    tempCameraPicName
                )
                val finalBitmap = BitmapFactory.decodeFile(tempCameraPicName) ?: return@launch

                val faceDir =
                    FileUtils.getExternalFilePath(this@SelfInfoActivity, "face")
                val facePic = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")

                //画框后的bitmap又变大了，需要再次压缩并保存在本地
                //BitmapUtils.saveWebpBitmap(finalBitmap, facePic.absolutePath)

                runOnUiThread {
                    loadingPopup?.dismiss()
                    toastTopShow(this@SelfInfoActivity, "设置成功")
                    loadCircleBitmap(this@SelfInfoActivity, finalBitmap, binding.imgMineInfoHeader)
                    appViewModel.headerUpdate.value = true
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun trackPicture(uri: Uri) {
        lifecycleScope.launch(Dispatchers.Default) {
            FileUtils.getRealPathFromUri(this@SelfInfoActivity, uri)?.let { path ->
                val compressedBitmap = BitmapUtils.compressBitmap(path, 400, 400)
                compressedBitmap?.let {
                    val faceDir =
                        FileUtils.getExternalFilePath(this@SelfInfoActivity, "face")
                    val facePath = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg").absolutePath

                    //1,二次压缩存储
                    BitmapUtils.saveCompressedBitmap(
                        it,
                        Bitmap.CompressFormat.WEBP_LOSSY,
                        facePath
                    )
                    val finalBitmap = BitmapFactory.decodeFile(facePath) ?: return@launch

                    runOnUiThread {
                        loadingPopup?.dismiss()
                        toastTopShow(this@SelfInfoActivity, "设置成功")
                        loadCircleBitmap(
                            this@SelfInfoActivity,
                            finalBitmap,
                            binding.imgMineInfoHeader
                        )
                        appViewModel.headerUpdate.value = true
                    }
                }
            }
        }
    }

    private fun backFinish() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}