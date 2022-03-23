import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.databinding.CardImageBinding
import com.example.pandas.databinding.CardItemMusicBinding
import com.example.pandas.databinding.LayoutSleepBinding
import com.example.pandas.databinding.LayoutTalkBinding
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.ui.activity.MoreDataListActivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @description: MyLoveFragmentAdapter
 * @author: dongyiming
 * @date: 1/28/22 9:39 下午
 * @version: v1.0
 */
public class MyLoveFragmentAdapter(
    private val owner: LifecycleOwner,
    private var data: PageCommonData
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_BANNER = 0 //图片展示
    private val TYPE_MOVIE = 1 //歌曲视频
    private val TYPE_MUSIC = 2 //热门音乐
    private val TYPE_FOOTBALL = 3 //天下足球
    private val TYPE_TALK = 4 //热门相声
    private val TYPE_ART = 5 //艺术
    private val TYPE_BABY = 6 //人类宝宝
    private val TYPE_HONGLOU = 7 //人类宝宝
    private val TYPE_BEAUTY = 8 //影视美人

    private var startIndex = 5
    private val pageItems = 5

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(newData: PageCommonData) {
        data = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = 9

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_BANNER
            1 -> TYPE_MOVIE
            2 -> TYPE_MUSIC
            3 -> TYPE_FOOTBALL
            4 -> TYPE_TALK
            5 -> TYPE_ART
            6 -> TYPE_BABY
            7 -> TYPE_HONGLOU
            else -> TYPE_BEAUTY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        when (viewType) {
            TYPE_BANNER -> {
                val binding =
                    CardImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImageViewHolder(binding)
            }
            TYPE_MOVIE -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return MovieViewHolder(binding)
            }
            TYPE_MUSIC -> {
                val binding =
                    CardItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MusicHolder(binding)
            }
            TYPE_FOOTBALL -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return SleepViewHolder(binding)
            }
            TYPE_TALK -> {
                val binding =
                    LayoutTalkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return TalkViewHolder(binding)
            }
            TYPE_ART -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ArtViewHolder(binding)
            }
            TYPE_BABY -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return BabyViewHolder(binding)
            }
            TYPE_HONGLOU -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return HongLouViewHolder(binding)
            }
            else -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return BeautyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_BANNER -> {
                (holder as ImageViewHolder).handle(position)
            }
            TYPE_MOVIE -> {
                (holder as MovieViewHolder).handle(position)
            }
            TYPE_FOOTBALL -> {
                (holder as SleepViewHolder).handle(position)
            }
            TYPE_MUSIC -> {
                (holder as MusicHolder).handle()
            }
            TYPE_TALK -> {
                (holder as TalkViewHolder).handle(position)
            }
            TYPE_ART -> {
                (holder as ArtViewHolder).handle(position)
            }
            TYPE_BABY -> {
                (holder as BabyViewHolder).handle(position)
            }
            TYPE_HONGLOU -> {
                (holder as HongLouViewHolder).handle(position)
            }
            TYPE_BEAUTY -> {
                (holder as BeautyViewHolder).handle(position)
            }
        }
    }

    private inner class ImageViewHolder(binding: CardImageBinding) :
        BaseEmptyViewHolder(binding.root) {
//        val image = binding.imageLove
//        val card2 = binding.layoutCard2
//        val card3 = binding.layoutCard3
//
//        private var lastX: Float = 0F
//        private var lastY: Float = 0F

        @SuppressLint("ClickableViewAccessibility")
        fun handle(position: Int) {

//            card2.setOnTouchListener { v, event ->
//                val x = event.rawX
//                val y = event.rawY
//                when(event.action){
//                    MotionEvent.ACTION_DOWN ->{
//                        lastX = x
//                        lastY = y
//                    }
//                    MotionEvent.ACTION_MOVE ->{
//                        lastX = event.rawX
//                        lastY = event.rawY
//                        val distanceX: Float = Math.abs(lastX - x)
//                        val distanceY: Float = Math.abs(lastY - y)
//
//                        if (distanceX > distanceY) {
//                            Log.e("1mean","和啊啊 啊")
//                        }
//
//                    }
//                    MotionEvent.ACTION_UP ->{
//
//                    }
//                }
//
//
//                true
//            }

        }
    }

    private inner class MusicHolder(binding: CardItemMusicBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutTitle
        val recyclerView = binding.recyclerMusicLove
        val title = binding.txtMusicTitle

        //val next = binding.layoutNext
        var mAdapter: MusicItemAdapter? = null

        fun handle() {
            val list = data.songs
            if (list.isNotEmpty() && mAdapter == null) {

                title.text = "歌曲"
                mAdapter = MusicItemAdapter(list)

                recyclerView.run {
                    layoutManager = LinearLayoutManager(itemView.context)
                    adapter = mAdapter
                }
                titleLayout.setOnClickListener {
                    MoreDataListActivity.startMoreDataActivity(itemView.context, AppInfos.TYPE_MP3)
                }

//                next.setOnClickListener {
//                    owner.apply {
//                        lifecycleScope.launch {
//                            getNextSongs().collect { value ->
//                                startIndex += pageItems
//                                mAdapter!!.loadMore(value)
//                            }
//                        }
//                    }
//                }
            }
        }
    }

    private inner class MovieViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "歌曲视频"
            val videos = data.movieModel
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.MUSIC.ordinal
                )
            }
        }
    }

    private inner class SleepViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "天下足球"
            val videos = data.footBallModel
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.FOOTBALL.ordinal
                )
            }
        }
    }

    private inner class TalkViewHolder(binding: LayoutTalkBinding) :
        BaseEmptyViewHolder(binding.root) {

        val loadMore = binding.layoutTalkMore
        val recyclerView = binding.recyclerTalk
        var mAdapter: TalkAudioItemAdapter? = null
        val padding = itemView.context.resources.getDimension(R.dimen.common_sz_12_dimens).toInt()

        fun handle(position: Int) {

            val audios = data.talkAudios
            if (mAdapter == null && audios.isNotEmpty()) {
                mAdapter = TalkAudioItemAdapter(audios)
                recyclerView.run {
                    addItemDecoration(
                        OneDirectionItemDecoration(
                            isBottom = true,
                            padding = padding
                        )
                    )
                    layoutManager = LinearLayoutManager(itemView.context)
                    adapter = mAdapter
                }
            }
        }
    }

    private inner class ArtViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "艺术雕塑"
            val videos = data.artList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.ART.ordinal
                )
            }
        }
    }

    private inner class BabyViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "人类宝宝"
            val videos = data.babyList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.BABY.ordinal
                )
            }
        }
    }

    private inner class HongLouViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "红楼评说"
            val videos = data.honglouList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.HONGLOU.ordinal
                )
            }
        }
    }

    private inner class BeautyViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        val title = binding.txtSleep
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            title.text = "影视美女"
            val videos = data.beautyList
            if (mAdapter == null && videos.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
            }
            titleLayout.setOnClickListener {
                MoreDataListActivity.startMoreDataActivity(
                    itemView.context,
                    VideoType.BEAUTY.ordinal
                )
            }
        }
    }

    private fun getNextSongs(): Flow<MutableList<MusicVo>> = flow {
        val list = PetManagerCoroutine.getPageMusic(startIndex, pageItems)
        emit(list)
    }

}