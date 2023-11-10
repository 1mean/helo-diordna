import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.blankj.utilcode.util.VibrateUtils
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.interaction.ItemClickListener
import com.example.pandas.databinding.AdapterHotFragmentBinding
import com.example.pandas.databinding.AdapterTopHotFragmentBinding
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.adapter.decoration.HotFragmentTopDecoration
import com.example.pandas.ui.ext.startVideoPlayingActivity
import com.example.pandas.ui.view.dialog.ShareBottomSheetDialog
import com.example.pandas.utils.NumUtils
import com.example.pandas.utils.TimeUtils

/**
 * @description: HotFragmentAdapter
 * @author: dongyiming
 * @date: 4/20/22 11:27 下午
 * @version: v1.0
 */
public class HotFragmentAdapter(val list: MutableList<PetVideo>) : Adapter<ViewHolder>() {

    private val max = 1 * 1000 * 1000 * 2
    private val th = 1 * 1000 * 1000

    private val TYPE_TOP = 1
    private val TYPE_ITEM = 2

    fun refreshAdapter(data: MutableList<PetVideo>) {
        if (data.isNotEmpty() && list != data) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()

        }
    }

    fun loadMore(data: MutableList<PetVideo>) {

        if (data.isNotEmpty()) {
            val size = list.size
            list.addAll(data)
            notifyItemRangeInserted(size + 1, data.size)
        }
    }

    override fun getItemCount(): Int = if (list.isEmpty()) {
        0
    } else {
        list.size + 1
    }

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        TYPE_TOP
    } else {
        TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == TYPE_TOP) {
            val binding = AdapterTopHotFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TopViewHolder(binding)
        } else {
            val binding = AdapterHotFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ItemViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_TOP) {
            (holder as TopViewHolder).handle()
        } else {
            (holder as ItemViewHolder).handle(position)
        }
    }

    class TopViewHolder(binding: AdapterTopHotFragmentBinding) : ViewHolder(binding.root) {

        val recyclerView = binding.rvTopHotFragment
        private val topList = mutableListOf("排行榜", "每周必看", "创作榜", "热搜榜")

        var mAdapter: HotTopItemAdapter? = null

        fun handle() {
            if (mAdapter == null) {
                mAdapter = HotTopItemAdapter(topList)
                with(recyclerView) {
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    addItemDecoration(HotFragmentTopDecoration())
                    adapter = mAdapter
                }
            }
        }
    }

    inner class ItemViewHolder(binding: AdapterHotFragmentBinding) : ViewHolder(binding.root) {

        val context = itemView.context
        val cover = binding.imgHotCover

        val duration = binding.txtHotDuration
        val title = binding.txtHotTitle
        val tag = binding.txtHotTag
        val author = binding.txtHotAuthor
        val playCounts = binding.txtHotVideoCounts
        val time = binding.txtHotTime
        val more = binding.itemHotMore

        fun handle(position: Int) {

            val data = list[position - 1]
            data.cover?.let {
                loadCenterRoundedCornerImage(context, 10, it, cover)
            }
            duration.text = TimeUtils.getDuration(data.duration.toLong())
            title.text = data.title
            tag.text = "百万播放"

            val rCounts = (1..max).random()
            val rCountsString = NumUtils.getShortNum(rCounts)
            playCounts.text = rCountsString
            if (rCounts >= th) {
                tag.visibility = View.VISIBLE
            } else {
                tag.visibility = View.GONE
            }

            data.user?.let {
                author.text = it.userName
            }

            val parseTime = TimeUtils.getMdTime(data.releaseTime)
            time.text = StringBuilder("- ").append(parseTime).toString()

            itemView.setOnClickListener {
                startVideoPlayingActivity(context, data)
            }

            itemView.setOnLongClickListener {
                val dialog = ShareBottomSheetDialog(context) {}
                dialog.addData().onShow()
                VibrateUtils.vibrate(2000)
                true
            }

            more.setOnClickListener {
                val dialog = ShareBottomSheetDialog(context) {}
                dialog.addData().onShow()
            }
        }

    }
}