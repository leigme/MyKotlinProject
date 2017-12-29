package com.yhcloud.mykotlinproject.module.login.utils

import android.support.design.widget.Snackbar
import android.view.View

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class SnackbarUtils {
    /**
     * 静态方法包裹对象
     */
    companion object {

        /**
         * @JvmStatic 注解表示方法为静态方法
         */
        @JvmStatic fun showSnackbar(view: View, snackbarText: String) {
            Snackbar.make(view, snackbarText, Snackbar.LENGTH_LONG).show()
        }
    }
}