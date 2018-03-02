package com.yhcloud.mykotlinproject.base.view.web

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_web.view.*
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class WebFragment: BaseFragment("HTML5页面") {

    lateinit var webBean: WebBean

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_web, container, false)

        view.setOnTouchListener(this)

        if (0 == webBean.type) {
            print("类型设置错误...")
            return view
        }

        val webSettings = view.wvContent.settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true

        view.wvContent.webViewClient = MyWebViewClient()

        when (webBean.type) {
            1 -> {
                view.wvContent.loadUrl(webBean.content)
            }
            2 -> {
                view.wvContent.loadDataWithBaseURL(null, webBean.content, "text/html", "utf-8", null)
            }
            else -> {
                print("类型设置无效...")
                return view
            }
        }

        return view
    }

    private inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            //    return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, errorCode: Int,
                                     description: String, failingUrl: String) {
            //     super.onReceivedError(view, errorCode, description, failingUrl);
            //  Toast.makeText(this,"网页加载错误！",0).show();
        }
    }
}