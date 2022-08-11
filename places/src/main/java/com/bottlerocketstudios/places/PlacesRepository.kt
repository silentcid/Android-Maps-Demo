package com.bottlerocketstudios.places

import com.bottlerocketstudios.mapsdemo.domain.models.Repository
import com.bottlerocketstudios.places.model.PlaceDetailsFound
import com.bottlerocketstudios.places.model.PlaceSearchEventIdle
import com.bottlerocketstudios.places.model.PlacesRequest
import com.bottlerocketstudios.places.model.PlacesSearchEvent
import com.bottlerocketstudios.places.model.PlacesSearchEventError
import com.bottlerocketstudios.places.model.PlacesSearchEventFound
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.PlacesClient
import org.koin.core.component.inject
import com.google.android.libraries.places.ktx.api.net.awaitFetchPlace
import com.google.android.libraries.places.ktx.api.net.awaitFindAutocompletePredictions
import com.google.android.libraries.places.ktx.api.net.fetchPlaceRequest
import com.google.android.libraries.places.ktx.api.net.findAutocompletePredictionsRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent


interface PlacesRepository: Repository {
    val placesEvents: StateFlow<PlacesSearchEvent>
    val placeDetails: StateFlow<PlacesSearchEvent>
    suspend fun getPlaces(placesRequest: PlacesRequest)
    suspend fun onAutoCompletePredictionSelected(prediction: AutocompletePrediction)
}

internal class PlacesRepositoryImp() : PlacesRepository, KoinComponent {
    val placesClient: PlacesClientProvider by inject()

    private val _placesAutocompletePredictionEvents = MutableStateFlow<PlacesSearchEvent>(PlaceSearchEventIdle)
    private val _placeDetails = MutableStateFlow<PlacesSearchEvent>(PlaceSearchEventIdle)

    override val placesEvents: StateFlow<PlacesSearchEvent> = _placesAutocompletePredictionEvents
    override val placeDetails: StateFlow<PlacesSearchEvent> = _placeDetails

    override suspend fun getPlaces(placesRequest: PlacesRequest) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            _placesAutocompletePredictionEvents.value = PlacesSearchEventError(throwable)
        }

        val scope = CoroutineScope(SupervisorJob() + handler)

        scope.launch {
            val request = findAutocompletePredictionsRequest {
                locationBias = placesRequest.bias
                typeFilter = placesRequest.typeFilter
                query = placesRequest.query
                countries = placesRequest.countries
            }

            val response = placesClient.awaitFindAutocompletePredictions(request)
            _placesAutocompletePredictionEvents.value = PlacesSearchEventFound(response.autocompletePredictions)
        }

    }

    override suspend fun onAutoCompletePredictionSelected(prediction: AutocompletePrediction) {

        // For all the different Fields you can use see https://developers.google.com/maps/documentation/places/web-service/place-data-fields
        val placeRequest = fetchPlaceRequest(
            prediction.placeId,
            listOf(
                Place.Field.NAME,
                Place.Field.ADDRESS,
                Place.Field.LAT_LNG,
                Place.Field.BUSINESS_STATUS
            )
        )

        val placeResponse = placesClient.awaitFetchPlace(request = placeRequest)

        _placeDetails.value = PlaceDetailsFound(placeResponse.place)

    }
}