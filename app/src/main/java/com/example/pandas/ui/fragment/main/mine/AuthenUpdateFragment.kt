package com.example.pandas.ui.fragment.main.mine

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.android.base.vm.BaseViewModel
import com.example.pandas.databinding.FragmentAuthenUpdateBinding
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.shape_20_drawables
import com.example.pandas.ui.ext.toastTopShow
import com.example.pandas.ui.ext.viewColors
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @description: AuthenFragment
 * @author: dongyiming
 * @date: 10/8/23 11:12 PM
 * @version: v1.0
 */
public class AuthenUpdateFragment : BaseFragment<BaseViewModel, FragmentAuthenUpdateBinding>() {

    private var loadingPopup: LoadingPopupView? = null

    override fun initView(savedInstanceState: Bundle?) {

        val type = appViewModel.appColorType.value ?: 0
        val spanColor: Int
        if (type == 0) {
            spanColor = viewColors[APP_COLOR_STATUS]
            binding.txtAuthenSubmit.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
        } else {
            spanColor = viewColors[type]
            binding.txtAuthenSubmit.setBackgroundResource(shape_20_drawables[type])
        }
        val builder = SpannableStringBuilder()
        val builder2 = SpannableStringBuilder()
        val builder3 = SpannableStringBuilder()
        val builder4 = SpannableStringBuilder()
        builder.append("联系客服") // 添加普通文本
        builder2.append("为响应《国家新闻出版署关于防止未成年沉迷网络游戏的通知》，请认真填写您的身份信息。您提供的证件信息将受到严格保护，仅用于用户实名制认证，不会用作其他用途，请放心填写。前往了解更多信息>>") // 添加普通文本
        builder3.append("若您提交的真实身份信息未通过认证或者您持有的为港澳台或国外身份证件，可转交人工审核") // 添加普通文本
        builder4.append("特别说明：由于部分用户之前的实名信息不正确或认证失败，可能需要重新认证，请提交真实的信息进行认证即可。部分视频仅对成年用户进行开放") // 添加普通文本
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(mActivity, spanColor)),
            0,
            4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(mActivity, spanColor)),
            83,
            93,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder3.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(mActivity, spanColor)),
            37,
            41,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(mActivity, spanColor)),
            0,
            4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(UnderlineSpan(), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) // 下划线
        builder3.setSpan(UnderlineSpan(), 37, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) // 下划线
        binding.txtAuthenHuman.text = builder
        binding.txtAuthenUpdateInfo1.text = builder2
        binding.txtAuthenDesc.text = builder3
        binding.txtAuthenUpdateInfo2.text = builder4

        binding.txtAuthenSubmit.setOnClickListener {
            if (binding.editAuthenticationName.text.toString().isEmpty()) {
                toastTopShow(mActivity, "请输入姓名")
            } else if (binding.editAuthenticationCard.text.toString().length != 18) {
                toastTopShow(mActivity, "必须使用18位的身份证号码")
            } else {
                if (loadingPopup == null) {
                    loadingPopup = XPopup.Builder(mActivity).dismissOnBackPressed(true)
                        .isLightNavigationBar(true)
                        .isViewMode(false)
                        .asLoading(
                            null,
                            R.layout.dialog_submit,
                            LoadingPopupView.Style.ProgressBar
                        )
                    loadingPopup!!.show()
                } else {
                    loadingPopup!!.show()
                }

                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        Thread.sleep(1000)
                        withContext(Dispatchers.Main) {
                            loadingPopup!!.dismiss()
                            val fragment = AuthenFragment.newInstance(
                                binding.editAuthenticationName.text.toString(),
                                binding.editAuthenticationCard.text.toString()
                            )
                            //bug：多fragment点击穿透，在不希望出现点击穿透的Layout加上 android:clickable="true"
                            mActivity.supportFragmentManager.beginTransaction()
                                .setReorderingAllowed(true)
                                .add(R.id.flayout_authen, fragment, "")
                                .addToBackStack(null)
                                .commit()
                        }
                    }
                }
            }
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}