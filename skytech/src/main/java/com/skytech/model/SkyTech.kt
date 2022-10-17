package com.skytech.model

import android.content.Context
import android.content.Intent
import com.skytech.SkyTechActivity
import com.skytech.util.CredentialHelper
import com.skytech.util.Utils
import org.json.JSONObject

data class SkyTech constructor(
    val api_key: String?,
    val app_id: String?,
    val firebaseToken: String?,
    val jsonParams: JSONObject,
    val messageId: Long
) {

    data class Builder(
        var api_key: String? = null,
        var app_id: String? = null,
        var firebaseToken: String? = null,
        var messageId: Long? = null,
        var jsonParams: JSONObject? = null
    ) {

        fun key(api_key: String) = apply { this.api_key = api_key }
        fun appID(app_id: String) = apply { this.app_id = app_id }
        fun firebaseToken(firebaseToken: String) = apply { this.firebaseToken = firebaseToken }
        fun messageId(messageId: Long?) = apply { this.messageId = messageId }
        fun userCredentials(jsonParams: JSONObject) =
            apply { this.jsonParams = jsonParams }

        fun open(context: Context) {
            setCredentials()


            val intent = Intent(context.applicationContext, SkyTechActivity::class.java)
            context.startActivity(intent)
        }

        private fun setCredentials() {
            val hashValue = Utils.hmac(jsonParams.toString(), "$api_key$app_id")
            val hashCredential = HashCredential(hashValue, app_id, firebaseToken, jsonParams, messageId)
            CredentialHelper.credential.value = hashCredential
        }
    }
}
