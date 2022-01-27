import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class RoomContentAdapter(fragmentActivity: FragmentActivity,val fragments:MutableList<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemId(position: Int): Long {

        if (fragments.isNotEmpty()) {
            return fragments[position].hashCode().toLong()
        }
        return super.getItemId(position)
    }

}