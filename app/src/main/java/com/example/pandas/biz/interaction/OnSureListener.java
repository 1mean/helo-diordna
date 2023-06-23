package com.example.pandas.biz.interaction;

/**
 * OnSureListener
 *
 * @author: dongyiming
 * @date: 8/18/22 6:24 下午
 * @version: v1.0
 */
public interface OnSureListener {

    default void onSure() {

    }

    default void onCancel() {

    }

    default void onSure(int type) {

    }
}
