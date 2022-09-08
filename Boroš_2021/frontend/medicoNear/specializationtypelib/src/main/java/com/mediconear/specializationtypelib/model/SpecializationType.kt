package com.mediconear.specializationtypelib.model

import com.mediconear.coreui.utils.DiffUtilViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecializationType(
    @Json(name = "specijalnost_id")
    val typeId: Int,
    @Json(name = "tip")
    val type: String
): DiffUtilViewModel(typeId) {

    companion object {
        val EMPTY = SpecializationType(0, "Select medical speciality:")
    }

    fun toRequest(): ApiSpecializationTypeRequest =
        ApiSpecializationTypeRequest(typeId, type)
}
