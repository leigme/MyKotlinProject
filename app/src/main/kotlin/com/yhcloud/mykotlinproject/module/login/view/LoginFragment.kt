package com.yhcloud.mykotlinproject.module.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.BaseFragment
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.module.login.ViewModelFactory

/**
 * MVVM模式的登录页面
 *
 * @author leig
 * @version 20170301
 *
 */
 
class LoginFragment: BaseFragment("登录页面") {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.setOnTouchListener(this)

        val factory = ViewModelFactory

        return view
    }
}