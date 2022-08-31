package com.skytech.util

import android.content.Context
import com.skytech.data.ApiService
import com.skytech.data.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

object LogoutSkyTech {
    fun clearFirebaseSkyTechToken(context: Context) {
        val api = RetrofitClientInstance.getRetrofitInstance(context)!!.create(
            ApiService::class.java
        )

        CoroutineScope(IO).launch {
            try {
                api.logout()
            } catch (e: Exception) {

            }
        }
    }
}
