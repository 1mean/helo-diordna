package com.example.pandas.biz.pictureselector

import android.content.Context
import com.life.publish.lib_selector.engine.UriToFileTransformEngine
import com.life.publish.lib_selector.interfaces.OnKeyValueResultCallbackListener
import com.life.publish.lib_selector.utils.SandboxTransformUtils

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