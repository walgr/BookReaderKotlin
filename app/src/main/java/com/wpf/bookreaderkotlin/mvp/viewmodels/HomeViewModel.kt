/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-24 15:24
 * Description: Home
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.data.BookInfoRepository

class HomeViewModel(bookInfoRepository: BookInfoRepository): ViewModel() {

    var bookList: LiveData<List<BookInfo>> = bookInfoRepository.getAllBook()

}