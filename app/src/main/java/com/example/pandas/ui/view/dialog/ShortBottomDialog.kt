package com.example.pandas.ui.dialog

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.manager.SoftInputManager
import com.example.pandas.data.qq.EmotionItem
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.ui.adapter.decoration.ShortEmoji2Decoration
import com.example.pandas.ui.adapter.decoration.ShortEmojiDecoration
import com.example.pandas.ui.view.recyclerview.MyVerticalRecyclerView
import com.lxj.xpopup.core.BottomPopupView

/**
 * @description: 短视频界面，底部弹出窗
 * @author: dongyiming
 * @date: 6/4/23 11:57 AM
 * @version: v1.0
 */
public class ShortBottomDialog(
    context: Context,
    private val editStr: String,
    private val listener: ShortPopuListener
) : BottomPopupView(context) {

    private var input_flag = false
    private var emojiView: MyVerticalRecyclerView? = null
    private var _editText: AppCompatEditText? = null
    private val editText get() = _editText!!
    private var keyBoardManager: SoftInputManager? = null
    private var _eitLayout: ConstraintLayout? = null

    public var isOpen: Boolean = false
    public var isFaceOpen: Boolean = false


    override fun getImplLayoutId(): Int = R.layout.dialog_vertical_input

    override fun onCreate() {
        super.onCreate()

        val recyclerView = findViewById<RecyclerView>(R.id.rv_short_input_face)
        emojiView = findViewById<MyVerticalRecyclerView>(R.id.clayout_short_input_emoji)
        val inputLayout = findViewById<LinearLayoutCompat>(R.id.clayout_short_top)
        _editText = findViewById<AppCompatEditText>(R.id.edit_vertical_input)
        val btnFace = findViewById<AppCompatImageButton>(R.id.btn_short_input_face)
        val btnSend = findViewById<AppCompatButton>(R.id.btn_short_send)
        _eitLayout = findViewById<ConstraintLayout>(R.id.clayout_short_eit)

        editText.setOnClickListener {
            isFaceOpen = false
            if (emojiView!!.isVisible) {
                emojiView!!.visibility = View.GONE
            }
        }

        btnSend.setOnClickListener {
            listener.sendComment(editText.text.toString())
            dismiss()
        }

        editText.addTextChangedListener { input ->
            Log.e("input", "input:$input")
            val inpputext = editText.text.toString()
            Log.e("input", "inpputext:$inpputext")

            if (input == null || input.isEmpty()) {
                btnSend.visibility = View.GONE
                val params = inputLayout.layoutParams
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
                params.height = ViewGroup.LayoutParams.MATCH_PARENT
                inputLayout.layoutParams = params
                input_flag = false
            } else {
                if (!input_flag) {//0.77

                    val params = inputLayout.layoutParams
                    params.width = 819
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT
                    inputLayout.layoutParams = params

                    //bug:第一次设置visible时，动画是不会执行的
                    if (btnSend.visibility == View.GONE) {
                        btnSend.visibility = View.INVISIBLE
                        btnSend.post {
                            //设置偏移中心点，从右边到左边
                            btnSend.pivotX = btnSend.width.toFloat()
                            val translationX =
                                ObjectAnimator.ofFloat(
                                    btnSend,
                                    "scaleX",
                                    0f,
                                    1f
                                )
                            translationX.duration = 200
                            translationX.start()
                            btnSend.visibility = View.VISIBLE
                        }
                    }
                    input_flag = true
                }
            }
        }

        val list = QqEmoticons.hotEmoticonHashMap
        recyclerView.run {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            addItemDecoration(ShortEmojiDecoration(activity))
            adapter = object : BaseCommonAdapter<EmotionItem>(list) {
                override fun getLayoutId(): Int = R.layout.adapter_short_emoji

                override fun convert(holder: BaseViewHolder, data: EmotionItem, position: Int) {
                    val mContext = holder.itemView.context
                    val emoji = holder.getWidget<AppCompatImageButton>(R.id.btn_emoji)
                    emoji.setImageResource(data.emotionIcon)
                    holder.itemView.setOnClickListener {

                        val spannableString = QqEmoticons.convertEmotion2String(mContext, data)
                        spannableString?.let {
                            //selectionStart没有值时为-1。比较取大于0的值
                            val startIndex = editText.selectionStart.coerceAtLeast(0)
                            editText.text?.insert(startIndex, it)
                        }
                    }
                }
            }
        }
        val images = QqEmoticons.sQqEmoticonHashMap
        emojiView?.run {
            layoutManager = GridLayoutManager(activity, 7)
            addItemDecoration(ShortEmoji2Decoration(activity))
            adapter = object : BaseCommonAdapter<EmotionItem>(images) {
                override fun getLayoutId(): Int = R.layout.adapter_emoji_gride

                override fun convert(holder: BaseViewHolder, data: EmotionItem, position: Int) {
                    val mContext = holder.itemView.context
                    val emoji = holder.getWidget<AppCompatImageButton>(R.id.btn_emoji)
                    emoji.setImageResource(data.emotionIcon)
                    holder.itemView.setOnClickListener {
                        val spannableString = QqEmoticons.convertEmotion2String(mContext, data)
                        spannableString?.let {
                            //selectionStart没有值时为-1。比较取大于0的值
                            val startIndex = editText.selectionStart.coerceAtLeast(0)
                            editText.text?.insert(startIndex, it)
                        }
                    }
                }
            }
        }

        btnFace.setOnClickListener {
            if (emojiView != null && emojiView!!.isVisible) {
                return@setOnClickListener
            }
            isFaceOpen = true
            listener.openEmoji(editText)
            //1。关闭软键盘
            val km = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            km.hideSoftInputFromWindow(windowToken, 0)

            //将dialog移动到最底部，同时显示表情界面，两个动画效果先后执行
            postDelayed({
                val transY = ObjectAnimator.ofFloat(bottomPopupContainer, "translationY", 891f, 0f)
                val transAlpha = ObjectAnimator.ofFloat(bottomPopupContainer, "alpha", 1f, 0f, 1f)
                val animationSet = AnimatorSet()
                animationSet.duration = 300
                animationSet.play(transY).with(transAlpha)
                animationSet.start()
            }, 100)

            emojiView?.let {
                it.postDelayed({
                    emojiView?.visibility = View.VISIBLE
                }, 300)
            }
        }


    }

    override fun onKeyboardHeightChange(height: Int) {
        super.onKeyboardHeightChange(height)
        if (height == 0) {
            if (isOpen && !isFaceOpen) {
                dismiss()
                isOpen = false
            }
        } else {
            isOpen = true
        }
    }

    fun clear() {
        editText.text = null
    }

    fun showEmotion() {
        emojiView?.let {
            editText.requestFocus()
            editText.isFocusable = true
            isFaceOpen = true
            it.visibility = View.VISIBLE
        }
    }

    fun showet() {
        _eitLayout?.let {

            //val transY = ObjectAnimator.ofFloat(it, "translationY", 0f, 366f)
            val transAlpha = ObjectAnimator.ofFloat(it, "alpha", 0f, 1f)
            val animationSet = AnimatorSet()
            animationSet.duration = 300
            animationSet.play(transAlpha)
            animationSet.start()

            it.visibility = View.VISIBLE
        }
    }

    //bug:重写dismiss，解决一些问题
    override fun dismiss() {
        super.dismiss()
        isFaceOpen = false
        emojiView?.visibility = View.GONE
        listener.dissmiss(editText.text.toString())
    }

    interface ShortPopuListener {

        fun openEmoji(view: View)

        fun sendComment(comment: String)

        fun dissmiss(comment: String)
    }
}