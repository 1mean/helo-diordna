import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import kotlinx.coroutines.launch

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/18/22 6:07 下午
 * @version: v1.0
 */
class HomePageViewModel : BaseViewModel() {

    var pageNo = 0 //分页获取数据
    var startIndex = 0//分页起始

    //获取所有宠物的输出
    var petDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> = MutableLiveData()

    var recommendDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> = MutableLiveData()


    fun getPagePet(isRefresh: Boolean) {

        if (isRefresh) {
            pageNo = 0
        }
        request({ PetManagerCoroutine.getPetByPage(startIndex) },
            {
                //请求数据成功
                startIndex += 20
                pageNo++

                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = it.size == 20,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
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
                petDataWrapper.value = dataList
            })
    }

    fun getRecommendData(isRefresh: Boolean) {

        if (isRefresh) {
            pageNo = 0
            startIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getRecommendByPage(startIndex)
            }.onSuccess {
                if (startIndex == 0) startIndex += 10 else startIndex += 11
                pageNo++
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    hasMore = (it.itemList.size + it.bannerList.size) == 11,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    recoData = it
                )
                recommendDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    recoData = RecommendData()
                )
                recommendDataWrapper.value = dataList
            }
        }
    }
}