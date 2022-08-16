package com.bottlerocketstudios.mapsdemo.domain.models

import com.google.android.libraries.places.api.model.LocationBias
import com.google.android.libraries.places.api.model.TypeFilter

data class PlacesRequest(
    val bias: LocationBias,
    val typeFilter: TypeFilter,
    val query: String,
    val countries: List<String>
)
