import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.R

/**
 * @description: adapter wrapper 只有一个footer
 * @author: dongyiming
 * @date: 4/18/22 11:47 上午
 * @version: v1.0
 */
public class AdapterWrapper(private val mAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_FOOTER = 99999 //footer

    private var mViewHolder: FooterViewHolder? = null
    private var onItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: OnItemLongClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }

    fun getCurrentItemCount() = mAdapter.itemCount

    private fun isFooter(position: Int): Boolean = position == getCurrentItemCount()

    private fun isFooter(holder: RecyclerView.ViewHolder): Boolean = holder is FooterViewHolder

    override fun getItemCount(): Int {
        val count = mAdapter.itemCount
        return if (count == 0) 0 else count + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (isFooter(position)) {
            return TYPE_ITEM_FOOTER
        } else {
            return mAdapter.getItemViewType(position)
        }
    }

    fun onLoading() {
        mViewHolder?.onLoading()
    }

    fun onLoadFinished(isEmpty: Boolean, hasMore: Boolean) {
        mViewHolder?.onLoadFinished(isEmpty, hasMore)
    }

    fun loadError(errorCode: Int, errorMessage: String) {
        mViewHolder?.onLoadError(errorCode, errorMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM_FOOTER) {
            val footer = LayoutInflater.from(parent.context)
                .inflate(R.layout.footer_recyclerview, parent, false)
            mViewHolder = FooterViewHolder(footer)
            return mViewHolder!!
        } else {
            val holder = mAdapter.onCreateViewHolder(parent, viewType)
            onItemClickListener?.let { listener ->
                holder.itemView.setOnClickListener {
                    listener.onItemClick(it, holder.bindingAdapterPosition)
                }
            }
            onItemLongClickListener?.let { listener ->
                holder.itemView.setOnLongClickListener {
                    listener.onItemLongClick(it, holder.bindingAdapterPosition)
                    true
                }
            }
            return holder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) != TYPE_ITEM_FOOTER) {
            mAdapter.onBindViewHolder(holder, position)
        }
    }

    private inner class FooterViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        private val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        private val txtFooter: AppCompatTextView = itemView.findViewById(R.id.txt_footer)
        private val footer: ConstraintLayout = itemView.findViewById(R.id.footer)

        fun onLoading() {
            footer.visibility = View.VISIBLE
            progressBar.visibility = View.VISIBLE
            txtFooter.visibility = View.GONE
        }

        fun onLoadFinished(isEmpty: Boolean, hasMore: Boolean) {

            Log.e("1mean", "onLoadFinished: $isEmpty, $hasMore")
            if (hasMore) {
                footer.visibility = View.GONE
            } else {
                footer.visibility = View.VISIBLE
                if (isEmpty) {
                    progressBar.visibility = View.GONE
                    txtFooter.visibility = View.VISIBLE
                    txtFooter.text = "暂时没有数据"
                } else {
                    progressBar.visibility = View.GONE
                    txtFooter.visibility = View.VISIBLE
                    txtFooter.text = "没有更多数据啦"
                }
            }
        }

        fun onLoadError(errorCode: Int, errorMessage: String) {

            footer.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            txtFooter.visibility = View.VISIBLE
            txtFooter.text = errorMessage
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager
        if (manager != null && manager is GridLayoutManager) {

            val gm = manager as GridLayoutManager
            gm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {

                    if (isFooter(position)) {
                        return gm.spanCount
                    } else if (getItemViewType(position) == 1 || getItemViewType(position) == 3) {//轮播图和横屏
                        return gm.spanCount
                    }
                    return 1
                }
            }
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (isFooter(holder)) {

            val layoutParams = holder.itemView.layoutParams
            if (layoutParams is StaggeredGridLayoutManager.LayoutParams) {
                val lp = layoutParams as StaggeredGridLayoutManager.LayoutParams
                lp.isFullSpan = true
            }
        } else {
            mAdapter.onViewAttachedToWindow(holder)
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        if (!isFooter(holder)) mAdapter.onViewRecycled(holder)
    }

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        return if (!isFooter(holder)) mAdapter.onFailedToRecycleView(holder) else false
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        if (!isFooter(holder)) mAdapter.onViewDetachedFromWindow(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        mAdapter.onDetachedFromRecyclerView(recyclerView)
    }
}