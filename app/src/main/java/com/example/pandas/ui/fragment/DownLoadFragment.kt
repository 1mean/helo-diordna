import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pandas.R

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/18 11:42 下午
 * @version: v1.0
 */
public class DownLoadFragment : Fragment(R.layout.fragment_download) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = view.findViewById<RecyclerView>(R.id.rl_download)

        val layoutManager = GridLayoutManager(context, 2)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.addItemDecoration(DownLoadItemDecoration(requireContext()))
        mRecyclerView.adapter = DownLoadAdapter()
    }

}