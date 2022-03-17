import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.base.BaseViewModel
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseLazyFragment<BaseViewModel, FragmentHomeBinding>() {

    //    private val tabTitles by lazy { arrayListOf("大熊猫", "推荐", "最爱", "山水", "小熊猫", "音乐", "动漫") }
    private val tabTitles by lazy { arrayListOf("大熊猫", "推荐", "最爱", "山水") }

    override fun lazyLoadTime(): Long = 0

    override fun initView(savedInstanceState: Bundle?) {

        Glide.with(requireContext()).load(R.mipmap.jia).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgHead)

        val viewpager = binding.viewpager
        viewpager.adapter = HomePagerAdapter(tabTitles, requireActivity())
        //不设置预加载页面
        viewpager.offscreenPageLimit = OFFSCREEN_PAGE_LIMIT_DEFAULT
        viewpager.setCurrentItem(1, false)
        TabLayoutMediator(
            binding.tab, viewpager, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.edit.setOnClickListener {
            startActivity(Intent(mActivity, SearchActivity::class.java))
        }

        binding.imgHead.setOnClickListener {

        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}