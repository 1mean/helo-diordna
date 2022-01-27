import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.FragmentRecommendBinding
import com.example.pandas.ui.ext.initReco

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 3:05 下午
 * @version: v1.0
 */
public class RecommendFragment : BaseFragment<HomePageViewModel, FragmentRecommendBinding>(),
    ILoadMoreListener {

    private val mAdapter: RecommendAdapter by lazy { RecommendAdapter(RecommendData<PetViewData>()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.rview.initReco(GridLayoutManager(activity, 2), mAdapter, this)
        binding.refreshReco.run {
            setColorSchemeResources(R.color.green)
            setOnRefreshListener {
                mViewModel.getRecommendData(true)
            }
        }
    }

    override fun onLoadMore() {
        mViewModel.getRecommendData(false)
    }

    override fun createObserver() {

        mViewModel.recommendDataWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {//成功
                when {
                    //没有数据
                    it.isFirstEmpty -> {
                        binding.refreshReco.isRefreshing = false
                        binding.rview.isFreshing(false)
                    }
                    //刷新的第一页
                    it.isRefresh -> {
                        binding.refreshReco.isRefreshing = false
                        binding.rview.isFreshing(false)
                        mAdapter.refreshData(it.recoData)
                    }
                    //加载更多
                    else -> {
                        binding.rview.loadMoreFinished()
                        mAdapter.addData(it.recoData)
                    }
                }
            } else {//失败
                binding.refreshReco.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.refreshReco.isRefreshing = true
        binding.rview.isFreshing(true)
        mViewModel.getRecommendData(true)
    }

    override fun againOnResume() {
    }

    //当banner可见时，滑动到左右两个item，还是在运行， 超过1个的会触发onDetachedFromWindow
    //当切换到homeFragment外也是触发超过1个的会触发onDetachedFromWindow
    override fun onPause() {
        super.onPause()

    }
}