package com.yhcloud.mykotlinproject.module.login

import android.arch.lifecycle.ViewModelProvider
import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import com.yhcloud.mykotlinproject.module.login.data.LoginModel


/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class ViewModelFactory(application: Application): ViewModelProvider.NewInstanceFactory() {

    @Volatile private var INSTANCE: ViewModelFactory? = null

    private var mApplication: Application = application

    fun getInstance(application: Application): ViewModelFactory {

        if (INSTANCE == null) {
            synchronized(ViewModelFactory::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = ViewModelFactory(this.mApplication)
                }
            }
        }
        return this.INSTANCE!!
    }

    @VisibleForTesting
    fun destroyInstance() {
        INSTANCE = null
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginModel::class.java)) {

            return LoginModel(this.mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}