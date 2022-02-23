import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.CardItemLayoutBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/12/22 7:53 下午
 * @version: v1.0
 */
public class PandasAdapter(private val list: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = list.size

    /**
     * 下拉刷新后，数据刷新
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(data: MutableList<PetViewData>) {

        list.clear()
        if (data.isNotEmpty()) {
            list.addAll(data)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: MutableList<PetViewData>) {
        val size = list.size
        if (data.isNotEmpty()) {
            list.addAll(data)
        }
        notifyItemRangeInserted(size, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        val binding = CardItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(holder, position)
    }

    inner class MyViewHolder(private val binding: CardItemLayoutBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgCover
        val duration = binding.txtDuration
        val name = binding.txtName
        val title = binding.txtTitle

        fun handle(holder: MyViewHolder, position: Int) {

            val petVideo = list[position]
            val duration = TimeUtils.getDuration(petVideo.duration.toLong())

            //把http图片换成https就能加载出来
            Glide.with(holder.itemView).load(petVideo.cover)
                .into(holder.cover)
            holder.duration.text = duration
            holder.name.text = petVideo.authorName
            holder.title.text = petVideo.title
        }
    }
}