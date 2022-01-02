package com.example.pandas.bean.pet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @description: 萌宠
 * @author: dongyiming
 * @date: 1/2/22 6:02 下午
 * @version: v1.0
 */
@Parcelize
public data class CutePet(


    var id: Int? = 0, //宠物身份证，type+id，如 花花 = panda_01
    var name: String? = null,//宠物名字，和花
    var foreignName: String? = null,//外文名
    /**
     *
     * -- 完美解决用逗号分隔存放在一个字段数据  6,16,26,36
     *    select * from tablename where ','+columnname+',' like '%,value,%'
     */
    var nikeName: String? = null,//宠物昵称。分隔符号","来区分
    /**
     * 宠物类型
     *     大熊猫：1
     *     金丝猴：2
     *     老虎：3
     *     北极熊：4
     *     狮子：5
     *     海豹：6
     *     小熊猫：7
     *     狐狸：8
     *
     * @version: v1.0
     */
    var type: Int? = 0,
    var age: Float = 0f, //年龄，自增长
    var sex: String? = null,//性别：male/female
    var birthDate: String? = null,//出生时间
    var birthPlace: String? = null,//出生地
    var currentAdress: String? = null,//现居地
    var headImage: String? = null,//头像地址
    var motherCode: Int? = 0,//妈妈的id
    var fatherCode: Int? = 0//爸爸的id
) : Parcelable