/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 16:05
 * Description: 基础ViewIView
 */
package com.wpf.bookreaderkotlin.mvp.iview

import android.app.Activity
import android.view.View

interface BaseViewIView {
    //获取上下文
    fun getActivity(): Activity

    fun showToastMsg(msg: String)

    fun showSnackBarMsg(view: View, msg: String)
}