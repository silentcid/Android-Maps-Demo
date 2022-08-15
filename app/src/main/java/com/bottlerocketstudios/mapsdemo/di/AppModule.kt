package com.bottlerocketstudios.mapsdemo.di

import com.bottlerocketstudios.mapsdemo.buildconfig.BuildConfigProviderImpl
import com.bottlerocketstudios.mapsdemo.data.di.BuildConfigProvider
import org.koin.dsl.module

object AppModule {
    val module = module {
        single { PlacesClientProvider.providePlacesClient(app = get()) }
        single<BuildConfigProvider> { BuildConfigProviderImpl() }
    }
}
