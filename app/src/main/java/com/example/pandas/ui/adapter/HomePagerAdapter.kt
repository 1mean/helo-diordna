import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 12:48 下午
 * @version: v1.0
 */
public class HomePagerAdapter(private val tabList: List<String>, fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {

    private var fragments: HashMap<Int, Fragment> = HashMap<Int, Fragment>()

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment {

        var mFragment = fragments.get(position)
        if (mFragment == null) {
            mFragment = when (tabList[position]) {
                "推荐" -> {
                    RecommendFragment()
                }
                "大熊猫" -> {
                    PandaFragment()
                }
                "最爱" -> {
                    MyLoveFragment()
                }
                else -> {
                    Fragment()
                }
            }
            fragments[position] = mFragment
        }
        return mFragment
    }

}