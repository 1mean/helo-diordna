import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.databinding.FragmentRoomBinding
import com.example.pandas.ui.view.viewpager.Indicator
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/27 8:10 上午
 * @version: v1.0
 */
public class CutePetFragment : BaseFragment<CutePetViewModel, FragmentRoomBinding>() {

    private var fragments: MutableList<Fragment> = mutableListOf()
    //private val bannerAdapter by lazy { PetBannerAdapter(mutableListOf<PetViewData>()) }

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

        binding.refreshPet.run {
            setProgressViewEndTarget(true, 300)
            setColorSchemeResources(R.color.green)
            setOnRefreshListener {
                isRefreshing = true
                mViewModel.getBannerData()
            }
        }

        //初始化ViewPager相关
        binding.vpPet.adapter = RoomContentAdapter(mActivity, fragments)

        //解决AppBarLayout和SwipeRefreshLayout的滑动冲突问题,同时也解决了SwipeRefreshLayout和Recyclerview的滑动冲突问题
        binding.abl.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            //像上滑动时，verticalOffset为负值，完全展示时为0
            binding.refreshPet.isEnabled = verticalOffset >= 0
        })

        //tabLayout和androidx的联动工具类,绑定前viewpager2必须先设定adapter
        TabLayoutMediator(
            binding.tlayoutPet, binding.vpPet, true
        ) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun createObserver() {

        mViewModel.bannerWrapper.observe(viewLifecycleOwner) {

            Log.e("1mean","bannerWrapper observe")
            if (it.isSuccess) {
                val data = it.listData
                val indicator = Indicator(mActivity)
                indicator.initIndicator(
                    data.size,
                    ContextCompat.getColor(mActivity, R.color.white)
                )
                //初始化轮播图
                val bannerAdapter = PetBannerAdapter(data)
                binding.bannerPet.setAdapter(bannerAdapter).setIndicator(indicator, true)
                    .setAutoPlayed(true)

                fragments.clear()
                //如果共享viewmodel，注意在page页面未显示前，observer会接收到model里数据刷新了的通知，
                // 会在onResume时先显示前一个页面的相同的view，然后才获取数据显示自己的真实view
                tabNames.forEach {
                    fragments.add(PetChildFragment.newInstance(mViewModel.getType(it)))
                }
                binding.vpPet.adapter?.notifyDataSetChanged()
                binding.vpPet.offscreenPageLimit = fragments.size
                binding.vpPet.currentItem = 0
            } else {

            }
            binding.refreshPet.isRefreshing = false
        }
    }

    override fun firstOnResume() {

        binding.refreshPet.isRefreshing = true
        mViewModel.getBannerData()
    }

    override fun againOnResume() {
        StatusBarUtils.updataStatus(requireActivity(), true, true, R.color.color_white_lucency)
    }
}