import android.os.Bundle
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.databinding.FragmentRoomBinding
import com.google.android.material.tabs.TabLayoutMediator


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/27 8:10 上午
 * @version: v1.0
 */
public class CutePetFragment : BaseFragment<CutePetViewModel, FragmentRoomBinding>() {


    private val tabNames by lazy {
        arrayListOf(
            resources.getString(R.string.string_room_tab_item1),
            resources.getString(R.string.string_room_tab_item2),
            resources.getString(R.string.string_room_tab_item3),
            resources.getString(R.string.string_room_tab_item4),
            resources.getString(R.string.string_room_tab_item5)
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(requireActivity(), true, true, R.color.color_white_lucency)
        val mAdapter = RoomImageAdapter(requireContext())
        binding.vpImage.setAdapter(mAdapter)

        val contentAdapter = activity?.let { RoomContentAdapter(it) }
        binding.vpContent.adapter = contentAdapter
        binding.vpContent.offscreenPageLimit = 1


        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tlRoom, binding.vpContent, true
        ) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {

    }

    override fun againOnResume() {
        StatusBarUtils.updataStatus(requireActivity(), true, true, R.color.color_white_lucency)
    }

}