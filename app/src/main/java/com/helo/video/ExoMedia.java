package com.helo.video;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.pandas.bean.MediaInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.google.android.exoplayer2.Player.STATE_READY;

/**
 * @description: exoplayer2[已废弃], 先不使用Media3
 * @author: dongyiming
 * @date: 9/9/24 PM3:14
 * @version: v1.0
 */
public class ExoMedia {

    private final Map<Integer, MediaItemInfo> mediaItemsCache = new ConcurrentHashMap<>();
    private ExoPlayer exoPlayer;
    private final Context mContext;
    private final int repeatMode;
    private final StyledPlayerView playerView;
    private StyledPlayerView oldPlayerView;
    private final MediaInfo mediaInfo;
    private final MediaIndexMap mediaIndexs = new MediaIndexMap();//存储资源文件信息
    private int playingPosition;//正在播放的视频在adapter里的位置
    private ExoMediaListener listener;

    public ExoMedia(Context context, ExoPlayer exoPlayer, StyledPlayerView playerView, int repeatMode, boolean isOpenVoice, MediaInfo mediaInfo, ExoMediaListener listener) {
        this.mContext = context;
        this.repeatMode = repeatMode;
        this.playerView = playerView;
        this.mediaInfo = mediaInfo;
        this.exoPlayer = exoPlayer;
        this.listener = listener;
    }

    public void play() {

        if (exoPlayer == null) {
            exoPlayer = new ExoPlayer.Builder(mContext).build();
        }
        exoPlayer.addListener(playerListener);
        exoPlayer.setRepeatMode(repeatMode);
        StyledPlayerView.switchTargetView(exoPlayer, oldPlayerView, playerView);
        oldPlayerView = playerView;

        int videoCode = mediaInfo.getVideoCode();
        long playPos = mediaInfo.getPlayPos();
        if (mediaIndexs.exist(videoCode)) {
            if (mediaIndexs.get(videoCode) != null) {
                exoPlayer.seekTo(mediaIndexs.indexOf(videoCode), playPos);
            }
        } else {
            synchronized (mediaItemsCache) {
                if (mediaItemsCache.containsKey(videoCode)) {
                    MediaItemInfo mediaItemInfo = mediaItemsCache.get(videoCode);
                    if (mediaItemInfo != null && mediaItemInfo.mediaItem != null) {
                        exoPlayer.addMediaItem(mediaItemInfo.mediaItem);
                        int index = mediaIndexs.add(mediaInfo);
                        exoPlayer.seekTo(index, mediaItemInfo.playPosition);
                    }
                } else {
                    MediaItem mediaItem =
                            new MediaItem.Builder().setUri(Uri.fromFile(new File(mediaInfo.getPlayUrl())))
                                    .setMediaId(String.valueOf(mediaInfo.getVideoCode())).build();
                    int index = mediaIndexs.add(mediaInfo);
                    mediaItemsCache.put(videoCode, new MediaItemInfo(mediaItem, playPos));
                    exoPlayer.addMediaItem(mediaItem);
                    exoPlayer.seekTo(index, playPos);
                }
            }
        }
        //this.playPos = position;
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.prepare();
    }

    public void pausePlayer() {
        if (exoPlayer != null && exoPlayer.isPlaying() && exoPlayer.getCurrentMediaItem() != null) {
            String videoCode = exoPlayer.getCurrentMediaItem().mediaId;
            if (!videoCode.isEmpty()) {
                synchronized (mediaItemsCache) {
                    if (mediaItemsCache.containsKey(Integer.valueOf(videoCode))) {
                        MediaItemInfo mediaItemInfo = mediaItemsCache.get(Integer.valueOf(videoCode));
                        if (mediaItemInfo != null) {
                            mediaItemInfo.playPosition = exoPlayer.getCurrentPosition();
                            mediaItemsCache.put(Integer.valueOf(videoCode), mediaItemInfo);
                        }
                    } else {
                        Log.e("1mean", "Pause Error: 当前播放的MediaItem，并未存储 .");
                    }
                }
                mediaIndexs.updatePlayingPosition(Integer.parseInt(videoCode), exoPlayer.getCurrentPosition());
                //playPos = -1
                exoPlayer.pause();
            } else {
                Log.e("1mean", "Pause Error: videoCode is null .");
            }
        }
    }

    public void releasePlayer() {
        if (exoPlayer != null && exoPlayer.getCurrentMediaItem() != null) {
            String videoCode = exoPlayer.getCurrentMediaItem().mediaId;
            if (!videoCode.isEmpty()) {
                synchronized (mediaItemsCache) {
                    if (mediaItemsCache.containsKey(Integer.valueOf(videoCode))) {
                        MediaItemInfo mediaItemInfo = mediaItemsCache.get(Integer.valueOf(videoCode));
                        if (mediaItemInfo != null) {
                            mediaItemInfo.playPosition = exoPlayer.getCurrentPosition();
                            mediaItemsCache.put(Integer.valueOf(videoCode), mediaItemInfo);
                        }
                    } else {
                        Log.e("1mean", "Pause Error: 当前播放的MediaItem，并未存储 .");
                    }
                }
                mediaIndexs.updatePlayingPosition(Integer.parseInt(videoCode), exoPlayer.getCurrentPosition());
                exoPlayer.removeListener(playerListener);
                exoPlayer.release();
                mediaIndexs.clear();
                oldPlayerView = null;
                exoPlayer = null;
                //playPos = -1
            } else {
                Log.e("1mean", "Release Error: videoCode is null .");
            }
        }
    }

    public void resumePlay() {
        if (exoPlayer != null && !exoPlayer.isPlaying() && exoPlayer.getPlaybackState() == STATE_READY) {
            exoPlayer.setPlayWhenReady(true);
        }
    }
//
//    /**
//     * deviceVolume [0,16]
//     * volume [0,1.0]
//     */
//    fun updateVolume(isOpen:Boolean) {
//
//        this.isOpenVoice = isOpen
//        if (isOpen) {//打开视频声音
//            mPlayer.volume = mPlayer.deviceVolume.toFloat() / 16
//        } else {
//            mPlayer.volume = 0f
//        }
//    }

    public static class Builder {

        private final Context context;
        private StyledPlayerView playerView;
        private int repeatMode;
        private boolean isOpenVoice;
        private ExoMediaListener listener;
        private MediaInfo mediaInfo;
        private ExoPlayer exoPlayer;

        public Builder(Context context) {
            this.context = context;
            if (exoPlayer == null) {//需要在onStart()方法里初始化
                exoPlayer = new ExoPlayer.Builder(context).build();
            }
        }

        public Builder addPlayerView(StyledPlayerView playerView) {
            this.playerView = playerView;
            return this;
        }

        public Builder setRepeatMode(int mode) {
            this.repeatMode = mode;
            return this;
        }

        public Builder isOpenVoice(boolean isOpen) {
            this.isOpenVoice = isOpen;
            return this;
        }

        public Builder addListener(ExoMediaListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.mediaInfo = mediaInfo;
            return this;
        }

        public ExoMedia build() {
            return new ExoMedia(context, exoPlayer, playerView, repeatMode, isOpenVoice, mediaInfo, listener);
        }
    }

    public interface ExoMediaListener {

        public void isPlayingChanged(boolean isPlaying);
    }

    private final Player.Listener playerListener = new Player.Listener() {

        @Override
        public void onPlaybackStateChanged(int playbackState) {
            Player.Listener.super.onPlaybackStateChanged(playbackState);
            switch (playbackState) {
                case Player.STATE_BUFFERING: {
                    Log.e("ExoMediaManager", "STATE_BUFFERING");
                }
                case STATE_READY: {
                    Log.e("ExoMediaManager", "STATE_READY: ${mPlayer.isPlaying}");
                }
                case Player.STATE_IDLE: {
                    Log.e("ExoMediaManager", "STATE_IDLE");
                }
                case Player.STATE_ENDED: {
                    Log.e("ExoMediaManager", "STATE_ENDED");
                }
            }
        }

        @Override
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            Player.Listener.super.onPlayWhenReadyChanged(playWhenReady, reason);

        }

        //当 #{isPlaying()} 的值改变时调用 ，是否player正在播放中
        @Override
        public void onIsPlayingChanged(boolean isPlaying) {
            Player.Listener.super.onIsPlayingChanged(isPlaying);
            if (listener != null) {
                listener.isPlayingChanged(isPlaying);
            }
        }

        //player开始/停止加载资源文件,每隔7秒就会回调两次，先true后false，可能是先加载缓冲，加载完了请求网络
        @Override
        public void onIsLoadingChanged(boolean isLoading) {
            Player.Listener.super.onIsLoadingChanged(isLoading);
        }
    };

    /**
     * 存储PlayingInfo,播放器内的资源位置和存入时的位置相同
     */
    private static class MediaIndexMap {

        // 添加的顺序 = 播放器内资源文件的顺序
        private final LinkedHashMap<Integer, MediaInfo> playInfoMap = new LinkedHashMap<>();

        public int add(MediaInfo playInfo) {
            if (playInfoMap.isEmpty()) {
                playInfoMap.put(playInfo.getVideoCode(), playInfo);
                return 0;
            } else {
                if (playInfoMap.containsKey(playInfo.getVideoCode())) {
                    return indexOf(playInfo.getVideoCode());
                } else {
                    playInfoMap.put(playInfo.getVideoCode(), playInfo);
                    return (playInfoMap.size() - 1);
                }
            }
        }

        public MediaInfo get(int videoCode) {
            return playInfoMap.get(videoCode);
        }

        public void updatePlayingPosition(int videoCode, Long playPos) {
            MediaInfo playInfo = playInfoMap.get(videoCode);
            if (playInfo != null) {
                playInfo.setPlayPos(playPos);
                playInfoMap.put(videoCode, playInfo);
            }
        }

        public boolean exist(int videoCode) {
            return playInfoMap.containsKey(videoCode);
        }

        public int indexOf(int videoCode) {
            Set<Integer> keys = playInfoMap.keySet();
            int index = 0;
            for (int item : keys) {
                if (item == videoCode) {
                    return index;
                }
                index++;
            }
            return -1;
        }

        public void clear() {
            if (!playInfoMap.isEmpty()) playInfoMap.clear();
        }
    }

    public static class MediaItemInfo {
        long playPosition;
        MediaItem mediaItem;

        public MediaItemInfo(MediaItem mediaItem, long playPosition) {
            this.mediaItem = mediaItem;
            this.playPosition = playPosition;
        }
    }
}
