package me.leig.mykotlinproject.base.activity

import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
abstract class BaseActivity: AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        Log.v("onBack", "点击物理返回执行退出")
    }

}