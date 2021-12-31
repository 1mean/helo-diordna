import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: RoomItemDecoration
 * @author: dongyiming
 * @date: 2021/12/13 4:56 下午
 * @version: v1.0
 */
public class RoomItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var padding: Int = context.resources.getDimension(R.dimen.room_decoration_dimen).toInt()

    /**
     * <绘制背景的效果，内容在上面，即在getItemOffsets的padding区域作画>
     * @param:
     * @version: v1.0
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

    }

    /**
     * <绘制在内容的上面，覆盖内容>
     * @param:
     * @version: v1.0
     */
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

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
        if (position <= 1) outRect.top = 0 else outRect.top = padding
        if (position % 2 == 0) outRect.left = padding else outRect.left = 0
        outRect.right = padding
    }
}