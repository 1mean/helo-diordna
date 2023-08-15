import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pandas.bean.pet.VideoType
import com.example.pandas.biz.ext.loadCenterImage
import com.example.pandas.biz.ext.loadCenterRoundedCornerImage
import com.example.pandas.biz.ext.loadMusicBackGround
import com.example.pandas.databinding.MusicTopItem1Binding
import com.example.pandas.databinding.MusicTopItem2Binding
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.ui.ext.startMusicActivity
import com.example.pandas.ui.ext.startVideoPlayingActivity

/**
 * @description: musicFragment2 top item
 * @author: dongyiming
 * @date: 7/14/23 3:15 PM
 * @version: v1.0
 */
public class MusicTopChildAdapter(private val list: MutableList<MusicVo>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            0 -> {
                val binding =
                    MusicTopItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder1(binding)
            }
            1 -> {
                val binding =
                    MusicTopItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder2(binding)
            }
            2 -> {
                val binding =
                    MusicTopItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder3(binding)
            }
            3 -> {
                val binding =
                    MusicTopItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder4(binding)
            }
            4 -> {
                val binding =
                    MusicTopItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder5(binding)
            }
            else -> {
                val binding =
                    MusicTopItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder6(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as ViewHolder1).handle(position)
            1 -> (holder as ViewHolder2).handle(position)
            2 -> (holder as ViewHolder3).handle(position)
            3 -> (holder as ViewHolder4).handle(position)
            4 -> (holder as ViewHolder5).handle(position)
            else -> (holder as ViewHolder6).handle(position)
        }
    }

    override fun getItemCount(): Int = list.size

    val covers =
        arrayOf(
            "https://i0.hdslb.com/bfs/archive/a2a54e16f3d70a7079c35812220bd011dc969c65.jpg",
            "https://i2.hdslb.com/bfs/archive/079a06085c4cb987b39f94eae6e0506848b4df9c.jpg",
            "https://p3-pc-sign.douyinpic.com/tos-cn-p-0015/oQ2AnhDs4eKEABDCFkZv9EgzCDIZbAJnQOwheC~tplv-dy-cropcenter:323:430.jpeg?biz_tag=pcweb_cover&from=3213915784&s=PackSourceEnum_COLLECTION&sc=cover&se=true&sh=323_430&x-expires=2003461200&x-signature=zOsk%2FWHMxqE1WdkJoH0CcRKnAkE%3D",
            "https://i1.hdslb.com/bfs/archive/78fc44827e4d88b5785f418a34a26a930f315e00.jpg",
            "https://i2.hdslb.com/bfs/archive/f042641aae29074e22a8910513c2e6eb670a367e.png",
            "https://i0.hdslb.com/bfs/archive/7643dcb1726a5ec7b0f446edc015b5f7042476bf.jpg",
        )

    inner class ViewHolder1(binding: MusicTopItem1Binding) : ViewHolder(binding.root) {

        val mContext = itemView.context
        val fullView = binding.clayoutMusic
        val image = binding.imgMusicTopChild1
        val name = binding.txtMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadMusicBackGround(mContext, covers[position], fullView)
                loadCenterRoundedCornerImage(mContext, 25, it, image)
            }
            name.text = musicVo.audioName

            itemView.setOnClickListener {
                musicVo.fileName?.let {
                    startMusicActivity(mContext, it)
                }
            }
        }
    }

    inner class ViewHolder2(binding: MusicTopItem1Binding) : ViewHolder(binding.root) {

        val mContext = itemView.context
        val fullView = binding.clayoutMusic
        val image = binding.imgMusicTopChild1
        val name = binding.txtMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadMusicBackGround(mContext, covers[position], fullView)
                loadCenterRoundedCornerImage(mContext, 25, it, image)
            }
            name.text = musicVo.audioName

            itemView.setOnClickListener {
                musicVo.fileName?.let {
                    startMusicActivity(mContext, it)
                }
            }
        }
    }

    inner class ViewHolder3(binding: MusicTopItem1Binding) : ViewHolder(binding.root) {

        val mContext = itemView.context
        val fullView = binding.clayoutMusic
        val image = binding.imgMusicTopChild1
        val name = binding.txtMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadMusicBackGround(mContext, covers[position], fullView)
                loadCenterRoundedCornerImage(mContext, 25, it, image)
            }
            name.text = musicVo.audioName

            itemView.setOnClickListener {
                musicVo.fileName?.let {
                    startMusicActivity(mContext, it)
                }
            }
        }
    }

    inner class ViewHolder4(binding: MusicTopItem2Binding) : ViewHolder(binding.root) {

        val image = binding.imgMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadCenterImage(itemView.context, covers[position], image)
            }

            val lp = itemView.layoutParams
            lp.width = 35
            itemView.layoutParams = lp

            itemView.setOnClickListener {

                val music19 = PetVideo()
                music19.type = VideoType.MUSIC.ordinal
                music19.fileName = "music19"
                music19.code = 1149
                music19.duration = 293
                music19.star = true
                music19.title = "【仙剑一】十五年后，再听灵儿叫一声逍遥哥哥"
                music19.releaseTime = 1584701452
                music19.authorId = 351141843
                music19.cover =
                    "https://i1.hdslb.com/bfs/archive/78fc44827e4d88b5785f418a34a26a930f315e00.jpg"
                music19.vertical = false

                startVideoPlayingActivity(itemView.context, music19)
            }
        }
    }

    inner class ViewHolder5(binding: MusicTopItem1Binding) : ViewHolder(binding.root) {

        val mContext = itemView.context
        val fullView = binding.clayoutMusic
        val image = binding.imgMusicTopChild1
        val name = binding.txtMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadMusicBackGround(mContext, covers[position], fullView)
                loadCenterRoundedCornerImage(mContext, 25, it, image)
            }
            name.text = musicVo.audioName

            val lp = itemView.layoutParams
            lp.width = 35
            itemView.layoutParams = lp

            itemView.setOnClickListener {
                musicVo.fileName?.let {
                    startMusicActivity(mContext, it)
                }
            }
        }
    }

    inner class ViewHolder6(binding: MusicTopItem1Binding) : ViewHolder(binding.root) {

        val mContext = itemView.context
        val fullView = binding.clayoutMusic
        val image = binding.imgMusicTopChild1
        val name = binding.txtMusicTopChild1

        fun handle(position: Int) {
            val musicVo = list[position]
            musicVo.cover?.let {
                loadMusicBackGround(mContext, covers[position], fullView)
                loadCenterRoundedCornerImage(mContext, 25, it, image)
            }
            name.text = musicVo.audioName

            val lp = itemView.layoutParams
            lp.width = 35
            itemView.layoutParams = lp

            itemView.setOnClickListener {
                musicVo.fileName?.let {
                    startMusicActivity(mContext, it)
                }
            }
        }
    }
}