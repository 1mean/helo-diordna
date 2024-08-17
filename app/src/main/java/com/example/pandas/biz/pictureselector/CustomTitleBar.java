package com.example.pandas.biz.pictureselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.pandas.R;
import com.life.publish.lib_selector.widget.TitleBar;

public class CustomTitleBar extends TitleBar implements View.OnClickListener {


    public TextView getTitleCancelView() {
        return tvCancel;
    }

    public CustomTitleBar(Context context) {
        super(context);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void inflateLayout() {
        inflate(getContext(), R.layout.ps_custom_title_bar, this);
    }

    @Override
    public void setTitleBarStyle() {
        super.setTitleBarStyle();
    }
}
