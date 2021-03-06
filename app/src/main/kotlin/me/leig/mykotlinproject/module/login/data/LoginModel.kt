package me.leig.mykotlinproject.module.login.data

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import android.text.TextUtils
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.module.login.SingleLiveEvent
import me.leig.mykotlinproject.module.login.SnackbarMessage

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class LoginModel(application: Application): AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val mContext = application.applicationContext

    val mOpenUserList: SingleLiveEvent<String> = SingleLiveEvent()
    val mSnackbarText = SnackbarMessage()

    val loginName = ObservableField<String>()
    val loginPass = ObservableField<String>()

    private fun login(loginName: String, loginPass: String) {

        if (TextUtils.isEmpty(loginName)) {
            mSnackbarText.value = mContext.getString(R.string.login_name_not_input)
            return
        }
        if (TextUtils.isEmpty(loginPass)) {
            mSnackbarText.value = mContext.getString(R.string.login_pass_not_input)
            return
        }

        mOpenUserList.value = loginName
        mSnackbarText.value = loginName

    }

    fun login() {
        if (null != loginName.get() && null != loginPass.get()) {
            login(loginName.get(), loginPass.get())
            println("用户账号是: ${loginName.get()},用户密码是: ${loginPass.get()}")
        }
    }
}
 
 