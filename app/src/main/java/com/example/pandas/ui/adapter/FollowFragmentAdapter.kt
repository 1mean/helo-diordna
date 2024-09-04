package com.example.pandas.ui.adapter

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
import com.example.pandas.R
import com.example.pandas.biz.ext.loadCircleImage

/**
 * @description: FollowFragmentAdapter
 * @author: dongyiming
 * @date: 5/10/22 3:16 下午
 * @version: v1.0
 */
public class FollowFragmentAdapter(
    private val list: MutableList<User>,
    private val followViewClick: (position: Int, userCode: Int) -> Unit,
    private val unFollowViewClick: (position: Int, userCode: Int) -> Unit
) :
    BaseCommonAdapter<User>(list) {

    private var vipColor: Int? = null
    override fun getLayoutId(): Int = R.layout.adapter_follow

    fun setVipColor(vipColor: Int) {
        this.vipColor = vipColor
    }

    fun updateItem(position: Int, hd: RecyclerView.ViewHolder?) {
        val data = list[position]
        data.reservedInt = 1

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
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_follow)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_follow_name)
        val desc = holder.getWidget<AppCompatTextView>(R.id.txt_follow_desc)
        val follow = holder.getWidget<ConstraintLayout>(R.id.rlayout_follow)
        val followView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_follow)
        val unFollowView = holder.getWidget<LinearLayoutCompat>(R.id.llayout_unfollow)

        data.headUrl?.let {
            loadCircleImage(context, it, cover)
        }
        desc.text = data.signature

        if (data.vip == 1) {
            if (vipColor != null) {
                name.setTextColor(vipColor!!)
            } else {
                name.setTextColor(ContextCompat.getColor(context, R.color.color_tab_text_selected))
            }
        } else {
            name.setTextColor(ContextCompat.getColor(context, R.color.color_txt_follow_name))
        }
        name.text = data.userName

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
            if (data.attention) {
                followViewClick(position, data.userCode)
            } else {
                unFollowViewClick(position, data.userCode)
                data.reservedInt = 0
                follow.setBackgroundResource(R.drawable.shape_follow_followed)
                followView.visibility = View.VISIBLE
                unFollowView.visibility = View.GONE
            }
        }
    }
}