package com.skytech.util

import com.skytech.model.SkyTech

object CredentialHelper {
    val credential = SingleLiveEvent<SkyTech.Builder>()
}