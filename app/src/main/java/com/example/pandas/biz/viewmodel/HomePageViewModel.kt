import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.biz.ext.loge
import com.example.pandas.biz.http.exception.ExceptionHandle
import kotlinx.coroutines.launch

/**
 * @description: homefragment viewmodel
 * @author: dongyiming
 * @date: 1/18/22 6:07 下午
 * @version: v1.0
 */
class HomePageViewModel : BaseViewModel() {

    var startIndex = 0//分页起始

    /***********************************************************************************
     * LiveData是不可变的，MutableLiveData是可变的
     * - 官方框架里：ViewModel内部使用了private的MutableLiveData实例，但对外暴露的是LiveData类型
     * *
     *   private val _user =  MutableLiveData<User>()
     *   val user:LiveData<User> = _user
     *   init{
     *       viewModelScope.launch{
     *               _user.value = dao.getUser(userId)
     *       }
     *   }
     ************************************************************************************/


    val petDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    val recommendDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    val loveDataWrapper: MutableLiveData<UIDataWrapper<PageCommonData>> by lazy { MutableLiveData() }

    val landScapeDataWrapper: MutableLiveData<UIDataWrapper<LandscapeData>> by lazy { MutableLiveData() }


    fun getPagePet(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }
        request({ PetManagerCoroutine.getPetByPage(startIndex) },
            {
                //请求数据成功
                startIndex += 20
                val dataList = UIDataWrapper(
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
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetViewData>()
                )
                petDataWrapper.value = dataList
            })
    }

    /**
     *  首页-推荐
     *
     * @author: dongyiming
     * @date: 2/7/22 5:26 下午
     * @version: v1.0
     */
    fun getRecommendData(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getRecommendByPage(startIndex)
            }.onSuccess {
                startIndex += if (startIndex == 0) 10 else 11
                val wrapper = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    hasMore = if (isRefresh) it.itemList.size == 10 else it.itemList.size == 11,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    recoData = it
                )
                recommendDataWrapper.value = wrapper
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

    fun getLoveData(isRefresh: Boolean) {

        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getLoveData(isRefresh, startIndex)
            }.onSuccess {
                startIndex += if (startIndex == 0) 10 else 11
                val dataList = UIDataWrapper<PageCommonData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    loveData = it
                )
                loveDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<PageCommonData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                )
                loveDataWrapper.value = dataList
            }
        }
    }

    fun getLandScapeData(isRefresh: Boolean) {

        if (isRefresh) {
            startIndex = 0
        }
        viewModelScope.launch {

            kotlin.runCatching {
                PetManagerCoroutine.getLandscapeData(startIndex, 10)
            }.onSuccess {
                startIndex += 10
                val dataList = UIDataWrapper<LandscapeData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    hasMore = it.itemList.size == 10,
                    isFirstEmpty = isRefresh && it.itemList.isEmpty() && it.bannerList.isEmpty(),
                    landscapeData = it
                )
                landScapeDataWrapper.value = dataList
            }.onFailure {

                it.message?.loge()
                it.printStackTrace()
                val exception = ExceptionHandle.handleException(it)
                val dataList = UIDataWrapper<LandscapeData>(
                    isSuccess = false,
                    errMessage = exception.errorMsg,
                    isRefresh = isRefresh,
                    landscapeData = LandscapeData()
                )
                landScapeDataWrapper.value = dataList
            }
        }
    }
}