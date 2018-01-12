package com.finddreams.ktgrank.ui


import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.finddreams.ktgrank.R
/**
 * Created by finddreams on 2017/12/23.
 * baseFragment
 */
abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    protected lateinit var mBinding: B
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getBindLayoutId(), container, false)
        return mBinding.root
    }

    abstract fun getBindLayoutId(): Int
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()

    }
    abstract fun initData()

}
