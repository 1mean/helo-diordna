package com.example.pandas.ui.fragment.main.mine

import AppInstance
import HeaderDialog
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentSettingBinding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startToActivity
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.view.dialog.TimingBottomSheetDialog
import com.example.pandas.utils.BitmapUtils
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.FileUtils
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.util.XPopupUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * @description: 我的-设置
 * @author: dongyiming
 * @date: 7/12/22 3:34 下午
 * @version: v1.0
 */
public class MineFragment : BaseFragment<SelfViewModel, FragmentSettingBinding>() {

    private var headerDialog: HeaderDialog? = null
    private var tempCameraPicName: String = ""
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        //loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)

        binding.imgMineHeader.setOnClickListener { showHeader() }

        binding.cardMineHistory.setOnClickListener {
            startAnyActivity(mActivity, HistoryActivity::class.java)
        }
        binding.clayoutSetting.setOnClickListener {
            startToActivity(mActivity, SettingActivity::class.java)
        }
        binding.clayoutSettingTiming.setOnClickListener {

            val dialog = TimingBottomSheetDialog(mActivity, object : ItemClickListener<Int> {
                override fun onItemClick(t: Int) {

                }
            })
            dialog.onShow()
        }
        binding.clayoutSelf.setOnClickListener {
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }
        binding.clayoutMineFollow.setOnClickListener {
            val intent =
                Intent(mActivity, FollowAndFansActivity::class.java).putExtra("FollowsOrFans", 0)
            mActivity.startActivity(intent)
        }
        binding.clayoutMineFans.setOnClickListener {
            val intent =
                Intent(mActivity, FollowAndFansActivity::class.java).putExtra("FollowsOrFans", 1)
            mActivity.startActivity(intent)
        }
        binding.txtMineName.setOnClickListener {
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }

        binding.cardMineLater.setOnClickListener {
            startAnyActivity(mActivity, LaterActivity::class.java)
        }

        binding.cardMineCollect.setOnClickListener {
            startAnyActivity(mActivity, CollectActivity::class.java)
        }
        binding.clayoutSettingLove.setOnClickListener {
            startAnyActivity(mActivity, LoveActivity::class.java)
        }

        binding.llayoutMineExp.setOnClickListener {
            startAnyActivity(mActivity, IntegralActivity::class.java)
        }

        binding.clayoutSettingAbout.setOnClickListener {
            startAnyActivity(mActivity, AboutActivity::class.java)
        }

        binding.cardMineDownload.setOnClickListener {
            startAnyActivity(mActivity, DownLoadActivity::class.java)
        }

        //1。主题不一致，会导致MainActivity刷新重建，即会主动调用recreate方法
        //2。如果不想要重建，可在activity中设置android:configChanges="uiMode"，使模式的改变对其无效
        //3。在MainActivity的onConfigurationChanged方法里，自己处理界面的改变
        binding.itemModeDark.setOnClickListener {
            val status = appViewModel.appColorType.value
            if (status == null || status == 0) {
                val nightMode = DarkModeUtils.getNightModel(mActivity)
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {//夜间模式
                    DarkModeUtils.applyDayMode(mActivity)
                    StatusBarUtils.updataStatus(mActivity, false, true, R.color.color_white_lucency)
                    AppInstance.isNightMode = true
                } else {
                    DarkModeUtils.applyNightMode(mActivity)
                    StatusBarUtils.updataStatus(mActivity, true, true, R.color.color_white_lucency)
                    AppInstance.isNightMode = false
                }
            } else {
                toastTopShow(mActivity, "当前不支持暗黑模式设置～")
            }
        }

        binding.itemCharacter.setOnClickListener {
            startAnyActivity(mActivity, BackGroundActivity::class.java)
        }

        appViewModel.appColorType.value?.let {
            updateTop(it)
        }
    }

    override fun createObserver() {

        mViewModel.follows.observe(viewLifecycleOwner) {
            binding.txtMineFollow.text = it.toString()
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
        }

        appViewModel.appColorType.observe(viewLifecycleOwner) {
            updateTop(it)
        }

        appViewModel.headerUpdate.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    val bitmap = getUserHeader(mActivity)
                    if (bitmap != null) {
                        loadCircleBitmap(mActivity, bitmap, binding.imgMineHeader)
                    }
                }
            }
        }
        appViewModel.nameUpdate.observe(this) {
            binding.txtMineName.post {
                binding.txtMineName.text = it
            }
        }

        appViewModel.sexUpdate.observe(this) {
            when (it) {
                0 -> {
                    binding.imgMineSex.setImageResource(R.mipmap.img_mine_male)
                }
                1 -> {
                    binding.imgMineSex.setImageResource(R.mipmap.img_mine_female)
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getCurrentFollows(mActivity)

        lifecycleScope.launch {
            val bitmap = getUserHeader(mActivity)
            if (bitmap == null) {
                loadCenterImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
            } else {
                loadCircleBitmap(mActivity, bitmap, binding.imgMineHeader)
            }
        }
    }

    private val albumLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                it.data?.let { intent ->
                    intent.data?.let { uri ->
                        headerDialog?.loadingShow()
                        trackPicture(uri)
                    }
                }
            }
        }

    private val takePictureLauncher =
        //TakePicturePreview()返回bitmap预览图，是缩略图，比较模糊
        registerForActivityResult(ActivityResultContracts.TakePicture()) { result ->
            if (result) {
                headerDialog?.loadingShow()
                trackFace()
            }
        }

    private fun showHeader() {
        headerDialog = HeaderDialog(mActivity, lifecycleScope, object : ItemClickListener<Int> {
            override fun onItemClick(t: Int) {
                if (t == 0) {
                    val faceDir =
                        FileUtils.getExternalFilePath(mActivity, "face")
                    if (faceDir.isEmpty()) {
                        return
                    }
                    val facePic = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")
                    tempCameraPicName = facePic.absolutePath

                    val authority = "${mActivity.applicationContext.packageName}.fileProvider"
                    val uri = FileProvider.getUriForFile(
                        mActivity,
                        authority,
                        facePic
                    )
                    takePictureLauncher.launch(uri)
                } else if (t == 1) {
                    val intent = Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    );
                    //参数一:对应的数据的URI 参数二:使用该函数表示要查找文件的MIME类型
                    intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*"
                    )
                    albumLauncher.launch(intent)
                } else {
                    saveInAlbum()
                }
            }
        })
        headerDialog!!.isClippingEnabled = false
        headerDialog!!.onShow(binding.imgMineHeader)
    }

    private fun trackPicture(uri: Uri) {
        lifecycleScope.launch(Dispatchers.Default) {
            FileUtils.getRealPathFromUri(mActivity, uri)?.let { path ->
                val compressedBitmap = BitmapUtils.compressBitmap(path, 400, 400)
                compressedBitmap?.let {
                    val faceDir =
                        FileUtils.getExternalFilePath(mActivity, "face")
                    val facePath = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg").absolutePath

                    //1,二次压缩存储
                    BitmapUtils.saveCompressedBitmap(
                        it,
                        Bitmap.CompressFormat.WEBP_LOSSY,
                        facePath
                    )
                    val finalBitmap = BitmapFactory.decodeFile(facePath) ?: return@launch

                    mHandler.post {
                        headerDialog?.setHeader(finalBitmap)
                        appViewModel.headerUpdate.value = true
                    }
                }
            }
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

                mHandler.post {
                    headerDialog?.setHeader(finalBitmap)
                    appViewModel.headerUpdate.value = true
                }
            }
        }
    }

    private fun updateTop(status: Int) {
        if (status == 0) {
            binding.layoutMineTop.setBackgroundResource(R.color.color_bg_self)
            binding.clayoutTopInfo.setBackgroundResource(R.color.color_bg_self)
            binding.txtMineName.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_mine_name
                )
            )
            binding.txtCoins.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_tab))
            binding.txtSelfZone.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_tab
                )
            )
            binding.txtFan.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_tab))
            binding.txtAttention.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_tab
                )
            )
            binding.txtZone.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_tab))
            binding.txtMineZone.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_fans_self
                )
            )
            binding.txtMineFollow.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_fans_self
                )
            )
            binding.txtMineFans.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_fans_self
                )
            )
            binding.imgZoneTo.setImageResource(R.mipmap.img_setting_top_arror)


            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_gray)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_gray)
        } else {
            binding.layoutMineTop.setBackgroundResource(AppInfos.bgColors[status])
            binding.clayoutTopInfo.setBackgroundResource(AppInfos.bgColors[status])
            binding.txtMineName.setTextColor(ContextCompat.getColor(mActivity, R.color.white))
            binding.txtCoins.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_top))
            binding.txtSelfZone.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_top
                )
            )
            binding.txtFan.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_top))
            binding.txtAttention.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_top
                )
            )
            binding.txtZone.setTextColor(ContextCompat.getColor(mActivity, R.color.color_txt_top))
            binding.txtMineZone.setTextColor(ContextCompat.getColor(mActivity, R.color.white))
            binding.txtMineFollow.setTextColor(ContextCompat.getColor(mActivity, R.color.white))
            binding.txtMineFans.setTextColor(ContextCompat.getColor(mActivity, R.color.white))
            binding.imgZoneTo.setImageResource(R.mipmap.img_setting_top_arror_white)


            binding.imgUpdateDark.setImageResource(R.mipmap.img_mine_dark_white)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_white)
        }
    }

    private fun saveInAlbum() {
        lifecycleScope.launch(Dispatchers.Default) {

            withContext(Dispatchers.Default) {
                headerDialog?.loadingShow()
            }
            val faceDir = FileUtils.getExternalFilePath(mActivity, "face")
            val faceFile = File(faceDir, "${AppInfos.HEAD_AUTHOR}.jpg")
            if (faceFile.exists()) {
                BitmapFactory.decodeFile(faceFile.absolutePath)

                try {
                    val dir = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
                        context!!.packageName
                    )
                    if (!dir.exists()) dir.mkdirs()
                    val destFile = File(
                        dir,
                        System.currentTimeMillis().toString() + "." + XPopupUtils.getImageType(
                            faceFile
                        )
                    )
                    if (Build.VERSION.SDK_INT < 29) {
                        if (destFile.exists()) destFile.delete()
                        destFile.createNewFile()
                        FileOutputStream(destFile).use { out ->
                            FileUtils.writeFileFromIS(
                                out,
                                FileInputStream(faceFile)
                            )
                        }
                        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                        intent.data = Uri.parse("file://" + destFile.absolutePath)
                        context!!.sendBroadcast(intent)
                    } else {
                        //android10以上，增加了新字段，自己insert，因为RELATIVE_PATH，DATE_EXPIRES，IS_PENDING是29新增字段
                        val contentValues = ContentValues()
                        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, destFile.name)
                        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/*")
                        val contentUri: Uri
                        contentUri =
                            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                            } else {
                                MediaStore.Images.Media.INTERNAL_CONTENT_URI
                            }
                        contentValues.put(
                            MediaStore.Images.Media.RELATIVE_PATH,
                            Environment.DIRECTORY_DCIM + "/" + context!!.packageName
                        )
                        contentValues.put(MediaStore.MediaColumns.IS_PENDING, 1)
                        val uri = context!!.contentResolver.insert(contentUri, contentValues)
                        if (uri == null) {
                            withContext(Dispatchers.Main) {
                                headerDialog?.downLoadHeader(false)
                            }
                            return@launch
                        }
                        val resolver = context!!.contentResolver
                        resolver.openOutputStream(uri)?.let { out ->
                            FileUtils.writeFileFromIS(
                                out,
                                FileInputStream(faceFile)
                            )
                        }
                        contentValues.clear()
                        contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
                        resolver.update(uri, contentValues, null, null)
                    }
                    withContext(Dispatchers.Main) {
                        headerDialog?.downLoadHeader(true)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    withContext(Dispatchers.Main) {
                        headerDialog?.downLoadHeader(false)
                    }
                }
            }
        }
    }
}