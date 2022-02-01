import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/31/22 1:27 上午
 * @version: v1.0
 */
public class MyLoveItemDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position == 2) {
            outRect.top = padding
        } else
            outRect.set(padding, padding, padding, 0)
    }
}