import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.pandas.biz.ext.getLocalFilePath
import com.example.pandas.biz.interaction.ExoPlayerListener
import com.example.pandas.sql.entity.PetVideo
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.IOException
import java.lang.Exception

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 6/27/23 11:35 AM
 * @version: v1.0
 */
public class ShortManager(
    private val context: Context,
    private val exoListener: ExoPlayerListener
) {

    private var _mPlayer: ExoPlayer? = null
    private val mPlayer get() = _mPlayer!!
    private var oldPlayerView: StyledPlayerView? = null

    //缓存所有创建的mediaItems。该创建是相对耗时的操作，缓存起来重用<videoCode,mediaItem>
    private val mediaItemCaches: MutableMap<Int, MediaItem> by lazy { mutableMapOf() }

    fun initPlayer() {
        if (_mPlayer == null) {
            _mPlayer = ExoPlayer.Builder(context).build()
            mPlayer.addListener(mListener)
            mPlayer.addAnalyticsListener(object : AnalyticsListener {

                override fun onAudioCodecError(
                    eventTime: AnalyticsListener.EventTime,
                    audioCodecError: Exception
                ) {
                    super.onAudioCodecError(eventTime, audioCodecError)
                    Log.e(
                        "2mean",
                        "onAudioCodecError audioCodecError:${audioCodecError.toString()}"
                    )
                }

                override fun onAudioSinkError(
                    eventTime: AnalyticsListener.EventTime,
                    audioSinkError: Exception
                ) {
                    super.onAudioSinkError(eventTime, audioSinkError)
                    Log.e("2mean", "onAudioSinkError audioSinkError:${audioSinkError.toString()}")
                }

                override fun onDrmSessionManagerError(
                    eventTime: AnalyticsListener.EventTime,
                    error: Exception
                ) {
                    super.onDrmSessionManagerError(eventTime, error)
                    Log.e("2mean", "onDrmSessionManagerError error:${error.toString()}")
                }

                override fun onLoadError(
                    eventTime: AnalyticsListener.EventTime,
                    loadEventInfo: LoadEventInfo,
                    mediaLoadData: MediaLoadData,
                    error: IOException,
                    wasCanceled: Boolean
                ) {
                    super.onLoadError(eventTime, loadEventInfo, mediaLoadData, error, wasCanceled)
                    Log.e("2mean", "onLoadError error:${error.toString()}")
                }

                override fun onPlayerError(
                    eventTime: AnalyticsListener.EventTime,
                    error: PlaybackException
                ) {
                    super.onPlayerError(eventTime, error)
                    Log.e("2mean", "onPlayerError error:${error.toString()}")
                }

                override fun onVideoCodecError(
                    eventTime: AnalyticsListener.EventTime,
                    videoCodecError: Exception
                ) {
                    super.onVideoCodecError(eventTime, videoCodecError)
                    Log.e(
                        "2mean",
                        "onVideoCodecError videoCodecError:${videoCodecError.toString()}"
                    )
                }

                override fun onPlayerErrorChanged(
                    eventTime: AnalyticsListener.EventTime,
                    error: PlaybackException?
                ) {
                    super.onPlayerErrorChanged(eventTime, error)
                    Log.e("2mean", "onPlayerErrorChanged PlaybackException:${error.toString()}")
                }

                override fun onTracksChanged(
                    eventTime: AnalyticsListener.EventTime,
                    tracks: Tracks
                ) {
                    super.onTracksChanged(eventTime, tracks)
                    Log.e("2mean", "onTracksChanged tracks:${tracks.toString()}")
                }

                override fun onTrackSelectionParametersChanged(
                    eventTime: AnalyticsListener.EventTime,
                    trackSelectionParameters: TrackSelectionParameters
                ) {
                    super.onTrackSelectionParametersChanged(eventTime, trackSelectionParameters)
                    Log.e(
                        "2mean",
                        "onTrackSelectionParametersChanged trackSelectionParameters:${trackSelectionParameters.toString()}"
                    )
                }
            })
        }
    }

    fun addMediaItems(list: MutableList<PetVideo>) {
        if (list.isNotEmpty()) {
            val mediaItems = mutableListOf<MediaItem>()
            list.forEach {
                val file = getLocalFilePath(context, it.fileName!!)
                val mediaItem =
                    MediaItem.Builder().setUri(Uri.fromFile(file))
                        .setMediaId(it.code.toString()).build()
                mediaItems.add(mediaItem)
                mediaItemCaches[it.code] = mediaItem
            }
            mPlayer.addMediaItems(mediaItems)
        }
    }

    fun play(playerView: StyledPlayerView, list: MutableList<PetVideo>) {

        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        this.oldPlayerView = playerView

        val mediaItems = mutableListOf<MediaItem>()
        list.forEach {
            val file = getLocalFilePath(context, it.fileName!!)
            val mediaItem =
                MediaItem.Builder().setUri(Uri.fromFile(file))
                    .setMediaId(it.code.toString()).build()
            mediaItems.add(mediaItem)
            mediaItemCaches[it.code] = mediaItem
        }
        mPlayer.addMediaItems(mediaItems)
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    val mListener = object : Player.Listener {

        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                Player.STATE_BUFFERING -> {//可以通过isPlaying和seek动作来处理界面相关
                }
                Player.STATE_READY -> {//视频已经准备好，此时isPlaying=true
                }
                Player.STATE_IDLE -> {//暂停不会触发
                    Log.e("RecoPlayManager", "STATE_IDLE")
                }
                Player.STATE_ENDED -> {//播放结束
                    Log.e("RecoPlayManager", "STATE_ENDED")
                }
            }
        }

        //回调后，立马执行 STATE_BUFFERING
        override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
            super.onPlayWhenReadyChanged(playWhenReady, reason)
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
            Log.e(
                "2mean",
                "ExoPlayer error: ${error.errorCode},${error.errorCodeName},${error.toString()}"
            )
        }

        //当 #{isPlaying()} 的值改变时调用 ，是否player正在播放中
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            super.onIsPlayingChanged(isPlaying)
            exoListener.isPlayingChanged(isPlaying)
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        override fun onIsLoadingChanged(isLoading: Boolean) {
            super.onIsLoadingChanged(isLoading)
        }
    }

    fun seekTo(position: Int, playerView: StyledPlayerView) {
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        this.oldPlayerView = playerView
        mPlayer.seekTo(position, 0)
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    fun isPlaying(): Boolean = mPlayer.isPlaying

    fun pause() {
        mPlayer.pause()
    }

    fun continuePlayer() {
        if (!mPlayer.isPlaying && mPlayer.playbackState == Player.STATE_READY) {
            mPlayer.playWhenReady = true
        }
    }

    fun againOnResume(playerView: StyledPlayerView,currentPosition:Int) {

        if (_mPlayer != null && mPlayer.playWhenReady) return

        initPlayer()
        mPlayer.repeatMode = Player.REPEAT_MODE_ONE
        StyledPlayerView.switchTargetView(mPlayer, oldPlayerView, playerView)
        this.oldPlayerView = playerView

        if (mediaItemCaches.isNotEmpty()) {
            mPlayer.addMediaItems(mediaItemCaches.values.toList())
            mPlayer.seekTo(currentPosition, 0)
        }
        mPlayer.playWhenReady = true
        mPlayer.prepare()
    }

    fun release() {
        mPlayer.removeListener(mListener)
        mPlayer.release()
        oldPlayerView = null
        _mPlayer = null
    }
}