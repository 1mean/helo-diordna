import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.SearchInfo
import com.example.pandas.biz.interaction.OnItemSelectedListener

/**
 * @description: list
 * @author: dongyiming
 * @date: 2/20/22 6:15 下午
 * @version: v1.0
 */
public class SearchResultAdapter(
    list: MutableList<SearchInfo>,
    private val listener: OnItemSelectedListener
) :
    BaseCommonAdapter<SearchInfo>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_popu_search

    override fun convert(holder: BaseViewHolder, data: SearchInfo, position: Int) {

        val name = holder.getWidget<AppCompatTextView>(R.id.txt_search_result)
        val color = ContextCompat.getColor(holder.itemView.context, R.color.color_search_text_like)
        name.text = data.title
        holder.itemView.setOnClickListener {
            listener.callback()
        }
    }
}