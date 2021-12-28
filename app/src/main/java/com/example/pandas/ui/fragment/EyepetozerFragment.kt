import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                recyclerView?.setRefreshAdapter(mAdapter!!,listener)
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
        }

//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//
//
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                when(newState){
//                    RecyclerView.SCROLL_STATE_IDLE -> {
//                        val totalCount =  mAdapter?.itemCount
//                        Log.e("mean1","count: " + mAdapter?.itemCount)
//                        val position = layoutManager.findLastVisibleItemPosition()
//                        Log.e("mean1","position: $position")
//                        if (!refreshLayout.isRefreshing && position == totalCount!! - 1) {
//
//                        }
//
//                    }
//                }
//
//            }
//        })

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
}