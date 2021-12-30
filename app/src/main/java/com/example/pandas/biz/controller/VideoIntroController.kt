import com.example.pandas.bean.eyes.EyepetozerBean
import com.example.pandas.biz.http.invoker.EyepetozerHttpInvoker
import io.reactivex.rxjava3.observers.ResourceObserver

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/30/21 10:53 下午
 * @version: v1.0
 */
public class VideoIntroController(private val listener: CommonResultListener<MutableList<EyepetozerBean>>) {

    private var invoker: EyepetozerHttpInvoker? = null

    init {
        invoker = EyepetozerHttpInvoker()
    }

    fun getRecommendVideos(videoId: Int) {

        val observer = object : ResourceObserver<MutableList<EyepetozerBean>>() {
            override fun onNext(list: MutableList<EyepetozerBean>) {

                listener.onResult(list)
            }

            override fun onError(e: Throwable) {
                listener.onFailure(e.toString())
            }

            override fun onComplete() {
            }
        }
        invoker?.getRecommendVideos(videoId, observer)
    }

}