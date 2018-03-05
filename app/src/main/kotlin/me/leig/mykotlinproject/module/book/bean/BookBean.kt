package me.leig.mykotlinproject.module.book.bean

import me.leig.mykotlinproject.base.fragment.BaseFragment

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