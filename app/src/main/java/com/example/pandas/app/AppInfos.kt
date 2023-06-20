package com.example.pandas.app

/**
 * 项目通用信息
 * @author: dongyiming
 * @date: 3/2/22 5:21 下午
 * @version: v1.0
 */
object AppInfos {

    const val APP_FLAG = false
    const val AUTHOR_ID = 1074309089 //作者ID
    const val AUTHOR_NAME = "和叶小可怜" //作者ID
    const val DEBUG_LOG_TAG = "pandas_log" //debug版本的默认删除日志tag
    const val SEARCH_KEY = "history" //搜索历史记录存入sp的key
    const val THEME_COLOR = "theme_color" //主题颜色
    const val ATTENTION_KEY = "attention" //搜索关注列表的key
    const val VIDEO_PLAY_KEY = "code" //视频播放界面需要传递的key
    const val BG_STATUS_KEY = "bg_status" //设置背景色
    const val HEAD_URL =
        "https://i2.hdslb.com/bfs/face/7974f1f6c031d305a30ea3ecd7aedadacb3921a4.jpg"

    // "https://i2.hdslb.com/bfs/face/7974f1f6c031d305a30ea3ecd7aedadacb3921a4.jpg@150w_150h.jpg"
    const val TYPE_MP3 = 999 //音乐类型

    const val headImgUrl = "https://i0.hdslb.com/bfs/face/member/noface.jpg@240w_240h_1c_1s.webp"

    //const val appKey = "62e9ec5305844627b50de961"
    const val appKey = "62ed041d05844627b5129e25"
    const val channel = "um_helo"


    //阈值
    const val useTempShortComment = true

    val provinces = mutableListOf(
        "北京",
        "天津",
        "上海",
        "重庆",
        "河北",
        "山西",
        "辽宁",
        "吉林",
        "黑龙江",
        "江苏",
        "浙江",
        "安徽",
        "福建",
        "江西",
        "山东",
        "河南",
        "湖北",
        "湖南",
        "广东",
        "海南",
        "四川",
        "贵州",
        "云南",
        "陕西",
        "甘肃",
        "青海",
        "台湾",
        "内蒙古",
        "广西",
        "西藏",
        "宁夏",
        "新疆",
        "香港",
        "澳门"
    )
}