/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 15:56
 * Description: 用户Fragment
 */
package com.wpf.bookreaderkotlin

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.readystatesoftware.systembartint.SystemBarTintManager
import com.wpf.bookreaderkotlin.adapters.bindCircleViewLoadUrl
import com.wpf.bookreaderkotlin.data.UserInfo
import com.wpf.bookreaderkotlin.databinding.FragmentUserBinding
import com.wpf.bookreaderkotlin.mvp.viewmodels.UserViewModel
import com.wpf.bookreaderkotlin.utilities.InjectorUtils

class UserFragment : BaseFragment() {

    private val viewModel: UserViewModel by viewModels {
        InjectorUtils.provideUserViewModelFactory(
            InjectorUtils.getUserInfoRepository(requireContext())
        )
    }

    lateinit var bind: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tintManager = SystemBarTintManager(requireActivity())
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
        tintManager.setStatusBarTintColor(Color.TRANSPARENT)
        bind = FragmentUserBinding.inflate(inflater, container, false)
        subscribeUi(bind)
        return bind.root
    }

    private fun subscribeUi(binding: FragmentUserBinding) {
        viewModel.userInfo.observe(viewLifecycleOwner, Observer<UserInfo> { userInfo ->
            bindCircleViewLoadUrl(binding.userImg, userInfo?.imgUrl)
            binding.userName.text = userInfo?.name
        })
    }
}