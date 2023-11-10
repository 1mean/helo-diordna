package com.example.pandas.ui.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.bean.ShareItem
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.DialogShareBinding
import com.example.pandas.ui.adapter.ShareDialogAdapter
import com.example.pandas.ui.adapter.decoration.ShareItemDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @description: ShareBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
public class ShareBottomSheetDialog(
    context: Context,
    private val onItemClick: (t: String) -> Unit
) :
    BottomSheetDialog(context) {

    private var _binding: DialogShareBinding? = null
    val binding: DialogShareBinding get() = _binding!!

    private val topAdapter: ShareDialogAdapter by lazy { ShareDialogAdapter(onItemClick = onItemClick) }
    private val bomAdapter: ShareDialogAdapter by lazy { ShareDialogAdapter(onItemClick = onItemClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DialogShareBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        initWidget()
    }

    private fun initWidget() {

        val marginLeft = context.resources.getDimension(R.dimen.common_lh_11_dimens).toInt()

        binding.btnShareClose.setOnClickListener {
            dismiss()
        }

        binding.rvShareTop.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(ShareItemDecoration(marginLeft))
            adapter = topAdapter
        }

        binding.rvShareBottom.run {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(ShareItemDecoration(marginLeft))
            adapter = bomAdapter
        }

    }

    fun addData(): ShareBottomSheetDialog {
        topAdapter.refreshAdapter(topList)
        bomAdapter.refreshAdapter(bomList)
        return this
    }

    fun onShow() {
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        show()
    }

    private val topList: MutableList<ShareItem> =
        mutableListOf(
            ShareItem(R.mipmap.img_weixin, "微信"),
            ShareItem(R.mipmap.img_weixin_zone, "朋友圈"),
            ShareItem(R.mipmap.img_qq, "QQ"),
            ShareItem(R.mipmap.img_qq_zone, "QQ空间")
        )
    private val bomList: MutableList<ShareItem> =
        mutableListOf(
            ShareItem(R.mipmap.img_share_zone, "动态"),
            ShareItem(R.mipmap.img_share_news, "消息"),
            ShareItem(R.mipmap.img_share_pic, "图片分享"),
            ShareItem(R.mipmap.img_copy_url, "复制链接"),
            ShareItem(R.mipmap.img_share_more, "更多"),
        )
}