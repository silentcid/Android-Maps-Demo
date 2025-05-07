package com.bottlerocketstudios.mapsdemo.data.model

import com.bottlerocketstudios.mapsdemo.domain.models.Dto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class YelpBusinessesDto(
    @Json(name = "businesses") val businesses: List<BusinessDto>,
) : Dto
