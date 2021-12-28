import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.databinding.AdapterDownloadBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/19 12:30 上午
 * @version: v1.0
 */
public class DownLoadAdapte() : RecyclerView.Adapter<DownLoadAdapte.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = AdapterDownloadBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        Glide.with(holder.context).load(R.mipmap.img_hehua).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )).into(holder.imgOwner)
    }

    override fun getItemCount(): Int = 10

    class MyViewHolder(binding: AdapterDownloadBinding) : RecyclerView.ViewHolder(binding.root) {

        val imgCover = binding.imgCover
        val imgOwner = binding.imgOwner
        val context = binding.root.context
    }

}