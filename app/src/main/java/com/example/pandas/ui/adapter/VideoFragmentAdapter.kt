import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/29/21 11:18 下午
 * @version: v1.0
 */
public class VideoFragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return if (position == 0) {
            VideoInfosFragment()
        } else {
            VideoCommentFragment()
        }
    }
}