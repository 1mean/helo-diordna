package com.example.pandas.sql.entity

/**
 * 宠物所处时段，视频如果有多角色，通过名字判断主角
 *  - 1：baby，刚出生
 *  - 2：mom，有妈妈陪伴，大概到1岁半
 *  - 3：group，幼年班，几个小伙伴一起成长
 *  - 4，single，成年，单独一个人
 *  - 5，old，老年
 *  - 6，all,成长记录
 */
enum class PeriodType(val value: String) {

    BABY("大熊猫宝宝"),
    MOM("熊猫母子"),
    GROUP("大熊猫少年班"),
    SINGLE("成年大熊猫"),
    OLD("老年大熊猫"),
    ALL("大熊猫成长记录"),
    KNOWLEDGE("大熊猫百科"),
    CUTE("最萌")
}