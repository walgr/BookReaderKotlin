/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-03 15:47
 * Description: 首页适配器
 */
package com.wpf.bookreaderkotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainViewPagerAdapter(
    private val fragments: Array<Fragment>,
    fm: FragmentManager,
    behavior: Int): FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}