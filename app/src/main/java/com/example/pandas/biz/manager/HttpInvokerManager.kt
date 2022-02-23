import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.http.EyepetozerConvert
import com.example.pandas.biz.http.httpService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @description: 数据处理manager
 * @author: dongyiming
 * @date: 2/23/22 12:42 上午
 * @version: v1.0
 */

val httpManager: HttpInvokerManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { HttpInvokerManager() }

public class HttpInvokerManager {

    suspend fun getHotList(startIndex: Int, num: Int): MutableList<EyepetozerBean> {

        return withContext(Dispatchers.IO) {

            val list = httpService.getHotList(startIndex, num)
            EyepetozerConvert.convert(list)
        }
    }

}