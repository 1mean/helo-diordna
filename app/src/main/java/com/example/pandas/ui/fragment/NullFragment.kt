import android.os.Bundle
import com.example.pandas.base.fragment.BaseFragment
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.databinding.FragmentNullBinding

/**
 * @description: NullFragment
 * @author: dongyiming
 * @date: 5/16/23 6:46 PM
 * @version: v1.0
 */
public class NullFragment : BaseFragment<BaseViewModel, FragmentNullBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }

    override fun firstOnResume() {
    }

}