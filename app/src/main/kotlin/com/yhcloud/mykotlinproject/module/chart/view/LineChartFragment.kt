package com.yhcloud.mykotlinproject.module.chart.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_line.view.*
import com.github.mikephil.charting.components.Legend.LegendForm
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.EntryXComparator
import java.util.*

/**
 * 折线图示例
 *
 * @author leig
 * @version 20170301
 *
 */
 
class LineChartFragment: BaseFragment("折线图") {

    private lateinit var chart: LineChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_line, container, false)

        chart = view.lineChart

        initChart(chart)

        return view
    }

    private fun initChart(chart: LineChart) {

        initDataStyle(chart)

        val xValues = (0..14).map { "" + it }

        val yValues = mutableListOf<Entry>()
        yValues.add(Entry(13f, 1f))
        yValues.add(Entry(6f, 2f))
        yValues.add(Entry(3f, 3f))
        yValues.add(Entry(7f, 4f))
        yValues.add(Entry(2f, 5f))
        yValues.add(Entry(5f, 6f))
        yValues.add(Entry(12f, 7f))

        // 数据绘制之前先排序
        Collections.sort(yValues, EntryXComparator())

//        val yValue1s = ArrayList()
//        yValue1.add(Entry(17f, 1f))
//        yValue1.add(Entry(3f, 2f))
//        yValue1.add(Entry(5f, 3f))
//        yValue1.add(Entry(4f, 4f))
//        yValue1.add(Entry(3f, 5f))
//        yValue1.add(Entry(7f, 6f))
//        yValue1.add(Entry(10f, 7f))

        val dataSet = LineDataSet(yValues, title)

        dataSet.color = Color.RED
        dataSet.setCircleColor(Color.RED)
        dataSet.setDrawValues(false)

        val dataSets = mutableListOf<ILineDataSet>()

        dataSets.add(dataSet)

        val lineData = LineData(dataSets)

        chart.data = lineData

        chart.animateY(2000, Easing.EasingOption.Linear)
        chart.animateX(2000, Easing.EasingOption.Linear)

        chart.invalidate()

    }

    private fun initDataStyle(chart: LineChart) {

        chart.setTouchEnabled(true)
        chart.setScaleEnabled(false)

        val titleLegend = chart.legend

        titleLegend.form = LegendForm.LINE

        val xAxis = chart.xAxis

        xAxis.position = XAxis.XAxisPosition.BOTTOM

        xAxis.axisLineColor = Color.parseColor("#66CDAA")
        xAxis.axisLineWidth = 5f

        xAxis.setDrawGridLines(false)

        xAxis.isEnabled = true

        val yAxisLeft = chart.axisLeft
        yAxisLeft.axisLineColor = Color.parseColor("#66CDAA")
        yAxisLeft.axisLineWidth = 5f
        yAxisLeft.setDrawGridLines(false)

        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false


    }

}