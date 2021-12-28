import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pandas.R
import com.example.pandas.databinding.AdapterPandaItem1Binding
import com.example.pandas.databinding.AdapterPandaItem2Binding


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 6:02 下午
 * @version: v1.0
 */
public class PandaAdapter(val context: Context, private val pandas: MutableList<Panda>) :

    RecyclerView.Adapter<RoomViewHolder>() {

    //瀑布流添加数据更新需要使用notifyItemInserted()，pandas.size是添加数据后集合的大小
    fun addData(newData: List<Panda>) {
        if (newData.isNotEmpty()) {
            pandas.addAll(newData)
            notifyItemInserted(pandas.size)
        }
    }

    override fun getItemCount(): Int = pandas.size

    override fun getItemViewType(position: Int): Int = pandas[position].type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {

        when (viewType) {
            0 -> {
                val binding = AdapterPandaItem1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return MyViewHolder1(binding)
            }
            else -> {
                val binding = AdapterPandaItem2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return MyViewHolder2(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {

        Log.e("1mean", "position: $position")

        when (getItemViewType(position)) {
            0 -> {
                //防止item高度滑动中出现错误，必须固定其高度，通过填充的图片高度来固定整体高度
                val layoutParams = holder.fullImageView.layoutParams
                layoutParams.height = ScreenUtil.getScreenHeight(context) / 3
                holder.fullImageView.layoutParams = layoutParams
                Glide.with(context).load(R.mipmap.liuyifei)
                    .into(holder.fullImageView)
            }
            1 -> {
                //布局必须是自适应的Imageview和一个固定高度的父布局
                //防止item高度滑动中出现错误，必须固定其高度，通过填充的图片高度来固定整体高度
                val layoutParams = holder.imgHeader.layoutParams
                layoutParams.height = (ScreenUtil.getScreenHeight(context) / 4.8).toInt()
                holder.imgHeader.layoutParams = layoutParams
                Glide.with(context).load(R.mipmap.ou).into(holder.imgHeader)
                holder.position.text = position.toString()
            }
        }
    }


    class MyViewHolder1(binding: AdapterPandaItem1Binding) : RoomViewHolder(binding.root) {
        init {
            fullImageView = binding.image
        }
    }

    class MyViewHolder2(binding: AdapterPandaItem2Binding) : RoomViewHolder(binding.root) {
        init {
            imgHeader = binding.imgHeader
            typeValue = binding.txtTypeValue
            name = binding.txtName
            desc1 = binding.txtDesc1
            desc2 = binding.txtDesc2
            desc3 = binding.txtDesc3
            position = binding.txtPosition
            cvItem = binding.cvItem
        }
    }
}