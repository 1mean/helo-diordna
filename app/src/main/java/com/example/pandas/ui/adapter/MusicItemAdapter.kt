import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.databinding.AdapterItemMusicBinding
import com.example.pandas.sql.entity.MusicVo

/**
 * @description: MusicItemAdapter
 * @author: dongyiming
 * @date: 2/1/22 6:55 下午
 * @version: v1.0
 */
public class MusicItemAdapter(private val list: MutableList<MusicVo>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    fun insertList(data: MutableList<MusicVo>) {
        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size, data.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        val binding =
            AdapterItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        (holder as MyViewHolder).handle(position)
    }

    override fun getItemCount(): Int = list.size

    private inner class MyViewHolder(binding: AdapterItemMusicBinding) :
        BaseEmptyViewHolder(binding.root) {

        val cover = binding.imgCoverMusic
        val audioName = binding.txtAudioName
        val singerName = binding.txtSingerName
        val layoutMore = binding.layoutMore

        fun handle(position: Int) {
            val options = RequestOptions.bitmapTransform(RoundedCorners(20))
            val music = list[position]
            Glide.with(itemView.context).load(music.cover).apply(options).into(cover)
            audioName.text = music.audioName
            singerName.text = music.singerName
            layoutMore.setOnClickListener {

            }
        }
    }
}