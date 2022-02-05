import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {

    private val tabTitles by lazy { arrayListOf("大熊猫", "推荐", "最爱", "热门", "小熊猫", "音乐", "动漫") }

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        StatusBarUtils.updataStatus(requireActivity(), true, false, R.color.color_white_lucency)

        Glide.with(requireContext()).load(R.mipmap.jia).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgHead)

        val viewpager = binding.viewpager
        viewpager.adapter = HomePagerAdapter(tabTitles, requireActivity())
        viewpager.offscreenPageLimit = tabTitles.size
        viewpager.setCurrentItem(1, false)
        TabLayoutMediator(
            binding.tab, viewpager, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun againOnResume() {
        Log.e("1mean", "againOnResume")
        StatusBarUtils.updataStatus(requireActivity(), true, false, R.color.color_white_lucency)
    }

}