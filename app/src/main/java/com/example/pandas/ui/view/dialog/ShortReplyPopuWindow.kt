package com.example.pandas.ui.view.dialog

import android.animation.ObjectAnimator
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
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
import com.lxj.xpopup.util.KeyboardUtils

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
public class ShortReplyPopuWindow(private val mContext: Context) : BottomPopupView(mContext) {


    private var inputStr: String? = null
    private var listener: CommentInputListener? = null
    private var _binding: DialogBottomCommentBinding? = null
    val binding: DialogBottomCommentBinding get() = _binding!!

    constructor(
        context: Context,
        inputStr: String,
        listener: CommentInputListener
    ) : this(context) {
        this.inputStr = inputStr
        this.listener = listener
    }

    override fun getImplLayoutId(): Int = R.layout.dialog_vertical_input

    private lateinit var faceRecyclerView: RecyclerView
    private lateinit var emojiView: RecyclerView
    private lateinit var inputLayout: ConstraintLayout
    private lateinit var editInput: AppCompatEditText
    private lateinit var btnFace: AppCompatImageButton
    private lateinit var btnSend: AppCompatButton

    private var input_flag = false

    override fun onCreate() {
        super.onCreate()

        faceRecyclerView = findViewById(R.id.rv_short_input_face)
        emojiView = findViewById(R.id.clayout_short_input_emoji)
        inputLayout = findViewById(R.id.clayout_comment_input)
        editInput = findViewById(R.id.edit_vertical_input)
        btnFace = findViewById(R.id.btn_short_input_face)
        btnSend = findViewById(R.id.btn_short_send)

        initEmoji()

        btnFace.setOnClickListener {

            KeyboardUtils.hideSoftInput(emojiView)
            emojiView.postDelayed({
                //SoftInputUtils.hideSoftInput(emojiView)
                emojiView.visibility = View.VISIBLE
            }, 200)
        }

        editInput.setOnClickListener {
            if (emojiView.isVisible) {
                emojiView.visibility = View.GONE
            }
        }

        if (inputStr != null) {
            editInput.hint = "回复 @$inputStr :"
        }

        editInput.addTextChangedListener { input ->
            Log.e("input", "input:$input")
            val inpputext = editInput.text.toString()
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
                    params.width = 751
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
        btnSend.setOnClickListener {
            listener?.sendComment(editInput.text.toString())
            dismiss()
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

    override fun onShow() {
        super.onShow()
    }

    fun getComment(): String {
        return editInput.text.toString()
    }

    interface CommentInputListener {
        fun sendComment(message: String)
    }
}