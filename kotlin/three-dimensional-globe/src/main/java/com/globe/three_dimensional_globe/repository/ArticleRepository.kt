package com.globe.three_dimensional_globe.repository

import com.globe.three_dimensional_globe.entity.ArticleEntity
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<ArticleEntity, Long> {

}