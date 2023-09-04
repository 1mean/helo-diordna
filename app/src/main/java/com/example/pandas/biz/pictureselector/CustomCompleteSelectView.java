package com.example.pandas.biz.pictureselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;

import com.example.pandas.R;
import com.luck.picture.lib.widget.CompleteSelectView;

public class CustomCompleteSelectView extends CompleteSelectView {
    public CustomCompleteSelectView(Context context) {
        super(context);
    }

    public CustomCompleteSelectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCompleteSelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void inflateLayout() {
        LayoutInflater.from(getContext()).inflate(R.layout.ps_custom_complete_selected_layout, this);
    }

    @Override
    public void setCompleteSelectViewStyle() {
        super.setCompleteSelectViewStyle();
    }
}
