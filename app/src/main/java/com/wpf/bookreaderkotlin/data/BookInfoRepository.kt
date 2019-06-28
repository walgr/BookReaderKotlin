/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-24 14:41
 * Description: BookInfo数据操作类
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookInfoRepository private constructor(private val bookInfoDao: BookInfoDao) {

    fun getAllBook(): LiveData<List<BookInfo>> = bookInfoDao.getAllBook()

    fun getBookByUrl(bookUrl: String): LiveData<BookInfo>?  = bookInfoDao.getBookByUrl(bookUrl)

    suspend fun insertBook(bookInfo: BookInfo) {
        withContext(Dispatchers.IO) {
            bookInfoDao.insertBook(bookInfo)
        }
    }

    suspend fun deleteBook(bookInfo: BookInfo) {
        withContext(Dispatchers.IO) {
            bookInfoDao.deleteBook(bookInfo)
        }
    }

    suspend fun updateBook(bookInfo: BookInfo) {
        withContext(Dispatchers.IO) {
            bookInfoDao.updateBook(bookInfo)
        }
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: BookInfoRepository? = null

        fun getInstance(bookInfoDao: BookInfoDao) =
            instance ?: synchronized(this) {
                instance ?: BookInfoRepository(bookInfoDao).also { instance = it }
            }
    }
}