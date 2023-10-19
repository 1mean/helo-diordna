package com.example.pandas.ui.activity

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.LoginInfo
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.ActivityLoginBinding
import com.example.pandas.ui.ext.toast
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.SPUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import java.util.*

/**
 * @description: 登录
 * @author: dongyiming
 * @date: 9/24/23 11:32 PM
 * @version: v1.0
 */
public class LoginActivity : BaseActivity<BaseViewModel, ActivityLoginBinding>() {

    private val WATTING_TIME = 60
    private var timer: Timer? = null
    private var r_time = WATTING_TIME
    private var taskRunning = false
    private var isSelected = false

    private var loadingPopup: LoadingPopupView? = null

    private val imgResource
        get() = arrayOf(
            R.mipmap.img_login_selected,
            R.mipmap.img_mine_unselected
        )

    override fun initView(savedInstanceState: Bundle?) {
        Log.e("1mean", "initView")
        binding.btnLoginClose.setOnClickListener {
            finish()
        }
        binding.btnLoginCode.setOnClickListener {

            if (!taskRunning) {
                val inputString = binding.editLoginPhone.text.toString()
                Log.e("1mean", "合法？= ${NumUtils.isMobileNo(inputString)}")
                if (inputString.isEmpty() || inputString.length != 11 || !NumUtils.isMobileNo(
                        inputString
                    )
                ) {
                    toast(this, "请输入正确的手机号")
                    return@setOnClickListener
                }
                toast(this, "验证短信码已发送，请注意查收短信")

                timer = Timer()
                timer!!.scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        taskRunning = true
                        r_time -= 1
                        Log.e("1mean", "r_time=$r_time")
                        if (r_time == 0) {
                            runOnUiThread {
                                binding.btnLoginCode.text = "重新获取"
                            }
                            r_time = WATTING_TIME
                            taskRunning = false
                            timer!!.cancel()//timer取消后再次 调用会报错 java.lang.IllegalStateException: Timer already cancelled.
                            timer = null
                        } else {
                            runOnUiThread {
                                binding.btnLoginCode.text = r_time.toString() + "s"
                            }
                        }
                    }
                }, 0, 1000)
            }
        }

        binding.clayoutLoginSelect.setOnClickListener {

            if (!isSelected) {
                binding.imgLoginSelect.setImageResource(imgResource[0])
            } else {
                binding.imgLoginSelect.setImageResource(imgResource[1])
            }
            isSelected = !isSelected
        }

        val builder = SpannableStringBuilder()
        builder.append("阅读并同意《用户协议》和《隐私政策》") // 添加普通文本
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_bg_grey)),
            5,
            11,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_bg_grey)),
            12,
            18,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        ) // 字体颜色
        builder.setSpan(UnderlineSpan(), 5, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) // 下划线
        builder.setSpan(UnderlineSpan(), 12, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) // 下划线
//        builder.setSpan(
//            URLSpan("https://www.baidu.com"),
//            5,
//            11,
//            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//        ) // 超链接
//        builder.setSpan(
//            URLSpan("https://www.baidu.com"),
//            12,
//            18,
//            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//        ) // 超链接
        binding.txtLoginDemand.text = builder

        binding.editLoginCode.addTextChangedListener(onTextChanged = { text: CharSequence?, start: Int, before: Int, count: Int ->
            Log.e("1mean", "text=$text,start=$start,before:$before,count=$count")
            text?.let { content ->
                val length = content.length
                if (length >= 6) {
                    binding.txtLogin.setBackgroundResource(R.drawable.shape_bg_login1)
                } else {
                    binding.txtLogin.setBackgroundResource(R.drawable.shape_bg_login2)
                }
            }
        })

        binding.txtLogin.setOnClickListener {
            if (isSelected) {
                if (binding.editLoginCode.text != null && binding.editLoginCode.text!!.length == 6) {
                    if (binding.editLoginPhone.text == null || binding.editLoginPhone.text.toString()
                            .isEmpty()
                    ) {
                        toastTopShow(this, "手机号不能为空")
                        return@setOnClickListener
                    }
                    val inputString = binding.editLoginPhone.text.toString()
                    if (inputString.isEmpty() || inputString.length != 11 || !NumUtils.isMobileNo(
                            inputString
                        )
                    ) {
                        toast(this, "请输入正确的手机号")
                        return@setOnClickListener
                    }
                    if (binding.editLoginCode.text.toString() == "123456") {
                        if (loadingPopup == null) {
                            loadingPopup = XPopup.Builder(this).dismissOnBackPressed(true)
                                .isLightNavigationBar(true)
                                .isViewMode(false)
                                .asLoading(
                                    null,
                                    R.layout.loading_login,
                                    LoadingPopupView.Style.ProgressBar
                                )
                            loadingPopup!!.show()
                        } else {
                            loadingPopup!!.show()
                        }
                        startLoginIn()
                    } else {
                        toastTopShow(this, "验证码错误，请重新获取")
                    }
                }
            } else {
                toastTopShow(this, "阅读并同意《用户协议》和《隐私政策》")
            }
        }
    }

    override fun createObserver() {
        Log.e("1mean", "createObserver")
    }

    private fun startLoginIn() {
        SPUtils.putInt(this, AppInfos.LOGIN_KEY, 1)
        LoginInfo.instance.setLoginStatus(1)
        appViewModel.loginStatus.value = 1
        timer?.cancel()
        timer = null
        loadingPopup?.dismiss()
        finish()
    }

}