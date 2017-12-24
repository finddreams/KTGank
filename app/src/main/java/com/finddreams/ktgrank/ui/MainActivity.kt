package com.finddreams.ktgrank.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import com.finddreams.ktgrank.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    private var curFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 底部tab切换监听
        rg_tab.setOnCheckedChangeListener({ group, checkedId -> switchTab(checkedId) })
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
        var fragment: Fragment?
        fragment = supportFragmentManager.findFragmentByTag("home")
        if (fragment != null) {
            ft.hide(fragment)
        }
        fragment = supportFragmentManager.findFragmentByTag("user")
        if (fragment != null) {
            ft.hide(fragment)
        }

    }
}
