import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.android.android_sqlite.entity.VideoAndUser
import com.android.base.utils.NumUtils
import com.android.base.utils.TimeUtils
import com.example.pandas.R
import com.android.base.ui.adapter.BaseCommonAdapter
import com.android.base.ui.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: OneVerticalAdapter
 * @author: dongyiming
 * @date: 7/16/23 7:07 PM
 * @version: v1.0
 */
public class OneVerticalAdapter(list: MutableList<VideoAndUser>, private val titleStr: String) :
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
        val infoImg = holder.getWidget<AppCompatImageView>(R.id.img_info_one_vertical)

        val video = data.video
        val user = data.user

        name.text = user.userName
        video.cover?.let {
            loadCenterRoundedCornerImage(mContext, 10, it, cover)
        }

        if (titleStr == "每周必看") {
            infoImg.setImageResource(R.mipmap.img_one_info_purple)
        } else {
            infoImg.setImageResource(R.mipmap.img_one_info_yellow)
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