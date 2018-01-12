package com.finddreams.ktgrank.utils

import android.app.Activity
import android.content.Context
import android.databinding.BindingAdapter
import android.os.Build
import android.support.v4.app.Fragment
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * Created by finddreams on 2017/12/23.
 * 拓展函数
 */
fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

//Fragment
fun Fragment.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    when (length) {
        Toast.LENGTH_SHORT -> Toast.makeText(context, msg, length).show()

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

/**
 * 让状态栏透明
 */
fun Activity.setTransparent(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        var window: Window? = null
        window = this.window            // Translucent status bar
        if (window != null)
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        return true
    }
    return false
}
@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, url: String?) =
        Glide.with(imageView.context).load(url)
                .into(imageView)




@BindingAdapter("load_asset")
fun loadAsset(imageView: ImageView, id:Int) =
        Glide.with(imageView.context).load(id).into(imageView)