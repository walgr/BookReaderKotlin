/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:31
 * Description: 书店ViewModel
 */
package com.wpf.bookreaderkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wpf.bookreaderkotlin.utilities.shopUrl

class BookShopViewModel(var loadUrl: LiveData<String>) : ViewModel()