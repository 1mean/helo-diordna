import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandas.R
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.controller.EyepetozerController
import com.example.pandas.biz.interaction.ICommonInvokeResult
import com.example.pandas.databinding.FragmentEyesBinding
import com.example.pandas.ui.view.refresh.RefreshRecyclerView

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/21 2:16 下午
 * @version: v1.0
 */
public class EyepetozerFragment : Fragment() {

    private var _controller: EyepetozerController? = null
    private val controller get() = _controller!!
    private var _binding: FragmentEyesBinding? = null
    private val binding get() = _binding!!
    private var mAdapter: EyepetozerAdapter? = null
    private var recyclerView: RefreshRecyclerView? = null

    //{ http://baobab.kaiyanapp.com/api/v4/discovery/hot?start=20&num=20 }
    private var start: Int = 20

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEyesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvEye
        val layoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = layoutManager
        _controller = EyepetozerController()
        controller.initData(object : ICommonInvokeResult<MutableList<EyepetozerBean>, String> {
            override fun onResult(t: MutableList<EyepetozerBean>) {

                mAdapter = EyepetozerAdapter(t)
                recyclerView?.setRefreshAdapter(mAdapter!!, listener)
            }

            override fun onFailure(e: String) {
                Log.e("1mean", "error msg: $e")
            }

            override fun onCompleted() {
            }
        })

        val refreshLayout = binding.refreshLayout
        refreshLayout.setColorSchemeResources(
            R.color.gray,
            R.color.red,
            R.color.orange,
            R.color.green
        )
        refreshLayout.setOnRefreshListener {

            refreshLayout.isRefreshing = true
            recyclerView?.isFreshing(true)
            controller.initData(object : ICommonInvokeResult<MutableList<EyepetozerBean>, String> {
                override fun onResult(t: MutableList<EyepetozerBean>) {

                    refreshLayout.isRefreshing = false
                    recyclerView?.isFreshing(false)
                    mAdapter?.refresh(t)
                }

                override fun onFailure(e: String) {
                    refreshLayout.isRefreshing = false
                    recyclerView?.isFreshing(false)
                }

                override fun onCompleted() {
                    refreshLayout.isRefreshing = false
                    recyclerView?.isFreshing(false)
                }
            })
        }
    }

    val listener = object : ILoadMoreListener {
        override fun onLoadMore() {
            controller.loadMore(
                start,
                20,
                object : ICommonInvokeResult<MutableList<EyepetozerBean>, String> {
                    override fun onResult(t: MutableList<EyepetozerBean>) {
                        start += 20
                        mAdapter?.addList(t)
                        recyclerView?.loadMoreFinished()
                    }

                    override fun onFailure(e: String) {
                        Log.e("1mean", "error msg: $e")
                    }

                    override fun onCompleted() {
                    }
                })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        StatusBarUtils.updataStatus(requireActivity(), true, false, R.color.color_white_lucency)
    }
}