package com.yhcloud.mykotlinproject.module.function

import com.yhcloud.mykotlinproject.base.BaseFragment

/**
 * 功能数据对象
 *
 * @author leig
 * @version 20170301
 *
 */
 
data class FunctionBean(
        val id: Int,
        val fragment: BaseFragment,
        val title: String = fragment.title
)