package com.bottlerocketstudios.mapsdemo.buildconfig

import com.bottlerocketstudios.mapsdemo.BuildConfig
import com.bottlerocketstudios.mapsdemo.data.di.BuildConfigProvider

class BuildConfigProviderImpl : BuildConfigProvider {
    override val isDebugOrInternalBuild: Boolean
        get() = isDebugOrInternalBuild()
    override val isProductionReleaseBuild: Boolean
        get() = isProductionReleaseBuild()
    override val buildIdentifier: String
        get() = BuildConfig.BUILD_IDENTIFIER
}

private fun isProductionReleaseBuild() = !BuildConfig.DEBUG && BuildConfig.PRODUCTION

private fun isDebugOrInternalBuild() = BuildConfig.DEBUG || BuildConfig.INTERNAL