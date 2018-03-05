package me.leig.mykotlinproject.module.netty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.base.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class NettyFragment: BaseFragment("Netty") {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_netty, container, false)
        view.setOnTouchListener(this)
        return view
    }

}