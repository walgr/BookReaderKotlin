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
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.wpf.bookreaderkotlin.data.BookChapterInfo
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.databinding.FragmentShopBinding
import com.wpf.bookreaderkotlin.utilities.InjectorUtils
import com.wpf.bookreaderkotlin.utilities.shopUrl
import com.wpf.bookreaderkotlin.mvp.viewmodels.BookShopViewModel
import com.wpf.bookreaderkotlin.utilities.BookChapterHelper
import com.wpf.bookreaderkotlin.utilities.BookInfoHelper

class BookShopFragment : BaseFragment() {

    private var isClick = false

    private val viewModel: BookShopViewModel by viewModels {
        InjectorUtils.provideShopUrlViewModelFactory(
            MutableLiveData(shopUrl),
            InjectorUtils.getBookInfoRepository(requireContext())
        )
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

        binding.clickListener = createOnClickListener()
    }

    private fun createOnClickListener(): View.OnClickListener {
        return View.OnClickListener { view ->
            //            if(context is MainActivity) {
//                (context as MainActivity).onFragmentViewClick(view)
//            }
            //获取小说成功
            if (isClick) return@OnClickListener
            isClick = true
            BookInfoHelper.getBookInfo(
                binding.shopWeb.url,
                object : BookInfoHelper.OnGetBookInfoFinish {

                    override fun onSuccess(bookInfo: BookInfo) {
                        viewModel.insertBook(bookInfo)
                        BookChapterHelper.getChapterList(bookInfo.bookUrl, bookInfo.bookChapterListUrl,
                            object : BookChapterHelper.OnGetBookChapterFinish {
                                override fun onSuccess(result: List<BookChapterInfo>) {
                                    isClick = false
                                    showSnackBarMsg(view, getString(R.string.str_addBookSuccess))
                                }

                                override fun onFail(msg: String) {
                                    isClick = false
                                    showSnackBarMsg(view, msg)
                                }
                            })
                    }

                    override fun onFail(msg: String) {
                        isClick = false
                        showSnackBarMsg(view, msg)
                    }

                })
        }
    }
}