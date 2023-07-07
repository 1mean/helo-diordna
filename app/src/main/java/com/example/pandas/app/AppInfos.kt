package com.example.pandas.app

import com.example.pandas.R

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
    const val RECO_STATUS_KEY = "reco_type" //设置推荐页面的排布类型
    const val MINE_STYLE_KEY = "mine_type" //我的界面的样式
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

    val bgColors = arrayOf(
        R.color.color_bg_white,
        R.color.color_bg_pink,
        R.color.color_bg_black,
        R.color.color_bg_red,
        R.color.color_bg_yellow,
        R.color.color_bg_grey,
        R.color.color_bg_blue,
        R.color.color_bg_purple
    )

    val viewColors = arrayOf(
        R.color.color_bg_pink,
        R.color.color_bg_pink,
        R.color.color_bg_black,
        R.color.color_bg_red,
        R.color.color_bg_yellow,
        R.color.color_bg_grey,
        R.color.color_bg_blue,
        R.color.color_bg_purple
    )

    val drawables
        get() = arrayOf(
            R.drawable.shape_user_attention,
            R.drawable.shape_user_attention_pink,
            R.drawable.shape_user_attention_pink,
            R.drawable.shape_user_attention_red,
            R.drawable.shape_user_attention_yellow,
            R.drawable.shape_user_attention_grey,
            R.drawable.shape_user_attention_blue,
            R.drawable.shape_user_attention_purple
        )

    val bestPandaVideoCodes = arrayOf(
        4,
        6,
        12,
        14,
        16,
        17,
        18,
        26,
        28,
        31,
        44,
        45,
        56,
        60,
        64,
        73,
        77,
        80,
        81,
        90,
        94,
        104,
        105,
        111,
        112,
        113,
        114,
        121,
        152,
        153,
        154,
        160,
        192,
        204,
        215,
        230,
        234,
        241,
        243,
        254,
        268,
        271,
        276,
        287,
        299,
        306,
        317,
        350,
        369,
        373,
        412,
        419,
        494,
        509,
        516,
        524,
        527,
        553,
        560,
        567,
        580,
        585,
        592,
        601,
        618,
        621,
        626,
        631,
        702,
        758,
        759,
        817,
        848,
        854,
        855,
        862,
        875,
        1127,
        1210,
        1218,
        1227,
        1348,
        1354,
        1371,
        1391,
        1460,
        1476,
        1491,
        1492,
        1505,
        1507,
        1511,
        1512,
        1514,
        1534,
        1558,
        1566,
        1569,
        1572,
        1770,
        1582,
        2295,
        2304,
        2334,
        2385,
        2390,
        2397,
        2433,
        2441,
        2475,
        2484,
        2497,
        2505,
        2546,
        2555,
        2579,
        2661,
        2663,
        2736,
        2760,
        2790,
        2815,
        2823,
        2840,
        2844,
        2872,
        2895,
        2908,
        2910,
        2930,
        2937,
        2946,
        2948,
        2953,
        2955,
        2956,
        2958,
        2966,
        2982,
        2998,
        3061,
        3086,
        3225,
        3529,
        3762,
        3768,
        3769,
        3778,
    )
}