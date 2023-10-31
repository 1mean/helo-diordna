import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.sql.entity.VideoAndData
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.ui.view.dialog.MoreBottomSheetDialog
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

    override fun getLayoutId(): Int = R.layout.item_video_intro

    override fun convert(holder: BaseViewHolder, data: VideoAndData, position: Int) {

        var dialog: MoreBottomSheetDialog? = null

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_video_reco_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_video_reco_name)
        val playCounts = holder.getWidget<AppCompatTextView>(R.id.txt_video_info_counts)
        val comments = holder.getWidget<AppCompatTextView>(R.id.txt_video_info_comment)
        val loadMoreLayout = holder.getWidget<ConstraintLayout>(R.id.clayout_video_info_more)

        val video = data.video
        val videoData = data.videoData
        video.cover?.let {
            //loadRoundedCornerImage(context, 15, it, cover)
            //loadCenterRoundedCornerImage(context, 15, it, cover)
            loadCenterImage(context, it, cover)
        }
        duration.text = TimeUtils.getDuration(video.duration.toLong())
        title.text = video.title
        data.video.user?.let {
            name.text = it.userName
        }
        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(context, video)
        }

        loadMoreLayout.setOnClickListener {
            if (dialog == null) {
                dialog = MoreBottomSheetDialog(context, object : ItemClickListener<Int> {
                    override fun onItemClick(t: Int) {
                    }
                })
            }
            dialog!!.onShow()
        }

        if (videoData == null) {
            playCounts.text = "播放 0"
            comments.text = " - 评论 0"
        } else {
            playCounts.text = "播放 ${videoData.plays.toString()}"
            val counts = videoData.comments
            if (counts == 0) {
                comments.text = " - 评论 0"
            } else {
                comments.text = " - 评论 ${counts.toString()}"
            }
        }
    }
}