package me.leig.mykotlinproject.module.function.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.leig.mykotlinproject.base.listener.AdaptListener
import me.leig.mykotlinproject.base.fragment.BaseFragment
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.module.book.view.BookFragment
import me.leig.mykotlinproject.module.chart.view.ChartFragment
import me.leig.mykotlinproject.module.function.adapter.FunctionAdapter
import me.leig.mykotlinproject.module.function.bean.FunctionBean
import me.leig.mykotlinproject.module.login.view.LoginFragment
import kotlinx.android.synthetic.main.fragment_main.view.*
import me.leig.mykotlinproject.module.answer.view.AnswerFragment
import me.leig.mykotlinproject.module.download.view.DownloadFragment
import me.leig.mykotlinproject.module.photo.ui.PhotoFragment

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

    // 列表页数据
    private fun getFunction(): List<FunctionBean> {
        return listOf(
                FunctionBean(0, LoginFragment()),
                FunctionBean(1, BookFragment()),
                FunctionBean(2, ChartFragment()),
                FunctionBean(3, DownloadFragment()),
                FunctionBean(4, AnswerFragment()),
                FunctionBean(5, PhotoFragment())
        )
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        return false
    }

    override fun onItemClick(view: View, position: Int) {
        val fm = fragmentManager
        val ft = fm!!.beginTransaction()
        ft.replace(R.id.fragment, functions[position].fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

}
