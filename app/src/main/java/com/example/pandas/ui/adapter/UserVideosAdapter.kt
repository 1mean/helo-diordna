import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadRoundedCornerImage
import com.example.pandas.biz.ext.startVideoPlayActivity
import com.example.pandas.utils.TimeUtils

/**
 * @description: UserVideosAdapter
 * @author: dongyiming
 * @date: 4/22/22 10:46 下午
 * @version: v1.0
 */
public class UserVideosAdapter(list: MutableList<PetViewData>) :
    BaseCommonAdapter<PetViewData>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_user_video_list

    override fun convert(holder: BaseViewHolder, data: PetViewData, position: Int) {

        val context = holder.itemView.context
        val cover = holder.getWidget<AppCompatImageView>(R.id.img_user_list_cover)
        val duration = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_duration)
        val title = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_name)
        val time = holder.getWidget<AppCompatTextView>(R.id.txt_user_list_time)
        val counts = holder.getWidget<AppCompatTextView>(R.id.txt_user_video_playcounts)

        loadRoundedCornerImage(context, 10, data.cover, cover)
        duration.text = TimeUtils.getDuration(data.duration.toLong())
        title.text = data.title
        val count = (1..5000).random()
        counts.text = StringBuilder("$count").append("观看").toString()

        data.releaseTime?.let {
            val subTime = it.substring(5, 10)
            time.text = StringBuilder("- ").append(subTime).toString()
        }
        holder.itemView.setOnClickListener {
            startVideoPlayActivity(context, data.code)
        }
    }

}