import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

/**
 * @description: video play
 * @author: dongyiming
 * @date: 1/1/22 3:56 下午
 * @version: v1.0
 */
public class VideoPlayManager(private val context:Context) {

    private var _mPlayer:ExoPlayer?= null
    private val mPlayer get() = _mPlayer!!
    init{


    }

    private fun initPlayer(playUri: String?) {

        if (playUri == null){
            Log.d("ExoTest", "playUri is null!")
            return
        }

        /* 1.创建SimpleExoPlayer实例 */
        _mPlayer = ExoPlayer.Builder(context).build()

        /* 2.创建播放菜单并添加到播放器 */
        val firstLocalMediaItem = MediaItem.fromUri(playUri)
        mPlayer.addMediaItem(firstLocalMediaItem)

        /* 3.设置播放方式为自动播放 */
        mPlayer.playWhenReady = true

        /* 4.将SimpleExoPlayer实例设置到StyledPlayerView中 */
        //mPlayerView.player = mPlayer

        /* 5，设置播放器状态为prepare */
        mPlayer.prepare()
    }
}