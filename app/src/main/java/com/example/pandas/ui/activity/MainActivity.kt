package com.example.pandas.ui.activity

import AppInstance
import android.Manifest
import android.app.Service
import android.content.*
import android.graphics.Rect
import android.os.Bundle
import android.os.IBinder
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation.findNavController
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.vm.BaseViewModel
import com.example.pandas.biz.manager.PlayerManager
import com.example.pandas.databinding.ActivityMainBinding
import com.example.pandas.ui.broadcast.TimingBroadCast
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.service.MainService
import com.example.pandas.utils.StatusBarUtils

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    private val ALARM_EVENT = "com.example.pandas.ui.broadcast.TimingBroadCast"
    private var exitTime = 0L

    private var broadCast: TimingBroadCast? = null
    var mService: MainService? = null

    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.main_navigation).navigateUp()
    }

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {

            val grantedList = it.filterValues { it }.mapNotNull { it.key } //通过的权限
            val isAllGranted = grantedList.size == it.size
            val list = (it - grantedList).map { it.key }//未通过的权限
            //拒绝的权限
            val deniedList =
                list.filter { ActivityCompat.shouldShowRequestPermissionRationale(this, it) }
            val alwaysDeniedList = list - deniedList
        }

    override fun initView(savedInstanceState: Bundle?) {

        requestPermissions.launch(permissions)

        if (AppInstance.instance.isNightMode) {//夜间模式
            StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
        } else {
            //StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
            appViewModel.appColorType.value?.let {
                if (it == 0) {
                    StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
                } else {
                    StatusBarUtils.updataStatus(this, false, true, viewColors[it])
                }
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(ALARM_EVENT)
        broadCast = TimingBroadCast()
        registerReceiver(broadCast, intentFilter)

        val intent = Intent(this, MainService::class.java)
        bindService(intent, conn, Service.BIND_AUTO_CREATE)

        //appViewModel.downLoadVideoCovers(this,this)
        //appViewModel.downLoadUserCovers(this,this)
    }

    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {

            val binder = service as MainService.LocalBinder
            mService = binder.getService()

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mService = null
        }
    }

    override fun createObserver() {
        appViewModel.appColorType.observe(this) {
            if (it == 0) {
                StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
            } else {
                StatusBarUtils.updataStatus(this, false, true, viewColors[it])
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_UP) {
            val view = currentFocus //界面里只给editext设置focus，其他地方点击为null
            if (view != null && view is EditText) {
                val consumed = super.dispatchTouchEvent(ev)
                val viewTmp = currentFocus
                val viewNew = viewTmp ?: view
                if (viewNew == view) {
                    val parentView = view.parent as ConstraintLayout
                    if (parentView != null) {
                        val rect = Rect()
                        val coordinates = IntArray(2)
//                    view.getLocationOnScreen(coordinates)
                        parentView.getLocationOnScreen(coordinates)
                        rect.set(
                            0,
                            coordinates[1],
                            parentView.width,
                            coordinates[1] + parentView.height
                        )
                        val x = ev.x.toInt()
                        val y = ev.y.toInt()
                        if (rect.contains(x, y)) {
                            return consumed
                        }
                    } else if (viewNew is EditText) {
                        return consumed
                    }
                    val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    im.hideSoftInputFromWindow(viewNew.windowToken, 0)
                    viewNew.clearFocus()
                    return consumed
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                PlayerManager.instance.observeHomeSystemVoice()
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                PlayerManager.instance.observeHomeSystemVoice()
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadCast)
    }
}
