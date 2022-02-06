import com.example.pandas.bean.CoverDownLoad
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.PetType
import com.example.pandas.bean.pet.PetViewData
import com.example.pandas.bean.pet.SleepModel
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.database.AppDataBase
import com.example.pandas.sql.entity.MusicVo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @description: 处理所有pet相关
 * @author: dongyiming
 * @date: 1/20/22 1:11 上午
 * @version: v1.0
 */
val PetManagerCoroutine: PetManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { PetManager() }

class PetManager {

    private val petDao: PetVideoDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().petVideoDao()
    }

    suspend fun getPetByPage(startIndex: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            petDao.queryByPage(startIndex)
        }
    }

    /**
     * 获取首页推荐栏数据
     * @param: pageNo ： 只有第一页才有轮播图
     * @return: 页面分布：轮播图+star视频+横屏视频
     * @date: 1/22/22 7:47 下午
     * @version: v1.0
     */
    suspend fun getRecommendByPage(startIndex: Int): RecommendData<PetViewData> {

        return withContext(Dispatchers.IO) {
            val recommendData = RecommendData<PetViewData>()
            if (startIndex == 0) {//首页
                recommendData.bannerList = petDao.queryByVideoType(1)
                recommendData.itemList = petDao.queryStarByPage(startIndex, 10)
            } else {
                recommendData.itemList = petDao.queryStarByPage(startIndex, 11)
            }
            recommendData
        }
    }

    /**
     * 通过videoType获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getCutePetBannerData(): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            petDao.queryByVideoType(3)
        }
    }

    /**
     * 通过type获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getCutePetByType(type: Int, startIndex: Int): MutableList<PetViewData> {

        return withContext(Dispatchers.IO) {
            petDao.queryByTypeAndPage(type, startIndex)
        }
    }

    /**
     * 通过type获取轮播图数据
     * @date: 1/26/22 5:27 下午
     * @version: v1.0
     */
    suspend fun getLoveData(): PageCommonData {

        return withContext(Dispatchers.IO) {

            val data = PageCommonData()
            val songs = petDao.queryMusicByPage(0, 5)
            data.songs = songs

            val sleepModel = SleepModel()
            sleepModel.videos = petDao.queryByCounts(4)
            sleepModel.audios = petDao.queryMusicByPage(0, 5)
            data.sleepModel = sleepModel

            data.talkAudios = petDao.queryMusicByPage(0, 5)
            data
        }
    }

    /**
     * 获取分页的music数据
     */
    suspend fun getPageMusic(startIndex: Int, counts: Int): MutableList<MusicVo> {

        return withContext(Dispatchers.IO) {
            petDao.queryMusicByPage(startIndex, counts)
        }
    }

    suspend fun getLandscapeData(startIndex: Int, counts: Int): LandscapeData {

        return withContext(Dispatchers.IO) {

            val itemList = petDao.queryVideoByType(PetType.LANDSCAPE.ordinal, startIndex, counts)
            var bannerList = mutableListOf<PetViewData>()
            if (startIndex == 0) {
                bannerList = petDao.queryBannerByType(PetType.LANDSCAPE.ordinal)
            }
            LandscapeData(bannerList, itemList)
        }
    }

    suspend fun getAllPetCoverUrl(): MutableList<CoverDownLoad> {

        return withContext(Dispatchers.IO) {
            petDao.queryAllPetCovers()
        }
    }

}