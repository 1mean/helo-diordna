package com.example.pandas.sql.database

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pandas.DiorApplication
import com.example.pandas.sql.dao.PetVideoDao
import com.example.pandas.sql.entity.MusicVo
import com.example.pandas.sql.entity.PetVideo

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 2022/1/11 12:51 上午
 * @version: v1.0
 */
@Database(entities = [PetVideo::class,MusicVo::class], version = 1, exportSchema = false)
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
                return Room.databaseBuilder(DiorApplication.instance(), AppDataBase::class.java, dbName)
                    .addCallback(object :
                        RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            Log.e("helo", "path: " + db.path)
                        }
                    }).allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}