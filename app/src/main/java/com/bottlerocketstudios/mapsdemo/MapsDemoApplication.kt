package com.bottlerocketstudios.mapsdemo

import android.app.Application
import timber.log.Timber

class MapsDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.v("[onCreate]") // timber should be initialized by this point
    }
}
