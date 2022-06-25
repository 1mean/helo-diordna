import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: HotFragmentAdapter
 * @author: dongyiming
 * @date: 4/20/22 11:27 下午
 * @version: v1.0
 */
public class HotFragmentAdapter(list: MutableList<PetVideo>) : BaseCommonAdapter<PetVideo>(list) {

    private val max = 1 * 1000 * 1000 * 2
    private val th = 1 * 1000 * 1000

    override fun getLayoutId(): Int = R.layout.adapter_hot_fragment

    override fun convert(holder: BaseViewHolder, data: PetVideo, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_hot_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_hot_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_hot_title)
        val tag = holder.getWidget<AppCompatTextView>(R.id.txt_hot_tag)
        val author = holder.getWidget<AppCompatTextView>(R.id.txt_hot_author)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_hot_video_counts)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_hot_time)

        data.cover?.let {
            loadRoundedCornerImage(context, 10, it, cover)
        }
        duration.text = TimeUtils.getDuration(data.duration.toLong())
        title.text = data.title
        tag.text = "百万播放"

        val rCounts = (1..max).random()
        val rCountsString = NumUtils.getShortNum(rCounts)
        playCounts.text = rCountsString
        if (rCounts >= th) {
            tag.visibility = View.VISIBLE
        } else {
            tag.visibility = View.GONE
        }

        data.user?.let {
            author.text = it.userName
        }

        data.releaseTime?.let {
            val subTime = it.substring(5, 10)
            time.text = StringBuilder("- ").append(subTime).toString()
        }
        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code,false)
        }
    }

}