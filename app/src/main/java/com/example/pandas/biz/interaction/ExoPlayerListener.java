package com.example.pandas.biz.interaction;

public interface ExoPlayerListener {

    default void updatePlayerView(boolean hidePlayer, int curPos) {

    }

    default void isPlayingChanged(boolean isPlaying) {

    }
}
