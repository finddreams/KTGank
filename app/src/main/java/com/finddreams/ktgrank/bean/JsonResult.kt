package com.finddreams.ktgrank.bean

/**
 * Created by finddreams on 2017/12/23.
 * 通用json封装
 */
class JsonResult<T>(val error :Boolean,
                    val results:T)
