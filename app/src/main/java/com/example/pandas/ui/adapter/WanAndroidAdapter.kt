package com.example.pandas.ui.adapter

import android.content.Intent
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.R
import com.example.pandas.bean.WxPageArticleResponse
import com.example.pandas.ui.activity.WanContentActivity

/**
 * @description: WanAndroidAdapter
 * @author: dongyiming
 * @date: 8/23/24 6:19 PM
 * @version: v1.0
 */
public class WanAndroidAdapter(
    list: MutableList<WxPageArticleResponse.Data.WxPageArticle> = mutableListOf(),
    private val collect: (id: Int) -> Unit,
    private val removeCollect: (id: Int, originId: Int) -> Unit
) :
    BaseCommonAdapter<WxPageArticleResponse.Data.WxPageArticle>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_wanandroid

    override fun convert(
        holder: BaseViewHolder,
        data: WxPageArticleResponse.Data.WxPageArticle,
        position: Int
    ) {
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_wanandroid_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_wanandroid_name)
        val wxcode = holder.getWidget<AppCompatTextView>(R.id.txt_wxcode)
        val date = holder.getWidget<AppCompatTextView>(R.id.txt_wanandroid_date)
        val type = holder.getWidget<AppCompatTextView>(R.id.txt_wanandroid_type)
        val loveImg = holder.getWidget<AppCompatImageView>(R.id.img_wanandroid_love)

        //title.text = Html.fromHtml(data.title)
        title.text = Html.fromHtml(data.title, FROM_HTML_MODE_LEGACY, null, null)

        if (data.shareUser.isNotEmpty()) {
            name.text = data.shareUser
        } else {
            name.text = data.author
        }

        if (data.collect) {
            loveImg.setImageResource(R.mipmap.img_music_item_liked1)
        } else {
            loveImg.setImageResource(R.mipmap.img_music_item_like1)
        }

        if (data.superChapterName.isNotEmpty() && data.superChapterName == "公众号") {
            wxcode.visibility = View.VISIBLE
        } else {
            wxcode.visibility = View.GONE
        }

        date.text = data.niceDate
        type.text = data.superChapterName + " • " + data.chapterName

        loveImg.setOnClickListener {
            if (data.collect) {
                loveImg.setImageResource(R.mipmap.img_music_item_like1)
                removeCollect(data.id, -1)
            } else {
                loveImg.setImageResource(R.mipmap.img_music_item_liked1)
                collect(data.id)
            }
            data.collect = !data.collect
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, WanContentActivity::class.java)
            intent.putExtra("url", data.link)
            holder.itemView.context.startActivity(intent)
        }
    }
}