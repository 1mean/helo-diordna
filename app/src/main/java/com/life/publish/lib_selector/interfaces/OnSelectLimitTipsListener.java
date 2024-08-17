package com.life.publish.lib_selector.interfaces;

import android.content.Context;

import androidx.annotation.Nullable;

import com.life.publish.lib_selector.config.SelectorConfig;
import com.life.publish.lib_selector.config.SelectLimitType;
import com.life.publish.lib_selector.entity.LocalMedia;

/**
 * @author：luck
 * @date：2022/1/8 2:12 下午
 * @describe：OnSelectLimitTipsListener
 */
public interface OnSelectLimitTipsListener {
    /**
     * Custom limit tips
     *
     * @param media Current Selection {@link LocalMedia}
     * @param config    PictureSelectionConfig
     * @param limitType Use {@link SelectLimitType}
     * @return If true is returned, the user needs to customize the implementation prompt content，
     * Otherwise, use the system default prompt
     */
    boolean onSelectLimitTips(Context context, @Nullable LocalMedia media, SelectorConfig config, int limitType);
}
