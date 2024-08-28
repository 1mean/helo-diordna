package com.example.pandas.ui.view.popuwindow

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.Group
import com.android.base.interaction.AdapterListener
import com.android.base.interaction.ViewClickListener
import com.example.pandas.R
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.adapter.CollectItemAdapter
import com.example.pandas.ui.ext.initBase
import com.example.pandas.ui.ext.toast
import com.github.iielse.switchbutton.SwitchView
import com.lxj.xpopup.core.BottomPopupView

/**
 * @description: CreateGroupPopupView
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
@SuppressLint("ViewConstructor")
public class CreateGroupPopupView(
    context: Context,
    private val coverUrl: String?,
    private val listener: ViewClickListener<Group>
) : BottomPopupView(context) {

    override fun getImplLayoutId(): Int = R.layout.dialog_group_create

    private lateinit var cancelView: AppCompatTextView
    private lateinit var sureView: AppCompatTextView
    private lateinit var cover: AppCompatImageView
    private lateinit var editText: AppCompatEditText
    private lateinit var switchView: SwitchView

    override fun onCreate() {
        super.onCreate()

        cancelView = findViewById(R.id.txt_cancel)
        sureView = findViewById(R.id.txt_sure)
        cover = findViewById(R.id.img_group_cover)
        editText = findViewById(R.id.edit_group_name)
        switchView = findViewById(R.id.switch_open)

        loadImage(context, coverUrl, cover)

        editText.isFocusable = true
        cancelView.setOnClickListener { dismiss() }
        sureView.setOnClickListener {
            val name = editText.text.toString()
            if (name.isEmpty()) {
                toast(context, "名称不能为空")
                return@setOnClickListener
            }
            val group = Group(
                groupName = name,
                createTime = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                open = switchView.isOpened,
                groupCover = coverUrl
            )
            listener.viewClick(group)
        }

    }
}