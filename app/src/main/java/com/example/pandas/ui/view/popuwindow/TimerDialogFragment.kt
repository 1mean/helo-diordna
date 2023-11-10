package com.example.pandas.ui.view.popuwindow

import AppInstance
import android.app.AlarmManager
import android.app.Dialog
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import androidx.fragment.app.DialogFragment
import com.blankj.utilcode.util.AppUtils
import com.example.pandas.R
import com.example.pandas.base.lifecycle.LifecycleHandler
import com.example.pandas.ui.activity.MainActivity
import com.example.pandas.ui.broadcast.ShutdownBroadcastReceiver
import com.example.pandas.utils.ScreenUtil
import com.example.pandas.utils.TimeUtils
import java.util.*


/**
 * @description: ShortBottoomPopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class TimerDialogFragment : DialogFragment() {

    var cancelView: AppCompatTextView? = null
    var startView: AppCompatTextView? = null
    var timing: AppCompatTextView? = null
    var time1Top: AppCompatTextView? = null
    var time2Top: AppCompatTextView? = null
    var time3Top: AppCompatTextView? = null
    var time1Mid: AppCompatTextView? = null
    var time2Mid: AppCompatTextView? = null
    var time3Mid: AppCompatTextView? = null
    var time1Bottom: AppCompatTextView? = null
    var time2Bottom: AppCompatTextView? = null
    var time3Bottom: AppCompatTextView? = null
    var time1Layout: ConstraintLayout? = null
    var time2Layout: ConstraintLayout? = null
    var time3Layout: ConstraintLayout? = null
    var spanBuilder: SpannableStringBuilder? = null
    private var alarmManager: AlarmManager? = null
    private var pIntent: PendingIntent? = null
    private var selectIndex = 0
    private var totalSec: Long = 0

    //onCreateDialog->onCreateView->onViewCreated
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.e("1mean", "onCreateDialog")
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("1mean", "onCreateView")
        val rootView = inflater.inflate(R.layout.window_timer, null)
        cancelView = rootView.findViewById(R.id.txt_timer_cancel)
        startView = rootView.findViewById(R.id.txt_timer_comit)
        timing = rootView.findViewById(R.id.txt_timer)
        time1Top = rootView.findViewById(R.id.txt_timer1_top)
        time2Top = rootView.findViewById(R.id.txt_timer2_top)
        time3Top = rootView.findViewById(R.id.txt_timer3_top)
        time1Mid = rootView.findViewById(R.id.txt_timer1_mid)
        time2Mid = rootView.findViewById(R.id.txt_timer2_mid)
        time3Mid = rootView.findViewById(R.id.txt_timer3_mid)
        time1Bottom = rootView.findViewById(R.id.txt_timer1_bottom)
        time2Bottom = rootView.findViewById(R.id.txt_timer2_bottom)
        time3Bottom = rootView.findViewById(R.id.txt_timer3_bottom)
        time1Layout = rootView.findViewById(R.id.clayout_timer_time1)
        time2Layout = rootView.findViewById(R.id.clayout_timer_time2)
        time3Layout = rootView.findViewById(R.id.clayout_timer_time3)
        spanBuilder = SpannableStringBuilder()

        if (alarmManager == null) {//使用系统闹钟，避免手机休眠导致任务无法完成(如Timer)
            alarmManager = activity?.getSystemService(Service.ALARM_SERVICE) as AlarmManager
        }

        if (pIntent == null) {//创建一个用于广播的延迟意图
            //val broadIntent = Intent(ALARM_EVENT)
            val broadIntent = Intent(activity!!, ShutdownBroadcastReceiver::class.java)
            broadIntent.putExtra("request", "shutdown")
            pIntent =
                PendingIntent.getBroadcast(
                    activity?.applicationContext, 0, broadIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
        }

        //初始化view
        return rootView
    }

    private val handler = LifecycleHandler(Looper.getMainLooper(),this)

    private fun startTimer() {
        handler.postDelayed(timerTask, 1000)
    }

    private val timerTask = Runnable {
        Log.d("TimerDialogFragment", "totalSec:$totalSec ,thread:${Thread.currentThread().name}")
        totalSec -= 1
        if (totalSec == 0L) {
            AppUtils.exitApp()
        }
        val targetTime = TimeUtils.parseSeconds(totalSec)
        val timingStr = spanBuilder(targetTime)
        timing?.text = timingStr

        startTimer()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("1mean", "onViewCreated")
        val deadTime = AppInstance.instance.timerDeadTime
        val spaceMill = deadTime - System.currentTimeMillis()//间隔时间
        if (spaceMill > 0) {
            totalSec = spaceMill / 1000
            val targetTime = TimeUtils.parseSeconds(totalSec)
            val timingStr = spanBuilder(targetTime)
            timing?.text = timingStr
            startTimer()
        }

        cancelView?.setOnClickListener {
            dismiss()
        }
        startView?.setOnClickListener {

            val calendar = Calendar.getInstance()
            val startTime = System.currentTimeMillis()
            calendar.timeInMillis = startTime
            var endTime = 0L
            var amount = 0
            when (AppInstance.instance.timerType) {
                0 -> {
                    endTime = startTime + 30 * 60 * 1000
                    amount = 30
                }
                1 -> {
                    endTime = startTime + 60 * 60 * 1000
                    amount = 60
                }
                else -> {
                    endTime = startTime + 2 * 60 * 60 * 1000
                    amount = 120
                }
            }
            AppInstance.instance.timerDeadTime = endTime

            // 给当前时间加上若干秒
            calendar.add(Calendar.MINUTE, amount)
            // 开始设定闹钟，延迟若干秒后，携带延迟意图发送闹钟广播
            alarmManager?.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pIntent)
            dismiss()
        }
        activity?.let {

            if (it is MainActivity) {
                (it as MainActivity).mService?.haha()

            }

            Log.e("1mean", "activity:$it")
            //后续把写到自定义view里
            val whiteColor = ContextCompat.getColor(it, R.color.white)
            val normalColor = ContextCompat.getColor(it, R.color.color_timer_time)

            when (AppInstance.instance.timerType) {
                0 -> {
                    time1Top?.setTextColor(whiteColor)
                    time1Mid?.setTextColor(whiteColor)
                    time1Bottom?.setTextColor(whiteColor)
                    time1Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                    time2Top?.setTextColor(normalColor)
                    time2Mid?.setTextColor(normalColor)
                    time2Bottom?.setTextColor(normalColor)
                    time2Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                    time3Top?.setTextColor(normalColor)
                    time3Mid?.setTextColor(normalColor)
                    time3Bottom?.setTextColor(normalColor)
                    time3Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                }
                1 -> {
                    time2Top?.setTextColor(whiteColor)
                    time2Mid?.setTextColor(whiteColor)
                    time2Bottom?.setTextColor(whiteColor)
                    time2Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                    time1Top?.setTextColor(normalColor)
                    time1Mid?.setTextColor(normalColor)
                    time1Bottom?.setTextColor(normalColor)
                    time1Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                    time3Top?.setTextColor(normalColor)
                    time3Mid?.setTextColor(normalColor)
                    time3Bottom?.setTextColor(normalColor)
                    time3Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                }
                2 -> {
                    time3Top?.setTextColor(whiteColor)
                    time3Mid?.setTextColor(whiteColor)
                    time3Bottom?.setTextColor(whiteColor)
                    time3Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                    time1Top?.setTextColor(normalColor)
                    time1Mid?.setTextColor(normalColor)
                    time1Bottom?.setTextColor(normalColor)
                    time1Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                    time2Top?.setTextColor(normalColor)
                    time2Mid?.setTextColor(normalColor)
                    time2Bottom?.setTextColor(normalColor)
                    time2Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                }
            }

            time1Layout?.setOnClickListener {
                time1Top?.setTextColor(whiteColor)
                time1Mid?.setTextColor(whiteColor)
                time1Bottom?.setTextColor(whiteColor)
                time1Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                time2Top?.setTextColor(normalColor)
                time2Mid?.setTextColor(normalColor)
                time2Bottom?.setTextColor(normalColor)
                time2Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                time3Top?.setTextColor(normalColor)
                time3Mid?.setTextColor(normalColor)
                time3Bottom?.setTextColor(normalColor)
                time3Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                AppInstance.instance.timerType = 0
            }
            time2Layout?.setOnClickListener {
                time2Top?.setTextColor(whiteColor)
                time2Mid?.setTextColor(whiteColor)
                time2Bottom?.setTextColor(whiteColor)
                time2Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                time1Top?.setTextColor(normalColor)
                time1Mid?.setTextColor(normalColor)
                time1Bottom?.setTextColor(normalColor)
                time1Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                time3Top?.setTextColor(normalColor)
                time3Mid?.setTextColor(normalColor)
                time3Bottom?.setTextColor(normalColor)
                time3Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                AppInstance.instance.timerType = 1
            }
            time3Layout?.setOnClickListener {
                time3Top?.setTextColor(whiteColor)
                time3Mid?.setTextColor(whiteColor)
                time3Bottom?.setTextColor(whiteColor)
                time3Layout?.setBackgroundResource(R.drawable.shape_timer_selected)

                time1Top?.setTextColor(normalColor)
                time1Mid?.setTextColor(normalColor)
                time1Bottom?.setTextColor(normalColor)
                time1Layout?.setBackgroundResource(R.drawable.shape_timer_normal)

                time2Top?.setTextColor(normalColor)
                time2Mid?.setTextColor(normalColor)
                time2Bottom?.setTextColor(normalColor)
                time2Layout?.setBackgroundResource(R.drawable.shape_timer_normal)
                AppInstance.instance.timerType = 2
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        alarmManager = null
    }

    private fun spanBuilder(value: String): SpannableStringBuilder? {
        val time = "$value 后，将退出应用"
        activity?.let {
            spanBuilder?.clear()
            spanBuilder?.clearSpans()
            spanBuilder?.append(time)
            spanBuilder?.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(it, R.color.color_bg_sky)),
                0,
                value.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return spanBuilder
        }
        return null
    }
}