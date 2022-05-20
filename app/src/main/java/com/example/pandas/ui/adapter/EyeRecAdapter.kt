import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.eyes.EyepetozerItem
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.utils.TimeUtils

/**
 * @description: EyeRecAdapter
 * @author: dongyiming
 * @date: 4/8/22 11:41 下午
 * @version: v1.0
 */
public class EyeRecAdapter(list: MutableList<EyepetozerItem>) :
    BaseCommonAdapter<EyepetozerItem>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_eye_item

    override fun convert(holder: BaseViewHolder, data: EyepetozerItem, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_eye_item_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_eye_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_eye_item_name)
        val tag = holder.getWidget<AppCompatTextView>(R.id.txt_eye_item_tag)

        data.coverUrl?.let {
            loadRoundedCornerImage(context, 10, it, cover)
        }
        duration.text = TimeUtils.getMMDuration(data.duration.toLong())
        data.title?.let {
            title.text = it
        }
        data.category?.let {
            tag.text = StringBuilder("#").append(it).toString()
        }
    }

}