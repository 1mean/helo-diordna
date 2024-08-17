package com.example.pandas.biz.pictureselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.example.pandas.R;
import com.life.publish.lib_selector.widget.BottomNavBar;

public class CustomBottomNavBar extends BottomNavBar implements View.OnClickListener {

    public CustomBottomNavBar(Context context) {
        super(context);
    }

    public CustomBottomNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBottomNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void inflateLayout() {
        inflate(getContext(), R.layout.ps_custom_bottom_nav_bar, this);
    }
}
