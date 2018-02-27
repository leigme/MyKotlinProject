package com.yhcloud.mykotlinproject.module.book.bean

import com.yhcloud.mykotlinproject.base.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

data class BookBean(
        val id: Int,
        val imageId: Int,
        val imageUrl: String,
        val fragment: BaseFragment,
        val title: String = fragment.title
)