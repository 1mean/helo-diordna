package com.example.pandas.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.helo_base.magic.commonnavigator.titles.ColorFlipPagerTitleView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.ActivityUserBinding
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.ui.adapter.UserInfoPageAdapter
import com.example.pandas.ui.ext.APP_COLOR_STATUS
import com.example.pandas.ui.ext.shape_20_drawables
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.math.abs

/**
 * @description: 用户个人主页
 * @author: dongyiming
 * @date: 4/21/22 5:35 下午
 * @version: v1.0
 */
public class UserInfoActivity : BaseActivity<BaseViewModel, ActivityUserBinding>() {

    private var userCode: Int = -1

    private var attentionUpdateCounts = 0

    private val tabList = listOf("作品", "其他")

    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, false, true, R.color.color_white_lucency)
        userCode = intent.getIntExtra("userCode", -1)

        binding.vpUser.run {
            offscreenPageLimit = tabList.size
            adapter = UserInfoPageAdapter(this@UserInfoActivity)
        }

        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int = tabList.size

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {

                val simplePagerTitleView = ColorFlipPagerTitleView(context)
                simplePagerTitleView.run {
                    text = tabList[index]
                    textSize = resources.getDimension(R.dimen.common_sz_3_dimens)
                    normalColor = ContextCompat.getColor(
                        this@UserInfoActivity,
                        R.color.color_txt_cute_item_name
                    )

                    val status = appViewModel.appColorType.value
                    selectedColor = if (status == null || status == 0) {
                        ContextCompat.getColor(
                            this@UserInfoActivity,
                            viewColors[APP_COLOR_STATUS]
                        )
                    } else {
                        ContextCompat.getColor(
                            this@UserInfoActivity,
                            viewColors[status]
                        )
                    }
                    setOnClickListener {
                        binding.vpUser.currentItem = index
                    }
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.run {
                    mode = LinePagerIndicator.MODE_EXACTLY
                    lineHeight = ScreenUtil.dip2px(2f)
                    lineWidth = ScreenUtil.dip2px(30f)
                    startInterpolator = AccelerateInterpolator()
                    endInterpolator = DecelerateInterpolator(2.0f)

                    val status = appViewModel.appColorType.value
                    if (status == null || status == 0) {
                        setColors(
                            ContextCompat.getColor(
                                this@UserInfoActivity,
                                viewColors[APP_COLOR_STATUS]
                            )
                        )
                    } else {
                        setColors(
                            ContextCompat.getColor(
                                this@UserInfoActivity,
                                viewColors[status]
                            )
                        )
                    }
                }
                return linePagerIndicator
            }
        }
        binding.tbUser.setNavigator(commonNavigator)
        ViewPagerHelper.bind(binding.tbUser, binding.vpUser)

        val lucencyColor = ContextCompat.getColor(this, R.color.color_white_lucency)
        binding.barUser.addOnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.txtUserBarName.visibility = View.GONE
                binding.ibUserVideo.setImageResource(R.mipmap.img_user_back_white)
                binding.ibUserMore.setImageResource(R.mipmap.img_user_more)
                binding.toolbarUserinfo.setBackgroundColor(lucencyColor)
            } else if (abs(verticalOffset) >= 0.6 * appBarLayout.totalScrollRange) {
                if (!binding.txtUserBarName.isVisible) {
                    binding.txtUserBarName.visibility = View.VISIBLE
                    mViewModel.user.value?.let {
                        binding.txtUserBarName.text = it.userName
                    }
                }

                appViewModel.appColorType.value?.let {
                    if (it == 0) {
                        binding.toolbarUserinfo.setBackgroundColor(
                            ContextCompat.getColor(
                                this,
                                viewColors[APP_COLOR_STATUS]
                            )
                        )
                    } else {
                        binding.toolbarUserinfo.setBackgroundColor(
                            ContextCompat.getColor(
                                this,
                                viewColors[it]
                            )
                        )
                    }
                }
            } else {
                binding.txtUserBarName.visibility = View.GONE
                binding.toolbarUserinfo.setBackgroundColor(lucencyColor)
            }
        }
        binding.ibUserVideo.setOnClickListener {
            if (attentionUpdateCounts % 2 != 0) {
                val intent = Intent().putExtra("userCode", userCode)
                setResult(RESULT_OK, intent)
            }
            finish()
        }
        binding.ibUserMore.setOnClickListener {
            Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launchWhenStarted {
            if (userCode > 0) {
                mViewModel.getUserByCode(userCode)
            }
        }
    }

    override fun onkeyBack() {
        if (attentionUpdateCounts % 2 != 0) {
            val intent = Intent().putExtra("userCode", userCode)
            setResult(RESULT_OK, intent)
        }
        super.onkeyBack()
    }

    override fun createObserver() {
        mViewModel.user.observe(this) {
            //setLevelImageResourse(it.level, binding.imgUserLevel)
            binding.txtUserName.text = it.userName
            binding.txtUserDesc.text = it.signature

            val provinces = AppInfos.provinces.random()
            binding.txtUserId.text = "IP属地：$provinces"

            it.headUrl?.let {
                loadImage(this, it, binding.imgUserHeader)
                //loadImage(this, it, binding.imgUserShelter)
            }

            val status = appViewModel.appColorType.value
            if (status == null || status == 0) {
                binding.clayoutUserFollow.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
            } else {
                binding.clayoutUserFollow.setBackgroundResource(shape_20_drawables[status])
            }

            if (it.attention) {
                binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
            }

            binding.clayoutUserFollow.setOnClickListener { _ ->

                if (!it.attention) {
                    attentionUpdateCounts += 1
                    mViewModel.updateAttention(it.userCode)
                    binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                    Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show()
                    it.attention = true
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
                        mViewModel.updateAttention(it.userCode)
                        attentionUpdateCounts += 1
                        val status1 = appViewModel.appColorType.value
                        if (status1 == null || status1 == 0) {
                            binding.clayoutUserFollow.setBackgroundResource(shape_20_drawables[APP_COLOR_STATUS])
                        } else {
                            binding.clayoutUserFollow.setBackgroundResource(shape_20_drawables[status1])
                        }
                        Toast.makeText(this, "已取消关注", Toast.LENGTH_SHORT).show()
                        it.attention = false
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
    }
}