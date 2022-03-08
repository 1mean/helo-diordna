import android.os.Bundle
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.biz.interaction.OnItemClickListener
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.FragmentCacheListBinding

/**
 * @description: CacheListFragment
 * @author: dongyiming
 * @date: 3/8/22 4:47 下午
 * @version: v1.0
 */
public class CacheListFragment : BaseFragment<LocalCacheViewModel, FragmentCacheListBinding>(),
    OnItemClickListener<String> {

    private val mFragment by lazy { CacheItemFragment() }

    private val mAdapter: CacheListAdapter by lazy { CacheListAdapter(mutableListOf(), this) }

    override fun initView(savedInstanceState: Bundle?) {

        mViewModel.getCacheList(mActivity)
        binding.rvCacheList.apply {
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mAdapter
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
        val list = mViewModel.getCacheList(mActivity)
        mAdapter.refreshAdapter(list)
    }

    override fun lazyLoadTime(): Long = 0

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun onClick(position: Int, t: String) {
        mViewModel.setSelectFileName(t)
    }

}