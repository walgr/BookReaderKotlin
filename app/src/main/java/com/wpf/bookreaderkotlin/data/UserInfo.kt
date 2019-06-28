/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-28 16:05
 * Description: 个人信息
 */
package com.wpf.bookreaderkotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInfo")
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var nickname: String? = "",
    var imgUrl: String? = ""
)