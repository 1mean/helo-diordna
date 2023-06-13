package com.example.pandas.ui.view.dialog

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.data.qq.EmotionItem
import com.example.pandas.data.qq.QqEmoticons
import com.example.pandas.databinding.DialogBottomCommentBinding
import com.example.pandas.ui.adapter.decoration.ShortEmoji2Decoration
import com.example.pandas.ui.adapter.decoration.ShortEmojiDecoration
import com.lxj.xpopup.core.BottomPopupView

/**
 * <设置圆角和固定高度>
 * - 圆角
 *  - 在oncreate()里设置setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialog)背景透明，不会遮挡圆角
 *  - 设置background圆角
 * - 高度
 *  - 具体数值和设置peekheight都没用，必须是layout里面控件确实填充到这个高度
 *
 *  - show(FragmentManager manager, String tag)
 *  - onCreate
 *  - onCreateDialog(Bundle savedInstanceState)
 *  - onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
 *  - onViewCreated
 *  - onStart
 *  - mDialog.show()
 *  - onResume
 *
 * @description: MoreBottomSheetDialog
 * @author: dongyiming
 * @date: 8/4/22 12:59 下午
 * @version: v1.0
 */
@SuppressLint("ViewConstructor")
public class ShortReplyPopuWindow(
    context: Context,
    private val fromName: String,
    private val listener: CommentInputListener
) : BottomPopupView(context) {


    private var _binding: DialogBottomCommentBinding? = null
    val binding: DialogBottomCommentBinding get() = _binding!!

    override fun getImplLayoutId(): Int = R.layout.dialog_vertical_input

    private lateinit var faceRecyclerView: RecyclerView
    private lateinit var emojiView: RecyclerView
    private lateinit var inputLayout: LinearLayoutCompat
    private lateinit var editInput: AppCompatEditText
    private lateinit var btnFace: AppCompatImageButton
    private lateinit var btnSend: AppCompatButton

    private var isSending = false
    private var input_flag = false
    private var isFaceOpen = false

    override fun onCreate() {
        super.onCreate()

        faceRecyclerView = findViewById(R.id.rv_short_input_face)
        emojiView = findViewById(R.id.clayout_short_input_emoji)
        inputLayout = findViewById(R.id.clayout_short_top)
        editInput = findViewById(R.id.edit_vertical_input)
        btnFace = findViewById(R.id.btn_short_input_face)
        btnSend = findViewById(R.id.btn_short_send)

        initEmoji()

        btnFace.setOnClickListener {
            if (emojiView != null && emojiView.isVisible) {
                return@setOnClickListener
            }
            isFaceOpen = true
            //listener.openEmoji(editText)
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

            emojiView.let {
                it.postDelayed({
                    emojiView.visibility = View.VISIBLE
                }, 300)
            }
        }

        editInput.setOnClickListener {
            if (emojiView.isVisible) {
                emojiView.visibility = View.GONE
            }
        }

        if (fromName.isEmpty()) {
            editInput.hint = resources.getString(R.string.str_hint_edit_short)
        } else {
            editInput.hint = "回复 @$fromName :"
        }

        editInput.addTextChangedListener { input ->
            val inpputext = editInput.text.toString()
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
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT
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
        btnSend.setOnClickListener {
            isSending = true
            listener.sendComment(editInput.text.toString())
            dismiss()
            editInput.postDelayed({
                clearInput()
            }, 200)
        }
    }

    fun updateHint(toUserName: String) {
        if (toUserName.isNotEmpty()) {
            editInput.text = null
            editInput.hint = "回复 @$toUserName :"
        }
    }

    private fun initEmoji() {
        val list = QqEmoticons.hotEmoticonHashMap
        faceRecyclerView.run {
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
                            val startIndex = editInput.selectionStart.coerceAtLeast(0)
                            editInput.text?.insert(startIndex, it)
                        }
                    }
                }
            }
        }
        val images = QqEmoticons.sQqEmoticonHashMap
        emojiView.run {
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
                            val startIndex = editInput.selectionStart.coerceAtLeast(0)
                            editInput.text?.insert(startIndex, it)
                        }
                    }
                }
            }
        }
    }

    fun showEmotion() {
        editInput.requestFocus()
        editInput.isFocusable = true
        isFaceOpen = true
        emojiView.visibility = View.VISIBLE
    }

    fun clearInput() {
        editInput.text = null
        editInput.hint = resources.getString(R.string.str_hint_edit_short)
        btnSend.visibility = View.GONE
    }

    override fun dismiss() {
        super.dismiss()
        isFaceOpen = false
        emojiView.visibility = View.GONE
        listener.dissmiss(editInput.text.toString(), isSending)
        isSending = false
    }

    override fun onShow() {
        super.onShow()
    }

    fun getComment(): String {
        return editInput.text.toString()
    }

    interface CommentInputListener {

        fun sendComment(message: String)

        fun dissmiss(comment: String, isSending: Boolean)
    }
}