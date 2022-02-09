package com.example.pandas.data

import com.example.pandas.sql.entity.MusicVo

object MusicData {

    private var list = mutableListOf<MusicVo>()

    fun getMusic(): MutableList<MusicVo> {

        val musicVo_1 = MusicVo()
        musicVo_1.audioName = "仰望"
        musicVo_1.singerName = "谢雨欣"
        musicVo_1.cover = "https://imge.kugou.com/stdmusic/20160908/20160908052907408931.jpg"
        musicVo_1.url =
            "https://webfs.ali.kugou.com/202201301855/8f08fecead15fb6d20a81b081789271b/KGTX/CLTX001/c990a95fac8e93c7fdf46c33644d11bd.mp3"
        list.add(musicVo_1)

        val musicVo_2 = MusicVo()
        musicVo_2.audioName = "只要有你"
        musicVo_2.singerName = "那英、孙楠"
        musicVo_2.cover = "https://imge.kugou.com/stdmusic/20200927/20200927150712779953.jpg"
        musicVo_2.url =
            "https://webfs.ali.kugou.com/202201301858/c6640a76f0beaa9ba234f57d72a39522/G192/M0B/1A/09/oJQEAF5y2i6AXdVJAD2_18ROfJk635.mp3"
        list.add(musicVo_2)

        val musicVo_3 = MusicVo()
        musicVo_3.audioName = "寂寞在唱歌"
        musicVo_3.singerName = "阿桑"
        musicVo_3.cover = "https://imge.kugou.com/stdmusic/20200909/20200909123221314919.jpg"
        musicVo_3.url =
            "https://webfs.ali.kugou.com/202201301901/4405264cd63db8f24adac549cbfa0292/G142/M05/19/08/bpQEAFuXPbGAaWcMAEG9j9Iu81w900.mp3"
        list.add(musicVo_3)

        val musicVo_4 = MusicVo()
        musicVo_4.audioName = "后来 (大合唱版)"
        musicVo_4.singerName = "任仕武"
        musicVo_4.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20200619/20200619153409446.jpg"
        musicVo_4.url =
            "https://webfs.ali.kugou.com/202201301902/3a706610b50f4be16bc2d956ad5f2b23/G131/M04/0C/05/Y5QEAFrmRiCAF1PcADZNTg3sAkY792.mp3"
        list.add(musicVo_4)

        val musicVo_5 = MusicVo()
        musicVo_5.audioName = "渡口"
        musicVo_5.singerName = "蔡琴"
        musicVo_5.cover = "https://imge.kugou.com/stdmusic/20150720/20150720192824785603.jpg"
        musicVo_5.url =
            "https://webfs.ali.kugou.com/202201301903/2dfee994c089ac6a6361622f12ab204c/KGTX/CLTX001/0e9a68dab665765ea214ecbc6131b4e5.mp3"
        list.add(musicVo_5)

        val musicVo_6 = MusicVo()
        musicVo_6.audioName = "风云"
        musicVo_6.singerName = "屠洪刚"
        musicVo_6.cover = "https://imge.kugou.com/stdmusic/20160907/20160907185808599300.jpg"
        musicVo_6.url =
            "https://webfs.ali.kugou.com/202201301903/12fee14d265961164a19e48db6d572ff/KGTX/CLTX001/0faf44c7c021c0bf4b7a33eeb98e2c70.mp3"
        list.add(musicVo_6)

        val musicVo_7 = MusicVo()
        musicVo_7.audioName = "水中花"
        musicVo_7.singerName = "蔡幸娟"
        musicVo_7.cover = "https://imge.kugou.com/stdmusic/20180611/20180611111315107863.jpg"
        musicVo_7.url =
            "https://webfs.ali.kugou.com/202201301904/d4a23a303c3e24d89290b3a3940dde1c/KGTX/CLTX001/e2405a77b71917678eef2428ccf12d54.mp3"
        list.add(musicVo_7)

        val musicVo_9 = MusicVo()
        musicVo_9.audioName = "大风吹 (Live)"
        musicVo_9.singerName = "刘惜君、王赫野"
        musicVo_9.cover = "https://imge.kugou.com/stdmusic/20210402/20210402165154822647.jpg"
        musicVo_9.url =
            "https://webfs.ali.kugou.com/202201301904/c6297010fd2ec22cd0ddb758fff54203/KGTX/CLTX001/d933554d46f08a59eb7961cf3160bd04.mp3"
        list.add(musicVo_9)

        val musicVo_10 = MusicVo()
        musicVo_10.audioName = "再回首 (Live)"
        musicVo_10.singerName = "姜育恒"
        musicVo_10.cover = "https://imge.kugou.com/stdmusic/20210722/20210722142602603030.jpg"
        musicVo_10.url =
            "https://webfs.ali.kugou.com/202201301904/4265aff17bbe6977274dfefd937f40f4/KGTX/CLTX001/e3c16801dac78898301e9c1b433789ef.mp3"
        list.add(musicVo_10)

        val musicVo_11 = MusicVo()
        musicVo_11.audioName = "萱草花 (Live)"
        musicVo_11.singerName = "杨坤、杨丞琳、张亚东"
        musicVo_11.cover = "https://imge.kugou.com/stdmusic/20220107/20220107155003347168.jpg"
        musicVo_11.url =
            "https://webfs.ali.kugou.com/202201301904/4b7a9aa83ba540693c6776142e13e254/KGTX/CLTX001/1004ad3c6e9dfd372593184f5b6a2e4b.mp3"
        list.add(musicVo_11)

        val musicVo_12 = MusicVo()
        musicVo_12.audioName = "不忘初心 (Live)"
        musicVo_12.singerName = "蔡国庆、成方圆、阿兰、蔡程昱、刘彬濠、孙美琪"
        musicVo_12.cover = "https://imge.kugou.com/stdmusic/20210701/20210701174803610132.jpg"
        musicVo_12.url =
            "https://webfs.ali.kugou.com/202201301905/8c841d4f63238d5cd3e5b06f90494beb/KGTX/CLTX001/476a32e33ee230a47334dcc21074bbbb.mp3"
        list.add(musicVo_12)

        val musicVo_13 = MusicVo()
        musicVo_13.audioName = "仙剑奇缘"
        musicVo_13.singerName = "麦振鸿"
        musicVo_13.cover = "https://imge.kugou.com/stdmusic/20200909/20200909114604558242.jpg"
        musicVo_13.url =
            "https://webfs.ali.kugou.com/202201301905/882e2887aaf65f1a9a75cddb0f5201a0/KGTX/CLTX001/ab9d8d80ea1662a9a3b829e9d7c0d921.mp3"
        list.add(musicVo_13)

        val musicVo_14 = MusicVo()
        musicVo_14.audioName = "雪见·落入凡尘"
        musicVo_14.singerName = "麦振鸿"
        musicVo_14.cover = "https://imge.kugou.com/stdmusic/20200909/20200909123219737311.jpg"
        musicVo_14.url =
            "https://webfs.ali.kugou.com/202201301905/a4b76fc8bfe238c25ee9e2b44bc7a9e2/G200/M02/1A/1B/CA4DAF5uIIGAAIIjAEbGWw9QftE797.mp3"
        list.add(musicVo_14)

        val musicVo_15 = MusicVo()
        musicVo_15.audioName = "静夜如梦"
        musicVo_15.singerName = "赵海洋"
        musicVo_15.cover = "https://imge.kugou.com/stdmusic/20170507/20170507115833669586.jpg"
        musicVo_15.url =
            "https://webfs.ali.kugou.com/202201301905/74016105eacb751d8a43a4c4f81beda9/KGTX/CLTX001/49ee18a59fd44b2dc44fcbefe41e2120.mp3   "
        list.add(musicVo_15)

        val musicVo_16 = MusicVo()
        musicVo_16.audioName = "Canon in D"
        musicVo_16.singerName = "Piano King"
        musicVo_16.cover = "https://imge.kugou.com/stdmusic/20200812/20200812102354364183.jpg"
        musicVo_16.url =
            "https://webfs.ali.kugou.com/202201301906/1d0cab292a71e64111b70bde860eda35/G170/M08/07/07/SocBAF1uaR2AEoB4AD97IX6MMoI254.mp3"
        list.add(musicVo_16)

        val musicVo_17 = MusicVo()
        musicVo_17.audioName = "Romeo And Juliet (罗密欧与朱丽叶)"
        musicVo_17.singerName = "Richard Clayderman"
        musicVo_17.cover = "https://imge.kugou.com/stdmusic/20150717/20150717193049283283.jpg"
        musicVo_17.url =
            "https://webfs.ali.kugou.com/202201301906/a68447dbb0d5d0e06d557e25ac5873dc/G136/M09/1F/13/KIcBAFuIK9KAGQ_cACL92a1NuqU949.mp3"
        list.add(musicVo_17)

        val musicVo_18 = MusicVo()
        musicVo_18.audioName = "我们都一样 (Live)"
        musicVo_18.singerName = "张杰"
        musicVo_18.cover = "https://imge.kugou.com/stdmusic/20190116/20190116013137318831.jpg"
        musicVo_18.url =
            "https://webfs.ali.kugou.com/202201301907/0e8f90a289dd90c4e67936a4c78592a4/G097/M03/0E/01/QZQEAFw-liGAHH2hAFN2q9imWnc772.mp3"
        list.add(musicVo_18)

        val musicVo_19 = MusicVo()
        musicVo_19.audioName = "脚本"
        musicVo_19.singerName = "王力宏"
        musicVo_19.cover = "https://imge.kugou.com/stdmusic/20160416/20160416103212186636.jpg"
        musicVo_19.url =
            "https://webfs.ali.kugou.com/202201301907/e912ffe1ae21653e079c74d72ec0a91e/KGTX/CLTX001/6706c758edc2b29089795fe503497281.mp3"
        list.add(musicVo_19)

        val musicVo_20 = MusicVo()
        musicVo_20.audioName = "倾尽温柔"
        musicVo_20.singerName = "本兮、阿悄"
        musicVo_20.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20210816/20210816234430980608.jpg"
        musicVo_20.url =
            "https://webfs.ali.kugou.com/202201301907/5e9e297919aa3bfa171907290a19c5bb/KGTX/CLTX001/2b4ed019cbe92e2ca8f9dd7ebccc0dac.mp3"
        list.add(musicVo_20)

        val musicVo_21 = MusicVo()
        musicVo_21.audioName = "我是我的情人"
        musicVo_21.singerName = "阿悄"
        musicVo_21.cover = "https://imge.kugou.com/stdmusic/20150717/20150717133541761120.jpg"
        musicVo_21.url =
            "https://webfs.ali.kugou.com/202201301908/d9c66ddd7bd0a9d41f3e5f0aa3a6f4a5/KGTX/CLTX001/04528a0c289b50564ba8dd9dac3db552.mp3"
        list.add(musicVo_21)

        val musicVo_22 = MusicVo()
        musicVo_22.audioName = "红装"
        musicVo_22.singerName = "徐良"
        musicVo_22.cover = "https://imge.kugou.com/stdmusic/20200428/20200428195007452986.jpg"
        musicVo_22.url =
            "https://webfs.ali.kugou.com/202201301908/425ddc2d011c9d3460ea9311b81760e3/KGTX/CLTX001/02680a6be748445ff7b72176befbdcca.mp3"
        list.add(musicVo_22)

        val musicVo_23 = MusicVo()
        musicVo_23.audioName = "你的烂借口"
        musicVo_23.singerName = "乔洋"
        musicVo_23.cover = "https://imge.kugou.com/stdmusic/20200909/20200909112829181612.jpg"
        musicVo_23.url =
            "https://webfs.ali.kugou.com/202201301908/d74df93c722a054eed2030db2d259fc4/KGTX/CLTX001/c50b74595b783310e61f1d462a6876c4.mp3"
        list.add(musicVo_23)

        val musicVo_24 = MusicVo()
        musicVo_24.audioName = "怀念过去"
        musicVo_24.singerName = "欢子、沈丹丹"
        musicVo_24.cover = "https://imge.kugou.com/stdmusic/20200909/20200909140549600348.jpg"
        musicVo_24.url =
            "https://webfs.ali.kugou.com/202201301909/b29be1ac10ceb07121f00d6f54c11e2f/KGTX/CLTX001/bd945029458cbe1c6ebd8e277c391db7.mp3"
        list.add(musicVo_24)

        val musicVo_25 = MusicVo()
        musicVo_25.audioName = "哥只是个传说"
        musicVo_25.singerName = "陈旭"
        musicVo_25.cover = "https://imge.kugou.com/stdmusic/20200927/20200927211240304353.jpg"
        musicVo_25.url =
            "https://webfs.ali.kugou.com/202201301909/a59252b68ae9a71e3b6e9d90730cdda7/KGTX/CLTX001/a107d07a1216238a10eea831a65cf782.mp3"
        list.add(musicVo_25)

        val musicVo_26 = MusicVo()
        musicVo_26.audioName = "快乐崇拜"
        musicVo_26.singerName = "潘玮柏、张韶涵"
        musicVo_26.cover = "https://imge.kugou.com/stdmusic/20200927/20200927141420771192.jpg"
        musicVo_26.url =
            "https://webfs.ali.kugou.com/202201301909/2913f51e5d9663e95d0f04d7c8dea412/KGTX/CLTX001/28da3701d8ffc84bc817cbe92e03f859.mp3"
        list.add(musicVo_26)

        val musicVo_27 = MusicVo()
        musicVo_27.audioName = "爱我就跟我走"
        musicVo_27.singerName = "王鹤铮"
        musicVo_27.cover = "https://imge.kugou.com/stdmusic/20200909/20200909143113537322.jpg"
        musicVo_27.url =
            "https://webfs.ali.kugou.com/202201301909/0431a90b5307a7f7e43859a177e91c41/G201/M0A/15/1D/qZQEAF5uv6qARkBOAEKBbsxbQQs831.mp3"
        list.add(musicVo_27)

        val musicVo_28 = MusicVo()
        musicVo_28.audioName = "放生"
        musicVo_28.singerName = "范逸臣"
        musicVo_28.cover = "https://imge.kugou.com/stdmusic/20170731/20170731155506994245.jpg"
        musicVo_28.url =
            "https://webfs.ali.kugou.com/202201301909/0eb12d42e44446f2a078d814db80127c/G240/M03/1F/0F/kIcBAF-iFu6Ae2EOAEKxbdE6I30321.mp3"
        list.add(musicVo_28)

        val musicVo_29 = MusicVo()
        musicVo_29.audioName = "为爱停留"
        musicVo_29.singerName = "郑源"
        musicVo_29.cover = "https://imge.kugou.com/stdmusic/20200923/20200923155314964141.jpg"
        musicVo_29.url =
            "https://webfs.ali.kugou.com/202201301910/96767d3e979c81c87735124171178cd7/KGTX/CLTX001/4f58dd8f8988da025088739fd2495d6b.mp3"
        list.add(musicVo_29)

        val musicVo_30 = MusicVo()
        musicVo_30.audioName = "酸酸甜甜就是我"
        musicVo_30.singerName = "张含韵"
        musicVo_30.cover = "https://imge.kugou.com/stdmusic/20200922/20200922123216563863.jpg"
        musicVo_30.url =
            "https://webfs.ali.kugou.com/202201301910/c23f2be304e33ba83715b4a89916d75e/G138/M01/04/05/yg0DAFuJYsyAXpOuADSvutUQLbk035.mp3"
        list.add(musicVo_30)

        val musicVo_31 = MusicVo()
        musicVo_31.audioName = "不怕不怕 (Original Radio Remix)"
        musicVo_31.singerName = "郭美美"
        musicVo_31.cover = "https://imge.kugou.com/stdmusic/20201125/20201125094018914394.jpg"
        musicVo_31.url =
            "https://webfs.ali.kugou.com/202201301910/86303363f0d19ad23b7693c1eab7993e/KGTX/CLTX001/078aba096d0aea355842f0b304ead0e4.mp3"
        list.add(musicVo_31)

        val musicVo_32 = MusicVo()
        musicVo_32.audioName = "秋天不回来"
        musicVo_32.singerName = "王强"
        musicVo_32.cover = "https://imge.kugou.com/stdmusic/20200909/20200909111329739124.jpg"
        musicVo_32.url =
            "https://webfs.ali.kugou.com/202201301910/00b94fc8426ec9e5a584aab562b81763/G193/M0B/06/14/YYcBAF5jYPiAXJeBAD3zjnZbrl4423.mp3"
        list.add(musicVo_32)

        val musicVo_33 = MusicVo()
        musicVo_33.audioName = "一万个理由"
        musicVo_33.singerName = "郑源"
        musicVo_33.cover = "https://imge.kugou.com/stdmusic/20150720/20150720183315129832.jpg"
        musicVo_33.url =
            "https://webfs.ali.kugou.com/202201301910/101b2b956aed8a93f80fdd7d05906b97/KGTX/CLTX001/6be0597021c8e5e3d7a9ae5fb782947a.mp3"
        list.add(musicVo_33)

        val musicVo_34 = MusicVo()
        musicVo_34.audioName = "玫瑰花的葬礼"
        musicVo_34.singerName = "许嵩"
        musicVo_34.cover = "https://imge.kugou.com/stdmusic/20190924/20190924195702432753.jpg"
        musicVo_34.url =
            "https://webfs.ali.kugou.com/202201301910/e59c511679647f03d976fe9db3c7783b/KGTX/CLTX001/ca6840904452f245f39d83ec7d8ae9cc.mp3"
        list.add(musicVo_34)

        val musicVo_35 = MusicVo()
        musicVo_35.audioName = "老人与海"
        musicVo_35.singerName = "海鸣威、吴琼"
        musicVo_35.cover = "https://imge.kugou.com/stdmusic/20200909/20200909112215111862.jpg"
        musicVo_35.url =
            "https://webfs.ali.kugou.com/202201301910/ab5ab767c12e486c984ed7eada23de6e/KGTX/CLTX001/be8cf138af41e4037942fc211dc5d648.mp3"
        list.add(musicVo_35)

        val musicVo_36 = MusicVo()
        musicVo_36.audioName = "该死的温柔"
        musicVo_36.singerName = "马天宇"
        musicVo_36.cover = "https://imge.kugou.com/stdmusic/20150718/20150718213709895570.jpg"
        musicVo_36.url =
            "https://webfs.ali.kugou.com/202201301911/f57a5aba959c85105d2de42f32099f95/G187/M01/1A/11/m5QEAF5OmbSAHulfADbrgeWrIW4040.mp3"
        list.add(musicVo_36)

        val musicVo_37 = MusicVo()
        musicVo_37.audioName = "화신 (花信)"
        musicVo_37.singerName = "朴孝信"
        musicVo_37.cover = "https://imge.kugou.com/stdmusic/20150718/20150718123017978688.jpg"
        musicVo_37.url =
            "https://webfs.ali.kugou.com/202201301911/a8dbe42538f50f51900768c08d574f7c/G148/M00/0E/15/NIcBAFvSWsaAVdxpADt6eHbeIR0286.mp3"
        list.add(musicVo_37)

        val musicVo_38 = MusicVo()
        musicVo_38.audioName = "눈의 꽃 (雪之花)"
        musicVo_38.singerName = "朴孝信"
        musicVo_38.cover = "https://imge.kugou.com/stdmusic/20210111/20210111163338987013.jpg"
        musicVo_38.url =
            "https://webfs.ali.kugou.com/202201301911/fede6bb072ac4caf450535e8f401decf/G079/M00/05/11/74YBAFhZSlSAZys4AFOtGt6Ggzk451.mp3"
        list.add(musicVo_38)

        val musicVo_39 = MusicVo()
        musicVo_39.audioName = "처음부터 지금까지 (从开始到现在)"
        musicVo_39.singerName = "Ryu"
        musicVo_39.cover = "https://imge.kugou.com/stdmusic/20160914/20160914120311733137.jpg"
        musicVo_39.url =
            "https://webfs.ali.kugou.com/202201301911/87488c8df7bc618eaef48d98a1c5c847/G192/M09/1D/0F/oJQEAF5r62CAEdqEAEHHritN8Ek223.mp3"
        list.add(musicVo_39)

        val musicVo_40 = MusicVo()
        musicVo_40.audioName = "상어를 사랑한 인어 (爱上鲨鱼的人鱼)(女 Ver.)"
        musicVo_40.singerName = "殆死悲爱"
        musicVo_40.cover = "https://imge.kugou.com/stdmusic/20200909/20200909124302893668.jpg"
        musicVo_40.url =
            "https://webfs.ali.kugou.com/202201301911/7ac1f0e519142eff513b1b5b3a9abaad/KGTX/CLTX001/ba4642f7156ca1cce03ffdc1667185ec.mp3"
        list.add(musicVo_40)

        val musicVo_41 = MusicVo()
        musicVo_41.audioName = "Never Say Goodbye"
        musicVo_41.singerName = "Mario & Nasty"
        musicVo_41.cover = "https://imge.kugou.com/stdmusic/20200909/20200909122042910108.jpg"
        musicVo_41.url =
            "https://webfs.ali.kugou.com/202201301911/38d7f73dc7e1ce3ca6c3554dd118be4a/G050/M06/07/08/EpQEAFaeNTmAJOvyADp4qBdw7_c157.mp3"
        list.add(musicVo_41)

        val musicVo_42 = MusicVo()
        musicVo_42.audioName = "이별보다 더 큰 슬픔 (比离别更大的悲伤)"
        musicVo_42.singerName = "김완선"
        musicVo_42.cover = "https://imge.kugou.com/stdmusic/20190320/20190320090228249021.jpg"
        musicVo_42.url =
            "https://webfs.ali.kugou.com/202201301911/53941104789a185348d3aa1aee988dcc/G097/M09/03/13/AYcBAFkaYICAFGQaADxnB623XY4654.mp3"
        list.add(musicVo_42)

        val musicVo_43 = MusicVo()
        musicVo_43.audioName = "许愿池的希腊少女"
        musicVo_43.singerName = "蔡依林"
        musicVo_43.cover = "https://imge.kugou.com/stdmusic/20170731/20170731143426162414.jpg"
        musicVo_43.url =
            "https://webfs.ali.kugou.com/202201301912/29a362fe4c54132ce12eb191cc2d6858/KGTX/CLTX001/9f44c3f63cfb7fb8f8f0d51f142a0540.mp3"
        list.add(musicVo_43)

        val musicVo_44 = MusicVo()
        musicVo_44.audioName = "黄昏晓"
        musicVo_44.singerName = "王心凌"
        musicVo_44.cover = "https://imge.kugou.com/stdmusic/20160909/20160909034750909439.jpg"
        musicVo_44.url =
            "https://webfs.ali.kugou.com/202201301912/05585f5d38ce854b9775f99163a39291/KGTX/CLTX001/835ef82bbfc086287c778fc773c8cfd0.mp3"
        list.add(musicVo_44)

        val musicVo_45 = MusicVo()
        musicVo_45.audioName = "羽毛"
        musicVo_45.singerName = "王心凌"
        musicVo_45.cover = "https://imge.kugou.com/stdmusic/20150715/20150715193840591496.jpg"
        musicVo_45.url =
            "https://webfs.ali.kugou.com/202201301912/c98d1f3b4cdae95ce41925bcad9b9e76/KGTX/CLTX001/0033c6cb9fe8bb225ba2f2e4add50aba.mp3"
        list.add(musicVo_45)

        val musicVo_46 = MusicVo()
        musicVo_46.audioName = "Hihi Byebye"
        musicVo_46.singerName = "王心凌"
        musicVo_46.cover = "https://imge.kugou.com/stdmusic/20150717/20150717114031374000.jpg"
        musicVo_46.url =
            "https://webfs.ali.kugou.com/202201301912/e0f5f4eedc6287041adf813d094cbe90/KGTX/CLTX001/19a915121b90a2f52173d13c2c0e3c34.mp3"
        list.add(musicVo_46)

        val musicVo_47 = MusicVo()
        musicVo_47.audioName = "下一页的我"
        musicVo_47.singerName = "王心凌"
        musicVo_47.cover = "https://imge.kugou.com/stdmusic/20200620/20200620100621836773.jpg"
        musicVo_47.url =
            "https://webfs.ali.kugou.com/202201301912/388f8c2f50abb9f3ef5aa172d2111ee8/KGTX/CLTX001/afd05a90417998d78166195f56b0b4c2.mp3"
        list.add(musicVo_47)

        val musicVo_48 = MusicVo()
        musicVo_48.audioName = "月光"
        musicVo_48.singerName = "王心凌"
        musicVo_48.cover = "https://imge.kugou.com/stdmusic/20150717/20150717114031374000.jpg"
        musicVo_48.url =
            "https://webfs.ali.kugou.com/202201301912/e8636ea730681ba615049a8317f839ce/KGTX/CLTX001/817213b96dda2c15353912ca024a25b2.mp3"
        list.add(musicVo_48)

        val musicVo_49 = MusicVo()
        musicVo_49.audioName = "爱的天国"
        musicVo_49.singerName = "王心凌"
        musicVo_49.cover = "https://imge.kugou.com/stdmusic/20160908/20160908103943877421.jpg"
        musicVo_49.url =
            "https://webfs.ali.kugou.com/202201301913/033cefc849862a8c491a568117565905/G187/M04/0E/07/m5QEAF5Op26AQ-iJADWwAC99OM8955.mp3"
        list.add(musicVo_49)

        val musicVo_50 = MusicVo()
        musicVo_50.audioName = "花的嫁纱"
        musicVo_50.singerName = "王心凌"
        musicVo_50.cover = "https://imge.kugou.com/stdmusic/20200918/20200918205601673529.jpg"
        musicVo_50.url =
            "https://webfs.ali.kugou.com/202201301913/13f6d35e4819b064fde861c1989cb507/G236/M02/05/01/jIcBAF9kslyAdDrUAD5kieBjqbw595.mp3"
        list.add(musicVo_50)

        val musicVo_51 = MusicVo()
        musicVo_51.audioName = "还是好朋友"
        musicVo_51.singerName = "王心凌"
        musicVo_51.cover = "https://imge.kugou.com/stdmusic/20150718/20150718141332688567.jpg"
        musicVo_51.url =
            "https://webfs.ali.kugou.com/202201301913/25e5c37c0e3077d4ef697f21b16b5471/KGTX/CLTX001/e9c051014d0ad4f5fa37196b37adbefc.mp3"
        list.add(musicVo_51)

        val musicVo_52 = MusicVo()
        musicVo_52.audioName = "越长大越孤单"
        musicVo_52.singerName = "牛奶咖啡"
        musicVo_52.cover = "https://imge.kugou.com/stdmusic/20200812/20200812175031850500.jpg"
        musicVo_52.url =
            "https://webfs.ali.kugou.com/202201301913/0b51f5ea7aac52195fece44ec9403387/G194/M00/18/13/YocBAF5p44mATpUAAEGkvA7t5i0947.mp3"
        list.add(musicVo_52)

        val musicVo_53 = MusicVo()
        musicVo_53.audioName = "笑看风云"
        musicVo_53.singerName = "童珺"
        musicVo_53.cover = "https://imge.kugou.com/stdmusic/20191029/20191029211156651593.jpg"
        musicVo_53.url =
            "https://webfs.ali.kugou.com/202201301913/44fbb7665e52b0b9976cd5658dddc2b4/G173/M09/16/09/TYcBAF2vstSAd4zCADehLXwiiEs644.mp3"
        list.add(musicVo_53)

        val musicVo_54 = MusicVo()
        musicVo_54.audioName = "Sayonala"
        musicVo_54.singerName = "김완선"
        musicVo_54.cover = "https://imge.kugou.com/stdmusic/20150718/20150718145620209412.jpg"
        musicVo_54.url =
            "https://webfs.ali.kugou.com/202201301913/aaab6bd20ae5b7df5922bd60df128657/G196/M07/05/11/ZIcBAF5S2GqABthtAEXxzZwwuwc662.mp3"
        list.add(musicVo_54)

        val musicVo_55 = MusicVo()
        musicVo_55.audioName = "恰似你的温柔"
        musicVo_55.singerName = "蔡琴"
        musicVo_55.cover = "https://imge.kugou.com/stdmusic/20191230/20191230093604982979.jpg"
        musicVo_55.url =
            "https://webfs.ali.kugou.com/202201301914/c8621db2b2d1b9a45603f0c7bdb31df8/G183/M04/18/03/9w0DAF4QcZ6ANAIgADvGC8sVGB8510.mp3"
        list.add(musicVo_55)

        val musicVo_56 = MusicVo()
        musicVo_56.audioName = "美丽女人"
        musicVo_56.singerName = "程响"
        musicVo_56.cover = "https://imge.kugou.com/stdmusic/20200301/20200301222813392764.jpg"
        musicVo_56.url =
            "https://webfs.ali.kugou.com/202201301914/4953851c6702ab6e754f3c61435b5485/G185/M04/05/19/WYcBAF5c8AOAVF9TADmRFz4M7mc248.mp3"
        list.add(musicVo_56)

        val musicVo_57 = MusicVo()
        musicVo_57.audioName = "左边"
        musicVo_57.singerName = "杨丞琳"
        musicVo_57.cover = "https://imge.kugou.com/stdmusic/20200927/20200927143828761368.jpg"
        musicVo_57.url =
            "https://webfs.ali.kugou.com/202201301914/aa7fc484179f75edc012c5a4aae7443d/G193/M01/0A/13/YYcBAF5poGmABdaUAEMXb1U0Zhs902.mp3"
        list.add(musicVo_57)

        val musicVo_58 = MusicVo()
        musicVo_58.audioName = "飘摇"
        musicVo_58.singerName = "周迅"
        musicVo_58.cover = "https://imge.kugou.com/stdmusic/20200909/20200909115946244353.jpg"
        musicVo_58.url =
            "https://webfs.ali.kugou.com/202201301914/e2c9c30a08d2e02276df6e90f87ac9a4/G136/M06/10/0D/aJQEAFuIFweAWGvLAD0zv24zjQU269.mp3"
        list.add(musicVo_58)

        val musicVo_62 = MusicVo()
        musicVo_62.audioName = "我们的纪念日"
        musicVo_62.singerName = "范玮琪"
        musicVo_62.cover = "https://imge.kugou.com/stdmusic/20170727/20170727160932579471.jpg"
        musicVo_62.url =
            "https://webfs.ali.kugou.com/202201301915/c7d4af97dbe27e8b7c6cf5a5e713f61a/KGTX/CLTX001/e55a83984c8526eabb7a363fb77baac0.mp3"
        list.add(musicVo_62)

        val musicVo_63 = MusicVo()
        musicVo_63.audioName = "暧昧"
        musicVo_63.singerName = "杨丞琳"
        musicVo_63.cover = "https://imge.kugou.com/stdmusic/20201125/20201125125558975632.jpg"
        musicVo_63.url =
            "https://webfs.ali.kugou.com/202201301915/2d1da00808872d3b58f68eaa1988ec23/KGTX/CLTX001/3bea540f67655164718f6fc55cdb55f0.mp3"
        list.add(musicVo_63)

        val musicVo_64 = MusicVo()
        musicVo_64.audioName = "金枝欲孽 笛子二重奏"
        musicVo_64.singerName = "陈宝硕"
        musicVo_64.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20141126/20141126161009815150.jpg"
        musicVo_64.url =
            "https://webfs.ali.kugou.com/202201301915/ec7dbe7686f7781535fce23a2f63a604/G053/M03/1C/07/FZQEAFcOhDyAMTZSAB9VZbWYMhA920.mp3"
        list.add(musicVo_64)

        val musicVo_66 = MusicVo()
        musicVo_66.audioName = "My Destiny (我的命运)"
        musicVo_66.singerName = "LYn"
        musicVo_66.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        musicVo_66.url =
            "https://webfs.ali.kugou.com/202201301916/ebec023a666d772783175e77402c10e2/G200/M01/0C/1F/qJQEAF5j-GKANm0gADigUttl3CA594.mp3"
        list.add(musicVo_66)

        val musicVo_67 = MusicVo()
        musicVo_67.audioName = "별에서 온 그대 (来自星星的你)"
        musicVo_67.singerName = "윤하 (YOUNHA)"
        musicVo_67.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        musicVo_67.url =
            "https://webfs.ali.kugou.com/202201301916/5c9e10664ce38063da99b02e5be4c64e/G193/M05/1E/15/AQ4DAF5QuJqAcWgiADCKHoJfwfk955.mp3"
        list.add(musicVo_67)

        val musicVo_68 = MusicVo()
        musicVo_68.audioName = "안녕 (再见)"
        musicVo_68.singerName = "孝琳"
        musicVo_68.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        musicVo_68.url =
            "https://webfs.ali.kugou.com/202201301917/e4e940d0996411ba0a273e84592ec1ae/G100/M09/12/19/pA0DAFvNscuAMy-DADV5ypjbsaY829.mp3"
        list.add(musicVo_68)

        val musicVo_69 = MusicVo()
        musicVo_69.audioName = "너의 집 앞"
        musicVo_69.singerName = "金秀贤"
        musicVo_69.cover = "https://imge.kugou.com/stdmusic/20200812/20200812152113360905.jpg"
        musicVo_69.url =
            "https://webfs.ali.kugou.com/202201301917/2ebc66a3c36432a79cd443c984aceba2/G137/M00/02/17/aZQEAFtrVIuANAqvADfMc4yV1lQ057.mp3"
        list.add(musicVo_69)

        val musicVo_70 = MusicVo()
        musicVo_70.audioName = "我悄悄的蒙上你的眼睛"
        musicVo_70.singerName = "高明骏"
        musicVo_70.cover = "https://imge.kugou.com/stdmusic/20200909/20200909121638734521.jpg"
        musicVo_70.url =
            "https://webfs.ali.kugou.com/202201301917/029cd7897c085b01496368133b5fdb4d/G141/M0A/0B/07/LYcBAFuJHLeACHizADm2DF3DR5o913.mp3"
        list.add(musicVo_70)

        val musicVo_71 = MusicVo()
        musicVo_71.audioName = "A Comme Amour (秋日的私语)"
        musicVo_71.singerName = "Richard Clayderman"
        musicVo_71.cover = "https://imge.kugou.com/stdmusic/20170502/20170502020707555413.jpg"
        musicVo_71.url =
            "https://webfs.ali.kugou.com/202201301917/1f86e768ec7e776e811a457f9ce8ef2e/G138/M0B/0C/1F/apQEAFuJRgCADuPAADDPtqjEqtc324.mp3"
        list.add(musicVo_71)

        val musicVo_72 = MusicVo()
        musicVo_72.audioName = "倩女幽魂"
        musicVo_72.singerName = "刘惜君"
        musicVo_72.cover = "https://imge.kugou.com/stdmusic/20200509/20200509115603273192.jpg"
        musicVo_72.url =
            "https://webfs.ali.kugou.com/202201301918/a5b6ef4ea2bd88bbd0c25635c80ec7c9/G215/M03/1B/11/Fw4DAF62K06AXU8tACWwAI-4yvw323.mp3"
        list.add(musicVo_72)

        val musicVo_73 = MusicVo()
        musicVo_73.audioName = "美丽的神话"
        musicVo_73.singerName = "成龙、金喜善"
        musicVo_73.cover = "https://imge.kugou.com/stdmusic/20200609/20200609221608205335.jpg"
        musicVo_73.url =
            "https://webfs.ali.kugou.com/202201301918/ad6f05d69bc58d298fffd1104fe42402/G192/M04/0F/19/oJQEAF5OQE-AKFxeAEbYgOmsMEw983.mp3"
        list.add(musicVo_73)

        val musicVo_74 = MusicVo()
        musicVo_74.audioName = "暁 (晓)"
        musicVo_74.singerName = "高梨康治"
        musicVo_74.cover = "https://imge.kugou.com/stdmusic/20210908/20210908160221792967.jpg"
        musicVo_74.url =
            "https://webfs.ali.kugou.com/202201301918/9ec7dc56f0a4604b39caceb22946f93b/G201/M09/03/0B/qZQEAF5jeH2APlo0AB3Ua8N4-Ts264.mp3"
        list.add(musicVo_74)

        val musicVo_75 = MusicVo()
        musicVo_75.audioName = "孤独"
        musicVo_75.singerName = "高梨康治"
        musicVo_75.cover = "https://imge.kugou.com/stdmusic/20210908/20210908160221792967.jpg"
        musicVo_75.url =
            "https://webfs.ali.kugou.com/202201301918/b188e18c23ba4e2a6c240d2bbdfaa0c3/G199/M02/05/09/Z4cBAF5Yv6iASl-MAB7UvoZPnqk793.mp3"
        list.add(musicVo_75)

        val musicVo_76 = MusicVo()
        musicVo_76.audioName = "柔らかな手"
        musicVo_76.singerName = "高梨康治、刃-yaiba-"
        musicVo_76.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_76.url =
            "https://webfs.ali.kugou.com/202201301918/6e5ea3b1cfdb6af9f572e78d6f947d31/G075/M01/0E/13/K5QEAFd_FseADp6aAC_K7rVW864294.mp3"
        list.add(musicVo_76)

        val musicVo_77 = MusicVo()
        musicVo_77.audioName = "父と母"
        musicVo_77.singerName = "高梨康治、刃-yaiba-"
        musicVo_77.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_77.url =
            "https://webfs.ali.kugou.com/202201301918/55c7f102d5b167b1c89a2fa85c59c4d9/G064/M04/16/00/IJQEAFd_Fr2ANDmIADGDuZdwQHM854.mp3"
        list.add(musicVo_77)

        val musicVo_78 = MusicVo()
        musicVo_78.audioName = "道は続く"
        musicVo_78.singerName = "高梨康治、刃-yaiba-"
        musicVo_78.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_78.url =
            "https://webfs.ali.kugou.com/202201301918/562b8585076dc6e5fe5ad54cbb652788/G065/M05/09/01/IZQEAFd_Fv6ANjHzAB2mBQc1f_U156.mp3"
        list.add(musicVo_78)

        val musicVo_79 = MusicVo()
        musicVo_79.audioName = "ノスタルジア"
        musicVo_79.singerName = "高梨康治、刃-yaiba-"
        musicVo_79.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_79.url =
            "https://webfs.ali.kugou.com/202201301919/12d0165943153ef42d363456d9bdeed5/G063/M0B/1C/05/fw0DAFd_FvyAMzoQAB3FEMADZR4395.mp3"
        list.add(musicVo_79)

        val musicVo_80 = MusicVo()
        musicVo_80.audioName = "ずっと見てた"
        musicVo_80.singerName = "高梨康治、刃-yaiba-"
        musicVo_80.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_80.url =
            "https://webfs.ali.kugou.com/202201301919/217a9a3437f82b99b99c274876f33626/G058/M0B/11/11/2oYBAFd_FseADIaRAB25ot2MWmw076.mp3"
        list.add(musicVo_80)

        val musicVo_81 = MusicVo()
        musicVo_81.audioName = "秋明菊"
        musicVo_81.singerName = "高梨康治、刃-yaiba-"
        musicVo_81.cover = "https://imge.kugou.com/stdmusic/20210908/20210908115701636044.jpg"
        musicVo_81.url =
            "https://webfs.ali.kugou.com/202201301919/3a90523b26bf6ecc74f6ac4f35bd50c6/G145/M05/00/19/cZQEAFvi0gGAVj8IABjcxaog30Q833.mp3"
        list.add(musicVo_81)

        val musicVo_82 = MusicVo()
        musicVo_82.audioName = "ゼツのテーマ"
        musicVo_82.singerName = "高梨康治、刃-yaiba-"
        musicVo_82.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_82.url =
            "https://webfs.ali.kugou.com/202201301919/056e6c0fe36207966ff4a18e6c51b728/G070/M03/1E/13/hg0DAFd_FsGASqkeACYWCw3mH0w377.mp3"
        list.add(musicVo_82)

        val musicVo_83 = MusicVo()
        musicVo_83.audioName = "アシュラ・インドラ"
        musicVo_83.singerName = "高梨康治、刃-yaiba-"
        musicVo_83.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_83.url =
            "https://webfs.ali.kugou.com/202201301919/24be04e01633d9f93d32a1092e506270/G061/M02/10/10/3YYBAFd_FrqAVXc8ACGt6lWIKN0156.mp3"
        list.add(musicVo_83)

        val musicVo_84 = MusicVo()
        musicVo_84.audioName = "修羅道"
        musicVo_84.singerName = "高梨康治、刃-yaiba-"
        musicVo_84.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_84.url =
            "https://webfs.ali.kugou.com/202201301919/ba249a6c5d5b86ac0ddb7fccbbce711d/G069/M09/00/15/hQ0DAFd_FsSAIqKVACSJRra-cMU372.mp3"
        list.add(musicVo_84)

        val musicVo_85 = MusicVo()
        musicVo_85.audioName = "粛清の女神"
        musicVo_85.singerName = "高梨康治、刃-yaiba-"
        musicVo_85.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_85.url =
            "https://webfs.ali.kugou.com/202201301919/adc8792a9a82754c6eb93d731cc503f4/G071/M04/03/03/J5QEAFd_FrqAUFEjABmn_S3CTOQ663.mp3"
        list.add(musicVo_85)

        val musicVo_86 = MusicVo()
        musicVo_86.audioName = "うずまく熱風"
        musicVo_86.singerName = "高梨康治、刃-yaiba-"
        musicVo_86.cover = "https://imge.kugou.com/stdmusic/20210908/20210908153503247290.jpg"
        musicVo_86.url =
            "https://webfs.ali.kugou.com/202201301920/64d656d69f60e4e11c7c6b6971d4ca57/G064/M0B/0E/18/4IYBAFd_FsaAQabhACPFZDPhBEc698.mp3"
        list.add(musicVo_86)

        val musicVo_87 = MusicVo()
        musicVo_87.audioName = "落葉船 (落叶船)"
        musicVo_87.singerName = "高梨康治、刃-yaiba-"
        musicVo_87.cover = "https://imge.kugou.com/stdmusic/20210908/20210908160501374347.jpg"
        musicVo_87.url =
            "https://webfs.ali.kugou.com/202201301920/c8ca4f4f74e754b101f910dc0720a910/G199/M00/0B/09/Bw4DAF5yXsmAAdm2ACAQt2bPwP8622.mp3"
        list.add(musicVo_87)

        val musicVo_88 = MusicVo()
        musicVo_88.audioName = "失意"
        musicVo_88.singerName = "高梨康治"
        musicVo_88.cover = "https://imge.kugou.com/stdmusic/20210908/20210908160221792967.jpg"
        musicVo_88.url =
            "https://webfs.ali.kugou.com/202201301920/cbbf9c52c7c7153a99bfca11fd8800ee/G202/M02/1C/09/aocBAF5sicGAT0bTAB2CySSoHKQ926.mp3"
        list.add(musicVo_88)

        val musicVo_89 = MusicVo()
        musicVo_89.audioName = "哀と悲 (哀与悲)"
        musicVo_89.singerName = "六三四"
        musicVo_89.cover = "https://imge.kugou.com/stdmusic/20210908/20210908000214218075.jpg"
        musicVo_89.url =
            "https://webfs.ali.kugou.com/202201301920/fc1bdfb263261c17dd830614aa7a317f/G201/M06/1B/04/aYcBAF5UIJOANTV7ACvcRoSw3a8786.mp3"
        list.add(musicVo_89)

        val musicVo_90 = MusicVo()
        musicVo_90.audioName = "哀と愁 (哀与愁)"
        musicVo_90.singerName = "纯音乐"
        musicVo_90.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20130531/20130531162457903.jpg"
        musicVo_90.url =
            "https://webfs.ali.kugou.com/202201301920/060a072a29ac56a2a72e5ecdba5f3b57/G200/M08/1E/07/aIcBAF5YkzCARaVMACwkOYIR0o8995.mp3"
        list.add(musicVo_90)

        val musicVo_91 = MusicVo()
        musicVo_91.audioName = "消愁 (DJ女生版)"
        musicVo_91.singerName = "新旭"
        musicVo_91.cover = "https://imge.kugou.com/stdmusic/20200110/20200110193426510352.jpg"
        musicVo_91.url =
            "https://webfs.ali.kugou.com/202201301921/3ce98d7dc6b7dc09cfd881f764358d51/G196/M06/11/19/pJQEAF4lbvmAS7PDACXSCOtvYdw636.mp3"
        list.add(musicVo_91)

        val musicVo_92 = MusicVo()
        musicVo_92.audioName = "一人晚餐"
        musicVo_92.singerName = "钟嘉欣"
        musicVo_92.cover = "https://imge.kugou.com/stdmusic/20150718/20150718171946246764.jpg"
        musicVo_92.url =
            "https://webfs.ali.kugou.com/202201301921/95f2b1829c9ac6bb552701f9c76c86ea/G078/M09/19/09/LpQEAFgvwXmAaWz3ADmo_ZoRo38429.mp3"
        list.add(musicVo_92)

        val musicVo_93 = MusicVo()
        musicVo_93.audioName = "多情种"
        musicVo_93.singerName = "胡杨林"
        musicVo_93.cover = "https://imge.kugou.com/stdmusic/20200909/20200909124111955688.jpg"
        musicVo_93.url =
            "https://webfs.ali.kugou.com/202201301921/97033492642b60bfd3ee9c253529f80d/G095/M07/16/07/P5QEAFj9vqeAe2m9AEYXn0RuuKM193.mp3"
        list.add(musicVo_93)

        val musicVo_94 = MusicVo()
        musicVo_94.audioName = "最浪漫的事"
        musicVo_94.singerName = "赵咏华"
        musicVo_94.cover = "https://imge.kugou.com/stdmusic/20200909/20200909120434791957.jpg"
        musicVo_94.url =
            "https://webfs.ali.kugou.com/202201301921/8c6ac23893979024d0b334bf57c5c9ba/G211/M01/1D/18/c4cBAF5rkY2AJvckAEDQmCOAnuM093.mp3"
        list.add(musicVo_94)

        val musicVo_95 = MusicVo()
        musicVo_95.audioName = "左手指月 (Live)"
        musicVo_95.singerName = "萨顶顶"
        musicVo_95.cover = "https://imge.kugou.com/stdmusic/20200328/20200328204648554453.jpg"
        musicVo_95.url =
            "https://webfs.ali.kugou.com/202201301921/875e8bf4ae8441baf49a7fc9d0aaf2fe/G192/M02/1F/17/AA4DAF6AfcOAJXQOADk7JNu4Cac793.mp3"
        list.add(musicVo_95)

        val musicVo_96 = MusicVo()
        musicVo_96.audioName = "Speak Softly, Love"
        musicVo_96.singerName = "Andy Williams"
        musicVo_96.cover = "https://imge.kugou.com/stdmusic/20170409/20170409154438670126.jpg"
        musicVo_96.url =
            "https://webfs.ali.kugou.com/202201301921/40e6bb6a9e7aabd2fa6690b01834ea0b/G051/M08/1F/18/E5QEAFZhugqAMuAFACzR4LepiJ0974.mp3"
        list.add(musicVo_96)

        val musicVo_97 = MusicVo()
        musicVo_97.audioName = "缺氧"
        musicVo_97.singerName = "杨丞琳"
        musicVo_97.cover = "https://imge.kugou.com/stdmusic/20160908/20160908035237756078.jpg"
        musicVo_97.url =
            "https://webfs.ali.kugou.com/202201301921/1835fdc6988bcaefa3ed118a7786f0b1/G200/M0B/15/15/CA4DAF5PUjyAWdn6AD-wCtSz_eE257.mp3"
        list.add(musicVo_97)

        val musicVo_98 = MusicVo()
        musicVo_98.audioName = "冰河想妈妈"
        musicVo_98.singerName = "纯音乐"
        musicVo_98.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20130531/20130531162457903.jpg"
        musicVo_98.url =
            "https://webfs.ali.kugou.com/202201301922/0b87e150ae7bd823b0f1b3fd87c6cf38/G193/M09/13/11/AQ4DAF5Ssq6AWdj_AB_OCu3lZQw515.mp3"
        list.add(musicVo_98)

        val musicVo_99 = MusicVo()
        musicVo_99.audioName = "Ballade Pour Adeline (水边的阿狄丽娜)"
        musicVo_99.singerName = "Richard Clayderman"
        musicVo_99.cover = "https://imge.kugou.com/stdmusic/20201229/20201229152914202525.jpg"
        musicVo_99.url =
            "https://webfs.ali.kugou.com/202201301922/59ff607f694964402b8db1f29259fa05/G192/M00/10/05/AA4DAF5pDYCAPCWlACa__2SSoUY034.mp3"
        list.add(musicVo_99)

        val musicVo_101 = MusicVo()
        musicVo_101.audioName = "雪千寻"
        musicVo_101.singerName = "胡伟立"
        musicVo_101.cover = "https://imge.kugou.com/stdmusic/20200909/20200909125045215175.jpg"
        musicVo_101.url =
            "https://webfs.ali.kugou.com/202201301922/62bf9ec3765aae25545476003786fe9f/G192/M01/0A/15/oJQEAF5UeKqAJVy6ADK2xVjrJ6I104.mp3"
        list.add(musicVo_101)

        val musicVo_102 = MusicVo()
        musicVo_102.audioName = "菩提一棵树 (纯音乐)"
        musicVo_102.singerName = "安敏捷、老五"
        musicVo_102.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20141230/20141230222726130605.jpg"
        musicVo_102.url =
            "https://webfs.ali.kugou.com/202201301922/107992fe4be930356d1915ba122e804c/G194/M02/12/01/opQEAF5nsI2AXKXYABUZpfFyPes611.mp3"
        list.add(musicVo_102)

        val musicVo_103 = MusicVo()
        musicVo_103.audioName = "アクション仮面の唄 (动感超人之歌)"
        musicVo_103.singerName = "玄田哲章、代官山少女合唱団"
        musicVo_103.cover = "https://imge.kugou.com/stdmusic/20200620/20200620065717783574.jpg"
        musicVo_103.url =
            "https://webfs.ali.kugou.com/202201301923/92debb04de86461a3c227de13ab366f2/G199/M05/10/0F/p5QEAF5yHNKAH2fpACoxDgNVjYI650.mp3"
        list.add(musicVo_103)

        val musicVo_104 = MusicVo()
        musicVo_104.audioName = "心愿便利贴"
        musicVo_104.singerName = "大Q秉洛、元若蓝"
        musicVo_104.cover = "https://imge.kugou.com/stdmusic/20190731/20190731173603877095.jpg"
        musicVo_104.url =
            "https://webfs.ali.kugou.com/202201301923/78c50fd261a4ff935af79e412df58421/G197/M04/02/15/BQ4DAF5lxA-AenQpAD5IAMDNbbQ236.mp3"
        list.add(musicVo_104)

        val musicVo_105 = MusicVo()
        musicVo_105.audioName = "你莫走"
        musicVo_105.singerName = "山水组合"
        musicVo_105.cover = "https://imge.kugou.com/stdmusic/20200514/20200514112009594473.jpg"
        musicVo_105.url =
            "https://webfs.ali.kugou.com/202201301923/33dec7ec1c520311646f201e71dd4251/G219/M0B/19/04/u5QEAF6r4tqAJjq_ADCSdUwfOEE046.mp3"
        list.add(musicVo_105)

        val musicVo_106 = MusicVo()
        musicVo_106.audioName = "世界这么大还是遇见你"
        musicVo_106.singerName = "程响"
        musicVo_106.cover = "https://imge.kugou.com/stdmusic/20200102/20200102145017962338.jpg"
        musicVo_106.url =
            "https://webfs.ali.kugou.com/202201301923/b714366b580ebd3d901b2d8d5b59ff20/G189/M00/17/03/XYcBAF4NnfOAdKH5ADn3W1bs4L0215.mp3"
        list.add(musicVo_106)

        val musicVo_107 = MusicVo()
        musicVo_107.audioName = "国际歌"
        musicVo_107.singerName = "唐朝"
        musicVo_107.cover = "https://imge.kugou.com/stdmusic/20160907/20160907222022997743.jpg"
        musicVo_107.url =
            "https://webfs.ali.kugou.com/202201301923/0da935db1a44faa9d979257ee14a6f48/G198/M08/02/0D/ZocBAF5banyAZjyuAEIBvbQdHSU809.mp3"
        list.add(musicVo_107)

        val musicVo_108 = MusicVo()
        musicVo_108.audioName = "生而为人"
        musicVo_108.singerName = "尚士达"
        musicVo_108.cover = "https://imge.kugou.com/stdmusic/20181222/20181222110124263772.jpg"
        musicVo_108.url =
            "https://webfs.ali.kugou.com/202201301923/b39905cebde303538eaa4afeee725f12/G146/M02/0E/05/cpQEAFwdqbWAXpWFAE4U9w8Ez_I406.mp3"
        list.add(musicVo_108)

        val musicVo_109 = MusicVo()
        musicVo_109.audioName = "我不愿让你一个人"
        musicVo_109.singerName = "五月天"
        musicVo_109.cover = "https://imge.kugou.com/stdmusic/20200909/20200909112636423113.jpg"
        musicVo_109.url =
            "https://webfs.ali.kugou.com/202201301923/e2ada552e8d7638b82271999a32c3b2b/G101/M01/01/0D/BYcBAFkCYlaAQllbAEEF8Z4AJm8818.mp3"
        list.add(musicVo_109)

        val musicVo_110 = MusicVo()
        musicVo_110.audioName = "想唱就唱"
        musicVo_110.singerName = "张含韵"
        musicVo_110.cover = "https://imge.kugou.com/stdmusic/20200812/20200812173142288672.jpg"
        musicVo_110.url =
            "https://webfs.ali.kugou.com/202201301924/fac150534f6b37d9945f126c8ce32e09/G138/M04/0E/19/yg0DAFuJwA-AfzIUADlxpx7NwDE690.mp3"
        list.add(musicVo_110)

        val musicVo_111 = MusicVo()
        musicVo_111.audioName = "三年的赌注"
        musicVo_111.singerName = "广东余丰"
        musicVo_111.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20210705/20210705115801622901.jpg"
        musicVo_111.url =
            "https://webfs.ali.kugou.com/202201301924/dc7e39e17cb4cb39d3c6dbfd42e998db/G212/M09/0A/03/tJQEAF6WrbaAMex6ABdHW9jU0uo232.mp3"
        list.add(musicVo_111)

        val musicVo_112 = MusicVo()
        musicVo_112.audioName = "Cry On My Shoulder"
        musicVo_112.singerName = "alexander klaws、Juliette Schoppmann、Daniel Küblböck"
        musicVo_112.cover = "https://imge.kugou.com/stdmusic/20160907/20160907185229963553.jpg"
        musicVo_112.url =
            "https://webfs.ali.kugou.com/202201301924/3cccdcf6e4bbad9e31deb09dea3d11a4/G076/M09/04/17/7IYBAFgullaARyg6ADoevPs0ye4394.mp3"
        list.add(musicVo_112)

        val musicVo_113 = MusicVo()
        musicVo_113.audioName = "Por Una Cabeza (一步之遥)"
        musicVo_113.singerName = "Thomas Newman、the tango project、Carlos Gardel"
        musicVo_113.cover = "https://imge.kugou.com/stdmusic/20210529/20210529133702621175.jpg"
        musicVo_113.url =
            "https://webfs.ali.kugou.com/202201301924/a783d3958510bdd1670bd6cbd1f8db20/G197/M0B/1D/04/ZYcBAF5l-16Aeo97ACGxTcGy6r4128.mp3"
        list.add(musicVo_113)

        val musicVo_115 = MusicVo()
        musicVo_115.audioName = "好人一生平安"
        musicVo_115.singerName = "李娜"
        musicVo_115.cover = "https://imge.kugou.com/stdmusic/20210120/20210120141338535340.jpg"
        musicVo_115.url =
            "https://webfs.ali.kugou.com/202201301924/98d0ab743afa2cf7012f81c27f95a831/G195/M00/06/1B/Y4cBAF5lwKmAEkjQAEPf8PNQikM113.mp3"
        list.add(musicVo_115)

        val musicVo_116 = MusicVo()
        musicVo_116.audioName = "一个人的浪漫 (钢琴曲)"
        musicVo_116.singerName = "耿子涵"
        musicVo_116.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20181024/20181024120239327.jpg"
        musicVo_116.url =
            "https://webfs.ali.kugou.com/202201301925/9458c6c1c141290003f0345dcdf75880/G131/M09/0E/13/I4cBAFtIBh-AX67sAC9wegpMwqw969.mp3"
        list.add(musicVo_116)

        val musicVo_117 = MusicVo()
        musicVo_117.audioName = "只要平凡"
        musicVo_117.singerName = "张杰、张碧晨"
        musicVo_117.cover = "https://imge.kugou.com/stdmusic/20180622/20180622194005815458.jpg"
        musicVo_117.url =
            "https://webfs.ali.kugou.com/202201301925/794b83d5088e7341c61fc2b3fe701e49/G128/M0B/0D/05/IIcBAFss7SWAFJ0BADwVp8tbUyg648.mp3"
        list.add(musicVo_117)

        val musicVo_118 = MusicVo()
        musicVo_118.audioName = "Rain"
        musicVo_118.singerName = "坂本龍一"
        musicVo_118.cover = "https://imge.kugou.com/stdmusic/20161126/20161126190219332168.jpg"
        musicVo_118.url =
            "https://webfs.ali.kugou.com/202201301925/36e0db2518dbf93dcdc77485a1278194/G082/M04/0D/1B/kg0DAFg72YWAIxZUAD6HBoFRRJU506.mp3"
        list.add(musicVo_118)

        val musicVo_119 = MusicVo()
        musicVo_119.audioName = "浪漫卡农"
        musicVo_119.singerName = "贵族乐团"
        musicVo_119.cover = "https://imge.kugou.com/stdmusic/20160908/20160908054600767363.jpg"
        musicVo_119.url =
            "https://webfs.ali.kugou.com/202201301925/a7d74a613fa4d206d26a78259f20c673/G205/M06/01/10/DQ4DAF5rAeCAB7LyAEQDgqX3qa0315.mp3"
        list.add(musicVo_119)

        val musicVo_120 = MusicVo()
        musicVo_120.audioName = "五百年桑田沧海"
        musicVo_120.singerName = "伍国忠"
        musicVo_120.cover = "https://imge.kugou.com/stdmusic/20200909/20200909134154818398.jpg"
        musicVo_120.url =
            "https://webfs.ali.kugou.com/202201301925/42650853e2f2873a69494e862a33b4b7/G210/M03/0C/1F/Eg4DAF5wlBmAVK8wAEuzlyFDJDQ212.mp3"
        list.add(musicVo_120)

        val musicVo_121 = MusicVo()
        musicVo_121.audioName = "乔克叔叔"
        musicVo_121.singerName = "周杰伦"
        musicVo_121.cover = "https://imge.kugou.com/stdmusic/20200909/20200909135350181905.jpg"
        musicVo_121.url =
            "https://webfs.ali.kugou.com/202201301925/eddc21cfac007d9456afea1fbb8e0464/G201/M0A/05/19/qZQEAF5SJlWATdO2AD65UBr5pxk649.mp3"
        list.add(musicVo_121)

        val musicVo_122 = MusicVo()
        musicVo_122.audioName = "爱过你这件事"
        musicVo_122.singerName = "西柚"
        musicVo_122.cover = "https://imge.kugou.com/stdmusic/20190920/20190920002407311977.jpg"
        musicVo_122.url =
            "https://webfs.ali.kugou.com/202201301926/c11af7ec932e9aef93af52f3ee9d10d7/G172/M05/04/09/TIcBAF2DqmiAHbBuAEQ_o6_h54c234.mp3"
        list.add(musicVo_122)

        val musicVo_123 = MusicVo()
        musicVo_123.audioName = "醒不来的梦"
        musicVo_123.singerName = "回小仙"
        musicVo_123.cover = "https://imge.kugou.com/stdmusic/20201203/20201203150402833578.jpg"
        musicVo_123.url =
            "https://webfs.ali.kugou.com/202201301926/e75a2a23508a49c68a25dc9676860df4/G234/M01/1F/19/ypQEAF9solOAFy9MADi7ZgAxc_0558.mp3"
        list.add(musicVo_123)

        val musicVo_124 = MusicVo()
        musicVo_124.audioName = "奉献2016"
        musicVo_124.singerName = "Vitas"
        musicVo_124.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20210726/20210726182752410.jpg"
        musicVo_124.url =
            "https://webfs.ali.kugou.com/202201301926/4eb0892924c29a6a925b6311e921f618/G061/M08/1A/14/HZQEAFdFTw-ANCP0AEHgyzFTw0A070.mp3"
        list.add(musicVo_124)

        val musicVo_127 = MusicVo()
        musicVo_127.audioName = "步步惊心配乐"
        musicVo_127.singerName = "纯音乐"
        musicVo_127.cover =
            "https://imgessl.kugou.com/uploadpic/softhead/400/20130531/20130531162457903.jpg"
        musicVo_127.url =
            "https://webfs.ali.kugou.com/202201301927/697c427cc8157c6731d7753e81f070af/G192/M07/12/0F/YIcBAF5a_xWAEUHvABmYWnjGcqQ033.mp3"
        list.add(musicVo_127)

        val musicVo_128 = MusicVo()
        musicVo_128.audioName = "カスカベ防衛隊の夜 (春日部防卫队之夜)"
        musicVo_128.singerName = "荒川敏行"
        musicVo_128.cover = "https://imge.kugou.com/stdmusic/20200909/20200909105532954172.jpg"
        musicVo_128.url =
            "https://webfs.ali.kugou.com/202201301927/92f3c214bab9e52f7c7b0e1369fae0af/G029/M0A/04/09/_ZMEAFWhOSeAafDiABxDVwlBsG8463.mp3"
        list.add(musicVo_128)


        return list
    }
}