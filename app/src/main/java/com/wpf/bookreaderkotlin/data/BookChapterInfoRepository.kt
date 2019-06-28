/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-26 19:34
 * Description: 小说章节数据库
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class BookChapterInfoRepository private constructor(private val bookChapterInfoDao: BookChapterInfoDao) {

    fun getChapterListByBookUrl(bookUrl: String): MutableLiveData<BookChapterInfo> =
        bookChapterInfoDao.getChapterListByBookUrl(bookUrl)

    fun getChapterByChapterUrl(bookChapterUrl: String): LiveData<BookChapterInfo> =
        bookChapterInfoDao.getChapterByChapterUrl(bookChapterUrl)

    suspend fun insertChapter(chapterInfo: BookChapterInfo) {
        withContext(IO) {
            bookChapterInfoDao.insertChapter(chapterInfo)
        }
    }

    suspend fun insertChapterList(chapterInfoList: List<BookChapterInfo>) {
        withContext(IO) {
            bookChapterInfoDao.insertChapterList(chapterInfoList)
        }
    }

    suspend fun deleteChapter(chapterInfo: BookChapterInfo) {
        withContext(IO) {
            bookChapterInfoDao.deleteChapter(chapterInfo)
        }
    }

    suspend fun deleteChapterList(chapterInfoList: List<BookChapterInfo>) {
        withContext(IO) {
            bookChapterInfoDao.deleteChapterList(chapterInfoList)
        }
    }

    suspend fun deleteChapterByBookUrl(bookUrl: String) {
        withContext(IO) {
            bookChapterInfoDao.deleteChapterByBookUrl(bookUrl)
        }
    }

    suspend fun deleteAllChapater() {
        withContext(IO) {
            bookChapterInfoDao.deleteAllChapter()
        }
    }

    suspend fun updateChapter(chapterInfo: BookChapterInfo) {
        withContext(IO) {
            bookChapterInfoDao.updateChapter(chapterInfo)
        }
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: BookChapterInfoRepository? = null

        fun getInstance(bookChapterInfoDao: BookChapterInfoDao) =
            instance ?: synchronized(this) {
                instance ?: BookChapterInfoRepository(bookChapterInfoDao).also { instance = it }
            }
    }
}