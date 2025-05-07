package com.bottlerocketstudios.places

import timber.log.Timber

class SystemOutPrintlnTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        System.out.println(message)
    }
}
