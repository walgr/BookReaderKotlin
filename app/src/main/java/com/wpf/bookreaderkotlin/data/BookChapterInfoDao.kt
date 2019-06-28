/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-26 19:35
 * Description: 小说章节数据库操作
 */
package com.wpf.bookreaderkotlin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface BookChapterInfoDao {

    /**
     * 添加一个章节
     */
    @Insert
    fun insertChapter(chapterInfo: BookChapterInfo)

    @Transaction
    @Insert
    fun insertChapterList(chapterInfoList: List<BookChapterInfo>)

    /**
     * 删除一个章节
     */
    @Delete
    fun deleteChapter(chapterInfo: BookChapterInfo)

    @Transaction
    @Delete
    fun deleteChapterList(chapterInfoList: List<BookChapterInfo>)

    /**
     * 根据小说地址主码删除所有章节
     */
    @Query("DELETE FROM BookChapterInfo WHERE book_id = (:bookUrl)")
    fun deleteChapterByBookUrl(bookUrl: String)

    /**
     * 删除所有小说章节
     */
    @Query("DELETE FROM BookChapterInfo")
    fun deleteAllChapter()

    /**
     * 更新章节
     */
    @Update
    fun updateChapter(chapterInfo: BookChapterInfo)

    /**
     * 根据小说地址查询所有章节
     */
    @Query("SELECT * FROM BookChapterInfo WHERE book_id = (:bookUrl)")
    fun getChapterListByBookUrl(bookUrl: String): MutableLiveData<BookChapterInfo>

    /**
     * 根据章节地址查询章节内容
     */
    @Query("SELECT * FROM BookChapterInfo WHERE chapter_id = (:bookChapterUrl)")
    fun getChapterByChapterUrl(bookChapterUrl: String) : LiveData<BookChapterInfo>
}