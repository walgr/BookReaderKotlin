/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 14:46
 * Description: 小说章节信息
 */
package com.wpf.bookreaderkotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BookChapterInfo")
data class BookChapterInfo(
    @PrimaryKey @ColumnInfo(name = "id")
    var bookUrl: String = ""
)