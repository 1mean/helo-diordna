import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.app.appViewModel
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.biz.viewmodel.BannerViewModel
import com.example.pandas.databinding.LayoutSwipRefreshBinding
import com.example.pandas.ui.adapter.BannerChildAdapter
import com.example.pandas.ui.adapter.decoration.RecommendDecoration2
import com.example.pandas.ui.ext.init
import com.example.pandas.ui.ext.setRefreshColor
import com.example.pandas.ui.ext.viewColors
import com.example.pandas.ui.view.recyclerview.SwipRecyclerView

/**
 * @description: BestFragment
 * @author: dongyiming
 * @date: 7/8/23 4:34 PM
 * @version: v1.0
 */
public class BestFragment : BaseFragment<BannerViewModel, LayoutSwipRefreshBinding>() {

    private var mPosition = 0
    private val mAdapter: BannerChildAdapter by lazy { BannerChildAdapter(lifecycle) }

    companion object {
        fun newInstance(id: Int): BestFragment {
            val args = Bundle().apply { putInt("position", id) }
            val fragment = BestFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

        arguments?.let {
            mPosition = it.getInt("position")
        }
        val padding: Int = resources.getDimension(R.dimen.common_lh_5_dimens).toInt()
        binding.recyclerLayout.init(
            RecommendDecoration2(padding, padding, padding, padding, padding),
            mAdapter,
            GridLayoutManager(mActivity, 2),
            listener = object : SwipRecyclerView.ILoadMoreListener {
                override fun onLoadMore() {
                    mViewModel.getBest(false,mPosition)
                }
            })

        binding.swipLayout.run {
            setRefreshColor()
            setBackgroundColor(ContextCompat.getColor(context, R.color.color_bg_recommend))
            setOnRefreshListener {
                binding.recyclerLayout.isRefreshing(true)
                mViewModel.getBest(true, mPosition)
            }
        }

        appViewModel.appColorType.value?.let {
            binding.swipLayout.setColorSchemeResources(viewColors[it])
        }
    }

    override fun createObserver() {
        mViewModel.bestList.observe(this) {

            if (it.isSuccess) {
                binding.recyclerLayout.visibility = View.VISIBLE
                when {
                    it.isRefresh -> {
                        mAdapter.refreshData(it.listData)
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
        mViewModel.getBest(true, mPosition)
    }
}