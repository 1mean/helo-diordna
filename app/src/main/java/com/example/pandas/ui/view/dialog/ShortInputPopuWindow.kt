package com.example.pandas.ui.view.dialog

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import androidx.emoji.text.EmojiCompat
import androidx.emoji.widget.EmojiTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.manager.KeyboardManager
import com.example.pandas.ui.adapter.decoration.ShortEmojiDecoration
import com.example.pandas.ui.ext.hideSoftKeyboard

/**
 * @description: ShortInputPopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class ShortInputPopuWindow(
    private val activity: Activity
) : PopupWindow() {

    private var _editText: AppCompatEditText? = null
    private val editText get() = _editText!!

    init {
        val view = activity.layoutInflater.inflate(R.layout.dialog_vertical_input, null)
        contentView = view
        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.WRAP_CONTENT

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_short_input_face)
        val inputLayout = view.findViewById<ConstraintLayout>(R.id.clayout_comment_input)
        _editText = view.findViewById<AppCompatEditText>(R.id.edit_vertical_input)
        val btnFace = view.findViewById<AppCompatImageButton>(R.id.btn_short_input_face)
        val btnSend = view.findViewById<AppCompatButton>(R.id.btn_short_send)

        editText.requestFocus()
        editText.showSoftInputOnFocus = true

        isFocusable = true //必须设置，否则点击外部会触发其他控件的点击效果

        editText.addTextChangedListener { input ->

            if (input == null || input.isEmpty()) {
                btnSend.visibility = View.GONE
                val params = inputLayout.layoutParams
                params.width = LayoutParams.MATCH_PARENT
                params.height = LayoutParams.MATCH_PARENT
                inputLayout.layoutParams = params
            } else {
                val params = inputLayout.layoutParams
                params.width = 751
                params.height = LayoutParams.MATCH_PARENT

                inputLayout.layoutParams = params
                btnSend.visibility = View.VISIBLE
            }
        }

        val padding = activity.resources.getDimension(R.dimen.common_lh_18_dimens)
        val list = mutableListOf<String>("", "", "", "", "", "", "")
        recyclerView.run {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            addItemDecoration(ShortEmojiDecoration(padding.toInt()))
            adapter = object : BaseCommonAdapter<String>(list) {
                override fun getLayoutId(): Int = R.layout.adapter_short_emoji

                override fun convert(holder: BaseViewHolder, data: String, position: Int) {
                    val emoji = holder.getWidget<EmojiTextView>(R.id.txt_emoji)
                    val processed = EmojiCompat.get().process("\uD83D\uDE10")
                    emoji.text = processed
                }
            }
        }

        setOnDismissListener {
            activity.window.run {
                attributes.alpha = 1.0f
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        }
        setLayout()
    }

    private fun setLayout() {

        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    fun setBackDark(): ShortInputPopuWindow {
        //设置背景变暗
        activity.window.run {
            attributes.alpha = 0.5f //代表透明程度，范围为0 - 1.0f
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return this
    }

    fun onShow(view: View) {
        animationStyle = R.style.style_vertical_video_animation
        Log.e("keyBoardManager", "onShow")
        isOutsideTouchable = true
        showAtLocation(view, Gravity.CENTER, 0, 160)
    }

    override fun dismiss() {

        val view = activity.currentFocus
        if (view is AppCompatEditText) {
            Log.e("keyBoardManager", "caonima")
            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (activity.currentFocus != null) {
                imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0);
            }
//            view.isCursorVisible = false
//            view.isFocusable = false
            super.dismiss()
        }
    }
}