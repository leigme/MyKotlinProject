package com.yhcloud.mykotlinproject

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yhcloud.mykotlinproject.module.chart.ChartFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainFragment : Fragment(), MainListListener {

    private val functions = getFunction()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.listView.layoutManager = LinearLayoutManager(activity)
        view.listView.adapter = MainAdapter(functions, this)

        return view
    }

    private fun getFunction(): List<FunctionBean> {
        return listOf(
                FunctionBean(0, "安卓图表示例")
        )
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        Toast.makeText(activity, "点击了第[$position]个按钮, 标题是:${functions[position].title}", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(activity, "点击了第[$position]个按钮", Toast.LENGTH_SHORT).show()
        val fm = fragmentManager
        fm!!.popBackStack()
        val ft = fm!!.beginTransaction()
        ft.addToBackStack(null)
        ft.replace(R.id.fragment, ChartFragment())
        ft.commit()
    }
}
