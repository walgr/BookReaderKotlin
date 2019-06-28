/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-24 14:32
 * Description: BookInfo数据库查询SQL
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookInfoDao {

    /**
     * 插入一本小说
     */
    @Insert
    fun insertBook(bookInfo: BookInfo)

    /**
     * 删除一本小说
     */
    @Delete
    fun deleteBook(bookInfo: BookInfo)

    /**
     * 更新一本小说
     */
    @Update
    fun updateBook(bookInfo: BookInfo)

    /**
     * 查询所有小说
     */
    @Transaction
    @Query("SELECT * FROM BookInfo")
    fun getAllBook(): LiveData<List<BookInfo>>

    /**
     * 按bookUrl查询小说
     */
    @Transaction
    @Query("SELECT * FROM BookInfo WHERE id = (:bookUrl)")
    fun getBookByUrl(bookUrl: String): LiveData<BookInfo>?
}