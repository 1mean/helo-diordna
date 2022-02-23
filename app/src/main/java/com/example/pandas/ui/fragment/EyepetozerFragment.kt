import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.FragmentEyesBinding
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView

/**
 * @description: 开眼
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment : BaseLazyFragment<EyepetozerViewModel, FragmentEyesBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val mAdapter: EyepetozerAdapter by lazy { EyepetozerAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.rvEye.apply {
            layoutManager = LinearLayoutManager(mActivity)
            setRefreshAdapter(mAdapter, this@EyepetozerFragment)
        }

        binding.refreshLayout.run {
            setRefreshColor()
            setOnRefreshListener {
                binding.rvEye.isFreshing(true)
                mViewModel.initData(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.eyepetozerWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                if (it.isRefresh) {
                    mAdapter.refresh(it.listData)
                    binding.rvEye.isFreshing(false)
                    binding.refreshLayout.isRefreshing = false
                } else if (it.hasMore) {
                    mAdapter.loadMore(it.listData)
                    binding.rvEye.loadMoreFinished()
                } else {
                    mAdapter.loadMore(it.listData)
                    binding.rvEye.noMoreData()
                }
            } else {
                if (it.isRefresh) {
                    binding.refreshLayout.isRefreshing = false
                }
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.initData(true)
    }

    override fun onLoadMore() {
        mViewModel.initData(false)
    }
}