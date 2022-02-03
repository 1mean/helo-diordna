import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @description: top有padding
 * @author: dongyiming
 * @date: 2/4/22 2:31 上午
 * @version: v1.0
 */
public class TopItemDecoration(private val padding: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = padding
    }
}