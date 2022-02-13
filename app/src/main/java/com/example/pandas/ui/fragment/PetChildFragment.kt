import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.databinding.FragmentPandaBinding
import com.example.pandas.ui.view.refresh.LoadMoreRecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class PetChildFragment(private var type: Int) :
    BaseLazyFragment<CutePetViewModel, FragmentPandaBinding>(),
    LoadMoreRecyclerView.ILoadMoreListener {

    private val mAdapter: PandasAdapter by lazy { PandasAdapter(mutableListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.rv.visibility = View.GONE
        binding.rv.run {
            layoutManager = GridLayoutManager(mActivity, 2)
            addItemDecoration(PandaDecoration(mActivity))
            setRefreshAdapter(mAdapter, this@PetChildFragment)
        }
    }

    override fun createObserver() {

        mViewModel.pageDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {

                when {
                    it.isRefresh -> {
                        mAdapter.refreshData(it.listData)
                    }
                    it.isFirstEmpty -> {

                    }
                    else -> {
                        mAdapter.addData(it.listData)
                        binding.rv.loadMoreFinished()
                        if (!it.hasMore) {//没有更多数据了
                            binding.rv.noMoreData()
                        }
                    }
                }
            } else {

            }

            binding.rv.visibility = View.VISIBLE
        }

    }

    override fun firstOnResume() {
        mViewModel.getDataByPage(true, type)
    }

    override fun onLoadMore() {
        mViewModel.getDataByPage(false, type)
    }
}