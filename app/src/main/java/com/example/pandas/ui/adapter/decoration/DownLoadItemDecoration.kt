import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/19 12:17 上午
 * @version: v1.0
 */
public class DownLoadItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.common_lh_5_dimens).toInt()

    /**
     * <padding>
     * @param:
     * @version: v1.0
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) outRect.left = padding else outRect.left = 0
        outRect.top = padding
        outRect.right = padding
    }
}