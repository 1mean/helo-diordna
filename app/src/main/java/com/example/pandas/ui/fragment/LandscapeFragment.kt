import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.LayoutRefreshBinding
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/4/22 4:44 下午
 * @version: v1.0
 */
public class LandscapeFragment : BaseLazyFragment<HomePageViewModel, LayoutRefreshBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val mAdapter: LandscapeAdapter by lazy { LandscapeAdapter(LandscapeData()) }

    override fun initView(savedInstanceState: Bundle?) {

        val padding = mActivity.resources.getDimension(R.dimen.item_home_padding).toInt()

        binding.recyclerLayout.run {

            layoutManager = LinearLayoutManager(mActivity)
            addItemDecoration(LandScapeItemDecoration(padding))
            setRefreshAdapter(mAdapter, this@LandscapeFragment)
        }

        binding.swipLayout.setOnRefreshListener {
            mViewModel.getLandScapeData(true)
        }
    }

    override fun createObserver() {

        mViewModel.landScapeDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {
                when {
                    it.isFirstEmpty -> {
                        binding.recyclerLayout.isFreshing(false)
                    }
                    it.isRefresh -> {
                        mAdapter.updata(true, it.landscapeData)
                        binding.recyclerLayout.isFreshing(false)
                    }
                    else -> {
                        mAdapter.updata(false, it.landscapeData)
                        binding.recyclerLayout.loadMoreFinished()
                    }
                }
            } else {

            }
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {

        mViewModel.getLandScapeData(true)
    }

    override fun onLoadMore() {
        mViewModel.getLandScapeData(false)
    }

}