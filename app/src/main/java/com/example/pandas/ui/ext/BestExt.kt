package com.example.pandas.ui.ext;

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pandas.biz.interaction.AnimationListener
import com.example.pandas.sql.entity.PetVideo
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.activity.UserInfoActivity
import com.example.pandas.ui.activity.VideoPlayingActivity
import kotlin.math.abs


/**************************************************************************************************
 * 最终解决方案( 待确定的方案，先存放在各自相关的逻辑页面里 )                                               *
 *  - 1.界面相关，最优处理结果，
 *
 *
 *
 *
 *
 *
 *
 *
 * ***********************************************************************************************/


//-------------------<Fragment相关 开始>-------------------------------------------------------------
/**
 * Fragment返回栈
 *  - FragmentManager返回栈包含的不是Fragment，而是调用了addToBackStack(name)的事务来组成的
 *      - 同一个FragmentManager绝对不允许，含有popBackStack()的事务和不含的事务混在一起
 *  - 直接或间接调用(系统返回键)popBackStack()，Fragment返回栈中最上层事务会从栈中弹出
 *      - 异步操作
 *      - 相当于撤销操作。失去视图状态、保存的实例状态(Saved Instance State)、ViewModel实例
 *      - 新出的saveBackStack()可实现弹出返回效果，同时保存视图状态，以及ViewModel实例
 *      - 返回后不会触发Activity的生命周期方法
 *  - 后续关注下OnBackPressedDispatcher，官方推荐的回退管理，对当前方法的补充，而不是替换
 */

/**
 * 添加Fragment到回退栈中，同时添加Fragment动画<进入动画和退出动画>
 */
fun AppCompatActivity.addFragment(
    tag: String,
    containerViewId: Int,
    fragment: Fragment,
    animators: IntArray
) {
    val transaction = supportFragmentManager.beginTransaction()
    val tagFragment = supportFragmentManager.findFragmentByTag(tag)
    if (tagFragment == null) {
        transaction.run {
            setReorderingAllowed(true)
            setCustomAnimations(animators[0], animators[1], animators[2], animators[3])
            add(containerViewId, fragment, tag)
            addToBackStack(null)
            commit()
        }
    }
}

/**
 * 注意：
 *  - popBackStack()为异步，会将Fragment从回退栈里移除，数据和视图也会被清除
 *      - 想要立马查看效果的，可以调用同步方法 popBackStackImmediate()
 *  - 切记ViewModel要使用Fragment独立的，如果是使用的Activity的ViewModel数据，则Fragment清理了，但是数据仍然存在
 *      - 在重新进入界面时，会先显示以往界面数据
 */
fun AppCompatActivity.popBack(tag: String) {
    val fragment = supportFragmentManager.findFragmentByTag(tag)
    if (fragment != null) {
        supportFragmentManager.popBackStack()
    }
}
//-------------------<Fragment相关 结束>-------------------------------------------------------------

//-------------------<Activity相关 开始>-------------------------------------------------------------
fun startUserInfoActivity(context: Context, user: User) {
    val intent = Intent(context, UserInfoActivity::class.java).apply {
        putExtra("user", user)
    }
    context.startActivity(intent)
}

fun startVideoPlayingActivity(context: Context, video: PetVideo) {
    val intent = Intent(context, VideoPlayingActivity::class.java).apply {
        putExtra("petVideo", video)
    }
    context.startActivity(intent)
}

fun launcherActivity(
    launcher: ActivityResultLauncher<Intent>,
    context: Context,
    cls: Class<*>
) {
    val intent = Intent(context, cls)
    launcher.launch(intent)
}


//-------------------<Activity相关 结束>-------------------------------------------------------------

//-------------------<动画相关 开始>-----------------------------------------------------------------
fun addItemAnimation(view: View) {
    val translationX =
        ObjectAnimator.ofFloat(
            view,
            "translationX",
            0f,
            view.width * 0.1f,
            0f
        )
    val translationY =
        ObjectAnimator.ofFloat(
            view,
            "translationY",
            0f,
            -view.height * 0.3f,
            0f,
            -view.height * 0.2f,
            0f
        )
    //旋转
    val transRotation = ObjectAnimator.ofFloat(view, "rotation", 0f, -5f, 0f)
    val animationSet = AnimatorSet()
    animationSet.duration = 600
    animationSet.interpolator = DecelerateInterpolator()
    animationSet.play(translationX).with(translationY).with(transRotation)
    animationSet.start()
}

fun addItemAnimation2(view: View) {
    val transScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.3f, 1f)
    val transScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.3f, 1f)
    val animationSet = AnimatorSet()
    animationSet.duration = 600
    animationSet.interpolator = DecelerateInterpolator()
    animationSet.play(transScaleX).with(transScaleY)
    animationSet.start()
}

fun addRefreshAnimation(view: View, offSet: Float, listener: Animator.AnimatorListener) {

    val y_trans = view.translationY
    val translationY = if (y_trans == 0f) {//translationY每次滑动后会累加
        ObjectAnimator.ofFloat(view, "translationY", y_trans, -offSet)
    } else {
        ObjectAnimator.ofFloat(view, "translationY", y_trans, -offSet - abs(y_trans))
    }
    Log.e("dispatchTouchEvent", "totalOffset: $offSet, y_trans: $y_trans")
    val transAlpha = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
    val animationSet = AnimatorSet()
    animationSet.duration = 400
    animationSet.play(translationY).with(transAlpha)
    animationSet.start()
    animationSet.addListener(listener)
}

fun setLikeAnimation(view: View, listener: AnimationListener) {

    val starScaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", 0.2f, 1f)
    starScaleYAnimator.interpolator = OvershootInterpolator(4f)

    val starScaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", 0.2f, 1f)
    starScaleXAnimator.interpolator = OvershootInterpolator(4f)
    val set = AnimatorSet()
    set.play(starScaleXAnimator).with(starScaleYAnimator)
    set.duration = 400
    set.addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            listener.onAnimationEnd(animation)
        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationRepeat(animation: Animator?) {
        }
    })
    set.start()
}

//-------------------<动画相关 结束>-----------------------------------------------------------------