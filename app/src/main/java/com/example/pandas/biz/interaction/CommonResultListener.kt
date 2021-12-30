/**
 * @description: TODO
 * @author: dongyiming
 * @date: 12/31/21 12:53 上午
 * @version: v1.0
 */
public interface CommonResultListener<T> {

    fun onResult(t: T)

    fun onFailure(errorMessage: String)
}