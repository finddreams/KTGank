package com.finddreams.ktgrank.bean

/**
 * Created by finddreams on 2017/12/23.
 */
data class GankResponse(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String

){
    fun hasImg():Boolean {
        return true
    }
    fun create() = createdAt.substring(0,10)

}