import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pandas.bean.pet.PetType

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 2:47 下午
 * @version: v1.0
 */
public class RoomContentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: MutableList<String>,
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment = PetChildFragment(getType(position))

    override fun getItemId(position: Int): Long {

        if (tabs.isNotEmpty()) {
            return tabs[position].hashCode().toLong()
        }
        return super.getItemId(position)
    }

    private fun getType(position: Int): Int {

        var type = 0
        when (position) {
            0 -> type = PetType.BIRD.ordinal
            1 -> type = PetType.FOX.ordinal
            2 -> type = PetType.RED_PANDA.ordinal
            3 -> type = PetType.PENGUIN.ordinal
            4 -> type = PetType.GOLDEN_MONKEY.ordinal
            5 -> type = PetType.BEAR.ordinal
        }
        return type
    }
}