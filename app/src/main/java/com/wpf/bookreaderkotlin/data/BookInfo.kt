/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 14:31
 * Description: 小说书籍信息
 */
package com.wpf.bookreaderkotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookInfo")
data class BookInfo(
    //小说网址
    @PrimaryKey @ColumnInfo(name = "id")
    var bookUrl: String = "",
    //小说章节网址
    var bookChapterListUrl: String = "",
    //小说名称
    var bookName: String = "",
    //小说封面图片地址
    var bookImgUrl: String? = "",
    //小说作者
    var bookAuthor: String? = "",
    //小说简介
    var bookIntroduction: String? = ""
) {
    //验证书籍信息是否合规
    fun isDataError(): Boolean {
        return bookUrl.isEmpty()
    }
}