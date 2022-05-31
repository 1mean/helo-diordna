package com.example.pandas.data

import com.example.pandas.bean.VideoComment

object TempData {

    val userCode = arrayListOf(
        523707706,
        348483302,
        28374744,
        41665075,
        1813574272,
        360321868,
        1151868166,
        34677299,
        335419800,
        7782934,
        478823961,
        18329821,
        39546503,
        1998535,
        66688464,
        40656188,
        92694869,
        36814636,
        98093909,
        20429499,
        293243325,
        2087432052,
        396343652,
        404523870,
        42448991,
        19429622,
        2024662,
        44341427,
        435041418,
        200634377,
        9370995,
        27306175,
        373529092,
        12444306,
        90548795,
        551467383,
        231314384,
        1435076062,
        374231948,
        288516776,
        4120384,
        627116323,
        175546072,
        3232184,
        404842697,
        346324250,
        30738231,
        43296249,
        668149765,
        3107068,
        179512321,
        549090612,
        312245686,
        27120931,
        1984573756,
        2106730041,
        514531996,
        4038416,
        1370008,
        16468440,
        1025949925,
        384395600,
        3917675,
        269899367,
        476733832,
        281381350,
        1307515,
        444796647,
        396450082,
        1499649009,
        580108645,
        591240042,
        272434852,
        66204694,
        493908108,
        255618361,
        1251374263,
        15287042,
        324568428,
        1968693474,
        406863853,
        388687723,
        276536331,
        13870029,
        176605331,
        373867,
        430127427,
        551961363,
        72209046,
        1247719104,
        488055582,
        1098561796,
        37053244,
    )

    val contents = arrayListOf<String>(
        "我不是你喜欢的",
        "毛呢我不是你喜欢的我不是你喜欢的我不是你喜欢的我不是你喜欢的我不是你喜欢的我不是你喜欢的",
        "我不是你喜欢的我不是你喜欢阿萨德大事阿斯顿是你喜欢的我不是你喜欢的"
    )

    fun getComments(count: Int): MutableList<VideoComment> {

        val list = mutableListOf<VideoComment>()
        var time = 1653849393000
        for (i in 1..count) {
            var isUpLike = false
            val num1 = (0..100).random()
            if (num1 > 70) {
                isUpLike = true
            }
            val num2 = (1..200).random()
            val comment = VideoComment(
                userCode = userCode.random(),
                commitTime = time.toLong(),
                content = contents.random(),
                isUpLike = isUpLike,
                likeNum = num2
            )
            time -= 2000000
            list.add(comment)
        }
        return list
    }
}