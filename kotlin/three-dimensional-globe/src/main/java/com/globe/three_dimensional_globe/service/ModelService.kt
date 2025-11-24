package com.globe.three_dimensional_globe.service

import com.globe.three_dimensional_globe.dto.ModelDto
import com.globe.three_dimensional_globe.entity.ModelEntity
import com.globe.three_dimensional_globe.repository.ModelRepository
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.awt.PageAttributes
import java.io.File
import java.util.UUID

@Service
class ModelService(
    private val modelRepository: ModelRepository
) {
    fun createModel(file: MultipartFile, latitude: Double, longitude: Double, height: Int): ModelDto {
        val uploadDir = File(System.getProperty("user.dir"), "models")

        if (!uploadDir.exists()) {
            uploadDir.mkdir()
        }

        val filename = file.originalFilename ?: "${UUID.randomUUID()}.glb"
        val destfile = File(uploadDir, filename)

        file.transferTo(destfile)

        val modelEntity = ModelEntity(
            filename = filename,
            filePath = destfile.absolutePath,
            latitude = latitude,
            longitude = longitude,
            height = height
        )

        val savedModelEntity = modelRepository.save(modelEntity)

        return ModelDto(
            id = savedModelEntity.id!!,
            filename = savedModelEntity.filename,
            filePath = savedModelEntity.filePath,
            latitude = savedModelEntity.latitude,
            longitude = savedModelEntity.longitude,
            height = savedModelEntity.height
        )
    }

    fun findModelById(id: Long): Pair<InputStreamResource, String> {
        val modelEntity = modelRepository.findById(id)
        val file = File(modelEntity.get().filePath)
        if(!file.exists()){
            throw RuntimeException("File path doesn't exist ${modelEntity.get().filePath}")
        }
        return Pair(InputStreamResource(file.inputStream()),file.name)
    }

}
