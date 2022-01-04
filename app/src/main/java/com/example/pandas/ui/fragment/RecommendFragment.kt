import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pandas.bean.pet.PetVideo
import com.example.pandas.databinding.FragmentRecommendBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/4/22 3:05 下午
 * @version: v1.0
 */
public class RecommendFragment : Fragment(),ILoadMoreListener {

    private var _binding: FragmentRecommendBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = binding.rview
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.setRefreshAdapter(RecommendAdapter(initData()),this)
        recyclerView.addItemDecoration(RecommendDecoration(requireActivity()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initData(): MutableList<PetVideo> {
        val list = mutableListOf<PetVideo>()
        for (i in 0 until 20) {

            val pet = PetVideo()
            pet.type = 2
            list.add(pet)
        }
        return list
    }

    override fun onLoadMore() {

    }
}