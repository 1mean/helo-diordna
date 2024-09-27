package com.android.base.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import com.android.base.vm.BaseViewModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

/**
 * @description: BaseFragment
 * @author: dongyiming
 * @date: 2/8/22 9:31 下午
 * @version: v1.0
 */
public abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    lateinit var mViewModel: VM

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    lateinit var mActivity: AppCompatActivity

    private var toast: Toast? = null

    private var isFirstShow: Boolean = true//第一次加载

    val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    /**
     *  获取到泛型对象，用反射来执行其inflate方法
     *    - getClass：获取该类的类类型(BaseFragment子类的类型)
     *    - getGenericSuperclass()：获得该类带有泛型的父类(在子类中确定的BaseFragment的类型)
     *    - Type是 Java中所有类型的公共高级接口。包括原始类型、参数化类型、数组类型、类型变量和基本类型
     *    - ParameterizedType参数化类型，即泛型
     *    - getActualTypeArguments获取参数化类型的数组，泛型可能有多个
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            val superclass = javaClass.genericSuperclass
            //获得父类的泛型参数的实际类型
            val aClass = (superclass as ParameterizedType).actualTypeArguments[1] as Class<VB>
            //获取inflate方法 传入相应的参数
            val method = aClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
            //执行inflate方法
            _binding = method.invoke(null, layoutInflater, container, false) as VB
        } catch (e: NoSuchMethodException) {
        } catch (e: IllegalAccessException) {
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isFirstShow = true

        val superclass = javaClass.genericSuperclass
        val aClass = (superclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel = ViewModelProvider(getCurrentLifeOwner())[aClass]
        initView(savedInstanceState)
        createObserver()
        clickFunction()
    }

    override fun onResume() {
        super.onResume()

        if (isFirstShow) {
            onVisible()
        } else {
            againOnResume()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mHandler.removeCallbacksAndMessages(null)
        _binding = null
    }

    /**
     * 懒加载
     */
    private fun onVisible() {

        if (lifecycle.currentState == Lifecycle.State.STARTED) {

            // 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿
            mHandler.postDelayed({
                firstOnResume()
                isFirstShow = false
            }, lazyLoadTime())
        }
    }

    /**
     * 保证同一按钮在1秒内只响应一次点击事件
     */
    abstract class onSingleClickListener : View.OnClickListener {

        //两次点击按钮的最小间隔，目前为1000
        private val MIN_CLICK_DELAY_TIME = 1000
        private var lastClickTime: Long = 0

        abstract fun onSingleClick(view: View)

        override fun onClick(v: View) {
            val curClickTime = System.currentTimeMillis()
            if (curClickTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {
                lastClickTime = curClickTime
                onSingleClick(v)
            }
        }
    }

    /**
     * 显示提示  toast
     *
     * @param msg 提示信息
     */
    @SuppressLint("ShowToast")
    open fun showToast(msg: String?) {
        try {
            if (null == toast) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            } else {
                toast!!.setText(msg)
            }
            toast?.show()
        } catch (e: Exception) {
            e.printStackTrace()
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare()
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            Looper.loop()
        }
    }

    /**
     * 初始化view
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 创建观察者
     */
    abstract fun createObserver()

    /**
     * 第一次展示界面
     */
    abstract fun firstOnResume()

    /**
     * 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿  bug
     * 这里传入你想要延迟的时间，延迟时间可以设置比转场动画时间长一点 单位： 毫秒
     * 不传默认 300毫秒
     * @return Long
     */
    open fun lazyLoadTime(): Long {
        return 300
    }

    /**
     * 数据共享时使用,通过Activity这个媒介来共享数据，返回mActivity
     */
    open fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return this
    }

    open fun againOnResume() {}

    open fun refresh() {}
    open fun clickFunction() {}

    //要习惯这种书写风格，获取关键字
    fun TextView.textWatcherFlow(): Flow<String> = callbackFlow {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                trySend(s.toString())
                //offer(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        addTextChangedListener(textWatcher)
        awaitClose { removeTextChangedListener(textWatcher) }
    }

}