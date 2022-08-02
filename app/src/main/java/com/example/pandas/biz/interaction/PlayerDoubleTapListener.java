package com.example.pandas.biz.interaction;

public interface PlayerDoubleTapListener {

    default void onDoubleTapStarted(float posX, float posY) {
    }

    default void onDoubleTapProgressDown(float posX, float posY) {
    }

    default void onDoubleTapProgressUp(float posX, float posY) {
    }

    default void onDoubleTapFinished() {
    }

    default void onScroll(float distanceX, float distanceY) {
    }

    default void onDown() {
    }

    default void onUp() {
    }

    default void onSingleTapUp() {
    }

}