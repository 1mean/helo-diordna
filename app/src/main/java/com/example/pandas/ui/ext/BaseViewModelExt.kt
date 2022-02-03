package com.example.pandas.ui.ext;

import com.example.pandas.base.BaseViewModel
import com.example.pandas.bean.pet.PageCommonData
import com.example.pandas.bean.pet.PetViewData


fun BaseViewModel.getHorVideos(data: PageCommonData): PageCommonData {

    val list = mutableListOf<PetViewData>()
    val pandaUrl = "https://i1.hdslb.com/bfs/archive/e6e38cd16c7050cfbd510b8d44eb2e82919a78f9.jpg"
    val foxUrl = "https://i0.hdslb.com/bfs/archive/c917011116fbe1dda527e580532b639514c47899.jpg"
    val penguinUrl = "https://i1.hdslb.com/bfs/archive/a6cf9cee1d99141c99741c86146e18398c620539.jpg"
    val monkeyUrl = "https://i0.hdslb.com/bfs/archive/6bb9554e8b9615019b4be1e9aa8aef621b1f0588.jpg"
    val birdUrl = "https://i2.hdslb.com/bfs/archive/7e4d79c66f22e8f0565cf2122c2248d95e17a557.jpg"
    val redPandaUrl = "https://i0.hdslb.com/bfs/archive/e7706c050c879e64ebbbeb4c9ae30a7d8518ac1d.png"
    val bearUrl = "https://i2.hdslb.com/bfs/archive/f1242657c843475898357e783da668d4201d78e7.jpg"
    val tigerUrl = "https://i0.hdslb.com/bfs/archive/4b58d5f6a462f534d02fc8d2856fe7e5aece389f.jpg"

    val panda = PetViewData(cover = pandaUrl, title = "大熊猫")
    val fox = PetViewData(cover = foxUrl, title = "狐狸")
    val penguin = PetViewData(cover = penguinUrl, title = "企鹅")
    val monkey = PetViewData(cover = monkeyUrl, title = "金丝猴")
    val bird = PetViewData(cover = birdUrl, title = "白鹭")
    val redPanda = PetViewData(cover = redPandaUrl, title = "小熊猫")
    val bear = PetViewData(cover = bearUrl, title = "北极熊")
    val tiger = PetViewData(cover = tigerUrl, title = "老虎")

    list.apply {
        add(panda)
        add(fox)
        add(penguin)
        add(monkey)
        add(bird)
        add(redPanda)
        add(bear)
        add(tiger)
    }
    data.horizontalVideos = list
    return data
}
