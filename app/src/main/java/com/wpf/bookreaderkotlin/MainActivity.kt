package com.wpf.bookreaderkotlin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.wpf.bookreaderkotlin.adapters.MainViewPagerAdapter
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.utilities.BookInfoHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var shopFragment: BookShopFragment
    private lateinit var userFragment: UserFragment
    private lateinit var fragments: Array<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {
        homeFragment = HomeFragment()
        shopFragment = BookShopFragment()
        userFragment = UserFragment()
        fragments = arrayOf(homeFragment, shopFragment, userFragment)
    }

    private fun initView() {
        supportActionBar?.hide()
        viewPager.setScrollable(false)
        viewPager.adapter = MainViewPagerAdapter(
            fragments,
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    viewPager.setCurrentItem(0, false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_shop -> {
                    viewPager.setCurrentItem(1, false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_user -> {
                    viewPager.setCurrentItem(2, false)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

//    fun onFragmentViewClick(view: View) {
//        when (view.id) {
//            R.id.shop_add_book -> {
//                view.isClickable = false
//                BookInfoHelper.getBookInfo(
//                    shopFragment.binding.shopWeb.url,
//                    object : BookInfoHelper.OnGetBookInfoFinish {
//
//                        override fun onSuccess(bookInfo: BookInfo) {
//                            view.isClickable = true
//
//                            showSnackBarMsg(view,getString(R.string.str_addBookSuccess))
//                        }
//
//                        override fun onFail(msg: String) {
//                            view.isClickable = false
//                            showSnackBarMsg(view,msg)
//                        }
//
//                    })
//            }
//        }
//    }

    override fun onBackPressed() {
        //默认web网页回退-->到首页了再回到Home-->退出app
        if (bottomNavigationView.selectedItemId == R.id.navigation_shop
            && shopFragment.binding.shopWeb.canGoBack()
        ) {
            shopFragment.binding.shopWeb.goBack()
        } else if (viewPager.currentItem != 0) {
            bottomNavigationView.selectedItemId = R.id.navigation_home
        } else {
            super.onBackPressed()
        }
    }
}
