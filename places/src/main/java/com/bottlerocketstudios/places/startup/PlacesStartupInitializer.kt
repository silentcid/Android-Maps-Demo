package com.bottlerocketstudios.places.startup

import android.content.Context
import androidx.startup.Initializer
import com.bottlerocketstudios.mapsdemo.domain.di.BuildConfigProvider
import com.google.android.libraries.places.api.Places
import org.koin.java.KoinJavaComponent.inject

class PlacesStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        val buildConfigProvider by inject<BuildConfigProvider>(BuildConfigProvider::class.java)
        // Secrets Gradle Plugin is being used in the project. To give Places the API Key, the BuildConfigProvider is being injected here
        // to get the API key variable.
        Places.initialize(context, buildConfigProvider.mapsApiKey)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
