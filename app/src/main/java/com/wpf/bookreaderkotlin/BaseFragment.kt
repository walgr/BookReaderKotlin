package com.wpf.bookreaderkotlin

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.wpf.bookreaderkotlin.mvp.iview.BaseViewIView


/**
 * 基础Fragment
 * @author 王朋飞
 */
open class BaseFragment : Fragment(), BaseViewIView {

    override fun getBaseActivity(): Activity {
        return activity as Activity
    }

    override fun showToastMsg(msg: String) {
        Toast.makeText(getBaseActivity(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun showSnackBarMsg(view: View?, msg: String) {
        if(null != view) {
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
        }
    }
}