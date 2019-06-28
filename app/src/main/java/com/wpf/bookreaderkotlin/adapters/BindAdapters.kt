/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 16:25
 * Description: ShopFragment界面数据绑定
 */
package com.wpf.bookreaderkotlin.adapters

import android.graphics.Color
import android.webkit.WebView
import androidx.databinding.BindingAdapter
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("loadUrl")
fun bindLoadUrl(webView: WebView, loadUrl: String?) {
    webView.loadUrl(loadUrl ?: "")
}

@BindingAdapter("circleImgFromUrl")
fun bindCircleViewLoadUrl(circleImageView: CircleImageView,imgUrl: String?) {
    circleImageView.borderColor = Color.WHITE
    circleImageView.borderWidth = 3
    bindImageFromUrl(circleImageView, imgUrl)
}