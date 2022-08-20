package com.example.pandas.ui.adapter

import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.sql.entity.Group
import com.example.pandas.ui.activity.CollectListActivity
import com.example.pandas.ui.view.dialog.DeleteBottomSheetDialog

/**
 * @description: CollectAdapter
 * @author: dongyiming
 * @date: 8/16/22 10:37 上午
 * @version: v1.0
 */
public class CollectAdapter(
    private val list: MutableList<Group> = mutableListOf(),
    private val listener: CollectListener
) :
    BaseCommonAdapter<Group>(list) {

    private var mPos: Int = -1

    fun deleteItem() {
        if (mPos != -1) {
            list.removeAt(mPos)
            notifyItemRemoved(mPos)
            notifyItemRangeChanged(mPos, list.size - mPos)
        }
    }

    override fun getLayoutId(): Int = R.layout.adapter_collect

    override fun convert(holder: BaseViewHolder, data: Group, position: Int) {

        var deleteDialog: DeleteBottomSheetDialog? = null
        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_collect_cover)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_collect_content_counts)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_collect_name)
        val creator = holder.getWidget<AppCompatTextView>(R.id.txt_collect_creator)
        val openView = holder.getWidget<AppCompatTextView>(R.id.txt_collect_open)
        val moreLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_collect_more)

        counts.text = data.videoCounts.toString()

        if (data.groupName == "默认收藏夹") {
            moreLayout.visibility = View.GONE
        } else {
            moreLayout.visibility = View.VISIBLE
        }

        loadCenterRoundedCornerImage(context, 15, data.groupCover, cover)

        creator.text = StringBuilder("创建者：").append(AppInfos.AUTHOR_NAME).toString()

        name.text = data.groupName

        if (data.isOpen) {
            openView.text = "收藏夹 - 公开"
        } else {
            openView.text = "收藏夹 - 私密"
        }

        moreLayout.setOnClickListener {
            if (deleteDialog == null) {
                deleteDialog = DeleteBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                        if (t == 0) {

                            mPos = position
                            listener.deleteGroup(data.groupCode)
                        }
                    }
                })
            }
            deleteDialog!!.onShow()
        }

        holder.itemView.setOnClickListener {

            val intent = Intent(context, CollectListActivity::class.java).apply {
                putExtra("group",data)
            }
            context.startActivity(intent)
        }
    }

    interface CollectListener {
        fun deleteGroup(groupCode: Int)
    }
}