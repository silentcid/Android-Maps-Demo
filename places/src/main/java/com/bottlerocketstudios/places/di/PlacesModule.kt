package com.bottlerocketstudios.places.di

import com.google.android.libraries.places.api.Places
import org.koin.dsl.module

object PlacesModule {
    val module = module {
        single { Places.createClient(get()) }
    }
}