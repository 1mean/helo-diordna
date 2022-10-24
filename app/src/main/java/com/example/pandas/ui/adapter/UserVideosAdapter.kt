import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.VideoAndData
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: UserVideosAdapter
 * @author: dongyiming
 * @date: 4/22/22 10:46 下午
 * @version: v1.0
 */
public class UserVideosAdapter(list: MutableList<VideoAndData>) :
    BaseCommonAdapter<VideoAndData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_user_video_list

    override fun convert(holder: BaseViewHolder, data: VideoAndData, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_user_list_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_name)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_time)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_user_video_playcounts)
        val more = holder.getWidget<ConstraintLayout>(R.id.item_user_video_more)

        val video = data.video
        loadCenterRoundedCornerImage(context, 10, video.cover, cover)
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        title.text = video.title

        if (data.videoData == null) {
            counts.text = "0"
        } else {
            counts.text = NumUtils.getShortNum(data.videoData.plays)
        }

        time.text = TimeUtils.parseTime(video.releaseTime)

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }

        more.setOnClickListener {
            Toast.makeText(context, "更多", Toast.LENGTH_SHORT).show()
        }
    }
}