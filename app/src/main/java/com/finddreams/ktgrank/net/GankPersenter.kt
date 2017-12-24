package com.finddreams.ktgrank.net

import com.finddreams.ktgrank.bean.GankResponse
import com.finddreams.ktgrank.bean.JsonResult
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Call
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by liuxiang on 2017/12/23.
 */
class GankPersenter @Inject
constructor(private val api: KTGankApi) {
    fun getAndroid(page: Int): Observable<JsonResult<ArrayList<GankResponse>>> {

        return api.getAndroidData(page)
    }

    fun getMeizi(page: Int): Observable<JsonResult<ArrayList<GankResponse>>> {
        return api.getGirlData(page)
    }
}