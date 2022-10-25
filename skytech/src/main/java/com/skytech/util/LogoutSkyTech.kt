package com.skytech.util

import com.skytech.data.ApiService
import com.skytech.data.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

object LogoutSkyTech {
    fun clearFirebaseSkyTechToken() {
        val api = RetrofitClientInstance.getRetrofitInstance()!!.create(
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
