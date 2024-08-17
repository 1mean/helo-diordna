package com.life.publish.lib_selector

import AppInstance
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.base.ui.activity.BaseActivity
import com.android.base.vm.BaseViewModel
import com.blankj.utilcode.util.ActivityUtils
import com.bumptech.glide.Glide
import com.example.pandas.R
import com.example.pandas.databinding.PsLayoutPublishFragmentBinding
import com.example.pandas.ui.activity.PublishActivity
import com.example.pandas.utils.StatusBarUtils
import com.life.publish.lib_selector.adapter.PublishItemDecoration
import com.life.publish.lib_selector.basic.PictureSelectorSupporterActivity
import com.life.publish.lib_selector.entity.LocalMedia
import com.life.publish.lib_selector.utils.ToastUtils


/**
 * @description: 发布
 * @author: dongyiming
 * @date: 8/13/24 7:30 PM
 * @version: v1.0
 */
public class PicturePublishActivity :
    BaseActivity<BaseViewModel, PsLayoutPublishFragmentBinding>() {

    private var mData: ArrayList<LocalMedia>? = null

    override fun initView(savedInstanceState: Bundle?) {

        if (AppInstance.instance.isNightMode) {
            StatusBarUtils.setStatusBarMode(this, false, R.color.color_bg_home)
        } else {
            StatusBarUtils.setStatusBarMode(this, true, R.color.color_bg_home)
        }

        mData = intent.getParcelableArrayListExtra<LocalMedia>("photos")


        binding.btnPublishBack.setOnClickListener {
            finish()
        }

        with(binding.recyclerPublish) {
            layoutManager =
                LinearLayoutManager(this@PicturePublishActivity, RecyclerView.HORIZONTAL, false)
            addItemDecoration(PublishItemDecoration())
            val mAdapter = PublishAdapter()
            if (mData != null && mData!!.isNotEmpty()) {
                mAdapter.initData(mData!!)
            }
            adapter = mAdapter
        }

        binding.imgPublishDelete.setOnClickListener {
            if (binding.editPublishTitle.text.toString().isNotEmpty()) {
                binding.editPublishTitle.text = null
                binding.editPublishTitle.hint = "填写标题"
            }
        }

        binding.clayoutPublish.setOnClickListener {
            if (binding.editPublishTitle.text.toString()
                    .isEmpty() || binding.editPublishContent.text.toString().isEmpty()
            ) {
                ToastUtils.showToast(this@PicturePublishActivity, "请填写标题和内容")
            } else {
                ToastUtils.showToast(this@PicturePublishActivity, "发布成功")
                ActivityUtils.finishActivity(PictureSelectorSupporterActivity::class.java)
                ActivityUtils.finishActivity(PublishActivity::class.java)
                finish()
            }
        }
    }

    override fun onkeyBack() {
        super.onkeyBack()
        finish()
    }

    override fun createObserver() {
    }

    private class PublishAdapter : RecyclerView.Adapter<PublishAdapter.PublishViewHolder>() {
        private var list: ArrayList<LocalMedia>? = null
        fun initData(list: ArrayList<LocalMedia>) {
            this.list = list
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublishViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.ps_adapter_publish, parent, false)
            return PublishViewHolder(view)
        }

        override fun onBindViewHolder(holder: PublishViewHolder, position: Int) {
            holder.handle(position)
        }

        override fun getItemCount(): Int {
            return if (list == null) {
                0
            } else list!!.size
        }

        inner class PublishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var image: AppCompatImageView

            init {
                image = itemView.findViewById(R.id.img_item_publish)
            }

            fun handle(position: Int) {
                if (list != null && !list!!.isEmpty()) {
                    val media = list!![position]
                    Glide.with(itemView.context).asBitmap().load(media.availablePath).into(image)
                }
            }
        }
    }
}