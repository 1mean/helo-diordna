package com.example.pandas.biz.interaction

/**
 * @description: ExoPlayerListener
 * @author: dongyiming
 * @date: 6/18/22 10:50 下午
 * @version: v1.0
 */
public interface ExoPlayerListener {

    /**
     * 对播放器显示的视图进行处理
     *  - hidePlayer：显示/关闭
     *  - curPos: 当前需要操作的item在adapter里的位置
     */
    fun updatePlayerView(hidePlayer: Boolean, curPos: Int)
}