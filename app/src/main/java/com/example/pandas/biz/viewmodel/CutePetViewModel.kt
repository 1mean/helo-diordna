import androidx.lifecycle.MutableLiveData
import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PetViewData

/**
 * @description: 获取宠物信息
 * @author: dongyiming
 * @date: 1/26/22 12:00 上午
 * @version: v1.0
 */
public class CutePetViewModel : BaseViewModel() {

    val bannerWrapper: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }
    val pageDataWrapper: MutableLiveData<UIDataWrapper<PetViewData>> by lazy { MutableLiveData() }

    //分页起始位置
    var startIndex = 0

    fun getBannerData(isRefresh: Boolean) {

        request({ PetManagerCoroutine.getCutePetBannerData() },
            {
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    listData = it
                )
                bannerWrapper.value = dataList
            },
            {
                val dataList = UIDataWrapper<PetViewData>(
                    isSuccess = false,
                    isRefresh = isRefresh,
                    errMessage = it.errorMsg,
                    listData = mutableListOf<PetViewData>()
                )
                bannerWrapper.value = dataList
            })
    }

    private var hasMore = false
    fun getDataByPage(isRefresh: Boolean, type: Int) {

        if (isRefresh) {
            startIndex = 0
        }

        request({ PetManagerCoroutine.getCutePetByType(type, startIndex, 21) },
            {

                hasMore = if (it.isNotEmpty() && it.size > 20) {
                    it.removeLast()
                    true
                } else {
                    false
                }
                val dataList = UIDataWrapper(
                    isSuccess = true,
                    isRefresh = isRefresh,
                    isEmpty = it.isEmpty(),
                    hasMore = hasMore,
                    isFirstEmpty = isRefresh && it.isEmpty(),
                    listData = it
                )
                startIndex += 20
                pageDataWrapper.value = dataList
            },
            {
                val dataList = UIDataWrapper(
                    isSuccess = false,
                    errMessage = it.errorMsg,
                    isRefresh = isRefresh,
                    listData = mutableListOf<PetViewData>()
                )
                pageDataWrapper.value = dataList
            })
    }
}