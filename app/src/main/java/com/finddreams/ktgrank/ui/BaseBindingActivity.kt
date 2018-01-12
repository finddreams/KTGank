package com.finddreams.ktgrank.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.Window
import com.finddreams.ktgrank.utils.setTransparent

/**
 * Created by finddreams on 2017/12/23.
 * basebinding
 */
abstract class BaseBindingActivity<B : ViewDataBinding> : FragmentActivity() {


    lateinit var mBinding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // 无标题栏
        setTransparent()
        mBinding = DataBindingUtil.setContentView(this,getBindLayout())
        initData()
    }

    abstract fun initData()

    abstract fun getBindLayout(): Int


}