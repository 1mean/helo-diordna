import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.pandas.R
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.activity.LocalCacheActivity

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : BaseLazyFragment<SelfViewModel, FragmentMineBinding>(),
    View.OnClickListener {

    override fun initView(savedInstanceState: Bundle?) {

        loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        binding.clayoutDownload.setOnClickListener(this)
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.clayout_download -> {
                val intent = Intent(activity, LocalCacheActivity::class.java)
                startActivity(intent)
            }
        }
    }
}