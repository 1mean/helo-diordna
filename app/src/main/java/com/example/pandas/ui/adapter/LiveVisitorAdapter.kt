package com.example.pandas.ui.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.ext.startUserInfoActivity
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @description: LiveVisitorAdapter
 * @author: dongyiming
 * @date: 10/10/22 5:49 下午
 * @version: v1.0
 */
public class LiveVisitorAdapter(list: MutableList<User>) : BaseCommonAdapter<User>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_live_visitor

    override fun convert(holder: BaseViewHolder, data: User, position: Int) {

        val context = holder.itemView.context
        val header = holder.getWidget<AppCompatImageView>(R.id.img_visitor)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_visitor_name)
        val updateView = holder.getWidget<View>(R.id.view_update)

        if (position <= 3 && !data.booleanFlag) {
            updateView.visibility = View.VISIBLE
        } else {
            updateView.visibility = View.GONE
        }

        data.headUrl?.let {
            loadCenterRoundedCornerImage(context, 40, it, header)
        }

        name.text = data.userName

        holder.itemView.setOnClickListener {
            data.booleanFlag = true
            updateView.visibility = View.GONE
            startUserInfoActivity(context, data.userCode)
        }
    }

}