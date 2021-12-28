package com.example.pandas.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pandas.R

/**
 * @description: 启动app后的第一个界面
 * @author: dongyiming
 * @date: 11/17/21 1:17 PM
 * @version: v1.0
 */
public class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

}