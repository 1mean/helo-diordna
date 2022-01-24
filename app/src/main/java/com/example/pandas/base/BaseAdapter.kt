import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/22/22 12:07 下午
 * @version: v1.0
 */
public class BaseAdapter<T>(private val data: MutableList<T>) : RecyclerView.Adapter<BaseViewHolder>() {

    /**
     * 刷新界面
     */
    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(list: MutableList<T>){

        if (list.isNotEmpty()) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: MutableList<T>){
        if (list.isNotEmpty()) {
            data.addAll(list)
            notifyDataSetChanged()
        }
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