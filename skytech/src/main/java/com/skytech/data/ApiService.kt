package com.skytech.data

import com.skytech.model.AuthResponse
import com.skytech.model.UserCredentials
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth")
    fun auth(@Body auth: UserCredentials): Call<AuthResponse>
}