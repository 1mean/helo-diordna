import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.widget.ViewPager2
import com.example.pandas.R
import com.example.pandas.ui.view.MyViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/27 8:10 上午
 * @version: v1.0
 */
public class RoomFragment : Fragment(R.layout.fragment_room) {

    private var _tabNames: ArrayList<String>? = null
    private val tabNames get() = _tabNames!!


    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().lifecycle.addObserver(object : DefaultLifecycleObserver {

            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)

                _tabNames = arrayListOf<String>(
                    resources.getString(R.string.string_room_tab_item1),
                    resources.getString(R.string.string_room_tab_item2),
                    resources.getString(R.string.string_room_tab_item3),
                    resources.getString(R.string.string_room_tab_item4),
                    resources.getString(R.string.string_room_tab_item5)
                )
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val rvRoom = view.findViewById<RecyclerView>(R.id.rv_room)
        val vpRoom = view.findViewById<MyViewPager2>(R.id.vp_image)
        val tabLayout = view.findViewById<TabLayout>(R.id.tl_room)
        val vpContent = view.findViewById<ViewPager2>(R.id.vp_content)
        val tbRoom = view.findViewById<Toolbar>(R.id.tb_room)

        val mAdapter = RoomImageAdapter(requireContext())
        vpRoom.setAdapter(mAdapter)

        val contentAdapter = activity?.let { RoomContentAdapter(it) }
        vpContent.adapter = contentAdapter
        vpContent.offscreenPageLimit = 1


        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            tabLayout, vpContent, true
        ) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}