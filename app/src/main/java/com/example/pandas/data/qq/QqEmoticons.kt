package com.example.pandas.data.qq

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.ui.view.EmoticonSpan
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * @description: QqEmoticons
 * @author: dongyiming
 * @date: 12/5/22 6:01 PM
 * @version: v1.0
 */
public object QqEmoticons {

    fun parseAndShowEmotion(context: Context,message: String): SpannableStringBuilder {
        val spannableString = SpannableStringBuilder(message)
        if (message.contains("[:")) {
            //a.+?b匹配最短的以a开始b结束的字符串，但ab中间至少要有一个字符,+表示一到多个
            //a.*?b匹配最短的以a开始b结束的字符串，但ab中间可以没有字符
            val pstr = "\\[.+?]"
            //val pstr = "\\[:.+?\\]"
            val pattern: Pattern = Pattern.compile(pstr)
            val matcher: Matcher = pattern.matcher(message)
            while (matcher.find()) {
                val emotionName = matcher.group()
                if (qqEmoticonHashMap.contains(emotionName)) {
                    val res = qqEmoticonHashMap[emotionName]
                    val drawable = ContextCompat.getDrawable(context, res!!)
                    drawable?.let {
                        //setSpan()方法用图片替换掉"emoji"，这个"emoji"可以随意写，这里用emotionName代替
                        it.setBounds(0, 0, 65, 65)
                        val imageSpan = EmoticonSpan(it)
                        val end = spannableString.length
                        spannableString.setSpan(
                            imageSpan,
                            matcher.start(),
                            matcher.end(),
                            //bug:解决两个ImageSpan之中无法插入文字
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            //Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                        )
                    }
                }
            }
        }
        return spannableString
    }

    fun disposeText(message: String): SpannableStringBuilder? {   //text:需要替换的句子
        //使用SpannableString
        val newText = SpannableStringBuilder(message)
        //匹配所有带有[]的词语
        val pattern: Pattern = Pattern.compile("\\[.+?\\]")
        val matcher: Matcher = pattern.matcher(message)
        //循环匹配结果
//        while (matcher.find()) {
//            //如果emojiList含有，进行替换
//            if (EmojiDate.emojiList.get(matcher.group()) != null) {
//                //下面代码可以用更下面的那部分代码替换
//                val bitmap: Bitmap = BitmapFactory.decodeResource(
//                    context.resources,
//                    EmojiDate.emojiList.get(matcher.group())
//                )
//                //需要传递进文字的大小，更好的确定表情的大小
//                val scaleBitmap: Bitmap =
//                    Bitmap.createScaledBitmap(bitmap, textSize * 15 / 10, textSize * 15 / 10, true)
//                val span = ImageSpan(context, scaleBitmap)
//                newText.setSpan(
//                    span,
//                    matcher.start(),
//                    matcher.end(),
//                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE
//                )
//            }
//        }
        return newText
    }

    fun convertEmotion2String(context: Context, data: EmotionItem): SpannableStringBuilder? {

        val drawable = ContextCompat.getDrawable(context, data.emotionIcon)
        drawable?.let {
            //setSpan()方法用图片替换掉"emoji"，这个"emoji"可以随意写，这里用emotionName代替
            val spannableString = SpannableStringBuilder(data.emotionName)
            it.setBounds(0, 0, 65, 65)
            val imageSpan = EmoticonSpan(it)
            val end = spannableString.length
            spannableString.setSpan(
                imageSpan,
                0,
                end,
                //bug:解决两个ImageSpan之中无法插入文字
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                //Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            return spannableString
        }
        Log.e(AppInfos.DEBUG_LOG_TAG, "EmotionItem has no data, please check it")
        return null
    }

    val hotEmoticonHashMap = mutableListOf(
        EmotionItem("[:ebr]", R.mipmap.ebr),
        EmotionItem("[:ebs]", R.mipmap.ebs),
        EmotionItem("[:ebg]", R.mipmap.ebg),
        EmotionItem("[:ecc]", R.mipmap.ecc),
        EmotionItem("[:ecb]", R.mipmap.ecb),
        EmotionItem("[:ecg]", R.mipmap.ecg),
        EmotionItem("[:ecd]", R.mipmap.ecd),
        EmotionItem("[:ecy]", R.mipmap.ecy),
    )

    val sQqEmoticonHashMap = mutableListOf(
        EmotionItem("[:ecf]", R.mipmap.ecf),
        EmotionItem("[:ecv]", R.mipmap.ecv),
        EmotionItem("[:ecb]", R.mipmap.ecb),
        EmotionItem("[:ecy]", R.mipmap.ecy),
        EmotionItem("[:ebu]", R.mipmap.ebu),
        EmotionItem("[:ebr]", R.mipmap.ebr),
        EmotionItem("[:ecc]", R.mipmap.ecc),
        EmotionItem("[:eft]", R.mipmap.eft),
        EmotionItem("[:ecr]", R.mipmap.ecr),
        EmotionItem("[:ebs]", R.mipmap.ebs),
        EmotionItem("[:ech]", R.mipmap.ech),
        EmotionItem("[:ecg]", R.mipmap.ecg),
        EmotionItem("[:ebh]", R.mipmap.ebh),
        EmotionItem("[:ebg]", R.mipmap.ebg),
        EmotionItem("[:ecp]", R.mipmap.ecp),
        EmotionItem("[:deg]", R.mipmap.deg),
        EmotionItem("[:ecd]", R.mipmap.ecd),
        EmotionItem("[:ecj]", R.mipmap.ecj),
        EmotionItem("[:ebv]", R.mipmap.ebv),
        EmotionItem("[:ece]", R.mipmap.ece),
        EmotionItem("[:ebl]", R.mipmap.ebl),
        EmotionItem("[:eca]", R.mipmap.eca),
        EmotionItem("[:ecn]", R.mipmap.ecn),
        EmotionItem("[:eco]", R.mipmap.eco),
        EmotionItem("[:eeo]", R.mipmap.eeo),
        EmotionItem("[:eep]", R.mipmap.eep),
        EmotionItem("[:eci]", R.mipmap.eci),
        EmotionItem("[:ebj]", R.mipmap.ebj),
        EmotionItem("[:eer]", R.mipmap.eer),
        EmotionItem("[:edi]", R.mipmap.edi),
        EmotionItem("[:ebq]", R.mipmap.ebq),
        EmotionItem("[:eeq]", R.mipmap.eeq),
        EmotionItem("[:ecq]", R.mipmap.ecq),
        EmotionItem("[:ebt]", R.mipmap.ebt),
        EmotionItem("[:ede]", R.mipmap.ede),
        EmotionItem("[:eew]", R.mipmap.eew),
        EmotionItem("[:eex]", R.mipmap.eex),
        EmotionItem("[:dga]", R.mipmap.dga),
        EmotionItem("[:ebp]", R.mipmap.ebp),
        EmotionItem("[:ebo]", R.mipmap.ebo)
    )

    val qqEmoticonHashMap = hashMapOf(
        "[:ecf]" to R.mipmap.ecf,
        "[:ecv]" to R.mipmap.ecv,
        "[:ecb]" to R.mipmap.ecb,
        "[:ecy]" to R.mipmap.ecy,
        "[:ebu]" to R.mipmap.ebu,
        "[:ebr]" to R.mipmap.ebr,
        "[:ecc]" to R.mipmap.ecc,
        "[:eft]" to R.mipmap.eft,
        "[:ecr]" to R.mipmap.ecr,
        "[:ebs]" to R.mipmap.ebs,
        "[:ech]" to R.mipmap.ech,
        "[:ecg]" to R.mipmap.ecg,
        "[:ebh]" to R.mipmap.ebh,
        "[:ebg]" to R.mipmap.ebg,
        "[:ecp]" to R.mipmap.ecp,
        "[:deg]" to R.mipmap.deg,
        "[:ecd]" to R.mipmap.ecd,
        "[:ecj]" to R.mipmap.ecj,
        "[:ebv]" to R.mipmap.ebv,
        "[:ece]" to R.mipmap.ece,
        "[:ebl]" to R.mipmap.ebl,
        "[:eca]" to R.mipmap.eca,
        "[:ecn]" to R.mipmap.ecn,
        "[:eco]" to R.mipmap.eco,
        "[:eeo]" to R.mipmap.eeo,
        "[:eep]" to R.mipmap.eep,
        "[:eci]" to R.mipmap.eci,
        "[:ebj]" to R.mipmap.ebj,
        "[:eer]" to R.mipmap.eer,
        "[:edi]" to R.mipmap.edi,
        "[:ebq]" to R.mipmap.ebq,
        "[:eeq]" to R.mipmap.eeq,
        "[:ecq]" to R.mipmap.ecq,
        "[:ebt]" to R.mipmap.ebt,
        "[:ede]" to R.mipmap.ede,
        "[:eew]" to R.mipmap.eew,
        "[:eex]" to R.mipmap.eex,
        "[:dga]" to R.mipmap.dga,
        "[:ebp]" to R.mipmap.ebp,
        "[:ebo]" to R.mipmap.ebo
    )
}