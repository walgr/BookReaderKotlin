/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-28 15:36
 * Description: UserViewModel工厂
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wpf.bookreaderkotlin.data.UserInfoRepository

class UserViewModelFactory(
    private val userInfoRepository: UserInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userInfoRepository) as T
    }
}