import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.databinding.LayoutRefreshBinding

/**
 * @description: 我爱看的
 * @author: dongyiming
 * @date: 1/28/22 8:51 下午
 * @version: v1.0
 */
public class MyLoveFragment : BaseLazyFragment<HomePageViewModel, LayoutRefreshBinding>() {

    private val mAdapter: MyLoveFragmentAdapter by lazy {
        MyLoveFragmentAdapter(
            viewLifecycleOwner,
            PageCommonData()
        )
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.freshLayout.setOnRefreshListener {
            mViewModel.getLoveData(true)
        }

        binding.recyclerView.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(mActivity)
            addItemDecoration(MyLoveItemDecoration(mActivity))

        }
    }

    override fun createObserver() {

        mViewModel.loveDataWrapper.observe(viewLifecycleOwner) {
            if (it.isSuccess) {

                when{
                    it.isRefresh ->{
                        mAdapter.refresh(it.loveData)
                        binding.freshLayout.isRefreshing = false
                    }
                }
                binding.freshLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun firstOnResume() {
        mViewModel.getLoveData(true)
        binding.freshLayout.isRefreshing = true
    }

}