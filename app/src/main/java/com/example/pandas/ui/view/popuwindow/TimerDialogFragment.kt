package com.example.pandas.ui.view.popuwindow

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.pandas.R
import com.example.pandas.utils.ScreenUtil


/**
 * @description: ShortBottoomPopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class TimerDialogFragment() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.window_timer, null)
        //初始化view
        return rootView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        val window = dialog.window
        if (null != window) {
            window.decorView.setPadding(0, 0, 0, 0)
            window.setBackgroundDrawableResource(R.drawable.shape_20_white)
            val lp = window.attributes
            context?.let { ctx ->
                val screenWidth = ScreenUtil.getScreenWidth(ctx)
                val screenHeight = ScreenUtil.getScreenHeight(ctx)
                lp.width = (screenWidth * 0.93).toInt()
                lp.height = (screenHeight * 0.43).toInt()
                lp.gravity = Gravity.BOTTOM
                lp.y = 150
                window.attributes = lp
            }
            lp.windowAnimations = R.style.style_timer_animation
            window.attributes = lp
        }
        dialog.setOnKeyListener { dialog, keyCode, event ->
            false
        }
        return dialog
    }
}