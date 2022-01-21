import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pandas.bean.pet.PetViewData

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/18/22 6:07 下午
 * @version: v1.0
 */
public class PetViewModel : BaseViewModel() {

    var pageNo = 0 //分页获取数据

    //获取所有宠物的输出
    var petDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> = MutableLiveData()

    fun getPagePet(isRefresh: Boolean) {

        if (isRefresh) {
            pageNo = 0
        }
        Log.e("1mean", "pageNo: $pageNo")
        request({ PetManagerCoroutine.getPetByPage(pageNo) },
            {
                //请求数据成功
                pageNo += 20

                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = it.size == 20,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                it.forEach {
                    Log.e("1mean", "code: " + it.code)
                }
                petDataWrapper.value = dataList
            },
            {
                //请求数据失败
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetViewData>()
                )
                Log.e("1mean", "error: " + it.errorMsg)
                petDataWrapper.value = dataList
            })
    }

}