import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pandas.R
import com.example.pandas.bean.MusicBean
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.databinding.AdapterItem1MusicBinding
import com.example.pandas.databinding.AdapterItem2MusicBinding
import com.example.pandas.databinding.AdapterItem3MusicVideoBinding
import com.example.pandas.ui.activity.MoreDataListActivity
import com.example.pandas.ui.adapter.ChildMusicVideoAdapter
import com.example.pandas.ui.adapter.MusicChildAdapter
import com.example.pandas.ui.adapter.decoration.MusicTopItemDecoration
import com.example.pandas.ui.adapter.decoration.MusicVideoItemDecoration

/**
 * @description: MusicFragment2 adapter
 * @author: dongyiming
 * @date: 7/14/23 2:39 PM
 * @version: v1.0
 */
public class MusicFragment2Adapter(private var musicBean: MusicBean) : Adapter<ViewHolder>() {

    private val TYPE_BANNER: Int = 1
    private val TYPE_ITEM1: Int = 2
    private val TYPE_ITEM2: Int = 3
    private val TYPE_VIDEO: Int = 4
    private val TYPE_ITEM3: Int = 5
    private val TYPE_ITEM4: Int = 6
    private val TYPE_ITEM5: Int = 7

    private val titles = arrayOf("新歌推荐", "私人专属好歌", "热门好歌精选", "音乐视频", "小众宝藏佳作", "潮流音乐")

    fun refresh(musicBean: MusicBean) {
        this.musicBean = musicBean
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_BANNER
            1 -> TYPE_ITEM1
            2 -> TYPE_ITEM2
            3 -> TYPE_VIDEO
            5 -> TYPE_ITEM4
            6 -> TYPE_ITEM5
            else -> TYPE_ITEM3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        when (viewType) {
            TYPE_BANNER -> {
                val binding = AdapterItem1MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return TopViewHolder(binding)
            }
            TYPE_ITEM1 -> {
                val binding = AdapterItem2MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return Item1ViewHolder(binding)
            }
            TYPE_ITEM2 -> {
                val binding = AdapterItem2MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return Item2ViewHolder(binding)
            }
            TYPE_ITEM3 -> {
                val binding = AdapterItem2MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return Item3ViewHolder(binding)
            }
            TYPE_ITEM4 -> {
                val binding = AdapterItem2MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return Item4ViewHolder(binding)
            }
            TYPE_ITEM5 -> {
                val binding = AdapterItem2MusicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return Item5ViewHolder(binding)
            }
            else -> {
                val binding = AdapterItem3MusicVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return ItemVideoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            TYPE_BANNER -> {
                (holder as TopViewHolder).handle()
            }
            TYPE_ITEM1 -> {
                (holder as Item1ViewHolder).handle()
            }
            TYPE_ITEM2 -> {
                (holder as Item2ViewHolder).handle()
            }
            TYPE_ITEM3 -> {
                (holder as Item3ViewHolder).handle()
            }
            TYPE_ITEM4 -> {
                (holder as Item4ViewHolder).handle()
            }
            TYPE_ITEM5 -> {
                (holder as Item5ViewHolder).handle()
            }
            else -> {
                (holder as ItemVideoViewHolder).handle()
            }
        }
    }

    override fun getItemCount(): Int = 7

    inner class TopViewHolder(binding: AdapterItem1MusicBinding) : ViewHolder(binding.root) {

        val recyclerView = binding.rvItem1
        private val marginLeft =
            itemView.context.resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        private val marginPadding =
            itemView.context.resources.getDimension(R.dimen.common_lh_2_dimens).toInt()
        private var mAdapter: MusicTopChildAdapter? = null

        fun handle() {
            val list = musicBean.musicBanners
            if (mAdapter == null) {
                mAdapter = MusicTopChildAdapter(list)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, HORIZONTAL, false)
                    addItemDecoration(MusicTopItemDecoration(marginLeft, marginPadding))
                    adapter = mAdapter
                }
            }
        }
    }

    inner class Item1ViewHolder(binding: AdapterItem2MusicBinding) : ViewHolder(binding.root) {

        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicItem
        val title = binding.txtMusicItemName
        var mAdapter: MusicChildAdapter? = null

        fun handle() {
            val list = musicBean.musicItem1

            title.text = titles[0]
            if (mAdapter == null) {
                mAdapter = MusicChildAdapter(list, 1)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, VERTICAL, false)
                    adapter = mAdapter
                }
            }
        }
    }

    inner class Item2ViewHolder(binding: AdapterItem2MusicBinding) : ViewHolder(binding.root) {

        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicItem
        val title = binding.txtMusicItemName
        var mAdapter: MusicChildAdapter? = null

        fun handle() {

            title.text = titles[1]
            val list = musicBean.musicItem2
            Log.e("1mean", "list size: ${list.size}")
            if (mAdapter == null) {
                mAdapter = MusicChildAdapter(list, 1)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, VERTICAL, false)
                    adapter = mAdapter
                }
            }
        }
    }

    inner class Item3ViewHolder(binding: AdapterItem2MusicBinding) : ViewHolder(binding.root) {

        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicItem
        val title = binding.txtMusicItemName
        var mAdapter: MusicChildAdapter? = null

        fun handle() {
            title.text = titles[2]
            val list = musicBean.musicItem3
            Log.e("1mean", "list size: ${list.size}")
            if (mAdapter == null) {
                mAdapter = MusicChildAdapter(list, 1)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, VERTICAL, false)
                    adapter = mAdapter
                }
            }
        }
    }

    inner class Item4ViewHolder(binding: AdapterItem2MusicBinding) : ViewHolder(binding.root) {

        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicItem
        val title = binding.txtMusicItemName
        var mAdapter: MusicChildAdapter? = null

        fun handle() {
            title.text = titles[4]
            val list = musicBean.musicItem4
            if (mAdapter == null) {
                mAdapter = MusicChildAdapter(list, 1)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, VERTICAL, false)
                    adapter = mAdapter
                }
            }
        }
    }

    inner class Item5ViewHolder(binding: AdapterItem2MusicBinding) : ViewHolder(binding.root) {

        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicItem
        val title = binding.txtMusicItemName
        var mAdapter: MusicChildAdapter? = null

        fun handle() {
            title.text = titles[5]
            val list = musicBean.musicItem5
            if (mAdapter == null) {
                mAdapter = MusicChildAdapter(list, 1)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, VERTICAL, false)
                    adapter = mAdapter
                }
            }
        }
    }

    inner class ItemVideoViewHolder(binding: AdapterItem3MusicVideoBinding) :
        ViewHolder(binding.root) {

        private val marginLeft =
            itemView.context.resources.getDimension(R.dimen.common_lh_12_dimens).toInt()
        private val marginPadding =
            itemView.context.resources.getDimension(R.dimen.common_lh_7_dimens).toInt()
        val more = binding.clayoutMusicMore
        val recyclerView = binding.rvMusicVideo
        val title = binding.txtMusicItemName
        var mAdapter: ChildMusicVideoAdapter? = null

        fun handle() {
            title.text = titles[3]
            val list = musicBean.musicVideos
            Log.e("1mean", "list size: ${list.size}")
            if (mAdapter == null) {
                mAdapter = ChildMusicVideoAdapter(list)
                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context, HORIZONTAL, false)
                    addItemDecoration(MusicVideoItemDecoration(marginLeft, marginPadding))
                    adapter = mAdapter
                }
            }

            more.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.MUSIC.ordinal
                )
            }
        }
    }
}