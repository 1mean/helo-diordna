package com.example.pandas.biz.manager

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer

/**
 * @description: 处理全局的Exoplayer
 * @author: dongyiming
 * @date: 2/28/22 4:38 下午
 * @version: v1.0
 */
public class ExoPlayerManager private constructor() {

    private var mPlayer: ExoPlayer? = null

    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = ExoPlayerManager()
    }

    private fun initPlayer(context: Context) {

        if (mPlayer == null) {
            mPlayer = ExoPlayer.Builder(context).build()
        }
    }

}