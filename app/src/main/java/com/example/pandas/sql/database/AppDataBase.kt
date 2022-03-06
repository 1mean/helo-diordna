package com.example.pandas.sql.database

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pandas.app.DiorApplication
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: 版本管理
 * @author: dongyiming
 * @date: 2022/1/11 12:51 上午
 * @version: v1.0
 */
@Database(entities = [PetVideo::class, MusicVo::class], version = 2, exportSchema = false)
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
                    }).allowMainThreadQueries().addMigrations(migration_1_2).build()
            }
            return instance!!
        }

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql1 = "alter table music add column fileName varchar(16) default null"
                val sql2 = "alter table music add column reservedInt integer not null default 0"
                val sql3 = "alter table music add column reservedString varchar(16) default null"
                database.execSQL(sql1)
                database.execSQL(sql2)
                database.execSQL(sql3)
            }
        }
    }
}