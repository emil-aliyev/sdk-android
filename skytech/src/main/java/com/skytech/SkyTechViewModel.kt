package com.skytech

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skytech.data.ApiService
import com.skytech.data.RetrofitClientInstance.getRetrofitInstance
import com.skytech.model.AuthResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
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

    fun getUrl(jsonObject: JSONObject) {

        val api: ApiService = getRetrofitInstance()!!.create(ApiService::class.java)

        val res = jsonObject.toString().toRequestBody("application/json".toMediaType())

        val call: Call<AuthResponse> = api.auth(res)

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