package com.example.pandas.ui.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentWebBinding
import com.just.agentweb.AgentWeb

class WebActivity : BaseActivity<BaseViewModel, FragmentWebBinding>() {

    private var mAgentWeb: AgentWeb? = null
    private var preWeb: AgentWeb.PreAgentWeb? = null

    override fun initView(savedInstanceState: Bundle?) {
        preWeb = AgentWeb.with(this)
            .setAgentWebParent(binding.llayoutWeb, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()

        binding.btnWebRefresh.setOnClickListener {
            mAgentWeb?.urlLoader?.reload()
        }

        //用浏览器打开
        //startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mViewModel.url)))
    }

    override fun firstOnResume() {

        //加载网页
        mAgentWeb = preWeb?.go("https://github.com/1mean/helo-diordna")
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    mAgentWeb?.let { web ->
                        if (web.webCreator.webView.canGoBack()) {
                            web.webCreator.webView.goBack()
                        }
                    }
                }
            })
    }

    override fun createObserver() {
    }

    override fun onPause() {
        mAgentWeb?.webLifeCycle?.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb?.webLifeCycle?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb?.webLifeCycle?.onDestroy()
        super.onDestroy()
    }
}