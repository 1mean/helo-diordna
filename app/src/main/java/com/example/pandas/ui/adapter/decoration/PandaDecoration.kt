import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: PandaDecoration
 * @author: dongyiming
 * @date: 1/24/22 2:31 上午
 * @version: v1.0
 */
public class PandaDecoration(private val context: Context): RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) outRect.left = padding else outRect.left = 0
        outRect.top = padding
        outRect.right = padding
    }
}