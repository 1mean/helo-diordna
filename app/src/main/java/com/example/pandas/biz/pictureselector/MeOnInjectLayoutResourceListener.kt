package com.example.pandas.biz.pictureselector

import android.content.Context
import com.example.pandas.R
import com.life.publish.lib_selector.config.InjectResourceSource
import com.life.publish.lib_selector.interfaces.OnInjectLayoutResourceListener

/**
 * @description: 注入自定义布局UI，前提是布局View id 和 根目录Layout必须一致
 * @author: dongyiming
 * @date: 9/1/23 8:06 PM
 * @version: v1.0
 */
public class MeOnInjectLayoutResourceListener : OnInjectLayoutResourceListener {
    override fun getLayoutResourceId(context: Context?, resourceSource: Int): Int {
        return when (resourceSource) {
            InjectResourceSource.MAIN_SELECTOR_LAYOUT_RESOURCE -> {
                R.layout.ps_custom_fragment_selector
            }
            InjectResourceSource.PREVIEW_LAYOUT_RESOURCE -> R.layout.ps_custom_fragment_preview
            InjectResourceSource.MAIN_ITEM_IMAGE_LAYOUT_RESOURCE -> {
                R.layout.ps_custom_item_grid_image
            }
            InjectResourceSource.MAIN_ITEM_VIDEO_LAYOUT_RESOURCE -> {
                R.layout.ps_custom_item_grid_video
            }
            InjectResourceSource.MAIN_ITEM_AUDIO_LAYOUT_RESOURCE -> R.layout.ps_custom_item_grid_audio
            InjectResourceSource.ALBUM_ITEM_LAYOUT_RESOURCE -> R.layout.ps_custom_album_folder_item
            InjectResourceSource.PREVIEW_ITEM_IMAGE_LAYOUT_RESOURCE -> {
                R.layout.ps_custom_preview_image
            }
            InjectResourceSource.PREVIEW_ITEM_VIDEO_LAYOUT_RESOURCE -> R.layout.ps_custom_preview_video
            InjectResourceSource.PREVIEW_GALLERY_ITEM_LAYOUT_RESOURCE -> R.layout.ps_custom_preview_gallery_item
            else -> 0
        }
    }

}