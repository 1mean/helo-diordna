import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.R
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.databinding.FragmentRecommendBinding
import com.example.pandas.ui.ext.initReco

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 3:05 下午
 * @version: v1.0
 */
public class RecommendFragment : BaseFragment<PetViewModel, FragmentRecommendBinding>(),
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
                        Log.e("1mean","adapter addData")
                        binding.rview.loadMoreFinished()
                        mAdapter.addData(it.recoData)
                    }
                }
            } else {//失败
                binding.refreshReco.isRefreshing = false
            }
        }
    }

    override fun lazyLoadData() {
        binding.refreshReco.isRefreshing = true
        binding.rview.isFreshing(true)
        mViewModel.getRecommendData(true)
    }
}