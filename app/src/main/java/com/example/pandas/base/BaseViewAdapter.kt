import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.base.interaction.IBaseAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/16 5:58 下午
 * @version: v1.0
 */
public abstract class BaseViewAdapter(
    private val context: Context,
    private val datas: MutableList<*>
) : RecyclerView.Adapter<BaseViewHolder>(), IBaseAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val holder = createViewHolder(parent, viewType)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        handleViewHolder(holder,position)
    }

    override fun getItemCount(): Int = datas.size

}