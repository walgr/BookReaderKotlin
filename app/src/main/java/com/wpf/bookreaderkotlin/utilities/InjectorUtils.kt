package com.wpf.bookreaderkotlin.utilities

import android.content.Context
import androidx.lifecycle.LiveData
import com.wpf.bookreaderkotlin.data.AppDatabase
import com.wpf.bookreaderkotlin.data.BookChapterInfoRepository
import com.wpf.bookreaderkotlin.data.BookInfoRepository
import com.wpf.bookreaderkotlin.data.UserInfoRepository
import com.wpf.bookreaderkotlin.mvp.viewmodels.BookShopViewModelFactory
import com.wpf.bookreaderkotlin.mvp.viewmodels.HomeViewModelFactory
import com.wpf.bookreaderkotlin.mvp.viewmodels.UserViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    fun getBookInfoRepository(context: Context): BookInfoRepository {
        return BookInfoRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).getBookInfoDao()
        )
    }

    fun getBookChapterInfoRepository(context: Context): BookChapterInfoRepository {
        return BookChapterInfoRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).getBookChapterInfoDao()
        )
    }

    fun getUserInfoRepository(context: Context): UserInfoRepository {
        return UserInfoRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).getUserInfoDao()
        )
    }

    fun provideShopUrlViewModelFactory(
        loadUrl: LiveData<String>,
        bookInfoRepository: BookInfoRepository,
        bookChapterInfoRepository: BookChapterInfoRepository
    ): BookShopViewModelFactory {
        return BookShopViewModelFactory(loadUrl, bookInfoRepository, bookChapterInfoRepository)
    }

    fun provideHomeViewModelFactory(bookInfoRepository: BookInfoRepository)
            : HomeViewModelFactory {
        return HomeViewModelFactory(bookInfoRepository)
    }

    fun provideUserViewModelFactory(userInfoRepository: UserInfoRepository): UserViewModelFactory {
        return UserViewModelFactory(userInfoRepository)
    }
}
