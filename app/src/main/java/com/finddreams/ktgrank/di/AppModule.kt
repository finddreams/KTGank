package com.finddreams.ktgrank.di

import com.finddreams.ktgrank.net.KTGankApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by liuxiang on 2017/12/23.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient)=

        Retrofit.Builder()
                .client(client)
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()


    @Provides
    fun provideOkhttp() =
            OkHttpClient.Builder()
                    .build()


    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(KTGankApi::class.java)

}