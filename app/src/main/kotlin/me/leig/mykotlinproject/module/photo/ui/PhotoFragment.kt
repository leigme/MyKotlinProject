package me.leig.mykotlinproject.module.photo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_photo.view.*
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.base.fragment.BaseFragment
import java.util.*

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class PhotoFragment: BaseFragment("照片墙"), View.OnClickListener {

    private lateinit var photoView: View

    private var btnStartTime = false

    private var btnEndTime = false

    private var startTime: String = ""

    private var endTime: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        photoView = inflater.inflate(R.layout.fragment_photo, container, false)

        val cal = Calendar.getInstance()

        cal.time = Date()

        // 获取年份
        val year = cal.get(Calendar.YEAR)
        // 获取月份
        val month = cal.get(Calendar.MONTH) + 1
        // 获取日
        val day = cal.get(Calendar.DATE)

        photoView.tv_starttime.text = "开始时间: ${stringTime(year, month, day)}"
        photoView.tv_starttime.setOnClickListener(this)

        photoView.tv_endtime.text = "结束时间: ${stringTime(year, month, day)}"
        photoView.tv_endtime.setOnClickListener(this)

        photoView.btn_submit.setOnClickListener(this)
        photoView.dp_time.init(year, month, day, { view, year, month, day ->
            view.visibility = View.GONE

            if (btnStartTime && !btnEndTime) {
                startTime = stringTime(year, month + 1, day)
                photoView.tv_starttime.text = "开始时间: $startTime"
            } else if (!btnStartTime && btnEndTime) {
                endTime = stringTime(year, month + 1, day)
                photoView.tv_endtime.text = "结束时间: $endTime"
            }

            Log.e("TAG", "年: $year")
            Log.e("TAG", "月: $month")
            Log.e("TAG", "日: $day")
        })

        return photoView
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.tv_starttime -> {
                btnStartTime = true
                btnEndTime = false
                photoView.dp_time.visibility = View.VISIBLE
            }
            R.id.tv_endtime -> {
                btnStartTime = false
                btnEndTime = true
                photoView.dp_time.visibility = View.VISIBLE
            }
            R.id.btn_submit -> {
                Log.e("TAG", "请求数据去了...[$startTime] [$endTime]")
            }
            else -> {

            }
        }
    }

    private fun stringTime(year: Int, month: Int, day: Int): String {

        val m: String = if (10 > month) {
            "0$month"
        } else {
            "$month"
        }

        val d: String = if (10 > day) {
            "0$day"
        } else {
            "$day"
        }

        return "$year-$m-$d"
    }

}