package com.yhcloud.mykotlinproject.module.book.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.AdaptListener
import com.yhcloud.mykotlinproject.base.BaseFragment
import com.yhcloud.mykotlinproject.module.book.adapter.BookAdapter
import com.yhcloud.mykotlinproject.module.book.bean.BookBean
import com.yhcloud.mykotlinproject.module.web.view.WebFragment
import kotlinx.android.synthetic.main.fragment_viewholder.view.*

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class BookFragment: BaseFragment("我的藏书阁"), AdaptListener {

    private val bookBeans = initBookBeans()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_viewholder, container, false)

        view.setOnTouchListener(this)

        val adapter = BookAdapter(bookBeans, this)

        view.listView.layoutManager = LinearLayoutManager(activity)
        view.listView.adapter = adapter

        return view
    }

    private fun initBookBeans(): List<BookBean> {

        val wf = WebFragment()
        wf.url = "https://array-huang.gitbooks.io/centos-book/content/"

        val centOS = BookBean(0, 0, "", wf, "CentOS")

        return listOf(
                centOS
        )
    }

    override fun onItemClick(view: View, position: Int) {
        println("点击的是${bookBeans[position].title}")
        val fm = fragmentManager
        val ft = fm!!.beginTransaction()
        ft.replace(R.id.fragment, bookBeans[position].fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        return false
    }

}