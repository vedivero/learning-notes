package com.globe.three_dimensional_globe.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ModelEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val filename: String,
    val filePath: String,
    val latitude: Double,
    val longitude: Double,
    val height: Int
)
