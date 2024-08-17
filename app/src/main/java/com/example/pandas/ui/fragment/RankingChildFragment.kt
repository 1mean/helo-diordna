import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.base.ui.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.RankViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.RankingListAdapter
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: RankingChildFragment
 * @author: dongyiming
 * @date: 7/17/23 2:01 PM
 * @version: v1.0
 */
public class RankingChildFragment : BaseFragment<RankViewModel, LayoutSwipRefreshBinding>() {

    private val mAdapter: RankingListAdapter by lazy { RankingListAdapter(mutableListOf()) }

    companion object {
        fun newInstance(id: Int): RankingChildFragment {
            val args = Bundle().apply { putInt("position", id) }
            val fragment = RankingChildFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.recyclerLayout.init(
            null, mAdapter, LinearLayoutManager(mActivity),
            object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getRanks(false)
                }
            })

        binding.swipLayout.run {
            isRefreshing = true
            setRefreshColor()
            setOnRefreshListener {
                binding.swipLayout.isRefreshing = true
                mViewModel.getRanks(true)
            }
        }
    }

    override fun createObserver() {

        mViewModel.ranks.observe(this) {

            if (it.isSuccess) {

                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshAdapter(it.listData)
                        binding.recyclerLayout.isRefreshing(false)
                    }
                    else -> {
                        mAdapter.loadMore(it.listData)
                    }
                }
                binding.recyclerLayout.loadMoreFinished(it.isEmpty, it.hasMore)
            }
            binding.swipLayout.visibility = View.VISIBLE
            binding.swipLayout.isRefreshing = false
        }
    }

    override fun firstOnResume() {
        mViewModel.getRanks(true)
    }
}