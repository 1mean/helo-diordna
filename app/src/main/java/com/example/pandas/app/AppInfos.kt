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
    const val LOGIN_KEY = "login" //搜索登录信息存入sp的key  0为未登录，1为登录成功
    const val THEME_COLOR = "theme_color" //主题颜色
    const val ATTENTION_KEY = "attention" //搜索关注列表的key
    const val VIDEO_PLAY_KEY = "code" //视频播放界面需要传递的key
    const val BG_STATUS_KEY = "bg_status" //设置背景色
    const val RECO_STATUS_KEY = "reco_type" //设置推荐页面的排布类型
    const val MINE_STYLE_KEY = "mine_type" //我的界面的样式
    const val MUSIC_STYLE_KEY = "music_type" //音乐界面的样式
    const val LOCAL_DATA_KEY = "local_data_type" //音乐界面的样式
    const val HEAD_URL =
        "https://i2.hdslb.com/bfs/face/7974f1f6c031d305a30ea3ecd7aedadacb3921a4.jpg"

    // "https://i2.hdslb.com/bfs/face/7974f1f6c031d305a30ea3ecd7aedadacb3921a4.jpg@150w_150h.jpg"
    const val TYPE_MP3 = 999 //音乐类型

    //头像存储名
    const val HEAD_AUTHOR = "img_header_author"

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

    val bestAnimalVideoCodes = arrayOf(
        428,
        430,
        436,
        437,
        445,
        448,
        1051,
        1057,
        1059,
        1072,
        1075,
        1078,
        1085,
        1091,
        1093,
        1094,
        1096,
        1103,
        1105,
        1174,
        1177,
        1184,
        1186,
        1087,
        1189,
        1191,
        1192,
        1193,
        1194,
        1195,
        1196,
        1198,
        1199,
        1201,
        1204,
        1356,
        1370,
        1382,
        1383,
        1388,
        1687,
        1689,
        1690,
        1696,
        1697,
        1701,
        1703,
        1706,
        1707,
        1708,
        1709,
        1712,
        1714,
        1716,
        1717,
        1718,
        1719,
        1720,
        1723,
        1724,
        1726,
        1727,
        1729,
        1732,
        1736,
        1737,
        1739,
        1740,
        1741,
        1743,
        1745,
        1747,
        1752,
        1753,
        1756,
        1758,
        1763,
        1764,
        1766,
        1767,
        3319,
        3321,
        3327,
        3329,
        3332,
        3334,
        3335,
        3336,
        3338,
        3341,
        3342,
        3343,
        3344,
        3347,
        3349,
        3350,
        3353,
        3354,
        3357,
        3358,
        3359,
        3360,
        3361,
        3363,
        3365,
        3366,
        3368,
        3369,
        3370,
        3374,
        3375,
        3377,
        3378,
        3379,
        3382,
        3384,
        3385,
        3386,
        3396,
        3398,
        3399,
        3401,
        3407,
        3412,
        3594,
        3599,
        3601,
        3603,
        3604,
        3608,
        3609,
        3610,
        3613,
        3615,
        3617,
        3618,
        3619,
        3621,
        3626,
        3627,
        3628,
        3629,
        3631,
        3632,
        3633,
        3634,
        3644,
        3645,
        3639,
        3683,
        3685,
        3739,
        3743
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

    val bestBeautyVideoCodes = arrayOf(
        3654,
        1976,
        1172,
        1168,
        1157,
        3652,
        1150,
        1156,
        3686,
        1134,
        1133,
        3653,
        1158,
        1362,
        1161,
        1974,
        1159,
        1166,
        1975,
        1171,
        1138,
        1142,
        1139,
        1131,
        1135,
        1140,
        1141,
        1160,
        1977,
        1154,
        1153,
        1137,
        3651,
        1149,
        1163,
        3689,
        1136,
        1165,
        1144,
        1170,
        1361,
        1155,
        1132,
        1145,
        1167,
        1359,
        1162,
        1148,
        1169,
        1360,
        1152,
        3655,
        1151,
        3687,
        1147,
        1146,
        1164,
        1143,
        1973,
        3688,
        3647,
        3648,
        3703,
        3649,
        3710,
        1955,
        3705,
        1952,
        1387,
        1953,
        1959,
        1954,
        426,
        3709,
        1947,
        3646,
        1946,
        1944,
        1956,
        1948,
        3707,
        3708,
        1384,
        1958,
        1386,
        1951,
        3706,
        1949,
        1950,
        1945,
        1385,
        3704,
        1957,
        3650,
        3691, 3692, 1978, 1980, 3690, 1981, 1979, 1906, 3816, 3852, 3891, 3831,
    )
}