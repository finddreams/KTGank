package com.finddreams.ktgrank.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.databinding.ActivityWebBinding

class WebActivity : BaseBindingActivity<ActivityWebBinding>() {
    override fun getBindLayout(): Int {
        return R.layout.activity_web
    }

    override fun initData() {
        mBinding.webView.loadUrl(intent.getStringExtra(URL))
        mBinding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

    }

    companion object {
        val URL = "url"
        fun startActivity(context: Context, url: String) {
            val intent = Intent(context, WebActivity.javaClass)
            intent.putExtra(URL, url)
            context.startActivity(intent)
        }

    }
}
