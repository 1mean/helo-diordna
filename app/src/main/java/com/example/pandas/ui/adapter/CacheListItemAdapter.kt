import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.CachaListItem
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.ui.activity.ListActivity

/**
 * @description: CacheListItemAdapter
 * @author: dongyiming
 * @date: 7/14/22 1:03 下午
 * @version: v1.0
 */
public class CacheListItemAdapter(list: MutableList<CachaListItem>) :
    BaseCommonAdapter<CachaListItem>(list) {

    override fun getLayoutId(): Int = R.layout.item_adapter_cache_list

    override fun convert(holder: BaseViewHolder, data: CachaListItem, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cache_item)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_cache_item_title)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_cache_item_counts)

        loadCenterRoundedCornerImage(context, 20, data.url, cover)
        name.text = data.name
        counts.text = data.counts.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context,ListActivity::class.java).apply {
                putExtra("localFilePath",data.localFilePath)
                putExtra("title",data.name)
            }
            context.startActivity(intent)
        }
    }

}