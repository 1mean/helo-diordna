import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @description: HotTopItemAdapter
 * @author: dongyiming
 * @date: 5/28/23 1:45 AM
 * @version: v1.0
 */
public class HotTopItemAdapter(list:MutableList<String>):BaseCommonAdapter<String>(list) {
    override fun getLayoutId(): Int = R.layout.item_adapter_hot_top

    override fun convert(holder: BaseViewHolder, data: String, position: Int) {

        val image = holder.getWidget<CircleImageView>(R.id.img_hot_top_item)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_hot_top_item)

        title.text = data
    }

}