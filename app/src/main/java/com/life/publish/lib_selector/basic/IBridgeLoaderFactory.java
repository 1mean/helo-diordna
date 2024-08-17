package com.life.publish.lib_selector.basic;

import com.life.publish.lib_selector.loader.IBridgeMediaLoader;

/**
 * @author：luck
 * @date：2022/6/10 9:37 上午
 * @describe：IBridgeLoaderFactory
 */
public interface IBridgeLoaderFactory {
    /**
     * CreateLoader
     */
    IBridgeMediaLoader onCreateLoader();
}
