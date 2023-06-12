package com.example.pandas.ui.view.dialog

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
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


/**
 * @description: ShortBottoomPopuWindow
 * @author: dongyiming
 * @date: 8/18/22 5:30 下午
 * @version: v1.0
 */
public class ShortBottoomPopuWindow(
    private val activity: Activity,
    private val editStr: String,
    private val listener: ShortPopuListener
) : PopupWindow() {

    private var input_flag = false
    private var emojiView: RecyclerView? = null
    private var _editText: AppCompatEditText? = null
    private val editText get() = _editText!!
    private var keyBoardManager: SoftInputManager? = null

    private val mHandler: Handler = Handler(Looper.getMainLooper())

    init {
        val view = activity.layoutInflater.inflate(R.layout.dialog_vertical_input, null)
        contentView = view
        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.WRAP_CONTENT

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_short_input_face)
        emojiView = view.findViewById<RecyclerView>(R.id.clayout_short_input_emoji)
        val inputLayout = view.findViewById<LinearLayoutCompat>(R.id.clayout_short_top)
        _editText = view.findViewById<AppCompatEditText>(R.id.edit_vertical_input)
        val btnFace = view.findViewById<AppCompatImageButton>(R.id.btn_short_input_face)
        val btnSend = view.findViewById<AppCompatButton>(R.id.btn_short_send)

        keyBoardManager = SoftInputManager(activity)
//        editText.requestFocus()
//        editText.showSoftInputOnFocus = true

        isFocusable = true //必须设置，否则点击外部会触发其他控件的点击效果

        editText.setOnClickListener {
            Log.e("editText", "editText")
            if (emojiView!!.isVisible) {
                emojiView!!.visibility = View.GONE
            }
        }
        btnSend.setOnClickListener {
            listener.sendComment(editText.text.toString())
            dismiss()
        }

//        if (editStr.isNotEmpty()) {
//            _editText?.post {
//                val stringBuilder = QqEmoticons.parseAndShowEmotion(activity,editStr)
//                editText.text = stringBuilder
//                editText.setSelection(editText.length())
//            }
//        }

        editText.addTextChangedListener { input ->
            Log.e("input", "input:$input")
            val inpputext = editText.text.toString()
            Log.e("input", "inpputext:$inpputext")

            if (input == null || input.isEmpty()) {
                btnSend.visibility = View.GONE
                val params = inputLayout.layoutParams
                params.width = LayoutParams.MATCH_PARENT
                params.height = LayoutParams.MATCH_PARENT
                inputLayout.layoutParams = params
                input_flag = false
            } else {
                if (!input_flag) {//0.77

                    val params = inputLayout.layoutParams
                    params.width = 751
                    params.height = LayoutParams.MATCH_PARENT
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

        setOnDismissListener {
            activity.window.run {
                attributes.alpha = 1.0f
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
        }

        btnFace.setOnClickListener {
            listener.openEmoji(editText)
            mHandler.postDelayed({
                emojiView?.visibility = View.VISIBLE
            }, 200)
        }
    }

    fun setBackDark(): ShortBottoomPopuWindow {
        //设置背景变暗
        activity.window.run {
            attributes.alpha = 0.7f //代表透明程度，范围为0 - 1.0f
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return this
    }

    fun onShow(view: View) {
        editText.requestFocus()
        editText.showSoftInputOnFocus = true

        animationStyle = R.style.style_vertical_video_animation
        Log.e("keyBoardManager", "onShow")
        isOutsideTouchable = true
        //要在底部加入表情view，所以将位置从中间移动到底部
        showAtLocation(view, Gravity.CENTER, 0, 165)
//        showAtLocation(view, Gravity.BOTTOM, 0, 0)
    }

    fun clear() {
        editText.text = null
    }

    //bug:重写dismiss，解决一些问题
    override fun dismiss() {
//        val view = activity.currentFocus
//        if (view is AppCompatEditText) {
//            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//            if (activity.currentFocus != null) {
//                imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0);
//            }
//        }
        super.dismiss()
        emojiView?.visibility = View.GONE
        listener.dissmiss(editText.text.toString())
    }

    interface ShortPopuListener {

        fun openEmoji(view: View)

        fun sendComment(comment: String)

        fun dissmiss(comment: String)
    }
}