package com.example.pandas.ui.activity

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.pandas.R
import com.example.pandas.utils.StatusBarUtils

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 4:32 下午
 * @version: v1.0
 */
public class TestCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //StatusBarUtils.setStatusTranslucent(this,)

        val view = layoutInflater.inflate(R.layout.activity_face,null)
        //view.layoutParams = ViewGroup.LayoutParams(300,300)
        setContentView(view)
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

//        StatusBarUtils.setStatusTranslucent(this)
//        StatusBarUtils.showSystemUI(this)

    }

    override fun onResume() {
        super.onResume()

        val width = window.decorView.width
        val height = window.decorView.height
        Log.e("1mean", "width:$width, height:$height")
    }
}