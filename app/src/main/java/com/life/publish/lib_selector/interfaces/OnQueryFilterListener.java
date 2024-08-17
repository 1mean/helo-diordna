package com.life.publish.lib_selector.interfaces;

import com.life.publish.lib_selector.entity.LocalMedia;

/**
 * @author：luck
 * @date：2022/3/12 10:09 上午
 * @describe：OnQueryFilterListener
 */
public interface OnQueryFilterListener {
    /**
     * You need to filter out what doesn't meet the standards
     *
     * @return the boolean result
     */
    boolean onFilter(LocalMedia media);
}
