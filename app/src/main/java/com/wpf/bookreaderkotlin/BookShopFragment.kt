/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 15:56
 * Description: 书店Fragment
 */
package com.wpf.bookreaderkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.wpf.bookreaderkotlin.databinding.FragmentShopBinding
import com.wpf.bookreaderkotlin.utilities.InjectorUtils
import com.wpf.bookreaderkotlin.utilities.shopUrl
import com.wpf.bookreaderkotlin.viewmodels.BookShopViewModel

class BookShopFragment : Fragment() {

    private val viewModel: BookShopViewModel by viewModels {
        InjectorUtils.provideShopUrlViewModelFactory(MutableLiveData(shopUrl))
    }

    lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        binding.shopWeb.webViewClient = WebViewClient()
        binding.shopWeb.webChromeClient = WebChromeClient()
        subscribeUi(binding)
        return binding.root
    }

    private fun subscribeUi(binding: FragmentShopBinding) {
        viewModel.loadUrl.observe(viewLifecycleOwner, Observer<String> { loadUrl ->
            binding.shopWeb.loadUrl(loadUrl)
        })

        binding.shopAddBook.setOnClickListener { view ->
            if(context is MainActivity) {
                (context as MainActivity).onFragmentViewClick(view)
            }
        }

    }
}