import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.databinding.LayoutRefreshBinding

/**
 * @description: 我爱看的
 * @author: dongyiming
 * @date: 1/28/22 8:51 下午
 * @version: v1.0
 */
public class MyLoveFragment : BaseFragment<HomePageViewModel, LayoutRefreshBinding>() {

    private val mAdapter: MyLoveFragmentAdapter by lazy { MyLoveFragmentAdapter(viewLifecycleOwner,PageCommonData()) }
    override fun initView(savedInstanceState: Bundle?) {

        binding.swipLayout.setOnRefreshListener {

        }

        binding.recyclerLayout.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(mActivity)
            addItemDecoration(MyLoveItemDecoration(mActivity))

        }
    }

    override fun createObserver() {

        mViewModel.loveDataWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                mAdapter.refresh(it.loveData)
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getLoveData(true)
    }

    override fun againOnResume() {
    }

}