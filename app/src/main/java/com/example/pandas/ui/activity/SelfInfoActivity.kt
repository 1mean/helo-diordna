package com.example.pandas.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.lifecycle.LifecycleHandler
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.view.dialog.FaceAddSheetDialog
import com.example.pandas.utils.BitmapUtils
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
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
    private var loadingPopup: LoadingPopupView? = null
    private var tempCameraPicName: String = ""
    private var hasHeader: Boolean = false
    val TAG_INFO = "fragment_mine_info"
    private var type: Int = -1
    private var user: User? = null
    private val sexs
        get() = mapOf<Int, String>(0 to "女", 1 to "男", 2 to "保密")

    private val mHandler = LifecycleHandler(Looper.getMainLooper(),this)

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
                        user?.let { u->
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
                        user?.let { u->
                            u.signature = it
                        }
                        binding.txtSelfSign.text = it
                    }
                }
            }
        }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_activity_setting)

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
                intent.putExtra("userCode", it.userCode)
                reNameLauncher.launch(intent)
            }
        }

        binding.clayoutInfoSex.setOnClickListener {

            val sex = binding.txtSelfSex.text.toString()
            var checkedPosition = 0
            if (sex.isEmpty()) {
                checkedPosition = 0
            } else {
                sexs.entries.forEach {
                    if (it.value == sex) {
                        checkedPosition = it.key
                    }
                }
            }
            XPopup.Builder(this)
                .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                .asBottomList(
                    "性别",
                    arrayOf("女", "男", "保密"),
                    null,
                    checkedPosition
                ) { position, text ->
                    binding.txtSelfSex.text = text
                    user?.let {
                        val sex1 = when (text) {
                            "女" -> 1
                            "男" -> 0
                            else -> -1
                        }
                        mViewModel.reSex(sex1, it.userCode)
                        appViewModel.sexUpdate.value = sex1
                    }
                }
                .show()
        }

        binding.clayoutInfoSign.setOnClickListener {
            user?.let {
                val intent = Intent(this, SignActivity::class.java)
                intent.putExtra("sign", it.signature)
                intent.putExtra("userCode", it.userCode)
                reSignLauncher.launch(intent)
            }
        }
    }

    override fun onkeyBack() {
        backFinish()
    }

    private fun showDialog() {

        if (mDialog == null) {
            mDialog = FaceAddSheetDialog(this, object : ItemClickListener<Int> {
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

    override fun createObserver() {

        mViewModel.userInfo.observe(this) {

            it?.let { user ->

                this.user = user

                if (!hasHeader) {
                    user.headUrl?.let {
                        loadCircleImage(this, it, binding.imgMineInfoHeader)
                    }
                }
                user.userName?.let {
                    binding.txtMineInfoName.text = it
                }
                when (user.sex) {
                    0 -> binding.txtSelfSex.text = "男"
                    1 -> binding.txtSelfSex.text = "女"
                    else -> binding.txtSelfSex.text = "保密"
                }
                binding.txtMineInfoNum.text = "ID:${user.userCode.toString()}"
                user.signature?.let {
                    binding.txtSelfSign.text = it
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
            mViewModel.getUserInfo()
        }
    }

    /**
     * 原始图片5M-->直接压缩存储，哪怕quality=10，也有近200kb-->需要先压缩一下，然后再压缩保存，大小40-60kb
     * @param:
     * @author: dongyiming
     * @date: 11/9/22 3:45 AM
     * @version: v1.0
     */
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