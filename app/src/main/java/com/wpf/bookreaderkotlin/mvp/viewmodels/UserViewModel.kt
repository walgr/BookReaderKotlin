/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-28 15:34
 * Description: 用户界面ViewModel
 */
package com.wpf.bookreaderkotlin.mvp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wpf.bookreaderkotlin.data.UserInfo
import com.wpf.bookreaderkotlin.data.UserInfoRepository
import com.wpf.bookreaderkotlin.utilities.SYSTEM_USER_ID

class UserViewModel(userInfoRepository: UserInfoRepository): ViewModel() {

    var userInfo: LiveData<UserInfo> = userInfoRepository.getUserById(SYSTEM_USER_ID)
}