/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 14:46
 * Description: 小说章节信息
 */
package com.wpf.bookreaderkotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "BookChapterInfo",
    primaryKeys = ["book_id", "chapter_id"],
    foreignKeys = [ForeignKey(entity = BookInfo::class, parentColumns = ["id"], childColumns = ["book_id"])]
)
data class BookChapterInfo(
    /**
     * 小说地址
     */
    @ColumnInfo(name = "book_id")
    var bookUrl: String = "",

    /**
     * 章节地址
     */
    @ColumnInfo(name = "chapter_id")
    var chapterUrl: String = "",

    /**
     * 章节名称
     */
    var chapterName: String? = "",

    /**
     * 章节内容
     */
    var chapterPageContent: String? = ""
)