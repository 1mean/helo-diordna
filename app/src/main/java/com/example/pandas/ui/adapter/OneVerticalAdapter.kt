import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: OneVerticalAdapter
 * @author: dongyiming
 * @date: 7/16/23 7:07 PM
 * @version: v1.0
 */
public class OneVerticalAdapter(list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    private val max = 1 * 1000 * 1000 * 2

    override fun getLayoutId(): Int = R.layout.adapter_one_vertical

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val mContext = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_one_cover)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_one_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_one_name)
        val info = holder.getWidget<AppCompatTextView>(R.id.txt_one_info)
        val desc = holder.getWidget<AppCompatTextView>(R.id.txt_bottom_desc)

        val video = data.video
        val user = data.user

        name.text = user.userName
        video.cover?.let {
            loadCenterRoundedCornerImage(mContext, 10, it, cover)
        }
        desc.text = user.signature
        title.text = video.title

        val duration = TimeUtils.getStringDate4(video.releaseTime)
        val rCounts = (1..max).random()
        val rCountsString = NumUtils.getShortNum(rCounts)
        info.text = StringBuilder("$rCountsString 观看").append(" · ").append(duration).toString()

        holder.itemView.setOnClickListener {
            startVideoPlayingActivity(mContext, video)
        }
    }

}