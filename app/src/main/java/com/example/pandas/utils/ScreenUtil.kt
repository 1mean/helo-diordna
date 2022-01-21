import android.content.Context
import android.util.DisplayMetrics

import android.view.WindowManager


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/14 10:31 下午
 * @version: v1.0
 */
public class ScreenUtil {

    companion object {

        fun dip2px(context: Context, dpValue: Float): Int {
            return (dpValue * context.resources.displayMetrics.density).toInt()
        }

        fun dp2px(context: Context, dpValue: Float): Int {

            val scale = context.resources.displayMetrics.density

            return (dpValue * scale + 0.5f).toInt()

        }

        fun px2dp(context: Context, pxValue: Float): Int {

            val scale = context.resources.displayMetrics.density

            return (pxValue / scale + 0.5f).toInt()

        }


        //获取屏幕宽度的方法
        fun getScreenWidth(context: Context): Int {
            val wm = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val outMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(outMetrics)
            return outMetrics.widthPixels
        }

        fun getScreenHeight(context: Context): Int {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getRealMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }
    }
}