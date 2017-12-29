package com.yhcloud.mykotlinproject.module.login

import android.arch.lifecycle.ViewModelProvider
import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.support.annotation.VisibleForTesting
import com.yhcloud.mykotlinproject.module.login.data.LoginModel


/**
 * Kotlin单例工厂模式
 *
 * @author leig
 * @version 20170301
 *
 */
 
class ViewModelFactory(private val application: Application): ViewModelProvider.NewInstanceFactory() {

    /**
     * 伴生对象
     * 定义单例工厂模式
     *
     */
    companion object {

        @SuppressLint("StaticFieldLeak")
        private var vmf: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory {
            if(null == vmf) vmf = ViewModelFactory(application)
            return vmf!!
        }

        @VisibleForTesting
        fun destroyInstance() {
            vmf = null
        }


    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginModel::class.java)) {
            return LoginModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}