/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-18 16:03
 * Description: 基础Activity(Iview实现)
 */
package com.wpf.bookreaderkotlin

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.wpf.bookreaderkotlin.mvp.iview.BaseActivityIView

open class BaseActivity: AppCompatActivity(),
    BaseActivityIView {

    override fun getBaseActivity(): Activity {
        return this
    }

    override fun showToastMsg(msg: String) {
        Toast.makeText(getBaseActivity(),msg,Toast.LENGTH_SHORT).show()
    }

    override fun showSnackBarMsg(view: View?, msg: String) {
        if(null != view) {
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
        }
    }
}