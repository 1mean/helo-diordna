package com.android.android_sqlite.manager

import com.android.android_sqlite.app.AppDataBase
import com.android.android_sqlite.bean.MusicBean
import com.android.android_sqlite.bean.VideoType
import com.android.android_sqlite.dao.MusicDao
import com.android.android_sqlite.entity.MusicVo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * @description: 处理MusicVo表相关的数据库操作
 * @author: dongyiming
 * @date: 8/19/24 11:39 PM
 * @version: v1.0
 */
val musicRepository: MusicRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { MusicRepository() }

public class MusicRepository : BaseRepository() {

    private val musicDao: MusicDao by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        AppDataBase.getInstance().musicDao()
    }

    suspend fun insert(songs: MutableList<MusicVo>) {
        withContext(Dispatchers.IO) {
            musicDao.insert(songs)
        }
    }

    suspend fun delete(list: MutableList<MusicVo>) {
        withContext(Dispatchers.IO) {
            musicDao.delete(list)
        }
    }

    //fun queryRandomMusic(type: Int): Flow<MusicVo> = flowIn(musicDao.queryRandomMusic(type))

    fun getMusicCounts(): Flow<Int> = flowIn(musicDao.queryMusicCounts())

    suspend fun getMusic(fileName: String): MusicVo {
        return withContext(Dispatchers.IO) {
            musicDao.queryMusicByFileName(fileName)
        }
    }

    suspend fun getAllMusic(): MutableList<MusicVo> {
        return withContext(Dispatchers.IO) {
            musicDao.queryAllMusic()
        }
    }

    /**
     * 获取分页的music数据
     */
    suspend fun getPageMusic(type: Int, startIndex: Int, counts: Int): MutableList<MusicVo> {

        return withContext(Dispatchers.IO) {
            if (type != 0) {
                val startDex = (8 - type) * 10
                musicDao.queryMusicByPage(0, startDex, 10)
            } else {
                musicDao.queryMusicByPage(0, startIndex, counts)
            }
        }
    }

    suspend fun getMusic(): MusicBean {

        return withContext(Dispatchers.IO) {
            val musicBean = MusicBean()

            for (i in 0 until 6) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicBanners.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicItem1.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicItem2.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicItem3.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicItem4.add(musicVo)
            }

            for (i in 0..2) {
                val musicVo = musicDao.queryRandomMusic(0)
                musicBean.musicItem5.add(musicVo)
            }

            musicBean.musicVideos = musicDao.queryVideosByVideoType(VideoType.MUSIC.ordinal, 0, 4)

            musicBean
        }
    }
}