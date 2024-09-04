package com.example.pandas.ui.adapter

import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.android_sqlite.entity.User
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.utils.StringColorUtil
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.ui.ext.startUserInfoActivity
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @description: SearchUserAdapter
 * @author: dongyiming
 * @date: 9/2/24 12:44 PM
 * @version: v1.0
 */
public class SearchUserAdapter(
    private val list: MutableList<User> = mutableListOf(),
    private val listener: (position: Int, userCode: Int, isFollow: Boolean) -> Unit
) : BaseCommonAdapter<User>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_follow

    fun updateItem(position: Int, hd: RecyclerView.ViewHolder?) {
        val data = list[position]
        data.attention = false

        hd?.let {
            val followView =
                it.itemView.findViewById<LinearLayoutCompat>(R.id.llayout_follow)
            val unFollowView =
                it.itemView.findViewById<LinearLayoutCompat>(R.id.llayout_unfollow)
            val follow =
                it.itemView.findViewById<ConstraintLayout>(R.id.rlayout_follow)
            followView.visibility = View.GONE
            unFollowView.visibility = View.VISIBLE
            follow.setBackgroundResource(R.drawable.shape_follow_unfollowed)
        }
    }

    override fun convert(holder: BaseViewHolder, data: User, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<CircleImageView>(R.id.img_follow)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_follow_name)
        val desc = holder.getWidget<AppCompatTextView>(R.id.txt_follow_desc)
        val follow = holder.getWidget<ConstraintLayout>(R.id.rlayout_follow)
        val followView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_follow)
        val unFollowView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_unfollow)

        data.headUrl?.let {
            loadImage(context, it, cover)
        }
        if (data.signature == null || data.signature!!.isEmpty()) {
            desc.text = data.userName
        } else {
            desc.text = data.signature
        }

        data.userName?.let {
            name.text = it
        }

        if (data.attention) {//已经关注
            follow.setBackgroundResource(R.drawable.shape_follow_followed)
            followView.visibility = View.VISIBLE
            unFollowView.visibility = View.GONE
        } else {
            follow.setBackgroundResource(R.drawable.shape_follow_unfollowed)
            followView.visibility = View.GONE
            unFollowView.visibility = View.VISIBLE
        }

        follow.setOnClickListener {
            if (!data.attention) {
                listener.invoke(position, data.userCode, true)
                follow.setBackgroundResource(R.drawable.shape_follow_followed)
                followView.visibility = View.VISIBLE
                unFollowView.visibility = View.GONE
                data.attention = !data.attention
            } else {
                listener.invoke(position, data.userCode, false)
                follow.setBackgroundResource(R.drawable.shape_follow_followed)
                followView.visibility = View.VISIBLE
                unFollowView.visibility = View.GONE
            }
        }

        holder.itemView.setOnClickListener {
            startUserInfoActivity(context, data.userCode)
        }
    }
}