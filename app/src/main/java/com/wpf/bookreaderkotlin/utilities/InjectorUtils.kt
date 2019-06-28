package com.wpf.bookreaderkotlin.utilities

import android.content.Context
import androidx.lifecycle.LiveData
import com.wpf.bookreaderkotlin.data.AppDatabase
import com.wpf.bookreaderkotlin.data.BookInfoRepository
import com.wpf.bookreaderkotlin.mvp.viewmodels.BookShopViewModelFactory
import com.wpf.bookreaderkotlin.mvp.viewmodels.HomeViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    fun getBookInfoRepository(context: Context): BookInfoRepository {
        return BookInfoRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).getBookInfoDao()
        )
    }

    fun provideShopUrlViewModelFactory(
        loadUrl: LiveData<String>,
        bookInfoRepository: BookInfoRepository
    ): BookShopViewModelFactory {
        return BookShopViewModelFactory(loadUrl, bookInfoRepository)
    }

    fun provideHomeViewModelFactory(bookInfoRepository: BookInfoRepository): HomeViewModelFactory {
        return HomeViewModelFactory(bookInfoRepository)
    }
}
