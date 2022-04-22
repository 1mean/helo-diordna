package com.example.pandas.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.ActivityUserBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.adapter.UserInfoPageAdapter
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 用户个人主页
 * @author: dongyiming
 * @date: 4/21/22 5:35 下午
 * @version: v1.0
 */
public class UserInfoActivity : BaseActivity<UserInfoViewModel, ActivityUserBinding>() {

    private var user: User? = null

    private val tabList = listOf<String>("主页", "动态", "投稿")

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
        user = intent.getParcelableExtra<User>("user")

        user?.let {
            if (it.isVip == 1) {
                binding.txtUserName.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                binding.txtUserName.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_name_txt
                    )
                )
            }
            setLevelImageResourse(it.level, binding.imgUserLevel)
            binding.txtUserName.text = it.userName
            binding.txtUserDesc.text = it.signature
            it.headUrl?.let {
                loadImage(this, it, binding.imgUserHeader)
            }
        }

        binding.vpUser.run {
            offscreenPageLimit = tabList.size
            adapter = UserInfoPageAdapter(this@UserInfoActivity)
        }


        TabLayoutMediator(
            binding.tbUser, binding.vpUser, true
        ) { tab, position ->
            tab.text = tabList[position]
        }.attach()

        binding.tbUser.getTabAt(2)?.select()
    }

    override fun onResume() {
        super.onResume()
        user?.let {
            it.userName?.let {
                mViewModel.getUserVideos(it, true)
            }
        }
    }

    override fun createObserver() {


    }

}