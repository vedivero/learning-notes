package com.globe.three_dimensional_globe.dto

data class ModelDto(
    val id: Long,
    val filename: String,
    val filePath: String,
    val latitude: Double,
    val longitude: Double,
    val height: Int,
)
