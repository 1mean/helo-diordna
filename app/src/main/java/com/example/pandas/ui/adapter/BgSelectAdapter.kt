import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder

/**
 * @description: BgSelectAdapter
 * @author: dongyiming
 * @date: 6/20/23 6:27 PM
 * @version: v1.0
 */
public class BgSelectAdapter(
    private val list: MutableList<String> = mutableListOf(),
    private var status: Int = 0,
    private val listener: ItemClickListener
) :
    BaseCommonAdapter<String>(list) {

    fun refreshAdapter(data: MutableList<String>, status: Int) {
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

    override fun getLayoutId(): Int = R.layout.adapter_bg_selected

    override fun convert(holder: BaseViewHolder, data: String, position: Int) {

        val context = holder.itemView.context
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_bg_seleted)
        val selectedView = holder.getWidget<AppCompatImageView>(R.id.img_bg_selected)
        val bgView = holder.getWidget<View>(R.id.view_selected)
        val outerView = holder.getWidget<ConstraintLayout>(R.id.clayout_bg_outer)

        val bgRes =
            arrayOf(
                R.drawable.shape_bg_white,
                R.drawable.shape_bg_pink,
                R.drawable.shape_bg_black,
                R.drawable.shape_bg_red,
                R.drawable.shape_bg_yellow,
                R.drawable.shape_bg_grey,
                R.drawable.shape_bg_blue,
                R.drawable.shape_bg_purple,
                R.drawable.shape_bg_sky,
            )
        name.text = data
        bgView.setBackgroundResource(bgRes[position])

        if (status == position) {
            selectedView.visibility = View.VISIBLE
            outerView.setBackgroundResource(R.drawable.shape_bg_outer)
        } else {
            selectedView.visibility = View.GONE
            outerView.background = null
        }

        holder.itemView.setOnClickListener {
            if (position == status) {
                return@setOnClickListener
            }
            listener.itemClick(position)
        }
    }

    interface ItemClickListener {
        fun itemClick(position: Int)
    }

}