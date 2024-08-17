package com.android.base.manager

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.ResultReceiver
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import com.android.base.utils.SoftInputUtils


/**
 * 软键盘，源代码可以查看 [TextView ## onTouchEvent()] 方法
 *
 * * * if (touchIsFinished && (isTextEditable() || textIsSelectable)) {
 * * *       // Show the IME, except when selecting in read-only text.
 * * *      final InputMethodManager imm = getInputMethodManager();
 * * *      viewClicked(imm);
 * * *      if (isTextEditable() && mEditor.mShowSoftInputOnFocus && imm != null) {
 * * *           imm.showSoftInput(this, 0);
 * * *      }
 * * *
 * * *      // The above condition ensures that the mEditor is not null
 * * *      mEditor.onTouchUpEvent(event);
 * * *      handled = true;
 * * * }
 * * * return handled;
 * * *
 * 相关知识点
 * - 软键盘也是dialog，软键盘弹出时，有两个window，分别是Activity和软键盘Dialog
 * - 软键盘的模式：WindowManager.LayoutParams.softInputMode，
 *     - SOFT_INPUT_ADJUST_UNSPECIFIED：不指定调整方式，系统自行决定使用哪种调整方式
 *         - 布局被顶上去
 *     - SOFT_INPUT_ADJUST_RESIZE：调整方式为布局需要重新计算大小适配当前可见区域
 *         - 已废弃。使用 window.setDecorFitsSystemWindows(true) 布局没变化
 *     - SOFT_INPUT_ADJUST_PAN：调整方式为布局需要整体移动
 *         - 布局被顶上去
 *     - SOFT_INPUT_ADJUST_NOTHING：不做任何操作
 *         - 布局没变化 当键盘弹出时，任何View都不需要顶上去，可以设置这个属性
 *     - SOFT_INPUT_STATE_HIDDEN：softInputMode可见状态，当切换至当前window时，在正常情况下隐藏任何软键盘区域
 *     - SOFT_INPUT_STATE_ALWAYS_HIDDEN：softInputMode可见状态，当当前window接收到focus焦点时，始终隐藏任何软键盘区域
 *     - SOFT_INPUT_STATE_VISIBLE：softInputMode可见状态，请在正常情况下(当用户导航到您的窗口时)显示软键盘区域
 *     - SOFT_INPUT_STATE_ALWAYS_VISIBLE：可见状态，当此窗口接收输入焦点时，请始终使软输入区域可见
 *
 * - 软键盘弹出时，会遮挡住部分内容区域，通过可见区域数据 [outRect] 可以得到被遮挡的区域，即偏移量
 *     - 偏移量 = 屏幕长度-可见长度
 *
 * 当app的窗口(即页面)的Focus状态发生变化，如进入一个新页面，这个窗口的focus状态从上一个页面的false变成true时，事件会经过一系列的回调，并通过WindowManagerService对窗口进行相应管理
 *
 *
 *                             ************************* --------
 *                             *      状态栏            *     63px
 *                             ************************* --------
 *                             *                       *
 *                             *                       *  内容区域被软键盘压缩了
 *                             *                       *
 *                             *                       *            【1920x1080】
 *                             *      内容  区域        *
 *                             *                       *
 *                             *-----------------------* ------------------
 *                             *                       *                  ｜
 *                             *      软键盘            *                  ｜
 *                             *                       *                972px
 *                             *                       *                  ｜
 *                             ************************* --------         ｜
 *                             *      导航栏            *     126px        ｜
 *                             ************************* ------------------
 *
 *  原理简析：
 *    - 软键盘是一个window，弹出后，导致了ViewTree的变化，[ViewRootImpl.java]里ViewRootHandler处理
 *    - ViewRootHandler接收到窗口变化事件，判断窗口几个区域尺寸是否变化，记录这些变化值
 *      - 主要有4个区域，用Rect来存储区域数据（键盘弹出 / 键盘收起）
 *      - arg1:    Window的尺寸            Rect(0,0-1080,1920)   /      Rect(0,0-1080,1920)
 *      - arg2:    内容区域限定边界         Rect(0,63-0,972)      /       Rect(0,63-0,126)
 *      - arg3:    可见区域的限定边界       Rect(0,63-0,972)      /       Rect(0,63-0,126)
 *      - arg6:    固定区域的限定边界       Rect(0,63-0,126)      /       Rect(0,63-0,126)
 *      - 键盘弹出和收起，变化的是arg2和arg3
 *   - 尺寸发生变化后，ViewTree里的每个view/ViewGroup都会执行三大流程
 *      - 当设置SOFT_INPUT_ADJUST_RESIZE，键盘弹起时内容区域发生变化，因此会执行dispatchApplyInsets()
 *      - 当设置SOFT_INPUT_ADJUST_PAN，键盘弹起时内容部区域不变，因此不会执行dispatchApplyInsets()
 *      - dispatchApplyWindowInsets分发insets:Rect
 *      - 最终给DecorView的子布局LinearLayout设置padding，最终会影响LinearLayout子布局的高度，一层层传递下去，就会影响到Demo里的Activity 布局文件的高度
 *   - [SOFT_INPUT_ADJUST_RESIZE]
 *      - SOFT_INPUT_ADJUST_RESIZE时，DecorView的子布局padding会改变，最后影响子孙布局的高度
 *          - 举例一个LinearLayout里有ImageView和Edittext
 *          - 当设置ImageView高度固定时，弹出软键盘后没有任何变化，但是EditText输入框会被盖住
 *          - 当设置ImageView高度跟随父布局变化时，ImageView变小了，EditText也被顶上去了
 *      - 父布局高度的变化并不一定会让自布局重新布局。根据ImageView的高度设置不同，当ImageView高度固定时，我们需要
 *      监听软键盘的变化从而调整输入框的位置，而第二种情况时，不需要手动调整，父布局会自动调整
 *
 *   - [SOFT_INPUT_ADJUST_PAN]     当焦点被软键盘遮挡住时，内容区域会被顶起，会有一部分内容区域被顶上去而不可见
 *      - 设置softinputmode为SOFT_INPUT_ADJUST_PAN
 *      - 布局LinearLayout里分别是 Edittext1--ImageView--Edittext2
 *      - 点击输入框1时，弹出软键盘，界面没变化，点击输入框2时，界面向上移动
 *    - 软键盘弹起时，arg2区域没有发生变化，即内容区域不变，最终不会执行ViewRootImp-> dispatchApplyInsets(xx)，当然布局的高度就不会变
 *    - 但是点击两个输入框的区别是，当键盘弹起时，输入框是否会被软键盘遮挡住，当被遮挡时，需要往上走，srolly>0
 *    - 确定滚动值并存储在mScrollY里，对Canvas进行平移，直至焦点的View显示在可见区域为止
 *
 *   - [SOFT_INPUT_ADJUST_UNSPECIFIED]   没有设置mode时的默认模式
 *    - 内部最终使用SOFT_INPUT_ADJUST_PAN和SOFT_INPUT_ADJUST_RESIZE之一进行展示，如何选择？
 *      - view是否是可以作为一个可以滚动的容器，如果可以滚动，高度就是可伸缩，此时设置SOFT_INPUT_ADJUST_RESIZE模式
 *      - 对于普通view，可以通过View.setScrollContainer(true)或者布局，同样可以实现
 *      - RecyclerView里默认就有该设置
 *
 *
 * @description: 软键盘
 * @author: dongyiming
 * @date: 5/31/22 1:16 上午
 * @version: v1.0
 */
class SoftInputManager(private val mContext: Context) {

    //    private var rootView: View? = null //activity的根视图
    private var rootViewVisibleHeight: Int = 0//纪录根视图的显示高度
    private var onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener? = null

    private var softInputHeight: Int = 0 //软键盘高度
    private var navigationHeight: Int = 0
    private var softInputHeightChanged: Boolean = false
    private var isNavigationBarShow: Boolean = false
    private var isSoftInputShowing: Boolean = false

    private var km: InputMethodManager? = null

    interface ISoftInputChanged {
        fun onChanged(isSoftInputShow: Boolean, softInputHeight: Int, viewOffset: Int)
    }

    /**
     * EditText设置监听高度的变化，方便view进行手动位置的改变
     *    - onChanged：view.setTranslationY(view.getTranslationY() - viewOffset)
     *    - editText2.setTranslationY(0)
     *    - 配合mode:android:windowSoftInputMode="adjustResize|stateAlwaysHidden"
     *
     * @param:
     * @author: dongyiming
     * @date: 12/16/22 7:31 PM
     * @version: v1.0
     */
    fun attachSoftInput(view: View?, softChangeListener: ISoftInputChanged?) {

        if (view == null || softChangeListener == null) {
            return
        }
        val rootView = view.rootView ?: return //获取根view
        navigationHeight = SoftInputUtils.getNavigationBarHeight(view.context)
        rootView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->

            val rootHeight = rootView.height //屏幕高度
            Log.d("pandas_log", "屏幕高度-rootHeight: $rootHeight")
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect) //获取当前可见区域，默认是除去状态栏和导航栏剩下的区域
            if (rootHeight - rect.bottom == navigationHeight) {
                //如果可见部分底部与屏幕底部刚好相差导航栏的高度，则认为有导航栏
                isNavigationBarShow = true;
            } else if (rootHeight - rect.bottom == 0) {
                //如果可见部分底部与屏幕底部平齐，说明没有导航栏
                isNavigationBarShow = false;
            }
            var isSoftInputShow = false
            var softInputHeight = 0
            val mutableHeight = if (isNavigationBarShow) navigationHeight else 0
            if (rootHeight - mutableHeight > rect.bottom) {
                //除去导航栏高度后，可见区域仍然小于屏幕高度，则说明键盘弹起了
                isSoftInputShow = true
                //键盘高度
                softInputHeight = rootHeight - mutableHeight - rect.bottom
                if (this.softInputHeight != softInputHeight) {
                    softInputHeightChanged = true
                    this.softInputHeight = softInputHeight
                } else {
                    softInputHeightChanged = false
                }
            }

            //获取目标View的位置坐标
            val location = IntArray(2)
            view.getLocationOnScreen(location)

            //条件1减少不必要的回调，只关心前后发生变化的
            //条件2针对软键盘切换手写、拼音键等键盘高度发生变化
            if (isSoftInputShowing != isSoftInputShow || isSoftInputShow && softInputHeightChanged) {
                //第三个参数为该View需要调整的偏移量
                //此处的坐标都是相对屏幕左上角(0,0)为基准的
                softChangeListener.onChanged(
                    isSoftInputShow,
                    softInputHeight,
                    location[1] + view.height - rect.bottom
                )
                isSoftInputShowing = isSoftInputShow
            }
        }
    }

    private val listener = object : ViewTreeObserver.OnGlobalLayoutListener {

        override fun onGlobalLayout() {
            //获取当前根视图在屏幕上显示的大小
            val rect = Rect()
            (mContext as Activity).window.decorView.getWindowVisibleDisplayFrame(rect)
            //当前activity根视图的高度
            val visibleHeight = rect.height()

            if (rootViewVisibleHeight == 0) {
                rootViewVisibleHeight = visibleHeight
                return
            }

            //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
            if (rootViewVisibleHeight == visibleHeight) {
                return
            }

            //根视图显示高度变小超过200，可以看作软键盘显示了
            if (rootViewVisibleHeight - visibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardShow(rootViewVisibleHeight - visibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return
            }

            //根视图显示高度变大超过200，可以看作软键盘隐藏了
            if (visibleHeight - rootViewVisibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardHide(visibleHeight - rootViewVisibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return
            }
        }
    }

    init {
        //监听视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变
        (mContext as Activity).window.decorView.viewTreeObserver.addOnGlobalLayoutListener(listener)
    }

    fun setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener
    }

    interface OnSoftKeyBoardChangeListener {
        fun keyBoardShow(height: Int)

        fun keyBoardHide(height: Int)
    }

    /**
     * 显示软键盘
     */
    fun showKeyBoard(activity: Activity, view: View?) {

        if (view == null) {
            return
        }
        if (km == null) {
            km = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        }
        km?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun showSoftInput(view: View?) {
        if (view == null) {
            return
        }
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            ?: return
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.requestFocus()
//        imm.showSoftInput(view, 0, SoftInputReceiver(view.context))
        imm.showSoftInput(view, 0)
        imm.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
//            InputMethodManager.SHOW_IMPLICIT
        )
    }

    inner class SoftInputReceiver(private var context: Context?) :
        ResultReceiver(Handler(Looper.getMainLooper())) {
        override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
            super.onReceiveResult(resultCode, resultData)
//            if (resultCode == InputMethodManager.RESULT_UNCHANGED_HIDDEN
//                || resultCode == InputMethodManager.RESULT_HIDDEN
//            ) {
//                toggleSoftInput(context!!)
//            }
//            context = null
        }
    }

    fun toggleSoftInput(context: Context) {
        val imm =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        imm.toggleSoftInput(0, 0)
    }

    /**
     * <隐藏软键盘>
     * @param:
     * @author: dongyiming
     * @date: 12/16/22 5:16 PM
     * @version: v1.0
     */
    fun hideKeyBoard(activity: Activity, view: View?) {

        if (view == null) {
            return
        }
        if (km == null) {
            km = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        }
//        km?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        km?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun onDestroy() {

        (mContext as Activity).window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(
            listener
        )
        km = null
    }

    private fun isSoftShowing(activity: Activity): Boolean {
        //获取当前屏幕内容的高度
        val screenHeight = activity.window.decorView.height
        //获取View可见区域的bottom
        val rect = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(rect)
        return screenHeight - rect.bottom != 0
    }

}