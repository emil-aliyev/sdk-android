package com.skytech.util

import com.skytech.model.HashCredential

object CredentialHelper {
    val credential = SingleLiveEvent<HashCredential>()
}

