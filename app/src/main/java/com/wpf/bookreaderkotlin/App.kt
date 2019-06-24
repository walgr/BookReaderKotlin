/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 18:36
 * Description:
 */
package com.wpf.bookreaderkotlin

import android.app.Application
import com.wpf.bookreaderkotlin.utilities.httpTimeOutTime
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class App : Application() {
    companion object {
        lateinit var okHttpClient: OkHttpClient
    }

    override fun onCreate() {
        super.onCreate()

        okHttpClient = OkHttpClient.Builder().apply {
            this.connectTimeout(httpTimeOutTime,TimeUnit.MILLISECONDS)
        }.build()
    }
}