package com.lxj.xpopup.core;

import static com.lxj.xpopup.enums.PopupAnimation.NoAnimation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.animator.BlurAnimator;
import com.lxj.xpopup.animator.EmptyAnimator;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.animator.ScaleAlphaAnimator;
import com.lxj.xpopup.animator.ScrollScaleAnimator;
import com.lxj.xpopup.animator.ShadowBgAnimator;
import com.lxj.xpopup.animator.TranslateAlphaAnimator;
import com.lxj.xpopup.animator.TranslateAnimator;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.lxj.xpopup.util.KeyboardUtils;
import com.lxj.xpopup.util.XPopupUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 弹窗基类
 * Create by lxj, at 2018/12/7
 */
public abstract class BasePopupView extends FrameLayout implements LifecycleObserver, LifecycleOwner,
        ViewCompat.OnUnhandledKeyEventListenerCompat {
    public PopupInfo popupInfo;
    protected PopupAnimator popupContentAnimator;
    protected ShadowBgAnimator shadowBgAnimator;
    protected BlurAnimator blurAnimator;
    private final int touchSlop;
    public PopupStatus popupStatus = PopupStatus.Dismiss;
    protected boolean isCreated = false;
    private boolean hasModifySoftMode = false;
    private int preSoftMode = -1;
    public boolean hasMoveUp = false;
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected LifecycleRegistry lifecycleRegistry;

    public BasePopupView(@NonNull Context context) {
        super(context);
        Log.e("BasePopupView", "BasePopupView");
        if (context instanceof Application) {
            throw new IllegalArgumentException("XPopup的Context必须是Activity类型！");
        }
        lifecycleRegistry = new LifecycleRegistry(this);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setId(View.generateViewId());
        View contentView = LayoutInflater.from(context).inflate(getInnerLayoutId(), this, false);
        contentView.setAlpha(0);
        addView(contentView);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("BasePopupView", "onAttachedToWindow");
        init();
    }

    public BasePopupView show() {
        Log.e("BasePopupView", "show");
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return this;
        }
        if (popupInfo == null) {
            throw new IllegalArgumentException("popupInfo is null, if your popup object is reused, do not set isDestroyOnDismiss(true) !");
        }
        if (popupStatus == PopupStatus.Showing || popupStatus == PopupStatus.Dismissing)
            return this;
        popupStatus = PopupStatus.Showing;
//        if (popupInfo.isRequestFocus) KeyboardUtils.hideSoftInput(activity.getWindow());
        if (!popupInfo.isViewMode && dialog != null && dialog.isShowing())
            return BasePopupView.this;

        // 1. add PopupView to its host.
        View cv = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        cv.post(new Runnable() {
            @Override
            public void run() {
                attachToHost();
            }
        });
        return this;
    }

    public FullScreenDialog dialog;

    private void attachToHost() {
        Log.e("BasePopupView", "attachToHost");
        if (popupInfo == null) {
            throw new IllegalArgumentException("如果弹窗对象是复用的，则不要设置isDestroyOnDismiss(true)");
        }
        if (popupInfo.hostLifecycle != null) {
            popupInfo.hostLifecycle.addObserver(this);
        } else {
            if (getContext() instanceof FragmentActivity) {
                ((FragmentActivity) getContext()).getLifecycle().addObserver(this);
            }
        }
        Log.e("BasePopupView", "attachToHost doMeasure");
        doMeasure();

        if (popupInfo.isViewMode) {
            //view实现
            ViewGroup decorView = (ViewGroup) getActivity().getWindow().getDecorView();
            if (getParent() != null) ((ViewGroup) getParent()).removeView(this);
            decorView.addView(this, getLayoutParams());
        } else {
            Log.e("xpopu", "11");
            //dialog实现
            if (dialog == null) {
                Log.e("xpopu", "22");
                dialog = new FullScreenDialog(getContext()).setContent(this);
            }
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && !dialog.isShowing()) {
                Log.e("xpopu11", "show");
                dialog.show();
            }
        }

        //TODO:有毛病呀。第一次弹出软键盘时，也会回调height=0，后续每一次都不会回调
        //2. 注册对话框监听器
        KeyboardUtils.registerSoftInputChangedListener(getHostWindow(), BasePopupView.this, new KeyboardUtils.OnSoftInputChangedListener() {
            @Override
            public void onSoftInputChanged(int height) {
                Log.e("1me111an", "registerSoftInputChangedListener");
                onKeyboardHeightChange(height);
                if (popupInfo != null && popupInfo.xPopupCallback != null) {
                    popupInfo.xPopupCallback.onKeyBoardStateChanged(BasePopupView.this, height);
                }
                if (height == 0 && hasMoveUp) { // 说明输入法隐藏
//                    XPopupUtils.moveDown(BasePopupView.this);
//                    hasMoveUp = false;
                } else {
                    //when show keyboard, move up
                    boolean isInn = popupStatus == PopupStatus.Showing;
                    Log.e("1me111an", "show--isInn=" + isInn);
                    if (BasePopupView.this instanceof PartShadowPopupView && popupStatus == PopupStatus.Showing) {
                        return;
                    }
                    Log.e("1me111an", "show1");
                    XPopupUtils.moveUpToKeyboard(height, BasePopupView.this);
                    hasMoveUp = true;
                }
            }
        });
        // 2. do init，game start.
//        init();
    }

    protected Activity getActivity() {
        return XPopupUtils.context2Activity(getContext());
    }

    protected View getWindowDecorView() {
        if (getHostWindow() == null) return null;
        return (ViewGroup) getHostWindow().getDecorView();
    }

    /**
     * 注意此处的Activity content并不是android.R.id.content，而是decorView的第一个子View，
     * 是包含了ActionBar/ToolBar在内的
     *
     * @return
     */
    public View getActivityContentView() {
        ViewGroup decorView = (ViewGroup) getActivity().getWindow().getDecorView();
        return decorView.getChildAt(0);
    }

    protected int getActivityContentLeft() {
        return 0;
//        if(!XPopupUtils.isLandscape(getContext())) return 0;
//        //以Activity的content的left为准
//        View decorView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
//        int[] loc = new int[2];
//        decorView.getLocationInWindow(loc);
//        return loc[0];
    }

    protected void doMeasure() {
        Log.e("BasePopupView", "doMeasure");
        //设置自己的大小，和Activity的contentView保持一致
        Activity act = getActivity();
        if (act == null) return;
        WindowManager wm = (WindowManager) act.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        ViewGroup.MarginLayoutParams params = (MarginLayoutParams) getLayoutParams();
        View activityContent = getActivityContentView();
        if (params == null) {
            params = new MarginLayoutParams(activityContent.getWidth(), activityContent.getHeight());
        } else {
            params.width = activityContent.getWidth();
            params.height = activityContent.getHeight();
        }
        params.leftMargin = popupInfo != null && popupInfo.isViewMode ? activityContent.getLeft() : 0;
        params.topMargin = activityContent.getTop();
        Log.e("BasePopupView", "width=" + params.width + ", height=" + params.height + ", leftMargin=" + params.leftMargin + ", topMargin=" + params.topMargin);
        setLayoutParams(params);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        getActivityContentView().post(new Runnable() {
            @Override
            public void run() {
                Log.e("BasePopupView", "onApplyWindowInsets doMeasure");
                doMeasure();
            }
        });
        return super.onApplyWindowInsets(insets);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getActivityContentView().post(new Runnable() {
            @Override
            public void run() {
                Log.e("BasePopupView", "onConfigurationChanged doMeasure");
                doMeasure();
            }
        });
    }

    /**
     * 执行初始化
     */
    protected void init() {
        Log.e("BasePopupView", "init");
        if (shadowBgAnimator == null) {
            Log.e("xpopu", "33");
            shadowBgAnimator = new ShadowBgAnimator(this, getAnimationDuration(), getShadowBgColor());
        }
        if (popupInfo.hasBlurBg) {
            blurAnimator = new BlurAnimator(this, getShadowBgColor());
            blurAnimator.hasShadowBg = popupInfo.hasShadowBg;
            blurAnimator.decorBitmap = XPopupUtils.view2Bitmap((getActivity()).getWindow().getDecorView(),
                    getActivityContentView().getHeight(), 5);
        }

        //1. 初始化Popup
        if (this instanceof AttachPopupView || this instanceof BubbleAttachPopupView
                || this instanceof PartShadowPopupView || this instanceof PositionPopupView) {
            initPopupContent();
        } else if (!isCreated) {
            Log.e("xpopu", "44");
            initPopupContent();
        }
        if (!isCreated) {
            Log.e("xpopu", "55");
            isCreated = true;
            onCreate();
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            if (popupInfo.xPopupCallback != null) popupInfo.xPopupCallback.onCreated(this);
        }
        handler.post(initTask);
    }

    private final Runnable initTask = new Runnable() {
        @Override
        public void run() {
            Log.e("BasePopupView", "initTask");
            Log.e("xpopu", "66");
            if (getHostWindow() == null) return;
            if (popupInfo != null && popupInfo.xPopupCallback != null)
                popupInfo.xPopupCallback.beforeShow(BasePopupView.this);
            beforeShow();
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            Log.e("xpopu11", "1111111111");
            if (!(BasePopupView.this instanceof FullScreenPopupView)) focusAndProcessBackPress();

            //由于部分弹窗有个位置设置过程，需要在位置设置完毕自己开启动画
            if (!(BasePopupView.this instanceof AttachPopupView) && !(BasePopupView.this instanceof BubbleAttachPopupView)
                    && !(BasePopupView.this instanceof PositionPopupView)
                    && !(BasePopupView.this instanceof PartShadowPopupView)) {
                Log.e("xpopu", "77");
                initAnimator();

                doShowAnimation();

                doAfterShow();
            }
        }
    };

    protected void initAnimator() {
        Log.e("BasePopupView", "initAnimator");
        getPopupContentView().setAlpha(1f);
        // 优先使用自定义的动画器
        if (popupInfo != null && popupInfo.customAnimator != null) {
            Log.e("xpopu", "888");
            popupContentAnimator = popupInfo.customAnimator;
            if (popupContentAnimator.targetView == null)
                popupContentAnimator.targetView = getPopupContentView();
        } else {
            // 根据PopupInfo的popupAnimation字段来生成对应的动画执行器，如果popupAnimation字段为null，则返回null
            popupContentAnimator = genAnimatorByPopupType();
            if (popupContentAnimator == null) {
                popupContentAnimator = getPopupAnimator();
            }
        }

        //3. 初始化动画执行器
        if (popupInfo != null && popupInfo.hasShadowBg) {
            shadowBgAnimator.initAnimator();
        }
        if (popupInfo != null && popupInfo.hasBlurBg && blurAnimator != null) {
            blurAnimator.initAnimator();
        }
        if (popupContentAnimator != null) {
            popupContentAnimator.initAnimator();
        }
    }

    private void detachFromHost() {
        if (popupInfo != null && popupInfo.isViewMode) {
            ViewGroup decorView = (ViewGroup) getParent();
            if (decorView != null) decorView.removeView(this);
        } else {
            if (dialog != null) dialog.dismiss();
        }
    }

    public Window getHostWindow() {
        if (popupInfo != null && popupInfo.isViewMode) {
            Activity activity = getActivity();
            return activity == null ? null : activity.getWindow();
        }
        return dialog == null ? null : dialog.getWindow();
    }

    protected void doAfterShow() {
        Log.e("BasePopupView", "doAfterShow");
        handler.removeCallbacks(doAfterShowTask);
        int time = getAnimationDuration();
        Log.e("xpopu", "time: " + time);
        handler.postDelayed(doAfterShowTask, time);
    }

    protected Runnable doAfterShowTask = new Runnable() {
        @Override
        public void run() {
            Log.e("BasePopupView", "doAfterShowTask");
            popupStatus = PopupStatus.Show;
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            onShow();
            Log.e("xpopu11", "2222222");
            if (BasePopupView.this instanceof FullScreenPopupView) focusAndProcessBackPress();
            if (popupInfo != null && popupInfo.xPopupCallback != null)
                popupInfo.xPopupCallback.onShow(BasePopupView.this);
            //再次检测移动距离
            int heiht11 = XPopupUtils.getDecorViewInvisibleHeight(getHostWindow());
            Log.e("BasePopupView", "heiht11=" + heiht11 + ", hasMoveUp= " + hasMoveUp);
            //TODO:将 >0 改成 >= 0，第一次点击表情按钮时正常，但第二次就不正常了，不会显示dialog，不会触发registerSoftInputChangedListener，需要这里开发一个=0，让后续执行，执行dialog的位移显示
            if (getHostWindow() != null && XPopupUtils.getDecorViewInvisibleHeight(getHostWindow()) >= 0 && !hasMoveUp) {
                XPopupUtils.moveUpToKeyboard(XPopupUtils.getDecorViewInvisibleHeight(getHostWindow()), BasePopupView.this);
            }
        }
    };

    private ShowSoftInputTask showSoftInputTask;

    public void focusAndProcessBackPress() {
        Log.e("BasePopupView", "focusAndProcessBackPress");
        if (popupInfo != null && popupInfo.isRequestFocus) {
            setFocusableInTouchMode(true);
            setFocusable(true);
            // 此处焦点可能被内部的EditText抢走，也需要给EditText也设置返回按下监听
            if (Build.VERSION.SDK_INT >= 28) {
                addOnUnhandledKeyListener(this);
            } else {
                setOnKeyListener(new BackPressListener());
            }

            //let all EditText can process back pressed.
            ArrayList<EditText> list = new ArrayList<>();
            XPopupUtils.findAllEditText(list, (ViewGroup) getPopupContentView());
            if (list.size() > 0) {
                preSoftMode = getHostWindow().getAttributes().softInputMode;
                if (popupInfo.isViewMode) {
                    getHostWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                    hasModifySoftMode = true;
                }
                for (int i = 0; i < list.size(); i++) {
                    final EditText et = list.get(i);
//                    addOnUnhandledKeyListener(et);
                    if (Build.VERSION.SDK_INT >= 28) {
                        addOnUnhandledKeyListener(et);
                    } else {
                        boolean hasSetKeyListener = XPopupUtils.hasSetKeyListener(et);
                        if (!hasSetKeyListener) et.setOnKeyListener(new BackPressListener());
                    }
                    if (i == 0) {
                        if (popupInfo.autoFocusEditText) {
                            et.setFocusable(true);
                            et.setFocusableInTouchMode(true);
                            et.requestFocus();
                            Log.e("xpopu11", "showSoftInput1");
                            if (popupInfo.autoOpenSoftInput) showSoftInput(et);
                        } else {
                            Log.e("xpopu11", "showSoftInput2");
                            if (popupInfo.autoOpenSoftInput) showSoftInput(this);
                        }
                    }
                }
            } else {
                Log.e("xpopu11", "showSoftInput3");
                if (popupInfo.autoOpenSoftInput) showSoftInput(this);
            }
        }
    }

    @Override
    public boolean onUnhandledKeyEvent(View v, KeyEvent event) {
        return processKeyEvent(event.getKeyCode(), event);
    }

    protected void addOnUnhandledKeyListener(View view) {
        ViewCompat.removeOnUnhandledKeyEventListener(view, this);
        ViewCompat.addOnUnhandledKeyEventListener(view, this);
    }

    protected void showSoftInput(View focusView) {
        Log.e("BasePopupView", "showSoftInput");
        if (popupInfo != null) {
            if (showSoftInputTask == null) {
                showSoftInputTask = new ShowSoftInputTask(focusView);
            } else {
                handler.removeCallbacks(showSoftInputTask);
            }
            handler.postDelayed(showSoftInputTask, 10);
        }
    }

    public void dismissOrHideSoftInput() {
        Log.e("BasePopupView", "dismissOrHideSoftInput");
        if (XPopupUtils.getDecorViewInvisibleHeight(getHostWindow()) == 0) {
            dismiss();
        } else
            KeyboardUtils.hideSoftInput(BasePopupView.this);
    }

    static class ShowSoftInputTask implements Runnable {
        View focusView;

        public ShowSoftInputTask(View focusView) {
            this.focusView = focusView;
        }

        @Override
        public void run() {
            Log.e("BasePopupView", "ShowSoftInputTask focusView=" + focusView);
            if (focusView != null) {
                KeyboardUtils.showSoftInput(focusView);
            }
        }
    }

    protected boolean processKeyEvent(int keyCode, KeyEvent event) {
        Log.e("BasePopupView", "processKeyEvent");
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP && popupInfo != null) {
            if (onBackPressed()) return true;
            if (popupInfo.isDismissOnBackPressed &&
                    (popupInfo.xPopupCallback == null || !popupInfo.xPopupCallback.onBackPressed(BasePopupView.this))) {
                dismissOrHideSoftInput();
            }
            return true;
        }
        return false;
    }

    class BackPressListener implements OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            Log.e("BasePopupView", "BackPressListener");
            return processKeyEvent(keyCode, event);
        }
    }

    /**
     * 根据PopupInfo的popupAnimation字段来生成对应的内置的动画执行器
     */
    protected PopupAnimator genAnimatorByPopupType() {
        Log.e("BasePopupView", "genAnimatorByPopupType");
        if (popupInfo == null || popupInfo.popupAnimation == null) return null;
        switch (popupInfo.popupAnimation) {
            case ScaleAlphaFromCenter:
            case ScaleAlphaFromLeftTop:
            case ScaleAlphaFromRightTop:
            case ScaleAlphaFromLeftBottom:
            case ScaleAlphaFromRightBottom:
                return new ScaleAlphaAnimator(getPopupContentView(), getAnimationDuration(), popupInfo.popupAnimation);

            case TranslateAlphaFromLeft:
            case TranslateAlphaFromTop:
            case TranslateAlphaFromRight:
            case TranslateAlphaFromBottom:
                return new TranslateAlphaAnimator(getPopupContentView(), getAnimationDuration(), popupInfo.popupAnimation);

            case TranslateFromLeft:
            case TranslateFromTop:
            case TranslateFromRight:
            case TranslateFromBottom:
                return new TranslateAnimator(getPopupContentView(), getAnimationDuration(), popupInfo.popupAnimation);

            case ScrollAlphaFromLeft:
            case ScrollAlphaFromLeftTop:
            case ScrollAlphaFromTop:
            case ScrollAlphaFromRightTop:
            case ScrollAlphaFromRight:
            case ScrollAlphaFromRightBottom:
            case ScrollAlphaFromBottom:
            case ScrollAlphaFromLeftBottom:
                return new ScrollScaleAnimator(getPopupContentView(), getAnimationDuration(), popupInfo.popupAnimation);

            case NoAnimation:
                return new EmptyAnimator(getPopupContentView(), getAnimationDuration());
        }
        return null;
    }

    /**
     * 内部使用，自定义弹窗的时候不要重新这个方法
     *
     * @return
     */
    protected abstract int getInnerLayoutId();

    /**
     * 如果你自己继承BasePopupView来做，这个不用实现
     *
     * @return
     */
    protected int getImplLayoutId() {
        return -1;
    }

    /**
     * 获取PopupAnimator，用于每种类型的PopupView自定义自己的动画器
     *
     * @return
     */
    protected PopupAnimator getPopupAnimator() {
        return null;
    }

    /**
     * 请使用onCreate，主要给弹窗内部用，不要去重写。
     */
    protected void initPopupContent() {
    }

    /**
     * do init.
     */
    protected void onCreate() {
    }

    protected void applyDarkTheme() {
    }

    protected void applyLightTheme() {
    }

    /**
     * 执行显示动画：动画由2部分组成，一个是背景渐变动画，一个是Content的动画；
     * 背景动画由父类实现，Content由子类实现
     */
    protected void doShowAnimation() {
        Log.e("BasePopupView", "doShowAnimation");
        if (popupInfo == null) return;
        if (popupInfo.hasShadowBg && !popupInfo.hasBlurBg && shadowBgAnimator != null) {
            Log.e("xpopu", "9991");
            shadowBgAnimator.animateShow();
        } else if (popupInfo.hasBlurBg && blurAnimator != null) {
            blurAnimator.animateShow();
        }
        if (popupContentAnimator != null)
            popupContentAnimator.animateShow();
    }

    /**
     * 执行消失动画：动画由2部分组成，一个是背景渐变动画，一个是Content的动画；
     * 背景动画由父类实现，Content由子类实现
     */
    protected void doDismissAnimation() {
        Log.e("BasePopupView", "doDismissAnimation");
        if (popupInfo == null) return;
        if (popupInfo.hasShadowBg && !popupInfo.hasBlurBg && shadowBgAnimator != null) {
            shadowBgAnimator.animateDismiss();
        } else if (popupInfo.hasBlurBg && blurAnimator != null) {
            blurAnimator.animateDismiss();
        }

        if (popupContentAnimator != null)
            popupContentAnimator.animateDismiss();
    }

    /**
     * 获取内容View，本质上PopupView显示的内容都在这个View内部。
     * 而且我们对PopupView执行的动画，也是对它执行的动画
     *
     * @return
     */
    public View getPopupContentView() {
        return getChildAt(0);
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    public int getAnimationDuration() {
        if (popupInfo == null) return 0;
        if (popupInfo.popupAnimation == NoAnimation) return 1;
        return popupInfo.animationDuration >= 0 ? popupInfo.animationDuration : XPopup.getAnimationDuration() + 1;
    }

    public int getShadowBgColor() {
        return popupInfo != null && popupInfo.shadowBgColor != 0 ? popupInfo.shadowBgColor : XPopup.getShadowBgColor();
    }

    public int getStatusBarBgColor() {
        return popupInfo != null && popupInfo.statusBarBgColor != 0 ? popupInfo.statusBarBgColor : XPopup.getStatusBarBgColor();
    }

    /**
     * 弹窗的最大宽度，用来限制弹窗的最大宽度
     * 返回0表示不限制，默认为0
     *
     * @return
     */
    protected int getMaxWidth() {
        return popupInfo == null ? 0 : popupInfo.maxWidth;
    }

    /**
     * 弹窗的最大高度，用来限制弹窗的最大高度
     * 返回0表示不限制，默认为0
     *
     * @return
     */
    protected int getMaxHeight() {
        return popupInfo == null ? 0 : popupInfo.maxHeight;
    }

    /**
     * 弹窗的宽度，用来动态设定当前弹窗的宽度，受getMaxWidth()限制
     * 返回0表示不设置，默认为0
     *
     * @return
     */
    protected int getPopupWidth() {
        return popupInfo == null ? 0 : popupInfo.popupWidth;
    }

    /**
     * 弹窗的高度，用来动态设定当前弹窗的高度，受getMaxHeight()限制
     * 返回0表示不设置，默认为0
     *
     * @return
     */
    protected int getPopupHeight() {
        return popupInfo == null ? 0 : popupInfo.popupHeight;
    }

    /**
     * 消失
     */
    public void dismiss() {
        Log.e("BasePopupView", "dismiss");
        handler.removeCallbacks(initTask);
        if (popupStatus == PopupStatus.Dismissing || popupStatus == PopupStatus.Dismiss) return;
        popupStatus = PopupStatus.Dismissing;
        clearFocus();
        if (popupInfo != null && popupInfo.xPopupCallback != null)
            popupInfo.xPopupCallback.beforeDismiss(this);
        beforeDismiss();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        doDismissAnimation();
        doAfterDismiss();
    }

    /**
     * 会等待弹窗show动画执行完毕再消失
     */
    public void smartDismiss() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                delayDismiss(getAnimationDuration() + 50);
            }
        });
    }

    public void delayDismiss(long delay) {
        Log.e("BasePopupView", "delayDismiss");
        if (delay < 0) delay = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, delay);
    }

    public void delayDismissWith(long delay, Runnable runnable) {
        this.dismissWithRunnable = runnable;
        delayDismiss(delay);
    }

    protected void doAfterDismiss() {
        Log.e("BasePopupView", "doAfterDismiss");
        // PartShadowPopupView要等到完全关闭再关闭输入法，不然有问题
        Log.e("xpopu11", "showSoftInput4");
        if (popupInfo != null && popupInfo.autoOpenSoftInput && !(this instanceof PartShadowPopupView)){
            Log.e("BasePopupView", "doAfterDismiss hideSoftInput");
            KeyboardUtils.hideSoftInput(this);
        }
        handler.removeCallbacks(doAfterDismissTask);
        handler.postDelayed(doAfterDismissTask, getAnimationDuration());
    }

    protected Runnable doAfterDismissTask = new Runnable() {
        @Override
        public void run() {
            Log.e("BasePopupView", "doAfterDismissTask");
            popupStatus = PopupStatus.Dismiss;
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            if (popupInfo == null) return;
            Log.e("xpopu11", "showSoftInput5");
            if (popupInfo.autoOpenSoftInput && BasePopupView.this instanceof PartShadowPopupView){
                Log.e("BasePopupView", "doAfterDismissTask hideSoftInput");
                KeyboardUtils.hideSoftInput(BasePopupView.this);
            }
            onDismiss();
            XPopup.longClickPoint = null;
            if (popupInfo.xPopupCallback != null) {
                popupInfo.xPopupCallback.onDismiss(BasePopupView.this);
            }
            if (dismissWithRunnable != null) {
                dismissWithRunnable.run();
                dismissWithRunnable = null;//no cache, avoid some bad edge effect.
            }
            if (popupInfo.isRequestFocus && popupInfo.isViewMode) {
                // 让根布局拿焦点，避免布局内RecyclerView类似布局获取焦点导致布局滚动
                if (getWindowDecorView() != null) {
                    View needFocusView = getWindowDecorView().findViewById(android.R.id.content);
                    if (needFocusView != null) {
                        needFocusView.setFocusable(true);
                        needFocusView.setFocusableInTouchMode(true);
                    }
                }
            }
            // 移除弹窗，GameOver
            detachFromHost();
        }
    };

    Runnable dismissWithRunnable;

    public void dismissWith(Runnable runnable) {
        this.dismissWithRunnable = runnable;
        dismiss();
    }

    public boolean isShow() {
        return popupStatus != PopupStatus.Dismiss;
    }

    public boolean isDismiss() {
        return popupStatus == PopupStatus.Dismiss;
    }

    public void toggle() {
        if (isShow()) {
            dismiss();
        } else {
            show();
        }
    }

    /**
     * 尝试移除弹窗内的Fragment，如果提供了Fragment的名字
     */
    protected void tryRemoveFragments() {
        Log.e("BasePopupView", "tryRemoveFragments");
        if (getContext() instanceof FragmentActivity) {
            FragmentManager manager = ((FragmentActivity) getContext()).getSupportFragmentManager();
            List<Fragment> fragments = manager.getFragments();
            List<String> internalFragmentNames = getInternalFragmentNames();
            if (fragments != null && fragments.size() > 0 && internalFragmentNames != null) {
                for (int i = 0; i < fragments.size(); i++) {
                    String name = fragments.get(i).getClass().getSimpleName();
                    if (internalFragmentNames.contains(name)) {
                        manager.beginTransaction()
                                .remove(fragments.get(i))
                                .commitAllowingStateLoss();
                    }
                }
            }
        }
    }

    /**
     * 在弹窗内嵌入Fragment的场景中，当弹窗消失后，由于Fragment被Activity的FragmentManager缓存，
     * 会导致弹窗重新创建的时候，Fragment会命中缓存，生命周期不再执行。为了处理这种情况，只需重写：
     * getInternalFragmentNames() 方法，返回嵌入的Fragment名称，XPopup会自动移除Fragment缓存。
     * 名字是: Fragment.getClass().getSimpleName()
     *
     * @return
     */
    protected List<String> getInternalFragmentNames() {
        return null;
    }

    /**
     * 消失动画执行完毕后执行
     */
    protected void onDismiss() {
        Log.d("tag", "onDismiss");
    }

    /**
     * 执行返回监听
     */
    protected boolean onBackPressed() {
        return false;
    }

    /**
     * onDismiss之前执行一次
     */
    protected void beforeDismiss() {
        Log.d("tag", "beforeDismiss");
    }

    /**
     * onCreated之后，onShow之前执行
     */
    protected void beforeShow() {
        Log.d("tag", "beforeShow");
    }

    protected void onKeyboardHeightChange(int height) {
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.e("BasePopupView", "onDestroy");
        onDetachedFromWindow();
        detachFromHost();
        destroy();
    }

    /**
     * 显示动画执行完毕后执行
     */
    protected void onShow() {
        Log.d("tag", "onShow");
    }

    public void destroy() {
        Log.e("BasePopupView", "destroy");
        ViewCompat.removeOnUnhandledKeyEventListener(this, this);
        if (isCreated) {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        lifecycleRegistry.removeObserver(this);
        if (popupInfo != null) {
            popupInfo.atView = null;
            popupInfo.xPopupCallback = null;
            if (popupInfo.hostLifecycle != null) {
                popupInfo.hostLifecycle.removeObserver(this);
                popupInfo.hostLifecycle = null;
            }
            if (popupInfo.customAnimator != null) {
                if (popupInfo.customAnimator.targetView != null) {
                    popupInfo.customAnimator.targetView.animate().cancel();
                    popupInfo.customAnimator.targetView = null;
                }
                popupInfo.customAnimator = null;
            }
            if (popupInfo.isViewMode) tryRemoveFragments();
            popupInfo = null;
        }
        if (dialog != null) {
            if (dialog.isShowing()) dialog.dismiss();
            dialog.contentView = null;
            dialog = null;
        }
        if (shadowBgAnimator != null && shadowBgAnimator.targetView != null) {
            shadowBgAnimator.targetView.animate().cancel();
        }
        if (blurAnimator != null && blurAnimator.targetView != null) {
            blurAnimator.targetView.animate().cancel();
            if (blurAnimator.decorBitmap != null && !blurAnimator.decorBitmap.isRecycled()) {
                blurAnimator.decorBitmap.recycle();
                blurAnimator.decorBitmap = null;
            }
        }
    }

    protected int getStatusBarHeight() {
        return XPopupUtils.getStatusBarHeight(getHostWindow());
    }

    protected int getNavBarHeight() {
        return XPopupUtils.getNavBarHeight(getHostWindow());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("BasePopupView", "onDetachedFromWindow");
        if (getWindowDecorView() != null)
            KeyboardUtils.removeLayoutChangeListener(getHostWindow(), BasePopupView.this);
        handler.removeCallbacksAndMessages(null);
        if (popupInfo != null) {
            if (popupInfo.isViewMode && hasModifySoftMode) {
                //还原WindowSoftMode
                getHostWindow().setSoftInputMode(preSoftMode);
                hasModifySoftMode = false;
            }
            if (popupInfo.isDestroyOnDismiss) destroy();//如果开启isDestroyOnDismiss，强制释放资源
        }
        if (popupInfo != null && popupInfo.hostLifecycle != null) {
            popupInfo.hostLifecycle.removeObserver(this);
        } else {
            if (getContext() != null && getContext() instanceof FragmentActivity) {
                ((FragmentActivity) getContext()).getLifecycle().removeObserver(this);
            }
        }
        popupStatus = PopupStatus.Dismiss;
        showSoftInputTask = null;
        hasMoveUp = false;
    }

    public void passTouchThrough(MotionEvent event) {
        Log.e("BasePopupView", "passTouchThrough");
        if (popupInfo != null && (popupInfo.isClickThrough || popupInfo.isTouchThrough)) {
            if (popupInfo.isViewMode) {
                //需要从DecorView分发，并且要排除自己，否则死循环
                ViewGroup decorView = (ViewGroup) getActivity().getWindow().getDecorView();
                for (int i = 0; i < decorView.getChildCount(); i++) {
                    View view = decorView.getChildAt(i);
                    //自己和兄弟弹窗都不互相分发，否则死循环
                    if (!(view instanceof BasePopupView)) view.dispatchTouchEvent(event);
                }
            } else {
                getActivity().dispatchTouchEvent(event);
            }
        }
    }

    private float x, y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("BasePopupView", "onTouchEvent");
        // 如果自己接触到了点击，并且不在PopupContentView范围内点击，则进行判断是否是点击事件,如果是，则dismiss
        Rect rect = new Rect();
        getPopupImplView().getGlobalVisibleRect(rect);
        if (!XPopupUtils.isInRect(event.getX(), event.getY(), rect)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                    if (popupInfo != null && popupInfo.xPopupCallback != null) {
                        popupInfo.xPopupCallback.onClickOutside(this);
                    }
                    passTouchThrough(event);
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (popupInfo != null) {
                        if (popupInfo.isDismissOnTouchOutside) {
                            checkDismissArea(event);
                        }
                        if (popupInfo.isTouchThrough) passTouchThrough(event);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    float dx = event.getX() - x;
                    float dy = event.getY() - y;
                    float distance = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                    passTouchThrough(event);
                    if (distance < touchSlop && popupInfo != null && popupInfo.isDismissOnTouchOutside) {
                        checkDismissArea(event);
                    }
                    x = 0;
                    y = 0;
                    break;
            }
        }
        return true;
    }

    private void checkDismissArea(MotionEvent event) {
        Log.e("BasePopupView", "checkDismissArea");
        //查看是否在排除区域外
        ArrayList<Rect> rects = popupInfo.notDismissWhenTouchInArea;
        if (rects != null && rects.size() > 0) {
            boolean inRect = false;
            for (Rect r : rects) {
                if (XPopupUtils.isInRect(event.getX(), event.getY(), r)) {
                    inRect = true;
                    break;
                }
            }
            if (!inRect) {
                dismiss();
            }
        } else {
            dismiss();
        }
    }
}
