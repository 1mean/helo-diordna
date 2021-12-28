import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pandas.databinding.FragmentPandaBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/11 3:54 下午
 * @version: v1.0
 */
public class RoomPandaFragment : Fragment() {

    private var _binding: FragmentPandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        gridManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE;
        binding.rv.layoutManager = gridManager
        binding.rv.addItemDecoration(RoomItemDecoration(requireContext()))
        binding.rv.adapter = activity?.let { PandaAdapter(it,initData()) }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initData(): MutableList<Panda> {

        val list = mutableListOf<Panda>()
        for (i in 1..20) {
            val panda = Panda()
            if (i % 2 == 0) panda.type = 0 else panda.type = 1
            list.add(panda)
        }
        return list
    }
}