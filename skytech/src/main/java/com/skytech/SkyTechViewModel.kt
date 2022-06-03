package com.skytech

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skytech.data.ApiService
import com.skytech.data.RetrofitClientInstance.getRetrofitInstance
import com.skytech.model.AuthResponse
import com.skytech.model.UserCredentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkyTechViewModel : ViewModel() {

    val url = MutableLiveData<String>()
    val loadingState = MutableLiveData<Boolean>()
    val sdkErrorState = MutableLiveData<Boolean>()

    init {
        loadingState.value = true
    }

    fun getUrl(context: Context, userCredentials: UserCredentials) {

        val api: ApiService = getRetrofitInstance(context)!!.create(ApiService::class.java)
        val call: Call<AuthResponse> = api.auth(userCredentials)

        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>?, response: Response<AuthResponse>) {
                loadingState.value = false

                val body = response.body()
                val code = response.code()
                if (body != null && code == 200) {
                    url.value = body.url
                }else{
                    sdkErrorState.value = true
                }
            }

            override fun onFailure(call: Call<AuthResponse>?, t: Throwable?) {
                loadingState.value = false
            }
        })
    }

}