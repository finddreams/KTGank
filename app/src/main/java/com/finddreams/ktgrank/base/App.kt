package com.finddreams.ktgrank.base

import android.app.Application
import com.finddreams.ktgrank.di.AppComponent
import com.finddreams.ktgrank.di.AppModule
import com.finddreams.ktgrank.di.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by liuxiang on 2017/12/23.
 */
class App : Application() {

    @Inject lateinit var appComponent: AppComponent

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
     DaggerAppComponent.builder().appModule(AppModule()).build().inject(this)
    }
    companion object {
        lateinit var instance: App
    }

}