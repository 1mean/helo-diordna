import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.ui.activity.RankingActivity
import com.example.pandas.ui.ext.startAnyActivity

/**
 * @description: HotTopItemAdapter
 * @author: dongyiming
 * @date: 5/28/23 1:45 AM
 * @version: v1.0
 */
public class HotTopItemAdapter(list: MutableList<String>) : BaseCommonAdapter<String>(list) {
    override fun getLayoutId(): Int = R.layout.item_adapter_hot_top

    override fun convert(holder: BaseViewHolder, data: String, position: Int) {

        val context = holder.itemView.context
        val image = holder.getWidget<AppCompatImageView>(R.id.img_hot_top_item)
        val item = holder.getWidget<ConstraintLayout>(R.id.clayout_hot_top_item)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_hot_top_item)

        if (data == "播放榜") {
            image.setImageResource(R.mipmap.img_hot_top1)
            item.setBackgroundResource(R.drawable.shape_bg_top_hot)
        } else if (data == "创作榜") {
            image.setImageResource(R.mipmap.img_hot_top2)
            item.setBackgroundResource(R.drawable.shape_bg_top_hot2)
        } else {
            image.setImageResource(R.mipmap.img_hot_top3)
            item.setBackgroundResource(R.drawable.shape_bg_top_hot3)
        }
        title.text = data

        item.setOnClickListener {
            val intent = Intent(context, RankingActivity::class.java).putExtra("title", data)
            context.startActivity(intent)
        }
    }

}