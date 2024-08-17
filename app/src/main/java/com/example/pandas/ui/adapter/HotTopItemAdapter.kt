import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.ui.activity.OneVerticalListActivity
import com.example.pandas.ui.activity.RankingActivity

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

        when (data) {
            "排行榜" -> {
                image.setImageResource(R.mipmap.img_hot_top1)
                item.setBackgroundResource(R.drawable.shape_bg_top_hot)
            }
            "创作榜" -> {
                image.setImageResource(R.mipmap.img_hot_top2)
                item.setBackgroundResource(R.drawable.shape_bg_top_hot2)
            }
            "热搜榜" -> {
                image.setImageResource(R.mipmap.img_hot_top3)
                item.setBackgroundResource(R.drawable.shape_bg_top_hot3)
            }
            else -> {
                image.setImageResource(R.mipmap.img_hot_top4)
                item.setBackgroundResource(R.drawable.shape_bg_top_hot4)
            }
        }
        title.text = data

        item.setOnClickListener {

            when (data) {
                "排行榜" -> {
                    val intent =
                        Intent(context, RankingActivity::class.java).putExtra("title", data)
                    context.startActivity(intent)
                }
                "每周必看" -> {
                    val intent =
                        Intent(context, OneVerticalListActivity::class.java).putExtra("title", data)
                    context.startActivity(intent)
                }
                "创作榜" -> {
                    val intent =
                        Intent(context, OneVerticalListActivity::class.java).putExtra("title", data)
                    context.startActivity(intent)
                }
                else -> {
                    val intent =
                        Intent(context, RankingActivity::class.java).putExtra("title", data)
                    context.startActivity(intent)
                }
            }
        }
    }

}