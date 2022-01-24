import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.ui.adapter.viewholder.ImageViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/23 1:46 下午
 * @version: v1.0
 */
public class EyeViewPagerAdapter(val list: MutableList<String>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        val image = AppCompatImageView(parent.context)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        image.layoutParams = layoutParams
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        return MyHolder(image)

    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        Glide.with(holder.itemView).load(list[position]).into((holder as MyHolder).itemView as AppCompatImageView)

    }

    override fun getItemCount(): Int = list.size

    inner class MyHolder(private val itemView:AppCompatImageView):BaseEmptyViewHolder(itemView){

    }
}