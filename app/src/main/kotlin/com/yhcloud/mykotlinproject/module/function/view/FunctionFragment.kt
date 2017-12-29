package com.yhcloud.mykotlinproject.module.function.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.AdaptListener
import com.yhcloud.mykotlinproject.base.BaseFragment
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.module.chart.view.ChartFragment
import com.yhcloud.mykotlinproject.module.function.adapter.FunctionAdapter
import com.yhcloud.mykotlinproject.module.function.bean.FunctionBean
import com.yhcloud.mykotlinproject.module.login.view.LoginFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * 功能列表Fragment
 *
 * @author leig
 * @20170301
 *
 */
class FunctionFragment : BaseFragment("功能列表"), AdaptListener {

    private val functions = getFunction()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.listView.layoutManager = LinearLayoutManager(activity)
        view.listView.adapter = FunctionAdapter(functions, this)

        return view
    }

    private fun getFunction(): List<FunctionBean> {
        return listOf(
                FunctionBean(0, LoginFragment()),
                FunctionBean(1, ChartFragment())
        )
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        return false
    }

    override fun onItemClick(view: View, position: Int) {
        val fm = fragmentManager
        fm!!.popBackStack()
        val ft = fm.beginTransaction()
        ft.addToBackStack(null)
        ft.replace(R.id.fragment, functions[position].fragment)
        ft.commit()
    }
}
