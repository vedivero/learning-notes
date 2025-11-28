package com.globe.three_dimensional_globe.controller

import com.globe.three_dimensional_globe.dto.ModelDto
import com.globe.three_dimensional_globe.service.ModelService
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream

@RestController
@RequestMapping("/article/model")
class ModelController (
    private val modelService: ModelService
){

    @PostMapping
    fun createModel(
        @RequestPart("file")file: MultipartFile,
        @RequestParam("latitude")latitude: Double,
        @RequestParam("longitude")longitude: Double,
        @RequestParam("height")height: Int,
    ) : ModelDto {
        return modelService.createModel(file, latitude, longitude, height)
    }

    @GetMapping
    fun findModelById(
        @PathVariable id: Long
    ): ResponseEntity<InputStreamResource>{
        val result = modelService.findModelById(id)
        return return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=\"${result.second}\"")
            .contentType(MediaType.parseMediaType("model/gltf-binary"))
            .body(result.first)
    }
}