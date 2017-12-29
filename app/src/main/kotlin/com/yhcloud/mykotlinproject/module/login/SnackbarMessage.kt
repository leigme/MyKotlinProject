package com.yhcloud.mykotlinproject.module.login

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.text.TextUtils

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class SnackbarMessage: SingleLiveEvent<String>() {

    fun observe(owner: LifecycleOwner, observer: SnackbarObsever) {
        super.observe(owner, Observer { message ->
            if (TextUtils.isEmpty(message)) {
                return@Observer
            }
            observer.onNewMessage(message!!)
        })
    }

    interface SnackbarObsever {
        fun onNewMessage(message: String)
    }
}