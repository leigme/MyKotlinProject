package com.yhcloud.mykotlinproject.module.chart.bean

import com.yhcloud.mykotlinproject.base.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
data class ChartBean(
        val id: Int,
        val imageId: Int,
        val imageUrl: String,
        val fragment: BaseFragment,
        val title: String = fragment.title
)