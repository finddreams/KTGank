package com.finddreams.ktgrank.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by liuxiang on 2017/12/23.
 */
fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}
//Fragment
fun Fragment.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    when (length) {
        Toast.LENGTH_SHORT ->Toast.makeText(context, msg, length).show()

        Toast.LENGTH_LONG -> Toast.makeText(context, msg, length).show()
    }
}
/**
 * screen width in pixels
 */
val Context.screenWidth
    get() = resources.displayMetrics.widthPixels

/**
 * screen height in pixels
 */
val Context.screenHeight
    get() = resources.displayMetrics.heightPixels

/**
 * returns dip(dp) dimension value in pixels
 * @param value dp
 */
fun Context.dip2px(value: Int): Int = (value * resources.displayMetrics.density).toInt()