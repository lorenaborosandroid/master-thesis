package com.mediconear.specializationtypelib.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiSpecializationTypes(
    @Json(name = "types")
    val types: List<SpecializationType>
)
