package com.yhcloud.mykotlinproject.module.login.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.BaseFragment
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.databinding.FragmentLoginBinding
import com.yhcloud.mykotlinproject.module.login.ViewModelFactory
import com.yhcloud.mykotlinproject.module.login.data.LoginModel
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * MVVM模式的登录页面
 *
 * @author leig
 * @version 20170301
 *
 */
 
class LoginFragment: BaseFragment("登录页面") {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val factory = ViewModelFactory.getInstance(activity!!.application)

        val loginModel = ViewModelProviders.of(this, factory).get(LoginModel::class.java)

        val binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.root.setOnTouchListener(this)

        binding.viewmodel = loginModel

        loginModel.mOpenUserList.observe(this, Observer { message ->
            println("点击的内容是: $message")
        })

        loginModel.mSnackbarText.observe(this, Observer { message ->

        })

        binding.submit.setOnClickListener{ _ ->
            loginModel.login()
        }

        return binding.root
    }
}