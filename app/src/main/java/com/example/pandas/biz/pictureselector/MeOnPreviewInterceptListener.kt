package com.example.pandas.biz.pictureselector

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.luck.picture.lib.basic.FragmentInjectManager
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener

/**
 * @description: 自定义预览
 * @author: dongyiming
 * @date: 9/1/23 7:54 PM
 * @version: v1.0
 */
public class MeOnPreviewInterceptListener: OnPreviewInterceptListener {

    override fun onPreview(
        context: Context?,
        position: Int,
        totalNum: Int,
        page: Int,
        currentBucketId: Long,
        currentAlbumName: String?,
        isShowCamera: Boolean,
        data: ArrayList<LocalMedia>?,
        isBottomPreview: Boolean
    ) {
        val previewFragment: CustomPreviewFragment = CustomPreviewFragment.newInstance()
        previewFragment.setInternalPreviewData(
            isBottomPreview, currentAlbumName, isShowCamera,
            position, totalNum, page, currentBucketId, data
        )
        FragmentInjectManager.injectFragment(
            context as FragmentActivity?,
            CustomPreviewFragment.TAG,
            previewFragment
        )
    }

}