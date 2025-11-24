package com.globe.three_dimensional_globe.controller

import com.globe.three_dimensional_globe.dto.ArticleRequest
import com.globe.three_dimensional_globe.dto.ArticleResponse
import com.globe.three_dimensional_globe.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController(
    private val articleService: ArticleService
) {

    @PostMapping
    fun createArticle(
        @RequestBody articleRequest:ArticleRequest
    ): ArticleResponse{
        return articleService.createArticle(articleRequest)
    }

    @GetMapping
    fun findAll(): List<ArticleResponse> {
        return articleService.findAll()
    }

}