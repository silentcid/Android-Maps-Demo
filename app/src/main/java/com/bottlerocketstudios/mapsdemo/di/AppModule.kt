package com.bottlerocketstudios.mapsdemo.di

import com.bottlerocketstudios.mapsdemo.buildconfig.BuildConfigProviderImpl
import com.bottlerocketstudios.mapsdemo.domain.di.BuildConfigProvider
import org.koin.dsl.module

object AppModule {
    val module = module {
        single<BuildConfigProvider> { BuildConfigProviderImpl() }
    }
}
