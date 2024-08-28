package com.example.pandas.ui.activity

import AppInstance
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.example.pandas.biz.viewmodel.WanAndroidViewModel
import com.example.pandas.databinding.ActivityWanContentBinding
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.StatusBarUtils
import com.just.agentweb.AgentWeb
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient

/**
 * @description: WanAndroidActivity
 * @author: dongyiming
 * @date: 8/22/24 11:53 PM
 * @version: v1.0
 */
public class WanContentActivity : BaseActivity<WanAndroidViewModel, ActivityWanContentBinding>() {

    private var agentWeb: AgentWeb? = null
    private lateinit var shareUrl: String

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            appViewModel.appColorType.value?.let {
                binding.clayoutWanTop.setBackgroundResource(viewColors[it])
                if (it == 0) {
                    binding.ibnWanBack.setImageResource(R.mipmap.img_setting_top_back_black33)
                    binding.txtWanTitle.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.color_history_title
                        )
                    )
                    StatusBarUtils.setStatusBarMode(this, true, viewColors[it])
                } else {
                    binding.ibnWanBack.setImageResource(R.mipmap.img_setting_top_back_white)
                    binding.txtWanTitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                    StatusBarUtils.setStatusBarMode(this, false, viewColors[it])
                }
            }
        }

        binding.ibnWanBack.setOnClickListener {
            finish()
        }

        intent.extras?.let {
            shareUrl = it.getString("url", "")
            agentWeb = getAgentWeb(shareUrl)
        }
        binding.txtWanTitle.text = "加载中..."

    }

    private val webChromeClient = object : WebChromeClient() {
        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
            binding.txtWanTitle.text = title
        }
    }

    private fun getWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler,
                error: SslError?
            ) {
                handler.proceed()
            }
        }
    }

    private fun getAgentWeb(url: String): AgentWeb? {
        return AgentWeb.with(this)//传入Activity or Fragment
            .setAgentWebParent(
                binding.flayoutWebContent,
                LinearLayout.LayoutParams(-1, -1)
            )//传入AgentWeb 的父控件
            .useDefaultIndicator()// 使用默认进度条
            //.setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .setWebViewClient(getWebViewClient())
            .setWebChromeClient(webChromeClient)
            .createAgentWeb()//
            .ready()
            .go(url)
    }

    override fun createObserver() {
    }

    override fun onResume() {
        super.onResume()
        agentWeb?.webLifeCycle?.onResume()
    }

    override fun onPause() {
        super.onPause()
        agentWeb?.webLifeCycle?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        agentWeb?.webLifeCycle?.onDestroy()
    }
}