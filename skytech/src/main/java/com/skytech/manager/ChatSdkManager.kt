package com.skytech.manager

object ChatSdkManager {
    private var isSdkForeground = false

    internal fun setSdkForeground(isForeground: Boolean) {
        isSdkForeground = isForeground
    }

    fun getSdkForegroundState(): Boolean {
        return isSdkForeground
    }
}
