package com.lxj.xpopup.animator;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;

import com.lxj.xpopup.enums.PopupAnimation;

/**
 * Description: 平移动画，不带渐变
 * Create by dance, at 2018/12/9
 */
public class TranslateAnimator extends PopupAnimator {
    public float startTranslationX, startTranslationY;
    public float endTranslationX, endTranslationY;
    public TranslateAnimator(View target, int animationDuration, PopupAnimation popupAnimation) {
        super(target, animationDuration, popupAnimation);
    }

    @Override
    public void initAnimator() {
        if(!hasInit){
            endTranslationX = targetView.getTranslationX();
            endTranslationY = targetView.getTranslationY();
            // 设置起始坐标
            applyTranslation();
            startTranslationX = targetView.getTranslationX();
            startTranslationY = targetView.getTranslationY();
        }
    }

    private void applyTranslation() {
        Log.e("xpopu","translationY6");
        switch (popupAnimation) {
            case TranslateFromLeft:
                targetView.setTranslationX(-targetView.getRight() + targetView.getTranslationX());
                break;
            case TranslateFromTop:
                targetView.setTranslationY(-targetView.getBottom() + targetView.getTranslationY());
                break;
            case TranslateFromRight:
                targetView.setTranslationX(((View) targetView.getParent()).getMeasuredWidth() - targetView.getLeft() + targetView.getTranslationX());
                break;
            case TranslateFromBottom:
                targetView.setTranslationY(((View) targetView.getParent()).getMeasuredHeight() - targetView.getTop() + targetView.getTranslationY());
                break;
        }
    }

    @Override
    public void animateShow() {
        Log.e("xpopu","1000");
        ViewPropertyAnimator animator = null;
        switch (popupAnimation) {
            case TranslateFromLeft:
            case TranslateFromRight:
                animator = targetView.animate().translationX(endTranslationX);
                break;
            case TranslateFromTop:
            case TranslateFromBottom:
                //TODO:从底下谈出来时，总是要先在底下停一会再上来
                Log.e("xpopu","translationY5");
//                animator = targetView.animate().translationY(endTranslationY);
                break;
        }

//        if (animator != null) animator.setInterpolator(new LinearInterpolator())
//                .setDuration(animationDuration)
//                .withLayer()
//                .start();
        Log.e("part", "start: " + targetView.getTranslationY() + "  endy: " + endTranslationY);
    }

    @Override
    public void animateDismiss() {
        if (animating) return;
        ViewPropertyAnimator animator = null;
        switch (popupAnimation) {
            case TranslateFromLeft:
                startTranslationX = -targetView.getRight();
                animator = targetView.animate().translationX(startTranslationX);
                break;
            case TranslateFromTop:
                Log.e("xpopu","translationY7");
                startTranslationY = -targetView.getBottom();
                animator = targetView.animate().translationY(startTranslationY);
                break;
            case TranslateFromRight:
                startTranslationX = ((View) targetView.getParent()).getMeasuredWidth() - targetView.getLeft();
                animator = targetView.animate().translationX(startTranslationX);
                break;
            case TranslateFromBottom:
                Log.e("xpopu","translationY6");
                startTranslationY = ((View) targetView.getParent()).getMeasuredHeight() - targetView.getTop();
                animator = targetView.animate().translationY(startTranslationY);
                break;
        }
        if (animator != null)
            observerAnimator(animator.setInterpolator(new FastOutSlowInInterpolator())
                    .setDuration((long) (animationDuration * .8))
                    .withLayer())
                    .start();
    }
}
