package me.leig.mykotlinproject.module.answer.view

import android.os.Bundle
import android.os.Handler
import android.os.Handler.Callback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_anwser.view.*
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.base.fragment.BaseFragment
import me.leig.mykotlinproject.base.tool.Time
import kotlin.concurrent.thread

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class AnswerFragment: BaseFragment("抢答"), View.OnClickListener {

    lateinit var answerView: View

    private val mHandler = Handler(Callback {

        when (it.what) {
            1001 -> {
                val s = it.obj as Int
                view!!.tv_time.text = s.toString()
            }
            else -> {

            }
        }

        return@Callback false
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        answerView = inflater.inflate(R.layout.fragment_anwser, container, false)

        answerView.btn_answer.setOnClickListener(this)

        return answerView
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_answer -> {
                var time = 5
                if (null != answerView.et_time
                        && null != answerView.et_time.text
                        && "" != answerView.et_time.text.toString()) {
                    time = answerView.et_time.text.toString().toInt()
                }
                answer(time)
            }
            else -> {

            }
        }
    }

    private fun answer(num: Int) {

        var showTime = num

        val time = Time()

        val answerTime = time.addTime(showTime)

        thread(start = true) {
            while (showTime != 0) {
                mHandler.obtainMessage(1001, showTime).sendToTarget()
                showTime = time.subTime(endTime = answerTime).toInt()
                Thread.sleep(1000)
            }
        }
    }
}