package com.skytech.model

import android.content.Context
import android.content.Intent
import android.util.Log
import com.skytech.SkyTechActivity
import com.skytech.util.CredentialHelper
import com.skytech.util.FIREBASE_TOKEN
import com.skytech.util.Preferences
import org.json.JSONObject

data class SkyTech constructor(
    val api_key: String?,
    val app_id: String?,
    val firebaseToken: String?,
    val jsonParams: JSONObject
) {

    data class Builder(
        var api_key: String? = null,
        var app_id: String? = null,
        var firebaseToken: String? = null,
        var jsonParams: JSONObject? = null
    ) {

        fun key(api_key: String) = apply { this.api_key = api_key }
        fun appID(app_id: String) = apply { this.app_id = app_id }
        fun firebaseToken(firebaseToken: String) = apply { this.firebaseToken = firebaseToken }
        fun userCredentials(jsonParams: JSONObject) =
            apply { this.jsonParams = jsonParams }

        fun open(context: Context) {
            val preferences = Preferences(context)

            firebaseToken?.let {
                preferences.saveToPrefs(FIREBASE_TOKEN, it)
                Log.d("SkyTech", "open: $it")
            }

            val intent = Intent(context.applicationContext, SkyTechActivity::class.java)
            CredentialHelper.credential.value =
                Builder(api_key, app_id, firebaseToken, jsonParams)



            context.startActivity(intent)
        }

    }
}