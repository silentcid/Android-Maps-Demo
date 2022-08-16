package com.bottlerocketstudios.data.model.test

import com.bottlerocketstudios.mapsdemo.data.model.PlacesSearchEventError
import com.bottlerocketstudios.mapsdemo.data.model.PlacesSearchEventFound
import com.google.android.libraries.places.api.net.PlacesStatusCodes
import com.google.common.truth.Truth.assertThat

import org.junit.Test

class PlacesSearchEventTest {

    @Test
    fun `test Places SearchEventFound`() {
        val placesEventFound = PlacesSearchEventFound(listOf())
        assertThat(placesEventFound).isInstanceOf(PlacesSearchEventFound::class.java)
    }

    @Test
    fun `Test Places Event Error`() {
        val placesSearchEventError = PlacesSearchEventError(Throwable(message = PlacesStatusCodes.getStatusCodeString(PlacesStatusCodes.NETWORK_ERROR)))
        assertThat(placesSearchEventError).isInstanceOf(PlacesSearchEventError::class.java)
        assertThat(placesSearchEventError.exception.message).isEqualTo(PlacesStatusCodes.getStatusCodeString(PlacesStatusCodes.NETWORK_ERROR))
    }
}
