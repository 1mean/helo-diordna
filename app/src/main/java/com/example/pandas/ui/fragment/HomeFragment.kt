import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.biz.viewmodel.MainViewModel
import com.example.pandas.databinding.FragmentHomeBinding
import com.example.pandas.ui.activity.MessageActivity
import com.example.pandas.ui.activity.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: 首页
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>() {

    private val tabTitles = arrayListOf("大熊猫", "推荐", "最爱", "山水")

    override fun lazyLoadTime(): Long = 0
    override fun getCurrentLifeOwner(): ViewModelStoreOwner = mActivity
    override fun initView(savedInstanceState: Bundle?) {

        Glide.with(requireContext()).load(R.mipmap.jia).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgHead)

        binding.viewpager.run {
            adapter = HomePagerAdapter(tabTitles, requireActivity())
            offscreenPageLimit = OFFSCREEN_PAGE_LIMIT_DEFAULT //不设置预加载页面
            setCurrentItem(1, false)
        }

        TabLayoutMediator(
            binding.tab, binding.viewpager, true
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.edit.setOnClickListener {
            startActivity(Intent(mActivity, SearchActivity::class.java))
        }

        binding.imgHead.setOnClickListener {
            mViewModel.updateHeadState()
        }
        binding.ibMessage.setOnClickListener {
            mActivity.startActivity(Intent(mActivity, MessageActivity::class.java))
        }

        //binding.bar.setExpanded(true,true)
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }
}