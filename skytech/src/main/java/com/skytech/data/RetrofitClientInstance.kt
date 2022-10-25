package com.skytech.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://skybot-widget-api.kapitalbank.az/sdk/"

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit? {

        val client = OkHttpClient.Builder()
            .addInterceptor(HttpInterceptor())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        return retrofit
    }
}
