/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-04 15:49
 * Description: 获取小说信息
 */
package com.wpf.bookreaderkotlin.utilities

import com.wpf.bookreaderkotlin.data.BookInfo
import kotlinx.coroutines.*
import org.jsoup.Jsoup

object BookInfoHelper {

    fun getBookInfo(bookUrl: String?, getBookInfoFinish: OnGetBookInfoFinish) {
        GlobalScope.launch(Dispatchers.IO) {
            var result: Any? = null
            if (null == bookUrl) {
                result = urlIsNull
                return@launch
            }
            bookUrl.let {
                val bookInfo = dealBookInfo(bookUrl)
                if (null == bookInfo) {
                    result = dataIsNull
                    return@launch
                }
                if (bookInfo.isDataError()) result = dataIsError
                result = bookInfo
            }

            launch(Dispatchers.Main) {
                when (result) {
                    is BookInfo -> getBookInfoFinish.onSuccess(result as BookInfo)
                    is String -> getBookInfoFinish.onFail(result as String)
                    else -> getBookInfoFinish.onFail(unknownError)
                }
            }
        }
    }

    private fun dealBookInfo(bookUrl: String): BookInfo? {
        val document = Jsoup.parse(EasyGetUrlData.getData(bookUrl))
        if (null == document || !document.hasText()) return null
        val chapterListUrl = getListUrl(bookUrl)
        val documentChapterList = Jsoup.parse(EasyGetUrlData.getData(chapterListUrl))
        if (null == documentChapterList || !documentChapterList.hasText()) return null
        val bookInfo = BookInfo()
        bookInfo.bookUrl = bookUrl
        bookInfo.bookChapterListUrl = chapterListUrl
        bookInfo.bookName = document.select("meta[property=og:novel:book_name]").attr("content")
        bookInfo.bookAuthor = document.select("meta[property=og:novel:author]").attr("content")
        bookInfo.bookImgUrl = document.select("meta[property=og:image]").attr("content")
        bookInfo.bookIntroduction = ""
        return bookInfo
    }

    private fun getListUrl(url: String): String {
        var listUrl = url.replace("book", "booklist")
        if (listUrl.endsWith("/")) listUrl = listUrl.substring(IntRange(0,listUrl.length - 1))
        listUrl += ".html"
        return listUrl
    }

    interface OnGetBookInfoFinish {
        fun onSuccess(bookInfo: BookInfo)
        fun onFail(msg: String)
    }
}