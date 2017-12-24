package com.finddreams.ktgrank.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

/**
 * Created by wing on 16-11-24.
 */
abstract class BaseBindingActivity<B : ViewDataBinding> : AppCompatActivity() {


    lateinit var mBinding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,getBindLayout())
        initData()
    }

    abstract fun initData()

    abstract fun getBindLayout(): Int


}