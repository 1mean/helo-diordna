import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pandas.databinding.FragmentBlogsBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/12/19 11:23 下午
 * @version: v1.0
 */
public class BlogsFragment : Fragment() {

    private var _binding: FragmentBlogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBlogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.wv.loadUrl("http://baobab.kaiyanapp.com/api/v4/webview/?title=&url=https%3A%2F%2Fwww.kaiyanapp.com%2Fnew_article.html%3Fnid%3D2529%26shareable%3Dtrue%26type%3DarticleTopic%26cid%3D2273")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}