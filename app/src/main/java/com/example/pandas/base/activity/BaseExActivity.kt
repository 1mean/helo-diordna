package com.example.pandas.base.activity

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.biz.manager.SoftInputManager

/**
 * @description: 扩展，添加软键盘的控制
 * @author: dongyiming
 * @date: 7/21/22 12:28 下午
 * @version: v1.0
 */
public abstract class BaseExActivity<VM : BaseViewModel, VB : ViewBinding> :
    BaseActivity<VM, VB>() {

    var isKeyBoardShow: Boolean = false

    private val km: SoftInputManager by lazy { SoftInputManager(this) }

    override fun initView(savedInstanceState: Bundle?) {
        km.setOnSoftKeyBoardChangeListener(object : SoftInputManager.OnSoftKeyBoardChangeListener {
            override fun keyBoardShow(height: Int) {
                isKeyBoardShow = true
            }

            override fun keyBoardHide(height: Int) {
                isKeyBoardShow = false
            }
        })
    }

    /**
     * EditText 一定要被ConstraintLayout包裹
     *
     * @author: dongyiming
     * @date: 7/21/22 12:46 下午
     * @version: v1.0
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus //界面里只给editext设置focus，其他地方点击为null
            view?.let { v ->
                val consumed = super.dispatchTouchEvent(ev)
                val viewTmp = currentFocus
                val viewNew = viewTmp ?: v
                if (viewNew == v) {
                    val parentView = v.parent as ConstraintLayout
                    if (parentView is ConstraintLayout && parentView != null) {
                        val rect = Rect()
                        val coordinates = IntArray(2)
//                    view.getLocationOnScreen(coordinates)
                        parentView.getLocationOnScreen(coordinates)
                        rect.set(
                            0,
                            coordinates[1],
                            parentView.width,
                            coordinates[1] + parentView.height
                        )
                        val x = ev.x.toInt()
                        val y = ev.y.toInt()
                        if (rect.contains(x, y)) {
                            return consumed
                        }
                    }
                } else if (viewNew is EditText) {
                    return consumed
                }
                if (isKeyBoardShow) {
                    km.hideKeyBoard(this, viewNew)
//                    if (viewNew is EditText) {
//                        (viewNew as EditText).isCursorVisible = false
//                    }
//                    viewNew.clearFocus()
                }
                return consumed
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onPause() {
        super.onPause()
        if (isKeyBoardShow) {
            km.hideKeyBoard(this,currentFocus)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        km.onDestroy()
    }

    fun keyBoardVisible(view: View) {
        if (!isKeyBoardShow) {
            km.showKeyBoard(this, view)
        }
    }

    fun keyBoardInvisible(view: View) {
        if (isKeyBoardShow) {
            km.hideKeyBoard(this, view)
        }
    }

}