package com.bottlerocketstudios.mapsdemo.di

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient

object PlacesClientProvider {
    fun providePlacesClient(app: Application): PlacesClient =
        Places.createClient(app.applicationContext)
}
