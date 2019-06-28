/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:49
 * Description: 书店ViewModel工厂
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wpf.bookreaderkotlin.data.BookChapterInfoRepository
import com.wpf.bookreaderkotlin.data.BookInfoRepository

class BookShopViewModelFactory(
    private val loadUrl: LiveData<String>,
    private val bookInfoRepository: BookInfoRepository,
    private val bookChapterInfoRepository: BookChapterInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookShopViewModel(loadUrl, bookInfoRepository, bookChapterInfoRepository) as T
    }
}