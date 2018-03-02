package com.yhcloud.mykotlinproject.module.chart.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_bar.view.*

/**
 * Created by i on 2017/12/29.
 */

class BarChartFragment : BaseFragment("柱状图") {

    private lateinit var chart: BarChart

    private lateinit var data: BarData

    private lateinit var dataSet: BarDataSet

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bar, container, false)
        chart = view.barChart


//        val entries = mutableListOf<BarEntry>()
//        val xValue = mutableListOf<String>()
//
//        val random = Random()
//
//        for (i in 0 until 12) {
//            val profit = random.nextFloat() * 1000
//            entries.add(BarEntry(i, profit))
//        }

        return view
    }

}