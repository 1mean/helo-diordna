import android.content.Context
import com.google.android.exoplayer2.ExoPlayer

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/28/22 4:38 下午
 * @version: v1.0
 */
public class ExoPlayerManager {

    private var mPlayer: ExoPlayer? = null

    private fun initPlayer(context: Context) {

        if (mPlayer == null) {
            mPlayer = ExoPlayer.Builder(context).build()
        }
    }

}