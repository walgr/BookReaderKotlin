/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-04 15:49
 * Description: 获取小说章节信息
 */
package com.wpf.bookreaderkotlin.utilities

import com.wpf.bookreaderkotlin.data.BookChapterInfo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

object BookChapterHelper {

    fun getChapterList(bookUrl: String, bookChapterUrl: String?, getBookChapterFinish: OnGetBookChapterFinish) {
        GlobalScope.launch(IO) {
            var result: Any = ""
            if (null == bookChapterUrl) {
                result = urlIsNull
            }

            bookChapterUrl?.let {
                val chapterList = getChapterList(bookUrl, bookChapterUrl)
                if (chapterList.isNullOrEmpty()) {
                    result = dataIsNull
                    return@let
                }
                result = chapterList
            }

            launch(Main) {
                when (result) {
                    is List<*> -> getBookChapterFinish.onSuccess(result as List<BookChapterInfo>)
                    is String -> getBookChapterFinish.onFail(result as String)
                    else -> getBookChapterFinish.onFail(unknownError)
                }
            }
        }
    }

    private fun getChapterList(bookUrl: String, bookChapterUrl: String) : List<BookChapterInfo>? {
        val document = Jsoup.parse(EasyGetUrlData.getData(bookChapterUrl))
        if (null == document || !document.hasText()) return null
        val chapterHtmlList = document.select("p a[href*=html]")
        if(chapterHtmlList.isNullOrEmpty()) return null
        val result = mutableListOf<BookChapterInfo>()
        for(ele in chapterHtmlList) {
            val chapterInfo = BookChapterInfo()
            chapterInfo.bookUrl = bookUrl
            chapterInfo.chapterUrl = shopUrl + ele.attr("href")
            chapterInfo.chapterName = ele.html()
            result.add(chapterInfo)
        }
        return result
    }

    interface OnGetBookChapterFinish {
        fun onSuccess(result: List<BookChapterInfo>)
        fun onFail(msg: String)
    }
}