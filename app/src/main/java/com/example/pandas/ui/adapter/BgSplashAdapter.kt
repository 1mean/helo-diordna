import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder

/**
 * @description: BgSelectAdapter
 * @author: dongyiming
 * @date: 6/20/23 6:27 PM
 * @version: v1.0
 */
public class BgSplashAdapter(
    private val list: MutableList<Int> = mutableListOf(),
    private var status: Int = 0,
    private val itemClick: (position: Int) -> Unit
) :
    BaseCommonAdapter<Int>(list) {

    fun refreshAdapter(data: MutableList<Int>, status: Int) {
        if (data.isNotEmpty() && data != list) {
            list.clear()
            list.addAll(data)
            this.status = status
            notifyDataSetChanged()
        }
    }

    fun updateSelect(position: Int) {
        this.status = position
        notifyDataSetChanged()
    }

    override fun getLayoutId(): Int = R.layout.adapter_item_splash

    override fun convert(holder: BaseViewHolder, data: Int, position: Int) {

        val context = holder.itemView.context
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_bg_seleted)
        val splashImg = holder.getWidget<AppCompatImageView>(R.id.img_item_splash)
        val selectedView = holder.getWidget<AppCompatImageView>(R.id.img_bg_selected)

        splashImg.setImageResource(data)
        name.text = AppInfos.splashNames[position]

        if (status == position) {
            selectedView.visibility = View.VISIBLE
            //outerView.setBackgroundResource(R.drawable.shape_bg_outer)
        } else {
            selectedView.visibility = View.GONE
            //outerView.background = null
        }

        holder.itemView.setOnClickListener {
            if (position == status) {
                return@setOnClickListener
            }
            itemClick(position)
        }
    }
}