package com.globe.three_dimensional_globe.repository

import com.globe.three_dimensional_globe.entity.ModelEntity
import org.springframework.data.repository.CrudRepository

interface ModelRepository : CrudRepository<ModelEntity, Long> {

}