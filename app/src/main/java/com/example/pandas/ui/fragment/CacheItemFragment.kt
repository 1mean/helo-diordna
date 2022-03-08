import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pandas.biz.viewmodel.LocalCacheViewModel
import com.example.pandas.databinding.LayoutLoadmoreBinding

/**
 * @description: CacheItemFragment
 * @author: dongyiming
 * @date: 3/8/22 11:26 下午
 * @version: v1.0
 */
public class CacheItemFragment : BaseFragment<LocalCacheViewModel, LayoutLoadmoreBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

    override fun onHiddenChanged(hidden: Boolean) {

        Log.e("2mean", "hidden: $hidden")
        if (!hidden) {
            val list = mViewModel.getItemList(true, mActivity)

        }
    }

    override fun getCurrentLifeOwner(): ViewModelStoreOwner {
        return mActivity
    }

    override fun lazyLoadTime(): Long = 0
}