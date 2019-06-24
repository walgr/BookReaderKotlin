/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 18:31
 * Description: 简单的获取网页内容（同步方式）
 */
package com.wpf.bookreaderkotlin.utilities

import com.wpf.bookreaderkotlin.App
import okhttp3.Request


object EasyGetUrlData {

    fun getData(url: String): String {
        val request = Request.Builder().url(url).build()
        return String(App.okHttpClient.newCall(request).execute().body()?.bytes()?: byteArrayOf(),Charsets.UTF_8)
    }
}