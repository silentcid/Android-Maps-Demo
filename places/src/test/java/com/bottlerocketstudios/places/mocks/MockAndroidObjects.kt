package com.bottlerocketstudios.places.mocks

import android.content.Context
import android.content.res.Resources
import org.mockito.kotlin.any
import org.mockito.kotlin.anyVararg
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

val testResources: Resources = mock {
    // Order is important here, most generic match first. Last match is final value.
    on { getQuantityString(any(), any(), anyVararg()) } doReturn ""
    on { getDrawable(any()) } doReturn null
    on { getDrawable(any(), any()) } doReturn null
    on { getString(any(), anyVararg()) } doReturn ""
}

val testContext: Context = mock {
    // Order is important here, most generic match first. Last match is final value.
    on { getString(any()) } doReturn ""
    on { getDrawable(any()) } doReturn null
    on { getString(any(), anyVararg()) } doReturn ""
    on { resources } doReturn testResources
}
