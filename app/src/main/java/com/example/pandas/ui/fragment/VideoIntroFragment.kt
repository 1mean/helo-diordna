import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.databinding.FragmentVideoIntroBinding

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/29/21 11:39 下午
 * @version: v1.0
 */
public class VideoIntroFragment:Fragment(),CommonResultListener<MutableList<EyepetozerBean>> {

    var videoCode: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        lifecycle.addObserver(object :DefaultLifecycleObserver{


            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)

                val eyepetozerBean = activity?.intent?.getParcelableExtra<EyepetozerBean>("EyepetozerBean")
                videoCode = eyepetozerBean?.videoId
            }
        })
    }


    private var _binding:FragmentVideoIntroBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoIntroBinding.inflate(inflater,container,false)

        val controller = VideoIntroController(this)
        controller.getRecommendVideos(videoCode!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvVideo


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResult(t: MutableList<EyepetozerBean>) {

    }

    override fun onFailure(errorMessage: String) {

    }
}