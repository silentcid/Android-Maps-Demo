package com.bottlerocketstudios.mapsdemo.startup

import android.content.Context
import androidx.startup.Initializer
import com.bottlerocketstudios.mapsdemo.buildconfig.BuildConfigProviderImpl
import timber.log.Timber

class TimberStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        // Can't use Koin to create this due to necessary logic needed in startKoin for androidLogger. Just create/use an instance here for this special case.
        val buildConfigProvider = BuildConfigProviderImpl()
        if (buildConfigProvider.isDebugOrInternalBuild) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.v("[create]")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
