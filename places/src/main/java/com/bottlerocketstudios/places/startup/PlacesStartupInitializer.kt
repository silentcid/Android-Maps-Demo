package com.bottlerocketstudios.places.startup

import android.content.Context
import androidx.startup.Initializer
import com.google.android.libraries.places.api.Places
import org.koin.android.BuildConfig

class PlacesStartupInitializer: Initializer<Unit>{
    override fun create(context: Context) {
        Places.initialize(context, BuildConfig.MAPS_API_KEY)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}