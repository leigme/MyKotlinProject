package com.yhcloud.mykotlinproject

import android.view.View

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
interface MainListListener {

    fun onItemClick(view: View, position: Int)

    fun onItemLongClick(view: View, position: Int): Boolean

}