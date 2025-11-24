package com.globe.three_dimensional_globe.dto

import com.globe.three_dimensional_globe.entity.ArticleEntity

data class ArticleResponse(
    val title: String,
    val content:String,
    val imgUrl:String,
    val modelDto: ModelDto
){
    constructor(articleEntity: ArticleEntity):this(
        articleEntity.title,
        articleEntity.content,
        articleEntity.imgUrl,
        ModelDto(
            id = articleEntity.modelEntity.id!!,
            filename = articleEntity.modelEntity.filename,
            filePath = articleEntity.modelEntity.filePath,
            latitude = articleEntity.modelEntity.latitude,
            longitude = articleEntity.modelEntity.longitude,
            height = articleEntity.modelEntity.height
        )
    )
}
