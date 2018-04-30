package com.finddreams.ktgrank.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.ImageView
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.databinding.ActivityImageBinding
import com.finddreams.ktgrank.utils.screenHeight
import com.finddreams.ktgrank.utils.toast
/**
 * Created by finddreams on 2017/12/23.
 * 图片显示
 */
class ImageActivity : BaseBindingActivity<ActivityImageBinding>() {
    override fun initData() {
        mBinding.url = intent.getStringExtra(IMG)

        mBinding.photoView.setOnClickListener {

            supportFinishAfterTransition()
        }
        val last = with("name") {
            last()
        }
    }

    override fun getBindLayout(): Int {
        return R.layout.activity_image
    }

    companion object {
        val IMG = "IMG"
        fun startActivity(context: Context, imageView: ImageView, url: String) {
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra(IMG, url)
            if (Build.VERSION.SDK_INT > 21) {
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity, imageView, "img").toBundle())
            } else {
                context.startActivity(intent)
            }
        }

    }
}
