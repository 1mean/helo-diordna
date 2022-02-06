import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pandas.R
import com.example.pandas.databinding.FragmentSelfBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSelfBinding? = null
    private val binding get() = _binding!!

    private val tablist = arrayListOf<String>("缓存", "收藏", "点赞")

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                Log.e("dongyiming", "hello")
            }
        }

    private val fileLauncher = registerForActivityResult(ActivityResultContracts.GetContent(),
        ActivityResultCallback {

        })

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSelfBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(R.mipmap.ou).apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.imgAuthor)

        binding.vpSelf.adapter = SelfFragmentAdapter(requireActivity())
        binding.vpSelf.offscreenPageLimit = 1
        TabLayoutMediator(
            binding.tlRoom, binding.vpSelf, true
        ) { tab, position ->
            tab.text = tablist[position]
        }.attach()

    }

    override fun onResume() {
        super.onResume()
        //StatusBarUtils.updataStatus(requireActivity(), false, true, R.color.color_white_lucency)
    }

    override fun onClick(view: View?) {

//        when (view?.id) {
//            R.id.btn_1 -> {
//                val intent = Intent(activity, BehaviorActivity::class.java)
//                startActivity(intent)
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}