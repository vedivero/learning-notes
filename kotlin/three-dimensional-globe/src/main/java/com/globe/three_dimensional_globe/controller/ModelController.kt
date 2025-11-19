package com.globe.three_dimensional_globe.controller

import com.globe.three_dimensional_globe.dto.ModelDto
import com.globe.three_dimensional_globe.service.ModelService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/article/model")
class ModelController (
    private val modelService: ModelService
){

    @PostMapping
    fun createModel(
        @RequestPart("file")file: MultipartFile,
        @RequestPart("latitude")latitude: Double,
        @RequestPart("longitude")longitude: Double,
        @RequestPart("height")height: Int,
    ) : ModelDto {
        return modelService.createModel(file, latitude, longitude, height)
    }
}