package com.skytech.data

import com.skytech.model.AuthResponse
import com.skytech.model.UserCredentials
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth")
    fun auth(@Body auth: RequestBody?): Call<AuthResponse>


    @POST("logout")
    suspend fun logout()
}
