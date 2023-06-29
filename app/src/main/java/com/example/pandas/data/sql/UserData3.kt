package com.example.pandas.data.sql

import com.example.pandas.sql.entity.User

object UserData3 {

    private val list = mutableListOf<User>()

    fun getAll(): MutableList<User> {

        val user646 = User()
        user646.userCode = 36468959
        user646.sex = 0
        user646.level = 6
        user646.headUrl =
            "https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-i-0813c001_bebdad79866b40bc8eca689fc11f44d1~c5_300x300.jpeg?from=2956013662"
        user646.userName = "萌宠摇摇乐"
        list.add(user646)

        val user647 = User()
        user647.userCode = 36468960
        user647.sex = 0
        user647.level = 6
        user647.headUrl =
            "https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c56daa1d3dd0b34188f0690b0f049992~c5_300x300.jpeg?from=2956013662"
        user647.userName = "🌈是我瑶妹呀😘"
        list.add(user647)










        return list
    }
}