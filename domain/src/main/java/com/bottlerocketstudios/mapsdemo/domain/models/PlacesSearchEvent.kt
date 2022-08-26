package com.bottlerocketstudios.mapsdemo.domain.models

sealed class PlacesSearchEvent

object PlacesSearchEventLoading : PlacesSearchEvent()
object PlaceSearchEventIdle : PlacesSearchEvent()
data class PlacesSearchEventError(val exception: Throwable) : PlacesSearchEvent()
/* When we are ready to use the Places API we won't need to use AutoCompletion and Place objects. It will be something else entirely.
data class PlacesSearchEventFound(val autocompletePredictions: List<AutocompletePrediction>) : PlacesSearchEvent()
data class PlaceDetailsFound(val place: Place) : PlacesSearchEvent()
*/
