package com.example.pandas.base.activity

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.pandas.R
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.ui.ext.toast
import com.example.pandas.utils.DarkModeUtils
import com.example.pandas.utils.NetWorkUtils
import com.example.pandas.utils.StatusBarUtils
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**
 * @description: BaseActivity
 * @author: dongyiming
 * @date: 2/11/22 4:08 下午
 * @version: v1.0
 */
public abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    lateinit var mViewModel: VM

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    private var isFirstVisible = false
    private var netWorkFlag = false
    private var networkService: ConnectivityManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preInit()
        setContentView(initViewBinding())

        initViewModel()
        initStatusView()
        initView(savedInstanceState)
        createObserver()

        if (netWorkFlag) {
            networkService = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            networkService?.registerDefaultNetworkCallback(networkCallback)
        }
    }

    /**
     * <设置白天和黑夜模式，如果想自己控制，自己继承方法定制>
     * @author: dongyiming
     * @date: 5/25/23 6:15 PM
     * @version: v1.0
     */
    open fun initStatusView() {
        val nightMode = DarkModeUtils.getNightModel(this)
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {//夜间模式
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            StatusBarUtils.setStatusBarMode(this, true, R.color.white)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isFirstVisible) {
            firstOnResume()
            isFirstVisible = true
        } else {
            againOnResume()
        }
    }

    private fun initViewBinding(): View {

        try {
            val superclass = javaClass.genericSuperclass
            //获得父类的泛型参数的实际类型
            val aClass = (superclass as ParameterizedType).actualTypeArguments[1] as Class<VB>
            //获取inflate方法 传入相应的参数
            val method = aClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java
            )
            //执行inflate方法
            _binding = method.invoke(null, layoutInflater) as VB
        } catch (e: NoSuchMethodException) {
        } catch (e: IllegalAccessException) {
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return binding.root
    }

    //bug:软键盘弹出来后，点击返回不会回调onKeyDown()和onBackPressed()方法
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onkeyBack()
            return true
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun initViewModel() {
        val superclass = javaClass.genericSuperclass
        val aClass = (superclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel = ViewModelProvider(this)[aClass]
    }

    /**
     * 初始化view
     */
    abstract fun initView(savedInstanceState: Bundle?)

    open fun onkeyBack() {
        finish()
    }

    open fun firstOnResume() {}

    open fun againOnResume() {}

    open fun preInit() {}

    open fun netLost() {}

    open fun netAvailable() {}

    /**
     * 创建观察者
     */
    abstract fun createObserver()

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        //当网络状态修改，但仍是可用状态时调用
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            if (NetWorkUtils.isConnectedAvailableNetwork(this@BaseActivity)) {
                Log.e(
                    "1mean",
                    "onCapabilitiesChanged===网络可正常上网，网络类型为==${
                        NetWorkUtils.getConnectedNetworkType(this@BaseActivity)
                    }"
                )
            }

            //表明此网络连接验证成功
            if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.e("1mean", "===当前在使用Mobile流量上网===");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.e("1mean", "====当前在使用WiFi上网===");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)) {
                    Log.e("1mean", "=====当前使用蓝牙上网=====");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.e("1mean", "=====当前使用以太网上网=====");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    Log.e("1mean", "===当前使用VPN上网====");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI_AWARE)) {
                    Log.e("1mean", "===表示此网络使用Wi-Fi感知传输====");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_LOWPAN)) {
                    Log.e("1mean", "=====表示此网络使用LoWPAN传输=====");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_USB)) {
                    Log.e("1mean", "=====表示此网络使用USB传输=====");
                }
            }
        }

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            toast(this@BaseActivity, "===网络连接成功，通知可以使用时调用====onAvailable=====")
            Log.e("1mean", "===网络连接成功，通知可以使用时调用====onAvailable=====")
            netAvailable()
        }

        override fun onUnavailable() {
            super.onUnavailable()
            Log.e("1mean", "===网络连接超时/网络要求达不到可用====onUnavailable=====")
        }

        override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
            super.onBlockedStatusChanged(network, blocked)
            Log.e("1mean", "===访问指定的网络被阻止或解除阻塞====onBlockedStatusChanged=====")
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            super.onLosing(network, maxMsToLive)
            toast(this@BaseActivity, "===网络正在断开连接====onLosing=====")
            Log.e("1mean", "===网络正在断开连接====onLosing=====")
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            toast(this@BaseActivity, "===网络已断开连接====onLost=====")
            Log.e("1mean", "===网络已断开连接====onLost=====")
            netLost()
        }

        override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties)
            Log.e("1mean", "===网络连接属性被修改====onLinkPropertiesChanged=====")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkService?.unregisterNetworkCallback(networkCallback)
    }
}