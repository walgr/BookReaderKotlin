package com.wpf.bookreaderkotlin.utilities

import androidx.lifecycle.LiveData
import com.wpf.bookreaderkotlin.viewmodels.BookShopViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    fun provideShopUrlViewModelFactory(loadUrl: LiveData<String>): BookShopViewModelFactory {
        return BookShopViewModelFactory(loadUrl)
    }
}
