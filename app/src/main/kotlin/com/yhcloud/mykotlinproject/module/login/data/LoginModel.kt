package com.yhcloud.mykotlinproject.module.login.data

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import android.support.design.widget.Snackbar
import android.text.TextUtils
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.module.login.SingleLiveEvent
import com.yhcloud.mykotlinproject.module.login.SnackbarMessage

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class LoginModel(application: Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext

    private val mOpenUserList: SingleLiveEvent<String> = SingleLiveEvent()
    private val mSnackbarText = SnackbarMessage()

    open val loginName = ObservableField<String>()
    open val loginPass = ObservableField<String>()


    private fun login(loginName: String, loginPass: String) {

        if (TextUtils.isEmpty(loginName)) {
            mSnackbarText.value = mContext.getString(R.string.login_name_not_input)
            return
        }
        if (TextUtils.isEmpty(loginPass)) {
            mSnackbarText.value = mContext.getString(R.string.login_pass_not_input)
            return
        }

        mOpenUserList.setValue("123456");

    }

    fun login() {
        login(loginName.get(), loginPass.get())
    }


}
 
 