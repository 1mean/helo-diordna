import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.sql.entity.VideoAndUser
import com.example.pandas.utils.TimeUtils

/**
 * @description: ListAdapter
 * @author: dongyiming
 * @date: 7/16/22 4:46 下午
 * @version: v1.0
 */
public class ListAdapter(val list: MutableList<VideoAndUser>) :
    BaseCommonAdapter<VideoAndUser>(list) {

    override fun getLayoutId(): Int = R.layout.item_list_activity

    override fun convert(holder: BaseViewHolder, data: VideoAndUser, position: Int) {

        val context = holder.itemView.context
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_name_list_activity)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_duration_list_activity)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_title_list_activity)
        val type = holder.getWidget<AppCompatTextView>(R.id.txt_type_list_activity)
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_cover_list_activity)

        val user = data.user
        val video = data.video
        name.text = user.userName

        video.cover?.let {
            loadImage(context, it, cover)
        }

        duration.text = TimeUtils.getDuration(video.duration.toLong())
        video.title?.let {
            if (it.contains("和花")) {
                type.text = "和花"
            } else {
                type.text = "暂无描述"
            }
            title.text = it
        }

        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, video.code)
        }

    }

}