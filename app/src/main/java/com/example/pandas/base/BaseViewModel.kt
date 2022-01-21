import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.AppException
import com.example.pandas.biz.http.exception.ExceptionHandle
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/19/22 1:16 下午
 * @version: v1.0
 */
open class BaseViewModel:ViewModel() {


    fun <T> request(
        block:suspend() -> MutableList<T>,
        success:(MutableList<T>) -> Unit,
        error:(AppException) ->Unit ={}
    ):Job{
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                success(it)
            }.onFailure {
                it.message?.loge()
                it.printStackTrace()
                error(ExceptionHandle.handleException(it))
            }
        }
    }
}