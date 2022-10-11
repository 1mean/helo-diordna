package com.example.pandas.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.ext.startUserInfoActivity

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

        data.headUrl?.let {
            loadCircleImage(context, it, header)
        }

        name.text = data.userName

        holder.itemView.setOnClickListener {
            startUserInfoActivity(context, data)
        }
    }

}