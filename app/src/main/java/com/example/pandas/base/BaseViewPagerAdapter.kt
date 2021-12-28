import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/18 11:35 下午
 * @version: v1.0
 */
public class BaseViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

}