package com.bottlerocketstudios.mapsdemo.data.di

import com.bottlerocketstudios.data.BuildConfig

class BuildConfigProviderImpl: BuildConfigProvider {
    override val isDebugOrInternalBuild: Boolean
        get() = isDebugOrInternalBuild()
    override val isProductionReleaseBuild: Boolean
        get() = isProductionReleaseBuild()
    override val buildIdentifier: String
        get() = BuildConfig
    override val mapsApiKey: String
        get() = Build

private fun isProductionReleaseBuild() = !BuildConfig.DEBUG && BuildConfig.PRODUCTION

private fun isDebugOrInternalBuild() = BuildConfig.DEBUG || BuildConfig.INTERNAL