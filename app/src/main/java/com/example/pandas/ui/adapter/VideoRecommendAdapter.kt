import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.ItemVideoIntroBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/30/21 10:49 下午
 * @version: v1.0
 */
public class VideoRecommendAdapter(private val mutableList: MutableList<EyepetozerBean>) :
    RecyclerView.Adapter<VideoRecommendAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding =
            ItemVideoIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = mutableList.size

    inner class MyViewHolder(binding: ItemVideoIntroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cover = binding.imgMinicover
        val duration = binding.txtDuration
        val title = binding.txtTitle
        val name = binding.txtName
        val time = binding.txtTime

        fun onBind(position: Int) {

            val eyepetozerBean = mutableList[position]
            Glide.with(itemView.context).load(eyepetozerBean.coverUrl).apply(
                RequestOptions.bitmapTransform(
                    RoundedCorners(10)
                )
            ).into(cover)
            title.text = eyepetozerBean.title
            name.text = eyepetozerBean.user?.userName
            duration.text = TimeUtils.getDuration(eyepetozerBean.duration.toLong())
            time.text = TimeUtils.getStringDate(eyepetozerBean.releaseTime)
        }
    }
}