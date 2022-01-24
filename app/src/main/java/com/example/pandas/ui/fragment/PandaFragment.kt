import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.databinding.FragmentPandasBinding
import com.example.pandas.ui.ext.initPanda

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/12/22 7:35 下午
 * @version: v1.0
 */
public class PandaFragment : BaseFragment<PetViewModel, FragmentPandasBinding>(),
    ILoadMoreListener {

    private val pandasAdapter: PandasAdapter by lazy { PandasAdapter(arrayListOf()) }

    override fun initView(savedInstanceState: Bundle?) {

        binding.refreshLayoutPanda.setOnRefreshListener {
            binding.refreshLayoutPanda.isRefreshing = true
            binding.recyclerViewPanda.isFreshing(true)
            mViewModel.getPagePet(true)
        }

        binding.recyclerViewPanda.initPanda(GridLayoutManager(activity, 2), pandasAdapter, this)

    }

    override fun createObserver() {

        mViewModel.petDataWrapper.observe(viewLifecycleOwner) {

            if (it.isSuccess) {//成功
                when {
                    //没有数据
                    it.isFirstEmpty -> {
                        binding.refreshLayoutPanda.isRefreshing = false
                        binding.recyclerViewPanda.isFreshing(false)
                    }
                    //刷新的第一页
                    it.isRefresh -> {
                        binding.refreshLayoutPanda.isRefreshing = false
                        binding.recyclerViewPanda.isFreshing(false)
                        pandasAdapter.refreshData(it.listData)
                    }
                    //加载更多
                    else -> {
                        binding.recyclerViewPanda.loadMoreFinished()
                        pandasAdapter.addData(it.listData)
                    }
                }
            } else {//失败

            }
        }

    }

    override fun lazyLoadData() {
        binding.refreshLayoutPanda.isRefreshing = true
        mViewModel.getPagePet(true)
    }

    override fun onLoadMore() {
        mViewModel.getPagePet(false)
    }
}