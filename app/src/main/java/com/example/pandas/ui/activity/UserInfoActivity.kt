package com.example.pandas.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.helo_base.magic.ViewPagerHelper
import com.example.helo_base.magic.commonnavigator.CommonNavigator
import com.example.helo_base.magic.commonnavigator.abs.CommonNavigatorAdapter
import com.example.helo_base.magic.commonnavigator.abs.IPagerIndicator
import com.example.helo_base.magic.commonnavigator.abs.IPagerTitleView
import com.example.helo_base.magic.commonnavigator.indicators.LinePagerIndicator
import com.example.helo_base.magic.commonnavigator.titles.ColorFlipPagerTitleView
import com.example.pandas.R
import com.example.pandas.base.activity.BaseActivity
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.ActivityUserBinding
import com.example.pandas.databinding.DialogAttentionCancelBinding
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.adapter.UserInfoPageAdapter
import com.example.pandas.ui.ext.setLevelImageResourse
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.StatusBarUtils
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: 用户个人主页
 * @author: dongyiming
 * @date: 4/21/22 5:35 下午
 * @version: v1.0
 */
public class UserInfoActivity : BaseActivity<BaseViewModel, ActivityUserBinding>() {

    private var user: User? = null

    private var toolbarUpdate: Boolean = false

    private val tabList = listOf("投稿", "动态", "主页")

    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(this, true, true, R.color.color_white_lucency)
        user = intent.getParcelableExtra("user")

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
                    textSize = resources.getDimension(R.dimen.common_sz_5_dimens)
                    normalColor = ContextCompat.getColor(
                        this@UserInfoActivity,
                        R.color.color_unselected_tab_userinfo
                    )
                    selectedColor = ContextCompat.getColor(
                        this@UserInfoActivity,
                        R.color.color_tab_text_selected
                    )
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
                    lineHeight = ScreenUtil.dip2px(3f)
                    lineWidth = ScreenUtil.dip2px(6f)
                    roundRadius = ScreenUtil.dip2px(3f)
                    startInterpolator = AccelerateInterpolator()
                    endInterpolator = DecelerateInterpolator(2.0f)
                    setColors(
                        ContextCompat.getColor(
                            this@UserInfoActivity,
                            R.color.color_tab_indicator
                        )
                    )
                }
                return linePagerIndicator
            }
        }
        binding.tbUser.setNavigator(commonNavigator)
        ViewPagerHelper.bind(binding.tbUser, binding.vpUser)

        initView()
        binding.barUser.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.txtUserBarName.visibility = View.GONE
                binding.ibUserVideo.setImageResource(R.mipmap.img_user_back)
                binding.ibUserMore.setImageResource(R.mipmap.img_user_more)
                binding.ibUserVideo.setBackgroundResource(R.drawable.shape_bg_user_video)
                binding.ibUserMore.setBackgroundResource(R.drawable.shape_bg_user_video)
                binding.toolbarUser.contentScrim = null
            } else if (Math.abs(verticalOffset) >= 0.6 * appBarLayout.totalScrollRange) {
                if (!binding.txtUserBarName.isVisible) {
                    binding.txtUserBarName.visibility = View.VISIBLE
                    user?.let {
                        binding.txtUserBarName.text = it.userName
                    }
                }
                binding.ibUserVideo.setImageResource(R.mipmap.img_user_back2)
                binding.ibUserMore.setImageResource(R.mipmap.img_user_more2)
                binding.ibUserVideo.background = null
                binding.ibUserMore.background = null
                binding.toolbarUser.setContentScrimResource(R.color.color_bg_user_top)
            } else {
                binding.txtUserBarName.visibility = View.GONE
                binding.ibUserVideo.setImageResource(R.mipmap.img_user_back)
                binding.ibUserMore.setImageResource(R.mipmap.img_user_more)
                binding.ibUserVideo.setBackgroundResource(R.drawable.shape_bg_user_video)
                binding.ibUserMore.setBackgroundResource(R.drawable.shape_bg_user_video)
                binding.toolbarUser.contentScrim = null
            }
        })
        binding.ibUserVideo.setOnClickListener {
            finish()
        }
        binding.ibUserMore.setOnClickListener {
            Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show()
        }
    }

    fun initView() {
        user?.let {
            if (it.vip == 1) {
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

            if (it.attention) {
                binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                binding.clayoutUserAttention.visibility = View.GONE
                binding.clayoutUserUnattention.visibility = View.VISIBLE
            }

            binding.clayoutUserFollow.setOnClickListener { _ ->

                if (!it.attention) {
                    mViewModel.updateAttention(it.userCode)
                    binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_unattention)
                    binding.clayoutUserAttention.visibility = View.GONE
                    binding.clayoutUserUnattention.visibility = View.VISIBLE
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
                        binding.clayoutUserFollow.setBackgroundResource(R.drawable.shape_user_attention)
                        binding.clayoutUserAttention.visibility = View.VISIBLE
                        binding.clayoutUserUnattention.visibility = View.GONE
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

    override fun createObserver() {

    }

}