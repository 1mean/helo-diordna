package com.example.pandas.sql.database

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pandas.app.DiorApplication
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.entity.*

/**
 * @description: 版本管理
 * @author: dongyiming
 * @date: 2022/1/11 12:51 上午
 * @version: v1.0
 */
@Database(
    entities = [PetVideo::class, MusicVo::class, History::class, User::class, VideoData::class, VideoComment::class],
    version = 3,
    exportSchema = false
)
public abstract class AppDataBase : RoomDatabase() {

    abstract fun petVideoDao(): PetVideoDao

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
                    DiorApplication.instance(),
                    AppDataBase::class.java,
                    dbName
                )
                    .addCallback(object :
                        RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d("helo", "path: ${db.path}")
                        }
                    }).allowMainThreadQueries().addMigrations(migration_1_2, migration_2_3)
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
    }
}