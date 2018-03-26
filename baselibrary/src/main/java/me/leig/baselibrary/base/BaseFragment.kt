/**********************************************************************
 *	湖南长沙阳环科技实业有限公司
 *    @Copyright (c) 2003-2017 yhcloud, Inc. All rights reserved.
 *
 *	This copy of Ice is licensed to you under the terms described in the
 *	ICE_LICENSE file included in this distribution.
 *
 *	@license http://www.yhcloud.com.cn/license/
 **********************************************************************/
package me.leig.baselibrary.base

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 *
 *
 *
 * @author Leig
 * @version 20180301
 *
 */

abstract class BaseFragment: Fragment(), View.OnClickListener, View.OnTouchListener, BaseInterface {

    lateinit var mView: View

    private val mHandler = Handler()

    private val toast = Toast.makeText(activity, "", Toast.LENGTH_SHORT)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mView = inflater.inflate(getLayoutId(), container, false)
        mView.setBackgroundColor(Color.WHITE)
        mView.setOnTouchListener(this)
        initData()
        initView()
        initEvent()
        return mView
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return true
    }

    /**
     * 简单打印
     *
     */
    fun log(msg: String) {
        Log.i(getClassTag(), msg)
    }

    /**
     * 简单吐司
     *
     */
    fun toast(msg: String) {
        toast.setText(msg)
        toast.show()
    }
}