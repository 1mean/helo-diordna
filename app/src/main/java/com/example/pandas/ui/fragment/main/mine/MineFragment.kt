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
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.android.base.ui.fragment.BaseFragment
import com.android.base.utils.BitmapUtils
import com.android.base.utils.FileUtils
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.ext.getUserHeader
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCircleBitmap
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.biz.viewmodel.SelfViewModel
import com.example.pandas.databinding.FragmentSetting2Binding
import com.example.pandas.ui.activity.*
import com.example.pandas.ui.ext.startAnyActivity
import com.example.pandas.ui.ext.startToActivity
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.popuwindow.TimerDialogFragment
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.Preference
import com.example.pandas.utils.StatusBarUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import com.lxj.xpopup.util.XPopupUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
public class MineFragment : BaseFragment<SelfViewModel, FragmentSetting2Binding>() {

    private val tabTitles = arrayListOf("我的")
    private var headerDialog: HeaderDialog? = null
    private var tempCameraPicName: String = ""
    private val loginStatus: Boolean
        get() = AppInstance.instance.isLoginSuccess
    private var loadingPopup: LoadingPopupView? = null

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity

    override fun initView(savedInstanceState: Bundle?) {

        //loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        if (!loginStatus) {
            binding.groupMine.visibility = View.GONE
            binding.txtMineLogin.visibility = View.VISIBLE
        }

        binding.imgMineHeader.setOnClickListener {
            if (loginStatus) {
                showHeader()
            } else {
                startLogin()
            }
        }

        binding.clayoutKugouStyle1.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, HistoryActivity::class.java)
            } else {
                startLogin()
            }
        }
        binding.llayoutSetting.setOnClickListener {
            if (loginStatus) {
                startToActivity(mActivity, SettingActivity::class.java)
            } else {
                startLogin()
            }
        }
        binding.clayoutSettingTiming.setOnClickListener {

//            val dialog = TimingBottomSheetDialog(mActivity, object : ItemClickListener<Int> {
//                override fun onItemClick(t: Int) {
//
//                }
//            })
//            dialog.onShow()

//            val timerPop = TimerPopuWindow(mActivity)
//            timerPop.setBackDark().onShow(binding.clayoutSettingTiming)

            val timerDialog = TimerDialogFragment()
            timerDialog.show(mActivity.supportFragmentManager, "dialog")
        }
        binding.clayoutSelf.setOnClickListener {
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }
        binding.clayoutMineAttention.setOnClickListener {
            if (loginStatus) {
                val intent =
                    Intent(mActivity, FollowAndFansActivity::class.java).putExtra(
                        "FollowsOrFans",
                        0
                    )
                mActivity.startActivity(intent)
            } else {
                startLogin()
            }
        }
        binding.clayoutMineFans.setOnClickListener {
            if (loginStatus) {
                val intent =
                    Intent(mActivity, FollowAndFansActivity::class.java).putExtra(
                        "FollowsOrFans",
                        1
                    )
                mActivity.startActivity(intent)
            } else {
                startLogin()
            }
        }
        binding.txtMineName.setOnClickListener {
            startAnyActivity(mActivity, SelfInfoActivity::class.java)
        }

        binding.clayoutKugouStyle5.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, LaterActivity::class.java)
            } else {
                startLogin()
            }
        }

        binding.clayoutKugouStyle4.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, CollectActivity::class.java)
            } else {
                startLogin()
            }
        }
        binding.clayoutKugouStyle3.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, LoveActivity::class.java)
            } else {
                startLogin()
            }
        }

        binding.clayoutKugouStyle6.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, IntegralActivity::class.java)
            } else {
                startLogin()
            }
        }

        binding.llayoutSettingAbout.setOnClickListener {
            startAnyActivity(mActivity, AboutActivity::class.java)
        }

        binding.clayoutKugouStyle2.setOnClickListener {
            if (loginStatus) {
                startAnyActivity(mActivity, DownLoadActivity::class.java)
            } else {
                startLogin()
            }
        }

        binding.itemMineSearch.setOnClickListener {
            startAnyActivity(mActivity, NewSearchActivity::class.java)
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
                    AppInstance.instance.isNightMode = true
                } else {
                    DarkModeUtils.applyNightMode(mActivity)
                    StatusBarUtils.updataStatus(mActivity, true, true, R.color.color_white_lucency)
                    AppInstance.instance.isNightMode = false
                }
            } else {
                toastTopShow(mActivity, "当前不支持暗黑模式设置～")
            }
        }

        binding.llayoutSettingLoginout.setOnClickListener {
            XPopup.Builder(mActivity).asConfirm("退出登录", "退出账号很多功能将无法使用，确定退出吗？", "取消", "确定",
                {
                    if (loadingPopup == null) {
                        loadingPopup = XPopup.Builder(mActivity).dismissOnBackPressed(true)
                            .isLightNavigationBar(true)
                            .isViewMode(false)
                            .asLoading(
                                null,
                                R.layout.loading_loginout,
                                LoadingPopupView.Style.ProgressBar
                            )
                        loadingPopup!!.show()
                    } else {
                        loadingPopup!!.show()
                    }
                    mViewModel.logout()
                }, { Log.e("1mean", "取消") }, false, R.layout.dialog_login_out
            ).show()
        }

        binding.itemCharacter.setOnClickListener {
            startAnyActivity(mActivity, BackGroundActivity::class.java)
        }

        binding.txtMineLogin.setOnClickListener {
            startAnyActivity(mActivity, LoginActivity::class.java)
        }

        binding.llayoutMineAuthentication.setOnClickListener {
            startAnyActivity(mActivity, AuthenticationActivity::class.java)
        }

        binding.llayoutMineYounger.setOnClickListener {
            startAnyActivity(mActivity, YoungerActivity::class.java)
        }

        binding.llayoutMineSafe.setOnClickListener {
            startAnyActivity(mActivity, SafeActivity::class.java)
        }

        binding.llayoutMineChat.setOnClickListener {
            startAnyActivity(mActivity, GroupChatActivity::class.java)
        }

        if (!AppInstance.instance.isNightMode) {
            updateTop(appViewModel.appColorType.value)
        }

        if (AppInstance.instance.isLoginSuccess) {//成功登录了
            binding.groupMine.visibility = View.VISIBLE
            binding.txtMineLogin.visibility = View.GONE
            binding.llayoutSettingLoginout.visibility = View.VISIBLE
            loadViewData()
        } else {
            binding.groupMine.visibility = View.GONE
            binding.txtMineLogin.visibility = View.VISIBLE
            binding.imgMineHeader.setImageResource(R.mipmap.img_icon_panda)
            binding.llayoutSettingLoginout.visibility = View.GONE
        }
    }

    override fun createObserver() {

        appViewModel.loginStatus.observe(viewLifecycleOwner) {
            if (it > 0) {
                binding.groupMine.visibility = View.VISIBLE
                binding.txtMineLogin.visibility = View.GONE
                binding.llayoutSettingLoginout.visibility = View.VISIBLE
                loadViewData()
            }
        }

        mViewModel.userInfo.observe(viewLifecycleOwner) {
            binding.txtMineName.text = it.userName
            when (it.sex) {
                0 -> {
                    binding.imgMineSex.setImageResource(R.mipmap.img_mine_male)
                }
                1 -> {
                    binding.imgMineSex.setImageResource(R.mipmap.img_mine_female)
                }
            }
        }

        mViewModel.follows.observe(viewLifecycleOwner) {
            //binding.txtMineFollow.text = it.toString()

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

        lifecycleScope.launch {
            mViewModel.logout.collect {
                if (it.errorCode == 0) {//退出登录成功
                    binding.groupMine.visibility = View.GONE
                    binding.txtMineLogin.visibility = View.VISIBLE
                    binding.imgMineHeader.setImageResource(R.mipmap.img_icon_seadog)
                    binding.llayoutSettingLoginout.visibility = View.GONE
                    AppInstance.instance.isLoginSuccess = false
                    Preference.clear()
                    delay(1000)
                    loadingPopup?.dismiss()
                }
            }
        }
    }

    override fun firstOnResume() {
        loadViewData()
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

    private fun updateTop(status: Int?) {
        if (status == null || status == 0) {
            binding.layoutMineTop.setBackgroundResource(R.color.color_bg_home)
            binding.clayoutTopInfo.setBackgroundResource(R.color.color_bg_home)
            binding.txtMineName.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_mine_name
                )
            )
            binding.txtSelfZone.setTextColor(
                ContextCompat.getColor(
                    mActivity,
                    R.color.color_txt_tab
                )
            )
            //binding.imgUpdateDark.setImageResource(R.mipmap.img_dark_new_black)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_new_black)
            binding.imgUpdateSearch.setImageResource(R.mipmap.img_search_new_black)
        } else {
            binding.layoutMineTop.setBackgroundResource(viewColors[status])
            //binding.imgUpdateDark.setImageResource(R.mipmap.img_dark_new_white)
            binding.imgUpdateBackground.setImageResource(R.mipmap.img_clothes_new_white)
            binding.imgUpdateSearch.setImageResource(R.mipmap.img_search_new_white)
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
                        requireContext().packageName
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
                        requireContext().sendBroadcast(intent)
                    } else {
                        //android10以上，增加了新字段，自己insert，因为RELATIVE_PATH，DATE_EXPIRES，IS_PENDING是29新增字段
                        val contentValues = ContentValues()
                        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, destFile.name)
                        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/*")
                        val contentUri: Uri =
                            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                            } else {
                                MediaStore.Images.Media.INTERNAL_CONTENT_URI
                            }
                        contentValues.put(
                            MediaStore.Images.Media.RELATIVE_PATH,
                            Environment.DIRECTORY_DCIM + "/" + requireContext().packageName
                        )
                        contentValues.put(MediaStore.MediaColumns.IS_PENDING, 1)
                        val uri = requireContext().contentResolver.insert(contentUri, contentValues)
                        if (uri == null) {
                            withContext(Dispatchers.Main) {
                                headerDialog?.downLoadHeader(false)
                            }
                            return@launch
                        }
                        val resolver = requireContext().contentResolver
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

    private fun startLogin() {
        startAnyActivity(mActivity, LoginActivity::class.java)
    }

    private fun loadViewData() {
        if (loginStatus) {
            //mViewModel.getCurrentFollows(mActivity)
            mViewModel.getUserInfo()
            lifecycleScope.launch {
                val bitmap = getUserHeader(mActivity)
                if (bitmap == null) {
                    loadCenterImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
                } else {
                    loadCircleBitmap(mActivity, bitmap, binding.imgMineHeader)
                }
            }
        }
    }
}