import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: CutePetChildDecoration
 * @author: dongyiming
 * @date: 3/17/22 11:59 下午
 * @version: v1.0
 */
public class CutePetChildDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    private var padding1: Int = context.resources.getDimension(R.dimen.item_home_padding).toInt()
    private var padding2: Int =
        context.resources.getDimension(R.dimen.item_home_padding_top).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position <= 1) {
            outRect.top = padding2
        } else {
            outRect.top = padding1
        }
        if (position % 2 == 0) outRect.left = padding1 else outRect.left = 0
        outRect.right = padding1
    }
}