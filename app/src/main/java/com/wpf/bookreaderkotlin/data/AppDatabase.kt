/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-24 14:15
 * Description: App数据库（唯一）
 */
package com.wpf.bookreaderkotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wpf.bookreaderkotlin.utilities.DATABASE_NAME
import com.wpf.bookreaderkotlin.utilities.DATABASE_VERSION
import com.wpf.bookreaderkotlin.utilities.SYSTEM_USER_ID
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(entities = [BookInfo::class, BookChapterInfo::class, UserInfo::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getBookInfoDao(): BookInfoDao

    abstract fun getBookChapterInfoDao(): BookChapterInfoDao

    abstract fun getUserInfoDao(): UserInfoDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //数据库创建时初始化数据
                        GlobalScope.launch {
                            withContext(IO) {
                                getInstance(context.applicationContext)
                                    .getUserInfoDao().addUser(buildExampleUser())
                            }
                        }
                    }
                }).build()
        }

        private fun buildExampleUser(): UserInfo {
            return UserInfo(
                SYSTEM_USER_ID,
                "系统用户",
                "小机器",
                "http://image.biaobaiju.com/uploads/20180802/03/1533150393-nMJhlBfqWL.jpg"
            )
        }
    }
}