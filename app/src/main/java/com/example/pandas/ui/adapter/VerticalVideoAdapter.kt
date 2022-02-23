import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import com.example.pandas.bean.eyes.EyepetozerBean

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2/24/22 12:26 上午
 * @version: v1.0
 */
public class VerticalVideoAdapter(private val list:MutableList<EyepetozerBean>):BaseCommonAdapter<EyepetozerBean>(list) {

    override fun getLayoutId(): Int = R.layout.adapter_vertical_video

    override fun convert(holder: BaseViewHolder, data: EyepetozerBean, position: Int) {

    }

}