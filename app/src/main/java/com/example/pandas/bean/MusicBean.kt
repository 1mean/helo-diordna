package com.example.pandas.bean

import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.VideoAndUser

data class MusicBean(

    var musicBanners: MutableList<MusicVo> = mutableListOf(),
    var musicItem1: MutableList<MusicVo> = mutableListOf(),
    var musicItem2: MutableList<MusicVo> = mutableListOf(),
    var musicItem3: MutableList<MusicVo> = mutableListOf(),
    var musicItem4: MutableList<MusicVo> = mutableListOf(),
    var musicItem5: MutableList<MusicVo> = mutableListOf(),
    var musicVideos: MutableList<VideoAndUser> = mutableListOf(),
)
