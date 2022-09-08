package com.mediconear.specializationtypelib.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiSpecializationTypeRequest(
    @Json(name = "specijalnost_id")
    val typeId: Int,
    @Json(name = "tip")
    val type: String
)
