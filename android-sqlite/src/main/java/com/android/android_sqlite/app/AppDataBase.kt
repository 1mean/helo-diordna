package com.android.android_sqlite.app

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.android_sqlite.dao.*
import com.android.android_sqlite.entity.*

/**
 * @description: 版本管理
 * @author: dongyiming
 * @date: 2022/1/11 12:51 上午
 * @version: v1.0
 */
@Database(
    entities = [PetVideo::class, MusicVo::class, History::class, User::class, VideoData::class, VideoComment::class, Group::class, GroupVideoItem::class, SearchHistory::class],
    version = 4,
    exportSchema = false
)
public abstract class AppDataBase : RoomDatabase() {

    abstract fun petVideoDao(): PetVideoDao
    abstract fun userDao(): UserDao
    abstract fun groupDao(): GroupDao
    abstract fun historyDao(): HistoryDao
    abstract fun musicDao(): MusicDao
    abstract fun videoCommentDao(): VideoCommentDao
    abstract fun searchHistoryDao(): SearchHistoryDao

    companion object {

        private val dbName = "cute_pet.db"

        @Volatile
        private var instance: AppDataBase? = null

        @JvmStatic
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: buildDataBase()
                    .also { instance = it }
            }

        private fun buildDataBase(): AppDataBase {

            if (instance == null) {
                return Room.databaseBuilder(
                    SqliteApplication.instance.applicationContext,
                    AppDataBase::class.java,
                    dbName
                )
                    .allowMainThreadQueries()//允许在主线程查询
                    .fallbackToDestructiveMigration()//设置升级策略，失败了会回滚至上一个版本
                    .addMigrations(migration_1_2, migration_2_3, migration_3_4)
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d("helo", "path: ${db.path}")
                        }
                    })
                    .build()
            }
            return instance!!
        }

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql1 = "alter table music add column fileName text default null"
                val sql2 = "alter table music add column reservedInt integer not null default 0"
                val sql3 = "alter table music add column reservedString text default null"
                database.execSQL(sql1)
                database.execSQL(sql2)
                database.execSQL(sql3)
            }
        }

        //千万别在顶部添加 History::class
        private val migration_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql =
                    "CREATE TABLE IF NOT EXISTS `history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT,`code` INTEGER NOT NULL,`lastTime` INTEGER,`playPosition` TEXT,`reservedInt` INTEGER DEFAULT 0,`reservedString` TEXT)"
                database.execSQL(sql)
            }
        }

        private val migration_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql =
                    "CREATE TABLE IF NOT EXISTS `search_history` (`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`createTime` INTEGER NOT NULL DEFAULT 0,`updateTime` INTEGER NOT NULL DEFAULT 0,`type` INTEGER NOT NULL DEFAULT 0,`reservedInt` INTEGER NOT NULL DEFAULT 0,`reservedString` TEXT)"
                database.execSQL(sql)
            }
        }
    }
}