import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.FragmentRecommendBinding
import com.example.pandas.ui.ext.initReco
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView

/**
 * @description: 首页-推荐
 * 当预加载设置为1时
 * 当banner可见时，滑动到左右两个item，还是在运行， 滑动位置超过1个时才会触发onDetachedFromWindow
 * 当切换到homeFragment外也是触发超过1个的会触发onDetachedFromWindow
 * @author: dongyiming
 * @date: 1/4/22 3:05 下午
 * @version: v1.0
 */
public class RecommendFragment : BaseLazyFragment<HomePageViewModel, FragmentRecommendBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val mAdapter: RecommendAdapter by lazy { RecommendAdapter(RecommendData()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.layoutReco.visibility = View.GONE
        binding.rview.initReco(GridLayoutManager(activity, 2), mAdapter, this)
        binding.refreshReco.run {
            setColorSchemeResources(R.color.green)
            setOnRefreshListener {
                binding.rview.isFreshing(true)
                mViewModel.getRecommendData(true)
            }
        }
    }

    override fun onLoadMore() {
        mViewModel.getRecommendData(false)
    }

    override fun createObserver() {

        mViewModel.recommendDataWrapper.observe(viewLifecycleOwner) {

            binding.layoutReco.visibility = View.VISIBLE
            if (it.isSuccess) {//成功

                when {
                    //没有数据
                    it.isFirstEmpty -> {
                        binding.refreshReco.isRefreshing = false
                        binding.rview.noMoreData()
                    }
                    //刷新的第一页
                    it.isRefresh -> {
                        binding.rview.isFreshing(false)
                        mAdapter.refreshData(it.recoData)
                        binding.refreshReco.isRefreshing = false
                        if (!it.hasMore) {
                            binding.rview.noMoreData()
                        }
                    }
                    //加载更多
                    else -> {
                        if (it.hasMore) {//还有更多数据
                            binding.rview.loadMoreFinished()
                        } else {//已经是最后一页数据了
                            binding.rview.noMoreData()
                        }
                        mAdapter.addData(it.recoData)
                    }
                }
            } else {//失败
                binding.rview.noMoreData()
                binding.refreshReco.isRefreshing = false
            }
        }
    }

    override fun firstOnResume() {
        binding.refreshReco.isRefreshing = true
        binding.rview.isFreshing(true)
        mViewModel.getRecommendData(true)
    }


}