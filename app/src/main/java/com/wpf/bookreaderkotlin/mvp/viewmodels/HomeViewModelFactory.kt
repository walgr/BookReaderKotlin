/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:49
 * Description: 主页ViewModel工厂
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wpf.bookreaderkotlin.data.BookInfoRepository

class HomeViewModelFactory(
    private val bookInfoRepository: BookInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(bookInfoRepository) as T
    }
}