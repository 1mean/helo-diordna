package com.example.pandas.biz.http

import com.example.pandas.bean.eyes.*

/**
 * 只保留video
 * @author: dongyiming
 * @date: 4/8/22 3:02 下午
 * @version: v2.0
 */
object EyepetozerConvert {

    fun convertAll(eyepetozer: Eyepetozer?): MutableList<EyepetozerItem> {
        val list: MutableList<EyepetozerItem> = mutableListOf()
        val itemList = eyepetozer?.itemList
        itemList?.let {
            if (it.isNotEmpty()) {
                for (item in it) {
                    //目前界面展示三种item_type
                    when (item.type) {
                        "horizontalScrollCard" -> {
                            list.add(buildScrollCard(item))
                        }
                        "textHeader" -> {
                            list.add(buildHeader(item))
                        }
                        "video" -> {
                            list.add(buildVideo(item, true))
                        }
                        "videoSmallCard" -> {
                            list.add(buildVideo(item, false))
                        }
                    }
                }
            }
        }
        return list
    }

    fun convertOnlyVideo(eyepetozer: Eyepetozer?): MutableList<EyepetozerItem> {
        val list: MutableList<EyepetozerItem> = mutableListOf()
        val itemList = eyepetozer?.itemList
        itemList?.let {
            if (it.isNotEmpty()) {
                for (item in it) {
                    //目前界面展示三种item_type
                    when (item.type) {
                        "video" -> {
                            list.add(buildVideo(item, true))
                        }
                        "videoSmallCard" -> {
                            list.add(buildVideo(item, false))
                        }
                    }
                }
            }
        }
        return list
    }

    fun convertTitleVideo(eyepetozer: Eyepetozer?): MutableList<EyepetozerItem> {
        val list: MutableList<EyepetozerItem> = mutableListOf()
        val itemList = eyepetozer?.itemList
        itemList?.let {
            if (it.isNotEmpty()) {
                for (item in it) {
                    //目前界面展示三种item_type
                    when (item.type) {
                        "textHeader" -> {
                            list.add(buildHeader(item))
                        }
                        "video" -> {
                            list.add(buildVideo(item, true))
                        }
                    }
                }
            }
        }
        return list
    }

    fun convertEyepetozerData(eyepetozer: Eyepetozer?): EyepetozerData {

        var eyepetozerData = EyepetozerData()
        eyepetozer?.let {

            eyepetozerData = EyepetozerData(
                date = it.date,
                nextPageUrl = it.nextPageUrl,
                nextPublishTime = it.nextPublishTime
            )
            val list: MutableList<EyepetozerItem> = mutableListOf()
            val itemList = it.itemList
            if (itemList.isNotEmpty()) {
                for (item in itemList) {
                    //目前界面展示三种item_type
                    when (item.type) {
                        "textHeader" -> {
                            list.add(buildHeader(item))
                        }
                        "video" -> {
                            list.add(buildVideo(item, true))
                        }
                    }
                }
            }
            eyepetozerData.itemList = list
        }
        return eyepetozerData
    }

    /**
     * 重构ScrollCard
     *
     * @date: 2021/12/22 10:18 下午
     * @version: v1.0
     */
    private fun buildScrollCard(item: Item): EyepetozerItem {

        val eyeBean = EyepetozerItem()
        val horizontalCardList: MutableList<String> = mutableListOf()
        eyeBean.type = 1
        eyeBean.count = item.data.count
        val listx = item.data.itemList
        for (itemX in listx) {
            horizontalCardList.add(itemX.data.image)
        }
        eyeBean.horizontalCardList = horizontalCardList
        return eyeBean
    }

    /**
     * 重构Header
     *
     * @date: 2021/12/22 10:18 下午
     * @version: v1.0
     */
    private fun buildHeader(item: Item): EyepetozerItem =
        EyepetozerItem(type = 2, title = item.data.text)

    /**
     * 重构Video
     *
     * @date: 2021/12/22 10:18 下午
     * @version: v1.0
     */
    private fun buildVideo(item: Item, flag: Boolean): EyepetozerItem {

        val eyeBean = EyepetozerItem()
        val data = item.data
        val consumption = data.consumption
        val author = data.author
        val playList = data.playInfo
        val cover = data.cover
        if (flag) eyeBean.type = 3 else eyeBean.type = 4
        eyeBean.title = data.title
        eyeBean.coverUrl = cover.feed
        eyeBean.videoId = data.id
        eyeBean.description = data.description
        eyeBean.collectionCount = consumption.collectionCount
        eyeBean.shareCount = consumption.shareCount
        eyeBean.replyCount = consumption.replyCount
        eyeBean.realCollectionCount = consumption.realCollectionCount
        author?.let {
            eyeBean.userCode = it.id
            eyeBean.user = createAuthor(it)
        }
        eyeBean.category = data.category
        eyeBean.playUrl = data.playUrl
        eyeBean.duration = data.duration
        eyeBean.videoType = data.type
        eyeBean.releaseTime = data.releaseTime
        for (playInfo in playList) {
            when (playInfo.type) {
                "normal" -> eyeBean.normalUrl = playInfo.url
                "high" -> eyeBean.highUrl = playInfo.url
            }
        }
        return eyeBean
    }

    /**
     * 创建EyepetozerUser
     * @param:
     * @return:
     * @version: v1.0
     */
    private fun createAuthor(author: Author): EyepetozerUser = EyepetozerUser(
        author.id,
        author.name,
        author.icon,
        author.description,
        author.latestReleaseTime,
        author.videoNum
    )
}