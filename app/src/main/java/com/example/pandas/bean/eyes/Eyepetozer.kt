package com.example.pandas.bean.eyes

/**
 * @description: 原始数据，只做原始数据的解析，只保留部分项目需要的数据
 * @author: dongyiming
 * @date: 2021/12/21 6:34 下午
 * @version: v1.0
 */
data class Eyepetozer(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: String,
    val total: Int,
    val date:Long,
    val nextPublishTime:Long
)

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class Data(
    val ad: Boolean,
    val adTrack: Any,
    val author: Author? = null,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val collected: Boolean,
    val consumption: Consumption,
    val count: Int,
    val cover: Cover,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: Any,
    val duration: Int,
    val favoriteAdTrack: Any,
    val font: String,
    val footer: Any,
    val header: Header,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val itemList: List<ItemX>,
    val label: Any,
    val labelList: List<Any>,
    val lastViewTime: Any,
    val library: String,
    val playInfo: List<PlayInfo>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: Provider,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val recall_source: Any,
    val releaseTime: Long,
    val remark: Any,
    val resourceType: String,
    val searchWeight: Int,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subtitles: List<Any>,
    val tags: List<Tag>,
    val text: String,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: Any,
    val type: String,
    val videoPosterBean: Any,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: WebUrl
)

data class Author(
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: Shield,
    val videoNum: Int
)

data class Consumption(
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
)

data class Cover(
    val blurred: String,
    val detail: String,
    val feed: String,
    val homepage: Any,
    val sharing: Any
)

data class Header(
    val actionUrl: String,
    val cover: Any,
    val font: String,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: Any,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val title: String
)

data class ItemX(
    val adIndex: Int,
    val `data`: DataX,
    val id: Int,
    val tag: Any,
    val trackingData: Any,
    val type: String
)

data class PlayInfo(
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<Url>,
    val width: Int
)

data class Provider(
    val alias: String,
    val icon: String,
    val name: String
)

data class Tag(
    val actionUrl: String,
    val adTrack: Any,
    val bgPicture: String,
    val childTagIdList: Any,
    val childTagList: Any,
    val communityIndex: Int,
    val desc: Any,
    val haveReward: Boolean,
    val headerImage: String,
    val id: Int,
    val ifNewest: Boolean,
    val name: String,
    val newestEndTime: Any,
    val tagRecType: String
)

data class WebUrl(
    val forWeibo: String,
    val raw: String
)

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)

data class Shield(
    val itemId: Int,
    val itemType: String,
    val shielded: Boolean
)

data class DataX(
    val actionUrl: String,
    val adTrack: List<Any>,
    val autoPlay: Boolean,
    val dataType: String,
    val description: String,
    val header: HeaderX,
    val id: Int,
    val image: String,
    val label: Label,
    val labelList: List<Any>,
    val shade: Boolean,
    val text: String,
    val title: String
)

data class HeaderX(
    val actionUrl: Any,
    val cover: Any,
    val description: Any,
    val font: Any,
    val icon: Any,
    val id: Int,
    val label: Any,
    val labelList: Any,
    val rightText: Any,
    val subTitle: Any,
    val subTitleFont: Any,
    val textAlign: String,
    val title: Any
)

data class Label(
    val card: String,
    val detail: Any,
    val text: String
)

//size报错：2158606266超出了Int的范围，int范围-2·31-2·31-1，即-2147483648——2147483647
data class Url(
    val name: String,
    val size: Long,
    val url: String
)