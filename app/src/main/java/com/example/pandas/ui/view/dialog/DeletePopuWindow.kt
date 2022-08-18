package com.example.pandas.ui.view.dialog

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.biz.interaction.OnSureListener

/**
 * @description: DeletePopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class DeletePopuWindow(
    private val activity: Activity,
    private val listener: OnSureListener
) : PopupWindow() {

    private var title: AppCompatTextView? = null

    init {

        val view = activity.layoutInflater.inflate(R.layout.dialog_history_delete_layout, null)
        contentView = view

        title = view.findViewById(R.id.txt_popu_title)
        val sure = view.findViewById<AppCompatButton>(R.id.txt_history_dialog_yes)
        val cancel = view.findViewById<AppCompatButton>(R.id.txt_history_dialog_no)

        width = 972
        height = 330
        isFocusable = true

        cancel.setOnClickListener {
            dismiss()
        }

        setOnDismissListener {

            activity.window.run {
                attributes.alpha = 1.0f
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        }

        sure.setOnClickListener {
            dismiss()
            listener.onSure()
        }
    }

    fun setTitle(titleStr: String): DeletePopuWindow {
        title?.text = titleStr
        return this
    }

    fun setBackDark(): DeletePopuWindow {
        //设置背景变暗
        activity.window.run {
            attributes.alpha = 0.5f //代表透明程度，范围为0 - 1.0f
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return this
    }

    fun onShow(parent: View) {
        isOutsideTouchable = true
        showAtLocation(parent, Gravity.CENTER, 0, 0)
    }
}