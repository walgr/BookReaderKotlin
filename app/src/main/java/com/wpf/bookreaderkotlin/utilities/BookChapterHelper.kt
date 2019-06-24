/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-04 15:49
 * Description: 获取小说章节信息
 */
package com.wpf.bookreaderkotlin.utilities

import com.wpf.bookreaderkotlin.data.BookChapterInfo

object BookChapterHelper {

    fun getChapterList(bookUrl: String, onGetBookChapterFinish: OnGetBookChapterFinish) {


    }

    interface OnGetBookChapterFinish {
        fun onSuccess(result: List<BookChapterInfo>)
        fun onFail(msg: String?)
    }
}