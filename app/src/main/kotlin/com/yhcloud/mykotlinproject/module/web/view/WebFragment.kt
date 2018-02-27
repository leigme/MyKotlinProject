package com.yhcloud.mykotlinproject.module.web.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.base.BaseFragment
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

    var url: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_web, container, false)

        view.setOnTouchListener(this)

        if ("" == url) {
            print("Url地址为空...")
            return view
        }

        val webSettings = view.wvContent.settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true

        view.wvContent.webViewClient = MyWebViewClient()

        view.wvContent.loadUrl(url)

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

    fun onBackPressed(): Boolean {

        return if (view!!.wvContent.canGoBack()) {
            view!!.wvContent.goBack()
            Log.v("webView.goBack()", "webView.goBack()")
            true

        } else {
            Log.v("Conversatio退出", "Conversatio退出")
            false
        }

    }
}