package com.bottlerocketstudios.data.model.test

import com.bottlerocketstudios.mapsdemo.data.model.PlacesRequest
import com.google.android.gms.maps.model.LatLng
import com.google.common.truth.Truth.assertThat
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import org.junit.Test

class PlacesRequestTest {

    @Test
    fun `test places request model`() {
        val locationBias = RectangularBounds.newInstance(
            LatLng(37.7576948, -122.4727051), // SW lat, lng
            LatLng(37.808300, -122.391338) // NE lat, lng
        )

        val placesRequest = PlacesRequest(
         locationBias,
        TypeFilter.ADDRESS,
        "123 Main Street",
        listOf("US"))

        assertThat(placesRequest.bias).isEqualTo(locationBias)
        assertThat(placesRequest.typeFilter).isEqualTo(TypeFilter.ADDRESS)
        assertThat(placesRequest.query).isEqualTo("123 Main Street")
        assertThat(placesRequest.countries.first()).isEqualTo("US")
    }
}
