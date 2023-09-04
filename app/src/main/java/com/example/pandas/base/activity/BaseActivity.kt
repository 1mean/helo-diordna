package com.example.pandas.base.activity

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
import com.example.pandas.utils.DarkModeUtils
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preInit()
        setContentView(initViewBinding())
        initViewModel()
        initStatusView()
        initView(savedInstanceState)
        createObserver()
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

    /**
     * 创建观察者
     */
    abstract fun createObserver()

}