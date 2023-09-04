package com.example.pandas.ui.view.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.pandas.R;
import com.luck.picture.lib.style.TitleBarStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.widget.PreviewTitleBar;

/**
 * @author：luck
 * @date：2021/11/19 4:38 下午
 * @describe：CustomPreviewTitleBar
 */
public class CustomPreviewTitleBar extends PreviewTitleBar {

    public CustomPreviewTitleBar(Context context) {
        super(context);
    }

    public CustomPreviewTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPreviewTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
