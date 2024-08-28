package com.example.pandas.ui.adapter

import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.example.pandas.bean.CoinsResponse

/**
 * @description: WanAndroidAdapter
 * @author: dongyiming
 * @date: 8/23/24 6:19 PM
 * @version: v1.0
 */
public class IntegralAdapter(private val list: MutableList<CoinsResponse.Data.CoinInfo> = mutableListOf()) :
    BaseCommonAdapter<CoinsResponse.Data.CoinInfo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_item_integral

    override fun convert(
        holder: BaseViewHolder,
        data: CoinsResponse.Data.CoinInfo,
        position: Int
    ) {
        val date = holder.getWidget<AppCompatTextView>(R.id.txt_integral_date)
        val reason = holder.getWidget<AppCompatTextView>(R.id.txt_integral_reason)
        val content = holder.getWidget<AppCompatTextView>(R.id.txt_integral_content)
        val integralInfo = holder.getWidget<AppCompatTextView>(R.id.txt_integral_info)

        date.text = TimeUtils.formatTime(data.date)
        reason.text = "成功" + data.reason
        val list = data.desc.split("：")
        if (list.size > 1) {
            content.text = "${data.reason}积分：${list.last()}"
        }
        integralInfo.text = "+${data.coinCount}"
    }
}