import android.content.Intent
import android.os.Bundle
import com.example.pandas.app.AppInfos
import com.example.pandas.base.fragment.BaseLazyFragment
import com.example.pandas.biz.ext.loadCircleImage
import com.example.pandas.databinding.FragmentMineBinding
import com.example.pandas.ui.activity.HistoryActivity
import com.example.pandas.ui.activity.LocalCacheActivity

/**
 * @description: SelfFragment
 * @author: dongyiming
 * @date: 2021/11/25 3:57 下午
 * @version: v1.0
 */
public class SelfFragment : BaseLazyFragment<SelfViewModel, FragmentMineBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        loadCircleImage(mActivity, AppInfos.HEAD_URL, binding.imgMineHeader)
        binding.clayoutDownload.setOnClickListener {
            startActivity(Intent(activity, LocalCacheActivity::class.java))
        }
        binding.clayoutHistory.setOnClickListener {
            startActivity(Intent(activity, HistoryActivity::class.java))
        }
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}