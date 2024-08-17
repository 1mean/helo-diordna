package com.example.pandas.biz.pictureselector;

import android.os.Bundle;

import com.life.publish.lib_selector.PictureSelectorPreviewFragment;
import com.life.publish.lib_selector.adapter.PicturePreviewAdapter;

/**
 * @author：luck
 * @date：2022/2/21 4:15 下午
 * @describe：CustomPreviewFragment
 */
public class CustomPreviewFragment extends PictureSelectorPreviewFragment {

    public static CustomPreviewFragment newInstance() {
        CustomPreviewFragment fragment = new CustomPreviewFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public String getFragmentTag() {
        return CustomPreviewFragment.class.getSimpleName();
    }

    @Override
    protected PicturePreviewAdapter createAdapter() {
        return new CustomPreviewAdapter();
    }
}
