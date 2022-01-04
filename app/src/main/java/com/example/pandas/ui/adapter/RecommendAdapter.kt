import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.bean.pet.PetVideo
import com.example.pandas.databinding.CardItemLayoutBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 3:27 下午
 * @version: v1.0
 */
public class RecommendAdapter(private val list: MutableList<PetVideo>) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private final val TYPE_VIEWPAGER = 1
    private final val TYPE_CARD = 2
    private final val TYPE_VIDEO = 3

    override fun getItemViewType(position: Int): Int {
        if (list.isNotEmpty()) {
            return list[position].type
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {

        when (viewType) {
            TYPE_CARD -> {
                val binding = CardItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CardHolder(binding)
            }
            else -> {
                val binding = CardItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CardHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {

        when (getItemViewType(position)) {

            TYPE_CARD -> {
                (holder as CardHolder).handle(position)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    inner class CardHolder(binding: CardItemLayoutBinding) : BaseEmptyViewHolder(binding.root) {

        fun handle(position: Int) {



        }
    }
}