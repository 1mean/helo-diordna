import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.databinding.FragmentHomeBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/3/22 11:42 下午
 * @version: v1.0
 */
public class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Glide.with(requireContext()).load(R.mipmap.jia).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgHead)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}