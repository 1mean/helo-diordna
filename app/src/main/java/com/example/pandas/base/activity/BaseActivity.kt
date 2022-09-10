package com.example.pandas.base.activity

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.pandas.base.viewmodel.BaseViewModel
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

        setContentView(initViewBinding())
        initViewModel()

        initView(savedInstanceState)
        createObserver()
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

    //BUG:软键盘弹出来后，点击返回不会回调onKeyDown和backpressed方法
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onkeyBack()
            return true
        } else {
            return super.onKeyDown(keyCode, event);
        }
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

    /**
     * 创建观察者
     */
    abstract fun createObserver()

}