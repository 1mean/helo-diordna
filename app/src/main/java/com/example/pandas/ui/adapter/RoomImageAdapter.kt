import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.R

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/6 2:23 下午
 * @version: v1.0
 */
public class RoomImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>() {

    private val imageList = listOf(
        R.mipmap.liuyifei,
        R.mipmap.ou,
        R.mipmap.angle,
        R.mipmap.han,
        R.mipmap.xinling,
        R.mipmap.jia
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        val imageView = ImageView(parent.context)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.layoutParams = layoutParams
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return ImageViewHolder(imageView)

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        Log.e("10mean", "position: $position")
        val imageIndex = position % 6

        Glide.with(context).load(imageList.get(imageIndex)).into(holder.imageView!!)
        holder.imageView?.setImageResource(imageList.get(imageIndex))
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

}