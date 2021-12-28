import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class RoomContentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {

        if (position == 0) {
            return RoomPandaFragment()
        } else
            return Fragment()
    }

}