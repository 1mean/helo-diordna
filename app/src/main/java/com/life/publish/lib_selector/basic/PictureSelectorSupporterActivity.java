package com.life.publish.lib_selector.basic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.life.publish.lib_selector.PictureSelectorFragment;
import com.example.pandas.R;
import com.life.publish.lib_selector.config.SelectorConfig;
import com.life.publish.lib_selector.config.SelectorProviders;
import com.life.publish.lib_selector.entity.LocalMedia;
import com.life.publish.lib_selector.immersive.ImmersiveManager;
import com.life.publish.lib_selector.interfaces.CloseListener;
import com.life.publish.lib_selector.language.LanguageConfig;
import com.life.publish.lib_selector.language.PictureLanguageUtils;
import com.life.publish.lib_selector.style.PictureWindowAnimationStyle;
import com.life.publish.lib_selector.style.SelectMainStyle;
import com.life.publish.lib_selector.utils.StyleUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author：luck
 * @date：2021/11/17 9:59 上午
 * @describe：PictureSelectorSupporterActivity
 */
public class PictureSelectorSupporterActivity extends AppCompatActivity implements CloseListener {
    private SelectorConfig selectorConfig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSelectorConfig();
        immersive();
        setContentView(R.layout.ps_activity_container);
        setupFragment();
    }

    private void initSelectorConfig() {
        selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
    }

    private void immersive() {
        SelectMainStyle mainStyle = selectorConfig.selectorStyle.getSelectMainStyle();
        int statusBarColor = mainStyle.getStatusBarColor();
        int navigationBarColor = mainStyle.getNavigationBarColor();
        boolean isDarkStatusBarBlack = mainStyle.isDarkStatusBarBlack();
        if (!StyleUtils.checkStyleValidity(statusBarColor)) {
            statusBarColor = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        if (!StyleUtils.checkStyleValidity(navigationBarColor)) {
            navigationBarColor = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        ImmersiveManager.immersiveAboveAPI23(this, statusBarColor, navigationBarColor, isDarkStatusBarBlack);
    }

    private void setupFragment() {
        PictureSelectorFragment fragment = PictureSelectorFragment.newInstance();
        fragment.addCloseListener(this);
        FragmentInjectManager.injectFragment(this, PictureSelectorFragment.TAG, fragment);
    }

    /**
     * set app language
     */
    public void initAppLanguage() {
        if (selectorConfig != null && selectorConfig.language != LanguageConfig.UNKNOWN_LANGUAGE && !selectorConfig.isOnlyCamera) {
            PictureLanguageUtils.setAppLanguage(this, selectorConfig.language, selectorConfig.defaultLanguage);
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        initAppLanguage();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        SelectorConfig selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        if (selectorConfig != null) {
            super.attachBaseContext(PictureContextWrapper.wrap(newBase, selectorConfig.language, selectorConfig.defaultLanguage));
        } else {
            super.attachBaseContext(newBase);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (selectorConfig != null) {
            PictureWindowAnimationStyle windowAnimationStyle = selectorConfig.selectorStyle.getWindowAnimationStyle();
            overridePendingTransition(0, windowAnimationStyle.activityExitAnimation);
        }
    }

    @Override
    public void closeActivity() {
        ArrayList<LocalMedia> medias = selectorConfig.selectedResult;
        Log.e("1mean", "medias size = " + medias.size());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        //bundle.putParcelableArrayList("data", medias);
        //intent.putExtras(bundle);
        intent.putParcelableArrayListExtra("data", medias);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.e("1mean", "PictureSelectorSupporterActivity onKeyDown");
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                fragments.forEach(new Consumer<Fragment>() {
                    @Override
                    public void accept(Fragment fragment) {
                        Log.e("1mean", "11111");
                    }
                });
            }
            //可能 PictureSelectorFragment、SupportRequestManagerFragment、PictureSelectorPreviewFragment、PicturePublishFragment
            if (fragments.size() == 2) {//只有PictureSelectorFragment+SupportRequestManagerFragment
                setResult(5);
                Log.e("1mean", "22222");
                finish();
            } else if (fragments.size() == 4) {
                Log.e("1mean", "33333");
                getSupportFragmentManager().popBackStack();
            }
            Log.e("1mean", "44444");
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
