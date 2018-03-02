package com.yhcloud.mykotlinproject.base.listener

import android.view.View

/**
 * 自定义点击事件回调接口
 *
 * @author leig
 * @version 20170301
 *
 */
 
interface AdaptListener {

    fun onItemClick(view: View, position: Int)

    fun onItemLongClick(view: View, position: Int): Boolean

}