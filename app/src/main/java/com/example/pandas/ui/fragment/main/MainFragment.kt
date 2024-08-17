package com.example.pandas.ui.fragment.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.R
import com.example.pandas.app.appViewModel
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.MainFragmentViewModel
import com.example.pandas.databinding.FragmentMainBinding
import com.example.pandas.ui.activity.PublishActivity
import com.example.pandas.ui.adapter.HomeAdapter
import com.example.pandas.ui.ext.*


/**
 * @description: 首页fragment
 * @author: dongyiming
 * @date: 4/28/22 4:04 下午
 * @version: v1.0
 */
public class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    val tabTitles = arrayListOf("首页", "动态", "发布", "视频", "我的")

    private var curPosition = 0
    private var lastPosition = 0

    override fun initView(savedInstanceState: Bundle?) {

        val mAdapter = HomeAdapter(mActivity)
        binding.vpHome.apply {
            adapter = mAdapter
            offscreenPageLimit = 5
            //setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

//        binding.bnvMain.getOrCreateBadge(R.id.menu_news).run {
//            badgeGravity = BadgeDrawable.TOP_END
//            backgroundColor =
//                ContextCompat.getColor(mActivity, R.color.color_groupbutton_text_selected)
//            maxCharacterCount = 3 //101显示99+
//            number = 23
//            badgeTextColor = Color.WHITE
//            verticalOffset = 15
//        }

        binding.bnvMain.run {
            itemIconTintList = null //必须代码设置，点击后变化的图片才能显示
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> {
//                        if (curPosition == 0) {
//                            mViewModel.bottomState
//                        }
                        curPosition = 0
                        binding.vpHome.setCurrentItem(0, false)
                    }
                    R.id.menu_news -> {
                        curPosition = 1
                        binding.vpHome.setCurrentItem(1, false)
                        binding.bnvMain.getOrCreateBadge(R.id.menu_news).isVisible = false
                    }
                    R.id.menu_add -> {
                        curPosition = 2
                        startAnyActivity(mActivity, PublishActivity::class.java)
                        mActivity.overridePendingTransition(
                            R.anim.animate_short_comment_in,
                            R.anim.animate_activity_out
                        )
                    }
                    R.id.menu_more -> {
                        Log.e("1mean","点击了")
                        curPosition = 3
                        binding.vpHome.setCurrentItem(3, false)
                        //bug:在此处执行，而不是ShortFragment回调firstOnresume后再执行，这样第一次加载ShortFragment会有200ms的延时
                        //bottomStateObserver(1)
                        //bottomUpDate()
                    }
                    R.id.menu_mine -> {
                        curPosition = 4
                        binding.vpHome.setCurrentItem(4, false)
                    }
                }
                if (curPosition == lastPosition) {
                    Log.e("doubleCilik", "开始刷新了， lastPosition：$lastPosition")
                    mViewModel.updateRefreshPosition(curPosition)
                }
                lastPosition = curPosition
                true //true表示拦截，不跳转
            }
        }
        initBottom()
    }

    override fun createObserver() {

        appViewModel.appColorType.observe(this) { type ->
            appColorObserver(type)
        }

        mViewModel.bottomState.observe(viewLifecycleOwner) { status ->
            bottomStateObserver(status)
        }
    }

    override fun firstOnResume() {

    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }
}