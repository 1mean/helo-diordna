package com.example.pandas.ui.activity

import android.Manifest
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.base.ui.activity.BaseActivity
import com.example.pandas.R
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.ActivityHomeBinding
import com.example.pandas.ui.adapter.HomeAdapter
import com.example.pandas.utils.StatusBarUtils


/**
 * @description: home-activity，项目总界面
 * @author: dongyiming
 * @date: 11/17/21 1:25 PM
 * @version: v1.0
 */
public class HomeActivity : BaseActivity<MainViewModel, ActivityHomeBinding>(),
    RadioGroup.OnCheckedChangeListener {

    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {

            val grantedList = it.filterValues { it }.mapNotNull { it.key } //通过的权限
            val isAllGranted = grantedList.size == it.size
            val list = (it - grantedList).map { it.key }//未通过的权限
            //拒绝的权限
            val deniedList =
                list.filter { ActivityCompat.shouldShowRequestPermissionRationale(this, it) }
            val alwaysDeniedList = list - deniedList
        }

    override fun initView(savedInstanceState: Bundle?) {

        //StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)

        binding.rgHome.apply {
            setOnCheckedChangeListener(this@HomeActivity)
            check(R.id.rb_name1)
        }

        binding.vpHome.apply {
            adapter = HomeAdapter(this@HomeActivity)
            offscreenPageLimit = 5
            setCurrentItem(0, false)
            isUserInputEnabled = false //禁止滑动
        }

        requestPermissions.launch(permissions)

        //downLoadVideoCovers(this,this)
    }

    override fun createObserver() {

        mViewModel.HeadUiState.observe(this) {
            binding.rgHome.check(R.id.rb_name4)
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        val selectColor = ContextCompat.getColor(this, R.color.color_groupbutton_text_selected)
        val color = ContextCompat.getColor(this, R.color.color_groupbutton_text)
        when (checkedId) {
            R.id.rb_name1 -> {
                binding.vpHome.setCurrentItem(0, false)
                binding.rbName1.setTextColor(selectColor)
                binding.rbName2.setTextColor(color)
                binding.rbName3.setTextColor(color)
                binding.rbName4.setTextColor(color)
            }
            R.id.rb_name2 -> {
                binding.vpHome.setCurrentItem(1, false)
                binding.rbName1.setTextColor(color)
                binding.rbName2.setTextColor(selectColor)
                binding.rbName3.setTextColor(color)
                binding.rbName4.setTextColor(color)
            }
            R.id.rb_name3 -> {
                binding.vpHome.setCurrentItem(2, false)
                binding.rbName1.setTextColor(color)
                binding.rbName2.setTextColor(color)
                binding.rbName3.setTextColor(selectColor)
                binding.rbName4.setTextColor(color)
            }
            R.id.rb_name4 -> {
                binding.vpHome.setCurrentItem(3, false)
                binding.rbName1.setTextColor(color)
                binding.rbName2.setTextColor(color)
                binding.rbName3.setTextColor(color)
                binding.rbName4.setTextColor(selectColor)
            }
        }
    }
}