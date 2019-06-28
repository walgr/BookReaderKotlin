/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:31
 * Description: 书店ViewModel
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wpf.bookreaderkotlin.data.BookChapterInfo
import com.wpf.bookreaderkotlin.data.BookChapterInfoRepository
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.data.BookInfoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class BookShopViewModel(
    var loadUrl: LiveData<String>,
    private val bookInfoRepository: BookInfoRepository,
    private val bookChapterInfoRepository: BookChapterInfoRepository) : ViewModel() {

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun insertBook(bookInfo: BookInfo) {
        viewModelScope.launch {
            if(bookInfoRepository.getBookByUrl(bookInfo.bookUrl) == null) {
                bookInfoRepository.insertBook(bookInfo)
            } else {
                bookInfoRepository.updateBook(bookInfo)
            }
        }
    }

    fun insertBookChapterList(bookUrl: String, chapterInfoList: List<BookChapterInfo>) {
        viewModelScope.launch {
            if(bookChapterInfoRepository.getChapterListByBookUrl(bookUrl).)
        }
    }
}