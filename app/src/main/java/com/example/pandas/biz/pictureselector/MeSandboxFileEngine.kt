package com.example.pandas.biz.pictureselector

import android.content.Context
import com.luck.picture.lib.engine.UriToFileTransformEngine
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener
import com.luck.picture.lib.utils.SandboxTransformUtils

/**
 * @description: 自定义沙盒文件处理
 * @author: dongyiming
 * @date: 9/1/23 6:30 PM
 * @version: v1.0
 */
public class MeSandboxFileEngine : UriToFileTransformEngine {
    override fun onUriToFileAsyncTransform(
        context: Context?,
        srcPath: String?,
        mineType: String?,
        call: OnKeyValueResultCallbackListener?
    ) {
        call?.onCallback(
            srcPath,
            SandboxTransformUtils.copyPathToSandbox(context, srcPath, mineType)
        )
    }

}