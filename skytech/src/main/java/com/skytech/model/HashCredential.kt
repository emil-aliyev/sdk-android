package com.skytech.model

import org.json.JSONObject

data class HashCredential(
    val hashValue: String,
    val appId: String? = null,
    val firebaseToken: String? = null,
    val jsonParams: JSONObject? = null,
    val messageId: Long? = null,
)
