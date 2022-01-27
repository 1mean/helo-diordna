import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.databinding.FragmentPandaBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class PetChildFragment() :
    BaseFragment<CutePetViewModel,FragmentPandaBinding>(), ILoadMoreListener {

    private val mAdapter: PandasAdapter by lazy { PandasAdapter(mutableListOf()) }

    private var type = 0

    override fun initView(savedInstanceState: Bundle?) {
//        val gridManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        gridManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE;
//        binding.rv.layoutManager = gridManager
//        binding.rv.addItemDecoration(RoomItemDecoration(requireContext()))
//        binding.rv.adapter = activity?.let { PandaAdapter(it, initData()) }

        arguments?.let {
            type = it.getInt("type")
        }

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
                            binding.rv.noMoreData(true)
                        }
                    }
                }
            } else {

            }
        }

    }

    override fun firstOnResume() {
        mViewModel.getDataByPage(true, type)
    }

    override fun againOnResume() {
    }

    override fun onLoadMore() {
        mViewModel.getDataByPage(false, type)
    }

    companion object {
        fun newInstance(type: Int): PetChildFragment {
            val args = Bundle()
            args.putInt("type", type)
            val fragment = PetChildFragment()
            fragment.arguments = args
            return fragment
        }
    }
}