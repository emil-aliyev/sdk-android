package com.skytech.data

import com.skytech.util.CredentialHelper
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HttpInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        CredentialHelper.credential.value?.let {
            request.addHeader("X-HASH-VALUE", it.hashValue)
            request.addHeader("X-APP-ID", it.appId ?: "")
            request.addHeader("X-DEVICE-OS", "android")
            request.addHeader("X-DEVICE-TOKEN", it.firebaseToken ?: "")
        }


        return chain.proceed(request.build())
    }
}