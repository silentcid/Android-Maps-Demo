package com.bottlerocketstudios.mapsdemo.infrastructure.coroutine

import com.bottlerocketstudios.mapsdemo.domain.infrastructure.coroutine.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DispatcherProviderImplementation : DispatcherProvider {
    override val Default: CoroutineDispatcher = Dispatchers.Default
    override val IO: CoroutineDispatcher = Dispatchers.IO
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}
