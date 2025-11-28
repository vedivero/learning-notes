package com.globe.three_dimensional_globe.service

import com.globe.three_dimensional_globe.dto.ArticleRequest
import com.globe.three_dimensional_globe.dto.ArticleResponse
import com.globe.three_dimensional_globe.entity.ArticleEntity
import com.globe.three_dimensional_globe.repository.ArticleRepository
import com.globe.three_dimensional_globe.repository.ModelRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val modelRepository: ModelRepository
) {
    fun createArticle(articleRequest: ArticleRequest): ArticleResponse {
        val modelEntity = modelRepository.findById(articleRequest.modelId)
            .orElseThrow { IllegalArgumentException("Model not found. id=${articleRequest.modelId}") }

        val articleEntity = ArticleEntity(
            title = articleRequest.title,
            content = articleRequest.content,
            imgUrl = articleRequest.imgUrl,
            modelEntity = modelEntity.get()
        )

        val savedArticleEntity = articleRepository.save(articleEntity)

        return ArticleResponse(savedArticleEntity)

    }

    fun findAll(): List<ArticleResponse> {
        return articleRepository.findAll().map{
            ArticleResponse(it)
        }
    }
}