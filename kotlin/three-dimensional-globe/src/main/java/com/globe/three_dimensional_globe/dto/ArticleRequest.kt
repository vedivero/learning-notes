package com.globe.three_dimensional_globe.dto

data class ArticleRequest(
    val title:String,
    val content:String,
    val imgUrl:String,
    val modelId: Long
)
