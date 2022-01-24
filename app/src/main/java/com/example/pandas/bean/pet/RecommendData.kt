/**
 * @description: TODO
 * @author: dongyiming
 * @date: 1/23/22 3:20 下午
 * @version: v1.0
 */
data class RecommendData<T>(

    //默认是普通视频,type=1是轮播图,type=2是横屏
    var itemList: MutableList<T> = mutableListOf(),  //视屏数据
    var bannerList: MutableList<T> = mutableListOf() //轮播图数据
)

