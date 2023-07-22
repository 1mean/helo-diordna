package com.example.pandas.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.KeyboardUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.ActivityMineInfoBinding
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.fragment.main.mine.NameSettingFragment
import com.example.pandas.ui.fragment.main.mine.SexSettingFragment
import com.example.pandas.ui.view.dialog.FaceAddSheetDialog
import com.example.pandas.utils.BitmapUtils
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.*
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

    private val mHandler = Handler(Looper.getMainLooper())

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

    override fun initView(savedInstanceState: Bundle?) {

        binding.btnSelfBack.setOnClickListener {
            backFinish()
        }
        appViewModel.appColorType.value?.let {
            binding.clayoutInfoTop.setBackgroundResource(AppInfos.bgColors[it])
            if (it == 0) {
                binding.btnSelfBack.setImageResource(R.mipmap.img_top_leave)
                binding.txtSelfInfo.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_txt_mylove_self
                    )
                )
            } else {
                binding.btnSelfBack.setImageResource(R.mipmap.img_top_leave_white)
                binding.txtSelfInfo.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                StatusBarUtils.setStatusBarMode(this, false, AppInfos.bgColors[it])
            }
        }

        binding.clayoutInfoHead.setOnClickListener {
            showDialog()
        }

        binding.clayoutInfoName.setOnClickListener {
            type = 1
            turnToFragment("修改昵称")
        }

        binding.clayoutInfoSex.setOnClickListener {
            type = 2
            turnToFragment("修改性别")
        }

//        binding.txtMineTopSave.setOnClickListener {
//            Log.e("1mean", "type: $type")
//            when (type) {
//                1 -> mViewModel.updateName.value = true
//                2 -> mViewModel.updateSex.value = true
//            }
//        }
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
                if (!hasHeader) {
                    user.headUrl?.let {
                        loadCircleImage(this, it, binding.imgMineInfoHeader)
                    }
                }
                user.userName?.let {
                    binding.txtMineInfoName.text = it
                }
                when (user.sex) {
                    0 -> binding.txtMineInfoSex.text = "男"
                    1 -> binding.txtMineInfoSex.text = "女"
                    else -> binding.txtMineInfoSex.text = "保密"
                }
                binding.txtMineInfoNum.text = user.userCode.toString()
                user.signature?.let {
                    binding.txtMineInfoSign.text = it
                }
            }
        }

        mViewModel.closeFragment.observe(this) {
            Log.e("1mean", "closeFragment observe")
            val fragment = supportFragmentManager.findFragmentByTag(TAG_INFO)
            if (fragment != null) {
                supportFragmentManager.popBackStack()
                binding.txtSelfInfo.post {
                    binding.txtSelfInfo.text = "个人信息"
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

    private fun turnToFragment(name: String) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(TAG_INFO)
        if (fragment == null) {
            val newFragment = when (name) {
                "修改昵称" -> NameSettingFragment()
                "修改性别" -> SexSettingFragment()
                else -> {
                    SexSettingFragment()
                }
            }
            transaction.add(R.id.flayout_mine_info, newFragment, TAG_INFO)
                .addToBackStack(null).commit()
        }
        binding.txtSelfInfo.post {
            binding.txtSelfInfo.text = name
        }
    }

    private fun backFinish() {
        val fragment = supportFragmentManager.findFragmentByTag(TAG_INFO)
        if (fragment == null) {
            finish()
        } else {
            if (fragment is NameSettingFragment) {
                (fragment as NameSettingFragment).hideSoft()
            }
            //bug:关闭fragment的操作只能在activity里执行，在fragment里执行后下次无法再次点击进入fragment
            supportFragmentManager.popBackStack()
            binding.txtSelfInfo.post {
                binding.txtSelfInfo.text = "个人信息"
            }
        }
    }
}