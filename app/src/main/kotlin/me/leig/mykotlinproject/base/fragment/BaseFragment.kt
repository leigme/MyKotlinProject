package me.leig.mykotlinproject.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MotionEvent
import android.view.View

/**
 * 所有的Fragment基类
 *
 * @author leig
 * @version 20170301
 *
 */
 
 abstract class BaseFragment constructor(open var title: String): Fragment(), View.OnTouchListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.setOnTouchListener(this)
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return true
    }
}