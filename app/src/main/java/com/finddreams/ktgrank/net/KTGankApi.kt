package com.finddreams.ktgrank.net

import com.finddreams.ktgrank.bean.GankResponse
import com.finddreams.ktgrank.bean.JsonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

/**
 * Created by liuxiang on 2017/12/23.
 */
interface KTGankApi {

    /**
     * Android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int): Observable<JsonResult<ArrayList<GankResponse>>>

    /**
     * 福利所有数据
     */
    @GET("data/福利/15/{page}")
    fun getGirlData(@Path("page") page:Int):Observable<JsonResult<ArrayList<GankResponse>>>

    /**
     * 手气不错
     */

    @GET("random/data/{type}/1")
    fun getRandom(@Path("type") type:String):Observable<JsonResult<ArrayList<GankResponse>>>
}