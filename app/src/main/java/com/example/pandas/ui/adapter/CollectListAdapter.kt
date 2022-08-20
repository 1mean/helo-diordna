package com.example.pandas.ui.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.utils.TimeUtils

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 8/19/22 11:11 上午
 * @version: v1.0
 */
public class CollectListAdapter(
    private val list: MutableList<PetVideo> = mutableListOf(),
    private val listener: CollectListListener
) :
    BaseCommonAdapter<PetVideo>(list) {

    private var isShow: Boolean = false

    interface CollectListListener {

    }

    override fun getLayoutId(): Int = R.layout.adapter_collect_list

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {


        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_collect_item_cover)
        val select = holder.getWidget<AppCompatImageView>(R.id.ibn_collect_item_select)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_collect_item_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_collect_item_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_collect_item_name)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_collect_item_counts)
        val comments = holder.getWidget<AppCompatTextView>(R.id.txt_collect_item_comment)
        val loadMoreLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_collect_item_more)

        data.videoData?.let {

            playCounts.text = it.plays.toString()

            val commentCounts = it.comments
            if (commentCounts > 0) {
                comments.text = commentCounts.toString()
            } else {
                comments.text = " - "
            }
        }

        if (isShow) {
            select.visibility = View.VISIBLE
        } else {
            select.visibility = View.GONE
        }

        if (data.booleanFlag) {
            select.setImageResource(R.mipmap.img_history_selected)
        } else {
            select.setImageResource(R.mipmap.img_history_unselect)
        }

        loadCenterRoundedCornerImage(context, 15, data.cover, cover)
        duration.text = TimeUtils.getDuration(data.duration.toLong())

        title.text = data.title

        data.user?.let {
            name.text = it.userName
        }


    }

}