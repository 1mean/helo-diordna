import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.utils.NumUtils
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: OneVerticalAdapter
 * @author: dongyiming
 * @date: 7/16/23 7:07 PM
 * @version: v1.0
 */
public class OneVertical2Adapter(list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    private val max = 1 * 1000 * 1000 * 2

    override fun getLayoutId(): Int = R.layout.adapter_one_vertical2

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val mContext = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_video_list_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_author)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_video)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_time)

        val video = data.video
        val user = data.user

        video.cover?.let {
            loadCenterImage(mContext, it, cover)
        }
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        title.text = video.title
        name.text = user.userName

        val rCounts = (1..max).random()
        val rCountsString = NumUtils.getShortNum(rCounts)
        counts.text = rCountsString

        val parseTime = TimeUtils.descriptiveData(video.releaseTime)
        time.text = StringBuilder("- ").append(parseTime).toString()

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(mContext, video)
        }
    }

}