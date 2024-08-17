package com.example.pandas.um

import android.app.Activity
import com.android.android_sqlite.entity.PetVideo
import com.example.pandas.biz.ext.getLocalFilePath
import com.umeng.socialize.ShareAction
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMVideo

/**
 * @description: 用于处理友盟分享相关
 * @author: dongyiming
 * @date: 8/5/22 7:59 下午
 * @version: v1.0
 */

val shareManager: ShareManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ShareManager() }

public class ShareManager {

    fun shareLocalVideo(activity: Activity, video: PetVideo, shareType: SHARE_MEDIA) {

        video.fileName?.let {
            val file = getLocalFilePath(activity, it)
            if (file.exists()) {
                val localVideo = UMVideo("http://video.sina.com.cn/p/sports/2020-01-15/detail-iihnzhha2647094.d.html")
                localVideo.title = video.title
                video.user?.let { acthor ->
                    localVideo.description = acthor.userName
                    ShareAction(activity).withMedia(localVideo)
                        .setPlatform(shareType).share()
                }
            }
        }
    }

}