/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:25
 * Description: ShopFragment界面数据绑定
 */
package com.wpf.bookreaderkotlin.adapters

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadUrl")
fun bindLoadUrl(webView: WebView, loadUrl: String?) {
    webView.loadUrl(loadUrl ?: "")
}