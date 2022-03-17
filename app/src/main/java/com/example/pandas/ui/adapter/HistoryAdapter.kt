import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.HistoryItem
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity

/**
 * @description: HistoryAdapter
 * @author: dongyiming
 * @date: 3/11/22 12:37 上午
 * @version: v1.0
 */
public class HistoryAdapter(private val list: MutableList<HistoryItem>) :
    BaseCommonAdapter<HistoryItem>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_history_item

    override fun convert(holder: BaseViewHolder, data: HistoryItem, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_history_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_history_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_history_name)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_history_time)

        val history = data.history
        val video = data.video
        if (history != null && video != null) {

            loadRoundedCornerImage(context, 15, video.cover, cover)
            title.text = video.title
            duration.text = TimeUtils.getTime(history.lastTime)
            time.text = TimeUtils.getTime(history.lastTime)

            val position = history.playPosition
            val videoDuration = TimeUtils.getMMDuration(video.duration.toLong())

            if (position != null) {
                duration.text =
                    StringBuilder(position).append(" / ").append(videoDuration).toString()
            }
            holder.itemView.setOnClickListener {
                startVideoPlayActivity(context, video.code)
            }
        }
    }

}