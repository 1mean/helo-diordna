import androidx.lifecycle.ViewModel
import com.example.pandas.base.viewmodel.BaseViewModel
import com.example.pandas.base.viewmodel.UnPeekLiveData

/**
 * @description: AppViewModel
 * @author: dongyiming
 * @date: 6/21/23 1:27 AM
 * @version: v1.0
 */
public class AppViewModel : ViewModel() {

    //App主题颜色 中大型项目不推荐以这种方式改变主题颜色，比较繁琐耦合，且容易有遗漏某些控件没有设置主题色
    val appColorType by lazy { UnPeekLiveData<Int>() }

    val recommendType by lazy { UnPeekLiveData<Int>() }
}