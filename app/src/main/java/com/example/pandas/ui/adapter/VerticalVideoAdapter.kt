package com.example.pandas.ui.adapter
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.eyes.EyepetozerItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/24/22 12:26 上午
 * @version: v1.0
 */
public class VerticalVideoAdapter(
    private val list: MutableList<EyepetozerItem>,
    private val call: VideoCallBack
) : BaseCommonAdapter<EyepetozerItem>(list) {

    private var mPlayer: ExoPlayer? = null

    override fun getLayoutId(): Int = R.layout.adapter_vertical_video

    override fun convert(holder: BaseViewHolder, data: EyepetozerItem, position: Int) {

        call.play(data.playUrl, holder.getWidget(R.id.playView))
//        if (data.playUrl != null) {
//
//            val playView = holder.getWidget<PlayerView>(R.id.playView)
//            //1.创建SimpleExoPlayer实例
//            if (mPlayer == null) {
//                mPlayer = ExoPlayer.Builder(holder.itemView.context).build()
//                playView.player = mPlayer
//
//            }
//
//            //2.创建播放菜单并添加到播放器
//            val firstLocalMediaItem = MediaItem.fromUri(data.playUrl!!)
//
//            mPlayer?.let {
//                it.repeatMode = Player.REPEAT_MODE_ALL
//                it.addMediaItem(firstLocalMediaItem)
//                it.playWhenReady = true//3.设置播放方式为自动播放
//                it.prepare()//设置播放器状态为prepare
//            }
//        }
    }

    interface VideoCallBack {
        fun play(url: String?, playerView: PlayerView)
    }
}