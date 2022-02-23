import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loadImage
import com.example.pandas.databinding.ItemVideoIntroBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/15/22 9:50 下午
 * @version: v1.0
 */
public class VideoRecoListAdapter(
    private val list: MutableList<PetViewData>,
    private val listener: OnVideoItemClickLIstener
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(data: MutableList<PetViewData>) {
        if (list != data && data.isNotEmpty()) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        val binding =
            ItemVideoIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(binding: ItemVideoIntroBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgVideoRecoCover
        val duration = binding.txtVideoRecoDuration
        val title = binding.txtVideoRecoTitle
        val name = binding.txtVideoRecoName
        val time = binding.textVideoRecoTime

        fun handle(position: Int) {

            val video = list[position]
            loadImage(itemView.context, video.cover, cover)
            title.text = video.title
            name.text = video.authorName
            duration.text = TimeUtils.getDuration(video.duration.toLong())
            time.text = video.releaseTime

            itemView.setOnClickListener {
                listener.onClick(position, video.code)
            }
        }
    }
}