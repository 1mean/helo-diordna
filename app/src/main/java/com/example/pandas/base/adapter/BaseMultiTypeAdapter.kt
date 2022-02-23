import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.adapter.BaseViewHolder

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/22/22 12:32 下午
 * @version: v1.0
 */
public class BaseMultiTypeAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}