import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.databinding.*
import com.example.pandas.sql.entity.MusicVo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/28/22 9:39 下午
 * @version: v1.0
 */
public class MyLoveFragmentAdapter(
    private val owner: LifecycleOwner,
    private var data: PageCommonData
) :
    RecyclerView.Adapter<BaseEmptyViewHolder>() {

    private val TYPE_IMAGE = 1 //图片展示
    private val TYPE_CLASSIFY = 2 //分类 /动物/TV/音乐/
    private val TYPE_HORIZONTAL = 3 //水平滑动
    private val TYPE_SLEEP = 4 //我爱的电视剧
    private val TYPE_MUSIC = 5 //热门音乐
    private val TYPE_TALK = 6 //热门相声
    private val TYPE_COMMON = 7 //普通列表

    private var startIndex = 5
    private val pageItems = 5

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(newData: PageCommonData) {
        data = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_IMAGE
            1 -> TYPE_CLASSIFY
            2 -> TYPE_HORIZONTAL
            3 -> TYPE_SLEEP
            5 -> TYPE_MUSIC
            4 -> TYPE_TALK
            else -> TYPE_COMMON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEmptyViewHolder {
        when (viewType) {
            TYPE_IMAGE -> {
                val binding =
                    CardImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImageViewHolder(binding)
            }
            TYPE_CLASSIFY -> {
                val binding =
                    CardItemClassifyBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ClassifyViewHolder(binding)
            }
            TYPE_HORIZONTAL -> {
                val binding =
                    CardItemHorizontalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return HorizontalViewHolder(binding)
            }
            TYPE_SLEEP -> {
                val binding =
                    LayoutSleepBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return SleepViewHolder(binding)
            }
            TYPE_MUSIC -> {
                val binding =
                    CardItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MusicHolder(binding)
            }
            TYPE_TALK -> {
                val binding =
                    LayoutTalkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return TalkViewHolder(binding)
            }
            TYPE_COMMON -> {
            }
        }
        val binding =
            CardItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseEmptyViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_IMAGE -> {
                (holder as ImageViewHolder).handle(position)
            }
            TYPE_CLASSIFY -> {
                (holder as ClassifyViewHolder).handle(position)
            }
            TYPE_HORIZONTAL -> {
                (holder as HorizontalViewHolder).handle()
            }
            TYPE_SLEEP -> {
                (holder as SleepViewHolder).handle(position)
            }
            TYPE_MUSIC -> {
                (holder as MusicHolder).handle()
            }
            TYPE_TALK -> {
                (holder as TalkViewHolder).handle(position)
            }
            TYPE_COMMON -> {
                (holder as ImageViewHolder).handle(position)
            }
        }
    }

    private inner class ImageViewHolder(binding: CardImageBinding) :
        BaseEmptyViewHolder(binding.root) {
        val image = binding.imageLove
        fun handle(position: Int) {

        }
    }

    private inner class ClassifyViewHolder(binding: CardItemClassifyBinding) :
        BaseEmptyViewHolder(binding.root) {

        val petView = binding.llayoutPet
        val tvView = binding.llayoutTv
        val musicView = binding.llayoutMusic
        val talkView = binding.llayoutTalk
        val otherView = binding.llayoutOther

        val imgPet = binding.imgPet
        val imgTv = binding.imgTv
        val imgMusic = binding.imgMusic
        val imgTalk = binding.imgTalk
        val imgOther = binding.imgOther

        fun handle(position: Int) {
            val options = RequestOptions.bitmapTransform(CircleCrop())
            Glide.with(itemView.context).apply {
                load(R.mipmap.img_tiger_1).apply(options).into(imgPet)
                load(R.mipmap.img_tiger_2).apply(options).into(imgTv)
                load(R.mipmap.img_tiger_3).apply(options).into(imgMusic)
                load(R.mipmap.img_tiger_4).apply(options).into(imgTalk)
                load(R.mipmap.img_tiger_5).apply(options).into(imgOther)
            }
        }
    }

    private inner class HorizontalViewHolder(binding: CardItemHorizontalBinding) :
        BaseEmptyViewHolder(binding.root) {

        val title = binding.textHorinzontalTitle
        val recyclerView = binding.recyclerViewHorizontalLove
        private var mAdapter: HorizontalVideoAdapter? = null
        val padding =
            itemView.context.resources.getDimension(R.dimen.item_horizontal_padding).toInt()

        fun handle() {
            val videos = data.horizontalVideos

            if (videos.isNotEmpty() && mAdapter == null) {
                title.text = "热门萌宠"
                mAdapter = HorizontalVideoAdapter(videos)
                recyclerView.run {
                    layoutManager =
                        LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                    addItemDecoration(HorizontalItemDecoration(padding))
                    adapter = mAdapter
                }
            }
        }
    }

    private inner class MusicHolder(binding: CardItemMusicBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutTitle
        val recyclerView = binding.recyclerMusicLove
        val title = binding.txtMusicTitle
        val next = binding.layoutNext
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
                next.setOnClickListener {
                    owner.apply {
                        lifecycleScope.launch {
                            getNextSongs().collect { value ->
                                startIndex += pageItems
                                mAdapter!!.insertList(value)
                            }
                        }
                    }
                }
            }
        }
    }

    private inner class SleepViewHolder(binding: LayoutSleepBinding) :
        BaseEmptyViewHolder(binding.root) {

        val titleLayout = binding.layoutSleepTitle
        val recyclerView = binding.recyclerSleepVideo
        var mAdapter: SleepVideoItemAdapter? = null

        fun handle(position: Int) {

            val videos = data.sleepModel.videos
            val audios = data.sleepModel.audios

            if (mAdapter == null && videos.isNotEmpty() && audios.isNotEmpty()) {
                mAdapter = SleepVideoItemAdapter(videos)
                recyclerView.run {
                    addItemDecoration(SleepVideosItemDecoration(itemView.context))
                    layoutManager = GridLayoutManager(itemView.context, 2)
                    adapter = mAdapter
                }
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


    private fun getNextSongs(): Flow<MutableList<MusicVo>> = flow {
        val list = PetManagerCoroutine.getPageMusic(startIndex, pageItems)
        emit(list)
    }

}