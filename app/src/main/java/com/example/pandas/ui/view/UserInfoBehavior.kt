import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * @description: UserInfoBehavior
 * @author: dongyiming
 * @date: 4/22/22 5:48 下午
 * @version: v1.0
 */
public class UserInfoBehavior:CoordinatorLayout.Behavior<View>() {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return super.onDependentViewChanged(parent, child, dependency)
    }
}