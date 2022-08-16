package com.bottlerocketstudios.places.mocks

import com.bottlerocketstudios.mapsdemo.domain.models.PlaceSearchEventIdle
import com.bottlerocketstudios.mapsdemo.domain.models.PlacesRequest
import com.bottlerocketstudios.mapsdemo.domain.models.PlacesSearchEvent
import com.bottlerocketstudios.mapsdemo.domain.models.PlacesSearchEventFound
import com.bottlerocketstudios.places.PlacesRepository
import com.google.android.libraries.places.api.model.TypeFilter
import kotlinx.coroutines.flow.MutableStateFlow
import org.mockito.kotlin.mock

object MockPlacesRepo {

    val placesRepository: PlacesRepository = mock {
        on { placeDetails }.then { _placeDetails }
        on { placesEvents }.then { _placesAutocompletePredictionEvents }

        onBlocking { getPlaces(placeRequest) }.then {
            _placesAutocompletePredictionEvents.value = placesSearchEventFound
            Unit
        }
    }

    private val placesSearchEventFound = PlacesSearchEventFound(listOf())
    private val placeRequest = PlacesRequest(testLocationBias, TypeFilter.ADDRESS, "123 Main Street", listOf("US"))
    private val _placesAutocompletePredictionEvents = MutableStateFlow<PlacesSearchEvent>(PlaceSearchEventIdle)
    private val _placeDetails = MutableStateFlow<PlacesSearchEvent>(PlaceSearchEventIdle)
}
