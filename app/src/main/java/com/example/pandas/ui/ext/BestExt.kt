package com.example.pandas.ui.ext;

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pandas.sql.entity.User
import com.example.pandas.ui.activity.UserInfoActivity


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


//-------------------<Activity相关 结束>-------------------------------------------------------------