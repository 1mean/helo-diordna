package com.lxj.xpopup.animator;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.util.Log;
import android.view.View;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupAnimation;

/**
 * Description: 平移动画
 * Create by dance, at 2018/12/9
 */
public class TranslateAlphaAnimator extends PopupAnimator {
    //动画起始坐标
    private float startTranslationX, startTranslationY;
    private float defTranslationX, defTranslationY;
    public TranslateAlphaAnimator(View target, int animationDuration, PopupAnimation popupAnimation) {
        super(target, animationDuration, popupAnimation);
    }

    @Override
    public void initAnimator() {
        defTranslationX = targetView.getTranslationX();
        defTranslationY = targetView.getTranslationY();

        targetView.setAlpha(0);
        // 设置移动坐标
        applyTranslation();
        startTranslationX = targetView.getTranslationX();
        startTranslationY = targetView.getTranslationY();
    }

    private void applyTranslation() {

        Log.e("xpopu","translationY3");
        switch (popupAnimation){
            case TranslateAlphaFromLeft:
                targetView.setTranslationX(-(targetView.getMeasuredWidth()/* + halfWidthOffset*/));
                break;
            case TranslateAlphaFromTop:
                targetView.setTranslationY(-(targetView.getMeasuredHeight() /*+ halfHeightOffset*/));
                break;
            case TranslateAlphaFromRight:
                targetView.setTranslationX(targetView.getMeasuredWidth() /*+ halfWidthOffset*/);
                break;
            case TranslateAlphaFromBottom:
                targetView.setTranslationY(targetView.getMeasuredHeight() /*+ halfHeightOffset*/);
                break;
        }
    }

    @Override
    public void animateShow() {
        Log.e("xpopu","TranslationY2");
        targetView.animate().translationX(defTranslationX).translationY(defTranslationY).alpha(1f)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(animationDuration)
                .withLayer()
                .start();
    }

    @Override
    public void animateDismiss() {
        if(animating)return;
        Log.e("xpopu","translationY4");
        observerAnimator(targetView.animate().translationX(startTranslationX).translationY(startTranslationY).alpha(0f)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(animationDuration)
                .withLayer())
                .start();
    }
}
