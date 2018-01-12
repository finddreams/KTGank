package com.finddreams.ktgrank.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.view.Window
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.utils.setTransparent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by liuxiang on 2017/12/23.
 * 主页
 */
class MainActivity : FragmentActivity() {
    private var curFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) // 无标题栏
        setTransparent()
        setContentView(R.layout.activity_main)
        // 底部tab切换监听
        rg_tab.setOnCheckedChangeListener({ _, checkedId -> switchTab(checkedId) })
        switchTab(R.id.rb_home)
    }


    private fun switchTab(checkedId: Int) {
        val ft = supportFragmentManager.beginTransaction()
        hideAllFragment(ft)
        if (checkedId == R.id.rb_home) {
            var mHomeFragment = supportFragmentManager.findFragmentByTag("home")
            if (mHomeFragment == null) {
                mHomeFragment = AndroidFragment()
                    ft.add(R.id.ll_main, mHomeFragment, "home")
            }
            curFragment = mHomeFragment
        } else if (checkedId == R.id.rb_user) {
            var meizifragment = supportFragmentManager.findFragmentByTag("user")
            if (meizifragment == null) {
                meizifragment = MeiziFragment()
                    ft.add(R.id.ll_main, meizifragment, "user")
            }
            curFragment = meizifragment
        }
        if (curFragment != null) {
            ft.show(curFragment).commit()
        }
    }


    fun hideAllFragment(ft: FragmentTransaction) {
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag("home")
        if (fragment != null) {
            ft.hide(fragment)
        }
        fragment = supportFragmentManager.findFragmentByTag("user")
        if (fragment != null) {
            ft.hide(fragment)
        }

    }
}
