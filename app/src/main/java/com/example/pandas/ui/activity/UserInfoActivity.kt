package com.example.pandas.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.viewmodel.UserInfoViewModel
import com.example.pandas.databinding.ActivityUserBinding
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.adapter.UserInfoPageAdapter
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 用户个人主页
 * @author: dongyiming
 * @date: 4/21/22 5:35 下午
 * @version: v1.0
 */
public class UserInfoActivity : BaseActivity<UserInfoViewModel, ActivityUserBinding>() {

    private var user: User? = null

    private val tabList = listOf<String>("投稿", "动态", "主页")

    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
        user = intent.getParcelableExtra<User>("user")

        user?.let {
            if (it.isVip == 1) {
                //binding.txtUserName.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
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
            var isAttention = mViewModel.isAttention(this, it.userCode)
            Log.e("1mean", "isAttention: $isAttention")
            if (isAttention) {
                binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                binding.clayoutUserAttention.visibility = View.GONE
                binding.clayoutUserUnattention.visibility = View.VISIBLE
            }

            binding.clayoutUserFollow.setOnClickListener { _ ->

                if (!isAttention) {
                    mViewModel.addAttention(this, it.userCode)
                    binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                    binding.clayoutUserAttention.visibility = View.GONE
                    binding.clayoutUserUnattention.visibility = View.VISIBLE
                    Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show()
                    isAttention = true
                } else {
                    bottomSheetDialog = BottomSheetDialog(this)
                    val dBinding = DialogAttentionCancelBinding.inflate(LayoutInflater.from(this))

                    dBinding.rlayoutAdd.setOnClickListener {
                        Toast.makeText(this, "加入特别关注", Toast.LENGTH_SHORT).show()
                        bottomSheetDialog.dismiss()
                    }
                    dBinding.rlayoutGroup.setOnClickListener {
                        Toast.makeText(this, "加入默认分组", Toast.LENGTH_SHORT).show()
                        bottomSheetDialog.dismiss()
                    }
                    dBinding.rlayoutCancel.setOnClickListener { _ ->
                        mViewModel.deleteAttention(this, it.userCode)
                        binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_attention)
                        binding.clayoutUserAttention.visibility = View.VISIBLE
                        binding.clayoutUserUnattention.visibility = View.GONE
                        Toast.makeText(this, "已取消关注", Toast.LENGTH_SHORT).show()
                        isAttention = false
                        bottomSheetDialog.dismiss()
                    }
                    dBinding.txtCancel.setOnClickListener {
                        bottomSheetDialog.dismiss()
                    }
                    bottomSheetDialog.setContentView(dBinding.root)
                    bottomSheetDialog.setCancelable(true)
                    bottomSheetDialog.setCanceledOnTouchOutside(true)
                    bottomSheetDialog.show()
                }
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

        //binding.tbUser.getTabAt(2)?.select()
    }

    override fun onResume() {
        super.onResume()
        user?.let {
            mViewModel.getUserVideos(it.userCode, true)
        }
    }

    override fun createObserver() {


    }

}