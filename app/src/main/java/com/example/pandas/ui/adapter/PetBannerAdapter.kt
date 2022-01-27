import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.LayoutImageBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/6 2:23 下午
 * @version: v1.0
 */
public class PetBannerAdapter(private var data: MutableList<PetViewData>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(list: MutableList<PetViewData>) {

        if (list.isNotEmpty()) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        val binding = LayoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    inner class MyViewHolder(binding: LayoutImageBinding) : BaseEmptyViewHolder(binding.root) {
        val image = binding.imgView
        fun handle(position: Int) {
            val url = data[position].cover.replace("http", "https")
            //Glide.with(itemView.context).load(url).into(image)
            when(position){
                0->{
                    Glide.with(itemView.context).load("https://i0.hdslb.com/bfs/archive/968efacd13d8ca3800396eab67e5c99e31fae4a6.jpg").into(image)
                }
                1->{
                    Glide.with(itemView.context).load("https://i1.hdslb.com/bfs/archive/58d301c56e86fd2cf7316c023daa1aca9480f21d.jpg").into(image)
                }
                2->{
                    Glide.with(itemView.context).load("https://i2.hdslb.com/bfs/archive/8e7e227303ea3b315b09b7838ccf61ec6ad243fe.jpg").into(image)
                }
                3->{
                    Glide.with(itemView.context).load("https://i0.hdslb.com/bfs/archive/213435510f2714c4e42323a2ae1111e9e7a27898.jpg").into(image)
                }
                else ->{
                    Glide.with(itemView.context).load(url).into(image)
                }
            }
        }
    }
}