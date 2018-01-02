package com.yhcloud.mykotlinproject.module.chart.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.BaseFragment
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.AdaptListener
import com.yhcloud.mykotlinproject.module.chart.adapter.ChartAdapter
import com.yhcloud.mykotlinproject.module.chart.bean.ChartBean
import kotlinx.android.synthetic.main.fragment_chart.*
import kotlinx.android.synthetic.main.fragment_chart.view.*

/**
 * 图表列表页面
 *
 * @author leig
 * @version 20170301
 *
 */
 
class ChartFragment: BaseFragment("安卓图表示例"), AdaptListener {

    private val chartBeans = initChartBeans()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_chart, container, false)

        view.setOnTouchListener(this)

        val adapter = ChartAdapter(chartBeans, this)

        view.rvChart.layoutManager = GridLayoutManager(activity, 3)
        view.rvChart.adapter = adapter

        return view
    }

    private fun initChartBeans(): List<ChartBean> {
        return listOf(
                ChartBean(0, 0, "", BarChartFragment(), "雷达图"),
                ChartBean(1, 0, "", BarChartFragment(), "散点图"),
                ChartBean(2, 0, "", LineChartFragment(), "折线图"),
                ChartBean(3, 0, "", BarChartFragment(), "饼状图"),
                ChartBean(4, 0, "", BarChartFragment(), "柱状图")
        )
    }

    override fun onItemClick(view: View, position: Int) {
        println("点击的是${chartBeans[position].title}")
        val fm = fragmentManager
        val ft = fm!!.beginTransaction()
        ft.replace(R.id.fragment, chartBeans[position].fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        return false
    }
}