package com.bottlerocketstudios.places

import com.bottlerocketstudios.places.mocks.testContext
import org.koin.dsl.module

object TestModule {

    fun generateMockedTestModule() = module {
        single { testContext}
    }
}
