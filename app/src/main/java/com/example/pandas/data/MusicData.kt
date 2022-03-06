package com.example.pandas.data

import com.example.pandas.sql.entity.MusicVo

object MusicData {

    private var list = mutableListOf<MusicVo>()

    fun getMusic(): MutableList<MusicVo> {

        val musicVo_1 = MusicVo()
        musicVo_1.audioName = "八十年代的歌"
        musicVo_1.fileName = "audio_mp3_1"
        musicVo_1.singerName = "赵雷"
        musicVo_1.cover = "https://imge.kugou.com/stdmusic/20200620/20200620111210903931.jpg"
        list.add(musicVo_1)

        val musicVo_2 = MusicVo()
        musicVo_2.audioName = "因为是女子"
        musicVo_2.fileName = "audio_mp3_2"
        musicVo_2.singerName = "Kiss"
        musicVo_2.cover = "https://imge.kugou.com/stdmusic/20181228/20181228103402456336.jpg"
        list.add(musicVo_2)

        val musicVo_3 = MusicVo()
        musicVo_3.audioName = "凤凰花开的路口 (童声版)"
        musicVo_3.fileName = "audio_mp3_3"
        musicVo_3.singerName = "姜小贝"
        musicVo_3.cover = "https://imge.kugou.com/stdmusic/20220118/20220118194808527789.jpg"
        list.add(musicVo_3)

        val musicVo_4 = MusicVo()
        musicVo_4.audioName = "凤凰花开的路口"
        musicVo_4.fileName = "audio_mp3_4"
        musicVo_4.singerName = "林志炫"
        musicVo_4.cover = "https://imge.kugou.com/stdmusic/20150719/20150719014843607872.jpg"
        list.add(musicVo_4)

        val musicVo_5 = MusicVo()
        musicVo_5.audioName = "只要有你"
        musicVo_5.fileName = "audio_mp3_5"
        musicVo_5.singerName = "那英、孙楠"
        musicVo_5.cover = "https://imge.kugou.com/stdmusic/20200927/20200927150712779953.jpg"
        list.add(musicVo_5)

        val musicVo_6 = MusicVo()
        musicVo_6.audioName = "后来 (大合唱版)"
        musicVo_6.fileName = "audio_mp3_6"
        musicVo_6.singerName = "任仕武"
        musicVo_6.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20200619/20200619153409446.jpg"
        list.add(musicVo_6)

        val musicVo_7 = MusicVo()
        musicVo_7.audioName = "风云"
        musicVo_7.fileName = "audio_mp3_7"
        musicVo_7.singerName = "屠洪刚"
        musicVo_7.cover = "https://imge.kugou.com/stdmusic/20160907/20160907185808599300.jpg"
        list.add(musicVo_7)

        val musicVo_8 = MusicVo()
        musicVo_8.audioName = "萱草花 (Live)"
        musicVo_8.fileName = "audio_mp3_8"
        musicVo_8.singerName = "杨坤、杨丞琳、张亚东"
        musicVo_8.cover = "https://imge.kugou.com/stdmusic/20220107/20220107155003347168.jpg"
        list.add(musicVo_8)

        val musicVo_9 = MusicVo()
        musicVo_9.audioName = "仙剑奇缘"
        musicVo_9.fileName = "audio_mp3_9"
        musicVo_9.singerName = "麦振鸿"
        musicVo_9.cover = "https://imge.kugou.com/stdmusic/20200909/20200909114604558242.jpg"
        list.add(musicVo_9)

        val musicVo_10 = MusicVo()
        musicVo_10.audioName = "雪见·落入凡尘"
        musicVo_10.fileName = "audio_mp3_10"
        musicVo_10.singerName = "麦振鸿"
        musicVo_10.cover = "https://imge.kugou.com/stdmusic/20200909/20200909123219737311.jpg"
        list.add(musicVo_10)

        val musicVo_11 = MusicVo()
        musicVo_11.audioName = "Canon_in_D"
        musicVo_11.fileName = "audio_mp3_11"
        musicVo_11.singerName = "Piano King"
        musicVo_11.cover = "https://imge.kugou.com/stdmusic/20200812/20200812102354364183.jpg"
        list.add(musicVo_11)

        val musicVo_12 = MusicVo()
        musicVo_12.audioName = "Romeo And Juliet (罗密欧与朱丽叶)"
        musicVo_12.fileName = "audio_mp3_12"
        musicVo_12.singerName = "Richard Clayderman"
        musicVo_12.cover = "https://imge.kugou.com/stdmusic/20150717/20150717193049283283.jpg"
        list.add(musicVo_12)

        val musicVo_13 = MusicVo()
        musicVo_13.audioName = "我是我的情人"
        musicVo_13.fileName = "audio_mp3_13"
        musicVo_13.singerName = "阿悄"
        musicVo_13.cover = "https://imge.kugou.com/stdmusic/20150717/20150717133541761120.jpg"
        list.add(musicVo_13)

        val musicVo_14 = MusicVo()
        musicVo_14.audioName = "红装"
        musicVo_14.fileName = "audio_mp3_14"
        musicVo_14.singerName = "徐良"
        musicVo_14.cover = "https://imge.kugou.com/stdmusic/20200428/20200428195007452986.jpg"
        list.add(musicVo_14)

        val musicVo_15 = MusicVo()
        musicVo_15.audioName = "你的烂借口"
        musicVo_15.fileName = "audio_mp3_15"
        musicVo_15.singerName = "乔洋"
        musicVo_15.cover = "https://imge.kugou.com/stdmusic/20200909/20200909112829181612.jpg"
        list.add(musicVo_15)

        val musicVo_16 = MusicVo()
        musicVo_16.audioName = "怀念过去"
        musicVo_16.fileName = "audio_mp3_16"
        musicVo_16.singerName = "欢子、沈丹丹"
        musicVo_16.cover = "https://imge.kugou.com/stdmusic/20200909/20200909140549600348.jpg"
        list.add(musicVo_16)

        val musicVo_17 = MusicVo()
        musicVo_17.audioName = "哥只是个传说"
        musicVo_17.fileName = "audio_mp3_17"
        musicVo_17.singerName = "陈旭"
        musicVo_17.cover = "https://imge.kugou.com/stdmusic/20200927/20200927211240304353.jpg"
        list.add(musicVo_17)

        val musicVo_18 = MusicVo()
        musicVo_18.audioName = "快乐崇拜"
        musicVo_18.fileName = "audio_mp3_18"
        musicVo_18.singerName = "潘玮柏、张韶涵"
        musicVo_18.cover = "https://imge.kugou.com/stdmusic/20200927/20200927141420771192.jpg"
        list.add(musicVo_18)

        val musicVo_19 = MusicVo()
        musicVo_19.audioName = "爱我就跟我走"
        musicVo_19.fileName = "audio_mp3_19"
        musicVo_19.singerName = "王鹤铮"
        musicVo_19.cover = "https://imge.kugou.com/stdmusic/20200909/20200909143113537322.jpg"
        list.add(musicVo_19)

        val musicVo_20 = MusicVo()
        musicVo_20.audioName = "放生"
        musicVo_20.fileName = "audio_mp3_20"
        musicVo_20.singerName = "范逸臣"
        musicVo_20.cover = "https://imge.kugou.com/stdmusic/20170731/20170731155506994245.jpg"
        list.add(musicVo_20)

        val musicVo_21 = MusicVo()
        musicVo_21.audioName = "为爱停留"
        musicVo_21.fileName = "audio_mp3_21"
        musicVo_21.singerName = "郑源"
        musicVo_21.cover = "https://imge.kugou.com/stdmusic/20200923/20200923155314964141.jpg"
        list.add(musicVo_21)

        val musicVo_22 = MusicVo()
        musicVo_22.audioName = "酸酸甜甜就是我"
        musicVo_22.fileName = "audio_mp3_22"
        musicVo_22.singerName = "张含韵"
        musicVo_22.cover = "https://imge.kugou.com/stdmusic/20200922/20200922123216563863.jpg"
        list.add(musicVo_22)

        val musicVo_23 = MusicVo()
        musicVo_23.audioName = "不怕不怕 (Original Radio Remix)"
        musicVo_23.fileName = "audio_mp3_23"
        musicVo_23.singerName = "郭美美"
        musicVo_23.cover = "https://imge.kugou.com/stdmusic/20201125/20201125094018914394.jpg"
        list.add(musicVo_23)

        val musicVo_24 = MusicVo()
        musicVo_24.audioName = "秋天不回来"
        musicVo_24.fileName = "audio_mp3_24"
        musicVo_24.singerName = "王强"
        musicVo_24.cover = "https://imge.kugou.com/stdmusic/20200909/20200909111329739124.jpg"
        list.add(musicVo_24)

        val musicVo_25 = MusicVo()
        musicVo_25.audioName = "一万个理由"
        musicVo_25.fileName = "audio_mp3_25"
        musicVo_25.singerName = "郑源"
        musicVo_25.cover = "https://imge.kugou.com/stdmusic/20150720/20150720183315129832.jpg"
        list.add(musicVo_25)

        val musicVo_26 = MusicVo()
        musicVo_26.audioName = "玫瑰花的葬礼"
        musicVo_26.fileName = "audio_mp3_26"
        musicVo_26.singerName = "许嵩"
        musicVo_26.cover = "https://imge.kugou.com/stdmusic/20190924/20190924195702432753.jpg"
        list.add(musicVo_26)

        val musicVo_27 = MusicVo()
        musicVo_27.audioName = "老人与海"
        musicVo_27.fileName = "audio_mp3_27"
        musicVo_27.singerName = "海鸣威、吴琼"
        musicVo_27.cover = "https://imge.kugou.com/stdmusic/20200909/20200909112215111862.jpg"
        list.add(musicVo_27)

        val musicVo_28 = MusicVo()
        musicVo_28.audioName = "该死的温柔"
        musicVo_28.fileName = "audio_mp3_28"
        musicVo_28.singerName = "马天宇"
        musicVo_28.cover = "https://imge.kugou.com/stdmusic/20150718/20150718213709895570.jpg"
        list.add(musicVo_28)

        val musicVo_29 = MusicVo()
        musicVo_29.audioName = "화신 (花信)"
        musicVo_29.fileName = "audio_mp3_29"
        musicVo_29.singerName = "朴孝信"
        musicVo_29.cover = "https://imge.kugou.com/stdmusic/20150718/20150718123017978688.jpg"
        list.add(musicVo_29)

        val musicVo_30 = MusicVo()
        musicVo_30.audioName = "雪之花"
        musicVo_30.fileName = "audio_mp3_30"
        musicVo_30.singerName = "朴孝信"
        musicVo_30.cover = "https://imge.kugou.com/stdmusic/20210111/20210111163338987013.jpg"
        list.add(musicVo_30)

        val musicVo_31 = MusicVo()
        musicVo_31.audioName = "从开始到现在"
        musicVo_31.fileName = "audio_mp3_31"
        musicVo_31.singerName = "Ryu"
        musicVo_31.cover = "https://imge.kugou.com/stdmusic/20160914/20160914120311733137.jpg"
        list.add(musicVo_31)

        val musicVo_32 = MusicVo()
        musicVo_32.audioName = "爱上鲨鱼的人鱼"
        musicVo_32.fileName = "audio_mp3_32"
        musicVo_32.singerName = "殆死悲爱"
        musicVo_32.cover = "https://imge.kugou.com/stdmusic/20200909/20200909124302893668.jpg"
        list.add(musicVo_32)

        val musicVo_33 = MusicVo()
        musicVo_33.audioName = "Never Say Goodbye"
        musicVo_33.fileName = "audio_mp3_33"
        musicVo_33.singerName = "Mario & Nasty"
        musicVo_33.cover = "https://imge.kugou.com/stdmusic/20200909/20200909122042910108.jpg"
        list.add(musicVo_33)

        val musicVo_34 = MusicVo()
        musicVo_34.audioName = "比离别更大的悲伤"
        musicVo_34.fileName = "audio_mp3_34"
        musicVo_34.singerName = "김완선"
        musicVo_34.cover = "https://imge.kugou.com/stdmusic/20190320/20190320090228249021.jpg"
        list.add(musicVo_34)

        val musicVo_35 = MusicVo()
        musicVo_35.audioName = "许愿池的希腊少女"
        musicVo_35.fileName = "audio_mp3_35"
        musicVo_35.singerName = "蔡依林"
        musicVo_35.cover = "https://imge.kugou.com/stdmusic/20170731/20170731143426162414.jpg"
        list.add(musicVo_35)

        val musicVo_36 = MusicVo()
        musicVo_36.audioName = "黄昏晓"
        musicVo_36.fileName = "audio_mp3_36"
        musicVo_36.singerName = "王心凌"
        musicVo_36.cover = "https://imge.kugou.com/stdmusic/20160909/20160909034750909439.jpg"
        list.add(musicVo_36)

        val musicVo_37 = MusicVo()
        musicVo_37.audioName = "羽毛"
        musicVo_37.fileName = "audio_mp3_37"
        musicVo_37.singerName = "王心凌"
        musicVo_37.cover = "https://imge.kugou.com/stdmusic/20150715/20150715193840591496.jpg"
        list.add(musicVo_37)

        val musicVo_38 = MusicVo()
        musicVo_38.audioName = "Hihi Byebye"
        musicVo_38.fileName = "audio_mp3_38"
        musicVo_38.singerName = "王心凌"
        musicVo_38.cover = "https://imge.kugou.com/stdmusic/20150717/20150717114031374000.jpg"
        list.add(musicVo_38)

        val musicVo_39 = MusicVo()
        musicVo_39.audioName = "下一页的我"
        musicVo_39.fileName = "audio_mp3_39"
        musicVo_39.singerName = "王心凌"
        musicVo_39.cover = "https://imge.kugou.com/stdmusic/20200620/20200620100621836773.jpg"
        list.add(musicVo_39)

        val musicVo_40 = MusicVo()
        musicVo_40.audioName = "月光"
        musicVo_40.fileName = "audio_mp3_40"
        musicVo_40.singerName = "王心凌"
        musicVo_40.cover = "https://imge.kugou.com/stdmusic/20150717/20150717114031374000.jpg"
        list.add(musicVo_40)

        val musicVo_41 = MusicVo()
        musicVo_41.audioName = "爱的天国"
        musicVo_41.fileName = "audio_mp3_41"
        musicVo_41.singerName = "王心凌"
        musicVo_41.cover = "https://imge.kugou.com/stdmusic/20160908/20160908103943877421.jpg"
        list.add(musicVo_41)

        val musicVo_42 = MusicVo()
        musicVo_42.audioName = "花的嫁纱"
        musicVo_42.fileName = "audio_mp3_42"
        musicVo_42.singerName = "王心凌"
        musicVo_42.cover = "https://imge.kugou.com/stdmusic/20200918/20200918205601673529.jpg"
        list.add(musicVo_42)

        val musicVo_43 = MusicVo()
        musicVo_43.audioName = "还是好朋友"
        musicVo_43.fileName = "audio_mp3_43"
        musicVo_43.singerName = "王心凌"
        musicVo_43.cover = "https://imge.kugou.com/stdmusic/20150718/20150718141332688567.jpg"
        list.add(musicVo_43)

        val musicVo_44 = MusicVo()
        musicVo_44.audioName = "越长大越孤单"
        musicVo_44.fileName = "audio_mp3_44"
        musicVo_44.singerName = "牛奶咖啡"
        musicVo_44.cover = "https://imge.kugou.com/stdmusic/20200812/20200812175031850500.jpg"
        list.add(musicVo_44)

        val musicVo_45 = MusicVo()
        musicVo_45.audioName = "笑看风云"
        musicVo_45.fileName = "audio_mp3_45"
        musicVo_45.singerName = "童珺"
        musicVo_45.cover = "https://imge.kugou.com/stdmusic/20191029/20191029211156651593.jpg"
        list.add(musicVo_45)

        val musicVo_46 = MusicVo()
        musicVo_46.audioName = "Sayonala"
        musicVo_46.fileName = "audio_mp3_46"
        musicVo_46.singerName = "김완선"
        musicVo_46.cover = "https://imge.kugou.com/stdmusic/20150718/20150718145620209412.jpg"
        list.add(musicVo_46)

        val musicVo_47 = MusicVo()
        musicVo_47.audioName = "恰似你的温柔"
        musicVo_47.fileName = "audio_mp3_47"
        musicVo_47.singerName = "蔡琴"
        musicVo_47.cover = "https://imge.kugou.com/stdmusic/20191230/20191230093604982979.jpg"
        list.add(musicVo_47)

        val musicVo_48 = MusicVo()
        musicVo_48.audioName = "美丽女人"
        musicVo_48.fileName = "audio_mp3_48"
        musicVo_48.singerName = "程响"
        musicVo_48.cover = "https://imge.kugou.com/stdmusic/20200301/20200301222813392764.jpg"
        list.add(musicVo_48)

        val musicVo_49 = MusicVo()
        musicVo_49.audioName = "左边"
        musicVo_49.fileName = "audio_mp3_49"
        musicVo_49.singerName = "杨丞琳"
        musicVo_49.cover = "https://imge.kugou.com/stdmusic/20200927/20200927143828761368.jpg"
        list.add(musicVo_49)

        val musicVo_50 = MusicVo()
        musicVo_50.audioName = "飘摇"
        musicVo_50.fileName = "audio_mp3_50"
        musicVo_50.singerName = "周迅"
        musicVo_50.cover = "https://imge.kugou.com/stdmusic/20200909/20200909115946244353.jpg"
        list.add(musicVo_50)

        val musicVo_51 = MusicVo()
        musicVo_51.audioName = "我们的纪念日"
        musicVo_51.fileName = "audio_mp3_51"
        musicVo_51.singerName = "范玮琪"
        musicVo_51.cover = "https://imge.kugou.com/stdmusic/20170727/20170727160932579471.jpg"
        list.add(musicVo_51)

        val musicVo_52 = MusicVo()
        musicVo_52.audioName = "暧昧"
        musicVo_52.fileName = "audio_mp3_52"
        musicVo_52.singerName = "杨丞琳"
        musicVo_52.cover = "https://imge.kugou.com/stdmusic/20201125/20201125125558975632.jpg"
        list.add(musicVo_52)

        val musicVo_53 = MusicVo()
        musicVo_53.audioName = "金枝欲孽 笛子二重奏"
        musicVo_53.fileName = "audio_mp3_53"
        musicVo_53.singerName = "陈宝硕"
        musicVo_53.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20141126/20141126161009815150.jpg"
        list.add(musicVo_53)

        val musicVo_54 = MusicVo()
        musicVo_54.audioName = "I Believe (我相信)"
        musicVo_54.fileName = "audio_mp3_54"
        musicVo_54.singerName = "申胜勋"
        musicVo_54.cover = "https://imgessl.kugou.com/commendpic/20160923/20160923162707215688.png"
        list.add(musicVo_54)

        val musicVo_55 = MusicVo()
        musicVo_55.audioName = "My Destiny (我的命运)"
        musicVo_55.fileName = "audio_mp3_55"
        musicVo_55.singerName = "LYn"
        musicVo_55.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        list.add(musicVo_55)

        val musicVo_56 = MusicVo()
        musicVo_56.audioName = "별에서 온 그대 (来自星星的你)"
        musicVo_56.fileName = "audio_mp3_56"
        musicVo_56.singerName = "윤하 (YOUNHA)"
        musicVo_56.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        list.add(musicVo_56)

        val musicVo_57 = MusicVo()
        musicVo_57.audioName = "안녕 (再见)"
        musicVo_57.fileName = "audio_mp3_57"
        musicVo_57.singerName = "孝琳"
        musicVo_57.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        list.add(musicVo_57)

        val musicVo_58 = MusicVo()
        musicVo_58.audioName = "너의 집 앞"
        musicVo_58.fileName = "audio_mp3_58"
        musicVo_58.singerName = "金秀贤"
        musicVo_58.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        list.add(musicVo_58)

        val musicVo_59 = MusicVo()
        musicVo_59.audioName = "我悄悄的蒙上你的眼睛"
        musicVo_59.fileName = "audio_mp3_59"
        musicVo_59.singerName = "高明骏"
        musicVo_59.cover = "https://imge.kugou.com/stdmusic/20200909/20200909121638734521.jpg"
        list.add(musicVo_59)

        val musicVo_60 = MusicVo()
        musicVo_60.audioName = "美丽的神话"
        musicVo_60.fileName = "audio_mp3_60"
        musicVo_60.singerName = "成龙、金喜善"
        musicVo_60.cover = "https://imge.kugou.com/stdmusic/20200609/20200609221608205335.jpg"
        list.add(musicVo_60)

        val musicVo_61 = MusicVo()
        musicVo_61.audioName = "道は続く"
        musicVo_61.fileName = "audio_mp3_61"
        musicVo_61.singerName = "高梨康治、刃-yaiba-"
        musicVo_61.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        list.add(musicVo_61)

        val musicVo_62 = MusicVo()
        musicVo_62.audioName = "落葉船 (落叶船)"
        musicVo_62.fileName = "audio_mp3_62"
        musicVo_62.singerName = "高梨康治、刃-yaiba-"
        musicVo_62.cover = "https://imge.kugou.com/stdmusic/20210908/20210908160501374347.jpg"
        list.add(musicVo_62)

        val musicVo_63 = MusicVo()
        musicVo_63.audioName = "消愁 (DJ女生版)"
        musicVo_63.fileName = "audio_mp3_63"
        musicVo_63.singerName = "新旭"
        musicVo_63.cover = "https://imge.kugou.com/stdmusic/20200110/20200110193426510352.jpg"
        list.add(musicVo_63)

        val musicVo_64 = MusicVo()
        musicVo_64.audioName = "一人晚餐"
        musicVo_64.fileName = "audio_mp3_64"
        musicVo_64.singerName = "钟嘉欣"
        musicVo_64.cover = "https://imge.kugou.com/stdmusic/20150718/20150718171946246764.jpg"
        list.add(musicVo_64)

        val musicVo_65 = MusicVo()
        musicVo_65.audioName = "左手指月 (Live)"
        musicVo_65.fileName = "audio_mp3_65"
        musicVo_65.singerName = "萨顶顶"
        musicVo_65.cover = "https://imge.kugou.com/stdmusic/20200328/20200328204648554453.jpg"
        list.add(musicVo_65)

        val musicVo_66 = MusicVo()
        musicVo_66.audioName = "冰河想妈妈"
        musicVo_66.fileName = "audio_mp3_66"
        musicVo_66.singerName = "纯音乐"
        musicVo_66.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20130531/20130531162457903.jpg"
        list.add(musicVo_66)

        val musicVo_67 = MusicVo()
        musicVo_67.audioName = "Ballade Pour Adeline (水边的阿狄丽娜)"
        musicVo_67.fileName = "audio_mp3_67"
        musicVo_67.singerName = "Richard Clayderman"
        musicVo_67.cover = "https://imge.kugou.com/stdmusic/20201229/20201229152914202525.jpg"
        list.add(musicVo_67)

        val musicVo_68 = MusicVo()
        musicVo_68.audioName = "菩提一棵树 (纯音乐)"
        musicVo_68.fileName = "audio_mp3_68"
        musicVo_68.singerName = "安敏捷、老五"
        musicVo_68.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20141230/20141230222726130605.jpg"
        list.add(musicVo_68)

        val musicVo_69 = MusicVo()
        musicVo_69.audioName = "国际歌"
        musicVo_69.fileName = "audio_mp3_69"
        musicVo_69.singerName = "唐朝"
        musicVo_69.cover = "https://imge.kugou.com/stdmusic/20160907/20160907222022997743.jpg"
        list.add(musicVo_69)

        val musicVo_70 = MusicVo()
        musicVo_70.audioName = "想唱就唱"
        musicVo_70.fileName = "audio_mp3_70"
        musicVo_70.singerName = "张含韵"
        musicVo_70.cover = "https://imge.kugou.com/stdmusic/20200812/20200812173142288672.jpg"
        list.add(musicVo_70)

        val musicVo_71 = MusicVo()
        musicVo_71.audioName = "三年的赌注"
        musicVo_71.fileName = "audio_mp3_71"
        musicVo_71.singerName = "广东余丰"
        musicVo_71.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20210705/20210705115801622901.jpg"
        list.add(musicVo_71)

        val musicVo_72 = MusicVo()
        musicVo_72.audioName = "好人一生平安"
        musicVo_72.fileName = "audio_mp3_72"
        musicVo_72.singerName = "李娜"
        musicVo_72.cover = "https://imge.kugou.com/stdmusic/20210120/20210120141338535340.jpg"
        list.add(musicVo_72)

        val musicVo_73 = MusicVo()
        musicVo_73.audioName = "一个人的浪漫 (钢琴曲)"
        musicVo_73.fileName = "audio_mp3_73"
        musicVo_73.singerName = "耿子涵"
        musicVo_73.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20181024/20181024120239327.jpg"
        list.add(musicVo_73)

        val musicVo_74 = MusicVo()
        musicVo_74.audioName = "Rain"
        musicVo_74.fileName = "audio_mp3_74"
        musicVo_74.singerName = "坂本龍一"
        musicVo_74.cover = "https://imge.kugou.com/stdmusic/20161126/20161126190219332168.jpg"
        list.add(musicVo_74)

        val musicVo_75 = MusicVo()
        musicVo_75.audioName = "浪漫卡农"
        musicVo_75.fileName = "audio_mp3_75"
        musicVo_75.singerName = "贵族乐团"
        musicVo_75.cover = "https://imge.kugou.com/stdmusic/20160908/20160908054600767363.jpg"
        list.add(musicVo_75)

        val musicVo_76 = MusicVo()
        musicVo_76.audioName = "五百年桑田沧海"
        musicVo_76.fileName = "audio_mp3_76"
        musicVo_76.singerName = "伍国忠"
        musicVo_76.cover = "https://imge.kugou.com/stdmusic/20200909/20200909134154818398.jpg"
        list.add(musicVo_76)

        val musicVo_77 = MusicVo()
        musicVo_77.audioName = "乔克叔叔"
        musicVo_77.fileName = "audio_mp3_77"
        musicVo_77.singerName = "周杰伦"
        musicVo_77.cover = "https://imge.kugou.com/stdmusic/20200909/20200909135350181905.jpg"
        list.add(musicVo_77)

        val musicVo_78 = MusicVo()
        musicVo_78.audioName = "奉献2016"
        musicVo_78.fileName = "audio_mp3_78"
        musicVo_78.singerName = "Vitas"
        musicVo_78.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20210726/20210726182752410.jpg"
        list.add(musicVo_78)

        val musicVo_79 = MusicVo()
        musicVo_79.audioName = "步步惊心配乐"
        musicVo_79.fileName = "audio_mp3_79"
        musicVo_79.singerName = "纯音乐"
        musicVo_79.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20130531/20130531162457903.jpg"
        list.add(musicVo_79)

        val musicVo_80 = MusicVo()
        musicVo_80.audioName = "カスカベ防衛隊の夜 (春日部防卫队之夜)"
        musicVo_80.fileName = "audio_mp3_80"
        musicVo_80.singerName = "荒川敏行"
        musicVo_80.cover = "https://imge.kugou.com/stdmusic/20200909/20200909105532954172.jpg"
        list.add(musicVo_80)

        return list
    }

}