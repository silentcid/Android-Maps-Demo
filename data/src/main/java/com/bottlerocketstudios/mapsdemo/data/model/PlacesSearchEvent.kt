package com.bottlerocketstudios.mapsdemo.data.model

import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.Place

sealed class PlacesSearchEvent

object PlacesSearchEventLoading : PlacesSearchEvent()
object PlaceSearchEventIdle : PlacesSearchEvent()
data class PlacesSearchEventError(val exception: Throwable) : PlacesSearchEvent()
data class PlacesSearchEventFound(val autocompletePredictions: List<AutocompletePrediction>) : PlacesSearchEvent()
data class PlaceDetailsFound(val place: Place) : PlacesSearchEvent()
