package com.example.pandas.utils

import android.R
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.view.Window
import android.view.WindowManager
import androidx.annotation.FloatRange
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.readystatesoftware.systembartint.SystemBarTintManager
import java.util.regex.Pattern


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/13 10:52 下午
 * @version: v1.0
 */
object StatusBarUtils {

    var DEFAULT_COLOR = 0
    var DEFAULT_ALPHA =
        0f //Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 0.2f : 0.3f;

    val MIN_API = 19


    /**
     * 设置状态栏为透明
     * @param activity
     */
    @TargetApi(19)
    fun setTranslucentStatus(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val window = activity.window
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }

    /**
     * 修改状态栏颜色，支持4.4以上版本
     * @param activity
     * @param colorId
     */
    fun setStatusBarColor(activity: Activity, colorId: Int) {

        //Android6.0（API 23）以上，系统方法
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.statusBarColor = ContextCompat.getColor(activity, colorId)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //使用SystemBarTint库使4.4版本状态栏变色，需要先将状态栏设置为透明
            setTranslucentStatus(activity)
            //设置状态栏颜色
            val tintManager = SystemBarTintManager(activity)
            tintManager.isStatusBarTintEnabled = true
            tintManager.setStatusBarTintResource(colorId)
        }
    }

    /**
     * 设置状态栏模式
     * @param activity
     * @param isTextDark 文字、图标是否为黑色 （false为默认的白色）
     * @param colorId 状态栏颜色
     * @return
     */
    fun setStatusBarMode(activity: Activity, isTextDark: Boolean, colorId: Int) {
        //修改状态栏颜色和文字图标颜色
        setStatusBarColor(activity, colorId)
        //4.4以上才可以改文字图标颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0以上，调用系统方法
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (isTextDark) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        }
    }

    fun setStatusBarTextColor(activity: Activity, isTextDark: Boolean) {
        //4.4以上才可以改文字图标颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0以上，调用系统方法
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (isTextDark) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
        }
    }

    /**
     * 符合我当前系统的设置状态栏的方式，一步到位
     *      - Android6.0（API 23）以上，系统方法
     *      - 4.4以上才可以改文字图标颜色
     *   - 修改状态栏颜色：window.statusBarColor
     *   - 文字图标颜色：
     *      - 设置背景是浅色，字体颜色就为黑：View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR，
     *      - 默认：View.SYSTEM_UI_FLAG_LAYOUT_STABLE
     * @param:
     * @date: 1/25/22 7:36 下午
     * @version: v1.0
     */
    fun updataStatus(
        activity: Activity,
        isTextDark: Boolean,
        isFullScreend: Boolean,
        colorId: Int
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = activity.window
            window.statusBarColor = ContextCompat.getColor(activity, colorId)//设置状态栏背景色
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            var status: Int = -1
            if (isFullScreend) {//设置侵入状态栏
                if (isTextDark) {
                    status =
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                } else {
                    status =
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                }
            } else {
                if (isTextDark) {
                    status = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    status = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                }
            }
            window.decorView.systemUiVisibility = status
        }
    }

    /**
     * 获取状态栏高度
     *
     * @date: 2/6/22 11:42 下午
     * @version: v1.0
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 24
        val resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        result = if (resId > 0) {
            context.resources.getDimensionPixelSize(resId)
        } else {
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                result.toFloat(), Resources.getSystem().displayMetrics
            ).toInt()
        }
        return result
    }

    /**
     * 增加View的高度以及paddingTop,增加的值为状态栏高度.一般是在沉浸式全屏给ToolBar用的
     *
     * @date: 2/6/22 11:43 下午
     * @version: v1.0
     */
    fun setHeightAndPadding(context: Context, view: View) {
        if (Build.VERSION.SDK_INT >= MIN_API) {
            val lp = view.layoutParams
            lp.height += getStatusBarHeight(context)
            view.setPadding(
                view.paddingLeft,
                view.paddingTop + getStatusBarHeight(
                    context
                ),
                view.paddingRight,
                view.paddingBottom
            )
        }
    }

    //<editor-fold desc="沉侵">
    fun /*@@maxkfq@@*/immersive(activity:/*@@xldgvz@@*/Activity) {
        immersive(
            activity,
            DEFAULT_COLOR,
            DEFAULT_ALPHA
        )
    }

    fun /*@@sosudq@@*/immersive(
        activity:/*@@xldgvz@@*/Activity,
        color:/*@@pvpmmn@@*/Int,
        @FloatRange(from = 0.0, to = 1.0) alpha:/*@@khjhby@@*/Float
    ) {
        immersive(activity.window, color, alpha)
    }

    fun /*@@eseoac@@*/immersive(activity:/*@@xldgvz@@*/Activity, color:/*@@pvpmmn@@*/Int) {
        immersive(activity.window, color, 1f)
    }

    fun /*@@immqor@@*/immersive(window:/*@@cwflmd@@*/Window) {
        immersive(
            window,
            DEFAULT_COLOR,
            DEFAULT_ALPHA
        )
    }

    fun /*@@zyhzlk@@*/immersive(window:/*@@cwflmd@@*/Window, color:/*@@pvpmmn@@*/Int) {
        immersive(window, color, 1f)
    }

    fun /*@@dnxkhj@@*/immersive(
        window:/*@@cwflmd@@*/Window,
        color:/*@@pvpmmn@@*/Int,
        @FloatRange(from = 0.0, to = 1.0) alpha:/*@@khjhby@@*/Float
    ) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor =
                mixtureColor(color, alpha)
            var systemUiVisibility/*@@pvpmmn@@*/ = window.decorView.systemUiVisibility
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = systemUiVisibility
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            setTranslucentView(
                window.decorView as /*@@kmijdm@@*/ViewGroup,
                color,
                alpha
            )
        } else if (Build.VERSION.SDK_INT >= MIN_API && Build.VERSION.SDK_INT > 16) {
            var systemUiVisibility/*@@pvpmmn@@*/ = window.decorView.systemUiVisibility
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = systemUiVisibility
        }
    }

//        public fun getStatusBarHeight(context: Context): Int {
//
//            var result = 0
//            val resourceId: Int = context.resources
//                .getIdentifier("status_bar_height", "dimen", "android")
//
//            if (resourceId > 0) {
//                result = context.resources.getDimensionPixelSize(resourceId)
//            }
//            return result
//        }

    /** 设置状态栏darkMode,字体颜色及icon变黑(目前支持MIUI6以上,Flyme4以上,Android M以上)  */
    fun darkMode(activity: Activity) {
        darkMode(
            activity.window,
            DEFAULT_COLOR,
            DEFAULT_ALPHA
        )
    }

    /** 设置状态栏darkMode,字体颜色及icon变黑(目前支持MIUI6以上,Flyme4以上,Android M以上)  */
    fun darkMode(window: Window, color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        if (isFlyme4Later()) {
            darkModeForFlyme4(window, true)
            immersive(window, color, alpha)
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(window, true)
            immersive(window, color, alpha)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            darkModeForM(window, true)
            immersive(window, color, alpha)
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            setTranslucentView(
                window.decorView as ViewGroup,
                color,
                alpha
            )
        } else {
            immersive(window, color, alpha)
        }
    }

    /** 判断是否Flyme4以上  */
    fun isFlyme4Later(): Boolean {
        return (Build.FINGERPRINT.contains("Flyme_OS_4")
                || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4")
                || Pattern.compile("Flyme OS [4|5]", Pattern.CASE_INSENSITIVE)
            .matcher(Build.DISPLAY).find())
    }

    /** 判断是否为MIUI6以上  */
    fun isMIUI6Later(): Boolean {
        return try {
            val clz = Class.forName("android.os.SystemProperties")
            val mtd = clz.getMethod("get", String::class.java)
            var `val` = mtd.invoke(null, "ro.miui.ui.version.name") as String
            `val` = `val`.replace("[vV]".toRegex(), "")
            val version = `val`.toInt()
            version >= 6
        } catch (e: Throwable) {
            false
        }
    }

    //</editor-fold>
    /** 增加View的paddingTop,增加的值为状态栏高度  */
    fun setPadding(context: Context, view: View) {
        if (Build.VERSION.SDK_INT >= MIN_API) {
            view.setPadding(
                view.paddingLeft,
                view.paddingTop + getStatusBarHeight(
                    context
                ),
                view.paddingRight,
                view.paddingBottom
            )
        }
    }

    /** 增加View的paddingTop,增加的值为状态栏高度 (智能判断，并设置高度) */
    fun setPaddingSmart(context: Context, view: View) {
        if (Build.VERSION.SDK_INT >= MIN_API) {
            val lp = view.layoutParams
            if (lp != null && lp.height > 0) {
                lp.height += getStatusBarHeight(
                    context
                ) //增高
            }
            view.setPadding(
                view.paddingLeft,
                view.paddingTop + getStatusBarHeight(
                    context
                ),
                view.paddingRight,
                view.paddingBottom
            )
        }
    }

    /** 增加View上边距（MarginTop）一般是给高度为 WARP_CONTENT 的小控件用的 */
    fun setMargin(context: Context, view: View) {
        if (Build.VERSION.SDK_INT >= MIN_API) {
            val lp = view.layoutParams
            if (lp is MarginLayoutParams) {
                lp.topMargin += getStatusBarHeight(
                    context
                ) //增高
            }
            view.layoutParams = lp
        }
    }

    /**
     * 创建假的透明栏
     */
    fun setTranslucentView(
        container: ViewGroup,
        color: Int,
        @FloatRange(from = 0.0, to = 1.0) alpha: Float
    ) {
        if (Build.VERSION.SDK_INT >= 19) {
            val mixtureColor = mixtureColor(color, alpha)
            var translucentView = container.findViewById<View>(R.id.custom)
            if (translucentView == null && mixtureColor != 0) {
                translucentView = View(container.context)
                translucentView.id = R.id.custom
                val lp = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(container.context)
                )
                container.addView(translucentView, lp)
            }
            translucentView?.setBackgroundColor(mixtureColor)
        }
    }

    fun mixtureColor(color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float): Int {
        val a = if (color and -0x1000000 == 0) 0xff else color ushr 24
        return color and 0x00ffffff or ((a * alpha).toInt() shl 24)
    }


    /**
     * 设置Flyme4+的darkMode,darkMode时候字体颜色及icon变黑
     * http://open-wiki.flyme.cn/index.php?title=Flyme%E7%B3%BB%E7%BB%9FAPI
     */
    fun darkModeForFlyme4(window: Window?, dark: Boolean): Boolean {
        var result = false
        if (window != null) {
            try {
                val e = window.attributes
                val darkFlag =
                    WindowManager.LayoutParams::class.java.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                val meizuFlags =
                    WindowManager.LayoutParams::class.java.getDeclaredField("meizuFlags")
                darkFlag.isAccessible = true
                meizuFlags.isAccessible = true
                val bit = darkFlag.getInt(null)
                var value = meizuFlags.getInt(e)
                value = if (dark) {
                    value or bit
                } else {
                    value and bit.inv()
                }
                meizuFlags.setInt(e, value)
                window.attributes = e
                result = true
            } catch (var8: Exception) {
                Log.e("StatusBar", "darkIcon: failed")
            }
        }
        return result
    }

    /**
     * 设置MIUI6+的状态栏是否为darkMode,darkMode时候字体颜色及icon变黑
     * http://dev.xiaomi.com/doc/p=4769/
     */
    fun darkModeForMIUI6(window: Window, dark: Boolean): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            darkModeForM(window, dark)
        }
        val clazz: Class<out Window> = window.javaClass
        return try {
            var darkModeFlag = 0
            val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
            val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
            darkModeFlag = field.getInt(layoutParams)
            val extraFlagField = clazz.getMethod(
                "setExtraFlags",
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType
            )
            extraFlagField.invoke(window, if (dark) darkModeFlag else 0, darkModeFlag)
            true
        } catch (e: Throwable) {
            e.printStackTrace()
            false
        }
    }

    //------------------------->
    /** android 6.0设置字体颜色  */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun darkModeForM(window: Window, dark: Boolean) {
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(Color.TRANSPARENT);
        var systemUiVisibility = window.decorView.systemUiVisibility
        systemUiVisibility = if (dark) {
            systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
        window.decorView.systemUiVisibility = systemUiVisibility
    }
}