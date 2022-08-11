package com.bottlerocketstudios.mapsdemo.di

import org.koin.dsl.module

object AppModule {
    val module = module {
        single { PlacesClientProvider.providePlacesClient(app = get()) }
    }
}
