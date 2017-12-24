package com.finddreams.ktgrank.di

import com.finddreams.ktgrank.base.App
import com.finddreams.ktgrank.net.GankPersenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by liuxiang on 2017/12/23.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun getApi(): GankPersenter
}