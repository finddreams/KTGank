package com.finddreams.ktgrank.ui

import android.content.Context
import android.content.Intent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.databinding.ActivityWebBinding
/**
 * Created by finddreams on 2017/12/23.
 * webview的
 */
class WebActivity : BaseBindingActivity<ActivityWebBinding>() {
    override fun getBindLayout(): Int {
        return R.layout.activity_web
    }

    override fun initData() {
        val settings = mBinding.webView.settings
        settings.setAppCacheEnabled(true)
        settings.cacheMode=WebSettings.LOAD_DEFAULT
        settings.setSupportZoom(false)
        settings.displayZoomControls=false
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
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra(URL, url)
            context.startActivity(intent)
        }

    }
}
