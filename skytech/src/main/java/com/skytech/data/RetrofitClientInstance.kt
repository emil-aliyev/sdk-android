package com.skytech.data

import android.content.Context
import com.skytech.util.Preferences
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClientInstance {
    private lateinit var preferences: Preferences
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://pre-widget-api.kapitalbank.az/sdk/"


    fun getRetrofitInstance(context: Context): Retrofit? {

        preferences = Preferences(context)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpInterceptor(preferences))
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