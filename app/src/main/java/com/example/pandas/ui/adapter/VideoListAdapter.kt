import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity

/**
 * @description: VideoListAdapter
 * @author: dongyiming
 * @date: 3/2/22 12:50 上午
 * @version: v1.0
 */
public class VideoListAdapter(private val list: MutableList<PetViewData>) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_video_list

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {

        val cover = holder.getWidget<AppCompatImageView>(R.id.img_video_list_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_title)
        val name = holder.getWidget<AppCompatTextView>(R.id.txt_video_list_author)
        val layoutMore = holder.getWidget<ConstraintLayout>(R.id.item_video_list_more)

        val video = list[position]

        loadRoundedCornerImage(holder.itemView.context, 10, video.cover, cover)
        duration.text = TimeUtils.getMMDuration(video.duration.toLong())
        title.text = video.title
        name.text = video.authorName
        layoutMore.setOnClickListener {

        }
        holder.itemView.setOnClickListener {
            startVideoPlayActivity(holder.itemView.context, video.code)
        }
    }

}