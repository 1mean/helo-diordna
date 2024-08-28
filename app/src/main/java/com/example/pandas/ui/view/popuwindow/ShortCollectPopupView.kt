package com.example.pandas.ui.view.popuwindow

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.Group
import com.android.base.interaction.AdapterListener
import com.example.pandas.R
import com.example.pandas.ui.adapter.CollectItemAdapter
import com.example.pandas.ui.ext.initBase
import com.lxj.xpopup.core.BottomPopupView

/**
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
@SuppressLint("ViewConstructor")
public class ShortCollectPopupView(
    context: Context,
    list: MutableList<Group>,
    private val listener: AdapterListener<Group>
) : BottomPopupView(context) {

    val mAdapter = CollectItemAdapter(list, listener)

    override fun getImplLayoutId(): Int = R.layout.dialog_short_collect

    private lateinit var groupRv: RecyclerView
    private lateinit var btnAdd: AppCompatImageButton
    private lateinit var cancelView: AppCompatTextView
    private lateinit var bottomView: ConstraintLayout

    override fun onCreate() {
        super.onCreate()

        groupRv = findViewById(R.id.rv_collect)
        btnAdd = findViewById(R.id.ibtn_collect_add)
        cancelView = findViewById(R.id.txt_short_collect_cancel)
        bottomView = findViewById(R.id.clayout_short_collect_bottom)

        groupRv.initBase(adapter = mAdapter)

        bottomView.setOnClickListener {
            listener.viewClick()
        }
    }
}